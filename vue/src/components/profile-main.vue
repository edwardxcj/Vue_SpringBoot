<template>
  <div class="main">
    <el-tabs v-model="activeName" @tab-click="handleClick">
      <el-tab-pane name="1">
        <span slot="label"><i class="el-icon-s-order"></i>Post</span>
        <profile-post-content :content="this.postContent"/>
        <div class = "post"> <el-button type="success" round @click = "newPost">Make a new post</el-button></div>
      </el-tab-pane>

      <el-tab-pane name="2">
        <span slot="label"><i class="el-icon-s-custom"></i>Following</span>
        <el-table @row-click="handleClick"
                  height="400"
                  :data="following"
                  style="width: 100%">
          <el-table-column width="30"></el-table-column>
          <el-table-column
              prop="Name"
              label="Name"
              >
          </el-table-column>
        </el-table>
      </el-tab-pane>

      <el-tab-pane name="3">   <!--这个是最后的个人信息，包括修改等，和前面的格式不同-->
        <span slot="label"><i class="el-icon-user"></i>personal Information</span>
        <div class="personalInfo">

          <el-form ref="form" :model="form" label-width="110px" @submit.native.prevent>
            <el-form-item label="Id">
              <el-input v-model="Id" disabled="true"></el-input>
            </el-form-item>
            <el-form-item label="old password">
              <el-input v-model="form.password"></el-input>
            </el-form-item>
            <el-form-item label="new password">
              <el-input v-model="form.newPassword"></el-input>
            </el-form-item>
            <el-form-item>
              <el-button type="primary" @click="changePassword" >Change password</el-button>
            </el-form-item>
          </el-form>
        </div>
      </el-tab-pane>
    </el-tabs>
  </div>
</template>

<script>
import ProfilePostContent from "@/components/profile-post-content";

export default {
  name: "profile-main",
  components: {
    ProfilePostContent,
  },
  data() {
    return {
      following:[],//[{Name:'David'},{Name:'aaa'}]
      activeName: '1',
      test: "",
      form: {
        password: '',
        newPassword:'',
      },
      postlist:[],
      postContent:[],
    };
  },
  computed:{
    Id(){
      return this.$store.state.userName
    }
  },
  methods: {
    handleClick(tab, event) {
      console.log(tab.name, event);
    },
    newPost(){
      window.location.href='http://localhost:8080/post-info/publish';
    },
    changePassword() {
      this.axios.post('http://localhost:8080/save/userInfo/userLogin', {
            userName:this.Id,
            phoneNumber:'',
            email:'',
            password:this.form.password
          }
      ).then(res => {
        console.log('login res=>', res);
        if(res.data.data !== null){
          if(this.form.password === this.form.newPassword){
            this.$message({
              message:'The new password cannot be the same as the old password',
              type:'warning'
            })
            return
          }
          this.axios.get('http://localhost:8080/save/userInfo/modifyPassword', {
                params: {
                  userName: this.Id,
                  password: this.form.newPassword
                },
              }
          ).then(res => {
            console.log('change password res=>', res);
            if(res.data.data === true){
              this.$message({
                message:'change success',
                type:'success'
              })
            }
          }).catch((error) => {
            console.log('error=>', error)
          })
        }else {
          this.$message.error({
            message:'password is incorrect'
          })
        }
      })
    },
    getUserInformation() {
      this.axios.get('http://localhost:8080/save/userInfo/queryUserInfo', {
            params: {
              userId: sessionStorage.getItem('userId'),
            },
          }
      ).then(res => {
        console.log('user information res=>', res);
        sessionStorage.setItem('userId',res.data.data.userId)
        this.$bus.$emit('sendScore',res.data.data.currScores)
        sessionStorage.setItem('score',res.data.data.currScores)
        let length = 0
        let postList = res.data.data.postList.slice(1,-1).split(',')
        if(res.data.data.postList !== ""){
          length = postList.length
        }
        this.$bus.$emit('sendPost',length)
        this.postlist = postList
        this.postInformation(postList)
      })
    },
    postInformation(postList){
      let postAllContent = []
      for(let i = 0;i<this.postlist.length;i++){
        this.axios.get('http://localhost:8080/save/post/getPostDetail', {
              params: {
                postId: postList[i].slice(1,-1)
              },
            }
        ).then(res => {
          console.log('post get=>', i,res);
          let postInfo = {
            Id:postList[i].slice(1,-1),
            title:res.data.data.title,
            reply:res.data.data.reply,
            channel:res.data.data.gameType
          }
          postAllContent.push(postInfo)
        })
      }
      console.log('postAllContent = >',postAllContent)
      this.postContent = postAllContent
    },
  },
  mounted() {
    //可能要加一个判断是否现在是在登陆
    this.getUserInformation()
  }
}
</script>

<style scoped>
.main {
  display: inline-block;
  width: 800px;
  height: 760px;
  background-color: #ffffff;
  margin-right: 25px;
  float: left;
}

.personalInfo {
  width: 700px;
  height: 500px;
  margin-left: 30px;
}

.post{
  text-align: center;
  margin-top: 20px;
}

</style>
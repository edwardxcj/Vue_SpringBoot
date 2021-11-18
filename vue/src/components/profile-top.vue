<template>
  <div class = "top">
    <el-row>
      <el-col :span="3"><div class="grid-content bg-purple">
        <img src="@/static/images/profile2.jpg">

      </div></el-col>
      <el-col :span="21"><div class="grid-content bg-purple-light">
          <h3> User Name：{{ userName }} </h3>
        <el-button type="danger" round style="justify-content: end" @click = "logout">Logout</el-button>
          <div class = "otherInformation"> I Love Football! </div>
      </div></el-col>
    </el-row>
  </div>
</template>

<script>
// import axios from "axios";

export default {
  name: "profile-top",
  data(){
    return{
    }
  },
  methods:{
    logout(){
      sessionStorage.clear()
      this.$store.commit('userNameChange','')
      this.$store.commit('login',false)
      this.$store.commit('userID','')
      this.$router.push({
        name: 'login'
      })
    }
  },
  computed:{
    userName(){
      return this.$store.state.userName
    }
  },
  created() {
    this.$store.commit('userNameChange',sessionStorage.getItem('userName'))
  }
}
</script>

<style scoped>
.top{
  height: 120px;
  width: 1250px;
  background-color: #595959;
  text-align: left;
}

img{
  height: 120px;
  display: inline;
  margin: 0 15px;
  border-radius: 60px;
  width: 120px;
}

h3{
  display: inline-block;
  width: 900px;
}
.personInformation{
  display: inline;
  height: inherit;
  width: 1000px;
  background-color: #1645dc;
}



.el-row {
  margin-bottom: 20px;
}
el-row:last-child{
  margin-bottom: 0;
}

.el-col {
  /*border-radius: 4px;*/
}
.bg-purple-dark {
  background: #ffffff;
}
.bg-purple {
  background: #ffffff;
}
.bg-purple-light {
  background: #ffffff;
}
/*设置了圆角*/
.grid-content {
  /*border-radius: 4px;*/
  height: 120px;
}
.row-bg {
  padding: 10px 0;
  background-color: #f9fafc;
}

h3{
  line-height: 65px;
  margin: 0 30px;
}
.otherInformation{
  margin:0 50px;
}

</style>
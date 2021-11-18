<template>
  <div class="aside">
    <div class="asideBox">
      <div class="asideBoxContent" style="border-right: 1px solid #bdbdbd">    <!--可以优化成一个slot-->
        <div>Post</div>
        <div>{{postNumber}}</div>
      </div>
      <div class="asideBoxContent">
        <div>Following</div>
        <div>{{following}}</div>
      </div>
    </div>

    <div class="asideBox">
      <div class="asideBoxContent" style="border-right: 1px solid #bdbdbd">
        <div>Points</div>
        <div>{{score}}</div>
      </div>
      <div class="asideBoxContent">
        <el-popover
            placement="top-start"
            popper-class="my-popover"
            width="200"
            trigger="hover"
            :content="popoverText">
          <el-button type="whiteBackground" class="backPlay" slot="reference">Post Ranking</el-button>
        </el-popover>
<!--        <div>Points Ranking</div>-->
        <div>{{ranking}}</div>
      </div>

    </div>
    <profile-aside-channel/>
  </div>
</template>

<script>
import profileAsideChannel from "@/components/profile-aside-channel"

export default {
  name: "profile-aside",
  data() {
    return {
      score: 0,
      postNumber:0,
      following:0,
      ranking:0,
      scoreNext:0
    }
  },
  computed:{
    popoverText(){
      return "If you get "+ (this.scoreNext-this.score) + " more points, you can surpass the previous one";
    }
  },
  components: {
    profileAsideChannel
  },
  mounted() {
    this.$bus.$on('sendScore',(data)=>{this.score = data})
    this.$bus.$on('sendPost',(data)=>{this.postNumber = data})
    //获取排名列表，计算排名
    this.axios.post('http://localhost:8080/rank/list/getRankList'
    ).then(res => {
      console.log('ranklist=>', res.data);
      for (let i = 0; i < res.data.length;i++){
        //console.log('this is=>', res.data[i].userName)
        if(sessionStorage.getItem('userName') === res.data[i].userName){
          this.scoreNext = res.data[i-1].currScores
         // this.score = res.data[i].currScores
          this.ranking = i+1
          break;
        }
      }
    }).catch(res =>{
      console.log('error =>',res)
    })
  }

}
</script>

<style scoped>
.aside {
  display: inline-block;
  width: 425px;
  height: 760px;
  background-color: #EBEEF5;
  overflow: hidden;
}

.asideBox {
  height: 100px;
  width: 425px;
  background-color: #ffffff;
  margin-bottom: 25px;
}

.asideBoxContent {
  height: 80px;
  width: 211px;
  margin: 10px 0px;
  display: inline-block;
  text-align: center;
  line-height: 40px;
}

.el-button--whiteBackground {
  color: #000000;
  background-color: #ffffff;
  border-color: #ffffff;
}


</style>

<style>
.my-popover{
  font-size: 13.3px;
}

</style>
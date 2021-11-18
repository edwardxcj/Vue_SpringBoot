<template>
  <div>
    <div class="channel">
      <div class="headTitle">
        <div class="headContent">
          Channels
        </div>
      </div>
      <!--      <ul>-->
      <!--        <li :key = "channel" v-for="channel in channels" >{{channel}}</li>-->
      <!--      </ul>-->
      <el-row>
        <el-col :span="8" v-for="(channel,index) in channelImage" :key="channel" style="margin-left: 25px;width:175px;margin-bottom: 10px">
          <el-card :body-style="{ padding: '0px'}" >
            <img :src="channel"
                 class="image">
            <div style="padding: 14px;text-align: center">
              <span @click = "channelsJump(channels[index])">{{ channels[index]}}</span>
              <div class="bottom clearfix">
<!--                <el-button type="text" class="button">取消关注</el-button>-->
              </div>
            </div>
          </el-card>
        </el-col>
      </el-row>
    </div>
    <div class="otherInfo">

    </div>
  </div>
</template>

<script>
export default {
  name: "profile-aside-channel",
  data(){
    return{
      channels: ['MLB', 'NBA','NHL','NCAAF'],
      index:1
    }
  },
  computed:{
    channelImage(){
      let arr = [...this.channels];
      arr.forEach((v,i)=>arr[i] = require("@/static/images/"+v+".jpg"))
      return arr
    }
  },
  methods:{
    channelsJump(index){
      this.$router.push({
            name:'league',
            params:{leagueName: index},
      }
      )
    }
  }
}
</script>

<style scoped>
.channel {
  background-color: #ffffff;
  padding-top: 10px;
}

.headTitle {
  height: 20px;
  margin-bottom: 10px;
  border-left: 3px solid red;
}

.headContent {
  margin-left: 20px;
  border-bottom: 1px solid #bdbdbd;
  font-weight: bold;
}

.otherInfo {
  height: 500px;
  background-color: #ffffff;
}


/*element*/

.bottom {
  margin-top: 13px;
  line-height: 12px;
}

.button {
  padding: 0;
  float: right;
}

.image {
  width: 100%;
  display: block;
}

.clearfix:before,
.clearfix:after {
  display: table;
  content: "";
}

.clearfix:after {
  clear: both
}
</style>

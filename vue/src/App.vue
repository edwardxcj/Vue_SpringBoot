<template>
  <!-- <div id="app">
    <div class="back">
      <div class="line"></div> -->
      <v-app>
      <el-menu
          :default-active="$route.path"
          class="el-menu-demo"
          mode="horizontal"
          background-color="#631712"
          text-color="#fff"
          active-text-color="#ffd04b"
          router
          >
        <el-menu-item index="/home">Home</el-menu-item>
        <el-submenu index="/League">
          <template slot="title">League</template>
          <!-- <el-menu-item index="/league/EPL">EPL</el-menu-item> -->
          <el-menu-item index="/league/MLB">MLB</el-menu-item>
          <el-menu-item index="/league/NBA">NBA</el-menu-item>
          <el-menu-item index="/league/NFL">NFL</el-menu-item>
          <el-menu-item index="/league/NCAAF">NCAAF</el-menu-item>
          <el-menu-item index="/league/NHL">NHL</el-menu-item>
        </el-submenu>
        <el-menu-item index="/posts">Posts</el-menu-item>
        <el-menu-item index="/profile" style="position:absolute;right:0">Personal Center</el-menu-item>
      </el-menu>
      <v-main>
      <router-view :key="$route.path"/>
      </v-main>
      <app-footer></app-footer>
      </v-app>
    <!-- </div>
  </div> -->

</template>

<script>


// import loginAndRegister from "@/components/login-and-register"
// import profile from "@/components/profile";
// import axios from "axios";
import AppFooter from "@/components/appFooter";
// import appBar from "@/components/appBar"
export default {
  name: 'App',
  data() {
    return {
      activeIndex: "home",

    }
  },
  components: {AppFooter,},
  computed: {
    isLogin() {
      return this.$store.state.isLogin
    },
    //设置login后导航栏随之变化
    // activeIndex: {
    //   get: function () {
    //     console.log(this.$route.path)
    //     const path = this.$route.path.split('/')
    //     let index = ''
    //     switch (path[1]) {
    //       case "home":
    //         index = '1'
    //         break;
    //       case "profile":
    //         index = '2'
    //         break;
    //     }
    //     return index
    //   },
    //   set: function () {

    //   }
    // },
  },
  watch: {},
  created() {
    if (sessionStorage.getItem('isLogin') == "true") {
      console.log("mounted is true")
      this.$store.commit('login', true)
    } else {
      this.$store.commit('login', false)
    }
  },
  methods: {
    // showProfile() {
    //   this.$router.push({
    //     name: 'profile'
    //   })
    // },
    // showLogin() {
    //   this.$router.push({
    //     name: 'login'
    //   })
    // handleSelect(key, keyPath) {
    //   console.log(key, keyPath);
    //   switch (key) {
    //     case "home":
    //       this.$router.push({
    //         name: 'home'
    //       })
    //       break;
    //     case "":
    //       this.$router.push({
    //         name: 'league',
    //         params: {league: "EPL"}
    //       })
    //       break;
    //     case "3":
    //       this.$router.push({
    //         name: 'home'
    //       })
    //       break;
    //     case "4":
    //       this.$router.push({
    //         name: 'football'
    //       })
    //       break;
    //     case "5":
    //       this.$router.push({
    //         name: 'basketball'
    //       })
    //       break;

    //   }
    // },
  },
  // created() {
  //   console.log(this.$route)
  // }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
}

.back {
  height: 1000px;
  background-color: #EBEEF5;
  min-width: 1300px;
}

/*main中的导航*/
.el-tabs--top .el-tabs__item.is-top:nth-child(2) {
  padding-left: 20px !important;
}

.el-tabs__item {
  font-size: 16px !important;
}

/*结束*/


.nav {
  height: 50px;
  background-color: #777777;

}

</style>

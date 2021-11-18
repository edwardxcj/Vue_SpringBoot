<template>
  <div id="container">
    <div class="form-box">
      <div class="button-box">

        <div id="btn" :style="{left:left+'px'}"></div>
        <button type="button" class="toggle-button" @click="switchToLogin">Log in</button>
        <button type="button" class="toggle-button" @click="switchToRegister">Register</button>
      </div>
      <!--登陆-->
      <form class="input-group" v-show="isLoginPage" >
        <input type="text" class="input-field" placeholder="User Id" v-model="loginInfo.Id">
        <input :type="loginPasswordType" class="input-field" placeholder="Enter password" v-model="loginInfo.password">
        <el-checkbox v-model="showLoginPassword" style="position: relative;left: -75px;margin-bottom: 10px;margin-top: 10px">Show password</el-checkbox>
        <button  type = "button" class="submit-btn" @click="login">Log in</button>
        <!--注册-->
      </form>
      <form class="input-group" v-show="!isLoginPage">
        <input type="text" class="input-field" placeholder="User Id" v-model="registerInfo.userName">
        <input type="text" class="input-field" placeholder="User email" v-model="registerInfo.email">
        <input type="text" class="input-field" placeholder="phone number"
               v-model="registerInfo.phoneNumber">
        <input :type="registerPasswordType" class="input-field" placeholder="Password"
               v-model="registerInfo.password">
        <input :type="registerPasswordType" class="input-field" placeholder="Confirm Password"
               v-model="registerInfo.confirmPassword">
        <el-checkbox v-model="showRegisterPassword" style="position: relative;left: -75px;margin-bottom: 10px;
        margin-top: 10px" >Show password</el-checkbox>
        <button  type = "button" class="submit-btn" @click="register">Register</button>

      </form>
    </div>
  </div>
</template>

<script>
export default {
  name: "login-and-register",
  data() {
    return {
      registerInfo: {
        userName: '',
        email: '',
        password: '',
        confirmPassword:'',
        phoneNumber: '',
      },
      loginInfo:{
        Id:'',
        password:''
      },
      isLoginPage: true,
      left: 0,
      showLoginPassword: false,
      showRegisterPassword:false,
    }
  },
  computed:{
    loginPasswordType(){
      if(this.showLoginPassword){
        return "text"
      }else {
        return "password"
      }
    },
    registerPasswordType() {
      if(this.showRegisterPassword){
        return "text"
      }else {
        return "password"
      }
    }
  },
  methods: {
    register() {
      //userName
      if (!/^\w{3,12}$/.test(this.registerInfo.userName.trim())) {
        this.$message.error({
          message: 'userName form is incorrect, it needs to be between 3 and 12 in length and must consist of letters, numbers and underscores',
        });
        return;
      }
      //email
      if (!/[a-zA-Z0-9]+@[a-zA-Z0-9]+\.[a-zA-Z0-9]+/.test(this.registerInfo.email.trim())) {
        this.$message.error({
          message: 'Incorrect email format',
        });
        return;
      }
      //phone number
      if (!/^(?:\+?61|0)4 ?(?:(?:[01] ?[0-9]|2 ?[0-57-9]|3 ?[1-9]|4 ?[7-9]|5 ?[018]) ?[0-9]|3 ?0 ?[0-5])(?: ?[0-9]){5}$/.test(
          this.registerInfo.phoneNumber.trim())) {
        this.$message.error({
          message: 'Incorrect mobile phone format',
        });
        return;
      }
      //password
      if (!/^\w{6,12}$/.test(this.registerInfo.password.trim())) {

        this.$message.error({
          message: 'password form is incorrect, it needs to be between 6 and 12 in length and must consist of letters, numbers and underscores',
        });
        return;
      }
      if(this.registerInfo.password !== this.registerInfo.confirmPassword){
        this.$message.error({
          message: 'The password entered twice is not the same',
        });
        return;
      }
      this.axios.post(
          'http://localhost:8080/save/userInfo/saveUserInfo',
          this.registerInfo
      ).then(res => {
        console.log('res=>', res);
        if(res.data.data === false){
          this.$message({
            message: 'This ID has already been registered',
            type:'warning'
          });
        }else{
          this.$message({
            message: 'Register success',
            type:'success'
          });
        }
      })
    },
    login() {
      if (this.loginInfo.Id.trim() === '') {
        this.$message.error({
          message: 'no userID',
        });
        return;
      }
      if(this.loginInfo.password.trim() === ''){
        this.$message.error({
          message: 'no password',
        });
        return;
      }
      if(sessionStorage.getItem('isLogin') === "true"){
        this.$message({
          message: 'you already login!',
          type:"warning"
        });
        return
      }
      this.axios.post('http://localhost:8080/save/userInfo/userLogin', {
        userName:this.loginInfo.Id,
        phoneNumber:'',
        email:'',
        password:this.loginInfo.password
          }
      ).then(res => {
        console.log('res=>', res);
        if(res.data.data !== null){
          this.$store.commit('login', true)
          this.$store.commit('userNameChange',this.loginInfo.Id)
          this.$store.commit('userIdChange',res.data.data)
          //储存到浏览器
          sessionStorage.clear()
          sessionStorage.setItem('userName',this.loginInfo.Id)
          sessionStorage.setItem('isLogin',"true")
          sessionStorage.setItem('userId',res.data.data)
          this.$router.push({
            name: 'profile'
          })
          this.$message({
            message:'login success',
            type:'success',

          })
        }else {
          this.$message.error({
            message: 'user name or password is incorrect',
            type:"warning"
          });
        }
      }).catch((error) => {
        console.log('error=>', error)
      })
      //修改登陆状态
    },
    switchToLogin() {
      //切换登陆和注册界面
      this.isLoginPage = true
      this.left = 0
      //
    },
    switchToRegister() {
      //切换登陆和注册界面
      this.isLoginPage = false
      this.left = 110
    }
  },
  // created() {
  //
  // }
}
</script>

<style scoped>
#container {
  text-align: center;
  color: #2c3e50;
  margin: 0;
  padding: 0;

  height: 1000px;
  width: 100%;
  background-image: linear-gradient(to bottom, rgba(0, 0, 0, 0.4), rgba(0, 0, 0, 0.4)), url(../assets/background.jpg);
  background-position: center;
  background-size: cover;
  position: relative;
}

* {
  margin: 0;
  padding: 0;
}

.hero {

}

.form-box {
  width: 380px;
  height: 480px;
  background: #fff;
  position: absolute;
  top: 200px;
  left: 50%;
  margin: auto auto auto -190px;
  padding: 5px;
}

.button-box {
  width: 220px;
  margin: 15px auto;
  position: relative;
  box-shadow: 0 0 20px 9px #ff61241f;
  border-radius: 30px;
}

.toggle-button {
  padding: 10px 30px;
  cursor: pointer;
  background: transparent;
  border: 0;
  outline: none;
  position: relative;
}

#btn { /*用来填充颜色的*/
  top: 0;
  left: 0px;
  position: absolute;
  width: 110px;
  height: 100%;
  background: linear-gradient(to right, #42b983, #a4eccc);
  border-radius: 30px; /*圆角，和上面保持一致*/
  transition: .5s;
}

.input-group {
  left: 50px;
  top: 100px;
  position: absolute;
  width: 280px;
  transition: .5s;
}

.input-field {
  width: 100%;
  padding: 10px 0;
  margin: 5px 0;
  border-left: 0;
  border-right: 0;
  border-top: 0;
  border-bottom: 1px solid #999;
  outline: none; /*外边框*/
  background: transparent;
}

.submit-btn {
  width: 85%;
  padding: 10px 30px;
  cursor: pointer;
  display: block;
  margin: auto;
  border: 0;
  outline: none;
  border-radius: 30px;
  background-color: #d5d5d5;
}

button{
  font-size: 13.3px;
}

input{
  font-size: 13.3px;
}
</style>
(function(e){function t(t){for(var s,r,i=t[0],l=t[1],c=t[2],d=0,p=[];d<i.length;d++)r=i[d],Object.prototype.hasOwnProperty.call(n,r)&&n[r]&&p.push(n[r][0]),n[r]=0;for(s in l)Object.prototype.hasOwnProperty.call(l,s)&&(e[s]=l[s]);u&&u(t);while(p.length)p.shift()();return a.push.apply(a,c||[]),o()}function o(){for(var e,t=0;t<a.length;t++){for(var o=a[t],s=!0,i=1;i<o.length;i++){var l=o[i];0!==n[l]&&(s=!1)}s&&(a.splice(t--,1),e=r(r.s=o[0]))}return e}var s={},n={app:0},a=[];function r(t){if(s[t])return s[t].exports;var o=s[t]={i:t,l:!1,exports:{}};return e[t].call(o.exports,o,o.exports,r),o.l=!0,o.exports}r.m=e,r.c=s,r.d=function(e,t,o){r.o(e,t)||Object.defineProperty(e,t,{enumerable:!0,get:o})},r.r=function(e){"undefined"!==typeof Symbol&&Symbol.toStringTag&&Object.defineProperty(e,Symbol.toStringTag,{value:"Module"}),Object.defineProperty(e,"__esModule",{value:!0})},r.t=function(e,t){if(1&t&&(e=r(e)),8&t)return e;if(4&t&&"object"===typeof e&&e&&e.__esModule)return e;var o=Object.create(null);if(r.r(o),Object.defineProperty(o,"default",{enumerable:!0,value:e}),2&t&&"string"!=typeof e)for(var s in e)r.d(o,s,function(t){return e[t]}.bind(null,s));return o},r.n=function(e){var t=e&&e.__esModule?function(){return e["default"]}:function(){return e};return r.d(t,"a",t),t},r.o=function(e,t){return Object.prototype.hasOwnProperty.call(e,t)},r.p="";var i=window["webpackJsonp"]=window["webpackJsonp"]||[],l=i.push.bind(i);i.push=t,i=i.slice();for(var c=0;c<i.length;c++)t(i[c]);var u=l;a.push([0,"chunk-vendors"]),o()})({0:function(e,t,o){e.exports=o("56d7")},"034f":function(e,t,o){"use strict";o("85ec")},"038b":function(e,t,o){"use strict";o("14d3")},"08d3":function(e,t,o){},"0bcc":function(e,t,o){},1340:function(e,t,o){e.exports=o.p+"img/pingpang.f3ffb1b7.jpg"},"14d3":function(e,t,o){},"1b1e":function(e,t,o){},3163:function(e,t,o){e.exports=o.p+"img/background.907c88ec.jpg"},"33a1":function(e,t,o){"use strict";o("e2a9")},"4d02":function(e,t,o){},"53de":function(e,t,o){e.exports=o.p+"img/football.2a2286cd.jpg"},"550b":function(e,t,o){"use strict";o("1b1e")},"56d7":function(e,t,o){"use strict";o.r(t);o("e260"),o("e6cf"),o("cca6"),o("a79d");var s=o("2b0e"),n=(o("d3b7"),o("bc3a")),a=o.n(n),r={},i=a.a.create(r);i.interceptors.request.use((function(e){return e}),(function(e){return Promise.reject(e)})),i.interceptors.response.use((function(e){return e}),(function(e){return Promise.reject(e)})),Plugin.install=function(e){e.axios=i,window.axios=i,Object.defineProperties(e.prototype,{axios:{get:function(){return i}},$axios:{get:function(){return i}}})},s["default"].use(Plugin);Plugin;var l=function(){var e=this,t=e.$createElement,o=e._self._c||t;return o("div",{attrs:{id:"app"}},[o("div",{staticClass:"back"},[o("div",{staticClass:"line"}),o("el-menu",{staticClass:"el-menu-demo",attrs:{"default-active":e.activeIndex,mode:"horizontal","background-color":"#545c64","text-color":"#fff","active-text-color":"#ffd04b"},on:{select:e.handleSelect}},[o("el-menu-item",{attrs:{index:"1"}},[e._v("Login")]),o("el-menu-item",{attrs:{index:"3"}},[e._v("Home")]),o("el-menu-item",{attrs:{index:"4"}},[e._v("FOOTBALL")]),o("el-menu-item",{attrs:{index:"5"}},[e._v("BASKETBALL")]),o("el-menu-item",{attrs:{index:"2",disabled:!e.isLogin}},[e._v("Personal Center")])],1),o("router-view"),o("app-footer")],1)])},c=[],u=(o("ac1f"),o("1276"),function(){var e=this,t=e.$createElement,o=e._self._c||t;return o("v-footer",{attrs:{height:"50",app:"",dark:"",padless:""}},[o("v-row",{attrs:{justify:"center","no-gutters":""}},[o("v-col",{staticClass:"dark lighten-2 py-4 text-center white--text",attrs:{cols:"12"}},[e._v(" "+e._s((new Date).getFullYear())+" — "),o("strong",[e._v("Sport live")])])],1)],1)}),d=[],p={data:function(){return{}}},f=p,m=o("2877"),g=o("6544"),h=o.n(g),v=o("62ad"),b=o("553a"),w=o("0fd9"),I=Object(m["a"])(f,u,d,!1,null,"6f02e736",null),x=I.exports;h()(I,{VCol:v["a"],VFooter:b["a"],VRow:w["a"]});var _={name:"App",data:function(){return{}},components:{AppFooter:x},computed:{isLogin:function(){return this.$store.state.isLogin},activeIndex:{get:function(){console.log(this.$route.path);var e=this.$route.path.split("/"),t="";switch(e[1]){case"login":t="1";break;case"profile":t="2";break}return t},set:function(){}}},watch:{},created:function(){"true"==sessionStorage.getItem("isLogin")?(console.log("mounted is true"),this.$store.commit("login",!0)):this.$store.commit("login",!1)},methods:{showProfile:function(){this.$router.push({name:"profile"})},showLogin:function(){this.$router.push({name:"login"})},handleSelect:function(e,t){switch(console.log(e,t),e){case"1":this.$router.push({name:"login"});break;case"2":this.$router.push({name:"profile"});break;case"3":this.$router.push({name:"home"});break;case"4":this.$router.push({name:"football"});break;case"5":this.$router.push({name:"basketball"});break}}}},y=_,C=(o("034f"),Object(m["a"])(y,l,c,!1,null,null,null)),P=C.exports,k=o("5c96"),$=o.n(k),N=(o("0fae"),o("8c4f")),L=function(){var e=this,t=e.$createElement,o=e._self._c||t;return o("div",{attrs:{id:"container"}},[o("div",{staticClass:"form-box"},[o("div",{staticClass:"button-box"},[o("div",{style:{left:e.left+"px"},attrs:{id:"btn"}}),o("button",{staticClass:"toggle-button",attrs:{type:"button"},on:{click:e.switchToLogin}},[e._v("Log in")]),o("button",{staticClass:"toggle-button",attrs:{type:"button"},on:{click:e.switchToRegister}},[e._v("Register")])]),o("form",{directives:[{name:"show",rawName:"v-show",value:e.isLoginPage,expression:"isLoginPage"}],staticClass:"input-group"},[o("input",{directives:[{name:"model",rawName:"v-model",value:e.loginInfo.Id,expression:"loginInfo.Id"}],staticClass:"input-field",attrs:{type:"text",placeholder:"User Id"},domProps:{value:e.loginInfo.Id},on:{input:function(t){t.target.composing||e.$set(e.loginInfo,"Id",t.target.value)}}}),"checkbox"===e.loginPasswordType?o("input",{directives:[{name:"model",rawName:"v-model",value:e.loginInfo.password,expression:"loginInfo.password"}],staticClass:"input-field",attrs:{placeholder:"Enter password",type:"checkbox"},domProps:{checked:Array.isArray(e.loginInfo.password)?e._i(e.loginInfo.password,null)>-1:e.loginInfo.password},on:{change:function(t){var o=e.loginInfo.password,s=t.target,n=!!s.checked;if(Array.isArray(o)){var a=null,r=e._i(o,a);s.checked?r<0&&e.$set(e.loginInfo,"password",o.concat([a])):r>-1&&e.$set(e.loginInfo,"password",o.slice(0,r).concat(o.slice(r+1)))}else e.$set(e.loginInfo,"password",n)}}}):"radio"===e.loginPasswordType?o("input",{directives:[{name:"model",rawName:"v-model",value:e.loginInfo.password,expression:"loginInfo.password"}],staticClass:"input-field",attrs:{placeholder:"Enter password",type:"radio"},domProps:{checked:e._q(e.loginInfo.password,null)},on:{change:function(t){return e.$set(e.loginInfo,"password",null)}}}):o("input",{directives:[{name:"model",rawName:"v-model",value:e.loginInfo.password,expression:"loginInfo.password"}],staticClass:"input-field",attrs:{placeholder:"Enter password",type:e.loginPasswordType},domProps:{value:e.loginInfo.password},on:{input:function(t){t.target.composing||e.$set(e.loginInfo,"password",t.target.value)}}}),o("el-checkbox",{staticStyle:{position:"relative",left:"-75px","margin-bottom":"10px","margin-top":"10px"},model:{value:e.showLoginPassword,callback:function(t){e.showLoginPassword=t},expression:"showLoginPassword"}},[e._v("Show password")]),o("button",{staticClass:"submit-btn",attrs:{type:"button"},on:{click:e.login}},[e._v("Log in")])],1),o("form",{directives:[{name:"show",rawName:"v-show",value:!e.isLoginPage,expression:"!isLoginPage"}],staticClass:"input-group"},[o("input",{directives:[{name:"model",rawName:"v-model",value:e.registerInfo.userName,expression:"registerInfo.userName"}],staticClass:"input-field",attrs:{type:"text",placeholder:"User Id"},domProps:{value:e.registerInfo.userName},on:{input:function(t){t.target.composing||e.$set(e.registerInfo,"userName",t.target.value)}}}),o("input",{directives:[{name:"model",rawName:"v-model",value:e.registerInfo.email,expression:"registerInfo.email"}],staticClass:"input-field",attrs:{type:"text",placeholder:"User email"},domProps:{value:e.registerInfo.email},on:{input:function(t){t.target.composing||e.$set(e.registerInfo,"email",t.target.value)}}}),o("input",{directives:[{name:"model",rawName:"v-model",value:e.registerInfo.phoneNumber,expression:"registerInfo.phoneNumber"}],staticClass:"input-field",attrs:{type:"text",placeholder:"phone number"},domProps:{value:e.registerInfo.phoneNumber},on:{input:function(t){t.target.composing||e.$set(e.registerInfo,"phoneNumber",t.target.value)}}}),"checkbox"===e.registerPasswordType?o("input",{directives:[{name:"model",rawName:"v-model",value:e.registerInfo.password,expression:"registerInfo.password"}],staticClass:"input-field",attrs:{placeholder:"Password",type:"checkbox"},domProps:{checked:Array.isArray(e.registerInfo.password)?e._i(e.registerInfo.password,null)>-1:e.registerInfo.password},on:{change:function(t){var o=e.registerInfo.password,s=t.target,n=!!s.checked;if(Array.isArray(o)){var a=null,r=e._i(o,a);s.checked?r<0&&e.$set(e.registerInfo,"password",o.concat([a])):r>-1&&e.$set(e.registerInfo,"password",o.slice(0,r).concat(o.slice(r+1)))}else e.$set(e.registerInfo,"password",n)}}}):"radio"===e.registerPasswordType?o("input",{directives:[{name:"model",rawName:"v-model",value:e.registerInfo.password,expression:"registerInfo.password"}],staticClass:"input-field",attrs:{placeholder:"Password",type:"radio"},domProps:{checked:e._q(e.registerInfo.password,null)},on:{change:function(t){return e.$set(e.registerInfo,"password",null)}}}):o("input",{directives:[{name:"model",rawName:"v-model",value:e.registerInfo.password,expression:"registerInfo.password"}],staticClass:"input-field",attrs:{placeholder:"Password",type:e.registerPasswordType},domProps:{value:e.registerInfo.password},on:{input:function(t){t.target.composing||e.$set(e.registerInfo,"password",t.target.value)}}}),o("el-checkbox",{staticStyle:{position:"relative",left:"-75px","margin-bottom":"10px","margin-top":"10px"},model:{value:e.showRegisterPassword,callback:function(t){e.showRegisterPassword=t},expression:"showRegisterPassword"}},[e._v("Show password")]),o("button",{staticClass:"submit-btn",attrs:{type:"button"},on:{click:e.register}},[e._v("Register")])],1)])])},j=[],S=(o("498a"),{name:"login-and-register",data:function(){return{registerInfo:{userName:"",email:"",password:"",phoneNumber:""},loginInfo:{Id:"",password:""},isLoginPage:!0,left:0,showLoginPassword:!1,showRegisterPassword:!1}},computed:{loginPasswordType:function(){return this.showLoginPassword?"text":"password"},registerPasswordType:function(){return this.showRegisterPassword?"text":"password"}},methods:{register:function(){/^\w{3,12}$/.test(this.registerInfo.userName.trim())?/[a-zA-Z0-9]+@[a-zA-Z0-9]+\.[a-zA-Z0-9]+/.test(this.registerInfo.email.trim())?/^(?:\+?61|0)4 ?(?:(?:[01] ?[0-9]|2 ?[0-57-9]|3 ?[1-9]|4 ?[7-9]|5 ?[018]) ?[0-9]|3 ?0 ?[0-5])(?: ?[0-9]){5}$/.test(this.registerInfo.phoneNumber.trim())?/^\w{6,12}$/.test(this.registerInfo.password.trim())?this.axios.post("http://localhost:8080/save/userInfo/saveUserInfo",this.registerInfo).then((function(e){console.log("res=>",e),!1===e.data.data?alert("This ID has already been registered"):alert("Register success")})):alert("password form is incorrect, it needs to be between 6 and 12 in length and must consist of letters, numbers and underscores"):alert("Incorrect mobile phone format"):alert("Incorrect email format"):alert("userName form is incorrect, it needs to be between 3 and 12 in length and must consist of letters, numbers and underscores")},login:function(){var e=this;""!==this.loginInfo.Id.trim()?"true"!==sessionStorage.getItem("isLogin")?this.axios.post("http://localhost:8080/save/userInfo/userLogin",{userName:this.loginInfo.Id,phoneNumber:"",email:"",password:this.loginInfo.password}).then((function(t){console.log("res=>",t),!0===t.data.data?(e.$store.commit("login",!0),e.$store.commit("userNameChange",e.loginInfo.Id),sessionStorage.clear(),sessionStorage.setItem("userName",e.loginInfo.Id),sessionStorage.setItem("isLogin","true"),e.$router.push({name:"profile"})):alert("user name or password is incorrect")})).catch((function(e){console.log("error=>",e)})):alert("you already login!"):alert("no userID")},switchToLogin:function(){this.isLoginPage=!0,this.left=0},switchToRegister:function(){this.isLoginPage=!1,this.left=110}}}),O=S,T=(o("33a1"),Object(m["a"])(O,L,j,!1,null,"4e4cecdc",null)),A=T.exports,E=function(){var e=this,t=e.$createElement,o=e._self._c||t;return o("div",{staticClass:"container"},[o("profile-top"),o("ProfileBottom")],1)},R=[],V=function(){var e=this,t=e.$createElement,s=e._self._c||t;return s("div",{staticClass:"top"},[s("el-row",[s("el-col",{attrs:{span:3}},[s("div",{staticClass:"grid-content bg-purple"},[s("img",{attrs:{src:o("b238")}})])]),s("el-col",{attrs:{span:21}},[s("div",{staticClass:"grid-content bg-purple-light"},[s("h3",[e._v(" User Name："+e._s(e.userName)+" ")]),s("el-button",{staticStyle:{"justify-content":"end"},attrs:{type:"danger",round:""},on:{click:e.logout}},[e._v("Logout")]),s("div",{staticClass:"otherInformation"},[e._v(" I Love Football! ")])],1)])],1)],1)},B=[],F={name:"profile-top",data:function(){return{}},methods:{logout:function(){sessionStorage.clear(),this.$store.commit("userNameChange",""),this.$store.commit("login",!1),this.$store.commit("userID",""),this.$router.push({name:"login"})}},computed:{userName:function(){return this.$store.state.userName}},created:function(){this.$store.commit("userNameChange",sessionStorage.getItem("userName"))}},U=F,D=(o("f7b1"),Object(m["a"])(U,V,B,!1,null,"5f15222f",null)),M=D.exports,z=function(){var e=this,t=e.$createElement,o=e._self._c||t;return o("div",{staticClass:"bottom"},[o("profile-main"),o("profile-aside")],1)},q=[],G=function(){var e=this,t=e.$createElement,o=e._self._c||t;return o("div",{staticClass:"main"},[o("el-tabs",{on:{"tab-click":e.handleClick},model:{value:e.activeName,callback:function(t){e.activeName=t},expression:"activeName"}},[o("el-tab-pane",{attrs:{name:"1"}},[o("span",{attrs:{slot:"label"},slot:"label"},[o("i",{staticClass:"el-icon-s-order"}),e._v("Post")]),o("profile-post-content",{attrs:{content:this.postContent}}),o("div",{staticClass:"post"},[o("el-button",{attrs:{type:"success",round:""},on:{click:e.newPost}},[e._v("Make a new post")])],1)],1),o("el-tab-pane",{attrs:{name:"2"}},[o("span",{attrs:{slot:"label"},slot:"label"},[o("i",{staticClass:"el-icon-s-custom"}),e._v("Following")]),o("el-table",{staticStyle:{width:"100%"},attrs:{height:"400",data:e.following},on:{"row-click":e.handleClick}},[o("el-table-column",{attrs:{width:"30"}}),o("el-table-column",{attrs:{prop:"Name",label:"Name"}})],1)],1),o("el-tab-pane",{attrs:{name:"3"}},[o("span",{attrs:{slot:"label"},slot:"label"},[o("i",{staticClass:"el-icon-user"}),e._v("personal Information")]),o("div",{staticClass:"personalInfo"},[o("el-form",{ref:"form",attrs:{model:e.form,"label-width":"110px"},nativeOn:{submit:function(e){e.preventDefault()}}},[o("el-form-item",{attrs:{label:"Id"}},[o("el-input",{attrs:{disabled:"true"},model:{value:e.Id,callback:function(t){e.Id=t},expression:"Id"}})],1),o("el-form-item",{attrs:{label:"old password"}},[o("el-input",{model:{value:e.form.password,callback:function(t){e.$set(e.form,"password",t)},expression:"form.password"}})],1),o("el-form-item",{attrs:{label:"new password"}},[o("el-input",{model:{value:e.form.newPassword,callback:function(t){e.$set(e.form,"newPassword",t)},expression:"form.newPassword"}})],1),o("el-form-item",[o("el-button",{attrs:{type:"primary"},on:{click:e.changePassword}},[e._v("Change password")])],1)],1)],1)])],1)],1)},Z=[],H=(o("b0c0"),o("fb6a"),function(){var e=this,t=e.$createElement,o=e._self._c||t;return o("div",[o("el-table",{staticStyle:{width:"100%"},attrs:{height:"400",data:e.content},on:{"row-click":e.handleClick}},[o("el-table-column",{attrs:{width:"30"}}),o("el-table-column",{attrs:{prop:"title",label:"title",width:"450"}}),o("el-table-column",{attrs:{prop:"reply",label:"reply",width:"180"}}),o("el-table-column",{attrs:{prop:"channel",label:"channel"}})],1)],1)}),J=[],Y={name:"profile-post-content",methods:{handleClick:function(e,t,o){console.log(e),console.log(t),console.log(o)}},props:["content"]},K=Y,W=Object(m["a"])(K,H,J,!1,null,"4e2974f4",null),X=W.exports,Q={name:"profile-main",components:{ProfilePostContent:X},data:function(){return{following:[],activeName:"1",test:"",form:{password:"",newPassword:""},postlist:[],postContent:[]}},computed:{Id:function(){return this.$store.state.userName}},methods:{handleClick:function(e,t){console.log(e.name,t)},newPost:function(){window.location.href="http://localhost:8080/game-session/test3shuyuan"},changePassword:function(){var e=this;this.axios.post("http://localhost:8080/save/userInfo/userLogin",{userName:this.Id,phoneNumber:"",email:"",password:this.form.password}).then((function(t){if(console.log("login res=>",t),!0===t.data.data){if(e.form.password===e.form.newPassword)return void alert("The new password cannot be the same as the old password");e.axios.get("http://localhost:8080/save/userInfo/modifyPassword",{params:{userName:e.Id,password:e.form.newPassword}}).then((function(e){console.log("change password res=>",e),!0===e.data.data&&alert("change success")})).catch((function(e){console.log("error=>",e)}))}else alert("user name or password is incorrect")}))},getUserInformation:function(){var e=this;this.axios.get("http://localhost:8080/save/userInfo/queryUserInfo",{params:{userName:this.Id}}).then((function(t){console.log("user information res=>",t),sessionStorage.setItem("userId",t.data.data.userId),e.$bus.$emit("sendScore",t.data.data.currScores);var o=t.data.data.postList.slice(1,-1).split(",");e.$bus.$emit("sendPost",o.length),e.postlist=o,e.postInformation(o)}))},postInformation:function(e){for(var t=this,o=[],s=function(s){t.axios.get("http://localhost:8080/save/post/getPostDetail",{params:{postId:e[s].slice(1,-1)}}).then((function(e){console.log("post get=>",s,e);var t={title:e.data.data.title,reply:e.data.data.reply,channel:e.data.data.gameType};o.push(t)}))},n=0;n<this.postlist.length;n++)s(n);console.log("postAllContent = >",o),this.postContent=o}},mounted:function(){this.getUserInformation(),this.axios.post("http://localhost:8080/rank/list/getRankList").then((function(e){console.log("ranklist=>",e)})).catch((function(e){console.log("error =>",e)}))}},ee=Q,te=(o("ed46"),Object(m["a"])(ee,G,Z,!1,null,"421076c9",null)),oe=te.exports,se=function(){var e=this,t=e.$createElement,o=e._self._c||t;return o("div",{staticClass:"aside"},[o("div",{staticClass:"asideBox"},[o("div",{staticClass:"asideBoxContent",staticStyle:{"border-right":"1px solid #bdbdbd"}},[o("div",[e._v("Post")]),o("div",[e._v(e._s(e.postNumber))])]),o("div",{staticClass:"asideBoxContent"},[o("div",[e._v("Following")]),o("div",[e._v(e._s(e.following))])])]),o("div",{staticClass:"asideBox"},[o("div",{staticClass:"asideBoxContent",staticStyle:{"border-right":"1px solid #bdbdbd"}},[o("div",[e._v("Points")]),o("div",[e._v(e._s(e.score))])]),o("div",{staticClass:"asideBoxContent"},[o("div",[e._v("Points Ranking")]),o("div",[e._v(e._s(e.ranking))])])]),o("profile-aside-channel")],1)},ne=[],ae=function(){var e=this,t=e.$createElement,o=e._self._c||t;return o("div",[o("div",{staticClass:"channel"},[e._m(0),o("el-row",e._l(e.channelImage,(function(t,s){return o("el-col",{key:t,staticStyle:{"margin-left":"25px",width:"175px","margin-bottom":"10px"},attrs:{span:8}},[o("el-card",{attrs:{"body-style":{padding:"0px"}}},[o("img",{staticClass:"image",attrs:{src:t}}),o("div",{staticStyle:{padding:"14px","text-align":"center"}},[o("span",[e._v(e._s(e.channels[s]))]),o("div",{staticClass:"bottom clearfix"})])])],1)})),1)],1),o("div",{staticClass:"otherInfo"})])},re=[function(){var e=this,t=e.$createElement,o=e._self._c||t;return o("div",{staticClass:"headTitle"},[o("div",{staticClass:"headContent"},[e._v(" Channels ")])])}],ie=o("2909"),le=(o("159b"),{name:"profile-aside-channel",data:function(){return{channels:["football","basketball","pingpang"],index:1}},computed:{channelImage:function(){var e=Object(ie["a"])(this.channels);return e.forEach((function(t,s){return e[s]=o("862c")("./"+t+".jpg")})),e}}}),ce=le,ue=(o("9936"),Object(m["a"])(ce,ae,re,!1,null,"7b9fac1a",null)),de=ue.exports,pe={name:"profile-aside",data:function(){return{score:0,postNumber:0,following:2,ranking:3}},components:{profileAsideChannel:de},mounted:function(){var e=this;this.$bus.$on("sendScore",(function(t){e.score=t})),this.$bus.$on("sendPost",(function(t){e.postNumber=t}))}},fe=pe,me=(o("038b"),Object(m["a"])(fe,se,ne,!1,null,"d817cb40",null)),ge=me.exports,he={name:"profile-bottom",components:{ProfileMain:oe,ProfileAside:ge}},ve=he,be=(o("550b"),Object(m["a"])(ve,z,q,!1,null,"4fb43426",null)),we=be.exports,Ie={name:"profile",components:{profileTop:M,ProfileBottom:we}},xe=Ie,_e=(o("f184"),Object(m["a"])(xe,E,R,!1,null,"2ae829ce",null)),ye=_e.exports,Ce=function(){var e=this,t=e.$createElement,o=e._self._c||t;return o("v-container",{attrs:{fluid:""}},[o("v-row",[o("v-col",{attrs:{cols:8}},[o("v-row",{attrs:{justify:"center"}},[o("v-col",{attrs:{cols:10}},[o("carousel")],1)],1),e._l(e.postList,(function(t){return o("v-row",{key:t.id},[o("v-col",[o("v-card",{attrs:{outlined:""}},[o("v-card-title",[e._v(e._s(t.title))]),o("v-card-subtitle",[e._v(e._s(t.content))])],1)],1)],1)}))],2),o("v-col",e._l(e.gameList,(function(t){return o("v-row",{key:t.id,attrs:{justify:"end"}},[o("v-col",{attrs:{cols:12}},[o("v-card",{attrs:{outlined:"",color:"grey"}},[o("v-row",{attrs:{align:"center",justify:"center"}},[o("v-card-title",[e._v(e._s(t.home)+" vs "+e._s(t.away))]),o("v-card-text",[o("p",{staticClass:"text-h4 text--primary",staticStyle:{"text-align":"center"}},[e._v(" "+e._s(t.gameResult)+" ")])])],1)],1)],1)],1)})),1)],1)],1)},Pe=[],ke=function(){var e=this,t=e.$createElement,o=e._self._c||t;return o("v-carousel",{attrs:{cycle:"",height:"400","hide-delimiter-background":"","show-arrows-on-hover":""}},e._l(e.items,(function(e,t){return o("v-carousel-item",{key:t,attrs:{src:e.src,"reverse-transition":"fade-transition",transition:"fade-transition"}})})),1)},$e=[],Ne={name:"carousel",data:function(){return{items:[{src:"https://upload.wikimedia.org/wikipedia/commons/thumb/b/b9/Football_iu_1996.jpg/1200px-Football_iu_1996.jpg"},{src:"https://c.files.bbci.co.uk/4646/production/_118109971_livreal.jpg"},{src:"https://cdn.vox-cdn.com/thumbor/945eiLpmbwdPoO3_eanzLWHYXuw=/0x0:2796x1926/1200x800/filters:focal(1163x362:1609x808)/cdn.vox-cdn.com/uploads/chorus_image/image/69947237/usa_today_16881222.0.jpg"},{src:"https://i.cbc.ca/1.5645636.1594411598!/fileImage/httpImage/elam-ending-071020.jpg"}]}}},Le=Ne,je=o("5e66"),Se=o("3e35"),Oe=Object(m["a"])(Le,ke,$e,!1,null,null,null),Te=Oe.exports;h()(Oe,{VCarousel:je["a"],VCarouselItem:Se["a"]});var Ae={name:"home",components:{carousel:Te},data:function(){return{category:this.$route.params.category,gameList:[],postList:[]}},methods:{getGameList:function(){var e=this;this.axios.post("http://localhost:8080/game/gameSession/getGameList",{}).then((function(t){t.data.success?(console.log("gamelist=>",t.data.data),e.gameList=t.data.data):e.$message.error("getGame fail")})).catch((function(e){console.log("error=>",e)}))},getPostList:function(){var e=this;this.axios.post("http://localhost:8080/save/post/getPostList",{}).then((function(t){t.data.success?(console.log("postlist=>",t.data.data),e.postList=t.data.data):e.$message.error("getPost fail")})).catch((function(e){console.log("error=>",e)}))}},created:function(){this.getGameList(),this.getPostList()}},Ee=Ae,Re=o("b0af"),Ve=o("99d9"),Be=o("a523"),Fe=Object(m["a"])(Ee,Ce,Pe,!1,null,null,null),Ue=Fe.exports;h()(Fe,{VCard:Re["a"],VCardSubtitle:Ve["a"],VCardText:Ve["b"],VCardTitle:Ve["c"],VCol:v["a"],VContainer:Be["a"],VRow:w["a"]});var De=new N["a"]({routes:[{path:"/profile",component:ye,name:"profile",meta:{isAuth:!0}},{path:"/login",component:A,name:"login"},{path:"/home",component:Ue,name:"home"},{path:"/home/football",component:Ue,name:"football"},{path:"/home/basketball",component:Ue,name:"basketball"},{path:"/",redirect:"login"}]});De.beforeEach((function(e,t,o){e.meta.isAuth?sessionStorage.getItem("isLogin")?o():(alert("can not access personal center, please login first"),De.push({name:"login"})):o()}));var Me=De,ze=o("2f62");s["default"].use(ze["a"]);var qe={},Ge={login:function(e,t){e.isLogin=t},userNameChange:function(e,t){e.userName=t}},Ze={isLogin:!1,userName:""},He=new ze["a"].Store({actions:qe,mutations:Ge,state:Ze}),Je=o("f309");s["default"].use(Je["a"]);var Ye=new Je["a"]({});s["default"].config.productionTip=!1,s["default"].use($.a),s["default"].use(N["a"]),new s["default"]({render:function(e){return e(P)},router:Me,store:He,vuetify:Ye,beforeCreate:function(){s["default"].prototype.$bus=this}}).$mount("#app")},"85ec":function(e,t,o){},"862c":function(e,t,o){var s={"./background.jpg":"3163","./basketball.jpg":"8f84","./basketball2.jpg":"fe67","./football.jpg":"53de","./pingpang.jpg":"1340","./profile.jpg":"b238"};function n(e){var t=a(e);return o(t)}function a(e){if(!o.o(s,e)){var t=new Error("Cannot find module '"+e+"'");throw t.code="MODULE_NOT_FOUND",t}return s[e]}n.keys=function(){return Object.keys(s)},n.resolve=a,e.exports=n,n.id="862c"},"8f84":function(e,t,o){e.exports=o.p+"img/basketball.e950c73f.jpg"},9936:function(e,t,o){"use strict";o("08d3")},b238:function(e,t,o){e.exports=o.p+"img/profile.9d3f2a32.jpg"},e033:function(e,t,o){},e2a9:function(e,t,o){},ed46:function(e,t,o){"use strict";o("e033")},f184:function(e,t,o){"use strict";o("4d02")},f7b1:function(e,t,o){"use strict";o("0bcc")},fe67:function(e,t,o){e.exports=o.p+"img/basketball2.6ced0c51.jpg"}});
//# sourceMappingURL=app.6d9ef27e.js.map
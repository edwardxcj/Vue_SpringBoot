import Vue from 'vue'
import './plugins/axios'
import App from './App.vue'
import ElementUI from 'element-ui';
import locale from 'element-ui/lib/locale/lang/en';
import 'element-ui/lib/theme-chalk/index.css';
import VueRouter from "vue-router";
import router from "./router"
import store from './store/index'
import vuetify from './plugins/vuetify'
Vue.config.productionTip = false
Vue.use(ElementUI, { locale });
Vue.use(VueRouter);

new Vue({
  render: h => h(App),
  router,
  store,
  vuetify,

  beforeCreate(){
    Vue.prototype.$bus = this     //安装全局事件总线
  }
}).$mount('#app')

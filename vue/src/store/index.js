import Vuex from 'vuex'
import Vue from 'vue'
Vue.use(Vuex)      //把这一行写在index里，就不用在main.js里写了

const actions = {

}
const mutations = {
    login(state,value){
        state.isLogin = value
    },
    userNameChange(state,value){
        state.userName = value
    },
    userIdChange(state,value){
        state.userId = value
    }
}
const state = {
    isLogin: false,
    userName:'',
    userId:''
}
export default new Vuex.Store({
    actions,
    mutations,
    state
})

//导出store
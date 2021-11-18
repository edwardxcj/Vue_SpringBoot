import VueRouter from "vue-router";
import loginAndRegister from "../components/login-and-register";
import profile from "../components/profile";
import home from "../views/home";
import league from "../views/league";
import postListPage from '../views/postListPage';

const router = new VueRouter({
    routes:[
        {
            path:"/profile",
            component:profile,
            name:"profile",
            meta:{isAuth:true}
        },
        {
            path:"/login",
            component:loginAndRegister,
            name:"login"
        },
        {
            path:"/home",
            component:home,
            name:"home"
        },
        {
            path:"/league/:leagueName",
            component:league,
            name:"league",
        },
        {
            path:'/',    //set default view of router
            redirect:'home'
        },
        {
            path:"/posts",
            component: postListPage,
            name:"postListPage"
        }
    ]
})
//Global Before Guards
router.beforeEach((to, from, next)=>{
    if(to.meta.isAuth){
        if(sessionStorage.getItem('isLogin') === "true"){
            next()
        }else{
            alert('can not access personal center, please login first')
            router.push({name:'login'})
        }
    }else {
        next()
    }
})

export default router
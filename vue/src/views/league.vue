<template>
    <div>
        <gameList :leagueName="leagueName" />
    </div>
</template>

<script>
import gameList from "../components/gameList.vue"
export default{
    components:{
        gameList
    },
    data(){
        return{
            leagueName:this.$route.params.leagueName
        }
    }
}

</script>

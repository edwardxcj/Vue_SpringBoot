<template>
 <div>
    <postList :topPost="false"/>
 </div>
</template>

<script>
import postList from '../components/postList.vue'
export default {
    name:'postListPage',
    components:{
        postList
    }
}
</script>
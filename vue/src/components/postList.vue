<template>
<!-- display post list in two situation, "topPost equal to false" means "non-topPost", it is in postPage, when "topPost is true, it is in home page" -->
    <v-container fluid>
        <div v-if="topPost == false">
            <span class="text-h3 text-center text--primary font-weight-bold text-decoration-underline d-flex justify-center" >Posts</span>
            <v-card v-for="post in postList" :key="post.id" hover style="margin-top:10px" outlined @click="toPostPage(post.postId)">
                <v-card-title>
                    <span class="text-h5 text--primary font-weight-black text-uppercase">{{post.title}}</span>
                </v-card-title>
                <v-card-subtitle >
                    <v-row>
                        <v-col :cols="1">
                            <span class="text-h6 font-weight-medium d-inline-block text-truncate" style="width: 150px;"><v-icon>mdi-account-circle-outline</v-icon>  {{post.userName}}</span>
                        </v-col>
                        <v-col :cols="9">
                            <span class="text-h6 font-weight-medium black--text d-inline-block text-truncate" style="font-style: italic">&emsp; &emsp; {{post.content}}</span>
                        </v-col>
                        <v-col :cols="2">
                            <span class="text-h6 font-weight-medium d-inline-block text-truncate" style="max-width: 130px; float:right" > {{post.gmtModified}}</span>
                        </v-col>
                    </v-row>
                </v-card-subtitle>
            </v-card>
        </div>
        <div v-else-if="topPost == true">
            <span class="text-h3 text-center text--primary font-weight-bold text-decoration-underline d-flex justify-center" >Top Posts</span>
            <v-card v-for="post in postList.slice(0,3)" :key="post.id"  hover style="margin-top:10px" outlined @click="toPostPage(post.postId)">
                <v-card-title>
                    <span class="text-h5 text--primary font-weight-black text-uppercase">{{post.title}}</span>
                </v-card-title>
                <v-card-subtitle >
                    <v-row>
                        <v-col :cols="1">
                            <span class="text-h6 font-weight-medium d-inline-block text-truncate" style="width: 150px;"><v-icon>mdi-account-circle-outline</v-icon>  {{post.userName}}</span>
                        </v-col>
                        <v-col :cols="9">
                            <span class="text-h6 font-weight-medium black--text d-inline-block text-truncate" style="font-style: italic">&emsp; &emsp; {{post.content}}</span>
                        </v-col>
                        <v-col :cols="2">
                            <span class="text-h6 font-weight-medium d-inline-block text-truncate" style="max-width: 130px; float:right" > {{post.gmtModified}}</span>
                        </v-col>
                    </v-row>
                </v-card-subtitle>
            </v-card>            
        </div>
    </v-container>
</template>
<script>
export default {
    name:'postList',
    props:['topPost'],
    data(){
        return{
            postList:[]
        }
    },
    methods:{
        // get the posts from backend via Axios
        getPostList(){
            this.axios
            .post("http://localhost:8080/save/post/getPostList", {})
            .then((res) => {
            //success
            if (res.data.success) {
                console.log("postlist=>", res.data.data);
                this.postList = res.data.data
                this.postList.forEach(e =>e.gmtModified =  e.gmtModified.substring(0,10))
            }else{
                //fail
                this.$message.error("getPost fail")
            }
            })
            .catch((error) => {
            console.log("error=>", error);
            });      
        },
        // redirect to post detail page when clicking on the post card
        toPostPage(id){
            window.location.href='http://localhost:8080/post-info/post?postId='+id 
        },        
    },
    created(){
        // run getPostList method when this component init
        this.getPostList();
    }
}
</script>
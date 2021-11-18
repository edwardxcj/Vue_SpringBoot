<template>
  <div class="bottom">
    <profile-main/>
    <profile-aside/>

  </div>
</template>



<script>
import ProfileMain from "@/components/profile-main"
import ProfileAside from "@/components/profile-aside"
export default {
  name: "profile-bottom",
  components:{
    ProfileMain,
    ProfileAside
  }
}
</script>

<style scoped>
.bottom {
  height: 764px;
  width: 2000px;
  margin-top: 20px;
  background-color: #EBEEF5;
  text-align: left;
}



</style>
<template>
  <div class="container">
    <profile-top/>
    <ProfileBottom/>

  </div>
</template>

<script>
import profileTop from "@/components/profile-top";
import ProfileBottom from "@/components/profile-bottom"
export default {
  name: "profile",
  components:{
    profileTop,
    ProfileBottom,
  }
}
</script>

<style scoped>
.container {
  position: relative;
  width: 1255px;
  /*position: absolute;*/
  left: 50%;
  margin-left: -625px;
}

</style>
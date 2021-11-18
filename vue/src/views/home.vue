<template>
<!-- home page view components, import carousel/postlist/gamelist and display it at different col-->
  <v-container fluid>
    <v-row>
      <v-col :cols="8">
        <carousel/>
        <postList :topPost='true'/>
      </v-col>
      <v-col :cols="4" >
        <gameList/>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import carousel from "../components/carousel.vue";
import gameList from '../components/gameList.vue';
import postList from '../components/postList.vue';
export default {
  name: "home",
  components: {
    carousel,
    gameList,
    postList,
  },
  data() {
    return {

    };
  },
  methods: {

  },
};
</script>

<style scoped>

</style>
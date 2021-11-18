<template>
<!-- a footer at highest layer of the App  -->
  <v-footer height="50"
  app
    dark
    padless
  >
    <v-row
      justify="center"
      no-gutters
      
    >
      <v-col
        class="dark lighten-2 py-4 text-center white--text"
        cols="12"
      >
        {{ new Date().getFullYear() }} — <strong>Sport live</strong>
      </v-col>
    </v-row>
  </v-footer>
</template>

<script>
  export default {
    data: () => ({

    }),
  }
</script>

<style scoped>

</style>
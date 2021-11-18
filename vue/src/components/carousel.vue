<template>
  <v-container fluid>
    <v-carousel
      cycle
      height="400"
      hide-delimiter-background
      show-arrows-on-hover
    >
      <v-carousel-item
        v-for="(item,i) in items"
        :key="i"
        :src="item.src"
        reverse-transition="fade-transition"
        transition="fade-transition"
      ></v-carousel-item>
    </v-carousel>
  </v-container>
</template>

<script>
  export default {
    name: 'carousel',
    data () {
      return {
        items: [
          {
            src: 'https://upload.wikimedia.org/wikipedia/commons/thumb/b/b9/Football_iu_1996.jpg/1200px-Football_iu_1996.jpg',
          },
          {
            src: 'https://c.files.bbci.co.uk/4646/production/_118109971_livreal.jpg',
          },
          {
            src: 'https://cdn.vox-cdn.com/thumbor/945eiLpmbwdPoO3_eanzLWHYXuw=/0x0:2796x1926/1200x800/filters:focal(1163x362:1609x808)/cdn.vox-cdn.com/uploads/chorus_image/image/69947237/usa_today_16881222.0.jpg',
          },
          {
            src: 'https://i.cbc.ca/1.5645636.1594411598!/fileImage/httpImage/elam-ending-071020.jpg',
          },
        ],
      }
    },
  }
</script>
<template>
<!-- display game list in two situation, "leagueName equal to null" means no selected league, it is in homePage, when "leagueName is not null, it is in specific page showing the selected league only " -->
    <v-container fluid >
        <span class="text-h3 text-center text--primary font-weight-bold text-decoration-underline d-flex justify-center" >{{leagueName}} Games</span>
        <div align="center">
            <!-- <v-menu
            ref="menu1"
            v-model="menu1"
            :close-on-content-click="false"
            transition="scale-transition"
            offset-y
            >
                <template v-slot:activator="{ on, attrs }">
                    <v-text-field
                    v-model="dateFormatted"
                    label="Date"
                    persistent-hint
                    prepend-icon="mdi-calendar"
                    v-bind="attrs"
                    @blur="date = parseDate(dateFormatted)"
                    v-on="on"
                    ></v-text-field>
                </template>
                    <v-date-picker
                    v-model="date"
                    :allowed-dates="allowedDates"
                    class="mt-4"
                    width="inhert"
                    ></v-date-picker>
            </v-menu> -->
            <div v-if="leagueName == null">
                <div 
                v-for="item in gameList.slice(2,6)"
                :key="item.id">
                    <v-col 
                    :cols="10"       
                    >
                        <v-card 
                        style="margin-top:5px" 
                        hover 
                        @click="toGamePage(item.gameId)" 
                        >
                            <v-row>
                                <v-col>
                                <span class="text-h5 text--primary font-weight-black">Home</span>
                                </v-col>
                                <v-col>
                                <span class="text-h5 text--primary font-weight-black">Away</span>
                                </v-col>
                            </v-row>
                            <v-row>
                                <v-col>
                                <span class="text-h6 text--primary" style="font-style: italic">{{item.home}}</span>
                                </v-col>
                                <v-col>
                                <span class="text-h6 text--primary" style="font-style: italic">{{item.away}}</span>
                                </v-col>
                            </v-row>
                            <v-row>
                                <v-col>
                                <span class="text-h4 text--primary text-center">
                                    {{item.gameResult}}
                                </span>
                                </v-col>
                            </v-row>
                        </v-card>
                    </v-col>
                </div>
            </div>
            <div 
            v-else
            v-for="item in gameList"
            :key="item.id">
                <div v-if='item.league != null & item.league == leagueName'>
                    <v-col 
                    :cols="10"       
                    >
                        <v-card 
                        style="margin-top:5px" 
                        hover 
                        @click="toGamePage(item.gameId)" 
                        >
                            <v-row>
                                <v-col>
                                <span class="text-h5 text--primary font-weight-black">Home</span>
                                </v-col>
                                <v-col>
                                <span class="text-h5 text--primary font-weight-black">Away</span>
                                </v-col>
                            </v-row>
                            <v-row>
                                <v-col>
                                <span class="text-h6 text--primary" style="font-style: italic">{{item.home}}</span>
                                </v-col>
                                <v-col>
                                <span class="text-h6 text--primary" style="font-style: italic">{{item.away}}</span>
                                </v-col>
                            </v-row>
                            <v-row>
                                <v-col>
                                <span class="text-h4 text--primary text-center">
                                    {{item.gameResult}}
                                </span>
                                </v-col>
                            </v-row>
                        </v-card>
                    </v-col>
                </div>
            </div>
        </div>
    </v-container>
</template>

<script>
export default {
    name:"gameList",
    props:['leagueName'],
    // data: vm => ({
    //     // date: (new Date(Date.now() - (new Date()).getTimezoneOffset() * 60000)).toISOString().substr(0, 10),
    //     // dateFormatted: vm.formatDate((new Date(Date.now() - (new Date()).getTimezoneOffset() * 60000)).toISOString().substr(0, 10)),
    //     // menu1: false,
    //     gameList:[],
    //     allowedDateList:[],
    // }),
    data(){
        return{
            gameList:[],
            allowedDateList:[]
        }
    },
    methods:{
        // get the games from backend via Axios
        getGameList(){
            this.axios
            .post("http://localhost:8080/game/gameSession/getGameList", {})
            .then((res) => {
            //success
            if (res.data.success) {
                console.log("gamelist=>", res.data.data);
                this.gameList = res.data.data
                this.gameList.forEach(e =>e.gameTime =  e.gameTime.substring(0,10), );
                this.gameList.forEach(e => this.allowedDateList.push(e.gameTime));
                console.log(this.allowedDateList)
            }else{
                //fail
                this.$message.error("getGame fail")
            }
            })
            .catch((error) => {
            console.log("error=>", error);
            });
        },
        // redirect to game detail page when clicking on the game card
        toGamePage(id){
            window.location.href='http://localhost:8080/game-session/gameDetail?gameId=' + id
        },
    },
    //     formatDate (date) {
    //         if (!date) return null
    //         const [year, month, day] = date.split('-')
    //         return `${month}/${day}/${year}`
    //     },
    //     parseDate (date) {
    //         if (!date) return null
    //         const [month, day, year] = date.split('/')
    //         return `${year}-${month.padStart(2, '0')}-${day.padStart(2, '0')}`
    //     },
    //     allowedDates(val) {
    //         if(this.leagueName == null){
    //             for (var i = 0; i < this.allowedDateList.length; i++) {
    //                 if (this.allowedDateList[i] == val){
    //                     return val
    //                 } 
    //             }
    //         }
    //         else if(this.leagueName != null){
    //             for (var a = 0; a < this.gameList.length; a++) {
    //                 for(var b=0; b<this.gameList[a].length; b++)
    //                   console.log (this.gameList[a].gameTime + "b")
    //                 } 
    //         }
    //     }
    // },
    // computed: {
    //     computedDateFormatted () {
    //         return this.formatDate(this.date)
    //     },
    //     // newdataList: function() {
    //     //     return this.sortKey(this.dataList, "addtime");
    //     // }
    // },
    // watch: {
    //   date () {
    //     this.dateFormatted = this.formatDate(this.date)
    //   },
    // },
    created(){
        // run getGameList method when this component init
        this.getGameList();
    }
}
</script>
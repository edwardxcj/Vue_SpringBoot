<template>
  <div>
    <el-table @cell-click="handleClick"
              height="400"
        :data="content.filter(content => !search || content.title.toLowerCase().includes(search.toLowerCase()))"
              :default-sort = "{prop: 'title', order: 'descending'}"

        style="width: 100%">
      <el-table-column width="30"></el-table-column>
      <el-table-column
          prop="title"
          label="title"
          sortable
          width="450">
      </el-table-column>

      <el-table-column
          sortable
          :filters = "[{text:'FOOTBALL',value:'FOOTBALL'},{text: 'BASKETBALL',value: 'BASKETBALL'}]"
          :filter-method = "filterHandler"
          prop="channel"
          label="channel">
      </el-table-column>
      <el-table-column
          align="right">
        <template slot="header" slot-scope="{}">
          <el-input
              v-model="search"
              size="mini"
              placeholder="search"/>
        </template>
      </el-table-column>
    </el-table>




  </div>
</template>

<script>
export default {
  name: "profile-post-content",
  methods:{
    handleClick(row, column, event,cell){
      console.log("row = ",row)
      console.log("col = ",column)
      console.log("event = ",event)
      console.log("cell = ",cell)
      console.log(this.content)
      window.location.href='http://localhost:8080/post-info/post?postId='+row.Id
    },
    filterHandler(value, row, column) {
      const property = column['property'];
      return row[property] === value;
    }
  },
  props:['content'],
  data(){
    return{
      search:''
    }

  }
}
</script>

<style scoped>

</style>
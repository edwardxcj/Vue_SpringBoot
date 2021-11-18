module.exports = {
    devServer:{
        port:8080,
        host:'0.0.0.0',
        // proxy:{
        //     '/api':{
        //         target:'http://localhost:8080/',
        //         changeOrigin:true,
        //         pathRewrite:{
        //             '^/api':''
        //         }
        //     }
        // }
    },

    publicPath:'./',

    transpileDependencies: [
      'vuetify'
    ]
}

var webpack = require("webpack")
var webpackHotMiddleware = require("webpack-hot-middleware")
var webpackDevMiddleware = require("webpack-dev-middleware")
var config = require("./webpack.config")

var app = new (require("express"))()
var port = 8701

var compiler = webpack(config)

app.use(webpackDevMiddleware(compiler,{noInfo:true,publicPath:config.output.publicPath}))
app.use(webpackHotMiddleware(compiler))

app.get("/",function(req,res){
    res.sendFile(__dirname + "/index.html")
})

app.listen(port,function(error){
    if(error){
        console.log(error)
    }else{
        console.log("app listen at "+port+" ......")
    }
})
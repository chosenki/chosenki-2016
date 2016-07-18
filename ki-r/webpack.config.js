var path = require("path")
var webpack = require("webpack")
var log4js = require("log4js")

module.exports = {
    devtool: "cheap-module-eval-source-map",
    entry: [
        "webpack-hot-middleware/client",
        "./index"
    ],
    output: {
        path: path.join(__dirname,"dist"),
        filename: "entry.js",
        publicPath: "/static/"
    },
    plugins: [
        new webpack.optimize.OccurenceOrderPlugin(),
        new webpack.HotModuleReplacementPlugin()
    ],
    module: {
        loaders: [
            {
                test: /\.js$/,
                loaders: [ 'babel' ],
                exclude: /node_modules/,
                include: __dirname
            }
        ]
    }
}



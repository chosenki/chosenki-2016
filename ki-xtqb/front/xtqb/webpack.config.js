var webpack = require('webpack');
var CopyWebpackPlugin = require('copy-webpack-plugin');
var CleanWebpackPlugin = require('clean-webpack-plugin');
var path = require('path');
var rootPath = __dirname;


module.exports = {
    entry: ['./index.js'],
    context: rootPath,
    devtool:'source-map',
    devServer: {
        outputPath: path.join(__dirname,"build")
    },
    output: {
        path: path.join( __dirname,'build'),
        publicPath: '/build/',
        filename: 'lib.bundle.js'
    },
    plugins: [
        //删除build目录
        //new CleanWebpackPlugin(['build/*']),
        new CopyWebpackPlugin([
            //{ from: './aaa/ss.xx', to: 'ccc/ss.txt' ,force:true},
            { from: './node_modules/.1.5.8@angular/angular.js',to:"angular.js"}
        ],{

        })
    ]
}

console.log("console");

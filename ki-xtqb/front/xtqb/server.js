/**
 * Created by Wangxiang on 2016/8/25.
 */
var webpack = require('webpack');
var webpackDevMiddleware = require('webpack-dev-middleware');
var webpackHotMiddleware = require('webpack-hot-middleware');
var config = require('./webpack.config');

var app = new (require('express'))()
var port = 3000


var compiler = webpack(config)

app.use(webpackHotMiddleware(compiler))

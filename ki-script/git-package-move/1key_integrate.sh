#!/bin/sh

#1、新建git目录，不存在时新建
mkdir /build/
cd /build/
mkdir /git/
mkdir /build/
#2、git clone/stash/pull
if true; then
git clone *.git
elif true; then
git stash
git pull origin master
fi
#3、打包脚本
package.sh
#4、copy最新的包到我们默认的仓库
cp -r a.tar.gz /build/gitName/dataing/
rm -f /build/gitName/newest/*
cp -r a.tar.gz /build/gitName/newest/
#5、输出最新的包描述，通知相应干系人,提供可给scp的地址
scp -r /build/gitName/newest/* user@url:/path/



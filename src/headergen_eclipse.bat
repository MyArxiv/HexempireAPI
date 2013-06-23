@echo off
cd ..
cd ..
cd ..
cd hexempire
cd hexempireapi
cd bin

echo 正在生成头文件...

%JAVA_HOME%\bin\javah net.donizyo.hexempire.Configuration
%JAVA_HOME%\bin\javah net.donizyo.hexempire.Communication

echo 头文件已成功生成.
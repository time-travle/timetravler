#maven学习 
##软件安装
##环境搭建
##工程建立
##工程编译
##工程运行
##bug处理
##jar包查查
maven repo   https://mvnrepository.com/
##单独添加本地jar到maven库中
    
    demo： ojdbc6-11.2.0.3.jar
    打开终端（windows用户打开cmd），输入：
    mvn install:install-file -Dfile=D:\Program Files\myjar\ojdbc6-11.2.0.3.jar -DgroupId=oracle -DartifactId=ojdbc6 -Dversion=11.2.0.3 -Dpackaging=jar -DgeneratePom=true
    pom引用
    <!-- https://mvnrepository.com/artifact/oracle/ojdbc6 -->
    <dependency>
        <groupId>oracle</groupId>
        <artifactId>ojdbc6</artifactId>
        <version>11.2.0.3</version>
    </dependency>


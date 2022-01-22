#Springboot学习 
##软件安装
##环境搭建
##工程建立
##工程编译
##工程运行
##bug处理


##springboot启动机制（starter机制）

##lombook的使用
 https://blog.csdn.net/Y_hahaha/article/details/89186284
##统一升级版本号
参考Wiki：https://www.cnblogs.com/lukelook/p/11298168.html
### 1引用插件
        <plugin>
            <groupId>org.codehaus.mojo</groupId>
            <artifactId>versions-maven-plugin</artifactId>
            <version>2.3</version>
            <configuration>
                <generateBackupPoms>false</generateBackupPoms>
            </configuration>
        </plugin>
方法1
    
    只需要执行mvn -N versions:update-child-modules
    则会自动把子POM的<parent>标签中的version更新为和父POM一致。
    这样修改一处然后运行一下执行一下命令就可以达到统一修改版本号的目的了。
     （在父model上执行后，所有子model中parent中的version都会修改）
 方法2
    
    仅修改子工程版本和父级pom一致
    执行mvn versions:update-child-modules: 
    自动把子POM的<parent>标签中的version更新为和父POM一致
 方法3
 
     mvn versions:set -DnewVersion=0.0.2-SNAPSHOT:更新的父及子Module的版本号都改成了0.0.2-SNAPSHOT.
     包括父和子工程
 ### 2不引用插件
 相比引入了插件
 mvn versions:commit ：如果没有在父pom用引入插件，
 Maven还会生成一个pom.xml.versionsBackup的备份文件，还需要mvn versions:commit提交
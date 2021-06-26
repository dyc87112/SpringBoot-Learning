# 测试Ehcache集群的步骤参考

## 1.题外话

学习完chapter5-3后，博主给出的验证逻辑如下：
1. 启动通过第三步说的命令参数，启动两个实例
2. 调用实例1的/create接口，创建一条数据 
3. 调用实例1的/find接口，实例1缓存User，同时同步缓存信息给实例2，在实例1中会存在SQL查询语句 
4. 调用实例2的/find接口，由于缓存集群同步了User的信息，所以在实例2中的这次查询也会出现SQL语句

逻辑简明清楚，但我对java命令行不很熟悉，摸索一番后总结以下步骤来进行验证，也许对有的小伙伴有帮助。

## 2.验证步骤

1. 进入项目目录打开git bash / power shell / cmd窗口，输入 `mvn clean package`命令，在target目录下会看到PROJECTNAME-0.0.1-SNAPSHAT.jar，PROJECTNAME是你自己的项目名称；
2. 输入`cd ./target`进入target目录；
3. 执行`java -jar PROJECTNAME-0.0.1-SNAPSHOT.jar -Dspring.cache.ehcache.config=classpath:ehcache-1.xml`；
4. 打开新git bash / power shell / cmd窗口，执行`java -jar PROJECTNAME-0.0.1-SNAPSHOT.jar -Dspring.cache.ehcache.config=classpath:ehcache-2.xml --server.port=9999`，在第三步中启动的应用占据了默认端口号8080，因此这里修改端口号为9999；
5. 在浏览器输入`http://localhost:8080/create`，再输入`http://localhost:8080/find`，即可查看到插入的信息；
6. 打开新标签页，输入`http://localhost:9999/find`，同样会看到信息，至此EhCache缓存集群验证完毕。


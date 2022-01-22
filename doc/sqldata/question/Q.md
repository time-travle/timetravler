##Q1:[HY000][1418] This function has none of DETERMINISTIC, NO SQL, or READS SQL DATA in its declaration and binary logging is enabled (you *might* want to use the less safe log_bin_trust_function_creators variable)
解决方法：set global log_bin_trust_function_creators=TRUE;



##IDEA 连接不上 MySQL的JDBC驱动（8.0版本）
使用的驱动包 添加参数

    1.引用外部库  mysql-connector-java-8.0.版本的jar
    2.jdbc驱动类：com.mysql.jdbc.Driver  改成 com.mysql.cj.jdbc.Driver
    3.jdbcUrl：jdbc:mysql://{ip}:{port}/{db}?
    characterEncoding=utf8
    useSSL=false
    serverTimezone=UTC
    rewriteBatchedStatements=true
    autoReconnect=true
    useUnicode=true
    allowPublicKeyRetrieval=true

    
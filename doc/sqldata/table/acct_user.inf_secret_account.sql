DROP TABLE IF EXISTS acct_user.inf_secret_account;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
SET character_set_client = utf8mb4 ;
CREATE TABLE acct_user.inf_secret_account
(
    `id`                INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
    `acct_id`           VARCHAR(45)  NOT NULL,
    `acct_name`         VARCHAR(45) DEFAULT NULL,
    `login_name`        VARCHAR(45) DEFAULT NULL,
    `login_pwd`         VARCHAR(45)  NOT NULL,
    `login_link`        VARCHAR(256) NOT NULL,
    `subs_id`           VARCHAR(45) DEFAULT NULL COMMENT '归属的用户',
    `cust_id`           VARCHAR(45) DEFAULT NULL COMMENT '归属的客户',
    `registered_time`   DATETIME    DEFAULT CURRENT_TIMESTAMP,
    `registered_idtype` VARCHAR(45) DEFAULT NULL,
    `registered_idnum`  VARCHAR(45) DEFAULT NULL,
    `registered_email`  VARCHAR(45) DEFAULT NULL,
    `registered_way`    VARCHAR(45) DEFAULT NULL,
    `acct_type`         VARCHAR(45) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8;


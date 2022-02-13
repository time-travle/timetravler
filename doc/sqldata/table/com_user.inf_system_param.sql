--
-- Table structure for table `inf_system_param`
--

DROP TABLE IF EXISTS com_user.inf_system_param;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
SET
character_set_client = utf8mb4 ;
CREATE TABLE com_user.inf_system_param
(
    `id`          INT(11) NOT NULL AUTO_INCREMENT,
    `param_id`    VARCHAR(25) NOT NULL COMMENT '系统参数的唯一识别码',
    `param_name`  VARCHAR(45) NOT NULL COMMENT '系统参数的名字',
    `param_value` VARCHAR(35) DEFAULT NULL COMMENT '系统参数的值',
    `param_desc`  VARCHAR(45) DEFAULT NULL COMMENT '系统参数的作用的描述',
    `eff_date`    DATETIME    DEFAULT CURRENT_TIMESTAMP COMMENT '当前系统参数生效时间',
    `exp_date`    DATETIME    DEFAULT '2222-12-31 12:59:59' COMMENT '当前系统参数失效时间',
    `ext_1`       VARCHAR(45) DEFAULT NULL,
    `ext_2`       VARCHAR(45) DEFAULT NULL,
    `ext_3`       VARCHAR(45) DEFAULT NULL,
    `ext_4`       VARCHAR(45) DEFAULT NULL,
    `ext_5`       VARCHAR(45) DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `param_id_UNIQUE` (`param_id`)
) ENGINE=INNODB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `inf_system_param_lang`
--

DROP TABLE IF EXISTS com_user.inf_system_param_lang;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
SET
character_set_client = utf8mb4 ;
CREATE TABLE com_user.inf_system_param_lang
(
    `id`           INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
    `rel_param_id` VARCHAR(25) NOT NULL COMMENT '系统参数的唯一识别码',
    `locate`       VARCHAR(45) NOT NULL COMMENT '语言类型',
    `name`         VARCHAR(35) DEFAULT NULL COMMENT '这个系统参数的名字的国际化',
    `desc`         VARCHAR(45) DEFAULT NULL COMMENT '系统参数的作用的描述国际化',
    PRIMARY KEY (`id`),
    UNIQUE KEY `U_param_local` (`rel_param_id`,`locate`),
    CONSTRAINT `fk_001` FOREIGN KEY (`rel_param_id`) REFERENCES `inf_system_param` (`param_id`)
) ENGINE=INNODB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

use system_user ;

DROP TABLE IF EXISTS `sys_auth`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
SET
character_set_client = utf8mb4 ;
CREATE TABLE `sys_auth`
(
    `id`        INT(8) NOT NULL AUTO_INCREMENT,
    `auth_id`   VARCHAR(45) NOT NULL COMMENT '权限的id 系统中时唯一的',
    `auth_name` VARCHAR(45) NOT NULL COMMENT '权限的名字',
    `eff_time`  DATETIME             DEFAULT CURRENT_TIMESTAMP,
    `exp_time`  DATETIME    NOT NULL DEFAULT '2222-12-31 12:59:59',
    `desc`      VARCHAR(100)         DEFAULT NULL,
    `filed1`    VARCHAR(45)          DEFAULT NULL,
    `filed2`    VARCHAR(45)          DEFAULT NULL,
    `filed3`    VARCHAR(45)          DEFAULT NULL,
    `filed4`    VARCHAR(45)          DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `auth_id_UNIQUE` (`auth_id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='定一个权限表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sys_auth_lang`
--

DROP TABLE IF EXISTS `sys_auth_lang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
SET
character_set_client = utf8mb4 ;
CREATE TABLE `sys_auth_lang`
(
    `id`        INT(10) NOT NULL AUTO_INCREMENT,
    `auth_id`   VARCHAR(45) NOT NULL,
    `anth_name` VARCHAR(45) DEFAULT NULL,
    `location`  VARCHAR(45) NOT NULL,
    `desc`      VARCHAR(45) DEFAULT NULL,
    `filed1`    VARCHAR(45) DEFAULT NULL,
    `filed2`    VARCHAR(45) DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `authid_location_NU` (`auth_id`,`location`) /*!80000 INVISIBLE */,
    KEY         `sys_auth_lang_authid_FK_idx` (`auth_id`) /*!80000 INVISIBLE */,
    CONSTRAINT `sys_auth_lang_authid_FK` FOREIGN KEY (`auth_id`) REFERENCES `sys_auth` (`auth_id`) ON UPDATE RESTRICT
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='权限的多语言表 对应inf_auth表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sys_role`
--

DROP TABLE IF EXISTS `sys_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
SET
character_set_client = utf8mb4 ;
CREATE TABLE `sys_role`
(
    `id`        INT(10) NOT NULL AUTO_INCREMENT,
    `role_id`   VARCHAR(45) NOT NULL COMMENT '角色Id 唯一',
    `role_name` VARCHAR(45) NOT NULL,
    `desc`      VARCHAR(50) DEFAULT NULL,
    `ext_1`     VARCHAR(45) DEFAULT NULL,
    `ext_2`     VARCHAR(45) DEFAULT NULL,
    `ext_3`     VARCHAR(45) DEFAULT NULL,
    `ext_4`     VARCHAR(45) DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `id_UNIQUE` (`id`),
    UNIQUE KEY `role_id_UNIQUE` (`role_id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='定一个角色';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sys_role_auth`
--

DROP TABLE IF EXISTS `sys_role_auth`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
SET
character_set_client = utf8mb4 ;
CREATE TABLE `sys_role_auth`
(
    `id`       INT(10) NOT NULL AUTO_INCREMENT,
    `role_id`  VARCHAR(45) NOT NULL,
    `auth_id`  VARCHAR(45) NOT NULL,
    `eff_time` DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `exp_time` DATETIME             DEFAULT '2222-12-31 12:59:59',
    `ext_1`    VARCHAR(45)          DEFAULT NULL,
    `ext_2`    VARCHAR(45)          DEFAULT NULL,
    `ext_3`    VARCHAR(45)          DEFAULT NULL,
    `ext_4`    VARCHAR(45)          DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `roleid_authid_UN` (`role_id`,`auth_id`) /*!80000 INVISIBLE */,
    KEY        `sysroleauth_authid_FK_idx` (`auth_id`),
    CONSTRAINT `rolauth_authid_fk` FOREIGN KEY (`auth_id`) REFERENCES `sys_auth` (`auth_id`) ON UPDATE RESTRICT,
    CONSTRAINT `roleauht_roleid_fk` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`role_id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='角色拥有的权限';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sys_role_empowerment`
--

DROP TABLE IF EXISTS `sys_role_empowerment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
SET
character_set_client = utf8mb4 ;
CREATE TABLE `sys_role_empowerment`
(
    `id`       INT(10) NOT NULL AUTO_INCREMENT,
    `role_id`  VARCHAR(45) NOT NULL,
    `auth_id`  VARCHAR(45) NOT NULL,
    `eff_time` DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `exp_time` DATETIME             DEFAULT '2222-12-31 12:59:59',
    `ext_1`    VARCHAR(45)          DEFAULT NULL,
    `ext_2`    VARCHAR(45)          DEFAULT NULL,
    `ext_3`    VARCHAR(45)          DEFAULT NULL,
    `ext_4`    VARCHAR(45)          DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `empower_roleid_authid_UN` (`role_id`,`auth_id`),
    KEY        `empower_authid_FK_idx` (`auth_id`),
    CONSTRAINT `empower_authid_FK` FOREIGN KEY (`auth_id`) REFERENCES `sys_auth` (`auth_id`),
    CONSTRAINT `empower_roleid_FK` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`role_id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='赋权权限';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sys_role_lang`
--

DROP TABLE IF EXISTS `sys_role_lang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
SET
character_set_client = utf8mb4 ;
CREATE TABLE `sys_role_lang`
(
    `id`        INT(11) NOT NULL AUTO_INCREMENT,
    `role_id`   VARCHAR(45) NOT NULL,
    `role_name` VARCHAR(45) DEFAULT NULL,
    `location`  VARCHAR(10) NOT NULL,
    `ext_1`     VARCHAR(45) DEFAULT NULL,
    `ext_2`     VARCHAR(45) DEFAULT NULL,
    `ext_3`     VARCHAR(45) DEFAULT NULL,
    `ext_4`     VARCHAR(45) DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `roleid_location_UN` (`role_id`,`location`) /*!80000 INVISIBLE */,
    CONSTRAINT `roleid_FK` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`role_id`) ON UPDATE RESTRICT
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='角色多语言';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sys_role_reverse`
--

DROP TABLE IF EXISTS `sys_role_reverse`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
SET
character_set_client = utf8mb4 ;
CREATE TABLE `sys_role_reverse`
(
    `id`       INT(10) NOT NULL AUTO_INCREMENT,
    `role_id`  VARCHAR(45) NOT NULL,
    `auth_id`  VARCHAR(45) NOT NULL,
    `eff_time` DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `exp_time` DATETIME             DEFAULT '2222-12-31 12:59:59',
    `ext_1`    VARCHAR(45)          DEFAULT NULL,
    `ext_2`    VARCHAR(45)          DEFAULT NULL,
    `ext_3`    VARCHAR(45)          DEFAULT NULL,
    `ext_4`    VARCHAR(45)          DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `reveres_roleid_authid_UN` (`role_id`,`auth_id`) /*!80000 INVISIBLE */,
    KEY        `reveres_authid_FK_idx` (`auth_id`),
    CONSTRAINT `reveres_authid_FK` FOREIGN KEY (`auth_id`) REFERENCES `sys_auth` (`auth_id`),
    CONSTRAINT `reveres_roleid_FK` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`role_id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='反向权限';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sys_user`
--

DROP TABLE IF EXISTS `sys_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
SET
character_set_client = utf8mb4 ;
CREATE TABLE `sys_user`
(
    `user_id`        INT(10) NOT NULL AUTO_INCREMENT,
    `user_name`      VARCHAR(45)         DEFAULT NULL,
    `user_type`      VARCHAR(4) NOT NULL DEFAULT '1',
    `group`          VARCHAR(10)         DEFAULT 'personal',
    `create_oper_id` INT(10) NOT NULL,
    `create_time`    DATETIME   NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `modify_time`    DATETIME            DEFAULT NULL,
    `eff_time`       DATETIME   NOT NULL DEFAULT '2222-12-31 12:59:59',
    `exp_time`       VARCHAR(45)         DEFAULT NULL,
    `filed1`         VARCHAR(45)         DEFAULT NULL,
    `filed2`         VARCHAR(45)         DEFAULT NULL,
    `filed3`         VARCHAR(45)         DEFAULT NULL,
    `filed4`         VARCHAR(45)         DEFAULT NULL,
    PRIMARY KEY (`user_id`),
    UNIQUE KEY `user_id_UNIQUE` (`user_id`),
    KEY              `create_oper_id_FK_idx` (`create_oper_id`),
    CONSTRAINT `create_oper_id_FK` FOREIGN KEY (`create_oper_id`) REFERENCES `sys_user` (`user_id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='user 表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sys_user_auth`
--

DROP TABLE IF EXISTS `sys_user_auth`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
SET
character_set_client = utf8mb4 ;
CREATE TABLE `sys_user_auth`
(
    `id`       INT(10) NOT NULL AUTO_INCREMENT,
    `user_id`  INT(10) NOT NULL,
    `auth_id`  VARCHAR(45) COLLATE utf8_bin NOT NULL,
    `eff_time` DATETIME                     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `exp_time` DATETIME                              DEFAULT '2222-12-31 12:59:59',
    `ext_1`    VARCHAR(45) COLLATE utf8_bin          DEFAULT NULL,
    `ext_2`    VARCHAR(45) COLLATE utf8_bin          DEFAULT NULL,
    `ext_3`    VARCHAR(45) COLLATE utf8_bin          DEFAULT NULL,
    `ext_4`    VARCHAR(45) COLLATE utf8_bin          DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `sysuser_authid_userid_UN` (`user_id`,`auth_id`),
    CONSTRAINT `sysuserauth_userid_FK` FOREIGN KEY (`user_id`) REFERENCES `sys_user` (`user_id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户的权限';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sys_user_empowerment`
--

DROP TABLE IF EXISTS `sys_user_empowerment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
SET
character_set_client = utf8mb4 ;
CREATE TABLE `sys_user_empowerment`
(
    `id`       INT(10) NOT NULL AUTO_INCREMENT,
    `user_id`  INT(10) NOT NULL,
    `auth_id`  VARCHAR(45) COLLATE utf8_bin NOT NULL,
    `eff_time` DATETIME                     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `exp_time` DATETIME                              DEFAULT '2222-12-31 12:59:59',
    `ext_1`    VARCHAR(45) COLLATE utf8_bin          DEFAULT NULL,
    `ext_2`    VARCHAR(45) COLLATE utf8_bin          DEFAULT NULL,
    `ext_3`    VARCHAR(45) COLLATE utf8_bin          DEFAULT NULL,
    `ext_4`    VARCHAR(45) COLLATE utf8_bin          DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `sysuserempowerment_userid_authid_UN` (`user_id`,`auth_id`),
    CONSTRAINT `sysuserempowerment_userid_FK` FOREIGN KEY (`user_id`) REFERENCES `sys_user` (`user_id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户的赋权权限';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sys_user_reverse`
--

DROP TABLE IF EXISTS `sys_user_reverse`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
SET
character_set_client = utf8mb4 ;
CREATE TABLE `sys_user_reverse`
(
    `id`       INT(10) NOT NULL AUTO_INCREMENT,
    `user_id`  INT(10) NOT NULL,
    `auth_id`  VARCHAR(45) COLLATE utf8_bin NOT NULL,
    `eff_time` DATETIME                     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `exp_time` DATETIME                              DEFAULT '2222-12-31 12:59:59',
    `ext_1`    VARCHAR(45) COLLATE utf8_bin          DEFAULT NULL,
    `ext_2`    VARCHAR(45) COLLATE utf8_bin          DEFAULT NULL,
    `ext_3`    VARCHAR(45) COLLATE utf8_bin          DEFAULT NULL,
    `ext_4`    VARCHAR(45) COLLATE utf8_bin          DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `sysuserreverse_userid_authid_UN` (`user_id`,`auth_id`),
    KEY        `sysuserreverse_authid_FK_idx` (`auth_id`),
    CONSTRAINT `sysuserreverse_userid_FK` FOREIGN KEY (`user_id`) REFERENCES `sys_user` (`user_id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户的反向权限';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sys_user_role`
--

DROP TABLE IF EXISTS `sys_user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
SET
character_set_client = utf8mb4 ;
CREATE TABLE `sys_user_role`
(
    `id`         INT(10) NOT NULL AUTO_INCREMENT,
    `user_id`    INT(10) NOT NULL,
    `role_id`    VARCHAR(45) NOT NULL,
    `desc`       VARCHAR(45)          DEFAULT NULL,
    `creat_time` DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `eff_time`   DATETIME             DEFAULT CURRENT_TIMESTAMP,
    `exp_time`   DATETIME             DEFAULT '2222-12-31 12:59:59',
    PRIMARY KEY (`id`),
    UNIQUE KEY `userid_roleId_UN` (`user_id`,`role_id`) /*!80000 INVISIBLE */,
    KEY          `userrole_role_FK_idx` (`role_id`) /*!80000 INVISIBLE */,
    CONSTRAINT `userrole_role_FK` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`role_id`) ON UPDATE RESTRICT,
    CONSTRAINT `userrole_userid_FK` FOREIGN KEY (`user_id`) REFERENCES `sys_user` (`user_id`) ON UPDATE RESTRICT
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='用户的角色';
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

DROP TABLE IF EXISTS subs_user.inf_subscriber;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
SET
character_set_client = utf8mb4 ;
CREATE TABLE subs_user.inf_subscriber
(
    `subs_id`    INT(9) NOT NULL,
    `sub_name`   VARCHAR(45) NOT NULL,
    `contact_id` VARCHAR(45) DEFAULT NULL COMMENT '外键 contact_user.inf_contact',
    `party_id`   INT(10) DEFAULT NULL COMMENT '外键party_user.inf_party',
    `addr_id`    INT(11) DEFAULT NULL COMMENT 'addr_user.inf_address',
    `filed1`     VARCHAR(45) DEFAULT NULL,
    `filed2`     VARCHAR(45) DEFAULT NULL,
    `filed3`     VARCHAR(45) DEFAULT NULL,
    `filed4`     VARCHAR(45) DEFAULT NULL,
    PRIMARY KEY (`subs_id`),
    UNIQUE KEY `subs_id_UNIQUE` (`subs_id`),
    KEY          `addr_id_FK_idx` (`addr_id`),
    CONSTRAINT `subs_addr_id_FK` FOREIGN KEY (`addr_id`) REFERENCES `addr_user`.`inf_address` (`addr_id`) ON UPDATE RESTRICT
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='用户表信息';
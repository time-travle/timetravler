DROP TABLE IF EXISTS addr_user.inf_address;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
SET
character_set_client = utf8mb4 ;
CREATE TABLE addr_user.inf_address
(
    `addr_id`        int(11) NOT NULL AUTO_INCREMENT,
    `overseas`       varchar(45) NOT NULL COMMENT '是不是海外的地址  Y(是)/N(不是)',
    `standard`       varchar(45) NOT NULL COMMENT '是不是标准地址  Y(是)/N(不是)',
    `country_addr`   varchar(45) DEFAULT NULL COMMENT '国家',
    `province_addr`  varchar(45) DEFAULT NULL COMMENT '省/州',
    `city_adddr`     varchar(45) DEFAULT NULL COMMENT '市/区',
    `city_street`    varchar(45) DEFAULT NULL COMMENT '市里的街道',
    `county_addr`    varchar(45) DEFAULT NULL COMMENT '县/',
    `country_street` varchar(45) DEFAULT NULL COMMENT '县街道',
    `tonwship_addr`  varchar(45) DEFAULT NULL COMMENT '镇/',
    `valliage_addr`  varchar(45) DEFAULT NULL COMMENT '村/',
    `house_addr`     varchar(45) DEFAULT NULL COMMENT '门牌号/',
    PRIMARY KEY (`addr_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
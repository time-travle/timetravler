DROP TABLE IF EXISTS addr_user.inf_region;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
SET
character_set_client = utf8mb4 ;
CREATE TABLE addr_user.inf_region
(
    `id`         INT(6) NOT NULL,
    `regin_id`   VARCHAR(45) NOT NULL,
    `regin_name` VARCHAR(45)  DEFAULT NULL,
    `regin_leve` VARCHAR(45)  DEFAULT NULL,
    `parent_id`  VARCHAR(45)  DEFAULT NULL,
    `desc`       VARCHAR(150) DEFAULT NULL,
    `filed1`     VARCHAR(45)  DEFAULT NULL,
    `filed2`     VARCHAR(45)  DEFAULT NULL,
    `filed3`     VARCHAR(45)  DEFAULT NULL,
    `filed4`     VARCHAR(45)  DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `regin_id_UNIQUE` (`regin_id`),
    KEY          `region_parent_id_idx` (`parent_id`),
    CONSTRAINT `region_parent_id` FOREIGN KEY (`parent_id`) REFERENCES `inf_region` (`regin_id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='区域id和名字';
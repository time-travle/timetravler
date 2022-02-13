DROP TABLE IF EXISTS subs_user.inf_travel;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
SET
character_set_client = utf8mb4 ;
CREATE TABLE subs_user.inf_travel
(
    `id`                  INT(6) NOT NULL AUTO_INCREMENT,
    `from_country`        VARCHAR(45) COLLATE utf8_bin  DEFAULT 'China' COMMENT '那个国家出发',
    `from_place`          VARCHAR(45) COLLATE utf8_bin  DEFAULT NULL COMMENT '从哪里出发',
    `to_country`          VARCHAR(45) COLLATE utf8_bin  DEFAULT 'China' COMMENT '去那个国家',
    `to_place`            VARCHAR(45) COLLATE utf8_bin  DEFAULT NULL COMMENT '去的详细地方',
    `currency`            VARCHAR(45) COLLATE utf8_bin  DEFAULT NULL COMMENT '行程费用币种',
    `price`               DECIMAL(6, 3)                 DEFAULT NULL COMMENT '行程价格',
    `price_detail`        VARCHAR(250) COLLATE utf8_bin DEFAULT NULL COMMENT '费用明细',
    `need_tax`            ENUM('Y','N') COLLATE utf8_bin DEFAULT 'Y' COMMENT '是否需要出租车',
    `tax_currency`        VARCHAR(45) COLLATE utf8_bin  DEFAULT NULL COMMENT '打车费用的币种',
    `tax_price`           DECIMAL(6, 3)                 DEFAULT NULL COMMENT '出租车费用',
    `tax_time`            TIMESTAMP NULL DEFAULT NULL COMMENT '打车时间',
    `tax_fee_detail`      VARCHAR(150) COLLATE utf8_bin DEFAULT NULL COMMENT '出租车费用明细',
    `accompanying_person` VARCHAR(45) COLLATE utf8_bin  DEFAULT NULL COMMENT '随行人员',
    `eff_time`            DATETIME                      DEFAULT CURRENT_TIMESTAMP COMMENT '行程开始时间',
    `exp_time`            DATETIME                      DEFAULT '2222-12-31 12:59:59' COMMENT '行程结束时间',
    `reason`              VARCHAR(500) COLLATE utf8_bin DEFAULT NULL COMMENT '出行原因',
    `remark`              VARCHAR(45) COLLATE utf8_bin  DEFAULT NULL,
    `filed_1`             VARCHAR(45) COLLATE utf8_bin  DEFAULT NULL,
    `filed_2`             VARCHAR(45) COLLATE utf8_bin  DEFAULT NULL,
    `filed_3`             VARCHAR(100) COLLATE utf8_bin DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
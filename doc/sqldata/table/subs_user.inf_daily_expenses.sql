--
-- Table structure for table `inf_daily_expenses`
--

DROP TABLE IF EXISTS subs_user.`inf_daily_expenses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
SET character_set_client = utf8mb4 ;
CREATE TABLE  subs_user.`inf_daily_expenses` (
      `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
      `name` enum('put cash to VISA','get cash from VISA','used') DEFAULT 'used' COMMENT '''费用名字''：get cash from VISA\\n，used\\n ，put cash to VISA',
      `value` varchar(45) NOT NULL,
      `currency` varchar(45) NOT NULL DEFAULT 'CNY',
      `paymentMethod` enum('Cash','CreditCard','E_Cash','Social_Card') DEFAULT 'E_Cash',
      `reason` varchar(45) DEFAULT NULL COMMENT '''费用发生原因''',
      `eff_time` timestamp NULL DEFAULT NULL COMMENT '费用发生时间',
      `inputTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
      `haveCertificate` enum('1','0') NOT NULL DEFAULT '1' COMMENT '1:有凭据 0:无凭据',
      `isreturn` int(1) DEFAULT '1' COMMENT '是否需要补充上来',
      `sub_id` varchar(45) DEFAULT NULL COMMENT '关联用户',
      `informationSources` varchar(45) DEFAULT NULL COMMENT '信息的来源是哪里',
      `remark1` varchar(45) DEFAULT NULL COMMENT '备注',
      `remark2` varchar(60) DEFAULT NULL COMMENT '备注2',
      PRIMARY KEY (`id`),
      UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=686 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

DROP TABLE IF EXISTS system_user.location;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
SET
character_set_client = utf8mb4 ;
CREATE TABLE system_user.location
(
    `id`          INT(11) NOT NULL AUTO_INCREMENT,
    `locate`      VARCHAR(8) NOT NULL,
    `descrpition` VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;


/*LOCK TABLES `inf_location` WRITE;*/
/*!40000 ALTER TABLE `inf_location` DISABLE KEYS */;
INSERT INTO system_user.location
VALUES (1, 'zh_CN', '中国大陆地区'),
       (2, 'en_US', '美国英语'),
       (3, 'es_CO', '哥伦比亚西班牙语'),
       (4, 'es_LA', '厄瓜多尔西班牙语'),
       (12, 'dsb_DE', '下索布语德语'),
       (13, 'zh_TW', '中国台湾'),
       (14, 'zh_SG', '新加坡'),
       (15, 'zh_MO', '中国澳门'),
       (16, 'zh_HK', '中国香港'),
       (17, 'da', '丹麦语'),
       (18, 'da-DK', '丹麦语（丹麦）'),
       (19, 'uz-uz', '乌兹别克语-拉丁文'),
       (20, 'ur', '乌都语'),
       (21, 'hy', '亚美尼亚语'),
       (22, 'ru-mo', '俄罗斯-摩尔多瓦共和国'),
       (23, 'mk', '马其顿'),
       (24, 'mr', '马拉地语'),
       (25, 'arn', '马普切语'),
       (26, 'arn-CL', '马普切语（智利）'),
       (27, 'ms-bn', '马来语-文莱'),
       (28, 'ms-my', '马来语-马来西亚'),
       (29, 'mt', '马耳他语'),
       (30, 'ru', '俄语'),
       (31, 'bg', '保加利亚语'),
       (32, 'bg-BG', '保加利亚语-保加利亚'),
       (33, 'ar', '阿拉伯语'),
       (34, 'ar-YE', '阿拉伯语-也门'),
       (35, 'ar-IQ', '阿拉伯语-伊拉克'),
       (36, 'ar-LY', '阿拉伯语-利比亚'),
       (37, 'ar-QA', '阿拉伯语-卡塔尔'),
       (38, 'ar-SY', '阿拉伯语-叙利亚'),
       (39, 'ar-EG', '阿拉伯语-埃及'),
       (40, 'ar-BH', '阿拉伯语-巴林'),
       (41, 'ar-MA', '阿拉伯语-摩洛哥'),
       (42, 'ar-SA', '阿拉伯语-沙特阿拉伯'),
       (43, 'ar-KW', '阿拉伯语-科威特'),
       (44, 'ar-TN', '阿拉伯语-突尼斯'),
       (45, 'ar-JO', '阿拉伯语-约旦'),
       (46, 'ar-DZ', '阿拉伯语-阿尔及利亚'),
       (47, 'ar-AE', '阿拉伯语-阿拉伯联合酋长国'),
       (48, 'ar-OM', '阿拉伯语-阿曼'),
       (49, 'ar-LB', '阿拉伯语-黎巴嫩'),
       (50, 'as', '阿萨姆语'),
       (51, 'as-IN', '阿萨姆语-印度'),
       (52, 'tt', '鞑靼语'),
       (53, 'vi', '越南语'),
       (54, 'dv', '迪维西语'),
       (55, 'dv_MF', '迪维西语(马尔代夫)'),
       (56, 'es-pe', '西班牙-秘鲁'),
       (57, 'es-uy', '西班牙语-乌拉圭'),
       (58, 'es-gt', '西班牙语-危地马拉'),
       (59, 'es-ec', '西班牙语-厄瓜多尔'),
       (60, 'es-co', '西班牙语-哥伦比亚'),
       (61, 'es-cr', '西班牙语-哥斯达黎加'),
       (62, 'es-mx', '西班牙语-墨西哥'),
       (63, 'es-do', '西班牙语-多米尼加共和国'),
       (64, 'es-ve', '西班牙语-委内瑞拉'),
       (65, 'es-ni', '西班牙语-尼加拉瓜'),
       (66, 'es-py', '西班牙语-巴拉圭'),
       (67, 'es-pa', '西班牙语-巴拿马'),
       (68, 'es-cl', '西班牙语-智利'),
       (69, 'es-pr', '西班牙语-波多黎各'),
       (70, 'es-hn', '西班牙语-洪都拉斯'),
       (71, 'es-bo', '西班牙语-玻利维亚'),
       (72, 'es-sv', '西班牙语-萨尔瓦多'),
       (73, 'es-es', '西班牙语-西班牙'),
       (74, 'es-ar', '西班牙语-阿根廷'),
       (75, 'bo', '藏语'),
       (76, 'bo-CN', '藏语-中国'),
       (77, 'pt-br', '葡萄牙语-巴西'),
       (78, 'pt-pt', '葡萄牙语-葡萄牙'),
       (79, 'fr-ca', '法语-加拿大'),
       (80, 'fr-lu', '法语-卢森堡'),
       (81, 'fr-be', '法语-比利时'),
       (82, 'fr-fr', '法语-法国'),
       (83, 'fr-ch', '法语-瑞士'),
       (84, 'en-BZ', '英语-伯利兹'),
       (85, 'en-CA', '英语-加拿大'),
       (86, 'en-CB', '英语-加勒比'),
       (87, 'en-ZA', '英语-南非'),
       (88, 'en-IN', '英语-印度'),
       (89, 'en-SG', '英语-新加坡'),
       (90, 'en-NZ', '英语-新西兰'),
       (91, 'en-ZW', '英语-津巴布韦'),
       (92, 'en-AU', '英语-澳大利亚'),
       (93, 'en-IE', '英语-爱尔兰'),
       (94, 'en-JM', '英语-牙买加'),
       (95, 'en-TT', '英语-特立尼达岛'),
       (96, 'en-GB', '英语-英国'),
       (97, 'en-PH', '英语-菲律宾'),
       (98, 'en-MY', '英语-马来西亚');
/*!40000 ALTER TABLE `inf_location` ENABLE KEYS */;
/*UNLOCK TABLES;*/
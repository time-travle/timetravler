DROP TABLE IF EXISTS subs_user.link_man;

CREATE TABLE subs_user.link_man
(
    `id`                        INT(3) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `name`                      VARCHAR(20)          DEFAULT NULL COMMENT '名字',
    `nick_name`                 VARCHAR(30)          DEFAULT NULL COMMENT '昵称',
    `phone_num_01`              VARCHAR(14) NOT NULL COMMENT '首选手机号',
    `group_name`                VARCHAR(25)          DEFAULT NULL COMMENT '给个分组',
    `old_company_name`          VARCHAR(20)          DEFAULT NULL COMMENT '老的公司名字',
    `address_work`              VARCHAR(45)          DEFAULT NULL COMMENT '工作地址',
    `home_num`                  VARCHAR(14)          DEFAULT NULL COMMENT '家庭电话',
    `phone_num_02`              VARCHAR(14)          DEFAULT NULL COMMENT '备用手机号',
    `position`                  VARCHAR(20)          DEFAULT NULL COMMENT '职位',
    `company_name`              VARCHAR(20)          DEFAULT NULL COMMENT '当前公司名字',
    `address_home`              VARCHAR(45)          DEFAULT NULL COMMENT '家庭地址',
    `net_phone`                 VARCHAR(20)          DEFAULT NULL COMMENT '网络电话',
    `email_01`                  VARCHAR(25)          DEFAULT NULL COMMENT '首选邮件',
    `email_02`                  VARCHAR(25)          DEFAULT NULL COMMENT '备选邮件',
    `address_http`              VARCHAR(30)          DEFAULT NULL COMMENT '网络地址',
    `realitation`               VARCHAR(30)          DEFAULT NULL COMMENT '关系',
    `Chinese_calendar_birthday` TIME                 DEFAULT NULL COMMENT '农历生日',
    `birthday`                  TIME                 DEFAULT NULL COMMENT '生日',
    `create_time`               TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
    `eff_time`                  TIMESTAMP   NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '生效时间',
    `modify_time`               TIMESTAMP   NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '修改时间',
    `ext_filed1`                VARCHAR(50)          DEFAULT NULL,
    `ext_filed2`                VARCHAR(50)          DEFAULT NULL,
    `ext_filed3`                VARCHAR(100)         DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `phone_num_01` (`phone_num_01`)
) ENGINE=INNODB AUTO_INCREMENT=73 DEFAULT CHARSET=utf8;


INSERT INTO subs_user.link_man(`id`, `name`, `nick_name`, `phone_num_01`, `group_name`, `old_company_name`,
                               `address_work`, `home_num`, `phone_num_02`, `position`, `company_name`, `address_home`,
                               `net_phone`, `email_01`, `email_02`, `address_http`, `realitation`,
                               `Chinese_calendar_birthday`, `birthday`, `create_time`, `eff_time`, `modify_time`,
                               `ext_filed1`, `ext_filed2`, `ext_filed3`)
VALUES (1, '白庄', NULL, '15054088065', '家人亲戚', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
        NULL, NULL, '2019-02-07 16:22:50', '0000-00-00 00:00:00', '0000-00-00 00:00:00', NULL, NULL, NULL),
       (2, '薛彦滨', '滨哥', '15668386739', '中软同事', NULL, '济南历下区', NULL, NULL, '高级软件开发工程师', '中软国际', NULL, NULL, NULL, NULL,
        NULL, NULL, NULL, NULL, '2019-02-07 18:56:09', '0000-00-00 00:00:00', '0000-00-00 00:00:00', NULL, NULL, NULL),
       (3, '曹新磊', '磊哥', '18234127213', '软通同事', '软通动力（济南）', NULL, NULL, NULL, '高级软件开发工程师', NULL, NULL, NULL, NULL, NULL,
        NULL, NULL, NULL, NULL, '2019-02-07 18:56:03', '0000-00-00 00:00:00', '0000-00-00 00:00:00', NULL, NULL, NULL),
       (4, '刘栋', NULL, '06313858228', '迪沙同事', NULL, '威海经济技术开发区', NULL, NULL, '主任', '迪沙药业', NULL, NULL, NULL, NULL, NULL,
        NULL, NULL, NULL, '2019-02-07 18:56:20', '0000-00-00 00:00:00', '0000-00-00 00:00:00', NULL, NULL, NULL),
       (5, '陈凡银', NULL, '18263133682', '大学同学', NULL, '威海经济技术开发区', NULL, NULL, NULL, '迪沙药业', NULL, NULL, NULL, NULL,
        NULL, NULL, NULL, NULL, '2019-02-07 16:42:21', '0000-00-00 00:00:00', '0000-00-00 00:00:00', NULL, NULL, NULL),
       (6, '陈慧君', NULL, '18256011862', '大学研究生师姐', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
        NULL, NULL, NULL, '2019-02-07 16:56:13', '0000-00-00 00:00:00', '0000-00-00 00:00:00', NULL, NULL, NULL),
       (7, '陈伟达', NULL, '17753173577', '知安同事', NULL, NULL, NULL, NULL, NULL, '济南知安药业', NULL, NULL, NULL, NULL, NULL,
        NULL, NULL, NULL, '2019-02-07 19:10:55', '0000-00-00 00:00:00', '0000-00-00 00:00:00', NULL, NULL, NULL),
       (8, '陈玉倩', NULL, '13598007825', '大学同学', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
        NULL, NULL, '2019-02-07 17:00:51', '0000-00-00 00:00:00', '0000-00-00 00:00:00', NULL, NULL, NULL),
       (9, '杨春宇', NULL, '15607102019', '大学同学', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
        NULL, NULL, '2019-02-07 17:01:57', '0000-00-00 00:00:00', '0000-00-00 00:00:00', NULL, NULL, NULL),
       (10, '张帅', NULL, '18754000929', '家人亲戚', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
        NULL, NULL, '2019-02-07 17:02:56', '0000-00-00 00:00:00', '0000-00-00 00:00:00', NULL, NULL, NULL),
       (11, '王东东(云聪)', NULL, '15605015573', '小时玩伴', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
        NULL, NULL, NULL, '2019-02-07 17:04:14', '0000-00-00 00:00:00', '0000-00-00 00:00:00', NULL, NULL, NULL),
       (12, '王明斌', NULL, '18463724421', '家人亲戚', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
        NULL, NULL, '2019-02-07 17:05:14', '0000-00-00 00:00:00', '0000-00-00 00:00:00', NULL, NULL, NULL),
       (13, '胡高彦', NULL, '18765893387', '高中同学', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
        NULL, NULL, '2019-02-07 17:08:54', '0000-00-00 00:00:00', '0000-00-00 00:00:00', NULL, NULL, NULL),
       (14, '郭建云', NULL, '18706589893', '大学同学', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
        NULL, NULL, '2019-02-07 17:09:38', '0000-00-00 00:00:00', '0000-00-00 00:00:00', NULL, NULL, NULL),
       (15, '桂梅姐', NULL, '18530113096', '家人亲戚', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
        NULL, NULL, '2019-02-07 17:14:02', '0000-00-00 00:00:00', '0000-00-00 00:00:00', NULL, NULL, NULL),
       (16, '桂梅姐', NULL, '13592127590', '家人亲戚', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
        NULL, NULL, '2019-02-07 17:15:34', '0000-00-00 00:00:00', '0000-00-00 00:00:00', NULL, NULL, NULL),
       (17, '何宗元', NULL, '15874757433', '大学同学', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
        NULL, NULL, '2019-02-07 18:10:14', '0000-00-00 00:00:00', '0000-00-00 00:00:00', NULL, NULL, NULL),
       (18, '黄思维', NULL, '15570725649', '软通同事', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
        NULL, NULL, '2019-02-07 18:55:58', '0000-00-00 00:00:00', '0000-00-00 00:00:00', NULL, NULL, NULL),
       (19, '季元超', NULL, '18963616489', '软通同事', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
        NULL, NULL, '2019-02-07 18:55:57', '0000-00-00 00:00:00', '0000-00-00 00:00:00', NULL, NULL, NULL),
       (20, '贾纪超', NULL, '18654521593', '软通同事', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
        NULL, NULL, '2019-02-07 18:55:56', '0000-00-00 00:00:00', '0000-00-00 00:00:00', NULL, NULL, NULL),
       (21, '贾岩', NULL, '13562193300', '迪沙同事', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
        NULL, NULL, '2019-02-07 18:56:35', '0000-00-00 00:00:00', '0000-00-00 00:00:00', NULL, NULL, NULL),
       (22, '王魁冲', NULL, '13486483231', '小时玩伴', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
        NULL, NULL, '2019-02-07 18:18:57', '0000-00-00 00:00:00', '0000-00-00 00:00:00', NULL, NULL, NULL),
       (23, '李磊', NULL, '13821324541', '高中同学', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
        NULL, NULL, '2019-02-07 18:54:04', '0000-00-00 00:00:00', '0000-00-00 00:00:00', NULL, NULL, NULL),
       (24, '李灵灵', NULL, '18237157898', '高中同学', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
        NULL, NULL, '2019-02-07 18:55:00', '0000-00-00 00:00:00', '0000-00-00 00:00:00', NULL, NULL, NULL),
       (25, '李萌', NULL, '18615659340', '软通同事', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
        NULL, NULL, '2019-02-07 18:55:51', '0000-00-00 00:00:00', '0000-00-00 00:00:00', NULL, NULL, NULL),
       (26, '李文豪', NULL, '15954041911', '迪沙同事', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
        NULL, NULL, '2019-02-07 18:57:45', '0000-00-00 00:00:00', '0000-00-00 00:00:00', NULL, NULL, NULL),
       (27, '李新宝', NULL, '18861353912', '大学同学', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
        NULL, NULL, '2019-02-07 18:58:37', '0000-00-00 00:00:00', '0000-00-00 00:00:00', NULL, NULL, NULL),
       (28, '李玉生', NULL, '15634881381', '软通同事', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
        NULL, NULL, '2019-02-07 18:59:23', '0000-00-00 00:00:00', '0000-00-00 00:00:00', NULL, NULL, NULL),
       (29, '刘大鹏', NULL, '13561892671', '迪沙同事', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
        NULL, NULL, '2019-02-07 18:59:59', '0000-00-00 00:00:00', '0000-00-00 00:00:00', NULL, NULL, NULL),
       (30, '刘洪法', NULL, '15634424911', '迪沙同事', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
        NULL, NULL, '2019-02-07 19:00:32', '0000-00-00 00:00:00', '0000-00-00 00:00:00', NULL, NULL, NULL),
       (31, '刘建坡', NULL, '15665666558', '迪沙同事', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
        NULL, NULL, '2019-02-07 19:01:12', '0000-00-00 00:00:00', '0000-00-00 00:00:00', NULL, NULL, NULL),
       (32, '刘兴康', NULL, '18810937212', '初中同学', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
        NULL, NULL, '2019-02-07 19:02:11', '0000-00-00 00:00:00', '0000-00-00 00:00:00', NULL, NULL, NULL),
       (33, '刘彦杰', NULL, '18354219305', '高中同学', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
        NULL, NULL, '2019-02-07 19:03:15', '0000-00-00 00:00:00', '0000-00-00 00:00:00', NULL, NULL, NULL),
       (34, '刘瑶', NULL, '18615274537', '软通同事', NULL, NULL, NULL, '053188687121', '人事部报销管理经理', '软通动力(济南)', NULL, NULL,
        NULL, NULL, NULL, NULL, NULL, NULL, '2019-02-07 19:05:35', '0000-00-00 00:00:00', '0000-00-00 00:00:00', NULL,
        NULL, NULL),
       (35, '吕健', NULL, '13465145116', '迪沙同事', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
        NULL, NULL, '2019-02-07 19:06:35', '0000-00-00 00:00:00', '0000-00-00 00:00:00', NULL, NULL, NULL),
       (36, '马学强', NULL, '15552367377', '中软同事', '中软国际', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
        NULL, NULL, NULL, '2019-02-07 19:15:20', '0000-00-00 00:00:00', '0000-00-00 00:00:00', NULL, NULL, NULL),
       (37, '毛耐民', NULL, '13529057352', '高中同学', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
        NULL, NULL, '2019-02-07 19:08:41', '0000-00-00 00:00:00', '0000-00-00 00:00:00', NULL, NULL, NULL),
       (38, '孟林', NULL, '18264083175', '高中同学', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
        NULL, NULL, '2019-02-07 19:09:27', '0000-00-00 00:00:00', '0000-00-00 00:00:00', NULL, NULL, NULL),
       (39, '彭帅', NULL, '15143120909', '大学同学', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
        NULL, NULL, '2019-02-07 19:10:02', '0000-00-00 00:00:00', '0000-00-00 00:00:00', NULL, NULL, NULL),
       (40, '齐坤山', NULL, '18363030973', '知安同事', NULL, NULL, NULL, NULL, NULL, '济南知安药业', NULL, NULL, NULL, NULL, NULL,
        NULL, NULL, NULL, '2019-02-07 19:12:02', '0000-00-00 00:00:00', '0000-00-00 00:00:00', NULL, NULL, NULL),
       (41, '任卓逸', NULL, '15753192592', '软通同事', '软通动力(济南)', NULL, NULL, NULL, NULL, '埃及某公司', NULL, NULL, NULL, NULL,
        NULL, NULL, NULL, NULL, '2019-02-07 19:13:22', '0000-00-00 00:00:00', '0000-00-00 00:00:00', NULL, NULL, NULL),
       (42, '田令勇', NULL, '13523787337', '家人亲戚', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
        NULL, NULL, '2019-02-07 19:14:27', '0000-00-00 00:00:00', '0000-00-00 00:00:00', NULL, NULL, NULL),
       (43, '尚玉康', NULL, '13969059881', '软通同事', '软通动力(济南)', NULL, NULL, NULL, NULL, '浪潮国际(济南)', NULL, NULL, NULL, NULL,
        NULL, NULL, NULL, NULL, '2019-02-07 19:15:56', '0000-00-00 00:00:00', '0000-00-00 00:00:00', NULL, NULL, NULL),
       (44, '石磊', NULL, '18369154139', '高中同学', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
        NULL, NULL, '2019-02-07 19:16:45', '0000-00-00 00:00:00', '0000-00-00 00:00:00', NULL, NULL, NULL),
       (45, '孙井鑫', NULL, '18300524454', '迪沙同事', '迪沙药业', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
        NULL, NULL, NULL, '2019-02-07 19:18:06', '0000-00-00 00:00:00', '0000-00-00 00:00:00', NULL, NULL, NULL),
       (46, '王磊', NULL, '18535624785', '大学同学', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
        NULL, NULL, '2019-02-07 19:19:19', '0000-00-00 00:00:00', '0000-00-00 00:00:00', NULL, NULL, NULL),
       (47, '王新宇', NULL, '15866307762', '迪沙同事', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
        NULL, NULL, '2019-02-07 19:19:54', '0000-00-00 00:00:00', '0000-00-00 00:00:00', NULL, NULL, NULL),
       (48, '文阳', NULL, '18357225201', '高中同学', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
        NULL, NULL, '2019-02-07 19:20:50', '0000-00-00 00:00:00', '0000-00-00 00:00:00', NULL, NULL, NULL),
       (49, '吴凤吉', NULL, '18753170849', '迪沙同事', '迪沙药业', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
        NULL, NULL, NULL, '2019-02-07 19:21:31', '0000-00-00 00:00:00', '0000-00-00 00:00:00', NULL, NULL, NULL),
       (50, '武清波', NULL, '15628788868', '华为同事', NULL, NULL, NULL, NULL, 'PL', NULL, NULL, NULL, NULL, NULL, NULL, NULL,
        NULL, NULL, '2019-02-07 19:24:39', '0000-00-00 00:00:00', '0000-00-00 00:00:00', NULL, NULL, NULL),
       (51, '徐亚东', NULL, '18562869500', '高中同学', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
        NULL, NULL, '2019-02-07 19:23:38', '0000-00-00 00:00:00', '0000-00-00 00:00:00', NULL, NULL, NULL),
       (52, '许亮', NULL, '18668971686', '华为同事', NULL, NULL, NULL, NULL, 'PL', NULL, NULL, NULL, NULL, NULL, NULL, NULL,
        NULL, NULL, '2019-02-07 19:24:29', '0000-00-00 00:00:00', '0000-00-00 00:00:00', NULL, NULL, NULL),
       (53, '王亚东', NULL, '15020123586', '小时玩伴', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
        NULL, NULL, '2019-02-07 19:25:17', '0000-00-00 00:00:00', '0000-00-00 00:00:00', NULL, NULL, NULL),
       (54, '杨丙华', NULL, '15508629008', '高中同学', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
        NULL, NULL, '2019-02-07 19:26:39', '0000-00-00 00:00:00', '0000-00-00 00:00:00', NULL, NULL, NULL),
       (55, '杨春宇', NULL, '15044070105', '大学同学', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
        NULL, NULL, '2019-02-07 19:27:26', '0000-00-00 00:00:00', '0000-00-00 00:00:00', NULL, NULL, NULL),
       (56, '杨江鑫', NULL, '17606263598', '迪沙同事', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
        NULL, NULL, '2019-02-07 19:27:59', '0000-00-00 00:00:00', '0000-00-00 00:00:00', NULL, NULL, NULL),
       (57, '杨巧灵', NULL, '15293307413', '大学研究生师姐', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
        NULL, NULL, NULL, '2019-02-07 19:28:48', '0000-00-00 00:00:00', '0000-00-00 00:00:00', NULL, NULL, NULL),
       (58, '籍今野', NULL, '13504760130', '大学同学', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
        NULL, NULL, '2019-02-07 19:30:19', '0000-00-00 00:00:00', '0000-00-00 00:00:00', NULL, NULL, NULL),
       (59, '翟强', NULL, '18663778554', '华为同事', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
        NULL, NULL, '2019-02-07 19:30:55', '0000-00-00 00:00:00', '0000-00-00 00:00:00', NULL, NULL, NULL),
       (60, '张璐', NULL, '15835720370', '软通同事', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
        NULL, NULL, '2019-02-07 19:31:46', '0000-00-00 00:00:00', '0000-00-00 00:00:00', NULL, NULL, NULL),
       (61, '张荣彪', NULL, '18853187628', '软通同事', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
        NULL, NULL, '2019-02-07 19:33:24', '0000-00-00 00:00:00', '0000-00-00 00:00:00', NULL, NULL, NULL),
       (62, '张汝云', NULL, '18654558688', '软通同事', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
        NULL, NULL, '2019-02-07 19:34:02', '0000-00-00 00:00:00', '0000-00-00 00:00:00', NULL, NULL, NULL),
       (63, '张胜飞', NULL, '18053156782', '软通同事', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
        NULL, NULL, '2019-02-07 19:34:43', '0000-00-00 00:00:00', '0000-00-00 00:00:00', NULL, NULL, NULL),
       (64, '张威威', NULL, '18705182852', '高中同学', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
        NULL, NULL, '2019-02-07 19:35:31', '0000-00-00 00:00:00', '0000-00-00 00:00:00', NULL, NULL, NULL),
       (65, '张文强', NULL, '18830539533', '迪沙同事', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
        NULL, NULL, '2019-02-07 19:36:01', '0000-00-00 00:00:00', '0000-00-00 00:00:00', NULL, NULL, NULL),
       (66, '张雪', NULL, '18684308286', '中软同事', '中软国际', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
        NULL, NULL, '2019-02-07 19:36:41', '0000-00-00 00:00:00', '0000-00-00 00:00:00', NULL, NULL, NULL),
       (67, '张云荃', NULL, '15700709735', '软通同事', NULL, NULL, NULL, NULL, NULL, '软通同事(长沙)', NULL, NULL, NULL, NULL, NULL,
        NULL, NULL, NULL, '2019-02-07 19:37:41', '0000-00-00 00:00:00', '0000-00-00 00:00:00', NULL, NULL, NULL),
       (68, '赵慧', NULL, '15190607959', '中软同事', NULL, NULL, NULL, NULL, NULL, '中软国际(南京)', NULL, NULL, NULL, NULL, NULL,
        NULL, NULL, NULL, '2019-02-07 19:38:39', '0000-00-00 00:00:00', '0000-00-00 00:00:00', NULL, NULL, NULL),
       (69, '王争光', NULL, '15552775356', '小时玩伴', NULL, NULL, NULL, '17661049855', NULL, NULL, NULL, NULL, NULL, NULL,
        NULL, NULL, NULL, NULL, '2019-02-07 19:41:09', '0000-00-00 00:00:00', '0000-00-00 00:00:00', NULL, NULL, NULL),
       (70, '智魁升', NULL, '13843072310', '高中同学', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
        NULL, NULL, '2019-02-07 19:42:04', '0000-00-00 00:00:00', '0000-00-00 00:00:00', NULL, NULL, NULL),
       (71, '周涛', NULL, '18615407258', '软通同事', NULL, NULL, NULL, NULL, 'PM(合作)', NULL, NULL, NULL, NULL, NULL, NULL,
        NULL, NULL, NULL, '2019-02-07 19:42:53', '0000-00-00 00:00:00', '0000-00-00 00:00:00', NULL, NULL, NULL),
       (72, '周政', NULL, '18653139252', '中软同事', '中软国际', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
        NULL, NULL, '2019-02-07 19:43:58', '0000-00-00 00:00:00', '0000-00-00 00:00:00', NULL, NULL, NULL);

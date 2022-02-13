DROP TABLE IF EXISTS party_user.certificates_type;

CREATE TABLE party_user.certificates_type
(
    `id`             INT(5) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `cert_type_code` VARCHAR(15) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '证件类型',
    `cert_type_name` VARCHAR(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '证件名称',
    `ext1`           VARCHAR(20) COLLATE utf8_unicode_ci DEFAULT NULL,
    `ext2`           VARCHAR(20) COLLATE utf8_unicode_ci DEFAULT NULL,
    `ext3`           VARCHAR(30) COLLATE utf8_unicode_ci DEFAULT NULL,
    `ext4`           VARCHAR(50) COLLATE utf8_unicode_ci DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `certificates_type` */

LOCK
TABLES party_user.certificates_type WRITE;

INSERT INTO party_user.certificates_type(`id`, `cert_type_code`, `cert_type_name`, `ext1`, `ext2`, `ext3`, `ext4`)
VALUES (1, 'identity', '身份证', NULL, NULL, NULL, NULL),
       (2, 'passport', '护照', NULL, NULL, NULL, NULL),
       (3, 'student', '学生证', NULL, NULL, NULL, NULL),
       (4, 'driver', '驾驶证', NULL, NULL, NULL, NULL),
       (5, 'teacher', '教师证', NULL, NULL, NULL, NULL),
       (6, 'household', '户口薄', NULL, NULL, NULL, NULL),
       (7, 'SIN', '社保卡', NULL, NULL, NULL, NULL),
       (8, 'IGAMA', '居住证', NULL, NULL, NULL, NULL),
       (9, 'bank', '银行卡', NULL, NULL, NULL, NULL),
       (10, 'other', '其他', NULL, NULL, NULL, NULL),
       (11, 'marriage', '结婚证', NULL, NULL, NULL, NULL),
       (12, 'divorce', '离婚证', NULL, NULL, NULL, NULL),
       (13, 'death', '死亡证', NULL, NULL, NULL, NULL),
       (14, 'oldMan', '老人证', NULL, NULL, NULL, NULL),
       (15, 'retirement', '退休证', NULL, NULL, NULL, NULL),
       (16, 'disabled', '残疾证', NULL, NULL, NULL, NULL),
       (17, 'pass', '通行证', NULL, NULL, NULL, NULL),
       (18, 'honor ', '荣誉证', NULL, NULL, NULL, NULL),
       (19, 'qualification', '资格证', NULL, NULL, NULL, NULL),
       (20, 'workLicense', '上岗证', NULL, NULL, NULL, NULL),
       (21, 'unemployed', '失业证', NULL, NULL, NULL, NULL),
       (22, 'xiaGangZheng', '下岗证', NULL, NULL, NULL, NULL),
       (23, 'medicalGuaran', '医保证', NULL, NULL, NULL, NULL),
       (24, 'employed', '工作证', NULL, NULL, NULL, NULL),
       (25, 'health', '健康证', NULL, NULL, NULL, NULL),
       (26, 'driving', '行驶证', NULL, NULL, NULL, NULL),
       (27, 'houeOwner', '房产证', NULL, NULL, NULL, NULL),
       (28, 'graduation', '毕业证', NULL, NULL, NULL, NULL),
       (29, 'certificate', '学位证', NULL, NULL, NULL, NULL),
       (30, 'partyCard', '党员证', NULL, NULL, NULL, NULL),
       (31, 'oneChild', '独生证', NULL, NULL, NULL, NULL),
       (32, 'birth', '出生证', NULL, NULL, NULL, NULL),
       (33, 'birthApproval', '准生证', NULL, NULL, NULL, NULL);

UNLOCK
TABLES;

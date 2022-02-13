/*Table structure for table `school_type` */

DROP TABLE IF EXISTS subs_user.school_type;

CREATE TABLE subs_user.school_type
(
    `id`               INT(3) NOT NULL AUTO_INCREMENT,
    `school_type`      VARCHAR(10) COLLATE utf8_unicode_ci DEFAULT NULL,
    `school_type_code` VARCHAR(30) COLLATE utf8_unicode_ci NOT NULL,
    `school_type_name` VARCHAR(20) COLLATE utf8_unicode_ci DEFAULT NULL,
    `school_type_desc` TEXT COLLATE utf8_unicode_ci,
    `ext1`             VARCHAR(10) COLLATE utf8_unicode_ci DEFAULT NULL,
    `ext2`             VARCHAR(20) COLLATE utf8_unicode_ci DEFAULT NULL,
    `ext3`             VARCHAR(30) COLLATE utf8_unicode_ci DEFAULT NULL,
    `ext4`             VARCHAR(40) COLLATE utf8_unicode_ci DEFAULT NULL,
    `ext5`             VARCHAR(50) COLLATE utf8_unicode_ci DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `Code_UK` (`school_type_code`)
) ENGINE=INNODB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `school_type` */


INSERT INTO `school_type`(`id`, `school_type`, `school_type_code`, `school_type_name`, `school_type_desc`, `ext1`,
                          `ext2`, `ext3`, `ext4`, `ext5`)
VALUES (1, NULL, 'Primary_School\n', '小学', NULL, NULL, NULL, NULL, NULL, NULL),
       (2, NULL, 'Senior_Middle_School', '高中', NULL, NULL, NULL, NULL, NULL, NULL),
       (3, NULL, 'Junior_Middle_School', '初中', NULL, NULL, NULL, NULL, NULL, NULL),
       (4, NULL, 'University', '大学', NULL, NULL, NULL, NULL, NULL, NULL),
       (5, NULL, 'College', '学院', NULL, NULL, NULL, NULL, NULL, NULL),
       (6, NULL, 'Junior_college_Education', '专科', NULL, NULL, NULL, NULL, NULL, NULL),
       (7, NULL, 'Undergraduate', '本科', NULL, NULL, NULL, NULL, NULL, NULL),
       (8, NULL, 'Doctor', '博士', NULL, NULL, NULL, NULL, NULL, NULL),
       (9, NULL, 'Master', '硕士', NULL, NULL, NULL, NULL, NULL, NULL);


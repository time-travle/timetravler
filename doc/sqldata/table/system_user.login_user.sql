DROP TABLE IF EXISTS system_user.login_user;
CREATE TABLE system_user.login_user
(
    `id`                  int(8) NOT NULL AUTO_INCREMENT,
    `login_id`            varchar(20) COLLATE utf8_bin DEFAULT NULL,
    `login_name`          varchar(20) COLLATE utf8_bin DEFAULT NULL,
    `login_in_time`       timestamp(6) NOT NULL        DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP (6),
    `login_out_time`      timestamp(6) NOT NULL        DEFAULT '0000-00-00 00:00:00.000000',
    `last_login_in_time`  timestamp(6) NOT NULL        DEFAULT '0000-00-00 00:00:00.000000',
    `last_login_out_time` timestamp(6) NOT NULL        DEFAULT '0000-00-00 00:00:00.000000',
    `is_disable`          int(1) DEFAULT '1' COMMENT '是不是可以使用。默认1可用',
    `ext1`                varchar(20) COLLATE utf8_bin DEFAULT NULL,
    `ext2`                varchar(20) COLLATE utf8_bin DEFAULT NULL,
    `ext3`                varchar(30) COLLATE utf8_bin DEFAULT NULL,
    `ext4`                varchar(30) COLLATE utf8_bin DEFAULT NULL,
    `ext5`                varchar(50) COLLATE utf8_bin DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

DROP TABLE IF EXISTS subs_user.blind_date;

CREATE TABLE subs_user.blind_date
(
    `id`                 INT(3) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `name`               VARCHAR(30)  DEFAULT NULL,
    `phone`              VARCHAR(14)  DEFAULT NULL,
    `address_work`       VARCHAR(50)  DEFAULT NULL,
    `address_home`       VARCHAR(50)  DEFAULT NULL,
    `active_addr`        VARCHAR(30)  DEFAULT NULL,
    `active_date`        TIMESTAMP NULL DEFAULT NULL,
    `age`                INT(2) DEFAULT NULL,
    `sex`                VARCHAR(4)   DEFAULT NULL,
    `realidation_person` VARCHAR(30)  DEFAULT NULL,
    `remark_01`          VARCHAR(100) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;


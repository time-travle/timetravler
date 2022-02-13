DROP TABLE IF EXISTS party_user.inf_party;

SET
character_set_client = utf8mb4 ;
CREATE TABLE party_user.inf_party
(
    `id`             INT(10) NOT NULL AUTO_INCREMENT,
    `id_type`        ENUM('其他','学生证','护照','身份证') NOT NULL,
    `id_num`         VARCHAR(18) NOT NULL,
    `eff_date`       DATETIME    DEFAULT CURRENT_TIMESTAMP,
    `exp_date`       DATETIME    DEFAULT '2222-12-31 12:59:59',
    `address_info`   VARCHAR(45) DEFAULT NULL,
    `number_entries` INT(2) DEFAULT '1',
    `ext_1`          VARCHAR(45) DEFAULT NULL,
    `ext_2`          VARCHAR(45) DEFAULT NULL,
    `ext_3`          VARCHAR(45) DEFAULT NULL,
    `ext_4`          VARCHAR(45) DEFAULT NULL,
    `ext_5`          VARCHAR(45) DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `id_UNIQUE` (`id_type`,`id_num`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;
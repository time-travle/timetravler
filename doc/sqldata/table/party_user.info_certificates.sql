DROP TABLE IF EXISTS party_user.info_certificates;

CREATE TABLE party_user.info_certificates
(
    `id`          INT(10) NOT NULL AUTO_INCREMENT,
    `rel_id`      INT(20) DEFAULT NULL COMMENT '关联的id',
    `cert_type`   INT(5) DEFAULT NULL COMMENT '证件类型id',
    `cert_number` VARCHAR(30) CHARACTER SET utf8  DEFAULT NULL COMMENT '证件号码',
    `sex`         INT(4) DEFAULT '1' COMMENT '证件的性别',
    `add_time`    TIMESTAMP NOT NULL              DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
    `modify_time` TIMESTAMP NOT NULL              DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
    `used_flag`   INT(1) DEFAULT '0' COMMENT '是不是在用:0未使用 1已经使用',
    `ext1`        VARCHAR(50) CHARACTER SET utf8  DEFAULT NULL COMMENT '预留字段1',
    `ext2`        VARCHAR(50) CHARACTER SET utf8  DEFAULT NULL COMMENT '预留字段2',
    `ext3`        VARCHAR(50) CHARACTER SET utf8  DEFAULT NULL COMMENT '预留字段3',
    `ext4`        VARCHAR(100) CHARACTER SET utf8 DEFAULT NULL COMMENT '预留字段4',
    PRIMARY KEY (`id`),
    UNIQUE KEY `unique_cert_type_number` (`cert_type`,`cert_number`),
    CONSTRAINT `info_certificates_ibfk_1` FOREIGN KEY (`cert_type`) REFERENCES `certificates_type` (`id`) ON DELETE SET NULL
) ENGINE=INNODB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;




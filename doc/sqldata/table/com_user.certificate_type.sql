drop table if exists com_user.certificate_type;
create table com_user.certificate_type
(
    `id`          bigint(21)                                       NOT NULL COMMENT '序列号ID',
    `name`        varchar(45) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '证件名',
    `value`       bigint(21)                                       NOT NULL COMMENT '证件值',
    `code`        varchar(45)                                      NOT NULL COMMENT '证件code',
    `create_time` timestamp                                        NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` timestamp                                        NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    ext_1         varchar(150)                                     null comment '类型说明',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `id` (`id`) USING BTREE,
    UNIQUE KEY `name` (`code`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COLLATE = utf8_bin comment '证件类型';
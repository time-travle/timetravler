Drop TABLE if exists cust_user.inf_customer;
CREATE TABLE cust_user.inf_customer
(
    id              int(8)      NOT NULL AUTO_INCREMENT,
    cust_id         varchar(45) NOT NULL comment '客户id唯一',
    code            varchar(45) NOT NULL comment '客户编码',

    first_name      varchar(45)      DEFAULT NULL comment '客户第一名字 姓',
    middle_name     varchar(45)      DEFAULT NULL comment '客户第一名字 中间名',
    last_name       varchar(45)      DEFAULT NULL comment '客户第一名字 后面名',
    full_name       varchar(45)      DEFAULT NULL comment '客户第一名字 fist+middle+last 全名',

    sec_first_name  varchar(45)      DEFAULT NULL comment '客户第二名字 姓',
    sec_middle_name varchar(45)      DEFAULT NULL comment '客户第二名字 中间名',
    sec_last_name   varchar(45)      DEFAULT NULL comment '客户第二名字 后面名',
    sec_full_name   varchar(45)      DEFAULT NULL comment '客户第二全名字 fist+middle+last 全名',

    cust_desc       varchar(45)      DEFAULT NULL comment '客户描述',
    status          enum ('1','0')   DEFAULT '1' COMMENT '是不是正常的 1 可用 0 不可用',

    exp_time        timestamp        default null comment '记录失效时间',
    create_time     timestamp   NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time     timestamp   NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',

    ext1            varchar(45)      DEFAULT NULL comment '扩展预留',
    ext2            varchar(90)      DEFAULT NULL comment '扩展预留',
    ext3            varchar(150)     DEFAULT NULL comment '扩展预留',
    ext4            varchar(250)     DEFAULT NULL comment '扩展预留',
    ext5            varchar(500)     DEFAULT NULL comment '扩展预留',
    PRIMARY KEY (id),
    unique key cust_UK_001 (cust_id)

) ENGINE = InnoDB
  AUTO_INCREMENT = 2
  DEFAULT CHARSET = utf8;
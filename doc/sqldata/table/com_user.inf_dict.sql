DROP table if exists com_user.inf_dict;
CREATE TABLE com_user.`inf_dict`
(
    `dict_id`   int(4)      NOT NULL AUTO_INCREMENT,
    `dict_code` varchar(45) NOT NULL,
    `dict_name` varchar(45)      DEFAULT NULL,
    `dict_desc` varchar(45)      DEFAULT NULL,
    `eff_time`  timestamp   NULL DEFAULT CURRENT_TIMESTAMP,
    `exp_time`  timestamp   NULL DEFAULT NULL COMMENT '字典项失效时间',
    `status`    enum ('1','0')   DEFAULT '1' COMMENT 'status当前的字典是不是可用 1 可用 0 不可用',
    `ext1`      varchar(45)      DEFAULT NULL,
    `ext2`      varchar(45)      DEFAULT NULL,
    `ext3`      varchar(45)      DEFAULT NULL,
    `ext4`      varchar(45)      DEFAULT NULL,
    `ext5`      varchar(45)      DEFAULT NULL,
    PRIMARY KEY (`dict_id`),
    UNIQUE KEY `dict_code_UNIQUE` (`dict_code`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 2
  DEFAULT CHARSET = utf8;
DROP table if exists com_user.inf_dict_lang;
CREATE TABLE com_user.`inf_dict_lang`
(
    `id`        int(11) NOT NULL AUTO_INCREMENT,
    `dict_code` varchar(45) DEFAULT NULL,
    `dict_name` varchar(45) DEFAULT NULL,
    `locate`    varchar(45) DEFAULT NULL,
    `desc`      varchar(45) DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `code_locate` (`dict_code`, `locate`) /*!80000 INVISIBLE */,
    CONSTRAINT `FK_dict_code` FOREIGN KEY (`dict_code`) REFERENCES com_user.`inf_dict` (`dict_code`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 3
  DEFAULT CHARSET = utf8;
DROP table if exists com_user.inf_dict_item;
CREATE TABLE com_user.`inf_dict_item`
(
    `item_id`    varchar(45) NOT NULL,
    `dict_code`  varchar(45) NOT NULL,
    `item_code`  varchar(45) NOT NULL,
    `item_value` varchar(45)    DEFAULT NULL,
    `item_desc`  varchar(45)    DEFAULT NULL,
    `status`     enum ('1','0') DEFAULT '1',
    `ext1`       varchar(45)    DEFAULT NULL,
    `ext2`       varchar(45)    DEFAULT NULL,
    `ext3`       varchar(45)    DEFAULT NULL,
    `ext4`       varchar(45)    DEFAULT NULL,
    `ext5`       varchar(45)    DEFAULT NULL,
    UNIQUE KEY `combineunique` (`dict_code`, `item_code`),
    UNIQUE KEY `id_UNIQUE` (`item_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
DROP table if exists com_user.inf_dict_item_lang;
CREATE TABLE com_user.`inf_dict_item_lang`
(
    `id`           int(5)      NOT NULL AUTO_INCREMENT,
    `dict_item_id` varchar(45) NOT NULL,
    `item_name`    varchar(45) DEFAULT NULL,
    `locate`       varchar(45) NOT NULL,
    `desc`         varchar(45) DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `FK_item_Id_idx` (`dict_item_id`),
    CONSTRAINT `FK_item_Id` FOREIGN KEY (`dict_item_id`) REFERENCES com_user.`inf_dict_item` (`item_id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 11
  DEFAULT CHARSET = utf8;
commit;


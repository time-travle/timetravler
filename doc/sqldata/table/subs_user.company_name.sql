DROP TABLE IF EXISTS subs_user.company_name;

CREATE TABLE subs_user.company_name
(
    `id`                    INT(10) NOT NULL AUTO_INCREMENT,
    `company_name`          VARCHAR(20) NOT NULL,
    `compang_addr_provence` VARCHAR(20)  DEFAULT NULL,
    `compang_addr_city`     VARCHAR(20)  DEFAULT NULL,
    `compang_addr_country`  VARCHAR(20)  DEFAULT NULL,
    `compang_addr_addrs`    VARCHAR(200) DEFAULT NULL,
    `feel`                  VARCHAR(50)  DEFAULT NULL,
    `ext1`                  VARCHAR(150) DEFAULT NULL,
    PRIMARY KEY (`company_name`),
    KEY                     `id` (`id`)
) ENGINE=INNODB AUTO_INCREMENT=5 DEFAULT CHARSET=gbk;

/*Data for the table `company_name` */

DROP table if exists com_user.sequences;
CREATE TABLE `com_user`.`sequences`
(
    `id_sequences`  INT         NOT NULL,
    `seq_name`      VARCHAR(45) NULL,
    `current_val`   VARCHAR(45) NULL COMMENT '当前值',
    `increment_val` VARCHAR(45) NULL COMMENT '步长',
    PRIMARY KEY (`id_sequences`)
)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8
    COLLATE = utf8_bin;

commit;

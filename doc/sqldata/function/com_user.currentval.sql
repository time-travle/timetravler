/*方式1、*/
CREATE DEFINER=`com_user`@`%` FUNCTION `currentval`(_seq_name varchar(50)) RETURNS int(11)
BEGIN
    declare value integer;
    set value = 0;
select current_val into value from sequences where seq_name = _seq_name;
RETURN value;
END;




/*方式2、 5.7.17-log MySQL Community Server (GPL)*/
DELIMITER $$
CREATE
    /*[DEFINER = { user | CURRENT_USER }]*/
    FUNCTION `com_user`.`currentval`(_seq_name VARCHAR(50))
    RETURNS INT(11)
/*LANGUAGE SQL
| [NOT] DETERMINISTIC
| { CONTAINS SQL | NO SQL | READS SQL DATA | MODIFIES SQL DATA }
| SQL SECURITY { DEFINER | INVOKER }
| COMMENT 'string'*/
BEGIN
		DECLARE VALUE INTEGER;
		SET VALUE = 0;
SELECT current_val INTO VALUE FROM sequences WHERE seq_name = _seq_name;
RETURN VALUE;
END$$
DELIMITER ;
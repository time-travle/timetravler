/*方式1、*/
CREATE DEFINER=`com_user`@`%` FUNCTION `nextval`(v_seq_name varchar(50)) RETURNS int(11)
BEGIN
update sequences set current_val = current_val + increment_val  where seq_name = v_seq_name;
return currentval(v_seq_name);
END;



/*方式2、 5.7.17-log MySQL Community Server (GPL)*/
DELIMITER $$
CREATE
    /*[DEFINER = { user | CURRENT_USER }]*/
    FUNCTION `com_user`.`nextval`(v_seq_name VARCHAR(50))
    RETURNS INT(11)
/*LANGUAGE SQL
| [NOT] DETERMINISTIC
| { CONTAINS SQL | NO SQL | READS SQL DATA | MODIFIES SQL DATA }
| SQL SECURITY { DEFINER | INVOKER }
| COMMENT 'string'*/
BEGIN
UPDATE sequences SET current_val = current_val + increment_val  WHERE seq_name = v_seq_name;
RETURN currentval(v_seq_name);
END$$

DELIMITER ;

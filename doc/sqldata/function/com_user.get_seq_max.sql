drop function if exists com_user.get_seq_max;
CREATE
DEFINER = `com_user`@`%` FUNCTION com_user.get_seq_max(seq_name char(100))
    RETURNS BIGINT
    LANGUAGE SQL
    DETERMINISTIC
    CONTAINS SQL
    SQL SECURITY DEFINER
    COMMENT ''
BEGIN
    DECLARE max BIGINT;
    SET max = 0;
SELECT max_value into max FROM t_sequence WHERE name = seq_name;
RETURN max;
END;
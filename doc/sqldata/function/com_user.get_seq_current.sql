drop function if exists com_user.get_seq_current;
CREATE
DEFINER = `com_user`@`%` FUNCTION com_user.get_seq_current(seq_name char(100))
    RETURNS BIGINT
    LANGUAGE SQL
    DETERMINISTIC
    CONTAINS SQL
    SQL SECURITY DEFINER
    COMMENT ''
BEGIN
    DECLARE current_value BIGINT;
    SET current_value = 0;
SELECT value into current_value FROM t_sequence WHERE name = seq_name;
RETURN current_value;
END;
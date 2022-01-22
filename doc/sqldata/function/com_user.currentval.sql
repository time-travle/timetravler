set global log_bin_trust_function_creators = TRUE;
CREATE
    DEFINER = `com_user`@`%` FUNCTION com_user.currentval(_seq_name varchar(50)) RETURNS int(11)
BEGIN
    declare value integer;
    set value = 0;
    select current_val into value from sequences where seq_name = _seq_name;
    RETURN value;
END


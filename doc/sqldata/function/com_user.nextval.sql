set global log_bin_trust_function_creators = TRUE;
CREATE DEFINER=`com_user`@`%` FUNCTION com_user.`nextval`(v_seq_name varchar(50)) RETURNS int(11)
BEGIN
    update sequences set current_val = current_val + increment_val  where seq_name = v_seq_name;
    return currentval(v_seq_name);
END
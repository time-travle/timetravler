-- test seq
select com_user.get_seq_current('DEFAULT_SEQ');
select com_user.get_seq_max('DEFAULT_SEQ');
select com_user.get_seq_next1('DEFAULT_SEQ');
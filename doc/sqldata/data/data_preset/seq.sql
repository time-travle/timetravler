delete
from com_user.sequences
where id_sequences = 1;
insert into com_user.sequences (id_sequences, seq_name, current_val, increment_val) value (1,'DEFAULT_SEQ',100000,1);

delete
from com_user.t_sequence
where id = 1;
insert into com_user.t_sequence (id, name, value, increment, min_value, max_value, create_time)
    value (1,'DEFAULT_SEQ',99999999,1,10000000,99999999,now());
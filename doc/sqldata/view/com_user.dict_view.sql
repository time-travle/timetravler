CREATE
    ALGORITHM = UNDEFINED
    DEFINER = `com_user`@`%`
    SQL SECURITY DEFINER
VIEW `com_user`.`query_dictitems_view` AS
    SELECT
        `t1`.`dict_code` AS `dict_code`,
        `t1`.`ext1` AS `ext1`,
        `t1`.`ext2` AS `ext2`,
        `t1`.`ext3` AS `ext3`,
        `t1`.`ext4` AS `ext4`,
        `t1`.`ext5` AS `ext5`,
        `t2`.`dict_name` AS `dict_name`,
        `t3`.`item_code` AS `item_code`,
        `t3`.`item_value` AS `item_value`,
        `t4`.`item_name` AS `item_name`,
        `t2`.`locate` AS `locate`,
        `t3`.`ext1` AS `item_ext1`,
        `t3`.`ext2` AS `item_ext2`,
        `t3`.`ext3` AS `item_ext3`,
        `t3`.`ext4` AS `item_ext4`,
        `t3`.`ext5` AS `item_ext5`
    FROM
        (((`com_user`.`inf_dict` `t1`
        JOIN `com_user`.`inf_dict_lang` `t2`)
        JOIN `com_user`.`inf_dict_item` `t3`)
        JOIN `com_user`.`inf_dict_item_lang` `t4`)
    WHERE
        ((`t1`.`dict_code` = `t2`.`dict_code`)
            AND (`t3`.`dict_code` = `t1`.`dict_code`)
            AND (`t3`.`status` = `t1`.`status`)
            AND (`t4`.`locate` = `t2`.`locate`)
            AND (`t4`.`dict_item_id` = `t3`.`item_id`))
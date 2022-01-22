insert into com_user.inf_dict (dict_id, dict_code, dict_name, dict_desc, eff_time, exp_time, status, ext1, ext2, ext3,
                               ext4, ext5)
values (1, 'TestDict', 'TestDict', '模板', '2022-01-17 10:39:23', '2022-01-17 10:39:23', '0', null, null, null, null,
        null);

insert into com_user.inf_dict_lang (id, dict_code, dict_name, locate, desc)
values (1, 'TestDict', 'TestDict', 'en-US', '英语'),
       (2, 'TestDict', '測试', 'zh-TW', '繁体中文'),
       (3, 'TestDict', '测试', 'zh-CN', '简体中文'),
       (4, 'TestDict', 'Prueba', 'es-CO', '哥伦比亚'),
       (5, 'TestDict', 'Ensayo', 'es-EC', '厄瓜多尔'),
       (6, 'TestDict', 'اختبار .', 'ar-EG', '阿拉伯语');

insert into com_user.inf_dict_item (item_id, dict_code, item_code, item_value, item_desc, status, ext1, ext2, ext3,
                                    ext4, ext5)
values ('1', 'TestDict', 'TestDict_1', '1', 'TestDict_1', '1', null, null, null, null, null),
       ('2', 'TestDict', 'TestDict_2', '2', 'TestDict_2', '1', null, null, null, null, null),
       ('3', 'TestDict', 'TestDict_3', '3', 'TestDict_3', '0', null, null, null, null, null),
       ('4', 'TestDict', 'TestDict_4', '4', 'TestDict_4', '0', null, null, null, null, null);

insert into com_user.inf_dict_item_lang (id, dict_item_id, item_name, locate, desc)
values (1, '1', 'TestDict', 'en-US', '英语'),
       (2, '1', '測试', 'zh-TW', '繁体中文'),
       (3, '1', '测试', 'zh-CN', '简体中文'),
       (4, '1', 'Prueba', 'es-CO', '哥伦比亚'),
       (5, '1', 'Ensayo', 'es-EC', '厄瓜多尔'),
       (6, '1', 'اختبار .', 'ar-EG', '阿拉伯语'),
       (7, '2', 'TestDict', 'en-US', '英语'),
       (8, '2', '測试', 'zh-TW', '繁体中文'),
       (9, '2', '测试', 'zh-CN', '简体中文'),
       (10, '2', 'Prueba', 'es-CO', '哥伦比亚'),
       (11, '2', 'Ensayo', 'es-EC', '厄瓜多尔'),
       (12, '2', 'اختبار .', 'ar-EG', '阿拉伯语'),
       (13, '3', 'TestDict', 'en-US', '英语'),
       (14, '3', '測试', 'zh-TW', '繁体中文'),
       (15, '3', '测试', 'zh-CN', '简体中文'),
       (16, '3', 'Prueba', 'es-CO', '哥伦比亚'),
       (17, '3', 'Ensayo', 'es-EC', '厄瓜多尔'),
       (18, '3', 'اختبار .', 'ar-EG', '阿拉伯语'),
       (19, '4', 'TestDict', 'en-US', '英语'),
       (20, '4', '測试', 'zh-TW', '繁体中文'),
       (21, '4', '测试', 'zh-CN', '简体中文'),
       (22, '4', 'Prueba', 'es-CO', '哥伦比亚'),
       (23, '4', 'Ensayo', 'es-EC', '厄瓜多尔'),
       (24, '4', 'اختبار .', 'ar-EG', '阿拉伯语');
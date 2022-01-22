#mysql:
# name:sys_user
DROP USER IF EXISTS 'sys_user'@'%';
CREATE USER 'sys_user'@'%' IDENTIFIED BY 'joven_sys123';

# revoke ALL PRIVILEGES on *.* from 'sys_user'@'%';
GRANT ALL privileges ON *.* TO 'sys_user'@'%';

# name:com_user
CREATE DATABASE IF NOT EXISTS com_user DEFAULT CHARACTER SET utf8 DEFAULT COLLATE utf8_bin;

DROP USER IF EXISTS 'com_user'@'%';
CREATE USER 'com_user'@'%' IDENTIFIED BY 'joven_com123$';

# GRANT privileges ON com_user.* TO 'com_user'@'%';
#或者
# revoke ALL PRIVILEGES on com_user.* from 'com_user'@'%';
GRANT ALL privileges ON com_user.* TO 'com_user'@'%';

# name:system_user
CREATE DATABASE IF NOT EXISTS system_user DEFAULT CHARACTER SET utf8 DEFAULT COLLATE utf8_bin;

DROP USER IF EXISTS 'system_user'@'%';
CREATE USER 'system_user'@'%' IDENTIFIED BY 'joven_system123$';

# revoke ALL privileges on system_user.* from 'system_user'@'%';
GRANT ALL privileges ON system_user.* TO 'system_user'@'%';

# name:subs_user
CREATE DATABASE IF NOT EXISTS subs_user DEFAULT CHARACTER SET utf8 DEFAULT COLLATE utf8_bin;

DROP USER IF EXISTS 'subs_user'@'%';
CREATE USER 'subs_user'@'%' IDENTIFIED BY 'joven_subs123$';

# revoke ALL PRIVILEGES on subs_user.* from 'subs_user'@'%';
GRANT ALL privileges ON subs_user.* TO 'subs_user'@'%';

# name:schedule_user
CREATE DATABASE IF NOT EXISTS schedule_user DEFAULT CHARACTER SET utf8 DEFAULT COLLATE utf8_bin;

DROP USER IF EXISTS 'schedule_user'@'%';
CREATE USER 'schedule_user'@'%' IDENTIFIED BY 'joven_schedule123$';

# revoke ALL PRIVILEGES on schedule_user.* from 'schedule_user'@'%';
GRANT ALL privileges ON schedule_user.* TO 'schedule_user'@'%';

# name:prod_user
CREATE DATABASE IF NOT EXISTS prod_user DEFAULT CHARACTER SET utf8 DEFAULT COLLATE utf8_bin;

DROP USER IF EXISTS 'prod_user'@'%';
CREATE USER 'prod_user'@'%' IDENTIFIED BY 'joven_prod123$';

# revoke ALL PRIVILEGES on prod_user.* from 'prod_user'@'%';
GRANT ALL privileges ON prod_user.* TO 'prod_user'@'%';

# name:acct_user
CREATE DATABASE IF NOT EXISTS acct_user DEFAULT CHARACTER SET utf8 DEFAULT COLLATE utf8_bin;

DROP USER IF EXISTS 'acct_user'@'%';
CREATE USER 'acct_user'@'%' IDENTIFIED BY 'joven_acct123$';

# revoke ALL PRIVILEGES on acct_user.* from 'acct_user'@'%';
GRANT ALL privileges ON acct_user.* TO 'acct_user'@'%';

# name:cust_user
CREATE DATABASE IF NOT EXISTS cust_user DEFAULT CHARACTER SET utf8 DEFAULT COLLATE utf8_bin;
DROP USER IF EXISTS 'cust_user'@'%';
CREATE USER 'cust_user'@'%' IDENTIFIED BY 'joven_cust123$';

# revoke ALL PRIVILEGES on cust_user.* from 'cust_user'@'%';
GRANT ALL privileges ON cust_user.* TO 'cust_user'@'%';

# name:order_user
CREATE DATABASE IF NOT EXISTS order_user DEFAULT CHARACTER SET utf8 DEFAULT COLLATE utf8_bin;
DROP USER IF EXISTS 'order_user'@'%';
CREATE USER 'order_user'@'%' IDENTIFIED BY 'joven_order123$';

# revoke ALL PRIVILEGES on order_user.* from 'order_user'@'%';
GRANT ALL privileges ON order_user.* TO 'order_user'@'%';

# name:party_user
CREATE DATABASE IF NOT EXISTS party_user DEFAULT CHARACTER SET utf8 DEFAULT COLLATE utf8_bin;
DROP USER IF EXISTS 'party_user'@'%';
CREATE USER 'party_user'@'%' IDENTIFIED BY 'joven_party123$';

# revoke ALL PRIVILEGES on party_user.* from 'party_user'@'%';
GRANT ALL privileges ON party_user.* TO 'party_user'@'%';

# name:addr_user
CREATE DATABASE IF NOT EXISTS addr_user DEFAULT CHARACTER SET utf8 DEFAULT COLLATE utf8_bin;
DROP USER IF EXISTS 'addr_user'@'%';
CREATE USER 'addr_user'@'%' IDENTIFIED BY 'joven_addr123$';

# revoke ALL PRIVILEGES on addr_user.* from 'addr_user'@'%';
GRANT ALL privileges ON addr_user.* TO 'addr_user'@'%';

# grant all privileges on 库名.表名 to '用户名'@'IP地址' identified by '密码' with grant option;
flush privileges;
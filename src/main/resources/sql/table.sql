create table customer_mapping (
  id int(11) primary key auto_increment,
  customer_id int(11),
  year int(11),
  db_name varchar(16) comment '数据库名称'
);

CREATE TABLE `admin_user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_name` varchar(16) NOT NULL COMMENT '用户名称',
  `login_name` varchar(32) NOT NULL COMMENT '登录名',
  `login_pwd` varchar(32) NOT NULL COMMENT '登录密码',
  `ctime` timestamp NOT NULL DEFAULT current_timestamp(),
  `ltime` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `customer_id` int(11) NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_login_name` (`login_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='运营后台用户信息表'
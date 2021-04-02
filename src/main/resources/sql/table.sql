create table customer_mapping (
  id int(11) primary key auto_increment,
  customer_id int(11),
  year int(11),
  db_name varchar(16) comment '数据库名称'
);

create table t_order (
  id          int(11) primary key auto_increment,
  customer_id int(11),
  year        int(11),
  order_no    char(32) comment '订单号',
  `ctime`     timestamp NOT NULL  DEFAULT current_timestamp(),
  `ltime`     timestamp NOT NULL  DEFAULT current_timestamp()
  ON UPDATE current_timestamp()
);
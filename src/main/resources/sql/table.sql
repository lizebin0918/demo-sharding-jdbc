create table customer_mapping (
  id int(11) primary key auto_increment,
  customer_id int(11),
  year int(11),
  db_name varchar(16) comment '数据库名称'
);

create database db0;

create table t_order
(
  id          int auto_increment
    primary key,
  customer_id int                                   null,
  year        int                                   null,
  order_no    char(32)                              null comment '订单号',
  ctime       timestamp default current_timestamp() not null,
  ltime       timestamp default current_timestamp() not null on update current_timestamp()
);

create table t_order_1_2016
(
  id          int auto_increment
    primary key,
  customer_id int                                   null,
  year        int                                   null,
  order_no    char(32)                              null comment '订单号',
  ctime       timestamp default current_timestamp() not null,
  ltime       timestamp default current_timestamp() not null on update current_timestamp()
);

create table t_order_1_2017
(
  id          int auto_increment
    primary key,
  customer_id int                                   null,
  year        int                                   null,
  order_no    char(32)                              null comment '订单号',
  ctime       timestamp default current_timestamp() not null,
  ltime       timestamp default current_timestamp() not null on update current_timestamp()
);

create table t_order_1_2018
(
  id          int auto_increment
    primary key,
  customer_id int                                   null,
  year        int                                   null,
  order_no    char(32)                              null comment '订单号',
  ctime       timestamp default current_timestamp() not null,
  ltime       timestamp default current_timestamp() not null on update current_timestamp()
);

create table t_order_1_2019
(
  id          int auto_increment
    primary key,
  customer_id int                                   null,
  year        int                                   null,
  order_no    char(32)                              null comment '订单号',
  ctime       timestamp default current_timestamp() not null,
  ltime       timestamp default current_timestamp() not null on update current_timestamp()
);

create table t_order_1_2020
(
  id          int auto_increment
    primary key,
  customer_id int                                   null,
  year        int                                   null,
  order_no    char(32)                              null comment '订单号',
  ctime       timestamp default current_timestamp() not null,
  ltime       timestamp default current_timestamp() not null on update current_timestamp()
);

create table t_order_1_2021
(
  id          int auto_increment
    primary key,
  customer_id int                                   null,
  year        int                                   null,
  order_no    char(32)                              null comment '订单号',
  ctime       timestamp default current_timestamp() not null,
  ltime       timestamp default current_timestamp() not null on update current_timestamp()
);

create table t_order_2_2016
(
  id          int auto_increment
    primary key,
  customer_id int                                   null,
  year        int                                   null,
  order_no    char(32)                              null comment '订单号',
  ctime       timestamp default current_timestamp() not null,
  ltime       timestamp default current_timestamp() not null on update current_timestamp()
);

create table t_order_2_2017
(
  id          int auto_increment
    primary key,
  customer_id int                                   null,
  year        int                                   null,
  order_no    char(32)                              null comment '订单号',
  ctime       timestamp default current_timestamp() not null,
  ltime       timestamp default current_timestamp() not null on update current_timestamp()
);

create table t_order_2_2018
(
  id          int auto_increment
    primary key,
  customer_id int                                   null,
  year        int                                   null,
  order_no    char(32)                              null comment '订单号',
  ctime       timestamp default current_timestamp() not null,
  ltime       timestamp default current_timestamp() not null on update current_timestamp()
);

create table t_order_2_2019
(
  id          int auto_increment
    primary key,
  customer_id int                                   null,
  year        int                                   null,
  order_no    char(32)                              null comment '订单号',
  ctime       timestamp default current_timestamp() not null,
  ltime       timestamp default current_timestamp() not null on update current_timestamp()
);

create table t_order_2_2020
(
  id          int auto_increment
    primary key,
  customer_id int                                   null,
  year        int                                   null,
  order_no    char(32)                              null comment '订单号',
  ctime       timestamp default current_timestamp() not null,
  ltime       timestamp default current_timestamp() not null on update current_timestamp()
);

create table t_order_2_2021
(
  id          int auto_increment
    primary key,
  customer_id int                                   null,
  year        int                                   null,
  order_no    char(32)                              null comment '订单号',
  ctime       timestamp default current_timestamp() not null,
  ltime       timestamp default current_timestamp() not null on update current_timestamp()
);

create database db1;

create table t_order
(
  id          int auto_increment
    primary key,
  customer_id int                                   null,
  year        int                                   null,
  order_no    char(32)                              null comment '订单号',
  ctime       timestamp default current_timestamp() not null,
  ltime       timestamp default current_timestamp() not null on update current_timestamp()
);

create table t_order_3_2016
(
  id          int auto_increment
    primary key,
  customer_id int                                   null,
  year        int                                   null,
  order_no    char(32)                              null comment '订单号',
  ctime       timestamp default current_timestamp() not null,
  ltime       timestamp default current_timestamp() not null on update current_timestamp()
);

create table t_order_3_2017
(
  id          int auto_increment
    primary key,
  customer_id int                                   null,
  year        int                                   null,
  order_no    char(32)                              null comment '订单号',
  ctime       timestamp default current_timestamp() not null,
  ltime       timestamp default current_timestamp() not null on update current_timestamp()
);

create table t_order_3_2018
(
  id          int auto_increment
    primary key,
  customer_id int                                   null,
  year        int                                   null,
  order_no    char(32)                              null comment '订单号',
  ctime       timestamp default current_timestamp() not null,
  ltime       timestamp default current_timestamp() not null on update current_timestamp()
);

create table t_order_3_2019
(
  id          int auto_increment
    primary key,
  customer_id int                                   null,
  year        int                                   null,
  order_no    char(32)                              null comment '订单号',
  ctime       timestamp default current_timestamp() not null,
  ltime       timestamp default current_timestamp() not null on update current_timestamp()
);

create table t_order_3_2020
(
  id          int auto_increment
    primary key,
  customer_id int                                   null,
  year        int                                   null,
  order_no    char(32)                              null comment '订单号',
  ctime       timestamp default current_timestamp() not null,
  ltime       timestamp default current_timestamp() not null on update current_timestamp()
);

create table t_order_3_2021
(
  id          int auto_increment
    primary key,
  customer_id int                                   null,
  year        int                                   null,
  order_no    char(32)                              null comment '订单号',
  ctime       timestamp default current_timestamp() not null,
  ltime       timestamp default current_timestamp() not null on update current_timestamp()
);

create table t_order_4_2016
(
  id          int auto_increment
    primary key,
  customer_id int                                   null,
  year        int                                   null,
  order_no    char(32)                              null comment '订单号',
  ctime       timestamp default current_timestamp() not null,
  ltime       timestamp default current_timestamp() not null on update current_timestamp()
);

create table t_order_4_2017
(
  id          int auto_increment
    primary key,
  customer_id int                                   null,
  year        int                                   null,
  order_no    char(32)                              null comment '订单号',
  ctime       timestamp default current_timestamp() not null,
  ltime       timestamp default current_timestamp() not null on update current_timestamp()
);

create table t_order_4_2018
(
  id          int auto_increment
    primary key,
  customer_id int                                   null,
  year        int                                   null,
  order_no    char(32)                              null comment '订单号',
  ctime       timestamp default current_timestamp() not null,
  ltime       timestamp default current_timestamp() not null on update current_timestamp()
);

create table t_order_4_2019
(
  id          int auto_increment
    primary key,
  customer_id int                                   null,
  year        int                                   null,
  order_no    char(32)                              null comment '订单号',
  ctime       timestamp default current_timestamp() not null,
  ltime       timestamp default current_timestamp() not null on update current_timestamp()
);

create table t_order_4_2020
(
  id          int auto_increment
    primary key,
  customer_id int                                   null,
  year        int                                   null,
  order_no    char(32)                              null comment '订单号',
  ctime       timestamp default current_timestamp() not null,
  ltime       timestamp default current_timestamp() not null on update current_timestamp()
);

create table t_order_4_2021
(
  id          int auto_increment
    primary key,
  customer_id int                                   null,
  year        int                                   null,
  order_no    char(32)                              null comment '订单号',
  ctime       timestamp default current_timestamp() not null,
  ltime       timestamp default current_timestamp() not null on update current_timestamp()
);


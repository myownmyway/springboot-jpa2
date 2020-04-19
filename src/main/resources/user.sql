create database jpa;
use jpa;
select database();
create table if not exists `user`
(
    id        int(11) auto_increment primary key comment '主键，用户id',
    last_name varchar(255) comment '姓名'
) engine = InnoDB
  charset = utf8 comment ='用户表';
insert into `user`(last_name)
values ("zhangsan");
insert into `user`(last_name)
values ("zhangsan2");
insert into `user`(last_name)
values ("zhangsan3");
insert into `user`(last_name)
values ("zhangsan4");
insert into `user`(last_name)
values ("zhangsan5");
insert into `user`(last_name)
values ("zhangsan6");
insert into `user`(last_name)
values ("zhangsan7");
insert into `user`(last_name)
values ("zhangsan8");
insert into `user`(last_name)
values ("zhangsan9");
insert into `user`(last_name)
values ("zhangsan10");
insert into `user`(last_name)
values ("zhangsan11");
insert into `user`(last_name)
values ("zhangsan12");
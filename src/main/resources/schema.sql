drop database if exists `myblog`;
create database `myblog`;
use `myblog`;

drop table if exists `t_article`;
create table `t_article`(
`id` bigint(20)  AUTO_INCREMENT COMMENT '主键',
`author` varchar(20) not null COMMENT '作者',
`title` varchar(20) not null COMMENT '标题',
`content` varchar(512) not null COMMENT '内容',
`create_time` TIMESTAMP COMMENT '创建时间',
`refresh_time` TIMESTAMP COMMENT '修改时间',
primary key (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文章表';


insert into
    t_article
    (author, title, content,create_time,refresh_time)
    values
    ('leon','this is a title','this is a context',NOW(),NOW()),
    ('礼敖','一个博客','一个内容',NOW(),NOW());
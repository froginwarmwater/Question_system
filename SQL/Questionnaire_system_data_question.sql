create table question
(
    id        int unsigned auto_increment
        primary key,
    content   varchar(255) default ''  not null comment '问题描述',
    invest_id int unsigned default '0' not null comment ' 问卷号'
)
    comment '问题表' charset = utf8;


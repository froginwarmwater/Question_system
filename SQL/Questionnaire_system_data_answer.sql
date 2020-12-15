create table answer
(
    id          int unsigned auto_increment
        primary key,
    content     varchar(255) default ''  not null comment '答案描述',
    question_id int unsigned default '0' not null comment '问题id'
)
    comment '答案表' charset = utf8;


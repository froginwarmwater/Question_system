create table statistic
(
    id          int unsigned auto_increment
        primary key,
    invest_id   int unsigned default '0' not null comment '问卷id',
    question_id int unsigned default '0' not null comment '问题id',
    answer_id   int unsigned default '0' not null comment '回答id',
    user_id     int unsigned default '0' not null comment '用户id',
    created     int unsigned default '0' not null
)
    comment '问卷统计' charset = utf8;


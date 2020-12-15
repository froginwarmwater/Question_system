create table invest
(
    id      int unsigned auto_increment
        primary key,
    title   varchar(255) default ''                not null comment '问卷标题',
    status  int unsigned default '1'               not null comment '问卷状态',
    created timestamp    default CURRENT_TIMESTAMP not null
)
    comment '问卷表' charset = utf8;


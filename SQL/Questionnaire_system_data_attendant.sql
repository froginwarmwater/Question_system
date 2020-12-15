create table attendant
(
    idno     varchar(50) charset utf8 not null
        primary key,
    pwd      varchar(50) charset utf8 not null,
    username varchar(50) charset utf8 null
)
    comment '管理员';

INSERT INTO Questionnaire_system_data.attendant (idno, pwd, username) VALUES ('13918789035', '123456', '周平');
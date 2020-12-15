create table member
(
    idno     int auto_increment
        primary key,
    tel      varchar(50) charset utf8 null,
    pwd      varchar(50) charset utf8 not null,
    username varchar(50) charset utf8 null,
    email    varchar(50) charset utf8 not null,
    constraint member_email_uindex
        unique (email),
    constraint member_tel_uindex
        unique (tel)
)
    comment '用户';

INSERT INTO Questionnaire_system_data.member (tel, pwd, username, email) VALUES ('15419872211', '123456', '朱蔡', '1541987221@qq.com');
INSERT INTO Questionnaire_system_data.member (tel, pwd, username, email) VALUES ('13918789035', '123456', '爱最终会消失对吗', '1541987222@qq.com');
INSERT INTO Questionnaire_system_data.member (tel, pwd, username, email) VALUES ('13761187715', '123456', '爸爸', '969221@163.com');
INSERT INTO Questionnaire_system_data.member (tel, pwd, username, email) VALUES ('13918789039', '123456', 'root', '1541987223@qq.com');
INSERT INTO Questionnaire_system_data.member (tel, pwd, username, email) VALUES ('13918789966', '123456', 'root', '1541987221@163.com');
INSERT INTO Questionnaire_system_data.member (tel, pwd, username, email) VALUES ('13918789967', '123456', 'root', '1541987223@163.com');
INSERT INTO Questionnaire_system_data.member (tel, pwd, username, email) VALUES ('13603532980', 'zcssb', '朱蔡是傻逼', 'zcssb@qq.com');
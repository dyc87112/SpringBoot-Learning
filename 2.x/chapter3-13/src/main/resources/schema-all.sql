create table test.user_info
(
    id          int unsigned auto_increment comment '用户id'
        primary key,
    open_id     varchar(255)     default '' null comment '微信小程序openid',
    nick_name   varchar(255)     default '' null comment '微信名',
    head_img    varchar(255)     default '' null comment '微信头像',
    sex         varchar(255)     default '' null comment '性别',
    phone       varchar(255)     default '' null comment '手机',
    province    varchar(255)     default '' null comment '注册地址：省',
    city        varchar(255)     default '' null comment '注册地址：城市',
    country     varchar(255)     default '' null comment '注册地址：县/区',
    status      tinyint unsigned default 0  not null comment '是否标记删除 0：否 1：是',
    create_time datetime                    not null comment '创建时间',
    update_time datetime                    not null comment '更新时间'
)
    comment '用户表';


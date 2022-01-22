drop table if exists schedule_user.schedule_job;
CREATE TABLE schedule_user.schedule_job
(
    `id`          int UNSIGNED                                                  NOT NULL AUTO_INCREMENT,
    `task_id`     varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  NOT NULL COMMENT '任务id',
    `cron`        varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  NOT NULL COMMENT 'cron表达式',
    `job_name`    varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'job名字',
    `bean_name`   varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT 'job使用的bean触发的地址',
    `class_name`  varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT 'job引用地址',
    `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '描述',
    `status`      tinyint                                                       NOT NULL COMMENT '定时任务状态 0 停用,1启用',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE INDEX `task_id_UNIQUE` (`task_id` ASC) VISIBLE
) comment '监控任务的任务'
    ENGINE = InnoDB
    CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci
    ROW_FORMAT = Dynamic;
SET FOREIGN_KEY_CHECKS = 1;

-- 初始化一个两个dedmo
INSERT INTO `schedule_user`.`schedule_job` (`task_id`, `cron`, `job_name`, `bean_name`, `class_name`, `description`,
                                            `status`)
VALUES ('test_1', '*/5 * * * * ?', 'TestBeanJob', 'TestBeanJob', null, 'TestBeanJob', '1'),
       ('test_2', '*/10 * * * * ?', 'TestClassJob', null, 'org.joven.schedule.task.TestClassJob', 'TestClassJob', '1'),
       ('202107302118001', '*/10 * * * * ?', 'refreshOrInitJob', null, 'org.joven.schedule.init.RefreshAutoQuartzJob',
        '用来监控任务的任务', '1');


-- 定时任务
drop table if exists schedule_user.quartz_job;
create table schedule_user.quartz_job
(
    id                   bigint           not null comment 'id'
        primary key,
    job_name             varchar(200)     null comment '定时任务名称',
    group_name           varchar(200)     null comment '定时任务分组' default 'default',
    bean_name            varchar(200)     null comment '定时任务对应的spring bean名称',
    class_name           varchar(200)     null comment '定时任务对应的spring class名称',
    params               varchar(2000)    null comment '参数',
    cron_expression      varchar(100)     not null comment 'cron表达式',
    restart_on_app_start tinyint unsigned not null comment '应用重启时任务是否重启  0：保持  1：重启',
    status               tinyint unsigned not null comment '任务状态  0：暂停  1：正常',
    remark               varchar(255)     null comment '备注',
    creator              bigint           null comment '创建者',
    create_date          datetime         null comment '创建时间',
    updater              bigint           null comment '更新者',
    update_date          datetime         null comment '更新时间'
) comment '定时任务';

create
    index idx_create_date on schedule_user.quartz_job (create_date);

-- 定时任务日志
drop table if exists schedule_user.quartz_job_log;
create table schedule_user.quartz_job_log
(
    id          bigint           not null comment 'id',
    job_id      bigint           not null comment '任务id',
    job_name    varchar(200)     null comment '定时任务名称',
    class_name  varchar(200)     null comment 'spring class名称',
    bean_name   varchar(200)     null comment 'spring bean名称',
    params      varchar(2000)    null comment '参数',
    status      tinyint unsigned not null comment '任务状态    0：失败    1：成功',
    error       varchar(2000)    null comment '失败信息',
    times       int              not null comment '耗时(单位：毫秒)',
    create_date datetime         null comment '创建时间',
    constraint `index`
        unique (id)
) comment '定时任务日志';

create
    index idx_create_date
    on schedule_user.quartz_job_log (create_date);

create
    index idx_job_id
    on schedule_user.quartz_job_log (job_id);

alter table schedule_user.quartz_job_log
    add primary key (id);
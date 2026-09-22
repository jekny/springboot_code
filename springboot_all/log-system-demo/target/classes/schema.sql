-- 日志系统数据库建表脚本

-- 日志表 (F-01 日志采集 / F-02 日志存储 / F-03 日志检索)
CREATE TABLE IF NOT EXISTS sys_log (
    id          BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '主键ID',
    app_name    VARCHAR(100)  NOT NULL COMMENT '应用名称',
    log_level   VARCHAR(20)   NOT NULL COMMENT '日志级别: DEBUG/INFO/WARN/ERROR/FATAL',
    trace_id    VARCHAR(100)  DEFAULT NULL COMMENT '链路追踪ID',
    content     TEXT          NOT NULL COMMENT '日志内容',
    create_time DATETIME      NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '日志产生时间',
    INDEX idx_app_name (app_name),
    INDEX idx_log_level (log_level),
    INDEX idx_create_time (create_time),
    INDEX idx_trace_id (trace_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='日志表';

-- 告警规则表 (F-04 告警功能)
CREATE TABLE IF NOT EXISTS alert_rule (
    id          BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '主键ID',
    rule_name   VARCHAR(100)  NOT NULL COMMENT '规则名称',
    keyword     VARCHAR(200)  NOT NULL COMMENT '匹配关键字',
    log_level   VARCHAR(20)   DEFAULT NULL COMMENT '日志级别过滤(可空)',
    threshold   INT           DEFAULT 1 COMMENT '触发阈值(条数)',
    time_window INT           DEFAULT 5 COMMENT '时间窗口(分钟)',
    alert_level VARCHAR(10)  DEFAULT 'P3' COMMENT '告警级别: P1紧急/P2重要/P3一般',
    enabled     TINYINT       DEFAULT 1 COMMENT '是否启用: 0-禁用 1-启用',
    create_time DATETIME      NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time DATETIME      NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='告警规则表';

-- 插入示例告警规则
INSERT INTO alert_rule (rule_name, keyword, log_level, threshold, time_window, alert_level, enabled)
SELECT 'ERROR关键字告警', 'ERROR', 'ERROR', 100, 5, 'P2', 1
WHERE NOT EXISTS (SELECT 1 FROM alert_rule WHERE rule_name = 'ERROR关键字告警');

INSERT INTO alert_rule (rule_name, keyword, log_level, threshold, time_window, alert_level, enabled)
SELECT 'Exception异常告警', 'Exception', NULL, 1, 5, 'P1', 1
WHERE NOT EXISTS (SELECT 1 FROM alert_rule WHERE rule_name = 'Exception异常告警');

-- 插入示例日志数据
INSERT INTO sys_log (app_name, log_level, trace_id, content)
SELECT 'order-service', 'INFO', 'trace-001', '订单创建成功, orderId=10001'
WHERE NOT EXISTS (SELECT 1 FROM sys_log WHERE trace_id = 'trace-001');

INSERT INTO sys_log (app_name, log_level, trace_id, content)
SELECT 'order-service', 'ERROR', 'trace-001', '订单支付失败: 连接支付网关超时'
WHERE NOT EXISTS (SELECT 1 FROM sys_log WHERE content = '订单支付失败: 连接支付网关超时');

INSERT INTO sys_log (app_name, log_level, trace_id, content)
SELECT 'user-service', 'WARN', 'trace-002', '用户登录重试次数过多, userId=20001'
WHERE NOT EXISTS (SELECT 1 FROM sys_log WHERE content = '用户登录重试次数过多, userId=20001');

INSERT INTO sys_log (app_name, log_level, trace_id, content)
SELECT 'user-service', 'ERROR', 'trace-003', 'NullPointerException at UserService.login(line:45)'
WHERE NOT EXISTS (SELECT 1 FROM sys_log WHERE content = 'NullPointerException at UserService.login(line:45)');

INSERT INTO sys_log (app_name, log_level, trace_id, content)
SELECT 'payment-service', 'INFO', 'trace-004', '支付回调处理完成, paymentId=30001'
WHERE NOT EXISTS (SELECT 1 FROM sys_log WHERE content = '支付回调处理完成, paymentId=30001');

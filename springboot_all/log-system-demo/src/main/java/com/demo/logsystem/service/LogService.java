package com.demo.logsystem.service;

import com.demo.logsystem.common.PageResult;
import com.demo.logsystem.entity.AlertRule;
import com.demo.logsystem.entity.SysLog;
import com.demo.logsystem.mapper.AlertRuleMapper;
import com.demo.logsystem.mapper.LogMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogService {

    private static final Logger log = LoggerFactory.getLogger(LogService.class);

    private final LogMapper logMapper;
    private final AlertRuleMapper alertRuleMapper;

    public LogService(LogMapper logMapper, AlertRuleMapper alertRuleMapper) {
        this.logMapper = logMapper;
        this.alertRuleMapper = alertRuleMapper;
    }

    /** F-01 日志采集: 接收并存储日志 */
    public void ingestLog(SysLog sysLog) {
        if (sysLog.getAppName() == null || sysLog.getAppName().isEmpty()) {
            sysLog.setAppName("default");
        }
        if (sysLog.getLogLevel() == null || sysLog.getLogLevel().isEmpty()) {
            sysLog.setLogLevel("INFO");
        }
        logMapper.insert(sysLog);

        // F-04 告警检查: 日志入库后检查是否触发告警规则
        checkAlert(sysLog);
    }

    /** F-03 日志检索: 多条件分页查询 */
    public PageResult<SysLog> searchLogs(String keyword, String appName,
                                         String logLevel, String traceId,
                                         String startTime, String endTime,
                                         int page, int size) {
        if (page < 1) page = 1;
        if (size < 1) size = 10;
        int offset = (page - 1) * size;

        List<SysLog> list = logMapper.searchLogs(keyword, appName, logLevel,
                traceId, startTime, endTime, offset, size);
        long total = logMapper.countLogs(keyword, appName, logLevel,
                traceId, startTime, endTime);

        return new PageResult<>(list, total, page, size);
    }

    /** 根据ID查询单条日志 */
    public SysLog getLogById(Long id) {
        return logMapper.selectById(id);
    }

    /** F-03-4 链路查询: 根据trace_id查询完整调用链 */
    public List<SysLog> getLogsByTraceId(String traceId) {
        return logMapper.selectByTraceId(traceId);
    }

    /** F-03-3 上下文查询: 查看某条日志前后N条 */
    public List<SysLog> getLogContext(Long id, int before, int after) {
        return logMapper.selectContext(id, before, after);
    }

    /** F-04 告警检查: 简单关键字匹配告警 */
    private void checkAlert(SysLog sysLog) {
        List<AlertRule> rules = alertRuleMapper.selectEnabledRules();
        if (rules == null) return;

        for (AlertRule rule : rules) {
            if (sysLog.getContent() != null
                    && sysLog.getContent().contains(rule.getKeyword())) {
                if (rule.getLogLevel() != null && !rule.getLogLevel().isEmpty()) {
                    if (!rule.getLogLevel().equals(sysLog.getLogLevel())) {
                        continue;
                    }
                }
                log.warn("[告警触发] 级别={} 规则={} 关键字={} 应用={} 内容={}",
                        rule.getAlertLevel(),
                        rule.getRuleName(),
                        rule.getKeyword(),
                        sysLog.getAppName(),
                        sysLog.getContent());
            }
        }
    }
}

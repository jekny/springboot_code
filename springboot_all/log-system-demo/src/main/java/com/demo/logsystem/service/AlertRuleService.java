package com.demo.logsystem.service;

import com.demo.logsystem.entity.AlertRule;
import com.demo.logsystem.mapper.AlertRuleMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlertRuleService {

    private final AlertRuleMapper alertRuleMapper;

    public AlertRuleService(AlertRuleMapper alertRuleMapper) {
        this.alertRuleMapper = alertRuleMapper;
    }

    /** F-04 新增告警规则 */
    public void createRule(AlertRule rule) {
        if (rule.getEnabled() == null) {
            rule.setEnabled(1);
        }
        if (rule.getThreshold() == null) {
            rule.setThreshold(1);
        }
        if (rule.getTimeWindow() == null) {
            rule.setTimeWindow(5);
        }
        if (rule.getAlertLevel() == null) {
            rule.setAlertLevel("P3");
        }
        alertRuleMapper.insert(rule);
    }

    /** 修改告警规则 */
    public void updateRule(AlertRule rule) {
        alertRuleMapper.update(rule);
    }

    /** 删除告警规则 */
    public void deleteRule(Long id) {
        alertRuleMapper.deleteById(id);
    }

    /** 查询单条告警规则 */
    public AlertRule getRuleById(Long id) {
        return alertRuleMapper.selectById(id);
    }

    /** 查询所有告警规则 */
    public List<AlertRule> getAllRules() {
        return alertRuleMapper.selectAll();
    }

    /** 查询启用的告警规则 */
    public List<AlertRule> getEnabledRules() {
        return alertRuleMapper.selectEnabledRules();
    }
}

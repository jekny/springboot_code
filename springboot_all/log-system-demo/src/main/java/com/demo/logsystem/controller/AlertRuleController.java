package com.demo.logsystem.controller;

import com.demo.logsystem.common.Result;
import com.demo.logsystem.entity.AlertRule;
import com.demo.logsystem.service.AlertRuleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alert-rules")
public class AlertRuleController {

    private final AlertRuleService alertRuleService;

    public AlertRuleController(AlertRuleService alertRuleService) {
        this.alertRuleService = alertRuleService;
    }

    /** F-04 新增告警规则 */
    @PostMapping
    public Result<String> createRule(@RequestBody AlertRule rule) {
        alertRuleService.createRule(rule);
        return Result.success("告警规则创建成功");
    }

    /** 修改告警规则 */
    @PutMapping("/{id}")
    public Result<String> updateRule(@PathVariable Long id, @RequestBody AlertRule rule) {
        rule.setId(id);
        alertRuleService.updateRule(rule);
        return Result.success("告警规则修改成功");
    }

    /** 删除告警规则 */
    @DeleteMapping("/{id}")
    public Result<String> deleteRule(@PathVariable Long id) {
        alertRuleService.deleteRule(id);
        return Result.success("告警规则删除成功");
    }

    /** 查询单条告警规则 */
    @GetMapping("/{id}")
    public Result<AlertRule> getRuleById(@PathVariable Long id) {
        AlertRule rule = alertRuleService.getRuleById(id);
        if (rule == null) {
            return Result.error("规则不存在");
        }
        return Result.success(rule);
    }

    /** 查询所有告警规则 */
    @GetMapping
    public Result<List<AlertRule>> getAllRules() {
        List<AlertRule> list = alertRuleService.getAllRules();
        return Result.success(list);
    }
}

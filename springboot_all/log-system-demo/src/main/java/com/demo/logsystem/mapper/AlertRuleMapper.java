package com.demo.logsystem.mapper;

import com.demo.logsystem.entity.AlertRule;

import java.util.List;

public interface AlertRuleMapper {

    void insert(AlertRule rule);

    void update(AlertRule rule);

    void deleteById(Long id);

    AlertRule selectById(Long id);

    List<AlertRule> selectAll();

    List<AlertRule> selectEnabledRules();
}

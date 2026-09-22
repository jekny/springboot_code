package com.demo.logsystem.controller;

import com.demo.logsystem.common.PageResult;
import com.demo.logsystem.common.Result;
import com.demo.logsystem.entity.SysLog;
import com.demo.logsystem.service.LogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/logs")
public class LogController {

    private final LogService logService;

    public LogController(LogService logService) {
        this.logService = logService;
    }

    /** F-01 日志采集: 接收日志 (HTTP主动上报) */
    @PostMapping
    public Result<String> ingestLog(@RequestBody SysLog sysLog) {
        logService.ingestLog(sysLog);
        return Result.success("日志采集成功");
    }

    /** F-03 日志检索: 多条件分页查询 */
    @GetMapping
    public Result<PageResult<SysLog>> searchLogs(
            @RequestParam(required = false) String keyword,
            @RequestParam(required = false) String appName,
            @RequestParam(required = false) String logLevel,
            @RequestParam(required = false) String traceId,
            @RequestParam(required = false) String startTime,
            @RequestParam(required = false) String endTime,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size) {
        PageResult<SysLog> result = logService.searchLogs(
                keyword, appName, logLevel, traceId, startTime, endTime, page, size);
        return Result.success(result);
    }

    /** 根据ID查询单条日志 */
    @GetMapping("/{id}")
    public Result<SysLog> getLogById(@PathVariable Long id) {
        SysLog sysLog = logService.getLogById(id);
        if (sysLog == null) {
            return Result.error("日志不存在");
        }
        return Result.success(sysLog);
    }

    /** F-03-4 链路查询: 根据trace_id查询完整调用链 */
    @GetMapping("/trace/{traceId}")
    public Result<List<SysLog>> getLogsByTraceId(@PathVariable String traceId) {
        List<SysLog> list = logService.getLogsByTraceId(traceId);
        return Result.success(list);
    }

    /** F-03-3 上下文查询: 查看某条日志前后N条 */
    @GetMapping("/{id}/context")
    public Result<List<SysLog>> getLogContext(
            @PathVariable Long id,
            @RequestParam(defaultValue = "5") int before,
            @RequestParam(defaultValue = "5") int after) {
        List<SysLog> list = logService.getLogContext(id, before, after);
        return Result.success(list);
    }
}

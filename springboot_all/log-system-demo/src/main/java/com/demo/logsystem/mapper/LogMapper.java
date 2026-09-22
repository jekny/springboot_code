package com.demo.logsystem.mapper;

import com.demo.logsystem.entity.SysLog;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface LogMapper {

    void insert(SysLog log);

    List<SysLog> searchLogs(@Param("keyword") String keyword,
                             @Param("appName") String appName,
                             @Param("logLevel") String logLevel,
                             @Param("traceId") String traceId,
                             @Param("startTime") String startTime,
                             @Param("endTime") String endTime,
                             @Param("offset") int offset,
                             @Param("size") int size);

    long countLogs(@Param("keyword") String keyword,
                   @Param("appName") String appName,
                   @Param("logLevel") String logLevel,
                   @Param("traceId") String traceId,
                   @Param("startTime") String startTime,
                   @Param("endTime") String endTime);

    SysLog selectById(Long id);

    List<SysLog> selectByTraceId(String traceId);

    List<SysLog> selectContext(@Param("id") Long id,
                               @Param("before") int before,
                               @Param("after") int after);
}

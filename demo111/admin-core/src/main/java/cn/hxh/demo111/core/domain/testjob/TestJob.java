package cn.hxh.demo111.core.domain.testjob;

import lombok.Data;
import java.util.Date;

/**
 * @author: xinhao.hu
 * @date: 2022/1/26 4:26 下午
 * @description:
 **/
@Data
public class TestJob {

    private String id;

    private String taskUuid;

    private String taskName;

    private String taskStatus;

    private String executeType;

    private String periodCron;

    private Double progress;

    private String jobId;

    private Date lastStartTime;

    private Date lastEndTime;
}

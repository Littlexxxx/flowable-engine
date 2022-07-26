package cn.hxh.demo111.core.infrastructure.testjob;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author: xinhao.hu
 * @date: 2022/1/26 4:17 下午
 * @description:
 **/
@Data
@Table(name = "test_job")
public class TestJobDO {
    @Id
    @GeneratedValue
    private String id;

    @Column(name = "task_uuid")
    private String taskUuid;

    @Column(name = "task_name")
    private String taskName;

    @Column(name = "task_status")
    private int taskStatus;

    @Column(name = "execute_type")
    private int executeType;

    @Column(name = "period_cron")
    private String periodCron;

    private String progress;

    @Column(name = "job_id")
    private String jobId;

    @Column(name = "last_start_time")
    private Date lastStartTime;

    @Column(name = "last_end_time")
    private Date lastEndTime;
}

package cn.hxh.demo111.core.infrastructure.testjob;

import cn.hxh.demo111.core.domain.testjob.TestJob;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-01T17:43:21+0800",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_302 (BellSoft)"
)
@Component
public class TestJobDOMapStructImpl implements TestJobDOMapStruct {

    @Override
    public TestJob toTestJob(TestJobDO testJobDO) {
        if ( testJobDO == null ) {
            return null;
        }

        TestJob testJob = new TestJob();

        testJob.setId( testJobDO.getId() );
        testJob.setTaskUuid( testJobDO.getTaskUuid() );
        testJob.setTaskName( testJobDO.getTaskName() );
        testJob.setPeriodCron( testJobDO.getPeriodCron() );
        if ( testJobDO.getProgress() != null ) {
            testJob.setProgress( Double.parseDouble( testJobDO.getProgress() ) );
        }
        testJob.setJobId( testJobDO.getJobId() );
        testJob.setLastStartTime( testJobDO.getLastStartTime() );
        testJob.setLastEndTime( testJobDO.getLastEndTime() );

        return testJob;
    }

    @Override
    public TestJobDO toTestJobDO(TestJob testJob) {
        if ( testJob == null ) {
            return null;
        }

        TestJobDO testJobDO = new TestJobDO();

        testJobDO.setId( testJob.getId() );
        testJobDO.setTaskUuid( testJob.getTaskUuid() );
        testJobDO.setTaskName( testJob.getTaskName() );
        testJobDO.setPeriodCron( testJob.getPeriodCron() );
        if ( testJob.getProgress() != null ) {
            testJobDO.setProgress( String.valueOf( testJob.getProgress() ) );
        }
        testJobDO.setJobId( testJob.getJobId() );
        testJobDO.setLastStartTime( testJob.getLastStartTime() );
        testJobDO.setLastEndTime( testJob.getLastEndTime() );

        return testJobDO;
    }
}

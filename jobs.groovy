@Grab(group='org.quartz-scheduler', module='quartz', version='2.2.1')
@Grab(group='org.slf4j', module='integration', version='1.7.7')

import org.quartz.*
import org.quartz.impl.* 
import static org.quartz.JobBuilder.*;
import static org.quartz.TriggerBuilder.*;
import static org.quartz.SimpleScheduleBuilder.*;
import static org.quartz.CronScheduleBuilder.*;
import static org.quartz.CalendarIntervalScheduleBuilder.*;
import static org.quartz.JobKey.*;
import static org.quartz.TriggerKey.*;
import static org.quartz.DateBuilder.*;
import static org.quartz.impl.matchers.KeyMatcher.*;
import static org.quartz.impl.matchers.GroupMatcher.*;
import static org.quartz.impl.matchers.AndMatcher.*;
import static org.quartz.impl.matchers.OrMatcher.*;
import static org.quartz.impl.matchers.EverythingMatcher.*;


class MySimpleJob  implements Job {

	public void execute(JobExecutionContext context)
		throws JobExecutionException {
		JobDataMap data = context.getMergedJobDataMap();
		System.out.println("someProp = " + data.getString("someProp"));
		println 'test'
	}
}

//SchedulerFactory sf = new StdSchedulerFactory();
def sched = new StdSchedulerFactory().getScheduler();
//Job #1 is scheduled to run every 20 seconds
def job = newJob(MySimpleJob.class)
	.withIdentity("job1", "group1")
	.build();
def trigger = newTrigger()
	.withIdentity("trigger1", "group1")
	.withSchedule(cronSchedule("0/20 * * * * ?"))
	.build();
sched.scheduleJob(job, trigger);


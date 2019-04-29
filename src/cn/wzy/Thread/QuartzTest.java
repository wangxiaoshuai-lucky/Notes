package cn.wzy.Thread;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

public class QuartzTest {

	public static class HelloJob implements Job {
		public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
			//打印当前的执行时间 例如 2017-11-23 00:00:00
			Date date = new Date();
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			System.out.println("现在的时间是：" + sf.format(date));
			//具体的业务逻辑
			System.out.println("Hello Quartz");
		}
	}

	public static void main(String[] args) throws SchedulerException {
		//创建一个jobDetail的实例，将该实例与HelloJob Class绑定
		JobDetail jobDetail = JobBuilder.newJob(HelloJob.class).withIdentity("myJob").build();
		//创建一个Trigger触发器的实例，定义该job立即执行，并且每2秒执行一次，一直执行
		CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity("myTrigger")
			.withSchedule(CronScheduleBuilder.cronSchedule("0 40 9 * * ? ")).build();
		//创建schedule实例
		StdSchedulerFactory factory = new StdSchedulerFactory();
		Scheduler scheduler = factory.getScheduler();
		scheduler.start();
		scheduler.scheduleJob(jobDetail, trigger);

	}
}

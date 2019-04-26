package cn.wzy.Collection;

import java.util.Calendar;
import java.util.Date;

public class CalendarTest {
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		System.out.println(cal.get(Calendar.MONTH));//输出月份
		System.out.println(cal.get(Calendar.YEAR));//输出年份
		System.out.println(cal.get(Calendar.DAY_OF_WEEK));//输出周几

		cal.add(Calendar.YEAR, -1);//前移一年
		cal.add(Calendar.MONTH, -1);//前移一月
		cal.add(Calendar.DATE, -1);//前移一天
	}
}

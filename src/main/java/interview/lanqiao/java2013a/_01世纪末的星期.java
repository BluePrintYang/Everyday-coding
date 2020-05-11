package interview.lanqiao.java2013a;

import java.util.Calendar;

/**
 * 1999年12月31日是星期五，找出1999年之后的第一个是星期日的世纪末（xx99年12月31日）
 * 使用Java日期API
 */
public class _01世纪末的星期 {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        int year;
        for (year = 1999; year < 10000; year+=100) {
            calendar.set(Calendar.YEAR,year);
            calendar.set(Calendar.MONTH,11);
            calendar.set(Calendar.DAY_OF_MONTH,31);
            if((calendar.get(Calendar.DAY_OF_WEEK))==1){

                break;
            }
        }
        System.out.println(year);
    }
}

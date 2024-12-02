package com.jobseekerapprenticeship.spring_api_test.testConfig;

import com.jobseekerapprenticeship.spring_api_test.configuration.timeProvider.ITimeProvider;

import java.util.Calendar;
import java.util.TimeZone;

public class TestTimeProvider implements ITimeProvider {
    public final Calendar calendar;

    public TestTimeProvider(){
        calendar = Calendar.getInstance(TimeZone.getTimeZone("Asia/Jakarta"));
        calendar.set(Calendar.YEAR, 2020);
        calendar.set(Calendar.MONTH, Calendar.JANUARY);
        calendar.set(Calendar.DAY_OF_MONTH, 15);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
    }

    /**
     * Mendapatkan waktu setelah memforward ke beberapa hari.
     * Misal hari ini adalah 1 Januari 2020, apabila anda memanggil <code>getTimeInMillisBasedOnDayForward(7)</code>,
     * maka anda mendapatkan 8 Januari 2020 dalam representasi time in millis
     */
    public long getTimeInMillisBasedOnDayForward(int forwardDay){
        return getCurrentTimeMillis() + forwardDay * (1000 * 60 * 24);
    }

    public void forwardCurrentTimeByDays(int day){
        calendar.add(Calendar.DAY_OF_MONTH, day);
    }

    @Override
    public Long getCurrentTimeMillis() {
        return calendar.getTimeInMillis();
    }
}

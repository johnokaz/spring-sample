package com.example.util;

import java.util.Calendar;
import java.util.Date;
import org.apache.commons.lang.time.DateUtils;

public class DateUtil {

	/**
	 * 開始年度日付取得処理。

	 * 指定された基準日から、開始年度日付を返却する。

	 * @param kijyunDate 基準日
	 * @return 開始年度日付
	 */
	public static Date getStartNendoDate(final Date kijyunDate) {

	 Calendar cal = Calendar.getInstance();
	 cal.setTime(kijyunDate);
	 if (cal.get(Calendar.MONTH) < 3) {
	  cal.add(Calendar.YEAR, -1);
	 }
	 cal.set(Calendar.MONTH, 3); // 4月
	 cal.set(Calendar.DATE, 1); // 1日

	 return DateUtils.truncate(cal.getTime(), Calendar.DAY_OF_MONTH);
	}

	/**
	 * 終了年度日付取得処理。

	 * 指定された基準日から、終了年度日付を返却する。

	 * @param kijyunDate 基準日
	 * @return 終了年度日付
	 */
	public static Date getEndNendoDate(final Date kijyunDate) {

	 Calendar cal = Calendar.getInstance();
	 cal.setTime(kijyunDate);
	 if (cal.get(Calendar.MONTH) >= 3) {
	  cal.add(Calendar.YEAR, 1);
	 }
	 cal.set(Calendar.MONTH, 2); // 3月
	 cal.set(Calendar.DATE, 31); // 31日

	 return DateUtils.truncate(cal.getTime(), Calendar.DAY_OF_MONTH);
	}
}

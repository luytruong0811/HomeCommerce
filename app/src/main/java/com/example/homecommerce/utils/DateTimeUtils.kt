package com.example.homecommerce.utils

import android.content.Context
import com.example.homecommerce.R
import java.text.SimpleDateFormat
import java.time.format.DateTimeFormatter
import java.util.*
import java.util.concurrent.TimeUnit

object DateTimeUtils {

    const val HH_mm = "HH:mm"
    const val mm_ss = "mm:ss"
    const val HH_mm_dd_MM_yyyy = "HH:mm dd-MM-yyyy"
    const val dd_MM_yyyy_HH_mm = "dd-MM-yyyy HH:mm"
    const val YYYY_MM_dd_HH_mm = "YYYY-MM-dd HH:mm"
    const val EEEE_dd_MM_yyyy = "EEEE, dd/MM/yyyy"
    const val dd_MM_yyyy = "dd/MM/yyyy"
    const val dd_MM_yyyy_line = "dd-MM-yyyy"
    const val dd_MM_yyyy_dot = "dd.MM.yyyy"
    const val HH_mm_dd_MM_yyyy_line = "HH:mm | dd-MM-yyyy"
    const val HH_mm_dd_MM_yyyy_dot = "HH:mm | dd.MM.yyyy"
    const val dd_MM_yyyy_HH_mm_line = "dd-MM-yyyy | HH:mm"

    const val DD_MMM_FORMAT = "dd MMM"
    const val DD_MM_YYYY_FORMAT = "dd/MM/yyyy"

    const val GMT_TIMEZONE = "GMT"
    const val UTC_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"

    fun getDateFromTimeUTC(date: String): Date? {
        val simpleDateFormat = SimpleDateFormat(UTC_FORMAT, Locale.getDefault())
        simpleDateFormat.timeZone = TimeZone.getTimeZone("UTC")
        return simpleDateFormat.parse(date)
    }

    fun getDateFromTimeGMT(date: String): Date? {
        val simpleDateFormat = SimpleDateFormat(UTC_FORMAT, Locale.getDefault())
        simpleDateFormat.timeZone = TimeZone.getTimeZone("GMT")
        return simpleDateFormat.parse(date)
    }

    fun getDateTimeFormat(date: Date, typeFormat: String): String {
        val simpleDateFormat = SimpleDateFormat(typeFormat, Locale.getDefault())
        return simpleDateFormat.format(date)
    }

    fun getDateTimeFormat(milliSeconds: Long, typeFormat: String): String {
        val simpleDateFormat = SimpleDateFormat(typeFormat, Locale.getDefault())
        val calendar = Calendar.getInstance().apply {
            timeInMillis = milliSeconds
        }
        return simpleDateFormat.format(calendar.time)
    }

    fun getDateTimeFormat(date: Date, typeFormat: String, timeZone: String? = null): String {
        val simpleDateFormat = SimpleDateFormat(typeFormat, Locale.getDefault())

        if (timeZone != null) {
            simpleDateFormat.timeZone = TimeZone.getTimeZone(timeZone)
        }

        return simpleDateFormat.format(date)
    }

    fun getDateTimeFormat(date: String, typeFormat: String): Date? {
        val simpleDateFormat = SimpleDateFormat(typeFormat, Locale.getDefault())
        return simpleDateFormat.parse(date)
    }

    fun convertTimeStampToDateString(time: Long, format: String, timeZone: String? = null): String {
        val simpleDateFormat = SimpleDateFormat(format, Locale.getDefault())
        if (timeZone != null) {
            simpleDateFormat.timeZone = TimeZone.getTimeZone(timeZone)
        }
        return simpleDateFormat.format(Date(time))
    }

    fun convertUTCToDateString(date: String, format: String, timeZone: String? = null): String {
        val simpleDateFormat = SimpleDateFormat(format, Locale.getDefault())
        if (timeZone != null) {
            simpleDateFormat.timeZone = TimeZone.getTimeZone(timeZone)
        }
        return simpleDateFormat.format(getDateFromTimeUTC(date))
    }

    fun convertGMTToDateString(date: String, format: String, timeZone: String? = null): String {
        val simpleDateFormat = SimpleDateFormat(format, Locale.getDefault())
        if (timeZone != null) {
            simpleDateFormat.timeZone = TimeZone.getTimeZone(timeZone)
        }
        return simpleDateFormat.format(getDateFromTimeGMT(date))
    }

    fun convertSecondToDateString(second: Long): String {
        return getDateTimeFormat(convertSecondToDate(second), DD_MM_YYYY_FORMAT)
    }
    fun convertSecondToDateStringFormat(second: Long, format: String): String {
        return getDateTimeFormat(convertSecondToDate(second), format)
    }

    fun convertSecondToDate(second: Long): Date {
        return Date(second * 1000)
    }

    fun convertDateToSecond(date: Date): Long {
        return date.time / 1000
    }

    fun currentDateTimeSecond(): Long {
        return convertDateToSecond(Calendar.getInstance().time)
    }

    fun currentDate(): Date = Calendar.getInstance().time

    fun convertSecondToDay(second: Long): Long {
        return second / 86400
    }

    fun convertDateToDay(date: Date): Long {
        return convertSecondToDay(convertDateToSecond(date))
    }

    fun convertDateToTimeStringMessage(context: Context, date: Date): String {
        val currentDay = convertDateToDay(currentDate())
        val timeDay = convertDateToDay(date)
        val diffDay = currentDay - timeDay
        return when (diffDay) {
            0L -> {
                context.getString(R.string.today)
            }
            in 1..6 -> {
                getDateTimeFormat(date, EEEE_dd_MM_yyyy)
            }
            else -> {
                getDateTimeFormat(date, dd_MM_yyyy)
            }
        }
    }

    fun convertMillisToSecond(millis: Long): Long {
        return TimeUnit.MILLISECONDS.toSeconds(millis)
    }

    fun convertTimeUTCToStringDateTimeFormat(timeUTC: String?, format: String, timeZone: String? = null): String? {
        val date = timeUTC?.let { getDateFromTimeGMT(it) }
        return date?.let { getDateTimeFormat(it, format, timeZone) }
    }
}
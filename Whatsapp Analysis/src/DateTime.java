public class DateTime
{

    // DD-MM-YYYY
    private int year = 1970;
    private int month = 1;
    private int day = 1;
    // HH:mm
    private int hour = 0;
    private int minute = 0;

    public DateTime(int day, int month, int year, int hour, int minute)
    {
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minute = minute;
    }

    public DateTime()
    {
        //empty for Polymorphism
    }

    public int getYear()
    {
        return year;
    }

    public void setYear(int year)
    {
        if (year >= 1970 && year <= 2300)
        {
            this.year = year;
        } else
        {
            throw new IndexOutOfBoundsException("year outOfRange");
        }
    }

    public int getMonth()
    {
        return month;
    }

    public void setMonth(int month)
    {
        if (month >= 1 && month <= 12)
        {
            this.month = month;
        } else
        {
            throw new IndexOutOfBoundsException("month outOfRange");
        }
    }

    public int getDay()
    {
        return day;
    }

    public void setDay(int day)
    {
        //improve here for every month;
        if (day >= 1 && day <= 31)
        {
            this.day = day;
        } else
        {
            throw new IndexOutOfBoundsException("day outOfRange");
        }
    }

    public int getHour()
    {
        return hour;
    }

    public void setHour(int hour)
    {
        if (hour >= 0 && hour <= 23)
        {
            this.hour = hour;
        } else
        {
            throw new IndexOutOfBoundsException("hour outOfRange");
        }
    }

    public int getMinute()
    {
        return minute;
    }

    public void setMinute(int minute)
    {
        if (minute >= 0 && minute <= 59)
        {
            this.minute = minute;
        } else
        {
            throw new IndexOutOfBoundsException("minute outOfRange");
        }
    }

    public void setDayMonthYear(int day, int month, int year)
    {
        setDay(day);
        setMonth(month);
        setYear(year);
    }

    public void setHourMinute(int hour, int minute)
    {
        setHour(hour);
        setMinute(minute);
    }

    public void setDateTime(int day, int month, int year, int hour, int minute)
    {
        setDayMonthYear(day, month, year);
        setHourMinute(hour, minute);
    }

    @Override
    public String toString()
    {
        return String.format("%02d.%02d.%04d %02d:%02d", day, month, year, hour, minute);
    }
}

package com.example.task02;

public class TimeSpan {

    private int hour;
    private int minute;
    private int second;

    //region Getter
    public int getHour() {
        return hour;
    }
    public int getMinute() {
        return minute;
    }
    public int getSecond() {
        return second;
    }
    //endregion

    //region Setter
    public void setHour(int hour) {
        if(hour >= 0 && hour < 24) {
            this.hour = hour;
        } else {
            throw new IllegalArgumentException("С переданным 'часом' что-то не так");
        }
    }
    public void setMinute(int minute) {
        if(minute >= 0 && minute < 60) {
            this.minute = minute;
        } else {
            throw new IllegalArgumentException("С переданными 'минутами' что-то не так");
        }
    }
    public void setSecond(int second) {
        if (second >= 0 && second < 60) {
            this.second = second;
        } else {
            throw new IllegalArgumentException("С переданными 'секундами' что-то не так");
        }
    }
    //endregion

    public TimeSpan(int hour, int minute, int second) {
        setHour(hour);
        setMinute(minute);
        setSecond(second);
    }

    //region ADD
    void add(TimeSpan time) {
        if ((this.second + time.second) < 60 && (this.second + time.second) >= 0) {
            setSecond(this.second + time.second);
        } else {
            int secondRemainder = (this.second + time.second) - 60;

            if ((this.minute + 1) >= 60) {
                setHour(this.hour + 1);
                setMinute(0);
            } else {
                setMinute(this.minute + 1);
            }
            setSecond(secondRemainder);
        }

        if ((this.minute + time.minute) < 60 && (this.minute + time.minute) >= 0) {
            setMinute(this.minute + time.minute);
        } else {
            int minutesRemainder = (this.minute + time.minute) - 60;

            if ((this.hour + 1) >= 24) {
                throw new IllegalArgumentException("Ошибка, не бывает больше 24 часов");
            } else {
                setHour(this.hour + 1);
            }
            setMinute(minutesRemainder);
        }

        if ((this.hour + time.hour) < 24) {
            setHour(this.hour + time.hour);
        } else {
            throw new IllegalArgumentException("Что-то пошло не так");
        }
    }
    //endregion

    //region subtract
    void subtract(TimeSpan time) {
        if((this.second - time.second) >= 0 && (this.second - time.second) < 60) {
            setSecond(this.second - time.second);
        } else {
            int secondMinRemainder = (this.second - time.second) + 60;

            if ((this.minute - 1) < 0) {
                setMinute((this.minute - 1) + 60);
                setHour((this.hour) - 1);
            } else {
                setMinute(this.minute - 1);
            }
            setSecond(secondMinRemainder);
        }

        if ((this.minute - time.minute) >= 0 && (this.minute - time.minute) < 60) {
            setMinute(this.minute - time.minute);
        } else {
            int minutesMinRemainder = (this.minute - time.minute) + 60;

            if ((this.hour - 1) < 0) {
                throw new IllegalArgumentException("Ошибка, не бывает -1 часов");
            }
            else {
                setHour(this.hour - 1);
            }
            setMinute(minutesMinRemainder);
        }

        if ((this.hour - time.hour) >= 0 && (this.hour - time.hour) < 24) {
            setHour(this.hour - time.hour);
        } else {
            throw new IllegalArgumentException("Что-то пошло не так");
        }
    }
    //endregion
    @Override
    public String toString() {
        return getHour() + ":" + getMinute() + ":" + getSecond();
    }
}

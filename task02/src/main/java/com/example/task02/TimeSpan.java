package com.example.task02;


public class TimeSpan {
    private int hours;
    private int minutes;
    private int second;

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSecond() {
        return second;
    }

    public void setHours(int hours) {
        if (hours >= 0 && hours <= 24) {
            this.hours = hours;
        } else {
            throw new RuntimeException("Такого времени не бывает. А именно: час");
        }
    }

    public void setMinutes(int minutes) {
        if (minutes >= 0 && minutes < 60) {
            this.minutes = minutes;
        } else {
            throw new RuntimeException("Такого времени не бывает. А именно: минута");
        }
    }

    public void setSecond(int second) {
        if (second >= 0 && second < 60) {
            this.second = second;
        } else {
            throw new RuntimeException("Такого времени не бывает. А именно: секунда");
        }
    }

    /**
     * Конструктор
     */
    public TimeSpan(int hours, int minutes, int second) {
        setHours(this.hours = hours);
        setMinutes(this.minutes = minutes);
        setSecond(this.second = second);
    }

    /**
     *
     * @param time для сложения времени
     */
    void add(TimeSpan time) {

        if ((this.second + time.second) < 60 && (this.second + time.second) >= 0) {
            setSecond(this.second + time.second);
        } else {
            int secondRemainder = (this.second + time.second) - 60;

            if ((this.minutes + 1) >= 60) {
                setHours(this.hours + 1);
                setMinutes(this.minutes = 0);
            } else {
                setMinutes(this.minutes + 1);
            }
            setSecond(this.second = secondRemainder);
        }

        if ((this.minutes + time.minutes) < 60 && (this.minutes + time.minutes) >= 0) {
            setMinutes(this.minutes + time.minutes);
        } else {
            int minutesRemainder = (this.minutes + time.minutes) - 60;

            if ((this.hours + 1) > 24) {
                throw new RuntimeException("Ошибка, не бывает 25 часов");
            } else {
                setHours(this.hours + 1);
            }
            setMinutes(this.minutes = minutesRemainder);
        }

        if ((this.hours + time.hours) < 24) {
            setHours(this.hours + time.hours);
        } else {
            throw new RuntimeException("Что-то пошло не так");
        }
    }

    void subtract(TimeSpan time) {

        if((this.second - time.second) >= 0 && (this.second - time.second) < 60) {
            setSecond(this.second - time.second);
        } else {
            int secondMinRemainder = (this.second - time.second) + 60;

            if ((this.minutes - 1) < 0) {
                setMinutes((this.minutes - 1) + 60);
                setHours((this.hours) - 1);
            } else {
                setMinutes(this.minutes - 1);
            }
            setSecond(this.second = secondMinRemainder);
        }

        if ((this.minutes - time.minutes) >= 0 && (this.minutes - time.minutes) < 60) {
            setMinutes(this.minutes - time.minutes);
        } else {
            int minutesMinRemainder = (this.minutes - time.minutes) + 60;

            if ((this.hours - 1) < 0) {
                throw new RuntimeException("Ошибка, не бывает -1 часов");
            }
            else {
                setHours(this.hours - 1);
            }
            setMinutes(this.minutes = minutesMinRemainder);
        }

        if ((this.hours - time.hours) >= 0 && (this.hours - time.hours) < 24) {
            setHours(this.hours - time.hours);
        } else {
            throw new RuntimeException("Что-то пошло не так");
        }
    }

    public String toString() {
        return getHours() + " часов, " + getMinutes() + " минут, " + getSecond() + " секунд";
    }

}

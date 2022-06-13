package inner;

import java.time.Month;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Calendar {

    public enum DayOfWeek {
        SUNDAY(1,"Sun"), MONDAY(2, "Mon"), TUESDAY(3, "Tue"), WEDNESDAY(4, "Wed"), THURSDAY(5, "Thu"), FRIDAY(6, "Fri"), SATURDAY(7, "Sat");
        private int number;
        private String shortName;
        private static final Map<DayOfWeek, DayOfWeek> NEXT_DAYS = new HashMap<>();
        private DayOfWeek(int number, String shortName) {
            this.number = number;
            this.shortName = shortName;
        }
        static{
            NEXT_DAYS.put(SUNDAY,MONDAY);NEXT_DAYS.put(MONDAY,TUESDAY);NEXT_DAYS.put(TUESDAY,WEDNESDAY);
            NEXT_DAYS.put(WEDNESDAY, THURSDAY);
            NEXT_DAYS.put(THURSDAY,FRIDAY);
            NEXT_DAYS.put(FRIDAY,SATURDAY);
            NEXT_DAYS.put(SATURDAY,SUNDAY);
        }
        public String toString() {
            return shortName;
        }
        public DayOfWeek tomorrow() {
            return NEXT_DAYS.get(this);
        }
        public enum Month implements Iterable<DayOfWeek> {
            JANUARY(31), FEBRUARY(28), MARCH(31), APRIL(30), MAY(31), JUNE(30), JULY(31),
            AUGUST(30), SEPTEMBER(30), OCTOBER(31), NOVEMBER(30), DECEMBER(31);
            private int dayInMonth;
            private DayOfWeek startDay;
            private String shortName;
            private static final Map<Month, Month> NEXT_MONTHS = new HashMap<>();
            private Month(int daysInMonth) {
                this.dayInMonth = daysInMonth;
                this.startDay = DayOfWeek.SUNDAY;
            }
            static{
                NEXT_MONTHS.put(JANUARY,FEBRUARY);NEXT_MONTHS.put(FEBRUARY,MARCH);NEXT_MONTHS.put(MARCH,APRIL);
                NEXT_MONTHS.put(APRIL, MAY);
                NEXT_MONTHS.put(MAY,JUNE);
                NEXT_MONTHS.put(JUNE,JULY);
                NEXT_MONTHS.put(JULY,AUGUST);
                NEXT_MONTHS.put(AUGUST,SEPTEMBER);
                NEXT_MONTHS.put(SEPTEMBER,OCTOBER);
                NEXT_MONTHS.put(OCTOBER,NOVEMBER);
                NEXT_MONTHS.put(NOVEMBER,DECEMBER);
                NEXT_MONTHS.put(DECEMBER,JANUARY);
            }
            public String toString() {
                return shortName;
            }
            public Month nextMonth() {
                return NEXT_MONTHS.get(this);
            }
            public void setStartDay(DayOfWeek day) {
                this.startDay = day;
            }
            @Override
            public Iterator<DayOfWeek> iterator() {
                
                return new Iterator<Calendar.DayOfWeek>(){
                    DayOfWeek day = startDay;
                    private int counter = 0;
                    @Override
                    public boolean hasNext() {
                        return counter < dayInMonth;
                    }

                    @Override
                    public DayOfWeek next() {
                        DayOfWeek day = startDay;
                        DayOfWeek today = day;
                        day = today.tomorrow();
                        counter ++;
                        return today;
                    }
                    
                };
            }   
        }
    }
    public static void main(String[] args) {
        for(DayOfWeek day:Month.MARCH) {
            System.out.println(day+ " ");
        }
    }
}
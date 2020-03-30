import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Zadanie3 {
    public static void main(String[] args)
    {
        LocalDate beginDate1 = LocalDate.parse("1939-09-01");
        LocalDate endDate1 = LocalDate.parse("1945-05-08");

        System.out.println("Druga wojna swiatowa trwala " + worldWarTwoLength(beginDate1, endDate1) + " dni.");

        LocalDate localDate = LocalDate.parse("2016-01-01");

        dayOfTheYear(localDate);

        LocalTime beginTime = LocalTime.parse("11:45:00");
        LocalTime endTime = LocalTime.parse("22:30:00");

        System.out.println("Suma cyfr liczby godzin i minut wynosiła 15 dokładnie " + amountOfSums(beginTime, endTime) + " razy.");

        LocalDate beginDate2 = LocalDate.parse("1997-03-25");
        LocalDate endDate2 = LocalDate.now();

        System.out.println("Osoba urodzona w dniu "+ beginDate2 +" przezyla " + isYearLeap(beginDate2, endDate2) + " lat przestepnych.");
    }

    static long worldWarTwoLength(LocalDate beginDate, LocalDate endDate)
    {
        return ChronoUnit.DAYS.between(beginDate, endDate);
    }

    static void dayOfTheYear(LocalDate beginDate)
    {
        LocalDate tomorrowDate = beginDate.plusDays(67);
        System.out.println("68-my dzień roku 2016: " + tomorrowDate);
    }

    static int amountOfSums(LocalTime beginTime, LocalTime endTime)
    {
        int counter = 0;
        int temp = (int)(beginTime.getHour()%10);
        temp += (int)(beginTime.getHour()/10);
        temp += (int)(beginTime.getMinute()%10);
        temp += (int)(beginTime.getMinute()/10);

        LocalTime tempTime = beginTime;

        while(tempTime.isBefore(endTime))
        {
            temp = (int)(tempTime.getHour()%10);
            temp += (int)(tempTime.getHour()/10);
            temp += (int)(tempTime.getMinute()%10);
            temp += (int)(tempTime.getMinute()/10);

            if (temp != 15) {
                tempTime = tempTime.plusMinutes(1);
            } else {
                counter += 1;
                tempTime = tempTime.plusMinutes(1);
            }
        }

        return counter;
    }

    static int isYearLeap(LocalDate beginDate, LocalDate actualDate)
    {
        int counter = 0;
        LocalDate tempDate = beginDate;

        if((beginDate.getYear() % 4 == 0) && (beginDate.getYear() % 100 != 0) || (beginDate.getYear() % 400 == 0))
        {
            LocalDate beginDate2 = LocalDate.parse(beginDate.getYear()+"-02-29");
            if(beginDate.isAfter(beginDate2))
            {
                counter -= 1;
            }
        }

        while(tempDate.getYear() <= actualDate.getYear())
        {
            if((tempDate.getYear() % 4 == 0) && (tempDate.getYear() % 100 != 0) || (tempDate.getYear() % 400 == 0))
            {
                counter += 1;
                tempDate = tempDate.plusYears(1);
            }
            else
            {
                tempDate = tempDate.plusYears(1);
            }
        }
        return counter;
    }
}
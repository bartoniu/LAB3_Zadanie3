import org.junit.jupiter.api.Assertions;
import java.time.LocalTime;

class Zadanie3Test {
    LocalTime beginTime = LocalTime.parse("11:45:00");
    LocalTime endTime = LocalTime.parse("22:30:00");

    LocalTime beginTime2 = LocalTime.parse("13:25:00");
    LocalTime endTime2 = LocalTime.parse("13:50:00");

    @org.junit.jupiter.api.Test
    void amountOfSums()
    {
        Assertions.assertEquals(50, Zadanie3.amountOfSums(beginTime, endTime));
        Assertions.assertEquals(3, Zadanie3.amountOfSums(beginTime2, endTime2));
    }
}
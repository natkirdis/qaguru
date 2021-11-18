
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class HelloWorld {

    public static void main(String[] args) {

        LocalDate birthday = LocalDate.ofEpochDay(ThreadLocalRandom
                .current().nextInt(-80 * 365, 0));
        String dateFormated = birthday.format(DateTimeFormatter
                .ofLocalizedDate(FormatStyle.LONG).localizedBy(Locale.UK));






        System.out.print( "day" + List.of(dateFormated.split(" ")).get(0));
        System.out.print("month" +  List.of(dateFormated.split(" ")).get(1));
        System.out.print("year" + List.of(dateFormated.split(" ")).get(2));
    }
}

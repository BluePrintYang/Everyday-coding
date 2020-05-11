import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDate {
    public static void main(String[] args) {
        LocalDateTime localDate = LocalDateTime.now();
        System.out.println(localDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    }}

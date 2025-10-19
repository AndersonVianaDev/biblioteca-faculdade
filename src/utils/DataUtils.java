package utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DataUtils {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    public static String getDataAtual() {
        return LocalDate.now().format(FORMATTER);
    }
    
    public static String formatarData(LocalDate data) {
        return data.format(FORMATTER);
    }
    
    public static LocalDate parseData(String data) {
        return LocalDate.parse(data, FORMATTER);
    }
}

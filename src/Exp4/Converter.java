package Exp4;

import javafx.scene.input.DataFormat;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Converter {
    public static void main(String[] args) {
        Calendar c=Calendar.getInstance();

        c.add(Calendar.DATE,+100);
        Date date=c.getTime();
        DateFormat dateFormat=DateFormat.getDateInstance(DateFormat.FULL, Locale.CHINA);
        System.out.println(dateFormat.format(date));
    }
}

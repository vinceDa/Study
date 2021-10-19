package org.example;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.logging.SimpleFormatter;
import java.util.stream.Collectors;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void testDate() throws InterruptedException {
        List<Date> list = new ArrayList<>();
        Date date = new Date();
        list.add(date);
        Thread.sleep(1000);
        date = new Date();
        list.add(date);
        Thread.sleep(1000);
        date = new Date();
        list.add(date);
        for (Date single : list) {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            System.out.println(format.format(single));
        }
        System.err.println("================================");
        list.sort(Comparator.comparing(Date::getTime).reversed());
        for (Date single : list) {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            System.out.println(format.format(single));
        }
    }
}

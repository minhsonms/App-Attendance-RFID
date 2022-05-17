/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Source;

import com.impinj.octane.TagData;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

/**
 *
 * @author Cham Cham
 */
public class Test {

    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime last = LocalDateTime.parse("2022-04-26T15:06:04");
        String s="2022-04-26T15:06:04";
        String []ar = s.split("T");
        //int second = (int)last.until(now,ChronoUnit.SECONDS);
        
        //System.out.println(LocalDateTime.now());
        //System.out.println(second);
        System.out.println(ar[0]);
        


    }
}

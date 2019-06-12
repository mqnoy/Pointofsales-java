/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trash;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class Make_microtime {
    public static float rumus(int seconds){
        
        
        float microsecons =  (float) (seconds*1E+6);
        return microsecons;
    }
    public static void main(String[] args) {
        long microsenconds = TimeUnit.MILLISECONDS.toMicros(System.currentTimeMillis());
        long seconds = TimeUnit.MICROSECONDS.toSeconds(microsenconds);
        float microTime = System.nanoTime();
        System.out.println("current milis"+System.currentTimeMillis());
        System.out.println("current milis"+microTime);
        System.out.println(microsenconds);
        System.out.println(seconds);
        
        float rumus = rumus(10);
        System.out.println(rumus);
        long rumus2;
        rumus2 = (long)rumus;
        System.out.println(rumus2);
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
        
        System.out.println(timeStamp);
//        System.out.println(ZonedDateTime.now());
    }
}

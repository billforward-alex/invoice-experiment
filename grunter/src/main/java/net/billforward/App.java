package net.billforward;

import java.io.*;
import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        File inputDir = new File("tmp");

        Uncss uncss = new Uncss(inputDir);
        try {
            uncss.uncss();
        } catch (UncssFailedException e) {
            e.printStackTrace();
        }
    }
}

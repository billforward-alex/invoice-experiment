package net.billforward;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        App app = new App();
        app.main();
    }

    public void main() {
        System.out.println( "Hello World!" );

        // Get current classloader
        ClassLoader classLoader = this.getClass().getClassLoader();
        String node = classLoader.getResource("generated-resources/node").getFile();
        String index = classLoader.getResource("js/index.js").getFile();

        String[] command = {node, index};
        System.out.printf("Running '%s'...\n",
                Arrays.toString(command));

        ProcessBuilder processBuilder = new ProcessBuilder(command);
        Process process;
        try {
            process = processBuilder.start();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        //Read out dir output
        InputStream is = process.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        String line;
        System.out.printf("Output of running '%s' is:\n",
                Arrays.toString(command));
        try {
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //Wait to get exit value
            try {
                int exitValue = process.waitFor();
                System.out.println("\n\nExit Value is " + exitValue);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}

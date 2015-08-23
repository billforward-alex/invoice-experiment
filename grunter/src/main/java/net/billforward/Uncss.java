package net.billforward;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by birch on 23/08/2015.
 */
public class Uncss {
    public String uncss() throws UncssFailedException {
        System.out.println("Hello World!");

        // Get current classloader
        ClassLoader classLoader = this.getClass().getClassLoader();
        String node;
        String index;
        try {
            node = classLoader.getResource("generated-resources/node").getFile();
            index = classLoader.getResource("js/index.js").getFile();
        } catch(NullPointerException e) {
            UncssFailedException uncssFailedException = new UncssFailedException("Couldn't find Uncsser");
            uncssFailedException.setStackTrace(e.getStackTrace());
            throw uncssFailedException;
        }

        String[] command = {node, index};
        System.out.printf("Running '%s'...\n",
                Arrays.toString(command));

        ProcessBuilder processBuilder = new ProcessBuilder(command);
        Process process;
        try {
            process = processBuilder.start();
        } catch (IOException e) {
            UncssFailedException uncssFailedException = new UncssFailedException("Couldn't start Uncss process");
            uncssFailedException.setStackTrace(e.getStackTrace());
            throw uncssFailedException;
        }

        //Read out dir output
        InputStream is = process.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        String line;
        System.out.printf("Output of running '%s' is:\n",
                Arrays.toString(command));

        StringBuilder outputBuilder = new StringBuilder();

        try {
            while ((line = br.readLine()) != null) {
                outputBuilder.append(line);
            }
        } catch (IOException e) {
            UncssFailedException uncssFailedException = new UncssFailedException("Error whilst running Uncss");
            uncssFailedException.setStackTrace(e.getStackTrace());
            throw uncssFailedException;
        } finally {
            //Wait to get exit value
            try {
                int exitValue = process.waitFor();
                System.out.println("\n\nExit Value is " + exitValue);
            } catch (InterruptedException e) {
                UncssFailedException uncssFailedException = new UncssFailedException("Interrupted whilst waiting for Uncss to close");
                uncssFailedException.setStackTrace(e.getStackTrace());
                throw uncssFailedException;
            }
        }

        return outputBuilder.toString();
    }
}

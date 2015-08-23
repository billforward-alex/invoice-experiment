package net.billforward;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        App app = new App();


        // Get current classloader
//        ClassLoader classLoader = App.class.getClassLoader();
        URI uri;
        try {
            uri = App.class.getResource(".").toURI();
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return;
        }
//        Paths.get(uri).toFile()
        File inputDir = new File(uri.getPath(), "tmp");

        Uncss uncss = new Uncss(inputDir);
        try {
            uncss.uncss("<html></html>");
        } catch (UncssFailedException e) {
            e.printStackTrace();
        }
    }
}

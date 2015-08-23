package net.billforward;

import io.apigee.trireme.core.NodeEnvironment;
import io.apigee.trireme.core.NodeException;
import io.apigee.trireme.core.NodeScript;
import io.apigee.trireme.core.ScriptStatus;

import java.io.File;
import java.util.concurrent.ExecutionException;

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

//        // The NodeEnvironment controls the environment for many scripts
//        NodeEnvironment env = new NodeEnvironment();
//
//        // Get current classloader
//        ClassLoader classLoader = this.getClass().getClassLoader();
//        String path = classLoader.getResource("js/index.js").getFile();
//
//        // Pass in the script file name, a File pointing to the actual script, and an Object[] containg "argv"
//        NodeScript script = null;
//        try {
//            script = env.createScript("index.js",
//                    new File(path), null);
//        } catch (NodeException e) {
//            e.printStackTrace();
//        }
//
//        // Wait for the script to complete
//        ScriptStatus status = null;
//        try {
//            status = script.execute().get();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        } catch (NodeException e) {
//            e.printStackTrace();
//        }
//
//        // Check the exit code
//        System.exit(status.getExitCode());
    }
}

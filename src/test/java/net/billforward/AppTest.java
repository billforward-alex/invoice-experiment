package net.billforward;

import clojure.java.api.Clojure;
import clojure.lang.IFn;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        IFn require = Clojure.var("clojure.core", "require");
        Object whatever = require.invoke(Clojure.read("net.billforward"));
        assertNotNull(whatever);

        assertTrue( true );
    }
}

package katas;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;


public class Kata6Test {

    @Test
    public void testExecuteType() {
        Assert.assertTrue(Kata6.execute() instanceof String);
    }
    
    @Test
    public void testExecuteValue() {
    	assertEquals(Kata6.execute(), "http://cdn-0.nflximg.com/images/2891/Fracture300.jpg");
    }
}

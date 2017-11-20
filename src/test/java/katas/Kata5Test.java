package katas;

import org.junit.Assert;
import org.junit.Test;


public class Kata5Test {

    @Test
    public void testExecuteType() {
        Assert.assertTrue(Kata5.execute() instanceof Double);
    }
    
    @Test
    public void testExecuteValue() {
        Assert.assertEquals(Kata5.execute(), (Double)5.0);
    }
}

package com.athens.athens2048;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class RandomPickerTest    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public RandomPickerTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( RandomPickerTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testRandomPicker()
    {
        RandomPicker picker = new RandomPicker(4,4);
        assertTrue( picker.freeTilesCount() == 0);
        // Add first Tile
        picker.addFreeTile(2, 3);
        assertTrue( picker.findTile(2, 3) != -1);
        assertTrue( picker.findTile(2, 4) == -1);
        assertTrue( picker.freeTilesCount() == 1);
        picker.addFreeTile(2, 3);
        // shouldn't be able to add twice the same cell
        assertTrue( picker.freeTilesCount() == 1);
        picker.removeFreeTile(2, 3);
        assertTrue( picker.freeTilesCount() == 0);
        RandomSelector randsel =  new RandomSelector();
        for(int i = 0;  i < 50; i++){
            System.out.println("Randomly picked : " + String.valueOf(randsel.getRandom()));
        }
    }
}

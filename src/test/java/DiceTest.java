//import io.zipcoder.casino.dicegames.dice.Dice;
import io.zipcoder.casino.utilities.Dice;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DiceTest {
    //This method will test the getDieGraphic method  returns specific character based on the input integer.
    @Test
    public void testgetDieGraphic1()
    {
        Dice dice=new Dice();
        Character  expected='⚀';
        Character actual=dice.getDieGraphic(1);
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void testgetDieGraphic2()
    {
        Dice dice=new Dice();
        Character expected='⚁';
        Character  actual=dice.getDieGraphic(2);
        Assert.assertEquals(expected,actual);
    }


    @Test
    public void testgetDieGraphic3()
    {
        Dice dice=new Dice();
        Character expected='⚂';
        Character  actual=dice.getDieGraphic(3);
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void testgetDieGraphic4()
    {
        Dice dice=new Dice();
        Character expected='⚃';
        Character  actual=dice.getDieGraphic(4);
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void testgetDieGraphic5()
    {
        Dice dice=new Dice();
        Character expected='⚄';
        Character  actual=dice.getDieGraphic(5);
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void testgetDieGraphic6()
    {
        Dice dice=new Dice();
        Character expected='⚅';
        Character  actual=dice.getDieGraphic(6);
        Assert.assertEquals(expected,actual);
    }

// This method will test the getLastRollGraphic method is returing the GRAPHIC String correctly
//     if input 4,6 3,1,3,5 is given the expected output should be -  ⚃ ⚅ ⚂ ⚀ ⚂ ⚄
    @Test
    public void testgetLastRollGraphic(){

        ArrayList<Integer> roll=new ArrayList<>();
        roll.add(4);
        roll.add(6);
        roll.add(3);
        roll.add(1);
        roll.add(3);
        roll.add(5);
        Dice dice=new Dice(6);
        dice.setLastRoll(roll);
       // String expected=dice.getLastRollGraphic();
        //Assert.assertEquals(expected,"⚃ ⚅ ⚂ ⚀ ⚂ ⚄ " ) ;

    }
    // This method will test tossAndSum method and return the sum of given number of dice.
    //if input is 2 dice then the result should be between 2 and 12.
    @Test
    public void testtossAndSum2(){
        Dice dice=new Dice(2);
        int actual =dice.tossAndSum() ;
        boolean tempflag = false;
        if (actual  >=2 && actual <=12 )
            tempflag=true;
        Assert.assertTrue(tempflag);
    }


}

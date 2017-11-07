package pl.sdacademy.animals.bear;

import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BearTest {

    @Test
    void bearShouldBeAliveIfHasEatenWithin10Days() {
        Bear bear = new BlackBear(1);
        bear.eat(2);

        boolean result = bear.isAlive();

        assertTrue(result == true);
    }

    @Test
    void feedingbearshouldsetthedateofthelastmeal(){
        Bear bear=new BlackBear(1);
        bear.eat(2);

        DateTime result=bear.getLastMealTime();
        assertTrue(new Duration(result,DateTime.now()).isShorterThan(Duration.standardSeconds(1)));

    }

    @Test
    void bearshouldnotbealiveifithasnoteatenformorethan10days(){
        Bear bear=new BlackBear(100,new TestClock());

        boolean result=bear.isAlive();
        assertTrue(result==false);
    }

    @Test
    void bearshouldbeweigtheraftermeal(){
        Bear bear=new BlackBear(100);

        int firstweigth=bear.getWeight();

        bear.eat(2);

        int result=bear.getWeight();

        assertTrue(result>firstweigth);
    }
    @Test
    void bearshouldbeweigtherafterdring(){
        Bear bear=new BlackBear(100);

        int firstweigth=bear.getWeight();

        bear.drink(2);

        int result=bear.getWeight();

        assertTrue(result>firstweigth);
    }
    @Test
    void bearshouldbelessweigthafterpoop(){
        Bear bear=new BlackBear(100);

        int firstweigth=bear.getWeight();

        bear.poop();

        int result=bear.getWeight();

        assertTrue(result<firstweigth);
    }
    @Test
    void bearshouldbeinHibernating(){
        assertTrue(DateTime.now().);
    }
}
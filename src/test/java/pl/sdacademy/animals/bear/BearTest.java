package pl.sdacademy.animals.bear;

import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BearTest {

    @Test
    void bearShouldBeAliveIfHasEatenWithin10Days() {
        Bear bear = new BlackBear(100);
        bear.eat(5);

        assertThat(bear.isAlive()).isTrue();
    }

    @Test
    void feedingBearShouldSetTheDateOfTheLastMealForNow() {
        Bear bear = new BlackBear(100);
        bear.eat(5);

        assertThat(new Duration(bear.getLastMealTime(), DateTime.now()).isShorterThan(Duration.standardSeconds(1)))
                .isTrue();
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

        bear.eat(6);

        int result=bear.getWeight();

        assertTrue(result>firstweigth);
    }
    @Test
    void bearshouldbeweigtherafterdring(){
        Bear bear=new BlackBear(100);

        int firstweigth=bear.getWeight();

        bear.drink(4);

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
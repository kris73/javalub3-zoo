package pl.sdacademy.animals.bear;

import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.joda.time.LocalDate;
import pl.sdacademy.animals.Animal;
import pl.sdacademy.clock.Clock;
import pl.sdacademy.clock.DateTimeClock;


public abstract class Bear implements Animal {

    private int weight;

    private DateTime lastMealTime;
    private Clock clock;

    public DateTime getLastMealTime() {
        return lastMealTime;
    }

    public Bear(int weight) {
        this.clock = new DateTimeClock();
        this.lastMealTime = clock.getCurrentTime();
        this.weight = weight;
    }

    public Bear(int weight, Clock clock) {
        this(weight);
        this.clock = clock;
    }

    @Override
    public boolean isAlive() {
        return new Duration(lastMealTime, clock.getCurrentTime()).isShorterThan(Duration.standardDays(10));
    }

    public void eat(int mealweigth) {
        lastMealTime = clock.getCurrentTime();
        this.weight+=mealweigth;
    }

    public void drink(int waterWeight) {
        this.weight+=waterWeight*3/4;
    }
    public void poop(){
        this.weight=this.weight-this.weight/20;
    }
    public boolean isHibernating(){
        return DateTime.now().;
    }

    @Override
    public int getWeight() {
        return weight;
    }

}

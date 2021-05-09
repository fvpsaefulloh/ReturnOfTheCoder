package coder.fivip;

import coder.fivip.model.PersonWhoKilledByTheWitch;
import coder.fivip.util.TheCoderUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class TheCoderUtilTest {
    @Test
    public void getNumberOfVillagerKilledByTheWitchTest() {
        Assertions.assertEquals(4, TheCoderUtil.getNumberOfVillagerThatKilledByTheWitch(3));
        Assertions.assertEquals(12, TheCoderUtil.getNumberOfVillagerThatKilledByTheWitch(5));
        Assertions.assertEquals(7, TheCoderUtil.getNumberOfVillagerThatKilledByTheWitch(4));
    }

    @Test
    public void getAverageTest() {
        PersonWhoKilledByTheWitch person1 = new PersonWhoKilledByTheWitch();
        person1.setAgeOfDeath(10);
        person1.setYearOfDeath(12);

        PersonWhoKilledByTheWitch person2 = new PersonWhoKilledByTheWitch();
        person2.setAgeOfDeath(13);
        person2.setYearOfDeath(17);

        Assertions.assertEquals(4.5D, TheCoderUtil.getAverage(person1, person2).doubleValue());
    }
}


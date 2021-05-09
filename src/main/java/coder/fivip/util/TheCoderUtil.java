package coder.fivip.util;

import coder.fivip.model.PersonWhoKilledByTheWitch;

public class TheCoderUtil {
    public static Integer getNumberOfVillagerThatKilledByTheWitch(Integer year) {
        if (year == 1) {
            return 1;
        }

        if (year == 0) {
            return 0;
        }

        return getNumberOfVillagerThatKilledByTheWitch(year-1) + getNumberOfVillagerThatKilledByTheWitch(year-2) + 1;
    }

    public static Double getAverage(PersonWhoKilledByTheWitch person1, PersonWhoKilledByTheWitch person2) {
        Integer resultForPerson1 = person1.getYearOfDeath() - person1.getAgeOfDeath();
        Integer resultForPerson2 = person2.getYearOfDeath() - person2.getAgeOfDeath();

        Double totalOfVillagerFromPerson1Year = getNumberOfVillagerThatKilledByTheWitch(resultForPerson1).doubleValue();
        Double totalOfVillagerFromPerson2Year = getNumberOfVillagerThatKilledByTheWitch(resultForPerson2).doubleValue();

        return (totalOfVillagerFromPerson1Year + totalOfVillagerFromPerson2Year) / 2;
    }

    public static Boolean validateAgeAndYearOfDeath(PersonWhoKilledByTheWitch person) {
        if(person.getAgeOfDeath() < 0 || person.getYearOfDeath() < 0 || person.getAgeOfDeath() > person.getYearOfDeath()) {
            return false;
        }
        return true;
    }
}

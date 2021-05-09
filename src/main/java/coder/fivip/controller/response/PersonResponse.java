package coder.fivip.controller.response;

import coder.fivip.model.PersonWhoKilledByTheWitch;

public class PersonResponse extends PersonWhoKilledByTheWitch {
    private Integer numberOfPeopleKilledOnTheYear;

    public Integer getNumberOfPeopleKilledOnTheYear() {
        return numberOfPeopleKilledOnTheYear;
    }

    public void setNumberOfPeopleKilledOnTheYear(Integer numberOfPeopleKilledOnTheYear) {
        this.numberOfPeopleKilledOnTheYear = numberOfPeopleKilledOnTheYear;
    }
}

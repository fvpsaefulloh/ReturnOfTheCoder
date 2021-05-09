package coder.fivip.controller.request;

import coder.fivip.model.PersonWhoKilledByTheWitch;

public class PersonRequest {
    PersonWhoKilledByTheWitch person1;
    PersonWhoKilledByTheWitch person2;

    public PersonWhoKilledByTheWitch getPerson1() {
        return person1;
    }

    public void setPerson1(PersonWhoKilledByTheWitch person1) {
        this.person1 = person1;
    }

    public PersonWhoKilledByTheWitch getPerson2() {
        return person2;
    }

    public void setPerson2(PersonWhoKilledByTheWitch person2) {
        this.person2 = person2;
    }
}

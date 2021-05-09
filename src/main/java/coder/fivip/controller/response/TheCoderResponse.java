package coder.fivip.controller.response;

import coder.fivip.model.PersonWhoKilledByTheWitch;

public class TheCoderResponse {
    private PersonResponse person1;
    private PersonResponse person2;
    private Double result;

    public PersonResponse getPerson1() {
        return person1;
    }

    public void setPerson1(PersonResponse person1) {
        this.person1 = person1;
    }

    public PersonResponse getPerson2() {
        return person2;
    }

    public void setPerson2(PersonResponse person2) {
        this.person2 = person2;
    }

    public Double getResult() {
        return result;
    }

    public void setResult(Double result) {
        this.result = result;
    }
}

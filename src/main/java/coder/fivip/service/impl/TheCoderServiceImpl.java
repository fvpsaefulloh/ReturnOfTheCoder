package coder.fivip.service.impl;

import coder.fivip.controller.request.PersonRequest;
import coder.fivip.controller.response.PersonResponse;
import coder.fivip.controller.response.TheCoderResponse;
import coder.fivip.model.PersonWhoKilledByTheWitch;
import coder.fivip.service.TheCoderService;
import coder.fivip.util.TheCoderUtil;
import org.springframework.stereotype.Service;

@Service
public class TheCoderServiceImpl implements TheCoderService {
    @Override
    public TheCoderResponse getResult(PersonRequest request){
        TheCoderResponse response = new TheCoderResponse();
        if(TheCoderUtil.validateAgeAndYearOfDeath(request.getPerson1()) && TheCoderUtil.validateAgeAndYearOfDeath(request.getPerson2())) {
            PersonResponse person1Response = getPersonResponse(response, request.getPerson1());
            PersonResponse person2Response = getPersonResponse(response, request.getPerson2());
            response.setPerson1(person1Response);
            response.setPerson2(person2Response);
            response.setResult(TheCoderUtil.getAverage(request.getPerson1(), request.getPerson2()));
        } else {
            response.setResult(-1D);
        }
        return response;
    }

    private PersonResponse getPersonResponse(TheCoderResponse theCoderResponse, PersonWhoKilledByTheWitch person) {
        PersonResponse personResponse = new PersonResponse();
        personResponse.setAgeOfDeath(person.getAgeOfDeath());
        personResponse.setYearOfDeath(person.getYearOfDeath());
        Integer substractResult = person.getYearOfDeath() - person.getAgeOfDeath();
        personResponse.setNumberOfPeopleKilledOnTheYear(TheCoderUtil.getNumberOfVillagerThatKilledByTheWitch(substractResult));
        return personResponse;

    }
}

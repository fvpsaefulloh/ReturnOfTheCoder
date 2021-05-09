package coder.fivip.service;

import coder.fivip.controller.request.PersonRequest;
import coder.fivip.controller.response.TheCoderResponse;
import coder.fivip.model.PersonWhoKilledByTheWitch;

public interface TheCoderService {
    TheCoderResponse getResult(PersonRequest request);
}

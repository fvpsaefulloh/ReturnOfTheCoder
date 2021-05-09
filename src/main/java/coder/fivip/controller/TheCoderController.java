package coder.fivip.controller;

import coder.fivip.controller.request.PersonRequest;
import coder.fivip.controller.response.TheCoderResponse;
import coder.fivip.model.PersonWhoKilledByTheWitch;
import coder.fivip.service.TheCoderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/theCoder")
public class TheCoderController {
    private final TheCoderService theCoderService;

    TheCoderController(TheCoderService theCoderService) {
        this.theCoderService = theCoderService;
    }
    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @PostMapping(value = "/getResult", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getResult(@RequestBody PersonRequest request) {
        TheCoderResponse response = theCoderService.getResult(request);
        return ResponseEntity.ok(response);
    }
}

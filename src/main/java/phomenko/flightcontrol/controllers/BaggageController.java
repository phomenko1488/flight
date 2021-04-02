package phomenko.flightcontrol.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import phomenko.flightcontrol.services.BaggageService;

import static phomenko.flightcontrol.controllers.JSON.errorWithMessage;
import static phomenko.flightcontrol.controllers.JSON.singleJsonObject;

@RestController
public class BaggageController {

    private final BaggageService baggageService;
    @Autowired
    public BaggageController(BaggageService baggageService) {
        this.baggageService = baggageService;
    }

    @GetMapping("checkIn")
    public Object checkIn(@RequestParam(name = "destinationId") String destinationId,
                        @RequestParam(name = "baggageId") String baggageId){
        try {
            return singleJsonObject("result", baggageService.checkIn(Long.parseLong(destinationId),Long.parseLong(baggageId)));
        }
        catch (NumberFormatException ignored) {
            return errorWithMessage("Invalid data format");
        }
    }
}

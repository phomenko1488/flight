package phomenko.flightcontrol.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import phomenko.flightcontrol.services.TicketService;


import static phomenko.flightcontrol.controllers.JSON.errorWithMessage;
import static phomenko.flightcontrol.controllers.JSON.singleJsonObject;

@RestController
public class TicketController {

    private final TicketService ticketService;
    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping("available")
    public Object exist(@RequestParam(name = "ticketID") String ticketID){
        try {
            return singleJsonObject("result", ticketService.available(Long.parseLong(ticketID)));
        }
        catch (NumberFormatException ignored) {
            return errorWithMessage("Invalid data format");
        }
    }

}

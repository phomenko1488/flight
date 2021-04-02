package phomenko.flightcontrol.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
@AllArgsConstructor
@Data
public class Ticket {
    private long id;
    private double price;
    private boolean available;
    //место отправления
    private Place departure;
    //место назначения
    private Place destination;

    private Baggage baggage;

    private Coupon coupon;
}

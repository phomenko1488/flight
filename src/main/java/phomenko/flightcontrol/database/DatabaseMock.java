package phomenko.flightcontrol.database;

import phomenko.flightcontrol.entities.Baggage;
import phomenko.flightcontrol.entities.Coupon;
import phomenko.flightcontrol.entities.Place;
import phomenko.flightcontrol.entities.Ticket;

import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class DatabaseMock {
    public static Map<Long, Ticket> getTickets() {
        return tickets;
    }
    static Map<Long, Baggage> baggage;
    public static Map<Long, Baggage> getBaggage() {
        AtomicLong itterator = new AtomicLong(0);
        getTickets().values().parallelStream().map(Ticket::getBaggage).forEach(currentBaggage -> baggage.put(itterator.getAndIncrement(),currentBaggage));
        return baggage;
    }
    static Map<Long, Coupon> coupons;
    public static Map<Long, Coupon> getCoupons() {
        AtomicLong itterator = new AtomicLong(0);
        getTickets().values().parallelStream().map(Ticket::getCoupon).forEach(coupon -> coupons.put(itterator.getAndIncrement(),coupon));
        return coupons;
    }
    private static final Map<Long, Ticket> tickets = Map.of(
            1L, new Ticket(1,149,true,new Place(1,52.52424,53.42421),new Place(1,52.52424,53.42421),new Baggage(0,111f,55f,false),new Coupon(1,20)),
            2L, new Ticket(2,232,true,new Place(1,52.52424,53.42421),new Place(1,52.52424,53.42421),new Baggage(0,124f,35f,false),new Coupon(2,22)),
            3L, new Ticket(3,182,true,new Place(1,52.52424,53.42421),new Place(1,52.52424,53.42421),new Baggage(0,133f,515f,false),new Coupon(3,30)),
            4L, new Ticket(4,419,true,new Place(1,52.52424,53.42421),new Place(1,52.52424,53.42421),new Baggage(0,140f,552f,false),new Coupon(4,31)),
            5L, new Ticket(5,247,true,new Place(1,52.52424,53.42421),new Place(1,52.52424,53.42421),new Baggage(0,141f,44f,false),new Coupon(5,19)),
            6L, new Ticket(6,94,true,new Place(1,52.52424,53.42421),new Place(1,52.52424,53.42421),new Baggage(0,143f,32f,false),new Coupon(6,11)),
            7L, new Ticket(7,78,true,new Place(1,52.52424,53.42421),new Place(1,52.52424,53.42421),new Baggage(0,144f,14f,false),new Coupon(7,32)),
            8L, new Ticket(8,182,true,new Place(1,52.52424,53.42421),new Place(1,52.52424,53.42421),new Baggage(0,12f,15f,false),new Coupon(8,33)),
            9L, new Ticket(9,144,true,new Place(1,52.52424,53.42421),new Place(1,52.52424,53.42421),new Baggage(0,13f,50f,false),new Coupon(9,35)),
            10L, new Ticket(10,555,true,new Place(1,52.52424,53.42421),new Place(1,52.52424,53.42421),new Baggage(0,19f,11f,false),new Coupon(10,36))
    );

}

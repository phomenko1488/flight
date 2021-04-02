package phomenko.flightcontrol.services;

import org.springframework.stereotype.Service;
import phomenko.flightcontrol.entities.Coupon;
import phomenko.flightcontrol.repositories.CouponRepository;

import java.util.*;

import static phomenko.flightcontrol.database.DatabaseMock.getCoupons;

@Service
public class CouponService implements CouponRepository {

    Map<Long, Coupon> database = getCoupons();
    List <Integer> sales = Arrays.asList(10, 50, 60);
    public Object getSale(long couponID, double price) {
        if (!exist(couponID))
        return false;
        int sale = sales.get(new Random().nextInt(sales.size()));
        database.put((long) database.size(), new Coupon(database.size(),sale));
        return price - price/100*sale;
    }
    @Override
    public boolean exist(Long id) {
        return database.containsKey(id);
    }

    @Override
    public Coupon getCouponByID(Long id) {
        return database.get(id);
    }

    @Override
    public Collection<Coupon> getAll() {
        return database.values();
    }
}

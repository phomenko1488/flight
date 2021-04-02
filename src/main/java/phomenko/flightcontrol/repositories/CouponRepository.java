package phomenko.flightcontrol.repositories;

import phomenko.flightcontrol.entities.Coupon;

import java.util.Collection;

public interface CouponRepository {
    boolean exist(Long id);
    Coupon getCouponByID(Long id);
    Collection<Coupon> getAll();
}

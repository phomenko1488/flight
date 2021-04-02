package phomenko.flightcontrol.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import phomenko.flightcontrol.services.CouponService;

import static phomenko.flightcontrol.controllers.JSON.errorWithMessage;
import static phomenko.flightcontrol.controllers.JSON.singleJsonObject;

@RestController
public class CouponController {
    private final CouponService couponService;
    @Autowired
    public CouponController(CouponService couponService) {
        this.couponService = couponService;
    }

    @GetMapping("createCoupon")
    public Object createCoupon(@RequestParam(name = "couponID") String couponID,
                               @RequestParam(name = "price") String price){
        try {
            return singleJsonObject("result", couponService.getSale(Long.parseLong(couponID), Double.parseDouble(price)));
        }
        catch (NumberFormatException ignored) {
            return errorWithMessage("Invalid data format");
        }
    }
}

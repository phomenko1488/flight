package phomenko.flightcontrol.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
@AllArgsConstructor
@Data
public class Place {
    private long id;
    private double longitude;
    private double latitude;
}

package phomenko.flightcontrol.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
@AllArgsConstructor
@Data
public class Baggage {
    private long id;
    private float weight;
    private float height;
    private boolean checkIn;
}

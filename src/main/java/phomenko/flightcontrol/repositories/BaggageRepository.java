package phomenko.flightcontrol.repositories;

import phomenko.flightcontrol.entities.Baggage;

import java.util.Collection;

public interface BaggageRepository {
    boolean exist(Long id);
    Baggage getBaggageByID(Long id);
    Collection<Baggage> getAll();
}

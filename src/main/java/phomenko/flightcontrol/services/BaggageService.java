package phomenko.flightcontrol.services;

import org.springframework.stereotype.Service;
import phomenko.flightcontrol.entities.Baggage;
import phomenko.flightcontrol.repositories.BaggageRepository;

import java.util.Collection;
import java.util.Map;

import static phomenko.flightcontrol.database.DatabaseMock.getBaggage;

@Service
public class BaggageService implements BaggageRepository {

    Map<Long, Baggage> database = getBaggage();
    public boolean checkIn(long destinationId, long baggageId) {
        if (!database.containsKey(baggageId))
            return false;
        Baggage baggage = database.get(baggageId);
        baggage.setCheckIn(true);
        database.put(baggageId,baggage);
        return true;
    }
    @Override
    public boolean exist(Long id) {
        return database.containsKey(id);
    }

    @Override
    public Baggage getBaggageByID(Long id) {
        return database.get(id);
    }

    @Override
    public Collection<Baggage> getAll() {
        return database.values();
    }
}

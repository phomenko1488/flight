package phomenko.flightcontrol.services;

import org.springframework.stereotype.Service;
import phomenko.flightcontrol.database.DatabaseMock;
import phomenko.flightcontrol.entities.Ticket;
import phomenko.flightcontrol.repositories.TicketRepository;

import java.util.Collection;

@Service
public class TicketService implements TicketRepository {
    @Override
    public boolean exist(Long id) {
        return DatabaseMock.getTickets().containsKey(id);
    }
    public boolean available(Long id) {
        if (!DatabaseMock.getTickets().containsKey(id))
            return false;
        return DatabaseMock.getTickets().get(id).isAvailable();
    }

    @Override
    public Ticket getTicketByID(Long id) {
        return DatabaseMock.getTickets().get(id);
    }

    @Override
    public Collection<Ticket> getAll() {
        return DatabaseMock.getTickets().values();
    }
}

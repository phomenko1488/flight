package phomenko.flightcontrol.repositories;

import phomenko.flightcontrol.entities.Ticket;

import java.util.Collection;

public interface TicketRepository {
    boolean exist(Long id);
    Ticket getTicketByID(Long id);
    Collection<Ticket> getAll();
}

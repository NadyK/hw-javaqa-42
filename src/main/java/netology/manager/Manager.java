package netology.manager;

import netology.domain.InfoTicket;
import netology.repository.Repository;

import java.util.Arrays;
import java.util.function.Predicate;

public class Manager {
    private Repository repository;

    public Manager(Repository repository) {
        this.repository = repository;
    }

    public void add(InfoTicket ticket) {
        repository.save(ticket);
    }

    public InfoTicket[] searchByDepartureAndArrival(String departure, String arrival) {

        return findBy(ticket -> ticket.getDepartureAirport().equalsIgnoreCase(departure)
                && ticket.getArrivalAirport().equalsIgnoreCase(arrival));

    }

    private InfoTicket[] findBy(Predicate<InfoTicket> filter) {
        InfoTicket[] allFromRepo = repository.findAll();
        InfoTicket[] result = new InfoTicket[0];
        for (InfoTicket ticket : repository.findAll()) {
            if (filter.test(ticket)) {
                InfoTicket[] tmp = new InfoTicket[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }

}


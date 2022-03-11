package netology.repository;

import netology.domain.InfoTicket;

public class Repository {

    private InfoTicket[] tickets = new InfoTicket[0];

    public void save(InfoTicket ticket) {
        int length = tickets.length + 1;
        InfoTicket[] tmp = new InfoTicket[length];
        System.arraycopy(tickets, 0, tmp, 0, tickets.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = ticket;
        tickets = tmp;
    }
    public InfoTicket[] findAll() {
        return tickets;
    }

    public InfoTicket[] removeById(int id) {

        int length = tickets.length - 1;
        InfoTicket[] tmp = new InfoTicket[length];
        int index = 0;
        for (InfoTicket item : tickets) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        tickets = tmp;
        return tmp;
    }
}

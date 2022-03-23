package netology.manager;

import netology.domain.InfoTicket;
import netology.repository.Repository;
import org.junit.jupiter.api.Test;

import java.awt.print.Book;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {

    private final Repository repository = new Repository();
    private final Manager manager = new Manager(repository);
    InfoTicket first = new InfoTicket(1, 2000, "DME", "LED", 240);
    InfoTicket second = new InfoTicket(2, 500, "SVO", "LED", 120);
    InfoTicket third = new InfoTicket(3, 1000, "SVO", "OVB", 300);
    InfoTicket forth = new InfoTicket(4, 100, "SVO", "LED", 90);

    @Test
    void add() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(forth);


    }

    @Test
    void searchByDepartureAndArrival() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(forth);

        InfoTicket[] expected = new InfoTicket[]{forth, second};
        InfoTicket[] actual = manager.searchByDepartureAndArrival("SVO", "LED");

        assertArrayEquals(expected, actual);
    }
}
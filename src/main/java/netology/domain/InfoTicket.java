package netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class InfoTicket implements Comparable<InfoTicket>{
    private int id;
    private int price;
    private String departureAirport;
    private String arrivalAirport;
    private int travelTime;


    @Override
    public int compareTo(InfoTicket o) {
              return this.price - o.price;
    }
}

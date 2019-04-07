import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class FlightManagerTest {

    Plane plane;
    Passenger passenger;
    Flight flight;

    @Before
    public void setup(Plane plane, Passenger passenger, Flight flight) {
        this.passenger = passenger;
        this.flight = flight;
        this.plane = new Plane(PlaneType.BOEING_747);
        this.passenger = new Passenger("James", 2);
//        Date date = new LocalDateTime(16-03-2019);
        this.flight = new Flight(plane, "BOEING_747", 123, "Barcelona");
    }

    @Test
    public void canSortBySeatNumber() {
        for (int i = 0; i < 200; i++) {
            Passenger passenger = new Passenger("Kirsten", 1);
            flight.bookPassengerOnFlight(passenger);
        }

        FlightManager.sortBySeatNumber(flight);

        boolean isSorted = true;
        int top = flight.passengerCount();
        for (int i = 0; i < top - 1; i++) {
            int seatNumber = flight.getPassengers().get(i).getSeatNumber();
            int nextSeatNumber = flight.getPassengers().get(i + 1).getSeatNumber();
            if (seatNumber > nextSeatNumber) {
                isSorted = false;
                {
                }
            }
            assertEquals(true, isSorted);
        }
    }

    @Test
    public void canFindBySeatNumber(){
        for(int i = 0; i < 199; i++){
            Passenger passenger = new Passenger("Kirsten", 1);
            flight.bookPassengerOnFlight(passenger);
        }

        Passenger passengerToFind = new Passenger("Lorna", 1);
        passengerToFind.setSeatNumber(198);
        flight.addPassenger(passengerToFind);

        Passenger result = FlightManager.sortAndFindBySeatNumber(flight, 198);

        assertEquals(passengerToFind, result);
    }


}




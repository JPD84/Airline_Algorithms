import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

public class FlightTest {

    private Flight flight1;
    private List<Passenger> passengers;
    private Plane plane;
    private LocalDateTime departureTime;
    private Passenger passenger1;
    private Passenger passenger2;
    private Set<Integer> seatNumbers;

    @Before
    public void setup(){
        passengers = new ArrayList<>();
        passenger1 = new Passenger("James", 1);
        passenger2 = new Passenger("Kirsten", 3);
        plane = new Plane(PlaneType.BOEING_747);
        departureTime = LocalDateTime.of(2019, 1, 28, 12, 4);
        seatNumbers = new HashSet<>();
        flight1 = new Flight(passengers, plane, 123, "Bordeaux", "Glasgow", departureTime, seatNumbers);
    }

    @Test
    public void canBookPassengersOnPlane(){
        flight1.bookPassengerOnFlight(passenger1);
        assertEquals(1, flight1.getNumberOfPassengers());
        assertTrue(flight1.getPassengers().contains(passenger1));
    }

    @Test
    public void canCheckAvailableSeatsOnPlane(){
        assertEquals(200, flight1.getNumberOfAvailableSeats());
        passengers.add(passenger1);
        assertEquals(199, flight1.getNumberOfAvailableSeats());
    }

    @Test
    public void canGetDepartureTime(){
        assertEquals(12, flight1.getDepartureTime().getHour());
        assertEquals(4, flight1.getDepartureTime().getMinute());
    }

    @Test
    public void canAddFlightToPassengerUponBooking(){
        assertEquals(null, passenger1.getFlight());
        flight1.bookPassengerOnFlight(passenger1);
        assertEquals(123, passenger1.getFlight().getFlightNumber());
        assertEquals("Bordeaux", passenger1.getFlight().getDestination());
    }

    @Test
    public void assignRandomSeatNumberUponBooking(){
        flight1.bookPassengerOnFlight(passenger1);
        assertTrue(flight1.getSeatNumbers().contains(passenger1.getSeatNumber()));
    }

    @Test
    public void assignMultipleRandomSeatNumberUponBooking(){
        flight1.bookPassengerOnFlight(passenger1);
        flight1.bookPassengerOnFlight(passenger2);
        assertTrue(flight1.getSeatNumbers().contains(passenger1.getSeatNumber()));
        assertTrue(flight1.getSeatNumbers().contains(passenger2.getSeatNumber()));
    }

    @Test
    public void assignUniqueSeatNumbersUponBooking(){
        flight1.bookPassengerOnFlight(passenger1);
        flight1.bookPassengerOnFlight(passenger2);
        assertFalse(passenger1.getSeatNumber() == passenger2.getSeatNumber());
    }


}

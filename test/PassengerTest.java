import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PassengerTest {

    private Passenger passenger;
    private Flight flight;

    @Before
    public void setup(){
        passenger = new Passenger("James Davidson", 1);
//        passenger2 = new Passenger("Kirsten Davidson", 2, null, 0);
    }

    @Test
    public void canGetPassengerName(){
        assertEquals("James Davidson", passenger.getName());
    }

    @Test
    public void canGetPassengerBags(){
        assertEquals(1, passenger.getBags());
    }

    @Test
    public void canSetPassengerName(){
        passenger.setName("Mr JD");
        assertEquals("Mr JD", passenger.getName());
    }

    @Test
    public void canSetPassengerBags(){
        passenger.setBags(2);
        assertEquals(2, passenger.getBags());
    }

}

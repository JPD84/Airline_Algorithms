import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Flight {

    private List<Passenger> passengers;
    private Plane plane;
    private int flightNumber;
    private String destination;
    private String departureAirport;
    private LocalDateTime departureTime;
    private Set<Integer> seatNumbers;

    public Flight(List<Passenger> passengers, Plane plane, Integer flightNumber, String destination, String departureAirport, LocalDateTime departureTime, Set<Integer> seatNumbers){
        this.passengers = passengers;
        this.plane = plane;
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.departureAirport = departureAirport;
        this.departureTime = departureTime;
        this.seatNumbers = seatNumbers;
    }

    public Flight(Plane plane, String boeing_747, int i, String barcelona) {
    }

    public List<Passenger> getPassengers(){
        return passengers;
    }

    public int getNumberOfPassengers(){
        return passengers.size();
    }

    public Plane getPlane(){
        return plane;
    }

    public int getFlightNumber(){
        return flightNumber;
    }

    public String getDestination(){
        return destination;
    }

    public String getDepartureAirport(){
        return departureAirport;
    }

    public LocalDateTime getDepartureTime(){
        return departureTime;
    }

    public Set<Integer> getSeatNumbers(){
        return seatNumbers;
    }


    public Integer assignSeatNumber(){
        int randomNumber = getRandomNumberInRange(1, plane.getPlaneCapacity());
        Integer seatNumber = Integer.valueOf(randomNumber);

        // TODO Set only accepts non duplicate entries - refactor for non-recursive call?
        if (seatNumbers.add(seatNumber)) {
            System.out.println("Seat Assigned");
            return seatNumber;
        } else {
            System.out.println("Retrying unique seat number assigning");
            return assignSeatNumber();
        }
    }

    private static int getRandomNumberInRange(Integer min, Integer max) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    public int getNumberOfAvailableSeats(){
        int availableSeats = plane.getPlaneCapacity() - getNumberOfPassengers();
        return availableSeats;
    }

    public void bookPassengerOnFlight(Passenger passenger){
        if (getNumberOfAvailableSeats() > 0) {
            passengers.add(passenger);
            Integer newSeatNumber = assignSeatNumber();
            passenger.setSeatNumber(newSeatNumber);
            passenger.setFlight(new Flight(passengers,plane,flightNumber,destination,departureAirport,departureTime,seatNumbers));
        } else {
            System.out.println("No available seats on plane to book passenger");
        }

    }


    public int passengerCount() {
        return this.passengers.size();
    }

    public void replacePassenger(int index, Passenger passenger) {
        this.passengers.set(index, passenger);
    }

    public void addPassenger(Passenger passenger) { this.passengers.add(passenger);
    }
}

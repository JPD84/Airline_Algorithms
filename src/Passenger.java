public class Passenger {

    private String name;
    private Integer bags;

    private Flight flight;
    private int seatNumber;

    public Passenger(String name, int bags) {
        this.name = name;
        this.bags = bags;
        this.flight = flight;
        this.seatNumber = seatNumber;
    }

    public String getName() {
        return name;
    }

    public int getBags() {
        return bags;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public void setBags(Integer newBags) {
        this.bags = newBags;
    }

    public Flight getFlight() {
        return flight;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setFlight(Flight flight){
        this.flight = flight;
    }

    public void setSeatNumber(Integer seatNumber) {
        this.seatNumber = seatNumber;
    }
}

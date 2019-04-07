import java.util.List;

public class FlightManager {

    private Flight flight;

    private FlightManager(Flight flight){
        this.flight = flight;
    }

    public Integer maximumBaggageWeight(){
        Integer maxBagWeight = flight.getPlane().getPlaneWeight() / 2;
        return maxBagWeight;
    }

    public int maximumBaggageWeightPerPax(){
        return maximumBaggageWeight() / flight.getPlane().getPlaneCapacity();
    }

    public int currentBaggageWeight(){
        return flight.getNumberOfPassengers() * maximumBaggageWeightPerPax();
    }

    public int remainingBaggageWeight(){
        return maximumBaggageWeight() - currentBaggageWeight();
    }

    public static void sortBySeatNumber(Flight flight){
        for (int i = 0; i < flight.passengerCount(); i++){
            boolean isSorted = true;
            for (int j = 1; j < flight.passengerCount(); j++){
                int prevPassengerSeatNumber = flight.getPassengers().get(j -1).getSeatNumber();
                int passengerSeatNumber = flight.getPassengers().get(j).getSeatNumber();
                if (prevPassengerSeatNumber > passengerSeatNumber) {
                    Passenger temp = flight.getPassengers().get(j - 1);
                    flight.replacePassenger(j - 1, flight.getPassengers().get(j));
                    flight.replacePassenger(j, temp);
                    isSorted = false;
                }
                if (isSorted) break;

                }
            }
        }


    public static Passenger sortAndFindBySeatNumber(Flight flight, int seatNumberToFind) {
        sortBySeatNumber(flight);
        return findBySeatNumber(flight.getPassengers(), seatNumberToFind);
    }

    public static Passenger findBySeatNumber(List<Passenger> passengers, int seatNumberToFind) {
        int middleIndex = passengers.size() / 2;
        int passengerSeatNumber = passengers.get(middleIndex).getSeatNumber();
        if (passengerSeatNumber == seatNumberToFind) {
            Passenger passenger = passengers.get(middleIndex);
            return passenger;
        }
        if (seatNumberToFind < passengerSeatNumber) {
            List<Passenger> newList = passengers.subList(0, middleIndex);
            return findBySeatNumber(newList, seatNumberToFind);
        }
        if (seatNumberToFind > passengerSeatNumber) {
            List<Passenger> newList = passengers.subList(middleIndex, passengers.size());
            return findBySeatNumber(newList, seatNumberToFind);
        }
        return null;
    }
}


//
//     TODO bubbleSort of passengers
//    public List<Passenger> sortPassengersBySeat(){
//        List<Passenger> sortedList = bubbleSort(flight.getPassengers());
//        return sortedList;
//    }

//    private void bubbleSort(List<Passenger> passengers){
//        for (int pass = 1; pass <= passengers.size() - 1; pass++){
//            for (int compare = 1; compare <= passengers.size() - pass; compare++) {
//                Passenger first = (Passenger) passengers[compare - 1];
//                Passenger second = (Passenger) passengers[compare];
//                if (first.getSeatNumber() > second.getSeatNumber()){
//                    swap(compare - 1, compare);
//                }
//            }
//        }
//    }
//
//    private void swap(int x, int y){
//        Object temp = List[x];
//        List[x] = List[y];
//        List[y] = temp;
//    }
//
    // TODO binary search passengers list
//    public void findPassenegersBySeat(int seatNumber){
//        List<Passenger> sortedList = sortPassengersBySeat();
//        flight.getPassengers()....;
//    }



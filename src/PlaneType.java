public enum PlaneType {

    BOEING_747(200, 344000),
    AIRBUS_A380(300, 400000);

    private final Integer capacity;
    private final Integer weight;

    PlaneType(Integer capacity, Integer weight){
        this.capacity = capacity;
        this.weight = weight;
    }

    public Integer getCapacity(){
        return capacity;
    }

    public Integer getWeight(){
        return weight;
    }

}

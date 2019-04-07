public class Plane {

    private PlaneType planeType;

    public Plane(PlaneType planeType){
        this.planeType = planeType;
    }

    public Integer getPlaneCapacity(){
        return planeType.getCapacity();
    }

    public Integer getPlaneWeight(){
        return planeType.getWeight();
    }



}

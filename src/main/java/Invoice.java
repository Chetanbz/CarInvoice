public class Invoice {
    double distance;
    int time;

    private static final double MINIMUM_DISTANCE_PER_KM = 10;
    private double MINIMUM_PRICE_PER_time = 1;

    public Invoice(double distance, int time) {
        this.distance = distance;
        this.time = time;
    }
    public Invoice(){

    }

    public double getfare(double distance, int time) {
        double fair = MINIMUM_DISTANCE_PER_KM*distance + MINIMUM_PRICE_PER_time*time;
        if (fair < 5) return 5;
        return fair;
    }
    public double getfare(){
        return  getfare(distance,time);
    }
}

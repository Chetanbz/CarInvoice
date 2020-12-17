public class Invoice {
    double distance;
    int time;
    static int count ;
    private static final double MINIMUM_DISTANCE_PER_KM = 10;
    private double MINIMUM_PRICE_PER_time = 1;

    public Invoice(double distance, int time) {
        this.distance = distance;
        this.time = time;
        count++;
    }
    public Invoice(){

    }

}

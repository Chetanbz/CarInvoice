public class InvoiceSummary {
    String userID;
    int totalNoRides ;
    double totalFare;
    double avgFare;
    private static final double MINIMUM_DISTANCE_PER_KM = 10;
    private double MINIMUM_PRICE_PER_time = 1;
    int min_Prize = 5;
    private static final double MINIMUM_DISTANCE_PER_KM_PREMIUM = 15;
    private double MINIMUM_PRICE_PER_time_PREMIUM = 2;
    int min_Prize_Premim  = 20;

    public InvoiceSummary(int totalNoRides, double totalFare, double avgFare) {
        this.totalNoRides = totalNoRides;
        this.totalFare = totalFare;
        this.avgFare = avgFare;
    }
    public InvoiceSummary(){

    }

    public double getfare(Invoice invoice){
        double distance = invoice.distance;
        int time = invoice.time;
        double fair = MINIMUM_DISTANCE_PER_KM*distance + MINIMUM_PRICE_PER_time*time;
        if (fair < 5) return min_Prize;
        return fair;
    }
    public double getPremiumfare(Invoice invoice){
        double distance = invoice.distance;
        int time = invoice.time;
        double fair = MINIMUM_DISTANCE_PER_KM_PREMIUM*distance + MINIMUM_PRICE_PER_time_PREMIUM*time;
        if (fair < 20) return min_Prize_Premim;
        return fair;
    }

    public   InvoiceSummary calculateFare(Invoice[] invoices){
        double totalFare = 0.0;
        int count = 0;
        for(Invoice i : invoices ){
            totalFare += getfare(i);
            count++;
        }
        this.avgFare = totalFare/count;
        return  new InvoiceSummary(count,totalFare,avgFare);

    }

    public   InvoiceSummary calculateFarePremium(Invoice[] invoices){
        double totalFare = 0.0;
        int count = 0;
        for(Invoice i : invoices ){
            totalFare += getPremiumfare(i);
            count++;
        }
        this.avgFare = totalFare/count;
        return  new InvoiceSummary(count,totalFare,avgFare);

    }

}

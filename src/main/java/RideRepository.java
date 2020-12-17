import java.util.HashMap;
import java.util.Map;

public class RideRepository {
    static Map<String, InvoiceSummary> rideRepositoryList = new HashMap<>();

    public static  void addToRideRepository(String userId,InvoiceSummary invoiceSummary) {
        rideRepositoryList.put(userId,invoiceSummary);
    }

    public static InvoiceSummary getInvoiceSummary(String userId){
        return rideRepositoryList.get(userId);
    }

}

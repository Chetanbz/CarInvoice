import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

public class CarInvoiceTest {
    InvoiceSummary invoiceSummary = null;

    @Before
    public void setUp() throws Exception{
        invoiceSummary = new InvoiceSummary();
    }

    @Test
    public void  givenDistanceAndTimeShouldReturnFare(){
        double  distance = 2.01;
        int time         = 5;
        Invoice invoice  = new Invoice(distance,time) ;
        double fare = invoiceSummary.getfare(invoice);
        Assert.assertEquals(25,fare,0.1);
    }

    @Test
    public void givenlessDistanceShouldreturnFive(){
        double  distance = 0.1;
        int time         = 2;
        Invoice invoice  = new Invoice(distance,time) ;
        double fare = invoiceSummary.getfare(invoice);
        Assert.assertEquals(5,fare,0.0);
    }

    @Test
    public void givenMultipleRideShouldReturnInvoice(){
        Invoice [] invoices = {new Invoice(2,5),new Invoice(0.1,1) };
        InvoiceSummary invoiceSummary1 = invoiceSummary.calculateFare(invoices);
            Assert.assertEquals(30, invoiceSummary1.totalFare , 0.0);
    }

    @Test
    public void givenMultipleRideShouldReturnInvoiceMultipleThing(){
        Invoice [] invoices = {new Invoice(2,5),new Invoice(0.1,1) };
        InvoiceSummary invoiceSummary1 = invoiceSummary.calculateFare(invoices);
        Assert.assertEquals(2,invoiceSummary1.totalNoRides);
        Assert.assertEquals(30, invoiceSummary1.totalFare , 0.0);
        Assert.assertEquals(15,invoiceSummary1.avgFare,0.0);
    }
    @Test
    public void givenMultipleRideeWithTDShouldReturnInvoice(){
        String userId1 = "Chetan";
        Invoice [] invoices1 = {new Invoice(2,5),new Invoice(0.1,1) };
        InvoiceSummary invoiceSummary1 = invoiceSummary.calculateFare(invoices1);

        String userId2 = "Ram";
        Invoice [] invoices2 = {new Invoice(3,5),new Invoice(0.1,1),new Invoice(2,5) };
        InvoiceSummary invoiceSummary2 = invoiceSummary.calculateFare(invoices2);

        RideRepository.addToRideRepository(userId1,invoiceSummary1);
        RideRepository.addToRideRepository(userId2,invoiceSummary2);

        InvoiceSummary obtainInvoiceForUser1 = RideRepository.getInvoiceSummary(userId1);
        InvoiceSummary obtainInvoiceForUser2 = RideRepository.getInvoiceSummary(userId2);

        Assert.assertEquals(2,obtainInvoiceForUser1.totalNoRides);
        Assert.assertEquals(30, obtainInvoiceForUser1.totalFare , 0.0);
        Assert.assertEquals(15,obtainInvoiceForUser1.avgFare,0.0);

        Assert.assertEquals(3,obtainInvoiceForUser2.totalNoRides);
        Assert.assertEquals(65, obtainInvoiceForUser2.totalFare , 0.0);
        Assert.assertEquals(21.66,obtainInvoiceForUser2.avgFare,0.66);
    }
    @Test
    public void givenMultipleRideeWithTDShouldReturnInvoiceForPremium(){
        String userId1 = "Chetan";
        Invoice [] invoices1 = {new Invoice(2,5),new Invoice(0.1,1) };
        InvoiceSummary invoiceSummary1 = invoiceSummary.calculateFarePremium(invoices1);

        String userId2 = "Ram";
        Invoice [] invoices2 = {new Invoice(3,5),new Invoice(0.1,1),new Invoice(2,5) };
        InvoiceSummary invoiceSummary2 = invoiceSummary.calculateFarePremium(invoices2);

        RideRepository.addToRideRepository(userId1,invoiceSummary1);
        RideRepository.addToRideRepository(userId2,invoiceSummary2);

        InvoiceSummary obtainInvoiceForUser1 = RideRepository.getInvoiceSummary(userId1);
        InvoiceSummary obtainInvoiceForUser2 = RideRepository.getInvoiceSummary(userId2);

        Assert.assertEquals(2,obtainInvoiceForUser1.totalNoRides);
        Assert.assertEquals(60, obtainInvoiceForUser1.totalFare , 0.0);
        Assert.assertEquals(30,obtainInvoiceForUser1.avgFare,0.0);

        Assert.assertEquals(3,obtainInvoiceForUser2.totalNoRides);
        Assert.assertEquals(115, obtainInvoiceForUser2.totalFare , 0.0);
        Assert.assertEquals(38.22,obtainInvoiceForUser2.avgFare,0.66);
    }


}

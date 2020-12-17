import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

public class CarInvoiceTest {

    @Test
    public void  givenDistanceAndTimeShouldReturnFare(){
        Invoice invoice  = new Invoice() ;
        Scanner sc = new Scanner(System.in);
        double  distance = 2.01;
        int time         = 5;
        double fare = invoice.getfare(distance,time);
        Assert.assertEquals(25,fare,0.1);
        sc.close();
    }
    @Test
    public void givenlessDistanceShouldreturnFive(){
        Invoice invoice  = new Invoice() ;
        Scanner sc = new Scanner(System.in);
        double  distance = 0.1;
        int time         = 2;
        double fare = invoice.getfare(distance,time);
        Assert.assertEquals(5,fare,0.0);
        sc.close();

    }
    @Test
    public void givenMultipleRideShouldReturnInvoice(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Give Total number rides");
        Invoice [] invoices = {new Invoice(2,5),new Invoice(0.1,1) };
        List inv = Arrays.asList(invoices);
        double totalFare = 0.0;
        for(Invoice i : invoices ){
            totalFare += i.getfare();
        }
            Assert.assertEquals(30, totalFare , 0.0);
            sc.close();
    }
    @Test
    public void givenMultipleRideShouldReturnInvoiceMultipleThing(){
        Scanner sc = new Scanner(System.in);
        Invoice [] invoices = {new Invoice(2,5),new Invoice(0.1,1) };
        int totalRide = Invoice.count;
        List inv = Arrays.asList(invoices);
        double totalFare = 0.0;
        for(Invoice i : invoices ){
            totalFare += i.getfare();
        }
        double avgFare = totalFare/totalRide;
        Assert.assertEquals(2,totalRide);
        Assert.assertEquals(30, totalFare , 0.0);
        Assert.assertEquals(15,avgFare,0.0);
        sc.close();
    }

}

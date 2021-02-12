import java.io.*;

public class gasStation 
{
    private double regprice; //price for a gallon of regular
    private double superprice; //price for a gallon of super
    private double sales; //total sales of stations in dollars
    private double amount; //total amount of gallons in the station
    public int bestsales;

    public gasStation(double r, double s) 
    {
        regprice = r;
        superprice = s;
        sales = 0;
        amount = 1000;
    }

    public void sellregular(double gallons) 
    {
        amount = amount - gallons;
        sales += regprice * gallons; //multiplication

    }

    public void sellsuper(double gallons) 
    {
        amount = amount - gallons;
        sales += superprice * gallons;

    }

    public void gasamount(double gallons) 
    {
        sales += superprice * gallons;

    }

    public double getSales() 
    {
        return sales;
    }

    public double getGallons() 
    {
        return amount;
    }

    public boolean moreProfit(gasStation other) 
    {
        return sales > other.sales;
    }

    private void gouge() 
    {
        superprice *= 2;
        regprice *= 2;
    }

    public static void main(String[] argv) 
    {
        
        gasStation A = new gasStation(1.69, 2.09);
        gasStation B = new gasStation(2.49, 2.99);
        System.out.println("Gallons = "+ A.getGallons());
        System.out.println("Gallons = "+ B.getGallons());
        // determine what is setting gallons to less than a reasonable amount
        //A.gouge();
        //B.gouge();
        A.sellregular(10);
        A.sellsuper(8);
        B.sellregular(11);
        B.sellsuper(12);

        System.out.println("Sales = "+ Math.round(A.getSales()));
        System.out.println("Sales = "+ Math.round(B.getSales()));
        System.out.println("Gallons = "+ Math.round(A.getGallons()));
        System.out.println("Gallons = "+ Math.round(B.getGallons()));

        if (A.moreProfit(B)) 
        {
            System.out.println("Station A is more profitable. \n");
        } else 
        {
            System.out.println("Station B is more profitable. \n");
        }

        // You've made a lot of money and now you own a whole array of gas stations
        gasStation[] G = new gasStation[10];
        for (int i = 0; i < 10; i++) 
        {
            G[i] = new gasStation(2.59, 3.19);
        }

        for (int i = 0; i < 10; i++) 
        {
            G[i].sellregular(Math.random() * 500);
            G[i].sellsuper(Math.random() * 500);
            System.out.println("Gas Station " + i + "\n" + " Balance = " + Math.round(G[i].getSales()));
            System.out.println("Supply = " + Math.round(G[i].getGallons())+ "\n");
            if (G[i].getGallons() == 200 || G[i].getGallons() < 200)
                {
                    System.out.println("Gas Station " + i + " has less than 200 gallons.");
                    System.out.println("Gas Station " + i + " had its prices gouged.");
                }
        }

        gasStation highest = G[0];
        for (int i = 1; i < 10; i++) 
        {
            if (G[i].moreProfit(highest)) 
            {
                highest = G[i];
                i = bestsales;
            }
            System.out.println(i);
        }
        System.out.println("Highest Sales was  Gas Station " + highest + " with $" + Math.round(highest.getSales()));
        //System.out.print(Math.round(highest.getSales()));
        //System.out.print("\n");
    }
}
//End of program
//Test Commit - DESKTOP10PC
import java.io.*;

public class gasStation 
{
    private double regprice; //price for a gallon of regular
    private double superprice; //price for a gallon of super
    private double sales; //total sales of stations in dollars

    public gasStation(double r, double s) 
    {
        regprice = r;
        superprice = s;
        sales = 0;
    }

    public void sellregular(double gallons) 
    {
        sales += regprice * gallons; //multiplication
    }

    public void sellsuper(double gallons) 
    {
        sales += superprice * gallons;

    }

    public double getSales() 
    {
        return sales;
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

        A.sellregular(10);
        A.sellsuper(8);
        B.sellregular(11);
        B.sellsuper(12);

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
            G[i].sellregular((int) Math.random() * 20);
            G[i].sellsuper((int) Math.random() * 20);
        }

        gasStation highest = G[0];
        for (int i = 1; i < 10; i++) 
        {
            if (highest[i].moreProfit(highest)) 
            {
                highest = G[i];
            }
        }
        System.out.print("highest total sales is ");
        System.out.print(highest.getSales());
        System.out.print("\n");
    }
}
//End of program
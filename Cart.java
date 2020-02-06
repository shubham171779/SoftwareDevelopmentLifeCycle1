package SoftwareDevelopmentLifeCycle1;



import java.util.HashMap;

import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class Cart
{

    static  HashMap<Product,Integer> map = new HashMap<>();
    static Product pr[] = new Product[6];
    static  void addProducts(String prod_name,Product []pr,int quantity)
    {

        for(int i=0;i<6;i++)
        {
            if(prod_name.equals(pr[i].prod_name))
            {
                map.put(pr[i],quantity);
                break;
            }
        }
    }
    static void removeProduct(String prod_name,Product []pr,int quantity)
    {
        for(int i=0;i<6;i++)
        {
            if(prod_name.equals(pr[i].prod_name))
            {
                int val = map.get(pr[i]);
                map.remove(pr[i]);
                val=val-quantity;
                map.put(pr[i],val);
                break;
            }
        }
    }
    static double totalPrice()
    {
        double total=0.0;

        for(int i=0;i<6;i++) {
            if (map.containsKey(pr[i])) {
                int quantity = map.get(pr[i]);
                double price = pr[i].price;
                total = total + (quantity * price);

            }
        }
        return total;

    }
    static int returnperiodprod(String prodname)
    {
        int rperiod=0;
        for(int i=0;i<6;i++)
        {
            if(pr[i].prod_name.equals(prodname))
            {
                rperiod=pr[i].returnperiod;
                break;
            }
        }
        return rperiod;
    }
    static double bill()
    {
        double bill=0.0;
        double sgst=0.0;
        double cgst=0.0;
        double tax=0.0;
        for(int i=0;i<6;i++)
        {
            if(map.containsKey(pr[i]))
            {
                sgst=pr[i].sgst;
                cgst=pr[i].cgst;
                System.out.println("The sgst and cgst applied on "+pr[i].prod_name +" is "+sgst+"% and "+cgst+"% respectively");

                tax=(((sgst*pr[i].price)/100)*map.get(pr[i]))+(((cgst*pr[i].price)/100)*map.get(pr[i]));
                System.out.println("The total cost of "+pr[i].prod_name+" after applying the gst is "+(tax+pr[i].price));
                bill=bill+ pr[i].price+tax;

            }
        }

        return bill;
    }

    public static void  main(String []args)
    {

            int choice=0;
            Scanner sc = new Scanner(System.in);
            pr[0]=new Product(1,"Jam",100,"Organic");
            pr[1]=new Product(2,"Cookies",50,"organic");
            pr[2]=new Product(3,"earphone",250,"Luxury");
            pr[3]=new Product(4,"Wrist Watch",1000,"Luxury");
            pr[4]=new Product(5,"t-shirt",400,"Apparels");
            pr[5]=new Product(6,"Jean",1000,"Apparels");
            System.out.println("Products available to add in cart are");
            System.out.println("Organic Products - Jam,cookies");
            System.out.println("Luxury Products - Earphone,Wrist Watch");
            System.out.println("Apparels - t-shirt,Jean");
            Cart cart = new Cart();
        while(choice!=5)
        {
            System.out.println("Enter \n 1 to add Product \n 2 to remove Product \n 3 to see the total of items price in the cart \n 4 to get Product return details \n 5 to go for billing");
            String prod_name;
            int quantity;

                choice=sc.nextInt();
                sc.nextLine();
                switch (choice)
                {

                    case 1:
                        System.out.println("Enter product name to insert into cart and quantity");
                        prod_name = sc.next();
                        quantity=sc.nextInt();
                        addProducts(prod_name, pr,quantity);
                        break;
                    case 2:
                        System.out.println("Enter product name and quantity to remove from cart");
                        prod_name = sc.next();
                        int num=sc.nextInt();
                        removeProduct(prod_name, pr,num);
                        break;
                    case 3:
                        double total = totalPrice();
                        System.out.println("Total of the cart without applying tax is " + total);
                        break;
                     case 4:
                        System.out.println("Enter the product name of which to find return period ");
                        String name=sc.nextLine();
                        int returnperiod=returnperiodprod(name);
                        if(returnperiod==0)
                            System.out.println("Product is not returnable");
                        else
                            System.out.println("The return period of "+name+" is "+returnperiod+" days ");
                }
        }
       double bill = bill();
        System.out.println("The total amount payable is Rs "+bill);






    }
}



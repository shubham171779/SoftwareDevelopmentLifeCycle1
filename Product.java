package SoftwareDevelopmentLifeCycle1;

public class Product {
    int id;
    String prod_name;
    double price;
    String category;
    double sgst;
    double cgst;
    int returnperiod;
    Product()
    {

    }
    Product(int id,String prod_name,double price,String category)
    {
        this.id=id;
        this.prod_name=prod_name;
        this.price=price;
        this.category=category;
        if(this.category.equals("organic"))
        {
            sgst=5;
            cgst=5;
            returnperiod = 1;
        }
        else if(this.category.equals("Luxury"))
        {
            sgst=15;
            cgst=15;
            returnperiod=0;
        }
        else
        {
            sgst=10;
            cgst=10;
            returnperiod=30;
        }
    }
}

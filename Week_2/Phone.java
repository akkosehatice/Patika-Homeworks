package Week_2;

public class Phone extends Product {
    int phoneNumber;

    Phone(){}
    Phone(int id , String name , double price, int phoneNumber){
        super(id,name,price);
        this.phoneNumber = phoneNumber;
    }
}


package Week_2;

public class Main {
    public static void main(String[] args) {

        PhoneApp phone = new PhoneApp();
        double totalPrice = phone.calculateTotalPrice(phone.phone);
        System.out.println("Toplam Fiyat : "+totalPrice);
    }
}
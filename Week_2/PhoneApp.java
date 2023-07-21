package Week_2;

public class PhoneApp {
    SmartPhone[] phone = new SmartPhone[]{
            new SmartPhone(1, "Samsung Galaxy S22 5G", 20000, 5486525, 128, 8, "50 MP +12 MP +10 MP"),
            new SmartPhone(2, "Xiaomi Redmi Note 10S", 8000, 558562, 128, 8, "64 MP + 8 MP + 2 MP + 2 MP"),
            new SmartPhone(3, "Poco X5 Pro 5G ", 14000, 558221, 256, 8, "108 MP + 8 MP + 2 MP"),
            new SmartPhone(4, "Samsung Galaxy S23 Ultra ", 50000, 548565, 512, 12, "200 MP + 12 MP + 10 MP + 10 MP"),
            new SmartPhone(5, "iPhone 14 Pro Max ", 67500, 558524, 256, 6, "48 MP + 12 MP + 12 MP")};

    Double calculateTotalPrice(SmartPhone[] smartPhoneArray) {
        double totalPrice = 0;
        for (SmartPhone phone : phone) {
            totalPrice += phone.price;
        }
        return totalPrice;
    }
}

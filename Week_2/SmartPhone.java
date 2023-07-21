package Week_2;

public class SmartPhone extends Phone {
    int storage;
    int ram;
    String camera;

    SmartPhone() {

    }

    SmartPhone(int id, String name, double price, int phoneNumber, int storage, int ram, String camera) {
        super(id, name, price, phoneNumber);
        this.storage = storage;
        this.ram = ram;
        this.camera = camera;
    }
}
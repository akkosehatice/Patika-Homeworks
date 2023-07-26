package Week_3;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private boolean isOpen = false;
    public static List<Controller> controllers = new ArrayList<>();

    public  void open() throws Exception {
        if (isOpen){
            throw new Exception("Bilgisayar Zaten Açık!");
        }
        else {
            isOpen = true;
            System.out.println("Bilgisayar Açıldı!");
        }
    }
    public void  shutdown() throws Exception {
        if (!isOpen){
            throw new Exception("Bilgisayar Zaten Kapalı!");
        }else {
            isOpen = false;
            System.out.println("Bilgisayar Kapatıldı!");
        }
    }
    // oyunu başlatmak için bilgisayarın durumunu ve controllers listesinde cihaz varlığını inceler
    // bilgisayarın açık olması durumunda ve bilgisayara bağlı cihaz olması durumunda oyunu başlatır.
    void playGame() {
        if (!isOpen) {
            throw new RuntimeException("Bilgisayar Kapalı!");
        }
        if (controllers.isEmpty()) {
            throw new RuntimeException("Bilgisayara Bağlı Bir Cihaz Yok!");
        }
        for (Controller controller : controllers){
            System.out.println("Bağlı Cihazlar : "+ controller);
        }

        System.out.println("Oyun Başladı...");


    }

}

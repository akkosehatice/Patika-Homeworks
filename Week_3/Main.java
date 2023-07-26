package Week_3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Xbox xbox = new Xbox();
        Playstation playstation = new Playstation();
        Computer computer = new Computer();
        computer.open();
        System.out.println("Cihaz Seçiniz :\n 1 - Xbox \n 2- Playstation ");
        int deger = scanner.nextInt();
        if (deger == 1){
            System.out.println("Xbox Seçildi ");
            xbox.open();
            xbox.addController();
        }else if (deger == 2){
            System.out.println("Playstation Seçildi");
            playstation.open();
            playstation.addController();
        }else {
            throw new Exception("Geçersiz İşlem !");
        }

        computer.playGame();










    }
}

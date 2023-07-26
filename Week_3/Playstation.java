package Week_3;

public class Playstation extends  Controller implements IGameController{
    private boolean isOpen = false;
    @Override
    public  void open() throws Exception {
        if (isOpen){
            throw new Exception("Playstation Zaten Açık!");
        }
        else {
            isOpen = true;
            System.out.println("Playstation Açıldı !");
        }
    }
    public void  shutdown() throws Exception {
        if (!isOpen){
            throw new Exception("Playstation Zaten Kapalı!");
        }else {
            isOpen = false;
            System.out.println("Playstation Kapatıldı!");
        }
    }
    // Playstation'u bilgisayara bağlamak için controllers listesine ekler. kapalı olması durumunda hata fırlatır...
    @Override
    public void addController() {
        if (!isOpen) {
            throw new RuntimeException("Playstation Kapalı!");
        }
        Computer.controllers.add(this);
        System.out.println("Playstation Bilgisayara Eklendi...");
    }



}

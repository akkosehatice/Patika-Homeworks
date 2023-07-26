package Week_3;

public class Xbox extends Controller implements IGameController{
    private boolean isOpen = false;

    @Override
    public  void open() throws Exception {
        if (isOpen){
            throw new Exception("Xbox Zaten Açık!");
        }
        else {
            isOpen = true;
            System.out.println("Xbox Açıldı !");
        }
    }
    public void  shutdown() throws Exception {
        if (!isOpen){
            throw new Exception("Xbox Zaten Kapalı!");
        }else {
            isOpen = false;
            System.out.println("Xbox Kapatıldı!");
        }
    }
    // Xbox'u controllers listesine ekleyerek bilgisayara bağlar kapalı olması durumunda hata fırlatır
    @Override
    public void addController() {
        if (!isOpen) {
            throw new RuntimeException("Xbox Kapalı!");
        }
        Computer.controllers.add(this);
        System.out.println("Xbox Bilgisayara eklendi...");

    }





}

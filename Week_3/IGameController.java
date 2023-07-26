package Week_3;

public interface IGameController {
    // cihazların açık olma durumunu kontrol eder.
    // Açık olması durumunda hata fırlatır ve cihazın kapalı olması durumunda cihazın açılmasını sağlar
    void open() throws Exception;
    // Cihazların kapalı olma durumunu inceler. Zaten kapalı olması durumunda hata fırlatır.
    // Açık olması durumunda ise kapatır.
    void addController();





}

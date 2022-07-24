public class Main {
    /*
    Not:
        -JSON dosyası resources dosyasının altında bulunmakta.
        -JSON dosyası okuamk için pom.xml dosyasında "org.json" kütüphanesi yüklendi
        -FileService sınıfı öğrencileri json dosyasından okuyup ArrayList olarak dönen bir metoda sahip
        -Student sınıfı öğrenci bilgilerini tutan nesnelere sahip bir sınıf
        -ThreadProcessRead sınıfı JSON dosyasını okuyon bir Thread oluşturuyor
        -ThreadProccessWrite sınıfı JSON dosaysından okunan ve liste olarak dönen bilgileri yazdıran bir thread oluşturuyor
     */
    public static void main(String[] args) {

        //İlk olarak dosyadan okuma işlemi için bir thread oluşturuyoruz:
        ThreadProcessRead threadProcessRead = new ThreadProcessRead();

        Thread thread = new Thread(threadProcessRead);
        thread.start(); // oluşturduğumuz thread'ı başlatıyoruz

        //Okunan verileri yazdırmak için bir thread oluşturuyoruz.
        ThreadProccessWrite threadProccessWrite = new ThreadProccessWrite();

        Thread thread1 = new Thread(threadProccessWrite);
        thread1.start(); // oluşturduğumuz ikinci thread'ı başlatıyoruz
    }
}

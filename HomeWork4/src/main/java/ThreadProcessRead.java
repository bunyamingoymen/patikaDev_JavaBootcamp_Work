import java.util.ArrayList;

public class ThreadProcessRead implements Runnable{

    //İlk önce verileri aktaracağımız bir liste oluşturuyoruz (ThreadProcessWrite ile ortak kullanılacağı için hem public hem static olarak belirleniyor.)
    public static ArrayList<Student> list;
    @Override
    public void run() {
        try {
        System.out.println("Dosyadan okuma işlemi başlatılıyor...");
        Thread.sleep(500); // 0.5 saniyelik bir bekleme yapıyoruz
        FileServices fs = new FileServices(); // Dosya okuma işlemini başlatmak için bir nesne oluşturuyoruz.
        list = fs.readJsonFile(); // dosya okuma işlemini başlatıyoruz.

        }catch (InterruptedException e) {
           e.printStackTrace(); // sleep sistemi hata vermemesi için catch kısmını oluşturuyoruz.
        }
    }
}

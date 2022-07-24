public class ThreadProccessWrite implements Runnable{

    //Okuma işleminin bitip bitmediğini kontrol eden bir değişken oluşturuyoruz:
    public static boolean readProccess = false;

    @Override
    public void run() {
        try {
            //İlk olarak 3 saniye beletiyoruz.
            Thread.sleep(3000);
            // okuma işlemi bitti ise if'e girerek yazma işlemini başlatıyoruz.
            if(readProccess){
                System.out.println("Okuma işlemi bitti yazdırılıyor...");
                Student.printList(ThreadProcessRead.list); // Student sınıfıdnaki static metot aracılığıyla da yazma işlemini yapıyoruz
            }
        } catch (InterruptedException e) {
            //Sleep metodu için try-catch oluşturuyoruz. Hata olursa ekrana bu değeri basıyoruz:
            e.printStackTrace();
        }
    }
}

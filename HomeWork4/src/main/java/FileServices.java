import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.InputStream;
import java.util.ArrayList;

public class FileServices {

    //
    public ArrayList<Student> readJsonFile() throws JSONException {
        ArrayList<Student> list = new ArrayList<>(); // dönrüdreceğimiz listeyi oluşturuyoruz

        String resourceName = "students.json"; // json dosyasının adını bir değişkende tutuyoruz.

        InputStream is = Main.class.getResourceAsStream(resourceName); //dosyayı arıyoruz.

        if (is == null) {
            // Dosya bulunamaz ise bu if'e girer ve hata döndürür
            throw new NullPointerException("Dosya bulunamadı:  " + resourceName);
        }

        //Json dosyasını açıp okuyoruz:
        JSONTokener tokener = new JSONTokener(is);
        JSONObject object = new JSONObject(tokener);

        String str = object.toString(); // gelen json değeri String'e dönüştürüyoruz.

        //Gereksiz değerlerden kurtulup. Gelen json değerini parçalara ayırıyoruz.(Her bir kullanıcı bilgisi dizinin farklı bir elemanında tutuluyor.)
        String[] arr = str.split("\\{\"students\":\\[")[1].split("\\{");

        //Yukarıda oluşturduğumuz diziyi döndürerek splitler aracılığıyla isim, soyisim ve yaş bilgilerine erişiyoruz.
        for(int i = 1; i<arr.length;i++){
            String student = arr[i].split("}")[0];
            String name = student.split("\"name\":\"")[1].split("\"")[0];
            String surname = student.split("\"surname\":\"")[1].split("\"")[0];
            String age = student.split("\"age\":")[1];
            Student newStudent = new Student(list.size()+1, name, surname, Integer.valueOf(age)); // Eriştiğimiz bilgileri yeni bir student nesnesi oluşturarak aktarıyoruz.
            list.add(newStudent); // oluşturduğumuz diziye oluşturduğumuz ynei öğrenciyi kaydediyoruz.
        }

        //Okuma işlemi bittiği için static boolean olan readProccess'i true yapıyoruz ki Thread'lardaki yazma işlemi devreye girsin
        ThreadProccessWrite.readProccess = true;
        return list; // en sonda, oluşturduğumuz diziyi gönderiyoruz.
    }
}

package entity;

import java.time.LocalDate;

public class Response {
    /*
    Bu sınıf dönüş tipi olarak kullanılmaktadır.
    code değişkeni 0 ise işlem başarılı, 1 ise işlem başarısız anlamına gelmekte.
     */
    private String code; // İşlemin başarılı olup olmaını tutan değişken
    private String date; // işlem tarihini tutan değişken

    //Boş bir constructor oluşturuyoruz:
    public Response() {
        //İşlemin başarılı olup olmadığı bilinmediğinde bu constructor metot çağrılıyor.
        //İşlemin başarılı olup olmadığı bilinmese bile tarih bilinmekte. Bu sebeple tarihi LocalDate'Den çağırmaktayız.
        this.date = LocalDate.now().toString();  //LocalDate'den şuanki tarihi çekiyoruz.
    }

    public Response(String code) {
        //İşlemin başarılı olup olmadığı bilindiğinde bu constructor metot çağrılıyor.
        this.code = code; //Gelen sonucu String değerimize aktarıyoruz.
        this.date = LocalDate.now().toString();//LocalDate'den şuanki tarihi çekiyoruz.
    }

    //Değişkenler private olduğu için getter ve setter metotlarını oluşturuyoruz:

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

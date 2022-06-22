package Services;

import entity.Response;

public class MemberAccountServie {

    //Ödevde bu sınıf pek kullanılmadığı için sadece ekrana hangi metot olduğu yazdırılıyor ve dönüş olarak response 1 değerini dönderiyor.

    public Response create(){
        System.out.println("Başarılı bir şekilde kullanıcı oluşturuldu");
        return new Response("1"); //Dönüş tipi olarak Response'yi kullanıyoruz.
    }

    public Response read(){
        System.out.println("Başarılı bir şekilde kullanıcı gösterildi");
        return new Response("1"); //Dönüş tipi olarak Response'yi kullanıyoruz.
    }

    public Response update(){
        System.out.println("Başarılı bir şekilde kullanıcı güncellendi");
        return new Response("1"); //Dönüş tipi olarak Response'yi kullanıyoruz.
    }

    public Response delete(){
        System.out.println("Başarılı bir şekilde kullanıcı silindi");
        return new Response("1"); //Dönüş tipi olarak Response'yi kullanıyoruz.
    }
}

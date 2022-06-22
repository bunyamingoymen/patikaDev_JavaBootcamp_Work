import Exceptions.PaymentException;
import Services.BillService;
import Services.Client;
import entity.Bill;
import entity.MemberAcount;
import entity.Response;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) throws PaymentException {

        //İlk olarak default bir Hesap ekliyoruz.
        MemberAcount memberAcount = new MemberAcount(1, "Bünyamin","Göymen",2500,"5074751366");

        //Default bir fatura ekliyoruz.
        Bill bill = new Bill(1,2300, LocalDate.of(2022,7,28), 1, memberAcount.getCode());

        //İşlemleri yapabilmek için Fatura servisine ait bir değişken oluşturuyoruz
        BillService b = new BillService();

        //Ödeme işlemi yapıyoruz. Sonuç Response sınıfı ile dönmekte. Response sınıfında da Tarih ve, başarı/başarısızlık durumu mevcut
        Response x = b.payment(bill, memberAcount);

        //Eğer ödeme başarılıysa İşlemin başarılı olduğunu yazıp ekrana tarihi basıyoruz. Başarısızsa da başarısız olduğunu yazıyoruz
        if(x.getCode().equals("1")) System.out.println("Başarılı bir şekilde ödeme yapılmıştır. Oluşturulma Tarihi: " + x.getDate());
        else System.out.println("İşlem yapılırken bir hata meydana geldi. Tarih: " + x.getDate());

        //Ödeme iptali işlemi yapıyoruz
        Response y = b.paymentCancel(bill, memberAcount);

        //Eğer ödeme iptali başarılıysa İşlemin başarılı olduğunu yazıp ekrana tarihi basıyoruz. Başarısızsa da başarısız olduğunu yazıyoruz
        if(y.getCode().equals("1")) System.out.println("Başarılı bir şekilde ödeme iptal edilmiştir. Oluşturulma Tarihi: " + y.getDate());
        else System.out.println("İşlem yapılırken bir hata meydana geldi. Tarih: " + y.getDate());

        //Fatura sorguluyoruz
        Response z = b.questioning(bill.getBill_type(), memberAcount.getCode(), memberAcount.getPhone());

        //Eğer sorgulama başarılıysa İşlemin başarılı olduğunu yazıp ekrana tarihi basıyoruz. Başarısızsa da başarısız olduğunu yazıyoruz
        if(z.getCode().equals("1")) System.out.println("Başarılı bir şekilde ödeme sorgulanmıştır. Oluşturulma Tarihi: " + z.getDate());
        else System.out.println("İşlem yapılırken bir hata meydana geldi. Tarih: " + z.getDate());

        //Faturayı overload ile diğer metot üzerinden sorguluyoruz.
        Response t = b.questioning(bill.getBill_type(), memberAcount.getCode());

        //Eğer sorgulama başarılıysa İşlemin başarılı olduğunu yazıp ekrana tarihi basıyoruz. Başarısızsa da başarısız olduğunu yazıyoruz
        if(t.getCode().equals("1")) System.out.println("Başarılı bir şekilde ödeme sorgulanmıştır. Oluşturulma Tarihi: " + t.getDate());
        else System.out.println("İşlem yapılırken bir hata meydana geldi. Tarih: " + t.getDate());




    }
}

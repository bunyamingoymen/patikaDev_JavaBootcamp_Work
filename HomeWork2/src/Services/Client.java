package Services;

import Exceptions.PaymentException;
import entity.Bill;
import entity.MemberAcount;
import entity.Response;

public class Client {

    //Fatura ödeme metodu:
    public Response payment(Bill bill, MemberAcount memberAcount) throws PaymentException {
        Response response = new Response(); //Dönüş tipi olarak Response'yi kullanıyoruz.

        /*
        İlk olarak faturayı ödeyen kişinin faturanın sahibi olup olmadığını kontrol ediyoruz.
        (Fautranın account değerininde kullanıcının membercode Değeri mevcut. Faturanın ödenebilmesi için bunların eşit olması gerekmekte)
         */
        if(bill.getAccount().equals(memberAcount.getCode())){

            //Kullanıcının hesabında yeterli bakiye var mı bunu kontrol ediyoruz:
            if(memberAcount.getBalance() < bill.getAmount()){
                //Kullanıcının hesabında yeterli bakiye yoksa hata mesajı döndürüyoruz
                response.setCode("0"); //Hata mesajı döndürürken dönüş tipimizi sıfır olarak ayarlıyoruz
                throw new PaymentException("Bakiye yeterli değil");
            }
            else {
                //Bu faturanın sahibi, bu kullanıcı ise ve hesabında yeterli bakiye varsa ödeme işlemini onaylıyoruz.
                response.setCode("1"); // Dönüş tipi olarak bir değerini döndürüyoruz
                memberAcount.setBalance(memberAcount.getBalance()-bill.getAmount()); // Kullanıcının bakiyesinden ödeme tutarını çıkartıyoruz
                bill.setPaid(true); // faturanın "ödendi mi?" değişkenini true olarak güncelliyoruz.
            }
        }else{
            //Eğer faturayı ödeyen kişi faturanın sahibi değilse hata mesajı yolluyoruz:
            response.setCode("0"); //Hata mesajı yollarken dönüş tipimizi sıfır olarak ayarlıyoruz
            throw new PaymentException("Size ait olmayan bir faturayı ödeyemezsiniz.");
        }

        return response; // Dönüş tipimizi dönderiyoruz.
    }

    //Ödeme İptal etme metodu:
    public Response paymentCancel(Bill bill, MemberAcount memberAccount) throws PaymentException {
        Response response = new Response(); //Dönüş tipi olarak Response'yi kullanıyoruz.
        /*
        İlk olarak ödeme iptali yapmak isteyen kullanıcının bu faturanın sahibi olup olmadığnı kontrol ediyoruz.
        (Faturanın account değerinde kullanıcının memberCode değeri mevcut. Fautra iptali olabilmesi için Fauranın sahibinin bu kullanıcı olması gerekmekte)
         */
        if(bill.getAccount().equals(memberAccount.getCode())){

            //Ödenmemiş bir fatura iptal edilemez. O sebple ilk olarka fatruanın ödenip ödenmediğini kontrol ediyoruz.
            if(bill.isPaid()){
                //Eğer fatura ödenmişse ödeme iptali yapılabilir.
                response.setCode("1"); // İşlem başarılı olduğu için dönüş değerimizi bir olarak ayarlıyoruz
                bill.setPaid(false); // Ödeme iptali yapıldığı için faturanın ödeme durumunu false olarak ayarlıyoruz
                memberAccount.setBalance(memberAccount.getBalance() + bill.getAmount()); // Ödeme iptalinde parayı kullanıcının hesabına geri aktarıyoruz.
            }else{
                response.setCode("0");// Hata mesajı döndürmeden önce dönüş değerimizi sıfır olarak ayarlıyoruz.
                throw new PaymentException("Ödenmemiş bir faturanın ödemesini iptal edemezsiniz.");
            }
        }else{
            //Fautranın sahibi bu kullanıcı değilse hata mesajı döndürüyoruz:
            response.setCode("0"); // Hata mesajı döndürmeden önce dönüş değerimizi sıfır olarak ayarlıyoruz.
            throw new PaymentException("Size ait olmayan bir faturanın ödemesini iptal edemezsiniz.");
        }

        return response; // Dönüş tipimizi dönderiyoruz.

    }

    //Fatura Sorgulama metodu:
    public Response questioning(int bill_type, String memberCode, String phone){
        System.out.println("Fatura 1 nolu metot ile Sorgulanmıştır."); // Hangi metotta olduğumuzu göstermek için ekrana yazı yazdırıyoruz.
        return new Response("1"); //Dönüş tipi olarak Response'yi kullanıyoruz.
    }

    //Fatura sorgulama overload metodu:
    public Response questioning(int bill_type, String memberCode){
        System.out.println("Fatura 2 nolu metot ile Sorgulanmıştır.(Overload)"); // Hangi metotta olduğumuzu göstermek için ekrana yazı yazdırıyoruz.
        return new Response("1"); //Dönüş tipi olarak Response'yi kullanıyoruz.
    }


}

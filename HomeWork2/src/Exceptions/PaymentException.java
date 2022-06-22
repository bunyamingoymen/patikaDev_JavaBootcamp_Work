package Exceptions;

public class PaymentException extends Exception{
    //Hatalı bir işlem gerçekleştiğinde bu sınıf çağrılmaktadır.
    public PaymentException(String message) {
        //Constructor metodda hatalı işlemin sebebini yazdırmaktayız.
        System.out.println("İşlem yapılırken bir hata meydana geldi: " + message);
    }
}

package com.work1;

import java.util.Scanner;

public class work {

    String s1="Welcome"; //oluşturulan değişken 1
    String s2="Welcome"; // oluşturulan değişken 2
    String s3="Welcome"; // oluşturulan değişken 3
    //Ram de 1 tane obje oluşturuluyor ve 3 tane değişken referans olarak orayı gösteriyor. (String pool)

    static String code = "<<code>>"; // ilk olarak static ve string olan bir değişken oluşturuyoruz.

    //Burada main metodumuzu yazmaya başlıyoruz
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in); // İlk olarak kullanıcıdan veri alacağımız için Scanner nesnesi oluşturuyoruz.
        String[] arr = new String[5]; // Metoda yollayacağımız ve kullanıcıdan aldığımız verileri kaydedeceğimiz string dizisini oluşturuyoruz.

        //Kullanıcıdan 5 tane değer alacağımız için döngü oluşturuyoruz.
        for(int i = 0; i<5;i++){
            System.out.println("Lütfen " + (i+1) + ". değeri giriniz"); // Ekrana uyarı vererek kullanıcının bir değer girmesi gerektiğini söylüyoruz.
            arr[i] = scan.next(); // girilen değeri döngünün o anki bulunan değerine aktarıyoruz.
        }

        String result = is_include(arr); // hangi değerin üstte tanımlanan static değere eşit olduğunu bularak için is_inlcude metoduna yolluyoruz.

        System.out.println("Tanımlı value yu içeren String deger:" + result); // en sonda gelen değeri ekrana yazdırıyoruz

    }

    //İlk olarak içeriyor_mu metodunu oluşturuyoruz.
    public static String is_include(String[] arr){

        //gelen dizinin boyutu kadar dönecek bir for döngüsü oluşturuyoruz.
        for(String tmp: arr){
            //Dizinin her bir değeri için yukarıda tanımlanan static string değerini içerip içermediğine bakıyoruz.
            if(tmp.contains(code))
                return tmp; // static string değerini içeriyorsa onu return ediyoruz.
        }

        return "-1"; // Eğer for döngüsünde if'e hiç girmezse -1 döndürüyoruz.
    }
}

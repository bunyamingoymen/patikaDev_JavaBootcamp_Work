import java.io.*;
import java.util.*;

import static java.lang.System.out;

//Solution adında sınıfımızı oluşturuyoruz:
class Student{

    //Gerekli değişkenleri private ile oluşturuyoruz:
    private int id;
    private String name;
    private double cgpa;

    //Yeni bir nesne oluşturulduğunda çalışması için yapıcı metot oluşturuyoruz:
    public Student(int id, String name, double cgpa){
        this.id = id; //gelen id değerini nesnemizin id değerine atıyoruz.
        this.name = name; // gelen name değerini nesnemizin name değerine atıyoruz.
        this.cgpa = cgpa; // gelen cgpa değerini nesnemizin cgpa değerine atıyoruz.
    }

    //Bütün değişkenleri private yaptığımız için getter ve setter metotlarımızı oluşturuyoruz:
    public int getId(){
        return this.id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getName(){
        return this.name;
    }

    public void setId(String name){
        this.name = name;
    }

    public double getCgpa(){
        return this.cgpa;
    }

    public void setCgpa(double cgpa){
        this.cgpa = cgpa;
    }
}

public class Solution {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in); // Kullanıcıdan veri almak için Scanner nesnesi oluşturuyoruz
        int n = s.nextInt(); // Kullanıcının kaç tane değer gireceğini tutmak için bir değişken oluşturuyoruz ve kullanıcının girdiği değeri buna atıyoruz.

        LinkedList<Student> students = new LinkedList<Student>(); // Öğrencileri tutacak bir dizi oluşturuyoruz.

        //Kullanıcının girdiği değer kadar for döngüsü oluşturuyoruz:
        for(int i = 0; i<=n; i++){
            String student = s.nextLine(); // Kullanıcının girdiği değeri alıyoruz.
            String[] arr =student.split(" "); // İLk değerini kontrol etmek için gelen değeri split ile parçalıyoruz.

            //Eğer gelen değer boş ise işlem yapmamamız gerektiği için bu if'i oluşturuyoruz:
            if(!student.equals("")){

                //Eğer gelen değerlerin ilk değeri ENTER ise kullanıcı ekliyoruz. Değilse kullanıcı siliyoruz. ig'e girerse kullanıcı ekleyeceğimiz anlamına geliyor.
                if(arr[0].equals("ENTER")){
                    //Yeni bir student nesnesi oluşturuyoruz ve değerleri gönderiyoruz:
                    /*
                    Gelen değerlerde en son gelen değer id, ilk gelen değer name ve ikinci gelen değer de cgpa olmakta.
                    Bu sebeple arr[3]:id, arr[1]:name ve arr[2]: cgpa olmakta. Ve sıraya göre hepsini gönderiyoruz:
                     */
                    Student newStudent = new Student(Integer.valueOf(arr[3]),arr[1], Double.valueOf(arr[2]));
                    students.add(newStudent); // Oluşturduğumuz yeni nesneyi listemize aktarıyoruz.
                }else{
                    //Eğer ilk değer ENTER değil de SERVED ise en başarılı öğrenciyi listeden çıkartacağız.

                    //Bunun için ilk önce dizinin boş olup olmadığına bakıyoruz. Boş ise değer silemeyiz.
                    if(!students.isEmpty()){
                        /*
                            Burada kullanıcıları ilk olarak başarı sıralamasına göre sıralıyoruz.
                            Ancak collection sort küçükten büyüğe sıraladığı için ilk reversed yapıyoruz.
                            Eğer başarı puanları (cgpa) eşit ise o zaman isime göre sırala diyoruz.
                            Eğer isimleri de aynıysa o zaman i'ye göre sırala diyoruz.
                            Aşağıda bulunan collection.sort bu işe yaramaktadır.
                         */
                        Collections.sort(students, Comparator.comparing(Student::getCgpa).reversed().thenComparing(Student::getName).thenComparing(Student::getId));
                        students.pop(); // Listeyi sıraladıktan sonra ilk değeri pop ederek en başarılı öğrenciyi listeden çıkartıyoruz.
                    } // empty if sonu
                }//else sonu
            } // if sonu
        }//for sonu

        //En sonda bütün listeyi başarı sıralaması ile sıralıyoruz. Başarı puanları aynı ise isme göre, isimleri de aynı ise id'ye göre bir sıralama mevcut oluyor.
        Collections.sort(students, Comparator.comparing(Student::getCgpa).reversed().thenComparing(Student::getName).thenComparing(Student::getId));

        //Listenin boş olup olmadığına bakıyoruz. Boş ise EMPTY yazdırıyoruz. Değilse listede bulunan öğrencilerin adını yazdıeıyoruz.
        if(students.isEmpty())
            out.println("EMPTY"); // Dizi boşsa EMPTY yazdırıyoruz.
        else
            students.forEach((student)->out.println(student.getName())); // Dizi doluysa öğrencilerin adını yazdırıyoruz.

    }
}



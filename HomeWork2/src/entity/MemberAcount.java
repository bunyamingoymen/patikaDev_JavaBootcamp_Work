package entity;

public class MemberAcount {

    //Bütün değişkenleri private yapıyoruz:
    private int id; //Kullanıcının hesap numarasını tutar
    private String name; // Kullanıcının adını tutar
    private String surname; // Kullanıcının soyadını tutar
    private String code; // id+name.subString(0,2);
    private int balance; //Kullanıcının hesabındaki para miktarını tutar
    private String phone; // kullanıcının telefon numarasını tutar

    public MemberAcount(int id, String name, String surname, int balance, String phone) {
        //Kullanıcıdan gelen değerlere göre bütün değişkenleri dolduruyoruz
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.code = String.valueOf(id) + name.substring(0,2);
        this.balance = balance;
        this.phone = phone;
    }

    //Bütün değişkenleri private yaptığımız için Getter ve Setter metotlarını yazıyoruz:

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

package entity;

import java.time.LocalDate;

public class Bill {

    //Bütün değişkenleri private yapıyoruz:

    private int id; // Faturanın id'sini tutuyor
    private int amount; // Faturanın tutarını tutuyor
    private LocalDate process_date; //İşlem tarihini tutuyor
    private int bill_type; // Fatura tipini tutuyor
    private String account; //Faturanın ait olduğu hesabın memberCode'unu tutuyor.
    private boolean isPaid; //Faturanın ödenip ödenmediğini kontrol ediyor.

    //İlk olarak bütün değerleri içeren bir constructor metodu oluşturuyoruz:
    public Bill(int id, int amount, LocalDate process_date, int bill_type, String account) {
        //isPaid hariç diğer değerleri kullanıcının girdiği değerler şeklinde ayarlıyoruz.
        this.id = id;
        this.amount = amount;
        this.process_date = process_date;
        this.bill_type = bill_type;
        this.account = account;
        this.isPaid = false; // Fatura oluştuğunda varsayuılan olarak ödenmemiş şeklidne gözükmeli. Bunu elle giriyoruz.
    }

    //Bütün değerleri private yaptığımız için Getter ve Setter metotlarını yazıyoruz:

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public LocalDate getProcess_date() {
        return process_date;
    }

    public void setProcess_date(LocalDate process_date) {
        this.process_date = process_date;
    }

    public int getBill_type() {
        return bill_type;
    }

    public void setBill_type(int bill_type) {
        this.bill_type = bill_type;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }
}

import java.util.*;
//
public class DuzInsanEkle extends TumInsanlar {

    Scanner klavye1 = new Scanner(System.in);

    String id_insan; //tablodaki sirasi
    String insan_Ad;
    String insan_Soyad;
    String insan_tc;
    String insan_cinsiyet;
    String insan_dogumtarihi;
    String insan_adres;
    String insan_sabika;
    String insan_DNA;

    public DuzInsanEkle() {
    }

    public DuzInsanEkle( String insan_Ad, String insan_Soyad, String insan_tc, String insan_cinsiyet, String insan_dogumtarihi, String insan_adres, String insan_sabika, String insan_DNA) {
        this.insan_Ad = insan_Ad;
        this.insan_Soyad = insan_Soyad;
        this.insan_tc = insan_tc;
        this.insan_cinsiyet = insan_cinsiyet;
        this.insan_dogumtarihi = insan_dogumtarihi;
        this.insan_adres = insan_adres;
        this.insan_sabika = insan_sabika;
        this.insan_DNA = insan_DNA;
    }

    @Override
    public void AdGirisi(){
        System.out.println("Ad girin.");
        insan_Ad = klavye1.nextLine();
    }

    @Override
    public void SoyadGirisi(){
        System.out.println("Soyad girin.");
        insan_Soyad = klavye1.nextLine();
    }
    @Override
    public void TcGirisi(){
        System.out.println("TC kimlik no girin.");
        insan_tc = klavye1.nextLine();
    }
    @Override
    public void CinsiyetGirisi(){
        System.out.println("Cinsiyeti girin.");
        insan_cinsiyet = klavye1.nextLine();
    }
    @Override
    public void DogumTarihiGirisi(){
        System.out.println("Dogum tarihi girin.");
        insan_dogumtarihi = klavye1.nextLine();
    }
    @Override
    public void AdresGirisi(){
        System.out.println("Adresini girin.");
        insan_adres = klavye1.nextLine();
    }
    @Override
    public void SabikaGirisi(){
        System.out.println("Sabikasini girin.");
        insan_sabika = klavye1.nextLine();
    }
    @Override
    public void DnaGirisi(){
        System.out.println("DNA girin.");
        insan_DNA = klavye1.nextLine();
    }




}


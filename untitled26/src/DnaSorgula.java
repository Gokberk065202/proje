import java.sql.*;
import java.util.*;

public class DnaSorgula extends DuzInsanEkle{
    String dna; //veritabanindaki dna
    String dna_sorgu; //kullanici girisi dna
    Scanner klavye1 = new Scanner(System.in);

    public DnaSorgula() {//gövdesiz olarak metodu cagirabilmek icin bos constructor

    }

    public DnaSorgula(String insan_Ad, String insan_Soyad, String insan_tc, String insan_cinsiyet, String insan_dogumtarihi, String insan_adres, String insan_sabika, String insan_DNA){
        super(insan_Ad,insan_Soyad,insan_tc,insan_cinsiyet,insan_dogumtarihi,insan_adres,insan_sabika,insan_DNA);



    }
    public void DnaSorgulama(){
        System.out.println("Dna girin.");
        dna = klavye1.nextLine();




    }



    //dna girilecek string 6 karakter  12 23 34 45,
    // herkesin birer cifti olacak 12 13 14 15 gibi bunlar aranacak
        //buradan nesne oluşturup tc sorgular gibi sorgulatacak
    //varsa var yoksa yok


}

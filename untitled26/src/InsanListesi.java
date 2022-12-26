public class InsanListesi extends DuzInsanEkle{

    public InsanListesi(){

    }


    public InsanListesi(String insan_Ad, String insan_Soyad, String insan_tc, String insan_cinsiyet, String insan_dogumtarihi, String insan_adres,String insan_sabika, String insan_DNA) {
        super(insan_tc, insan_Ad, insan_Soyad, insan_cinsiyet, insan_dogumtarihi, insan_sabika, insan_adres, insan_DNA);
    }

    public void InsanADGuncelle(){
        AdresGirisi();

    }
    public void InsanSoyadGuncelle(){
        SoyadGirisi();

    }
    public void InsanAdresGuncelle(){
        AdresGirisi();



    }
    public void InsanCinsiyetGuncelle(){
        CinsiyetGirisi();

    }
}

public class PolisListesi extends PolisEkle{


    public PolisListesi() {

    }

    public PolisListesi(String tc, String adres, String dogumt, String cinsiyet, String ad, String soyad,String dna) {
        super(tc, adres, dogumt, cinsiyet, ad, soyad,dna);
    }

    public void AdresGuncelle(){

        super.setAdresGir();

    }

    public void CinsiyetGuncelle(){

        super.setCinsiyetGir();

    }
    public void ADGuncelle(){

        super.setADGir();

    }
    public void SoyadGuncelle(){

        super.setSoyadGir();

    }
    public void SifreGuncelle(){

        super.setSifreGir();

    }
}
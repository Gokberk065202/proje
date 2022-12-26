import java.util.Scanner;

public class GbtSorgula extends PolisEkle{

    private String tc1;
    Scanner klavye=new Scanner(System.in);

    public GbtSorgula(){

    }

    public GbtSorgula(String tc, String adres, String dogumt, String cinsiyet, String ad, String soyad,String dna) {
        super(tc, adres, dogumt, cinsiyet, ad, soyad,dna);
    }
    @Override
    public void setTcGir(){
        System.out.println("Tc1 nosunu gir");
        tc1=klavye.nextLine();

    }
    public String getTc(){
        return tc1;
    }




}
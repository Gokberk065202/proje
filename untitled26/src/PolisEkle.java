import java.util.Scanner;

public class PolisEkle extends TumInsanlar{
    Scanner klavye=new Scanner(System.in);
    private String tc;
    private String adres;
    private String dogumt;
    private String cinsiyet;
    private String ad;
    private String soyad;
    private String sifre;
    public int id;

    private String mudursifre="12";

    public PolisEkle(){

    }


    public PolisEkle(String tc, String adres, String dogumt, String cinsiyet, String ad, String soyad,String sifre) {

        this.tc = tc;
        this.adres = adres;
        this.dogumt = dogumt;
        this.cinsiyet = cinsiyet;
        this.ad = ad;
        this.soyad = soyad;
        this.sifre=sifre;

    }
    @Override
    public void setTcGir(){
        System.out.println("Tc nosunu gir");
        Scanner q2=new Scanner(System.in);
        tc=q2.nextLine();
    }
    public String getTc(){
        return tc;
    }
    @Override
    public void setAdresGir(){
        System.out.println("adres gir");
        Scanner q3=new Scanner(System.in);
        adres=q3.nextLine();
    }
    public String getAdres(){
        return adres;
    }
    @Override
    public void setDogumtGir(){
        System.out.println("dogumt gir");
        Scanner q4=new Scanner(System.in);
        dogumt=q4.nextLine();
    }
    public String getDogumt(){
        return dogumt;
    }
    @Override
    public void setCinsiyetGir(){
        System.out.println("cinsiyet gir");
        Scanner q5=new Scanner(System.in);
        cinsiyet=q5.nextLine();

    }
    public String getCinsiyet(){
        return cinsiyet;
    }
    @Override
    public void setADGir(){
        System.out.println("adini gir");
        Scanner q6=new Scanner(System.in);
        ad=q6.nextLine();
    }
    public String getAd(){
        return ad;
    }
    @Override
    public void setSoyadGir(){
        System.out.println("Soyadini gir");
        Scanner q7=new Scanner(System.in);
        soyad=q7.nextLine();
    }
    public String getSoyad(){
        return soyad;
    }
    @Override
    public void setSifreGir(){
        System.out.println("Sifre gir");
        sifre=klavye.nextLine();
    }
    public String getSifre(){
        return sifre;
    }

    public void setidGir(){
        System.out.println("İd gir");
        id=klavye.nextInt();
    }
    public int getid(){
        return id;
    }
    public String getMudursifre(){
        return mudursifre;
    }



}


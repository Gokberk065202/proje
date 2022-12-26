import org.jetbrains.annotations.NotNull;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.*;


import java.sql.*;
import java.util.Scanner;

public class Emniyet {

    public static void Poli1(@NotNull PolisEkle k){
        k.setTcGir();

    }


    public static final String DB_URL="jdbc:mysql://localhost/deneme";
    public static final String DB_USER="root";
    public static final String DB_PASSWORD="gok123.";

    public static void main(String[] args) {

        boolean x=false,z=true,l=true,m=true;
        String kullaniciadi,kullanicisifre,sifreemniyet;

        int y;




        PolisEkle c=new PolisEkle();
        PolisListesi d=new PolisListesi();
        GbtSorgula f=new GbtSorgula();
        DuzInsanEkle duzInsanEkle1 = new DuzInsanEkle();
        DnaSorgula dnaSorgula1 = new DnaSorgula();
        InsanListesi insanListesi=new InsanListesi();




        while (z) {
            System.out.println("1) Emniyet müdür girisi");
            System.out.println("2) Polis girisi");
            System.out.println("3) Kapat");
            Scanner klavye=new Scanner(System.in);
            y = klavye.nextInt();
            if (y == 1) {
                System.out.println("Sifreyi giriniz");
                Scanner q11=new Scanner(System.in);
                sifreemniyet = q11.nextLine();


                if (c.getMudursifre().equals(sifreemniyet))
                    x=true;



                while (x) {
                    System.out.println("1) Polis ekle");
                    System.out.println("2) Polis listesi");
                    System.out.println("3) geri");
                    Scanner q1=new Scanner(System.in);
                    y = q1.nextInt();
                    if (y == 1) {
                        c.setADGir();
                        c.setSoyadGir();
                        c.setCinsiyetGir();
                        c.setDogumtGir();
                        c.setAdresGir();
                        c.setSifreGir();
                        Poli1(c);


                        try {

                            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                            Statement statement = connection.createStatement();


                            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO projenyp.polis (polis_ad,polis_soyad,polis_tc,polis_cinsiyet,polis_dogumt,polis_adres,polis_sifre) VALUES (?,?,?,?,?,?,?)");
                            preparedStatement.setString(1, c.getAd());
                            preparedStatement.setString(2, c.getSoyad());
                            preparedStatement.setString(3, c.getSifre());
                            preparedStatement.setString(4, c.getCinsiyet());
                            preparedStatement.setString(5, c.getDogumt());
                            preparedStatement.setString(6, c.getAdres());
                            preparedStatement.setString(7, c.getSifre());

                            preparedStatement.executeUpdate();
                            statement.close();


                        } catch (SQLException e) {
                            System.out.println(e.getMessage());
                            System.out.println("SQLState: " + e.getSQLState());
                            System.out.println("VendorError: " + e.getErrorCode());

                        }
                    }

                    if (y == 2) {

                        try {
                            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                            Statement statement = connection.createStatement();
                            ResultSet resultSet = statement.executeQuery("SELECT * FROM projenyp.polis");
                            while (resultSet.next()) {
                                System.out.println("ID : " + resultSet.getInt("idpolis"));
                                System.out.println("Adı : " + resultSet.getString("polis_ad"));
                                System.out.println("Soyadı : " + resultSet.getString("polis_soyad"));
                                System.out.println("T.C. : " + resultSet.getString("polis_TC"));
                                System.out.println("Cinsiyet : " + resultSet.getString("polis_cinsiyet"));
                                System.out.println("Dogum Tarihi : " + resultSet.getString("polis_dogumt"));
                                System.out.println("Adres : " + resultSet.getString("polis_adres"));
                                System.out.println("Sifre : " + resultSet.getString("polis_sifre"));
                                System.out.println("#################");
                            }

                        } catch (Exception ex) {
                            System.out.println("SQLException: " + ex.getMessage());


                        }



                    }
                    if(y==3)
                        x=false;


                }
            }

            if (y == 2) {

                Scanner q20=new Scanner(System.in);


                System.out.println("kullanici adi gir");
                kullaniciadi = q20.nextLine();
                System.out.println("sifreyi gir");
                kullanicisifre = q20.nextLine();


                try {
                    Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                    Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery("SELECT * FROM projenyp.polis");
                    while (resultSet.next()) {
                        if (resultSet.getString("polis_sifre").equals(kullanicisifre) && resultSet.getString("polis_ad").equals(kullaniciadi)) {
                            l = true;

                        }

                    }
                } catch (Exception e3) {
                    System.out.println("SQLException: " + e3.getMessage());

                }
                while (l) {
                    System.out.println("1) İnsan ekle");
                    System.out.println("2) İnsan listesi");
                    System.out.println("3) DNA sorgulama ");
                    System.out.println("4) T.C. kimlik no ile sorgulama");
                    System.out.println("5) Parmak izi sorgulama");
                    System.out.println("6) Geri");
                    System.out.println("Secim yapınız");
                    y = klavye.nextInt();
                    if (y == 1) {
                        duzInsanEkle1.AdGirisi();
                        duzInsanEkle1.SoyadGirisi();
                        duzInsanEkle1.TcGirisi();
                        duzInsanEkle1.CinsiyetGirisi();
                        duzInsanEkle1.DogumTarihiGirisi();
                        duzInsanEkle1.AdresGirisi();
                        duzInsanEkle1.SabikaGirisi();
                        duzInsanEkle1.DnaGirisi();


                        String dosya, foto;

                        Scanner b1 = new Scanner(System.in);
                        dosya = b1.nextLine();
                        foto = (("C:\\Users\\Gökberk SAVAŞ\\OneDrive\\Masaüstü\\parmak izleri nesne yönelimli projesi\\" + dosya + ".png"));


                        try {
                            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                            Statement statement = connection.createStatement();
                            PreparedStatement pstmt = connection.prepareStatement("INSERT INTO projenyp.insanliste (insanliste_ad,insanliste_soyad,insanliste_TC,insanliste_cinsiyet,insanliste_dogumt,insanliste_adres,insanliste_sabika,insanliste_DNA,insanliste_foto) VALUES (?,?,?,?,?,?,?,?,?)");
                            pstmt.setString(1, duzInsanEkle1.insan_Ad);
                            pstmt.setString(2, duzInsanEkle1.insan_Soyad);
                            pstmt.setString(3, duzInsanEkle1.insan_tc);
                            pstmt.setString(4, duzInsanEkle1.insan_cinsiyet);
                            pstmt.setString(5, duzInsanEkle1.insan_dogumtarihi);
                            pstmt.setString(6, duzInsanEkle1.insan_adres);
                            pstmt.setString(7, duzInsanEkle1.insan_sabika);
                            pstmt.setString(8, duzInsanEkle1.insan_DNA);
                            pstmt.setString(9, foto);

                            pstmt.executeUpdate();

                            statement.close();


                        } catch (SQLException e) {
                            System.out.println(e.getMessage());
                        }


                    }
                    if (y == 2) {
                        try {
                            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                            Statement statement = connection.createStatement();
                            ResultSet rs = statement.executeQuery("SELECT * FROM projenyp.insanliste");//tablodaki veriye erisiliyor.

                            while (rs.next()) { //bir sonraki veriyi okuyor

                                System.out.println("Tablo no: " + rs.getString("id_insanliste"));
                                System.out.println("Adi: " + rs.getString("insanliste_ad"));
                                System.out.println("Soyadi: " + rs.getString("insanliste_soyad"));
                                System.out.println("TC: " + rs.getString("insanliste_TC"));
                                System.out.println("Cinsiyet: " + rs.getString("insanliste_cinsiyet"));
                                System.out.println("Dogum tarihi: " + rs.getString("insanliste_dogumt"));
                                System.out.println("Adres: " + rs.getString("insanliste_adres"));
                                System.out.println("Sabika: " + rs.getString("insanliste_sabika"));
                                System.out.println("Dna: " + rs.getString("insanliste_DNA"));
                                System.out.println("********");

                            }
                        } catch (SQLException e) {
                            System.out.println(e.getMessage());
                        }


                    }
                    if (y == 3) {
                        dnaSorgula1.DnaSorgulama();


                        try {

                            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                            Statement statement = connection.createStatement();

                            ResultSet rs = statement.executeQuery("SELECT * FROM projenyp.insanliste");

                            while (rs.next()) {
                                if (rs.getString("insanliste_DNA").equals(dnaSorgula1.dna)) {


                                    System.out.println("Tablo no: " + rs.getString("id_insanliste"));
                                    System.out.println("Adi: " + rs.getString("insanliste_ad"));
                                    System.out.println("Soyadi: " + rs.getString("insanliste_soyad"));
                                    System.out.println("TC: " + rs.getString("insanliste_TC"));
                                    System.out.println("Cinsiyet: " + rs.getString("insanliste_cinsiyet"));
                                    System.out.println("Dogum tarihi: " + rs.getString("insanliste_dogumt"));
                                    System.out.println("Adres: " + rs.getString("insanliste_adres"));
                                    System.out.println("Sabika: " + rs.getString("insanliste_sabika"));
                                    System.out.println("#################");


                                }

                            }
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        }


                    }

                    if (y == 4) {
                        Poli1(f);
                        try {
                            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                            Statement statement = connection.createStatement();
                            ResultSet resultSet = statement.executeQuery("SELECT * FROM projenyp.insanliste");
                            while (resultSet.next()) {
                                if (resultSet.getString("insanliste_TC").equals(f.getTc())) {
                                    System.out.println("Tablo no: " + resultSet.getString("id_insanliste"));
                                    System.out.println("Adi: " + resultSet.getString("insanliste_ad"));
                                    System.out.println("Soyadi: " + resultSet.getString("insanliste_soyad"));
                                    System.out.println("TC: " + resultSet.getString("insanliste_TC"));
                                    System.out.println("Cinsiyet: " + resultSet.getString("insanliste_cinsiyet"));
                                    System.out.println("Dogum tarihi: " + resultSet.getString("insanliste_dogumt"));
                                    System.out.println("Adres: " + resultSet.getString("insanliste_adres"));
                                    System.out.println("Sabika: " + resultSet.getString("insanliste_sabika"));
                                    System.out.println("#################");

                                }

                            }
                        } catch (Exception e2) {
                            System.out.println("SQLException: " + e2.getMessage());

                        }

                    }

                    if (y == 5) {

                        BufferedImage foto1 = null;
                        try {
                            String dosya1;
                            System.out.println("Dosya ismini giriniz");
                            Scanner z1 = new Scanner(System.in);
                            dosya1 = z1.nextLine();
                            foto1 = ImageIO.read(new File("C:\\Users\\Gökberk SAVAŞ\\OneDrive\\Masaüstü\\parmak izleri nesne yönelimli projesi\\Kopyalar\\" + dosya1 + ".png"));
                        } catch (Exception e) {
                            System.out.println("ik fotoğraf okunurken hata oluştu.");
                            System.out.println(e.getMessage());
                            System.exit(1);

                        }

                        BufferedImage foto2;
                        try {
                            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                            Statement statement = connection.createStatement();
                            ResultSet resultSet = statement.executeQuery("SELECT * FROM projenyp.insanliste");

                            while (resultSet.next()) {
                                m=true;

                                while (m) {
                                    String dosya2 = resultSet.getString("insanliste_foto1");

                                    foto2 = ImageIO.read(new File("C:\\Users\\Gökberk SAVAŞ\\OneDrive\\Masaüstü\\parmak izleri nesne yönelimli projesi\\" + dosya2 + ".png"));
                                    if (foto1.getWidth() != foto2.getWidth() || foto1.getHeight() != foto2.getHeight()) {
                                        System.out.println("Fotoğraflar eşit değil. Boyutları farklı.");
                                        System.exit(1);
                                    }
                                    for (int i = 0; i < foto1.getHeight(); i++) {
                                        for (int j = 0; j < foto1.getWidth(); j++) {
                                            if (foto1.getRGB(j, i) != foto2.getRGB(j, i)) {
                                                m=false;


                                            }

                                        }
                                    }

                                    if(m){
                                        System.out.println("Tablo no: " + resultSet.getString("id_insanliste"));
                                        System.out.println("Adi: " + resultSet.getString("insanliste_ad"));
                                        System.out.println("Soyadi: " + resultSet.getString("insanliste_soyad"));
                                        System.out.println("TC: " + resultSet.getString("insanliste_TC"));
                                        System.out.println("Cinsiyet: " + resultSet.getString("insanliste_cinsiyet"));
                                        System.out.println("Dogum tarihi: " + resultSet.getString("insanliste_dogumt"));
                                        System.out.println("Adres: " + resultSet.getString("insanliste_adres"));
                                        System.out.println("Sabika: " + resultSet.getString("insanliste_sabika"));
                                        System.out.println("#################");
                                        break;

                                    }


                                }
                            }


                            } catch(Exception e2){
                                System.out.println("SQLException: " + e2.getMessage());

                            }


                        }
                        if (y == 6) {
                            l = false;

                        }
                    }

                }
            if(y==3)
                z=false;

            }


        }
        }




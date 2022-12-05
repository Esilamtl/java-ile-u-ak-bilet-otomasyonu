package error.odev2;

import java.util.Scanner;
public class Odev2 {

   private static Yonetici yönetici;
    
    public static void main(String[] args) throws Exception{
     
//     Ucak ucak= new Ucak();
//     
//     ucak.setKapasite(100);
//     ucak.setTip("Airbus");
//     ucak.setUretimYili(2000);

System.out.println("musteri misiniz? yonetici mi?");
Scanner girdi = new Scanner(System.in);
String cevap = girdi.next();

if(cevap.equals("yonetici")){
    System.out.println("şifreyi giriniz.");
    Scanner girdi2 = new Scanner(System.in);
    int sifre = girdi2.nextInt();
    if(sifre==123){
     System.out.println("yapmak istediğiniz işlemi giriniz.");  
     Scanner girdi3 = new Scanner(System.in);
     String cevap1 = girdi3.next();
        switch (cevap1) {
            case "ekleHavayoluSirket":
                Yonetici.ekleHavayoluSirket();
                
            case "getirHavayoluSirketler":
                Yonetici.getirHavayoluSirketler();
            case "ekleUcus":
                Yonetici.ekleUcus();
            case "getirUcus":
                Yonetici.getirUcus();
            case "getirRezervasyonlar":    
                UcusRezervasyonu.getirRezervasyonlar();
            case "ekleHavalimani":
                Yonetici.ekleHavalimani();
            case "getirHavalimani":
               Yonetici.getirHavalimani();
            case "ekleUcak":
             Ucak ucak=new Ucak();
             // bilgiler kullanıcıdan alınır 
              System.out.println("ucagin tipini  giriniz."); 
              Scanner girdi4 = new Scanner(System.in);
              String Tip = girdi4.next();
              ucak.setTip(Tip);
              
              System.out.println("ucagin kapasitesini  giriniz."); 
              Scanner girdi5 = new Scanner(System.in);
              int kapasite = girdi5.nextInt();        
              ucak.setKapasite(kapasite);
              
               System.out.println("ucagin uretim yilini   giriniz."); 
              Scanner girdi6 = new Scanner(System.in);
              int uretimYili = girdi6.nextInt();        
              ucak.setUretimYili(uretimYili);
              Yonetici.ekleUcak(ucak);
              
            case "getirUcak":    
                Yonetici.getirUcak();
            case "rezervasyon yaptırmıs yolcular":
                UcusRezervasyonu.getirRezervasyonlar();
            default:
                throw new AssertionError();
        }
        
    }
    else{
        
        System.out.println("yanlış şifre, şifreyi giriniz.");
        Scanner girdi3 = new Scanner(System.in);
    }
}

else if(cevap.equals("müşteri")){
   System.out.println("yapmak istediğiniz işlemi giriniz.");  
     Scanner girdi1 = new Scanner(System.in);
     String cevap1 = girdi1.next();
        switch (cevap1) {
            case "getirUcuslar":
                Ucak.getirUcuslar(); 
            case "getirHavayoluSirketler":
                UcusRezervasyonu.ekleRezervasyon();
            case "rezevasyon iptal":
                  UcusRezervasyonu.guncelleRezervasyonDurum(cevap1, RezervasyonDurum.IPTAL);
            case "getirHavalimani":
                Yonetici.getirHavalimani();
//tarihte ve kalkış/varış havalimanları için uçuş araması yapabilmelidirler
 
}
 
    }else{
    System.out.println("girdiğiniz türde bir kullanıcı bulunmamaktadır.");
}
     
}
}

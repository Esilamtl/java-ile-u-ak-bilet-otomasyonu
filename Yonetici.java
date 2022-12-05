 
package error.odev2;
 
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Calendar;
 

public class Yonetici extends Kisi{
    private String departman;
   
    public static List<Ucak> getirUcak() throws IOException, ParseException {
        
            List<Ucak>ucakList  = new ArrayList<Ucak>();
         File file=new File("C:\\Users\\ESİLA\\Desktop\\Files\\Ucaklar.txt");
        if(file.exists()){
            file.createNewFile();}
        
         FileReader fileReader = new FileReader(file);
        String line;
 
         BufferedReader br = new BufferedReader(fileReader);
 
         while ((line = br.readLine()) != null) { //bana belirtilen bir dosyadaki tüm satırları içeren String[] dizisini döndürmelidir.
 
          String[] strArray;  
       
            //converting using String.split() method with whitespace as a delimiter  
            
            strArray = line.split(";");   
            Ucak ucak= new Ucak();
     
            //printing the converted string array  
            ucak.setTip(strArray[0]);
            ucak.setKapasite(Integer.parseInt(strArray[1])); 
            ucak.setUretimYili(Integer.parseInt(strArray[2]));
            
              
            ucakList.add( ucak); 
            
         }
         br.close();
         return ucakList;
        
    }
    
    public static boolean  ekleUcak(Ucak ucak) throws IOException {

        
     try{
    File file = new File("C:\\Users\\ESİLA\\Desktop\\Files\\Ucaklar.txt");
        if (!file.exists())
            file.createNewFile();
        FileWriter fileWriter = new FileWriter(file, false);
        BufferedWriter bWriter = new BufferedWriter(fileWriter);
        bWriter.write(ucak.getTip()+";"+ucak.getKapasite()+";"+ucak.getUretimYili());
        bWriter.close();
        return true;
     }catch(Exception e){
         return false;   
     }   
    }
    public static List<Ucus> getirUcus() throws IOException{
        File file=new File("C:\\Users\\ESİLA\\Desktop\\Files\\Ucuslar.txt");
        if(file.exists()){
            file.createNewFile();}
        
         FileReader fileReader = new FileReader(file);
        String line;
 
        BufferedReader br = new BufferedReader(fileReader);
 
        List<Ucus>ucusList  = new ArrayList<Ucus>();
         while ((line = br.readLine()) != null) {  
 
          String[] strArray;  
        
            strArray = line.split(";");   
            Ucus ucus= new Ucus();
            //printing the converted string array  
            
            ucus.setUcusNo(Integer.parseInt(strArray[0]));
            try {
                ucus.setKalkisSaat(new SimpleDateFormat("yyyy-MM-dd hh:mm").parse(strArray[1]+"-"+strArray[2]+"-"+strArray[3]+" "+strArray[4])); 
            } catch (ParseException e) {
            }
            ucus.setSure(Float.parseFloat(strArray[5]));
            
            Havalimani havalimani = new Havalimani();
            havalimani.setUlke(strArray[6]);
            havalimani.setSehir(strArray[7]);
            havalimani.setHavalimaniAd(strArray[8]);
            ucus.setKalkis(havalimani);
            
            Havalimani havalimaniV=new Havalimani();
            havalimaniV.setUlke(strArray[9]);
            havalimaniV.setSehir(strArray[10]);
            havalimaniV.setHavalimaniAd(strArray[11]);
            ucus.setVaris(havalimaniV);
            
            Ucak ucak=new Ucak();
            ucak.setTip(strArray[12]);
            ucus.setUcak(ucak);
            switch (strArray[14]) {
                case "1" -> ucus.setDurum(UcusDurum.PLANLANDI);
                case "2" -> ucus.setDurum(UcusDurum.ERTELENDI);
                case "3" -> ucus.setDurum(UcusDurum.AYRILDI);
                case "4" -> ucus.setDurum(UcusDurum.TAMAMLANDI);
                case "5" -> ucus.setDurum(UcusDurum.IPTAL);
            }
            
            ucusList.add(ucus); 
            
         }
         br.close();
        return ucusList;
    }
    public static boolean  ekleUcus(){
     Ucus ucus= new Ucus();
     try{
    File file = new File("C:\\Users\\ESİLA\\Desktop\\Files\\Ucuslar.txt");
        if (!file.exists())
            file.createNewFile();
        FileWriter fileWriter = new FileWriter(file, false);
        BufferedWriter bWriter = new BufferedWriter(fileWriter);
        Calendar calendar = new GregorianCalendar();
        HavayoluSirketi havayoluSirketi = new HavayoluSirketi();
        calendar.setTime(ucus.getKalkisSaat());
        bWriter.write(ucus.getUcusNo()+";"
                +calendar.get(Calendar.YEAR)+";"
                +calendar.get(Calendar.MONTH)+";"
                +calendar.get(Calendar.DAY_OF_MONTH)+";"
                +calendar.get(Calendar.HOUR)+":"
                +calendar.get(Calendar.MINUTE)+";"
                +ucus.getKalkis().getUlke()+";"
                +ucus.getKalkis().getSehir()+";"
                +ucus.getKalkis().getHavalimaniAd()+";"
                +ucus.getVaris().getUlke()+";"
                +ucus.getVaris().getSehir()+";"
                +ucus.getVaris().getHavalimaniAd()+";"
                +ucus.getUcak().getTip()+";"
                +havayoluSirketi.getHavayoluSirketiAdi()+";"
                +ucus.getDurum()+";"
                
              
                );
        bWriter.close();
        return true;
     }catch(Exception e){
         return false;   
     }   
    }
    
    
    
    public static List<Havalimani> getirHavalimani() throws IOException {
        
        File file=new File("C:\\Users\\ESİLA\\Desktop\\Files\\Havalimanlari.txt");
        if(file.exists()){
            file.createNewFile();}
        
         FileReader fileReader = new FileReader(file);
        String line;
 
         BufferedReader br = new BufferedReader(fileReader);
 
        List<Havalimani>havalimaniList  = new ArrayList<Havalimani>();
         while ((line = br.readLine()) != null) {  
 
          String[] strArray;  
       
           
        
            strArray = line.split(";");   
            Havalimani havalimani= new Havalimani();
            
           
                havalimani.setHavalimaniAd(strArray[0]);
                havalimani.setUlke(strArray[1]);
                havalimani.setSehir(strArray[2]);
             
            havalimaniList.add(havalimani);          
         }
         br.close();
        return havalimaniList;
    }
        
    
    
    
    public static  void ekleHavalimani() throws IOException{
        
        Havalimani havalimani=new Havalimani();
        
    File file = new File("C:\\Users\\ESİLA\\Desktop\\Files\\Havalimanlari.txt");
        if (!file.exists())
            file.createNewFile();
        FileWriter fileWriter = new FileWriter(file, false);
        BufferedWriter bWriter = new BufferedWriter(fileWriter);
        bWriter.write(havalimani.getHavalimaniAd()+";"+ havalimani.getUlke()+";"+havalimani.getSehir());
        bWriter.close();
        
        
    }
 
    
    
   public static  List<HavayoluSirketi> getirHavayoluSirketler() throws IOException{
       
       
      File file=new File("C:\\Users\\ESİLA\\Desktop\\Files\\HavayoluSirketleri.txt");
        if(file.exists()){
            file.createNewFile();}
        
         FileReader fileReader = new FileReader(file);
        String line;
 
         BufferedReader br = new BufferedReader(fileReader);
 
        List<HavayoluSirketi>havayoluSirketiList  = new ArrayList<HavayoluSirketi>();
         while ((line = br.readLine()) != null) {  
 
          String[] strArray;  
       
           
        
            strArray = line.split(";");   
            HavayoluSirketi havayoluSirketi= new HavayoluSirketi();
            
              havayoluSirketi.setKod(Integer.parseInt(strArray[0]));
                havayoluSirketi.setHavayoluSirketiAdi(strArray[1]);
              
             
         
            havayoluSirketiList.add(havayoluSirketi);          
         } 
         br.close();
        return havayoluSirketiList;
    } 
 
   
   
    public static void ekleHavayoluSirket() throws IOException{
        HavayoluSirketi havayoluSirketi=new HavayoluSirketi();
        
    File file = new File("C:\\Users\\ESİLA\\Desktop\\Files\\HavayoluSirketleri.txt");
        if (!file.exists())
            file.createNewFile();
        FileWriter fileWriter = new FileWriter(file, false);
        BufferedWriter bWriter = new BufferedWriter(fileWriter);
        bWriter.write(havayoluSirketi.getHavayoluSirketiAdi()+";"+havayoluSirketi.getKod());
        bWriter.close();
    
  }
 
    
    }
    



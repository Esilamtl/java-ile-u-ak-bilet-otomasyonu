 
package error.odev2;
 
 
import java.io.IOException; 
  
import java.util.List;
public class Ucak {
    String tip;
    int kapasite;
    int uretimYili;
    
    
    static Yonetici yonetici;

    public void setTip(String tip) {
        this.tip = tip;
    }

    public void setKapasite(int kapasite) {
        this.kapasite = kapasite;
    }

    public void setUretimYili(int uretimYili) {
        this.uretimYili = uretimYili;
    }

    public String getTip() {
        return tip;
    }

    public int getKapasite() {
        return kapasite;
    }

    public int getUretimYili() {
        return uretimYili;
    }
        
    public static  List<Ucus> getirUcuslar() throws IOException{
        
      return yonetici.getirUcus();
       
      
    }
  
    

 
}

  
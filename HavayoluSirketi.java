/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package error.odev2;

import java.io.IOException;
import java.util.List;

/**
 *
 * @author ESİLA
 */
public class HavayoluSirketi {
    private String havayoluSirketiAdi;
    private int kod;

    public String getHavayoluSirketiAdi() {
        return havayoluSirketiAdi;
    }

    public void setHavayoluSirketiAdi(String havayoluSirketiAdi) {
        this.havayoluSirketiAdi = havayoluSirketiAdi;
    }

    public int getKod() {
        return kod;
    }

    public void setKod(int kod) {
        this.kod = kod;
    }
    
    public  static List<Ucus> getirUcuslar() throws IOException{
        return Yonetici.getirUcus();
    }
    
}

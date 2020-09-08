import java.util.*;
import java.awt.*;
import java.io.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Color;

class Imagine {
    BufferedImage imagine1; //imagine1 reprezinta intr-un fel matricea pixelilor imaginii
    int inaltime;
    int latime;
    
    //initializam parametrii imaginii
    Imagine() {
        imagine1 = null;
        inaltime = 0;
        latime = 0;
    }
    
    void citire(File f)
    {
        try{
            //citim din folder imaginea si ii salvam parametrii
            imagine1 = ImageIO.read(f);
            if(imagine1 != null) {
                    inaltime = imagine1.getHeight();
                    latime  = imagine1.getWidth();
            } else {
                    System.out.println("Imaginea nu exista!");
            }
        }
        catch(Exception e){
            System.out.println("A aparut eroarea: " + e);
        }
    }
    
    //cu aceasta metoda modificam atributele obiectului Imagine
    Imagine(BufferedImage img, int l, int h) {
        imagine1 = img;
        latime = l;
        inaltime = h;
    }
    
    //urmeaza getterii
    BufferedImage getImagine(){
        return imagine1;
    }
    
    int getInaltime(){
        return inaltime;
    }
    
    int getLatime(){
        return latime;
    }
    
    //urmeaza setterii
    void setImagine(BufferedImage image1){
        imagine1 = image1;
    }
    
    void setInaltime(int inalt){
        inaltime = inalt;
    }
    
    void setLatime(int lat){
        latime = lat;
    }
    
    //cu metoda afisare scriem in folderul de iesire imaginea obtinuta
    void afisare(String fisier){
        try{
            System.out.println("Inaltime:" + inaltime + " Latime: " + latime);  
            ImageIO.write(imagine1,"bmp",new File(fisier)); 
            System.out.println("Succes!");
        }
        catch(Exception e){
            System.out.println("A aparut eroarea: " + e);
        }
        
    }
    
    //aceasta metoda modifica pixel cu pixel luminozitatea si returneaza imaginea noua
    BufferedImage luminozitate(int ...lum){
        long start_mod = System.currentTimeMillis();
        BufferedImage imagine_noua = imagine1;
        int pixel = 0;
        int r, g, b;
        //parcurgem matricea de pixeli si pentru fiecare pixel adaugam factorul de luminozitate
        for(int i = 0; i < latime; i++) {
            for(int j = 0; j < inaltime; j++){
                pixel = imagine1.getRGB(i,j);
                r = (pixel >> 16) & 0xff; 
                g = (pixel >> 8) & 0xff; 
                b = pixel & 0xff; 
                
                for(int l : lum) {
                    r += l;
                    g += l;
                    b += l;
                }
                //cum pixelii pot lua valori doar intre 0 si 255, atunci le dau valorile corespunzatoare 
                //in caz ca se depasesc aceste limite
                r = (r > 255) ? 255 : r;
                g = (g > 255) ? 255 : g;
                b = (b > 255) ? 255 : b;
                r = (r < 0) ? 0 : r;
                g = (g < 0) ? 0 : g;
                b = (b < 0) ? 0 : b;
                
                pixel = (r<<16) | (g<<8) | b; 
                //reconstruim pixelul si il salvam in noua imagine
                imagine_noua.setRGB(i, j, pixel); 
            }
        }
        long stop_mod = System.currentTimeMillis();
        System.out.println("----------------Modificarea imaginii a durat:" + (stop_mod - start_mod) +"ms");
        return imagine_noua;
    }
}
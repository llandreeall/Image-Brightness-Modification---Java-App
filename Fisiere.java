import java.io.File;
import javax.swing.*;
import javax.swing.filechooser.*;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;
import java.util.Scanner.*;
import java.util.*;

//clasa Fisiere afla adresa imaginii a carei luminozitate va fi modificata 
//am rescris metoda setInput pentru a obtine adresa imaginii
public class Fisiere extends FisierOutput
{   File imagine = null;
    @Override
    public void setInput(){
        //incep contorizarea timpului
        long start_aii = System.currentTimeMillis();
        //am decis sa fie la alegerea utilizatorului daca citeste adresa de la tastatura
        //sau din fereastra de alegere
        //eu personal as alege fereastra de alegere deoarece este mai estetica si poti alege orice folder
        System.out.println("Doriti ca alegerea folderului sa se faca de la tastatura sau din" + 
        " fereastra de alegere?");
        //citim de la tastatura ce doreste utilizatorul
        Scanner tastatura = new Scanner(System.in);
        String citire;
        citire = tastatura.nextLine();
        switch(citire){
            case "tastatura":
                //daca am ales tastatura atunci citesc de la tastatura pe rand
                //adresele folderelor de intrare si de iesire si le salvez in adresa_input si
                //adresa_output
                File citire_in;
                File citire_out;
                System.out.println("Introduceti folderul de unde se citeste imaginea:");
                citire = tastatura.nextLine();
                citire_in = new File(citire);
                adresa_input = citire_in;
                System.out.println("Introduceti folderul de unde se salveaza imaginea:");
                citire = tastatura.nextLine();
                citire_out = new File(citire);
                adresa_output = citire_out;
                
                break;
            case "fereastra":
                //daca am ales fereastra atunci apelez functiile care obtin adresele prin fereastra 
                //de alegere
                adresa_input = this.getInput();
                this.setOutput();
                break;
            case "exit" :
                //aceasta optiune imi permite sa ies din aplicatie
                System.out.println("IESIRE DIN APLICATIE");
                System.exit(0);
            break;
            default: System.out.println("Sintaxa gresita, incearca inca o data!\n");
        }
         
        //aleg imaginea din folderul de intrare ales 
        JFileChooser img = new JFileChooser(adresa_input);
        img.setDialogTitle("Alege o imagine (BMP): ");
        FileNameExtensionFilter f = new FileNameExtensionFilter("BMP Images", "bmp");
        //folosesc un filtru deoarece am nevoie doar de imaginile BMP
        img.setFileFilter(f);
        img.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int returnValue = img.showSaveDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            //in imagine salvez adresa imaginii alese
            System.out.println("Adresa imaginii este: \n" + img.getSelectedFile().getAbsolutePath());
            imagine = img.getSelectedFile();
        }
        //opresc contorizarea timpului si calculez timpul de executie
        long stop_aii = System.currentTimeMillis();
        System.out.println("----------------Alegerea imaginii a durat:" + (stop_aii - start_aii) +"ms");
    }
    
    //setterii si getterii pentru adresele de intrare si iesire
    @Override
    public File getAdresa_output(){
        return adresa_output;
    }
    
    @Override
    public File getAdresa_input(){
        return adresa_input;
    }
    
    @Override
    public void setAdresa_output(File ao){
        adresa_output = ao;
    }
    
    @Override
    public void setAdresa_input(File ai){
        adresa_input = ai;
    }
    
    //afisare adresa imagine
    void afisare_adresa_input(){
        System.out.println("Imaginea este:" + imagine);
    }
    
    //setter si getter pentru adresa Imaginii
    File getImagine(){
        return imagine;
    }
    
   void setImagine(File image){
        imagine = image;
    }
    
}

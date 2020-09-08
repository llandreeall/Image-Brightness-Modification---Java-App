import java.util.Scanner;
//aceasta clasa face modificarea imaginii
public class Modifica extends Fisiere
{   
    Imagine i;   
    int []lumin;//factorul de luminozitate este de tip varargs
    
    //constructorul imi initializeaza luminozitatea si obiectul imagine
    Modifica(){
        lumin = new int[1];
        i = new Imagine();
    }
    
    public void setLumin()
    {   
        long start_m = System.currentTimeMillis();
        this.setInput(); //salvam adresa imaginii in variabila imagine
        //System.out.println(imagine);
        i.citire(imagine); //apelam functia citire pentru a prelua pixelii imaginii folosind BufferedImage
        Scanner keyboard = new Scanner(System.in); 
        System.out.println("Introdu un factor de luminozitate(de la -255 la 255):");
        lumin[0] = Integer.parseInt(keyboard.nextLine()); //citim de la tastatura factorul de luminozitate
        //creem o imagine noua modificata in functie de luminozitate
        long stop_m = System.currentTimeMillis();
        System.out.println("----------------Citirea unei imagini si a factorului de luminozitate a durat:" + (stop_m - start_m) +"ms");
        Imagine i_nou = new Imagine(i.luminozitate(lumin), i.getLatime(), i.getInaltime());
        //salvam adresa imaginii de iesire in fisierul de iesire
        String aici_salvez = adresa_output + "\\" + "output.bmp";
        System.out.println(aici_salvez);
        //scriem imaginea in folderul de iesire
        i.afisare(aici_salvez);
        
    }
    
    
    
}

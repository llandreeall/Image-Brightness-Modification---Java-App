import java.io.File;
//Aceasta interfata imi pregateste operatiile
//pentru a citi adresa fisierului sursa
//si pentru a citi adresa fisierului destinatie
public interface FisierInput{
    
    abstract File getInput(); //aceasta functie alege folderul de intrare prin fereastra de alegere
    
    abstract void setOutput(); //aceasta functie alege folderul de iesire prin fereastra de alegere

}
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

//aceasta clasa suprascrie operatiile mentionate in interfata
//introduce o noua metoda ce obtine adresa imaginii ce va fi modificata prin fereastra de alegere
//si introduce setterii si getterii
public abstract class FisierOutput implements FisierInput {
        File adresa_input; //adresa sursa
        File adresa_output; //adresa destinatie
        abstract void setInput(); //alege imaginea ce va fi prelucrata
   
        abstract void setAdresa_input(File ai); //setter input
        abstract File getAdresa_input();        //getter input
        abstract void setAdresa_output(File ao);//setter output
        abstract File getAdresa_output();       //getter output
        
        @Override
        //getInput preia adresa folderului sursa folosind clasa JFileChooser
        //initial adresa este null si atunci cand este aleasa o retinem in adresa_input
        //am decis sa returnez adresa deoarece ne va ajuta sa alegem adresa imaginii bmp 
        //ca sa nu mai cautam in toate folderele
        //am ales sa folosesc JFileChooser din motive estetice
        public File getInput(){
            long start_ai = System.currentTimeMillis();
        JFileChooser input = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        input.setDialogTitle("Alege un folder din care se ia fisierul: ");
        //pun conditia sa aleaga doar foldere 
        input.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        File adresa = null;
	int returnValue = input.showSaveDialog(null);
	if (returnValue == JFileChooser.APPROVE_OPTION) {
		if (input.getSelectedFile().isDirectory()) {
		        adresa = input.getSelectedFile();
			System.out.println("Folderul sursa selectat: \n" + input.getSelectedFile());

		}
	}
	long stop_ai = System.currentTimeMillis();
	System.out.println("----------------Alegerea fisierului sursa a durat:" + (stop_ai - start_ai) +"ms");
	return adresa;
    }

    @Override
    //getOutput preia adresa folderuluidestinatie folosind clasa JFileChooser
    //initial adresa este null si atunci cand este aleasa o retinem in adresa_output
    //am decis sa NU returnez adresa deoarece doar o voi retine in valoarea mentionata

    public void setOutput(){
        long start_ao = System.currentTimeMillis();
        JFileChooser output = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        output.setDialogTitle("Alege un folder destinatie: ");
        output.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        File adresa = null ;
	int returnValue = output.showSaveDialog(null);
	if (returnValue == JFileChooser.APPROVE_OPTION) {
		if (output.getSelectedFile().isDirectory()) {
			System.out.println("Folderul destinatie selectat: \n" + output.getSelectedFile());
			adresa = output.getSelectedFile();
		}
	}
	adresa_output = adresa;
	long stop_ao = System.currentTimeMillis();
	System.out.println("----------------Alegerea fisierului destinatie a durat:" + (stop_ao - start_ao) +"ms"); 
    }

}
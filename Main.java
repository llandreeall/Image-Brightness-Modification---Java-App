
public class Main
{
    public static void main(String[] args){
        System.out.println("Bun Venit!");
        //incepem modificarea 
        long start = System.currentTimeMillis();
        Modifica m = new Modifica();
        m.setLumin();
        long stop = System.currentTimeMillis();
        System.out.println("----------------Toata executia a durat:" + (stop - start) +"ms");
    }
}

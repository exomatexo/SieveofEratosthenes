import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int licz=0;
    static int licz2=0;

    //sito e.
    public static int[] S1(int a, int b){
    int[] tab = new int [b+1];
        for (int i=0; i<=b;i++){
            tab[i]=1;
        }
        int doilu = (int) Math.sqrt(b);
        for (int i = 2; i<= doilu ; i++){
            if(tab[i] == 1 ) {
                for (int j = 2; j*i < tab.length; j ++) {
                    tab[j*i] = 0;
                }
                licz++;
            }

        }
    return tab;
   }
    //naiwnie
    public static ArrayList<Integer> S2(int a , int b){
        ArrayList<Integer> listan = new ArrayList<>();
        //wypełnianie
        for (int i= a; i<=b;i++)
            listan.add(i);
        for (int i = 0 ; i<=b-a;i++){
            for (int j = 2; j<listan.get(i);j++){
                if(listan.get(i)%j==0){
                    listan.set(i,-1);
                    licz2++;
                    break;
                }

            }
        }
        return listan;
    }

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File ("In0104.txt");
        ArrayList<Integer> listaw2 = new ArrayList<>();
        int  a = 0;
        int  b = 0;
        try {

            Scanner sc = new Scanner(file);

            a=sc.nextInt();
            b=sc.nextInt();
            sc.close();
        }
        catch (FileNotFoundException e) {
        }

        int []tab = S1(a,b);
        listaw2=S2(a,b);
        PrintWriter fileout = new PrintWriter ("Out0104.txt");
        fileout.println("przedział: ["+a+", "+b+"]");
        fileout.println("I metoda:" );
        int ile=0;
        for (int i=a; i<b+1;i++)
            if(tab[i]!=0) {
                fileout.print(" " +i);
                ile++;
            }
        fileout.println("\n Ilosc liczb pierwszych: "+ ile + "; ilość wykonanych operacji elementarnych = "+ licz  );
        fileout.println("II metoda:" );
        ile=0;
        for (int i=0; i<=b-a;i++){
            if(listaw2.get(i)!=-1){
                fileout.print(" " + listaw2.get(i));
                ile++;
            }
        }
        fileout.println("\n Ilosc liczb pierwszych: "+ ile + "; ilość wykonanych operacji elementarnych = "+ licz2);
        fileout.println("ala");
        fileout.close();
    }
}

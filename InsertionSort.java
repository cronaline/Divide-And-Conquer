/*
Correspondiente a las lecturas complementarias del curso
Insertion Sort
Version 1
16/enero/2017
*/
import java.lang.NumberFormatException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class InsertionSort{
    private int a[];

    public static void main(String args[]) throws FileNotFoundException, IOException{
        InsertionSort is = new InsertionSort();
        is.leeNumeros(args[0]);
        System.out.println();
        is.listar();

    }

    
    public void leeNumeros(String archivo) throws FileNotFoundException, IOException, NumberFormatException {
        FileReader fr = new FileReader(archivo);
        BufferedReader b = new BufferedReader(fr);
        String cadena = b.readLine();
        String[] numeros = cadena.replaceAll("\\s", "").split(" ");
        int c[] = new int[numeros.length];
        for(int i = 0; i < c.length; i++){
            try{
                c[i] = Integer.parseInt(numeros[i]);
            }catch (NumberFormatException nfe){
            };
        }
        b.close(); //Se cierra el archivo
        a = c;
    }

    public void listar(){
        for(int i = 0; i < a.length; i++){
            System.out.print(a[i]);
        }
    }
}

import java.math.*;
import java.lang.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Karatsuba3{
    BigInteger n1;
    BigInteger n2;

    public static void main(String args[]) throws FileNotFoundException, IOException {
        Karatsuba3 k = new Karatsuba3();
        k.leeNumeros(args[0]);
        System.out.println(k.n1);
        System.out.println(k.n2);
        System.out.println(k.getSize(k.n1));
    }

    public int getSize(BigInteger n){
        int size = 0;
        BigInteger valor, residuo;
        valor = n;
        while(n.compareTo(10) != -1){ //si el numero es mayor a 10
            size++;
            residuo = b.mod()
            valor = valor - residuo;
            valor = valor.shiftRight();
        }
    }

    public void leeNumeros(String archivo) throws FileNotFoundException, IOException {
        String cadena;
        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        cadena = b.readLine();
        n1 = new BigInteger(cadena);
        cadena = b.readLine();
        n2 = new BigInteger(cadena);
        b.close();
    }

    /*public  BigInteger karatsuba(BigInteger num1, BigInteger num2) {
        if(num1 < 10 || num2 < 10){
            return num1 * num2;
        }
        //Calcula el tamaño de los numeros
    }*/
}

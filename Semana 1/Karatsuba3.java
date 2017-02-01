import java.math.*;
import java.lang.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Karatsuba3{
    BigInteger n1;
    BigInteger n2;
    BigInteger high = new BigInteger("0");
    BigInteger low = new BigInteger("0");

    public static void main(String args[]) throws FileNotFoundException, IOException {
        Karatsuba3 k = new Karatsuba3();
        k.leeNumeros(args[0]);
        System.out.println(k.n1);
        System.out.println(k.n2);
        System.out.println(k.getSize(k.n1));
        k.split(k.n1, k.getSize(k.n1));
        System.out.println(k.high);
        System.out.println(k.low);
    }

    public int getSize(BigInteger n){
        int size = 0;
        BigInteger valor, residuo, diez;
        diez = new BigInteger("10");
        valor = n;
        while(valor.compareTo(diez) != -1){ //si el numero es mayor a 10
            size++;
            residuo = valor.mod(diez);
            valor = valor.subtract(residuo);
            valor = valor.divide(diez);
        }
        return size + 1;
    }

    //supone la existencia de BigInteger high and low
    public void split(BigInteger num, int size){
        BigInteger valor, residuo, diez;
        int mitad = size / 2;
        int veces, corrHigh, corrLow;
        corrHigh = 0;
        corrLow = 0;
        diez = new BigInteger("10");
        valor = num;
        for(int i = size; i> 0; i--){
            residuo = valor.mod(diez);
            if(i > mitad){
                veces = (int)Math.pow(10,corrLow);
                valor = valor.subtract(residuo);
                valor = valor.divide(diez);
                BigInteger corrimiento = new BigInteger(Integer.toString(veces));
                residuo = residuo.multiply(corrimiento);
                low = low.add(residuo);
                corrLow++;
            }
            else{
                veces = (int)Math.pow(10,corrHigh);
                valor = valor.subtract(residuo);
                valor = valor.divide(diez);
                BigInteger corrimiento = new BigInteger(Integer.toString(veces));
                residuo = residuo.multiply(corrimiento);
                high = high.add(residuo);
                corrHigh++;
            }
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

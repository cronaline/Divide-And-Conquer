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
    BigInteger diez = new BigInteger("10");

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

    public  BigInteger karatsuba(BigInteger num1, BigInteger num2) {
        if(num1 < 10 || num2 < 10){
            return num1 * num2;
        }
        int size;
        size = getSize(num1);
        BigInteger high1 = new BigInteger("0");
        BigInteger low1 = new BigInteger("0");
        BigInteger high2 = new BigInteger("0");
        BigInteger low2 = new BigInteger("0");
        split(num1, size, high1, low1);
        split(num1, size, high2, low2);
        BigInteger z0 = karatsuba(low1, low2);
        BigInteger z1 = karatsuba((low1 + high1), (low2 + high2));
        BigInteger z0 = karatsuba(high1, high2);
        BigInteger result = new BigInteger("0");
        result =
    }

    public int getSize(BigInteger n){
        int size = 0;
        BigInteger valor, residuo;
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
    public void split(BigInteger num, int size, BigInteger high, BigInteger low){
        BigInteger valor, residuo;
        int mitad = size / 2;
        int veces, corrHigh, corrLow;
        corrHigh = 0;
        corrLow = 0;
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

}

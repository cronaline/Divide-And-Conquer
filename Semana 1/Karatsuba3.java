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
        k.low = k.splitLow(k.n1, k.getSize(k.n1));
        System.out.println(k.low);
        k.high = k.splitHigh(k.n1, k.getSize(k.n1));
        System.out.println("\t" + k.high);
        //System.out.println("\n\t\t"+k.low);
    }

    /*public  BigInteger karatsuba(BigInteger num1, BigInteger num2) {
        if(num1 < 10 || num2 < 10){
            return num1 * num2;
        }
        int size;t
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
    }*/

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

    public BigInteger splitLow(BigInteger num, int size){
        BigInteger valor, residuo;
        BigInteger low = new BigInteger("0");
        int mitad = size / 2;
        int veces, corr;
        corr = 0;
        valor = num;
        for(int i = 0; i < mitad; i++){
            residuo = valor.mod(diez);
            veces = (int)Math.pow(10,corr);
            valor = valor.subtract(residuo);
            valor = valor.divide(diez);
            BigInteger corrimiento = new BigInteger(Integer.toString(veces));
            residuo = residuo.multiply(corrimiento);
            low = low.add(residuo);
            corr++;
            //System.out.println(low);
        }
        return low;
    }

    public BigInteger splitHigh(BigInteger num, int size){
        BigInteger valor, residuo;
        BigInteger high = new BigInteger("0");
        int mitad = size / 2;
        int veces, corr;
        corr = 0;
        valor = num;
        for(int i = 0; i < size; i++){
            residuo = valor.mod(diez);
            if(i >= mitad){
                veces = (int)Math.pow(10, corr);
                valor = valor.subtract(residuo);
                valor = valor.divide(diez);
                BigInteger corrimiento = new BigInteger(Integer.toString(veces));
                residuo = residuo.multiply(corrimiento);
                high = high.add(residuo);
                corr++;
            }else{
                valor = valor.subtract(residuo);
                valor = valor.divide(diez);
            }
        }
        return high;
    }

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
                System.out.println(low);
            }
            else{
                veces = (int)Math.pow(10,corrHigh);
                valor = valor.subtract(residuo);
                valor = valor.divide(diez);
                BigInteger corrimiento = new BigInteger(Integer.toString(veces));
                residuo = residuo.multiply(corrimiento);
                high = high.add(residuo);
                corrHigh++;
                System.out.println(high);
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

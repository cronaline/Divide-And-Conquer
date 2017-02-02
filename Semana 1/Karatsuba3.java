import java.math.*;
import java.lang.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Karatsuba3{
    BigInteger n1;
    BigInteger n2;
    BigInteger diez = new BigInteger("10");
    BigInteger res = new BigInteger("0");

    public static void main(String args[]) throws FileNotFoundException, IOException {
        Karatsuba3 k = new Karatsuba3();
        k.leeNumeros(args[0]);
        System.out.println(k.n1);
        System.out.println(k.n2);
        System.out.println("Resultado de la multiplicacion: \n");
        k.res = k.karatsuba(k.n1, k.n2);
        System.out.println("\t" + k.res);
    }

    public  BigInteger karatsuba(BigInteger num1, BigInteger num2) {
        if(num1.compareTo(diez)  == -1 || num2.compareTo(diez) == -1){ //Si num1 o num2 son menores a diez
            BigInteger res = num1;
            return res.multiply(num2); //n1 * n2
        }
        int size, mid;
        size = getSize(num1);
        mid = size / 2;
        BigInteger high1 = new BigInteger("0");
        BigInteger low1 = new BigInteger("0");
        BigInteger high2 = new BigInteger("0");
        BigInteger low2 = new BigInteger("0");
        low1 = splitLow(n1, size);
        high1 = splitHigh(n1, size);
        low2 = splitLow(n2, size);
        high2 = splitHigh(n2, size);
        BigInteger z0 = karatsuba(low1, low2);
        BigInteger z1 = karatsuba((low1.add(high1)), (low2.add(high2)));
        BigInteger z2 = karatsuba(high1, high2);
        BigInteger result = new BigInteger("0");
        result = z2.multiply(diez.pow(2 * mid));    //z2*10^(2*mid)
        result = result.add((z1.subtract(z2).subtract(z0)).multiply(diez.pow(mid)));
        result = result.add(z0);
        return result;
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

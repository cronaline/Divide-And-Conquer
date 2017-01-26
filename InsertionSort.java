/*
Insertion Sort
Correspondiente a las lecturas complementarias del curso
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
        System.out.println();
        is.insertionSort();
        is.listar();
        is.insertionSortAsc();
        is.listar();
    }

    //Metodo que ordena los valores en la lista de menor a mayor utilizando insertionSort
    public void insertionSort(){
        int key, j;
        for(int i = 1; i < a.length; i++){  //Indice para el elemento a comparar con los demas
            //listar();
            key = a[i]; //elemento elegido
            j = i - 1;  //La comparacion empieza con los elementos anteriores al elegido
            while(j >= 0 && a[j] > key){    //mueve los elementos anteriores y mayores al elemento elegido
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;
        }
    }

    //Metodo que ordena los numeros de menor a mayor 
    public void insertionSortAsc(){
        int key, j;
        for(int i = 1; i < a.length; i++){
            key = a[i];
            j = i - 1;
            while(j >= 0 && a[j] < key){
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;
        }
    }
    //Metodo que lee los numeros de un archivo y los transforma a un arreglo de int
    //Entrada nombre del archivo a leer
    public void leeNumeros(String archivo) throws FileNotFoundException, IOException, NumberFormatException {
        FileReader fr = new FileReader(archivo);    //Se crea el stream para la lectura de caracteres
        BufferedReader b = new BufferedReader(fr);  //Creacion del buffer de lectura
        String cadena = b.readLine();   //cadena es llenado con todos ls numeros en el archivo
        String[] numeros = cadena.replaceAll("\\s", "").split(","); //creamos un arreglo para los los numeros
        a = new int[numeros.length]; //creacion del arreglo int
        for(int i = 0; i < a.length; i++){  //Cast y almacenamiento
            try{
                a[i] = Integer.parseInt(numeros[i]);
            }catch (NumberFormatException nfe){
            };
        }
        b.close();  //Se cierra el archivo
    }

    //Metodo que lista todos los elementos leidos del archivo, un vez que fueron guardados en el arreglo
    public void listar(){
        System.out.println();
        for(int i = 0; i < a.length; i++){
            System.out.print(a[i] );
        }
    }
}

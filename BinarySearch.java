/*
BinarySearch
Correspondiente a las lecturas complementarias del curso
Version 1
16/enero/2017
*/
import java.lang.NumberFormatException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BinarySearch{
    public int a[];

    public static void main(String args[]) throws FileNotFoundException, IOException{
        BinarySearch bs = new BinarySearch();
        bs.leeNumeros(args[0]);
        System.out.println();
        bs.listar();
        System.out.println();
        bs.insertionSort();
        bs.listar();
        System.out.println("\n"+bs.search(6, 0, bs.a.length -1));
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

    //Metodo que encuentra un valor en el arreglo
    //Entrada: valor a buscar, indice de inicio e indice de fin
    //Salida: indice donde se encuentra el valor buscado, -1 si no existe tal valor 
    public int search(int val, int inicio, int fin){
        int mitad;
        mitad = (inicio + fin) /2;
        if(a[mitad] == val){
            return mitad;
        }else if(inicio == fin && a[inicio] != val){
            return -1;
        }else if(a[mitad] > val){
            return search(val, inicio, mitad);
        }else{
            return search(val, mitad + 1, fin);
        }

    }
}

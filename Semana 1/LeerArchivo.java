import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LeerArchivo {

    //Metodo que lee un archivo linea a linea
    //Entrada: nombre del archivo
    //Salida: contenido del archivo original
    public static void leeFilas(String archivo) throws FileNotFoundException, IOException {
        String cadena;
        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        while((cadena = b.readLine())!=null) {
            System.out.println(cadena);
        }
        b.close();
    }

    //Metodo que lee un archivo caracter a caracter
    //Entrada: nombre del archivo
    //Salida: caracteres contenidos en el archivo, impreso uno a uno
    public static void leeCaracter(String archivo) throws FileNotFoundException, IOException {
        FileReader fr = new FileReader(archivo);
        int car = fr.read();
        while(car != -1) //Se recorre el fichero hasta encontrar el caracter de fin de archivo
        {
            System.out.print(Character.toString((char)car));
            car = fr.read(); //Leer el siguiente carácter
        }
        fr.close(); //Se cierra el archivo
    }

    public static void main(String[] args) throws IOException {
        leeFilas(args[0]);
        System.out.println();
        leeCaracter(args[0]);
    }

}

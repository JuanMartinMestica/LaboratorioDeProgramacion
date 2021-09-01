package laboratorio;

import java.io.File;
import Utilidades.TecladoIn;

public class Laboratorio {

    public static void main(String[] args) {

        Carpeta raiz = cargaInicial();
        String nombreCarpeta;
        
        System.out.print("Ingrese el nombre de la carpeta a la que quiere ingresar: ");
        nombreCarpeta = TecladoIn.readLine();
        
        Carpeta subcarpeta = raiz.obtenerSubcarpeta(nombreCarpeta);
        
        System.out.println(subcarpeta.toString());
        
    }

    public static Carpeta cargaInicial() {

        Carpeta raiz = null;
        
        //Se especifica la ruta de la carpeta padre
        String path = "C:\\Users\\MARTIN\\Desktop";

        //Se crea un item de tipo File, que será una carpeta o archivo
        File item = new File(path, "Prueba");

        //Se verifica si existe el item
        if (item.exists()) {

            raiz = cargaPublica(item);

            System.out.println(raiz.toString());
            System.out.println("Cant hijos inmediatos: " + raiz.getCantHijos());

        } else {
            System.out.println("ERROR: No existe archivo-carpeta en la ruta dada.");
        }

      return raiz;  
      
    }

    private static Carpeta cargaPublica(File item) {
        Carpeta raiz;

        raiz = new Carpeta(item.getName());
        cargaAux(raiz, item);

        return raiz;
    }

    private static void cargaAux(Carpeta visitado, File item) {

        for (File subElem : item.listFiles()) {

            //Si el subelemento es una carpeta, se crea una instancia de Carpeta
            if (subElem.isDirectory()) {

                Carpeta nuevaCarpeta = new Carpeta(subElem.getName());

                cargaAux(nuevaCarpeta, subElem);

                //Se añade la Carpeta a la Carpeta padre
                visitado.añadirItem(nuevaCarpeta);

            } else {
                //Si el subelemento es un archivo, se crea una instancia de Archivo
                Archivo nuevoArchivo = new Archivo(subElem.getName(), subElem.length());

                //Se añade el Archivo a la Carpeta
                visitado.añadirItem(nuevoArchivo);
            }
        }
    }

}

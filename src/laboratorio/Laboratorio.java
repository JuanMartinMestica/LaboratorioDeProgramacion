package laboratorio;

import java.io.File;

public class Laboratorio {

    public static void main(String[] args) {

        
        /*Pruebas con archivos*/
        
        String path = "C:\\Users\\MARTIN\\Desktop\\Segundo cuatrimestre 2021";

        File archivo = new File(path, "Redes");

    
          if (archivo.exists()) {
            
              System.out.println("!!!!");
              
              for (File ar: archivo.listFiles()) { 
                 System.out.println("Archivo: " + ar.getName() + " pesa: " + ar.length());
                       
              }
              
        }
           
    

    }

}

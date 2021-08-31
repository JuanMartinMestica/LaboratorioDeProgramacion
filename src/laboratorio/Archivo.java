package laboratorio;
import java.io.File;

/*Laboratorio de Programación - Fernando Iraira - Juan Mestica*/

public class Archivo implements ItemArchivo{
    
    File archivo;
    String nombre;
    
    @Override
    public double getPeso() {
        return archivo.length();
    }

    @Override
    public String getNombre() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mostrar() {
        
    }


    
    

    
}

package laboratorio;

/*Laboratorio de Programación - Fernando Iraira - Juan Mestica*/

public class Archivo implements ItemArchivo {

    String nombre;
    double peso;

    public Archivo(String nombre, double peso) {
        this.nombre = nombre;
        this.peso = peso;
    }

    @Override
    public double getPeso() {
        return this.peso;
    }

    @Override
    public String getNombre() {
        return "----- [Archivo] " + this.nombre + "| Peso: " + this.peso;
    }

    @Override
    public String toString() {
        return "----- [Archivo] " + this.nombre + "| Peso: " + this.peso;
    }
}

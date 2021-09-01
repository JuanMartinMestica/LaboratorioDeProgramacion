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
        return this.nombre;
    }

    @Override
    public String toString() {
        return "----- [Archivo] " + this.nombre + "| Peso: " + String.format("%.2f",this.peso / 1024);
    }

    @Override
    public String mostrar() {
        return "[Archivo] " + this.nombre;
    }
}

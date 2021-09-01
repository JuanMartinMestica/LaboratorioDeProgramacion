package Utilidades;

public class Pila {
    private Nodo tope;
    
    public Pila(){
        this.tope = null;
    }
    
    public boolean apilar(Object nuevoElem){
        //crea un nuevo nodo delante de la antigua cabecera
        Nodo nuevo = new Nodo(nuevoElem, this.tope);
        
        //actualiza el tope para que apunte al nodo nuevo
        this.tope = nuevo;
        
        //nunca hay error de pila llena , entonces devuelve true
        return true;
    }
    
    public boolean desapilar(){
        boolean exito;
        
        if (this.tope == null){
            exito = false;
        }
        else{
            this.tope = this.tope.getEnlace();
            exito = true;
        }
        
        
        return exito;
    }
    
    public boolean esVacia(){
        return (this.tope==null);
    }
    
    public void vaciar(){
        this.tope = null;
    }
    
    @Override
    public String toString(){
        String s = "";
        
        if (this.tope == null){
            s = "Pila vacia";
        }
        else{
            //se ubica para recorrer la pila
            Nodo aux = this.tope;
            s = "[";
            while (aux != null){
                //agrega el texto del elem y avanza
                s += aux.getElem().toString();
                aux = aux.getEnlace();
                if (aux != null)
                    s += ",";
            }
            s+= "]";  
        }
        return s;
    }
    
    public Object obtenerTope(){
        Object elTope;
        
        if(this.tope == null){
            elTope = null;
        }
        else{
            elTope = this.tope.getElem();
        }
        return elTope;
    }
    //Clonar de pila sin utilizar recursion
    
    public Pila clone() {

        Pila clon = new Pila();
        if (this.tope != null) {
            clon.tope = clonador(this.tope);
        }

        return clon;
    }

    private Nodo clonador(Nodo nodo) {
        
        Nodo aux = new Nodo(null,null);
        aux.setElem(nodo.getElem());

        if (nodo.getEnlace() != null) {

            aux.setEnlace(clonador(nodo.getEnlace()));
 
        }

        return aux;
    }
}

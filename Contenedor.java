/*
 * Programa hecho por Jonathan Tubac 24484
 * Programa de gestión de contenedores
 */
public class Contenedor {
    private String id;
    private String nombreProducto;
    private double peso;
    private String destino;

    //constructor
    public Contenedor(String id, String nombreProducto, double peso, String destino){
        this.id = id;
        this.nombreProducto = nombreProducto;
        this.peso = peso;
        this.destino = destino;
    }

    //retornará el id del contenedor
    public String getId(){
        return id;
    }

    //retornará el nombre del producto del contenedor
    public String getNombreProducto(){
        return nombreProducto;
    }

    //retornará el peso del contenedor
    public double getPeso(){
        return peso;
    }

    //retornará el destino del contenedor
    public String getDestino(){
        return destino;
    }

    //retornará los valores del contenedor para imprimirse en el Main
    @Override
    public String toString() {
        return "ID: " + id + ", Producto: " + nombreProducto + ", Peso: " + peso + "kg, Destino: " + destino;
    }
}

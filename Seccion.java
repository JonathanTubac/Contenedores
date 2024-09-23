/*
 * Programa hecho por Jonathan Tubac 24484
 * Programa de gestión de contenedores
 */

public class Seccion {
    private String nombre;
    private double pesoMaximo;
    private Contenedor[][] contenedores;
    private double pesoActual;

    public Seccion(String nombre, double pesoMaximo) {
        this.nombre = nombre;
        this.pesoMaximo = pesoMaximo;
        this.contenedores = new Contenedor[10][5]; 
        this.pesoActual = 0;
    }

    public void setNull(int fila, int columna) {
        if (fila >= 0 && fila < contenedores.length && columna >= 0 && columna < contenedores[fila].length) {
            contenedores[fila][columna] = null;
        }
    }
    
    //Asigna el contenedor a un espacio de la matriz
    public boolean agregarContenedor(Contenedor contenedor) {
        if (pesoActual + contenedor.getPeso() > pesoMaximo) {
            System.out.println("No se puede agregar. Excede el peso máximo de la sección.");
            return false;
        }

        for (int i = 0; i < contenedores.length; i++) {
            for (int j = 0; j < contenedores[i].length; j++) {
                if (contenedores[i][j] == null) {
                    contenedores[i][j] = contenedor;
                    pesoActual += contenedor.getPeso();
                    return true;
                }
            }
        }

        System.out.println("No hay espacio disponible en la sección.");
        return false;
    }

    //muestra los valores de los contenedores en dicha sección
    public void mostrarContenedores() {
        for (int i = 0; i < contenedores.length; i++) {
            for (int j = 0; j < contenedores[i].length; j++) {
                if (contenedores[i][j] != null) {
                    System.out.println(contenedores[i][j]);
                }
            }
        }
    }

    //retorna el peso actual de la sección
    public double calcularPesoTotal() {
        return pesoActual;
    }
    
    //obtiene el valor del cotenedor segun su pisición en la fila y columna
    public Contenedor getContenedor(int fila, int columna) {
        if (fila >= 0 && fila < contenedores.length && columna >= 0 && columna < contenedores[fila].length) {
            return contenedores[fila][columna];
        }
        return null; 
    }
    
    public void setPesoActual(double peso) {
        this.pesoActual = peso;
    }
    
   //mueve el origen del contenedor al destino que se quiere mover
    public boolean moverContenedor(int filaOrigen, int colOrigen, int filaDestino, int colDestino) {
        if (contenedores[filaOrigen][colOrigen] != null && contenedores[filaDestino][colDestino] == null) {
            contenedores[filaDestino][colDestino] = contenedores[filaOrigen][colOrigen];
            contenedores[filaOrigen][colOrigen] = null;
            return true;
        }
        System.out.println("Movimiento no permitido.");
        return false;
    }
}

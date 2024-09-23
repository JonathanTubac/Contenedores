/*
 * Programa hecho por Jonathan Tubac 24484
 * Programa de gestión de contenedores
 */
import java.util.HashMap;
import java.util.Map;

public class Puerto {
    private Map<String, Seccion> secciones;

    //creacion de las secciones con sus nombres y pesos máximos
    public Puerto() {
        secciones = new HashMap<>();
        secciones.put("Electrónicos", new Seccion("Electrónicos", 200000));
        secciones.put("Ropa", new Seccion("Ropa", 150000));
        secciones.put("Alimentos", new Seccion("Alimentos", 250000));
        secciones.put("Maquinaria", new Seccion("Maquinaria", 300000));
    }

    //verifica si la sección existe para poder agregar el contenedor a la matriz
    public boolean agregarContenedor(String seccion, Contenedor contenedor) {
        Seccion sec = secciones.get(seccion);
        if (sec != null) {
            return sec.agregarContenedor(contenedor);
        }
        System.out.println("Sección no encontrada.");
        return false;
    }

    //verifica si la sección existe para poder mostrar los contenedores de dicha sección
    public void mostrarContenedores(String seccion) {
        Seccion sec = secciones.get(seccion);
        if (sec != null) {
            sec.mostrarContenedores();
        } else {
            System.out.println("Sección no encontrada.");
        }
    }

    //Obtiene el origen y el destino al que se desea mover el contenedor, ademas elimina el contenedor de la sección donde estaba
    public boolean moverContenedorEntreSecciones(String seccionOrigen, String seccionDestino, Contenedor contenedor) {
        Seccion origen = secciones.get(seccionOrigen);
        Seccion destino = secciones.get(seccionDestino);
    
        if (origen != null && destino != null) {
            if (origen.calcularPesoTotal() >= contenedor.getPeso() && destino.agregarContenedor(contenedor)) {

                for (int i = 0; i < 10; i++) {
                    for (int j = 0; j < 5; j++) {
                        if (origen.getContenedor(i, j) != null && origen.getContenedor(i, j).getId().equals(contenedor.getId())) {
                            origen.setNull(i, j);
                            origen.setPesoActual(origen.calcularPesoTotal() - contenedor.getPeso()); 
                            return true;
                        }
                    }
                }
            }
        }
        System.out.println("Error al mover contenedor entre secciones.");
        return false;
    }
    

    //busca la posición de un contenedor en una sección, si existe en la seccion
    public Contenedor buscarContenedor(String seccion, String id) {
        Seccion sec = secciones.get(seccion);
        if (sec != null) {
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 5; j++) {
                    Contenedor contenedor = sec.getContenedor(i, j);
                    if (contenedor != null && contenedor.getId().equals(id)) {
                        return contenedor;
                    }
                }
            }
        }
        return null;
    }
    

    //obtiene las secciones existentes
    public Map<String, Seccion> getSecciones() {
        return secciones;
    }

    //verifica si la seccion existe para poder calcular su peso total
    public void calcularPesoSeccion(String seccion) {
        Seccion sec = secciones.get(seccion);
        if (sec != null) {
            System.out.println("Peso total de la sección " + seccion + ": " + sec.calcularPesoTotal() + " kg");
        } else {
            System.out.println("Sección no encontrada.");
        }
    }
}

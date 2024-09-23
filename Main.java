/*
 * Programa hecho por Jonathan Tubac 24484
 * Programa de gestión de contenedores
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Puerto puerto = new Puerto();
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        //menu principal
        while (!salir) {
            System.out.println("\n--- Sistema de Gestión de Contenedores ---");
            System.out.println("1. Agregar contenedor");
            System.out.println("2. Ver contenedores en una sección");
            System.out.println("3. Mover contenedor entre secciones");
            System.out.println("4. Calcular peso total de una sección");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    System.out.print("Ingresa el ID del contenedor: ");
                    String id = scanner.nextLine();
                    System.out.print("Ingresa el nombre del producto: ");
                    String nombreProducto = scanner.nextLine();
                    System.out.print("Ingresa el peso del contenedor: ");
                    double peso = scanner.nextDouble();
                    scanner.nextLine();  
                    System.out.print("Ingresa el destino del contenedor: ");
                    String destino = scanner.nextLine();
                    
                    String seccionAgregar = seleccionarSeccion(scanner);

                    if (seccionAgregar != null) {
                        Contenedor contenedor = new Contenedor(id, nombreProducto, peso, destino);
                        puerto.agregarContenedor(seccionAgregar, contenedor);
                    } else {
                        System.out.println("Sección no válida.");
                    }
                    break;

                case 2:
                    String seccionVer = seleccionarSeccion(scanner);
                    if (seccionVer != null) {
                        puerto.mostrarContenedores(seccionVer);
                    } else {
                        System.out.println("Sección no válida.");
                    }
                    break;

                    case 3:
                    System.out.print("Ingresa el ID del contenedor a mover: ");
                    String idMover = scanner.nextLine();
                
                    String seccionOrigen = seleccionarSeccion(scanner);
                    if (seccionOrigen == null) {
                        System.out.println("Sección de origen no válida.");
                        break;
                    }
                
                    String seccionDestino = seleccionarSeccion(scanner);
                    if (seccionDestino == null) {
                        System.out.println("Sección de destino no válida.");
                        break;
                    }
                
                    // Llama a buscarContenedor desde el objeto puerto
                    Contenedor contenedorMover = puerto.buscarContenedor(seccionOrigen, idMover);
                    if (contenedorMover != null) {
                        puerto.moverContenedorEntreSecciones(seccionOrigen, seccionDestino, contenedorMover);
                    } else {
                        System.out.println("Contenedor no encontrado en la sección de origen.");
                    }
                    break;
                case 4:
                    String seccionPeso = seleccionarSeccion(scanner);
                    if (seccionPeso != null) {
                        puerto.calcularPesoSeccion(seccionPeso);
                    } else {
                        System.out.println("Sección no válida.");
                    }
                    break;

                case 5:
                    salir = true;
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
                    break;
            }
        }

        scanner.close();
    }

    //menu de secciones
    public static String seleccionarSeccion(Scanner scanner) {
        System.out.println("\n--- Selecciona la sección ---");
        System.out.println("1. Electrónicos");
        System.out.println("2. Ropa");
        System.out.println("3. Alimentos");
        System.out.println("4. Maquinaria");
        System.out.print("Elige una sección: ");

        int opcionSeccion = scanner.nextInt();
        scanner.nextLine();  

        switch (opcionSeccion) {
            case 1:
                return "Electrónicos";
            case 2:
                return "Ropa";
            case 3:
                return "Alimentos";
            case 4:
                return "Maquinaria";
            default:
                return null; 
        }
    }

    
}

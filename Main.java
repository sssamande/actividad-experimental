import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestorDeTorneo gestor = new GestorDeTorneo();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        while (true) {
            System.out.println("1. Registrar Equipo");
            System.out.println("2. Agregar Jugador a Equipo");
            System.out.println("3. Crear Partido");
            System.out.println("4. Consultar Equipos");
            System.out.println("5. Consultar Partidos");
            System.out.println("6. Actualizar Resultado de Partido");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del equipo: ");
                    String nombreEquipo = scanner.nextLine();
                    System.out.print("Ingrese el nombre del entrenador: ");
                    String entrenador = scanner.nextLine();
                    Equipo equipo = new Equipo(nombreEquipo, entrenador);
                    gestor.registrarEquipo(equipo);
                    System.out.println("Equipo registrado.");
                    break;

                case 2:
                    System.out.print("Ingrese el nombre del equipo: ");
                    String nombreEquipoJugador = scanner.nextLine();
                    Equipo equipoEncontrado = null;
                    for (Equipo e : gestor.getEquipos()) {
                        if (e.getNombre().equalsIgnoreCase(nombreEquipoJugador)) {
                            equipoEncontrado = e;
                            break;
                        }
                    }
                    if (equipoEncontrado != null) {
                        System.out.print("Ingrese el nombre del jugador: ");
                        String nombreJugador = scanner.nextLine();
                        Jugador jugador = new Jugador(nombreJugador);
                        equipoEncontrado.agregarJugador(jugador);
                        System.out.println("Jugador agregado al equipo.");
                    } else {
                        System.out.println("Equipo no encontrado.");
                    }
                    break;

                case 3:
                    System.out.print("Ingrese el nombre del equipo local: ");
                    String nombreLocal = scanner.nextLine();
                    System.out.print("Ingrese el nombre del equipo visitante: ");
                    String nombreVisitante = scanner.nextLine();
                    System.out.print("Ingrese la fecha del partido (dd/MM/yyyy): ");
                    String fechaString = scanner.nextLine();
                    Date fecha;
                    try {
                        fecha = dateFormat.parse(fechaString);
                    } catch (ParseException e) {
                        System.out.println("Formato de fecha inválido. Intente de nuevo.");
                        break;
                    }
                    Equipo local = null, visitante = null;
                    for (Equipo e : gestor.getEquipos()) {
                        if (e.getNombre().equalsIgnoreCase(nombreLocal)) {
                            local = e;
                        }
                        if (e.getNombre().equalsIgnoreCase(nombreVisitante)) {
                            visitante = e;
                        }
                    }
                    if (local != null && visitante != null) {
                        gestor.crearPartido(local, visitante, fecha);
                        System.out.println("Partido creado.");
                    } else {
                        System.out.println("Uno o ambos equipos no encontrados.");
                    }
                    break;

                case 4:
                    gestor.mostrarEquipos();
                    break;

                case 5:
                    gestor.mostrarPartidos();
                    break;

                case 6:
                    System.out.print("Ingrese el índice del partido a actualizar: ");
                    int index = scanner.nextInt();
                    scanner.nextLine(); // Limpiar el buffer
                    System.out.print("Ingrese el marcador (ej. 2-1): ");
                    String marcador = scanner.nextLine();
                    gestor.actualizarResultadoPartido(index - 1, marcador);
                    System.out.println("Resultado actualizado.");
                    break;

                case 7:
                    System.out.println("Saliendo...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}
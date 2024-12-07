import java.util.ArrayList;
import java.util.List;

public class Equipo {
    private String nombre;
    private String entrenador;
    private List<Jugador> jugadores;

    public Equipo(String nombre, String entrenador) {
        this.nombre = nombre;
        this.entrenador = entrenador;
        this.jugadores = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getEntrenador() {
        return entrenador;
    }

    public void agregarJugador(Jugador jugador) {
        jugadores.add(jugador);
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void mostrarJugadores() {
        System.out.print("Jugadores: ");
        for (Jugador jugador : jugadores) {
            System.out.print(jugador.getNombre() + " ");
        }
        System.out.println();
    }
}
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GestorDeTorneo {
    private List<Equipo> equipos;
    private List<Partido> partidos;

    public GestorDeTorneo() {
        equipos = new ArrayList<>();
        partidos = new ArrayList<>();
    }

    public void registrarEquipo(Equipo equipo) {
        equipos.add(equipo);
    }

    public List<Equipo> getEquipos() {
        return equipos;
    }

    public void crearPartido(Equipo local, Equipo visitante, Date fecha) {
        Partido partido = new Partido(local, visitante, fecha);
        partidos.add(partido);
    }

    public void mostrarEquipos() {
        for (Equipo equipo : equipos) {
            System.out.println("Nombre: " + equipo.getNombre());
            System.out.println("Entrenador: " + equipo.getEntrenador());
            equipo.mostrarJugadores();
            System.out.println();
        }
    }

    public void mostrarPartidos() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        for (int i = 0; i < partidos.size(); i++) {
            Partido partido = partidos.get(i);
            System.out.println("Partido " + (i + 1) + ": " +
                    partido.getLocal().getNombre() + " vs " +
                    partido.getVisitante().getNombre() + " | " +
                    dateFormat.format(partido.getFecha()) + " | " +
                    partido.getResultado());
        }
    }

    public void actualizarResultadoPartido(int index, String marcador) {
        if (index >= 0 && index < partidos.size()) {
            partidos.get(index).setResultado(marcador);
        } else {
            System.out.println("Índice inválido.");
        }
    }
}
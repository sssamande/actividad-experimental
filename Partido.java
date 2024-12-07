import java.util.Date;

public class Partido {
    private Equipo local;
    private Equipo visitante;
    private Date fecha;
    private String resultado;

    public Partido(Equipo local, Equipo visitante, Date fecha) {
        this.local = local;
        this.visitante = visitante;
        this.fecha = fecha;
        this.resultado = "Sin resultado";
    }

    public Equipo getLocal() {
        return local;
    }

    public Equipo getVisitante() {
        return visitante;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
}
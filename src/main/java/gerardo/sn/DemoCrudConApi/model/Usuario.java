package gerardo.sn.DemoCrudConApi.model;

//public class Usuario {
//}
import java.time.LocalDate;
import jakarta.persistence.*;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private boolean habilitadoParaIngresar;
    private LocalDate habilitadoHastaLaFecha;

    public Usuario() {}

    public Usuario(String nombre, boolean habilitadoParaIngresar, String habilitadoHastaLaFecha) {
        this.nombre = nombre;
        this.habilitadoParaIngresar = habilitadoParaIngresar;
        this.habilitadoHastaLaFecha = LocalDate.parse(habilitadoHastaLaFecha);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isHabilitadoParaIngresar() {
        return habilitadoParaIngresar;
    }

    public void setHabilitadoParaIngresar(boolean habilitadoParaIngresar) {
        this.habilitadoParaIngresar = habilitadoParaIngresar;
    }

    public LocalDate getHabilitadoHastaLaFecha() {
        return habilitadoHastaLaFecha;
    }

    public void setHabilitadoHastaLaFecha(LocalDate habilitadoHastaLaFecha) {
        this.habilitadoHastaLaFecha = habilitadoHastaLaFecha;
    }
}
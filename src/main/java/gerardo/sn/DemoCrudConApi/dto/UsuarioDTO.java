package gerardo.sn.DemoCrudConApi.dto;

import gerardo.sn.DemoCrudConApi.model.Usuario;

//public class UsuarioDTO {
//}
public class UsuarioDTO {
    private Long id;
    private String nombre;
    private boolean habilitadoParaIngresar;
    private String habilitadoHastaLaFecha;

    public UsuarioDTO() {}

    public UsuarioDTO(Usuario usuario) {
        this.id = usuario.getId();
        this.nombre = usuario.getNombre();
        this.habilitadoParaIngresar = usuario.isHabilitadoParaIngresar();
        this.habilitadoHastaLaFecha = usuario.getHabilitadoHastaLaFecha().toString();
    }

    // Getters y setters
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

    public String getHabilitadoHastaLaFecha() {
        return habilitadoHastaLaFecha;
    }

    public void setHabilitadoHastaLaFecha(String habilitadoHastaLaFecha) {
        this.habilitadoHastaLaFecha = habilitadoHastaLaFecha;
    }
}

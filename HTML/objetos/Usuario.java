package objetos;

public class Usuario {
    private String nombre;
    private String contra;

    public Usuario(String contra, String nombre) {
        this.contra = contra;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }
}

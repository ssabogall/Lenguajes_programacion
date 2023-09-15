import java.util.Scanner;

public class Administrador extends Login {
    private String nombre;
    private String correo;

    public Administrador() {
        this.correo = correo;
    }

    public void metodoAdmin() {
        // Realiza aquí las acciones específicas del administrador
        Scanner sc = new Scanner(System.in);

        System.out.println("Ponle un codigo al usuario que ingreso");
        String codigo = sc.next();
    }

    private Cliente buscarCliente(String correo, String nombre) {
        // Implementa la búsqueda real de clientes aquí o utiliza la funcionalidad de Login
        return null;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}

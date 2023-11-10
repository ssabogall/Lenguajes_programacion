import java.util.Scanner;

public class Login {
    private Cliente[] clientes;

    public Login() {
        clientes = new Cliente[100];
    }

    public boolean verificar(String nombreIngresado, String correoIngresado) {
        for (int i = 0; i < clientes.length; i++) {
            Cliente cliente = clientes[i];
            if (cliente != null && cliente.getNombre().equals(nombreIngresado) && cliente.getCorreo().equals(correoIngresado)) {
                return true;
            }
        }
        return false;
    }

    public void registrarCliente() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el correo: ");
        String correo = sc.nextLine();
        System.out.print("Ingrese el Nombre: ");
        String nombre = sc.nextLine();

        Cliente cliente = new Cliente("", nombre, correo); // Usuario no requerido para registro

        for (int i = 0; i < clientes.length; i++) {
            if (clientes[i] == null) {
                clientes[i] = cliente;
                System.out.println("Cliente registrado correctamente.");
                break;
            }
        }
    }

    public Cliente[] getClientes() {
        return clientes;
    }
}

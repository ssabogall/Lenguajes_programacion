import java.util.Scanner;

public class Main {
    private Scanner sc;
    private Cliente clienteLogueado;
    private Cajero cajeroLogueado;
    private Administrador administrador;

    public Main() {
        sc = new Scanner(System.in);
        Login login = new Login();
        String CLcajero = "cajero123";
        String CLadmin = "admin678";

        while (true) {
            System.out.println("Crear cuenta (0)");
            System.out.println("Login (1)");
            System.out.println("Salir (2)");

            int opc3 = sc.nextInt();
            switch (opc3) {
                case 0:
                    login.registrarCliente();
                    break;

                case 1:
                    System.out.print("Digite su correo: ");
                    String correoIngresado = sc.next();
                    System.out.print("Digite su nombre: ");
                    String nombreIngresado = sc.next();
                    if (login.verificar(nombreIngresado, correoIngresado)) {
                        clienteLogueado = new Cliente("", nombreIngresado, correoIngresado);
                        cajeroLogueado = new Cajero("", nombreIngresado, correoIngresado);
                        administrador = new Administrador();
                        loggedInMenu();
                    } else {
                        System.out.println("Inicio de sesión fallido. Verifique sus credenciales.");
                    }
                    break;
                case 2:
                    System.out.println("Hasta la próxima vez.");
                    sc.close();
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    public void loggedInMenu() {
        int opc1 = 0;
        String CLcajero = "cajero123";
        String CLadmin = "admin678";
        while (true) {
            System.out.println("0. Cliente:");
            System.out.println("1. Cajero:");
            System.out.println("2. Administrador:");
            System.out.println("3. Salir");
            opc1 = sc.nextInt();
            switch (opc1) {
                case 0:
                    System.out.println("Bienvenido querido cliente a nuestra pagina:");
                    clienteLogueado.mostrarInformacion();
                    break;
                case 1:
                    System.out.print("Ingrese la contraseña de Cajero: ");
                    String claveCajero = sc.next();
                    if (CLcajero.equals(claveCajero)) {
                        System.out.println("Hola cajero, por favor registre la venta");
                        cajeroLogueado.metodoCajero();
                    } else {
                        System.out.println("Contraseña incorrecta.");
                    }
                    break;
                case 2:
                    System.out.print("Ingrese la contraseña de Administrador: ");
                    String claveAdmin = sc.next();
                    if (CLadmin.equals(claveAdmin)) {
                        System.out.println("Hola administrador, ¿qué quiere hacer?");
                        administrador.metodoAdmin();
                    } else {
                        System.out.println("Contraseña incorrecta.");
                    }
                    break;
                case 3:
                    System.out.println("Hasta pronto querido usuario:");
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    public static void main(String[] args) {
        Main cliente = new Main();
    }
}

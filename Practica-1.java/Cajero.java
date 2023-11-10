import java.util.Scanner;

public class Cajero extends Login {
    private String usuario;
    private String nombre;
    private String correo;
    public Venta[] ventas;
    public int ventasRealizadas;

    public Cajero(String usuario, String nombre, String correo) {
        super();
        this.usuario = usuario;
        this.nombre = nombre;
        this.correo = correo;
        this.ventas = new Venta[100];
        this.ventasRealizadas = 0;
    }

    public void crearVenta() {
        Scanner sc = new Scanner(System.in);

        if (ventasRealizadas < ventas.length) {
            System.out.println("Ingrese los detalles de la venta:");

            System.out.print("Productos vendidos: ");
            String productosVendidos = sc.nextLine();

            System.out.print("Precio: ");
            double precio = sc.nextDouble();

            sc.nextLine();

            Venta venta = new Venta(productosVendidos, precio);

            agregarVenta(venta);

            System.out.println("Venta registrada correctamente.");
        } else {
            System.out.println("No se pueden agregar más ventas, la matriz está llena.");
        }
    }

    public void agregarVenta(Venta venta) {
        if (ventasRealizadas < ventas.length) {
            ventas[ventasRealizadas] = venta;
            ventasRealizadas++;
        } else {
            System.out.println("No se pueden agregar más ventas, la matriz está llena.");
        }
    }

    public void metodoCajero() {
        int opc2;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("0. Agregar venta");
            System.out.println("1. Salir");
            opc2 = sc.nextInt();
            switch (opc2) {
                case 0:
                    System.out.println("Realizando venta...");
                    crearVenta();
                    break;
                case 1:
                    System.out.println("Hasta la próxima venta, querido cajero.");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opc2 != 1);
    }

    public String getCorreo() {
        return correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    private class Venta {
        private String productosVendidos;
        private double precio;

        public Venta(String productosVendidos, double precio) {
            this.productosVendidos = productosVendidos;
            this.precio = precio;
        }
    }
}

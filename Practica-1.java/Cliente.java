public class Cliente extends Cajero {

    public Cliente(String usuario, String nombre, String correo) {
        super(usuario, nombre, correo);
    }

    public void mostrarInformacion() {
        String camisa = "Camisa sencilla en cuello V";
        String pantalon = "Cargueros de Bad Bunny";
        String chaqueta = "Chaqueta para la nieve";

        System.out.println("Cliente: " + getNombre());
        System.out.println("Correo electrónico: " + getCorreo());
        System.out.println(camisa + " $17,900");
        System.out.println(pantalon + " $1,900,000");
        System.out.println(chaqueta + " $300,000");
    }
}

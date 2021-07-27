package dominio;

public class Cuenta {

    private int nroCuenta;
    private String tipo = null;
    private double saldoCuenta;
    private static int contador_int;
    private Cliente cliente;

    public Cuenta() {
        this.nroCuenta = Cuenta.contador_int++;
    }

    public Cuenta(double saldoCuenta) {
        this();
        this.saldoCuenta = saldoCuenta;
    }

    public int getNroCuenta() {
        return this.nroCuenta;
    }

    public double getSaldoCuenta() {
        return saldoCuenta;
    }

    public void depositar(double cantidad) {
        this.saldoCuenta = this.saldoCuenta + cantidad;
    }

    public void retirar(double cantidad) {
        this.saldoCuenta = this.saldoCuenta - cantidad;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void mostrarCuenta(int nc) {
        switch (nc) {
            case 1 -> {
                tipo = "Ahorros";
                System.out.println("");
                System.out.println("Cta. Nro " + this.nroCuenta + " de " + tipo);
            }
            case 2 -> {
                tipo = "Corriente";
                System.out.println("");
                System.out.println("Cta. Nro " + this.nroCuenta + " de saldo " + tipo);
            }
            case 3 -> {
                tipo = "Poliza";
                System.out.println("");
                System.out.println("Cta. Nro " + this.nroCuenta + " de " + tipo);
            }
        }
    }

    @Override
    public String toString() {
        return "Nro. de cuenta " + this.nroCuenta + " es de tipo " + tipo + " tiene $ " + this.getSaldoCuenta() + " de saldo";
    }

}

package dominio;

import java.util.ArrayList;

public class Cliente {

    private String nombres;
    private String cedula;
    private ArrayList<Cuenta> cuentas;
    private Cuenta cta;

    public Cliente(String nombres, String cedula) {
        cuentas = new ArrayList<>();
        cta = new Cuenta();
        this.nombres = nombres;
        this.cedula = cedula;
    }

    public String getCedula() {
        return cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public void consultarSaldo() {
        System.out.println("El usuario " + this.nombres + " con Nro. de cedula " + this.cedula);
        System.out.println("Tiene como saldo en las siguientes cuentas: ");
        System.out.println("");
        for (Cuenta cta : cuentas) {
            System.out.println(cta);
        }
    }

    public void agreagarCuentas(Cuenta cuentas1) {
        cuentas.add(cuentas1);
        cuentas1.setCliente(this);
    }

}

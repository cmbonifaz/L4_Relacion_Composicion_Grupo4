package test;

import dominio.*;
import java.util.Scanner;

public class TestCliente {

    static Scanner entrada;

    public static void main(String[] args) {
        entrada = new Scanner(System.in);
        Cliente cl = null;
        Cuenta cuenta = null;
        String cedula, nombre = null;

        double dinero = 0;
        int op = 0;
        int nc = 0;

        while (op != 6) {
            op = 0;
            System.out.println("");
            System.out.println("--- Menu de opciones del banco ---");
            System.out.println("1.- Crear cliente");
            System.out.println("2.- Asignar cuenta o cuentas al cliente");
            System.out.println("3.- Depositar");
            System.out.println("4.- Retirar");
            System.out.println("5.- Consultar Saldo");
            System.out.println("6.- Salir");
            System.out.print("Ingrese el numero de la opcion que desea: ");

            while (op < 1 || op > 6) {
                op = entrada.nextInt();
            }
            entrada.nextLine();
            switch (op) {
                case 1 -> {
                    entrada = new Scanner(System.in);
                    if (nombre == null) {
                        System.out.println("");
                        System.out.println("--- Ingrese sus datos personales ---");
                        System.out.println("");
                        System.out.print("Ingrese su nombre: ");

                        nombre = entrada.nextLine();
                        System.out.print("Ingrese su Nro. de Cedula: ");
                        cedula = entrada.nextLine();
                        cl = new Cliente(nombre, cedula);
                    } else {
                        System.out.println("");
                        System.out.println("--- Nota: Ya existe un usuario creado con el nombre de: " + cl.getNombres() + " ---");
                    }
                }
                case 2 -> {
                    if (nombre == null) {
                        System.out.println("");
                        System.out.println("--- Nota: Primero cree un usuario para asignar una cuenta ---");
                    } else {
                        dinero = 0;
                        nc = 0;
                        System.out.println("");
                        System.out.println("--- Elija que tipo de cuenta desea obtener ---");
                        System.out.println("1.- Cta. de Ahorros");
                        System.out.println("2.- Cta. Corriente");
                        System.out.println("3.- Cta. Poliza");
                        System.out.print("Ingrese el numero de la opcion que desea: ");
                        while (nc < 1 || nc > 3) {
                            nc = entrada.nextInt();
                        }
                        System.out.println("");
                        System.out.println("--- Su saldo Inicial de la cuenta es de $0 ---");

                        cuenta = new Cuenta(dinero);
                        cuenta.mostrarCuenta(nc);
                        cl.agreagarCuentas(cuenta);
                    }
                }
                case 3 -> {
                    if (nombre == null || nc == 0) {
                        System.out.println("");
                        System.out.println("--- Nota: Primero cree un usuario y asigne una cuenta para depositar dinero---");
                    } else {
                        dinero = 0;
                        System.out.println("");
                        System.out.println("--- Ingrese el valor a depositar mayor a cero ---");
                        System.out.print("$ ");
                        while (dinero <= 0) {
                            dinero = entrada.nextDouble();
                        }
                        cuenta.depositar(dinero);
                        System.out.println("");
                        System.out.println("El saldo de la cuenta es $ " + cuenta.getSaldoCuenta());
                    }
                }
                case 4 -> {
                    if (nombre == null || nc == 0) {
                        System.out.println("");
                        System.out.println("--- Nota: Primero cree un usuario y asigne una cuenta para retirar dinero ---");
                    } else {
                        dinero = 0;
                        System.out.println("");
                        System.out.println("--- Ingrese el valor a retirar mayor a cero ---");
                        System.out.print("$ ");
                        while (dinero <= 0) {
                            dinero = entrada.nextDouble();
                        }
                        if (dinero <= cuenta.getSaldoCuenta()) {
                            cuenta.retirar(dinero);
                            System.out.println("");
                            System.out.println("El saldo de la cuenta es $ " + cuenta.getSaldoCuenta());
                        } else {
                            System.out.println("");
                            System.out.println("--- Saldo insuficiente para retitrar ---");
                        }
                    }
                }
                case 5 -> {
                    if (nombre == null || nc == 0) {
                        System.out.println("");
                        System.out.println("--- Nota: Primero cree un usuario y asigne una cuenta para ver su saldo ---");
                    } else {
                        System.out.println("");
                        System.out.println("--- Consultando el valor de su cuenta ---");
                        System.out.println("");
                        cl.consultarSaldo();
                    }
                }
                case 6 -> {
                    System.out.println("");
                    System.out.println("--- Saliendo del programa ---");
                    System.out.println("");
                }
            }
        }
    }
}

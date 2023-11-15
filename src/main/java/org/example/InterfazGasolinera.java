package org.example;
import java.util.Scanner;

public class InterfazGasolinera {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestorGasolinera gestor = new GestorGasolinera();

        boolean salir = false;
        while (!salir) {
            System.out.println("Menú de la gasolinera:");
            System.out.println("1. Repostaje normal");
            System.out.println("2. Repostaje factura");
            System.out.println("3. Ver todos los repostajes");
            System.out.println("4. Importe total combustible vendido.");
            System.out.println("5. Llenado de depósito. ");
            System.out.println("6. Eliminar último llenado de depósito. ");
            System.out.println("7. Ver todos los llenados de depósito. ");
            System.out.println("0. Salir");

            System.out.print("Elige una opción: ");
            int opcion = scanner.nextInt();
            //int opcion=1;

            switch (opcion) {
                case 1:
                    RepostajeNormal r = new RepostajeNormal(20);
                    gestor.insertarRepostaje(r);
                    System.out.println("Operacion realizada correctamente");
                    break;
                case 2:
                    RepostajeFactura f = new RepostajeFactura(20,"74392021","342244");
                    gestor.insertarRepostaje(f);
                    System.out.println("Operacion realizada correctamente");
                    break;
                case 3:
                    gestor.verTodosLosRepostajes();
                    System.out.println("Operacion realizada correctamente");
                    break;
                case 4:
                    System.out.println("el importe total es: "+gestor.calcularImporteTotalCombustibleVendido()+" €");
                    break;
                case 5:
                    LlenadoDeposito l = new LlenadoDeposito(90,"diesel",50);
                    gestor.insertarLlenadoDeposito(l);
                    System.out.println("Operacion realizada correctamente");
                    break;
                case 6:
                    gestor.eliminarUltimoLlenadoDeposito();
                    System.out.println("Operacion realizada correctamente");
                    break;
                case 7:
                    gestor.verTodosLosLlenadosDeposito();
                    System.out.println("Operacion realizada correctamente");
                    break;
                case 0:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }

        gestor.cerrar();
        scanner.close();
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;

import java.util.InputMismatchException;
import java.util.Scanner;

public class QWETR {

    public static void main(String[] args) {
        Scanner lea = new Scanner(System.in);
        lea.useDelimiter("\n");

        int opcionMenu = 0;
        double caja =0, cantidadIngresada = 0, isv=0, cantKilosVenta = 0;
        String producto = "";
        double stockAzucar = 0, stockAvena = 0, stockMaiz = 0, stockTrigo = 0;

        while (opcionMenu != 6) {
            try {
                System.out.println(" __________________________________________");
                System.out.println("|                TIENDA JAVA               |");
                System.out.println("|------------------------------------------|");
                System.out.println("|               MENU PRINCIPAL             |");
                System.out.println("|------------------------------------------|");
                System.out.println("| [1] Abrir Caja                           |");
                System.out.println("| [2] Ventas                               |");
                System.out.println("| [3] Compras                              |");
                System.out.println("| [4] Reportes                             |");
                System.out.println("| [5] Cierre de Caja                       |");
                System.out.println("| [6] Salir del Sistema                    |");
                System.out.println("|__________________________________________|");
                System.out.println("");
                System.out.print("Seleccionar la opcion deseada: ");
                opcionMenu = lea.nextInt();

                switch (opcionMenu) {
                    case 1:
                        System.out.println("-------------------------- ABRIR CAJA -----------------------------");

                        while (true) {
                            try {
                                System.out.print("Ingrese la cantidad de dinero que desea guardar en caja: ");
                                cantidadIngresada = lea.nextDouble();
                                if (cantidadIngresada <= 0) {
                                    System.out.println("Error: Ingrese una cantidad valida.");
                                } else {
                                    caja += cantidadIngresada;
                                    System.out.println("Se ha guardado correctamente.");
                                    System.out.println("___________________________________________________________");
                                    System.out.println("                       TIENDA JAVA                         ");
                                    System.out.println("___________________________________________________________");
                                    System.out.println(String.format("%-45s L. %.2f", "Cantidad Guardada:", cantidadIngresada));
                                    System.out.println("-----------------------------------------------------------");
                                    System.out.println(String.format("%-45s L. %.2f", "Cantidad Total:", caja));
                                    System.out.println("-----------------------------------------------------------");
                                    System.out.println("");
                                    System.out.println("Regresando al menu...");
                                    break;
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Error: Ingrese datos numericos.");
                                lea.next();
                            }
                        }
                        break;
                    case 2:
                        System.out.println("\n----------------------- VENTAS ----------------------------");

                        String tipoClienteVenta;
                        char clienteVenta;

                        while (true) {
                            System.out.print("Ingrese el tipo del cliente (A, B o C): ");
                            tipoClienteVenta = lea.next().toUpperCase();

                            if (tipoClienteVenta.equals("A") || tipoClienteVenta.equals("B") || tipoClienteVenta.equals("C")) {
                                clienteVenta = tipoClienteVenta.charAt(0);
                                break;
                            } else {
                                System.out.println("Error: Ingrese una opcion valida (A, B o C).");
                                System.out.println("");
                            }
                        }

                        int codProductoVenta = 0;
                        String facturaVenta = " ",
                         adquirirProducto,
                         porcentDescuento = " ";
                        double precioUniVenta = 0.00;
                        double totalProductoVenta = 0,
                         subtotalVenta = 0,
                         descuento,
                         totalPagarVenta=0;
                       

                        do {
                            System.out.println(" ----------------------------------------------------------------------------");
                            System.out.println("| Codigo                   |  Producto                 | Precio              |");
                            System.out.println("|----------------------------------------------------------------------------|");
                            System.out.println("| 1                        |  Azucar                   |  L. 30.00           |");
                            System.out.println("| 2                        |  Avena                    |  L. 25.00           |");
                            System.out.println("| 3                        |  Trigo                    |  L. 32.00           |");
                            System.out.println("| 4                        |  Maiz                     |  L. 20.00           |");
                            System.out.println(" ----------------------------------------------------------------------------");

                            while (true) {
                                try {
                                    System.out.print("Ingrese el codigo del producto que desea adquirir: ");
                                    codProductoVenta = lea.nextInt();

                                    if (codProductoVenta < 1 || codProductoVenta > 4) {
                                        System.out.println("Error: El codigo que escogio es invalido.");
                                    } else {
                                        break;
                                    }
                                } catch (InputMismatchException e) {
                                    System.out.println("Error: Ingrese un codigo valido (1 - 4).");
                                    lea.next();
                                }
                            }

                            boolean tipoProducto = true;
                            switch (codProductoVenta) {
                                case 1:
                                    producto = "Azucar";
                                    precioUniVenta = 30.00;
                                    if (clienteVenta == 'C') {
                                        System.out.println("Error: Este producto no esta disponible.");
                                        tipoProducto = false;
                                    }
                                    break;
                                case 2:
                                    producto = "Avena";
                                    precioUniVenta = 25.00;
                                    if (clienteVenta == 'C') {
                                        System.out.println("Error: Este producto no esta disponible.");
                                        tipoProducto = false;
                                    }
                                    break;
                                case 3:
                                    producto = "Trigo";
                                    precioUniVenta = 32.00;
                                    if (clienteVenta == 'C') {
                                        System.out.println("Error: Este producto no esta disponible.");
                                        tipoProducto = false;
                                    }
                                    break;
                                case 4:
                                    producto = "Maiz";
                                    precioUniVenta = 20.00;
                                    if (clienteVenta == 'B') {
                                        System.out.println("Error: Este producto no esta disponible.");
                                        tipoProducto = false;
                                    }
                                    break;
                                default:
                                    System.out.println("Error: Esta opcion no existe.");
                                    tipoProducto = false;
                                    break;
                            }

                            if (tipoProducto) {
                                while (true) {
                                    try {
                                        System.out.print("Ingrese la cantidad en kilogramos de " + producto + ": ");
                                        cantKilosVenta = lea.nextDouble();
                                        if (cantKilosVenta <= 0) {
                                            System.out.println("Error: Ingrese una cantidad valida.");
                                            continue;
                                        }

                                        if (codProductoVenta == 1 && stockAzucar >= cantKilosVenta) {
                                            stockAzucar -= cantKilosVenta;
                                        } else if (codProductoVenta == 2 && stockAvena >= cantKilosVenta) {
                                            stockAvena -= cantKilosVenta;
                                        } else if (codProductoVenta == 3 && stockTrigo >= cantKilosVenta) {
                                            stockTrigo -= cantKilosVenta;
                                        } else if (codProductoVenta == 4 && stockMaiz >= cantKilosVenta) {
                                            stockMaiz -= cantKilosVenta;
                                        } else {
                                            System.out.println("Error: No hay suficiente cantidad de productos.");
                                            continue;
                                        }

                                        totalProductoVenta = cantKilosVenta * precioUniVenta;
                                        facturaVenta += String.format("%-15s %-16f %-20f L. %.2f\n", producto, cantKilosVenta, precioUniVenta, totalProductoVenta);
                                        subtotalVenta += totalProductoVenta;
                                        break;
                                    } catch (InputMismatchException e) {
                                        System.out.println("Error: Ingrese una cantidad numerica valida.");
                                        lea.next();
                                    }
                                }
                            }

                            System.out.print("¿Desea comprar otro producto? (SI/NO): ");
                            adquirirProducto = lea.next().toUpperCase();

                        } while (adquirirProducto.equals("SI"));
                        isv = subtotalVenta * 0.07;
                        if (subtotalVenta > 5000) {
                            descuento = subtotalVenta* 0.10;
                            porcentDescuento = "10%";
                        } else if (subtotalVenta >= 1000) {
                            descuento = subtotalVenta * 0.05;
                            porcentDescuento = "05%";
                        } else {
                            descuento = 0;
                            porcentDescuento = "";
                        }

                        totalPagarVenta = (subtotalVenta - descuento) + isv;

                        System.out.println("_________________________________________________________________");
                        System.out.println("                          TIENDA JAVA                           ");
                        System.out.println("                            FACTURA                             ");
                        System.out.println("_________________________________________________________________");
                        System.out.println("Tipo de Cliente: " + clienteVenta);
                        System.out.println("----------------------------------------------------------------");
                        System.out.println("Producto       Cantidad(kg)       Precio Unit.       Total");
                        System.out.println("----------------------------------------------------------------");
                        System.out.println(facturaVenta);
                        System.out.println("----------------------------------------------------------------");
                        System.out.println(String.format("%-50s L. %.2f", "Subtotal:", subtotalVenta));
                        System.out.println(String.format("%-50s L. %.2f", "Descuento: " + porcentDescuento + ":", descuento));
                        System.out.println(String.format("%-50s L. %.2f", "ISV:", isv));
                        System.out.println("----------------------------------------------------------------");
                        System.out.println(String.format("%-50s L. %.2f", "TOTAL A PAGAR:", totalPagarVenta));
                        System.out.println("----------------------------------------------------------------");
                        System.out.println("             GRACIAS POR SU COMPRA. ¡VUELVE PRONTO!             ");
                        System.out.println("________________________________________________________________");
                        break;
                    case 3:
                         System.out.println("\n------------------------- COMPRAS ---------------------------");

                        String tipoProveedor;
                        char proveedor;

                        while (true) {
                            System.out.print("Ingrese el tipo del cliente (A, B o C): ");
                            tipoProveedor = lea.next().toUpperCase();

                            if (tipoProveedor.equals("A") || tipoProveedor.equals("B") || tipoProveedor.equals("C")) {
                                proveedor = tipoProveedor.charAt(0);
                                break;
                            } else {
                                System.out.println("Error: Ingrese una opcion valida (A, B o C).");
                                System.out.println("");
                            }
                        }
                        
                        int codProductoCompra=0;
                        String facturaCompra = " ";
                        double precioUniCompra = 0.00,
                         cantKilosCompra = 0;
                        double totalProductoCompra = 0,
                         subtotalCompra = 0,
                         totalPagarCompra=0;
                       
                        
                            System.out.println(" ------------------------------------------------------");
                            System.out.println("| Codigo                   |  Producto                 |");
                            System.out.println("|------------------------------------------------------");
                            System.out.println("| 1                        |  Azucar                   |");
                            System.out.println("| 2                        |  Avena                    |");
                            System.out.println("| 3                        |  Trigo                    |");
                            System.out.println("| 4                        |  Maiz                     |");
                            System.out.println(" ------------------------------------------------------");

                            while (true) {
                                try {
                                    System.out.print("Ingrese el codigo del producto que desea adquirir: ");
                                    codProductoCompra = lea.nextInt();

                                    if (codProductoCompra < 1 || codProductoCompra > 4) {
                                        System.out.println("Error: El codigo que escogio es invalido.");
                                    } else {
                                        break;
                                    }
                                } catch (InputMismatchException e) {
                                    System.out.println("Error: Ingrese un codigo valido (1 - 4).");
                                    lea.next();
                                }
                            }
                            
                            boolean tipoProducto = true;
                            switch (codProductoCompra) {
                                case 1:
                                    producto = "Azucar";
                                    precioUniCompra = 25.00;
                                    if (proveedor == 'B'||proveedor == 'C') {
                                        System.out.println("Error: Este producto no esta disponible por el proveedor.");
                                        tipoProducto = false;
                                    }
                                    break;
                                case 2:
                                    producto = "Avena";
                                    if (proveedor=='A'){
                                        System.out.println("Este producto no esta disponible.");
                                    }else if (proveedor=='B'){
                                        precioUniCompra = 20.00;
                                        tipoProducto = true;
                                    }else if(proveedor =='C'){
                                        precioUniCompra = 22.00;
                                        tipoProducto = true;
                                    }
                                    break;
                                case 3:
                                    producto = "Trigo";
                                    precioUniCompra = 30.00;
                                    if (proveedor == 'A'|| proveedor== 'C') {
                                        System.out.println("Error: Este producto no esta disponible por el proveedor.");
                                        tipoProducto = false;
                                    }
                                    break;
                                case 4:
                                    producto = "Maiz";
                                    precioUniCompra = 18.00;
                                    if (proveedor == 'B'||proveedor == 'C') {
                                        System.out.println("Error: Este producto no esta disponible por el proveedor.");
                                        tipoProducto = false;
                                    }
                                    break;
                                default:
                                    System.out.println("Error: Esta opcion no existe.");
                                    tipoProducto = false;
                                    break;
                            }
                            
                             if (tipoProducto) {
                                while (true) {
                                    try {
                                        System.out.print("Ingrese la cantidad en kilogramos de " + producto + " a comprar : ");
                                        cantKilosCompra = lea.nextDouble();
                                        if (cantKilosCompra <= 0) {
                                            System.out.println("Error: Ingrese una cantidad valida.");
                                            continue;
                                        }

                                        totalProductoCompra = cantKilosCompra * precioUniCompra;
                                        
                                        if (caja>=totalProductoCompra){
                                            facturaCompra += String.format("%-15s %-16f %-20f L. %.2f\n", producto, cantKilosCompra, precioUniCompra, totalProductoCompra);
                                            subtotalCompra += totalProductoCompra;
                                            isv = subtotalCompra * 0.07;
                                            totalPagarCompra = subtotalCompra + isv;

                                            System.out.println("_________________________________________________________________");
                                            System.out.println("                          TIENDA JAVA                           ");
                                            System.out.println("                            FACTURA                             ");
                                            System.out.println("_________________________________________________________________");
                                            System.out.println("Tipo de Cliente: " + proveedor);
                                            System.out.println("----------------------------------------------------------------");
                                            System.out.println("Producto       Cantidad(kg)       Precio Unit.       Total");
                                            System.out.println("----------------------------------------------------------------");
                                            System.out.println(facturaCompra);
                                            System.out.println("----------------------------------------------------------------");
                                            System.out.println(String.format("%-50s L. %.2f", "Subtotal:", subtotalCompra));
                                            System.out.println(String.format("%-50s L. %.2f", "ISV:", isv));
                                            System.out.println("----------------------------------------------------------------");
                                            System.out.println(String.format("%-50s L. %.2f", "TOTAL A PAGAR:", totalPagarCompra));
                                            System.out.println("----------------------------------------------------------------");
                                            System.out.println("             GRACIAS POR SU COMPRA. ¡VUELVE PRONTO!             ");
                                            System.out.println("________________________________________________________________");   
                                            
                                            caja -= totalPagarCompra;
                                        }else{
                                            System.out.println("Error: No se puede realizar la compra, saldo insuficiente.");
                                        }     
                                        break;
                                    } catch (InputMismatchException e) {
                                        System.out.println("Error: Ingrese una cantidad numerica valida.");
                                        lea.next();
                                    }
                                }
                            }
                             
                        
                        
                        
                    case 6:
                        System.out.println("Saliendo del sistema...");
                        return;

                    default:
                        System.out.println("Error: Opcion invalida. Ingrese una opcion del (1 - 6).");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Ingrese una opcion numerica valida.");
                lea.next();
            }
        }
    }
}

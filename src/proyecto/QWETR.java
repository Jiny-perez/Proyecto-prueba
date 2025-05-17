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
        
        int opcionMenu=0;
        double cantidadTotal = 0, cantidadIngresada = 0;
        
        while(true){
            try{           
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
                    System.out.println("------------------------------- ABRIR CAJA ---------------------------------");
                            
                    while (true) {
                        try {
                            System.out.print("Ingrese la cantidad de dinero que desea guardar en caja: ");
                            cantidadIngresada = lea.nextDouble();
                            if (cantidadIngresada <= 0) {
                                System.out.println("Error: Ingrese una cantidad valida.");
                            } else {
                                cantidadTotal += cantidadIngresada;
                                System.out.println("Se ha guardado correctamente.");
                                System.out.println("___________________________________________________________");
                                System.out.println("                       TIENDA JAVA                         ");
                                System.out.println("___________________________________________________________");
                                System.out.println(String.format("%-45s L. %.2f", "Cantidad Guardada:", cantidadIngresada));
                                System.out.println("-----------------------------------------------------------");
                                System.out.println(String.format("%-45s L. %.2f", "Cantidad Total:", cantidadTotal));
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
                    System.out.println("\n-------------------------------- VENTAS ------------------------------------");
                    
                    String tipoClienteVenta;
                    char clienteVenta;
                    
                    while (true) {
                        System.out.print("Ingrese el tipo del cliente (A, B o C): ");
                        tipoClienteVenta = lea.next().toUpperCase();

                        if (tipoClienteVenta.equals("A") || tipoClienteVenta.equals("B") || tipoClienteVenta.equals("C")) {
                            clienteVenta=tipoClienteVenta.charAt(0);
                            break; 
                        } else {
                            System.out.println("Error: Ingrese una opcion valida (A, B o C).");
                            System.out.println("");
                        }
                    }
                    
                    int codProductoVenta=0;
                    String producto="", factura=" ", adquirirVenta, porcentDescuento=" ";
                    double precioUni=0.00, cantKilos=0;
                    double totalProducto=0, subtotal=0, isv, descuento, totalPagar;
                    double stockAzucar = 3, stockAvena = 3, stockMaiz = 3, stockTrigo = 3;
                   
                    do{   
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
                    
                    boolean tipoProducto=true;
                    switch (codProductoVenta) {         
                        case 1:
                            producto = "Azucar";
                            precioUni = 30.00;
                            if (clienteVenta == 'C') {
                                System.out.println("Error: Este producto no esta disponible.");
                                tipoProducto=false;
                            }
                            break;
                        case 2:
                            producto = "Avena";
                            precioUni = 25.00;
                            if (clienteVenta == 'C') {
                                System.out.println("Error: Este producto no esta disponible.");
                                tipoProducto=false;
                            }
                            break;
                        case 3:
                            producto = "Trigo";
                            precioUni = 32.00;
                            if (clienteVenta == 'C') {
                                System.out.println("Error: Este producto no esta disponible.");
                                tipoProducto=false;
                            }
                            break;
                        case 4:
                            producto = "Maiz";
                            precioUni = 20.00;
                            if (clienteVenta == 'B') {
                                System.out.println("Error: Este producto no esta disponible.");
                                tipoProducto=false;
                            }
                            break;
                        default:
                            System.out.println("Error: Esta opcion no existe.");
                            tipoProducto=false;
                            break;
                    }
                    
                    if (tipoProducto) {   
                    while (true) {
                        try {
                            System.out.print("Ingrese la cantidad en kilogramos de " + producto + ": ");
                            cantKilos = lea.nextDouble();
                            if (cantKilos <= 0) {
                                System.out.println("Error: Ingrese una cantidad valida.");
                                continue;
                            }

                            if (codProductoVenta == 1 && stockAzucar >= cantKilos) {
                                stockAzucar -= cantKilos;
                            } else if (codProductoVenta == 2 && stockAvena >= cantKilos) {
                                stockAvena -= cantKilos;
                            } else if (codProductoVenta == 3 && stockTrigo >= cantKilos) {
                                stockTrigo -= cantKilos;
                            } else if (codProductoVenta == 4 && stockMaiz >= cantKilos) {
                                stockMaiz -= cantKilos;
                            } else {
                                System.out.println("Error: No hay suficiente cantidad de productos.");
                                continue;
                            }
                            
                            totalProducto = cantKilos * precioUni;
                            factura += String.format("%-15s %-16f %-20f L. %.2f\n", producto, cantKilos, precioUni, totalProducto);
                            subtotal += totalProducto;
                            break;
                            } catch (InputMismatchException e) {
                                System.out.println("Error: Ingrese una cantidad numerica valida.");
                                lea.next();
                            }
                        }
                    }
                    
                    System.out.print("¿Desea comprar otro producto? (SI/NO): ");
                    adquirirVenta = lea.next().toUpperCase();   

                    } while (adquirirVenta.equals("SI"));       
                        isv = subtotal * 0.07;
                        if (subtotal > 5000) {
                            descuento = subtotal * 0.10;
                            porcentDescuento = "10%";
                        } else if (subtotal >= 1000) {
                            descuento = subtotal * 0.05;
                            porcentDescuento = "05%";
                        } else {
                            descuento = 0;
                            porcentDescuento = "";
                        }

                        totalPagar = (subtotal - descuento) + isv;
                        
                        System.out.println("_________________________________________________________________");
                        System.out.println("                          TIENDA JAVA                           ");
                        System.out.println("                            FACTURA                             ");
                        System.out.println("_________________________________________________________________");
                        System.out.println("Tipo de Cliente: " + clienteVenta);
                        System.out.println("----------------------------------------------------------------");
                        System.out.println("Producto       Cantidad(kg)       Precio Unit.       Total");
                        System.out.println("----------------------------------------------------------------");
                        System.out.println(factura);
                        System.out.println("----------------------------------------------------------------");
                        System.out.println(String.format("%-50s L. %.2f", "Subtotal:", subtotal));
                        System.out.println(String.format("%-50s L. %.2f", "Descuento: " + porcentDescuento + ":", descuento));
                        System.out.println(String.format("%-50s L. %.2f", "ISV:", isv));
                        System.out.println("----------------------------------------------------------------");
                        System.out.println(String.format("%-50s L. %.2f", "TOTAL A PAGAR:", totalPagar));
                        System.out.println("----------------------------------------------------------------");
                        System.out.println("             GRACIAS POR SU COMPRA. ¡VUELVE PRONTO!             ");
                        System.out.println("________________________________________________________________");
                        break;
                case 6:
                        System.out.println("Saliendo del sistema...");
                        return;

                    default:
                        System.out.println("Error: Opcion invalida. Ingrese una opcion del (1 - 6).");
            }
            }catch (InputMismatchException e) {
                System.out.println("Error: Ingrese una opcion numerica valida.");
                lea.next();
            }
        }
    }
}




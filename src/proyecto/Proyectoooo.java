/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;
import java.util.InputMismatchException;
import java.util.Scanner;

public class  Proyectoooo {
    public static void main(String[] args) {
        Scanner lea = new Scanner(System.in);
        lea.useDelimiter("\n");

        double cantidadTotal = 0, cantidadIngresada = 0, precioUni = 0, cantKilos = 0, totalProducto = 0, subtotal = 0;
        double stockAzucar = 3, stockAvena = 3, stockMaiz = 3, stockTrigo = 3;
        double isv, descuento, totalPagar;
        String factura = "", porcent_dsct = "", producto="", tipoClienteVenta="", tipoClienteCompra="";
        char clienteVenta, clienteCompra;
        int codProductoVenta = 0, codProductoCompra=0, opcion = 0;

        while (true) {
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
            opcion = lea.nextInt();

                switch (opcion) {
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
                                    System.out.println("Cantidad Guardada: " + cantidadIngresada);
                                    System.out.println("Total en caja: " + cantidadTotal);
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
                        while (true) {
                            System.out.print("Ingrese el tipo del cliente (A/B/C): ");
                            tipoClienteVenta = lea.next().toUpperCase();
                           if (tipoClienteVenta.length() == 1 && (tipoClienteVenta.charAt(0) == 'A' || tipoClienteVenta.charAt(0) == 'B' || tipoClienteVenta.charAt(0) == 'C')) {
                           clienteVenta = tipoClienteVenta.charAt(0);
                           break;
                            } else {
                                System.out.println("Error: Ingrese una opcion valida.");
                            }
                        }

                        String adquirirVenta;
                        do {
                            System.out.println(" ____________________________________________________________________________");
                            System.out.println("| Código                   |  Producto                 | Precio              |");
                            System.out.println("|----------------------------------------------------------------------------|");
                            System.out.println("| 1                        |  Azúcar                   |  30 Lempiras        |");
                            System.out.println("| 2                        |  Avena                    |  25 Lempiras        |");
                            System.out.println("| 3                        |  Trigo                    |  32 Lempiras        |");
                            System.out.println("| 4                        |  Maíz                     |  20 Lempiras        |");
                            System.out.println("|____________________________________________________________________________|");

                            while (true) {
                                try {
                                    System.out.print("Ingrese el codigo del producto que desea adquirir: ");
                                    codProductoVenta= lea.nextInt();
                                    if (codProductoVenta < 1 || codProductoVenta > 4) {
                                        System.out.println("El código que escogió es inválido.");
                                        continue;
                                    }
                                    break;
                                } catch (InputMismatchException e) {
                                    System.out.println("Error: Ingrese un código válido (1-4).");
                                    lea.next();
                                }
                            }
                            
                            boolean tipoProducto=true;
                            switch (codProductoVenta) {
                                case 1:
                                    producto = "Azucar";
                                    precioUni = 30.00;
                                    if (clienteVenta=='C'){
                                        System.out.println("Error: Este producto no esta disponible.");
                                        tipoProducto=false;
                                    }
                                    break;
                                case 2:
                                    producto = "Avena";
                                    precioUni = 25.00;
                                    if (clienteVenta=='C'){
                                        System.out.println("Error: Este producto no esta disponible.");
                                        tipoProducto=false;
                                    }
                                    break;
                                case 3:
                                    producto = "Trigo";
                                    precioUni = 32.00;
                                    if (clienteVenta=='C'){
                                        System.out.println("Error: Este producto no esta disponible.");
                                        tipoProducto=false;
                                    }
                                    break;
                                case 4:
                                    producto = "Maíz";
                                    precioUni = 20.00;
                                    if (clienteVenta=='B'){
                                        System.out.println("Error: Este producto no esta disponible.");
                                        tipoProducto=false;
                                    }
                                    break;
                                default:
                                    System.out.println("Error: Este codigo que escogio es invalido.");
                                    tipoProducto=false;
                                    break;
                            }
                            
                            if (tipoProducto) {     
                                while (true) {
                                        try {
                                         System.out.print("Ingrese la cantidad en kilogramos de " + producto + ": ");
                                         cantKilos = lea.nextDouble();
                                        if (cantKilos <= 0) {
                                            System.out.println("Error: Ingrese una cantidad válida.");
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
                                            System.out.println("No hay suficiente cantidad de productos.");
                                            break;
                                        }

                                        totalProducto = cantKilos * precioUni;
                                        factura += String.format("%-15s %-15.2f %-17.2f L. %.2f\n", producto, cantKilos, precioUni, totalProducto);
                                        subtotal += totalProducto;
                                        break;

                                    } catch (InputMismatchException e) {
                                        System.out.println("Error: Ingrese una cantidad numérica válida.");
                                        lea.next();
                                    }
                                }
                            }

                        System.out.print("¿Desea comprar otro producto? (SI/NO): ");
                        adquirirVenta = lea.next();

                        } while (adquirirVenta.equalsIgnoreCase("si"));

                        isv = subtotal * 0.07;
                        if (subtotal > 5000) {
                            descuento = subtotal * 0.10;
                            porcent_dsct = "10%";
                        } else if (subtotal >= 1000) {
                            descuento = subtotal * 0.05;
                            porcent_dsct = "05%";
                        } else {
                            descuento = 0;
                            porcent_dsct = "";
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
                        System.out.println(String.format("%-50s L. %.2f", "Descuento: " + porcent_dsct + ":", descuento));
                        System.out.println(String.format("%-50s L. %.2f", "ISV:", isv));
                        System.out.println("----------------------------------------------------------------");
                        System.out.println(String.format("%-50s L. %.2f", "TOTAL A PAGAR:", totalPagar));
                        System.out.println("----------------------------------------------------------------");
                        System.out.println("             GRACIAS POR SU COMPRA. ¡VUELVE PRONTO!             ");
                        System.out.println("________________________________________________________________");
                        cantidadIngresada += totalPagar;
                        System.out.println("Stock azucar: "+stockAzucar);
                        break;
                        
                    case 3:
                        System.out.println("-¿------------------------------- COMPRAS ---------------------------------");
                        while (true) {
                           System.out.print("Ingrese el tipo del cliente (A/B/C): ");
                           tipoClienteCompra = lea.next().toUpperCase();
                           if (tipoClienteCompra.length() == 1 && (tipoClienteCompra.charAt(0) == 'A' || tipoClienteCompra.charAt(0) == 'B' || tipoClienteCompra.charAt(0) == 'C')) {
                           clienteCompra = tipoClienteCompra.charAt(0);
                           break;
                            } else {
                                System.out.println("Error: Ingrese una opcion valida.");
                            }
                        }
                        
                        String adquirirCompra;
                        do {
                            System.out.println(" _______________________________________________________");
                            System.out.println("| Código                   |  Producto                  |");
                            System.out.println("|-------------------------------------------------------|");
                            System.out.println("| 1                        |  Azúcar                    |");
                            System.out.println("| 2                        |  Avena                     |");
                            System.out.println("| 3                        |  Trigo                     |");
                            System.out.println("| 4                        |  Maíz                      |");
                            System.out.println("|_______________________________________________________|");

                            while (true) {
                                try {
                                    System.out.print("Ingrese el codigo del producto que desea adquirir: ");
                                    codProductoCompra = lea.nextInt();
                                    if (codProductoCompra < 1 || codProductoCompra > 4) {
                                        System.out.println("El código que escogió es inválido.");
                                        continue;
                                    }
                                    break;
                                } catch (InputMismatchException e) {
                                    System.out.println("Error: Ingrese un código válido (1-4).");
                                    lea.next();
                                }
                            }

                            switch (codProductoCompra) {
                                case 1:
                                     if (clienteCompra=='B'||clienteCompra=='C'){
                                        System.out.println("Este producto no esta disponible.");
                                    }else{
                                        producto = "Azucar";
                                        precioUni = 25.00;
                                     }
                                    break;
                                case 2:
                                    if (clienteCompra=='A'){
                                        System.out.println("Este producto no esta disponible.");
                                    }else if (clienteCompra=='B'){
                                        producto = "Avena";
                                        precioUni = 20.00;
                                    }else if(clienteCompra=='C'){
                                        producto = "Avena";
                                        precioUni = 22.00;
                                    }
                                    break;
                                case 3:
                                    if (clienteCompra=='A'||clienteCompra=='C'){
                                        System.out.println("Este producto no esta disponible.");
                                    }else{
                                        producto = "Trigo";
                                        precioUni = 32.00;
                                    }
                                    break;
                                case 4:
                                    if (clienteCompra=='B'||clienteCompra=='C'){
                                        System.out.println("Este producto no esta disponible.");
                                    }else{
                                        producto = "Maíz";
                                        precioUni = 30.00;
                                    }
                                    break;
                                default:
                                    System.out.println("Esta opcion no existe");
                                    break;
                            }
                            
                            if (producto.equals("")) {     
                            } else {
                                while (true) {
                                        try {
                                         System.out.print("Ingrese la cantidad en kilogramos de " + producto + ": ");
                                         cantKilos = lea.nextDouble();
                                        if (cantKilos <= 0) {
                                            System.out.println("Error: Ingrese una cantidad válida.");
                                            continue;
                                        }

                                        if (codProductoCompra == 1 && stockAzucar >= cantKilos) {
                                            stockAzucar -= cantKilos;
                                        } else if (codProductoCompra == 2 && stockAvena >= cantKilos) {
                                            stockAvena -= cantKilos;
                                        } else if (codProductoCompra == 3 && stockTrigo >= cantKilos) {
                                            stockTrigo -= cantKilos;
                                        } else if (codProductoCompra == 4 && stockMaiz >= cantKilos) {
                                            stockMaiz -= cantKilos;
                                        } else {
                                            System.out.println("No hay suficiente cantidad de productos.");
                                            break;
                                        }

                                        totalProducto = cantKilos * precioUni;
                                        factura += String.format("%-15s %-15.2f %-17.2f L. %.2f\n", producto, cantKilos, precioUni, totalProducto);
                                        subtotal += totalProducto;
                                        break;

                                    } catch (InputMismatchException e) {
                                        System.out.println("Error: Ingrese una cantidad numérica válida.");
                                        lea.next();
                                    }
                                }
                            }

                        System.out.print("¿Desea comprar otro producto? (SI/NO): ");
                        adquirirCompra = lea.next();

                        } while (adquirirCompra.equalsIgnoreCase("si"));

                        isv = subtotal * 0.07;
                        totalPagar = subtotal  + isv;

                        System.out.println("_________________________________________________________________");
                        System.out.println("                          TIENDA JAVA                           ");
                        System.out.println("                            FACTURA                             ");
                        System.out.println("_________________________________________________________________");
                        System.out.println("Tipo de Cliente: " + clienteCompra);
                        System.out.println("----------------------------------------------------------------");
                        System.out.println("Producto       Cantidad(kg)       Precio Unit.       Total");
                        System.out.println("----------------------------------------------------------------");
                        System.out.println(factura);
                        System.out.println("----------------------------------------------------------------");
                        System.out.println(String.format("%-50s L. %.2f", "Subtotal:", subtotal));
                        System.out.println(String.format("%-50s L. %.2f", "ISV:", isv));
                        System.out.println("----------------------------------------------------------------");
                        System.out.println(String.format("%-50s L. %.2f", "TOTAL A PAGAR:", totalPagar));
                        System.out.println("----------------------------------------------------------------");
                        System.out.println("             GRACIAS POR SU COMPRA. ¡VUELVE PRONTO!             ");
                        System.out.println("________________________________________________________________");
                        cantidadIngresada += totalPagar;
                        System.out.println("Stock azucar: "+stockAzucar);
                        break;
                        
                        

                    case 6:
                        System.out.println("Saliendo del sistema. ¡Hasta luego!");
                        return;

                    default:
                        System.out.println("Error: Opción inválida. Ingrese una opcion del (1-6).");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Ingrese una opción numérica válida.");
                lea.next();
            }
        }
    }
}




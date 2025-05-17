/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;
import java.util.Scanner;

public class Perez_Jiny_ProyectoTienda {

    public static void main(String[] args) {
        Scanner lea = new Scanner (System.in);
        lea.useDelimiter ("\n");
        
        double caja=0, cant_kilos=0 , total_producto=0, subtotal=0, descuento=0, isv, total_pagar;
        int opcion=0, cod_producto;
        String factura="", porcent_dsct="0%"; 
        
        while (opcion != 6){
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
        
        
        switch (opcion){
            case 1:
                System.out.println("");
                System.out.println("------------------------------- ABRIR CAJA ---------------------------------");
                System.out.print("Ingrese la cantidad de dinero que desea guardar en caja (0 para cancelar): ");
                caja = lea.nextDouble();
                
                if (caja>0){
                    System.out.println("Se ha guardado correctamente en caja.");
                } else {
                    System.out.println("Regresando al menu...");
                }
                break;
            case 2:
                System.out.println("");
                System.out.println("-------------------------------- VENTAS ------------------------------------");
                System.out.print("Ingrese el tipo del cliente (A/B/C): ");
                char tipo_cliente = Character.toUpperCase(lea.next().charAt(0));
                
                String respuesta = "SI";
                while(respuesta.equals("SI")){
                System.out.println(" ____________________________________________________________________________");
                System.out.println("| Código                   |  Producto                 | Precio              |");
                System.out.println("|----------------------------------------------------------------------------|");
                System.out.println("| 1                        |  Azúcar                   |  30 Lempiras        |");
                System.out.println("| 2                        |  Avena                    |  25 Lempiras        |");
                System.out.println("| 3                        |  Trigo                    |  32 Lempiras        |");
                System.out.println("| 4                        |  Maíz                     |  20 Lempiras        |");
                System.out.println("|____________________________________________________________________________|");
                
                switch (tipo_cliente){
                    case 'A':
                        System.out.println("");
                        System.out.print("Ingrese el codigo del producto que desea adquirir: ");
                        cod_producto = lea.nextInt();
                        
                         if (cod_producto == 1){
                         System.out.println("Producto: Azúcar, Precio: 30 LPS. ");
                         System.out.print("Ingrese la contidad en kilogramos de Azúcar: ");
                         cant_kilos = lea.nextDouble();
                         total_producto =  cant_kilos * 30;
                         factura += "Producto: Azúcar - Cantidad: " + cant_kilos + " kg - Precio unitario: 30 LPS\n";
                         }else if ( cod_producto == 2){
                         System.out.println("Producto: Avena, Precio: 25 LPS.");
                         System.out.print("Ingrese la contidad en kilogramos de Avena: ");
                         cant_kilos = lea.nextDouble();
                         total_producto =  cant_kilos * 25;
                         factura += "Producto: Avena - Cantidad: " + cant_kilos + " kg - Precio unitario: 25 LPS\n";
                         }else if (cod_producto == 3){
                         System.out.println("Producto: Trigo, Precio: 32 LPS.");
                         System.out.print("Ingrese la contidad en kilogramos de Trigo: ");
                         cant_kilos = lea.nextDouble();
                         total_producto =  cant_kilos * 32;
                         factura += "Producto: Trigo - Cantidad: " + cant_kilos + " kg - Precio unitario: 32 LPS\n";
                         }else if (cod_producto == 4){
                         System.out.println("Producto: Maiz, Precio: 20 LPS.");   
                         System.out.print("Ingrese la contidad en kilogramos de Maiz: ");
                         cant_kilos = lea.nextDouble();
                         total_producto =  cant_kilos * 20;
                         factura += "Producto: Maiz - Cantidad: " + cant_kilos + " kg - Precio unitario: 20 LPS\n";
                         }else{
                         System.out.println("El codigo que escogio es invalido.");
                         }
                         
                         subtotal += total_producto;
                         isv = subtotal * 0.07;
                         
                         if (subtotal>5000){
                             descuento = subtotal * 0.10;
                             porcent_dsct = "10%";
                         }else if (subtotal>= 1000){
                             descuento = subtotal * 0.05;
                             porcent_dsct = "05%";     
                         }else{
                             descuento = 0;
                             porcent_dsct = "";
  
                         }
                         
                         total_pagar = (subtotal-descuento)+isv;
                         System.out.print("¿Desea comprar otro producto? (SI/NO): ");
                         respuesta = lea.next().toUpperCase();
                          
                         if (respuesta.equals ("NO")){
                             System.out.println("");
                             System.out.println("----------------------------------------------------------------");
                             System.out.println("                         F A C T U R A       ");
                             System.out.println("----------------------------------------------------------------");
                             System.out.println(factura);
                             System.out.println("----------------------------------------------------------------");
                             System.out.println(String.format("%-50s L. %.2f", "Subtotal:",subtotal));
                             System.out.println(String.format("%-50s L. %.2f", "Descuento:" + porcent_dsct+":",descuento));
                             System.out.println(String.format("%-50s L. %.2f", "ISV:",isv));
                             System.out.println(String.format("%-50s L. %.2f", "Total:", total_pagar));
                             System.out.println("----------------------------------------------------------------");
                             caja += total_pagar;
                         }
                     break;    
                         
                    case 'B':
                        System.out.println("");
                                               System.out.println("");
                        System.out.print("Ingrese el codigo del producto que desea adquirir: ");
                        cod_producto = lea.nextInt();
                        
                         if (cod_producto == 1){
                         System.out.println("Producto: Azúcar, Precio: 30 LPS. ");
                         System.out.print("Ingrese la contidad en kilogramos de Azúcar: ");
                         cant_kilos = lea.nextDouble();
                         total_producto =  cant_kilos * 30;
                         factura += "Producto: Azúcar - Cantidad: " + cant_kilos + " kg - Precio unitario: 30 LPS\n";
                         }else if ( cod_producto == 2){
                         System.out.println("Producto: Avena, Precio: 25 LPS.");
                         System.out.print("Ingrese la contidad en kilogramos de Avena: ");
                         cant_kilos = lea.nextDouble();
                         total_producto =  cant_kilos * 25;
                         factura += "Producto: Avena - Cantidad: " + cant_kilos + " kg - Precio unitario: 25 LPS\n";
                         }else if (cod_producto == 3){
                         System.out.println("Producto: Trigo, Precio: 32 LPS.");
                         System.out.print("Ingrese la contidad en kilogramos de Trigo: ");
                         cant_kilos = lea.nextDouble();
                         total_producto =  cant_kilos * 32;
                         factura += "Producto: Trigo - Cantidad: " + cant_kilos + " kg - Precio unitario: 32 LPS\n";
                         }else if (cod_producto == 4){
                         System.out.println("No puede comprar este producto.");
                         }else{
                         System.out.println("No puede comprar dicho producto.");
                         }
                         
                         subtotal += total_producto;
                         isv = subtotal * 0.07;
                         
                         if (subtotal>5000){
                             descuento = subtotal * 0.10;
                             porcent_dsct = "10%";
                         }else if (subtotal>= 1000){
                             descuento = subtotal * 0.05;
                             porcent_dsct = "05%";     
                         }else{
                             descuento = 0;
                             porcent_dsct = "";
  
                         }
                         
                         total_pagar = (subtotal-descuento)+isv;
                         System.out.print("¿Desea comprar otro producto? (SI/NO): ");
                         respuesta = lea.next().toUpperCase();
                          
                         if (respuesta.equals ("NO")){
                             System.out.println("");
                             System.out.println("----------------------------------------------------------------");
                             System.out.println("                         F A C T U R A       ");
                             System.out.println("----------------------------------------------------------------");
                             System.out.println(factura);
                             System.out.println("----------------------------------------------------------------");
                             System.out.println(String.format("%-50s L. %.2f", "Subtotal:",subtotal));
                             System.out.println(String.format("%-50s L. %.2f", "Descuento:" + porcent_dsct+":",descuento));
                             System.out.println(String.format("%-50s L. %.2f", "ISV:",isv));
                             System.out.println(String.format("%-50s L. %.2f", "Total:", total_pagar));
                             System.out.println("----------------------------------------------------------------");
                             caja += total_pagar;
                         }
                         break;
                         
                        case 'C':
                        System.out.println("");
                                               System.out.println("");
                        System.out.print("Ingrese el codigo del producto que desea adquirir: ");
                        cod_producto = lea.nextInt();
                        
                        if (cod_producto >= 1 && cod_producto <= 3){
                         System.out.println("No puede comprar este producto");  
                        }else if (cod_producto == 4){
                         System.out.println("Producto: Maiz, Precio: 20 LPS.");   
                         System.out.print("Ingrese la contidad en kilogramos de Maiz: ");
                         cant_kilos = lea.nextDouble();
                         total_producto =  cant_kilos * 20;
                         factura += "Producto: Maiz - Cantidad: " + cant_kilos + " kg - Precio unitario: 20 LPS\n";
                         }else{
                         System.out.println("El codigo que escogio es invalido.");
                         }
                         
                         subtotal += total_producto;
                         isv = subtotal * 0.07;
                         
                         if (subtotal>5000){
                             descuento = subtotal * 0.10;
                             porcent_dsct = "10%";
                         }else if (subtotal>= 1000){
                             descuento = subtotal * 0.05;
                             porcent_dsct = "05%";     
                         }else{
                             descuento = 0;
                             porcent_dsct = "";
  
                         }
                         
                         total_pagar = (subtotal-descuento)+isv;
                         System.out.print("¿Desea comprar otro producto? (SI/NO): ");
                         respuesta = lea.next().toUpperCase();
                          
                         if (respuesta.equals ("NO")){
                             System.out.println("");
                             System.out.println("----------------------------------------------------------------");
                             System.out.println("                         F A C T U R A       ");
                             System.out.println("----------------------------------------------------------------");
                             System.out.println(factura);
                             System.out.println("----------------------------------------------------------------");
                             System.out.println(String.format("%-50s L. %.2f", "Subtotal:",subtotal));
                             System.out.println(String.format("%-50s L. %.2f", "Descuento:" + porcent_dsct+":",descuento));
                             System.out.println(String.format("%-50s L. %.2f", "ISV:",isv));
                             System.out.println(String.format("%-50s L. %.2f", "Total:", total_pagar));
                             System.out.println("----------------------------------------------------------------");
                             caja += total_pagar;
                         }
                         break;
                        
                     }
                 }
             }
         }
     } 
}
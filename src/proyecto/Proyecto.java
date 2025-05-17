package proyecto;
import java.util.Scanner;
import java.util.InputMismatchException;
public class Proyecto{

    public static void main(String[] args) {
        Scanner lea = new Scanner (System.in);
        lea.useDelimiter ("\n");
        
        double cantidadIngresada=0, cantidadTotal=0, stock=0, cantKilos=0 , totalProducto=0, subtotal=0, descuento=0, isv, totalPagar, precioUni;
        int opcion=0, codProducto;
        String factura="", porcent_dsct="", producto=""; 
        char tipoCliente;
        
        while (opcion != 6){
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
        
        
        switch (opcion){
            case 1:
                System.out.println("");
                System.out.println("------------------------------- ABRIR CAJA ---------------------------------");
                
                while (true){
                    try{ 
                        System.out.print("Ingrese la cantidad de dinero que desea guardar en caja: ");
                        cantidadIngresada = lea.nextDouble();
                    }catch (InputMismatchException e){
                        System.out.println("Error: Ingrese datos numericos.");
                        lea.next();
                        continue;
                    }
                    if (cantidadIngresada<=0){
                        System.out.println("Error: Ingrese una cantidad valida.");
                    } else {
                        cantidadTotal += cantidadIngresada;
                        System.out.println("Se ha guardado correctamente.");
                        System.out.println("Cantidad Guardada: "+cantidadIngresada);
                        System.out.println("Total en caja: "+cantidadTotal);
                        System.out.println("");
                        System.out.println("Regresando al menú..");
                     break;
                    }
                }
            break;
            case 2:
                System.out.println("");
                System.out.println("-------------------------------- VENTAS ------------------------------------");
                
                System.out.print("Ingrese el tipo del cliente (A/B/C): ");
                tipoCliente = Character.toUpperCase(lea.next().charAt(0));
                
                while (tipoCliente !='A' && tipoCliente !='B' && tipoCliente !='C'){
                    System.out.println("Error: Ingrese una opcion valida.");
                    System.out.println("");
                    System.out.print("Ingrese el tipo del cliente (A/B/C): ");
                    tipoCliente = Character.toUpperCase(lea.next().charAt(0));
                }
                
                String respuesta = "";
                do{
                    
                System.out.println(" ____________________________________________________________________________");
                System.out.println("| Código                   |  Producto                 | Precio              |");
                System.out.println("|----------------------------------------------------------------------------|");
                System.out.println("| 1                        |  Azúcar                   |  30 Lempiras        |");
                System.out.println("| 2                        |  Avena                    |  25 Lempiras        |");
                System.out.println("| 3                        |  Trigo                    |  32 Lempiras        |");
                System.out.println("| 4                        |  Maíz                     |  20 Lempiras        |");
                System.out.println("|____________________________________________________________________________|");
                System.out.print("Ingrese el codigo del producto que desea adquirir: ");
                codProducto = lea.nextInt();
                
                
                 subtotal += totalProducto;
                 isv = subtotal * 0.07;
                         
                 if (subtotal>5000){
                 descuento = subtotal * 0.10;
                 porcent_dsct = "10%";
                 }else if (subtotal>=1000){
                 descuento=subtotal*0.05;
                 porcent_dsct="05%";     
                 }else{
                 descuento=0;
                 porcent_dsct="";
                 }
                 
                 totalPagar=(subtotal-descuento)+isv;
                 System.out.print("¿Desea comprar otro producto? (SI/NO): ");
                 respuesta = lea.next();
                          
                 if (respuesta.equalsIgnoreCase("No")){
                 System.out.println("");
                 System.out.println("_________________________________________________________________");
                 System.out.println("                          TIENDA JAVA                           ");
                 System.out.println("                            FACTURA                             ");
                 System.out.println("_________________________________________________________________");
                 System.out.println("Tipo de Cliente: "+tipoCliente);
                 System.out.println("----------------------------------------------------------------");
                 System.out.println("Producto       Cantidad(kg)       Precio Unit.       Total");
                 System.out.println("----------------------------------------------------------------");
                 System.out.println(factura);
                 System.out.println("----------------------------------------------------------------");
                 System.out.println(String.format("%-50s L. %.2f", "Subtotal:",subtotal));
                 System.out.println(String.format("%-50s L. %.2f", "Descuento:" + porcent_dsct+":",descuento));
                 System.out.println(String.format("%-50s L. %.2f", "ISV:",isv));
                 System.out.println("----------------------------------------------------------------");
                 System.out.println(String.format("%-50s L. %.2f", "TOTAL A PAGAR:", totalPagar));
                 System.out.println("----------------------------------------------------------------");
                 System.out.println("             GRACIAS POR SU COMPRA. ¡VUELVE PRONTO!             ");
                 System.out.println("________________________________________________________________");
                 cantidadIngresada += totalPagar;
                 break;
            }
        }while(respuesta.equalsIgnoreCase("si"));
        break;    
             }
         }catch (InputMismatchException e){
             
         System.out.println("Error: Ingrese datos numericos.");
         lea.next();
         continue;           
        }
        }
     }
}

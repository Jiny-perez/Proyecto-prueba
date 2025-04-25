/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prueba;
import java.util.Random;

/**
 *
 * @author marye
 */

public class Randomnumber {
    public static void main(String[] args){
    Random random = new Random();
    int random_number = random.nextInt(1,10);
    
    System.out.println("numero generado:"+random_number);
    }
    
}

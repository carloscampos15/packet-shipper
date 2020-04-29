/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import java.util.Scanner;

/**
 *
 * @author carlo
 */
public class Main {
    
    public static void main(String[] args) {
        
        ClienteRecepcion clienteRecepcion = new ClienteRecepcion("127.0.0.1");
        
        Scanner sc = new Scanner(System.in);
        boolean band = false;
        while (!band){            
            System.out.println("1. traer ciudades");
            System.out.println("2. ");
            System.out.println("3. salir");
            
            int opcion = sc.nextInt();
            switch(opcion){
                case 1:
                    System.out.println(clienteRecepcion.obtenerCiudades().size());
                    break;
                case 2:
                    break;
                case 3:
                    band = true;
                    break;
            }
        }
    }
}

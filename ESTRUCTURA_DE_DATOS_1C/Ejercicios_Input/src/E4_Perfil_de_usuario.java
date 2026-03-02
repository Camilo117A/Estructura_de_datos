/* Ejercicio 4 — Perfil de usuario
Pide al usuario los datos de su perfil: nombre, edad, ciudad, correo y si acepta términos y condiciones. Muestra un resumen indicando el tipo de dato que se usó para cada campo.

Datos de entrada: String, int, String, String, boolean

Salida esperada:

========= Perfil creado =========
Nombre  (String)  : Ana Pérez
Edad    (int)     : 22
Ciudad  (String)  : Bogotá
Correo  (String)  : ana@mail.com
T&C     (boolean) : true */

import java.util.Scanner;

public class E4_Perfil_de_usuario {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nombre completo : ");
        String nombre = sc.nextLine();   

        System.out.print("Edad            : ");
        int edad = sc.nextInt();       
        sc.nextLine();               

        System.out.print("Ciudad          : ");
        String ciudad = sc.nextLine();   

        System.out.print("Correo          : ");
        String correo = sc.nextLine();  

        System.out.print("¿Acepta T&C? (true/false): ");
        boolean aceptaTC = sc.nextBoolean(); 

        System.out.println("\n========= Perfil creado =========");
        System.out.printf("Nombre  (String)  : ",  nombre);
        System.out.printf("Edad    (int)     : ",  edad);
        System.out.printf("Ciudad  (String)  : ",  ciudad);
        System.out.printf("Correo  (String)  : ",  correo);
        System.out.printf("T&C     (boolean) : ",  aceptaTC);

        sc.close();
    }
}

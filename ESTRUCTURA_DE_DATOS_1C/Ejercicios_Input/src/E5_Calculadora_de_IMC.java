/* Ejercicio 5 — Calculadora de IMC
Pide nombre, peso en kg y altura en metros. Calcula el IMC y clasifícalo.

Fórmula: IMC = peso / (altura × altura)

Clasificación:

IMC < 18.5 → Bajo peso
18.5 ≤ IMC < 25 → Normal
25 ≤ IMC < 30 → Sobrepeso
IMC ≥ 30 → Obesidad
Datos de entrada: String nombre, double peso, double altura */

import java.util.Scanner;

public class E5_Calculadora_de_IMC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nombre  : ");
        String nombre = sc.nextLine();

        System.out.print("Peso (kg)    : ");
        double peso = sc.nextDouble();

        System.out.print("Altura (m)   : ");
        double altura = sc.nextDouble();

        double imc = peso / (altura * altura);

        String clasificacion;
        if (imc < 18.5) {
            clasificacion = "Bajo peso";
        } else if (imc < 25) {
            clasificacion = "Normal";
        } else if (imc < 30) {
            clasificacion = "Sobrepeso";
        } else {
            clasificacion = "Obesidad";
        }

        System.out.println("\n--- Resultado IMC ---");
        System.out.printf("Nombre         : %s%n",    nombre);
        System.out.printf("Peso           : %.1f kg%n", peso);
        System.out.printf("Altura         : %.2f m%n",  altura);
        System.out.printf("IMC            : %.2f%n",    imc);
        System.out.printf("Clasificación  : %s%n",      clasificacion);

        sc.close();
    }
}

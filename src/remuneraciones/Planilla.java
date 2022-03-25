package remuneraciones;

import java.util.Scanner;

public class Planilla {
	
	public static void main(String[] args) {
		if( args.length < 6) {
			mostrarEjemplo();
		}else {
			calcularRemuneracion(args);			
		}
		
	}

	private static void mostrarEjemplo() {
		System.out.println("Remuneraciones [sueldo-base] [colación] [movilización] [afp] [salud] [tipo contrato]");
		System.out.println("Ejemplo, Remuneración [500000] [30000] [20000] [modelo] [isapre] [indefinido]");
		
	}
	
	public static void calcularRemuneracion(String[] args) {
		int sueldoBase = Integer.parseInt(args[0]);
		int colacion = Integer.parseInt(args[1]);
		int movilizacion = Integer.parseInt(args[2]);
		String afp = args[3];
		String salud = args[4];
		String plazoContrato = args[5];
		
		int montoImponible = calcularMontoImponible(sueldoBase);
		int montoAFP = calcularMontoAfp(montoImponible,afp);
		int montoNoImponible = calcularMontoNoImponible(colacion,movilizacion);
		int montoSalud = calcularMontoSalud(montoImponible, salud);
		int montoPlazo = calcularSeguroCesantia(montoImponible, plazoContrato);
		
		System.out.printf("Monto imponible %d\n", sueldoBase);
		System.out.printf("Monto No imponible %d\n\n", montoNoImponible);
		System.out.println("Descuentos legales:");
		System.out.printf("AFP: %s\n", afp); //se esta uniendo el valor de una variable a un string, en este caso se formatea el valor de la variable afp
		System.out.printf("Descuento AFP: %d\n", montoAFP); //se esta uniendo el valor de una variable a un string, en este caso se formatea el valor de la variable montoAfp que es un integer
		System.out.printf("Descuento %s %d\n", salud, montoSalud);
		System.out.printf("Descuento seguro cesantia %d\n", montoPlazo);			
		
	}
	
	public static int calcularMontoImponible(int sueldoBase) {
		return sueldoBase;
	}
	
	public static int calcularMontoNoImponible(int colacion, int movilizacion) {
		return colacion + movilizacion;
	}
	
	public static int calcularMontoSalud(int montoImponible, String salud) {
		double uf = 31727.74;//monto uf a marzo del 2022
		switch(salud) {
			case "fonasa":{
				return (int) (montoImponible * 0.07);
			}
			case "isapre":{
				double montoIsapre;
				System.out.println("Ingrese el plan de salud en UF, ejemplo: 1.5 ");
				Scanner teclado = new Scanner(System.in);
				montoIsapre = teclado.nextDouble();
				return (int) (montoIsapre * uf);
			}
		}
		return 0;
		
	}
	
	public static int calcularMontoAfp(int montoImponible, String afp) {
		switch(afp) {
			case "capital": {
				return (int) (montoImponible * 0.1144); //se esta haciendo un casting para crear un integer
			}
			case "cuprum": {
				return (int) (montoImponible * 0.1144);
			}
			case "habitat": {
				return (int) (montoImponible * 0.1127);
			}
			case "planvital": {
				return (int) (montoImponible * 0.1116);
			}
			case "provida": {
				return (int) (montoImponible * 0.1145);
			}
			case "modelo": {
				return (int) (montoImponible * 0.1058);
			}
			case "uno": {
				return (int) (montoImponible * 0.1069);
			}
		}
		return 0;
	}
	
	public static int calcularSeguroCesantia(int montoImponible, String plazoContrato) {
		
		switch(plazoContrato) {
			case "indefinido":{
				return (int) (montoImponible * 0.006);
			}
		}
		return 0;
	}

}

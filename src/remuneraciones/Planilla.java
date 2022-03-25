package remuneraciones;

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
		
		System.out.printf("AFP: %s\n", afp); //se esta uniendo el valor de una variable a un string, en este caso se formatea el valor de la variable afp
		System.out.printf("Monto: %d\n", montoAFP); //se esta uniendo el valor de una variable a un string, en este caso se formatea el valor de la variable montoAfp que es un integer
	}
	
	public static int calcularMontoImponible(int sueldoBase) {
		return sueldoBase;
	}
	
	public static int calcularMontoNoImponible(int colacion, int movilizacion) {
		return colacion + movilizacion;
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

}

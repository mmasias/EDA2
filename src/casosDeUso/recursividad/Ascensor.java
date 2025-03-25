public class Ascensor {

	public static void main(String[] args) {
		int ascensor = 0;
		ascensor = moverAscensor(ascensor, 5);
		ascensor = moverAscensor(ascensor, 3);
		ascensor = moverAscensor(ascensor, 10);
		ascensor = moverAscensor(ascensor, -2);
	}

	public static int moverAscensor(int ascensor, int objetivo) {
		System.out.print("[" + ascensor + "] ");
		if (ascensor == objetivo) {
			System.out.println("Se ha llegado a su destino");
			return ascensor;
		}
		int movimiento = (objetivo-ascensor)/Math.abs(objetivo-ascensor);
		return moverAscensor(ascensor + movimiento, objetivo);
	}
}

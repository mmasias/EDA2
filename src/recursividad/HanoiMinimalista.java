class HanoiMinimalista {

    static void resolver(int n, char origen, char destino, char auxiliar) {
        if (n == 1) {
            System.out.println("Mover disco 1 de " + origen + " a " + destino);
            return;
        }

        resolver(n - 1, origen, auxiliar, destino);
        System.out.println("Mover disco " + n + " de " + origen + " a " + destino);
        resolver(n - 1, auxiliar, destino, origen);
    }

    public static void main(String[] args) {
        resolver(7, 'A', 'C', 'B');
    }
}

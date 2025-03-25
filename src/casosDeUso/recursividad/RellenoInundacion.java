import java.util.Scanner;
import java.util.Stack;

public class RellenoInundacion {

    final static boolean MODO_DEBUG = false;

    public static void main(String[] args) {
        
        char[][] imagen = crearImagenEjemplo(PLANTILLA_001);

        imprimirImagen(imagen);
        System.out.println("Imagen original -- Pulse una tecla para empezar a pintarla");
        new Scanner(System.in).nextLine();

        rellenarRecursivo(imagen, 2, 2, 'x', '\0');
        imprimirImagen(imagen);
        System.out.println("Imagen después del relleno por inundación habiendo empezado en (4,4)");

        // imagen = crearImagenEjemplo();
        // rellenarIterativo(imagen, 2, 2, '*');
        // System.out.println("Imagen después del relleno por inundación en (3,3):");
        // imprimirImagen(imagen);

        // imagen = crearImagenEjemplo();
        // int numHabitaciones = contarHabitaciones(imagen);
        // System.out.println("Número de habitaciones (áreas cerradas): " +
        // numHabitaciones);
    }

    private static String[] PLANTILLA_000 = {
            ".....................................",
            ".....................................",
            "..########################...........",
            "..#......................#...#####...",
            "..#..........########....#####...#...",
            "..#..........#......#............#...",
            "..#..........########.........####...",
            "..######......................#......",
            ".......#..#####.....###########......",
            "..######.................#...#####...",
            "..#..........########....#####...#...",
            "..#..........#......#............#...",
            "..#..........########.........####...",
            "..######......................#......",
            ".......#..#####.....###########......",
            ".......####...#######................",
            ".....................................",
            "....................................."
    };

    private static String[] PLANTILLA_001 = {
            ".....................................................",
            ".....................................................",
            "..########........#########.......########...........",
            "..#......#........#.......#.......#......#...........",
            "..#......#........#.......#.......#......#...........",
            "..#......#........#.......#.......#......#...........",
            "..########........#########.......########...........",
            ".....................................................",
            "..########....########....########....########.......",
            "..#......#....#......#....#......#....#......#.......",
            "..#......#....#......#....#......#....#......#.......",
            "..########....########....########....########.......",
            ".....................................................",
            "..#######.........#######.........#######............",
            "..#.....#.........#.....#.........#.....#............",
            "..#.....#.........#.....#.........#.....#............",
            "..#######.........#######.........#######............",
            ".....................................................",
            ".....................................................",
            "....................................................."
    };

    private static String[] PLANTILLA_002 = {
            " ############################################+##################################################### ",
            " ++------------++---+++---++++----+##############################-+++++++++--------++--------++++++ ",
            "                              -###########+-###-----+-++++###########+                              ",
            "                           -#######+-++-+#++###+++++++++#++--+--########-                           ",
            "                         +#####+-+-+##+-+#-++--+#++####-#++-+#+++++-######+                         ",
            "                       +#####+#+-++--#+-+#####+#+++-+##++-+-##--+#++#++#####+                       ",
            "                     +#####+-+#--#-  -+++---####+++++##+#+-+#+  -++--#+ +####+-                     ",
            "                    +#####+  ####+  --##+---###-+++++##+-+-+#+-  -++--#++######-                    ",
            "                  -+##+--##++#+-+----##+++-###+-++++-#####--##--- -+++####+--###+-                  ",
            "                  +##+   -####++ --+##-+--####- ++++-+###+++-###--  #+-##+   -+##+-                 ",
            "                 +##+     +##-+#+-###--+-##+#+- ++++--#####++-###-- +++##-     +##+-                ",
            "                +##+-     +##-+#-### +-+##-+#-  ++++--+####++#++##--++-##-      +##+                ",
            "               +##+---    +##-####+ +-#-#+-#++++#####+-##-###+#++##++++#+        +##+               ",
            "              -##+-+##--  -##-###+---#-######+##############-#+#++##++#+       ---+##-              ",
            "              +##--+++#++--#+##-- ++#-##+++#+####+-+#####+-## #+#--#####-----++++-++#+              ",
            "              ##--+-#+#++-+###+- -++###++##################### #+#++++###----+###+--##+             ",
            "             -##--+-#+#++###+   +#+#+#+++##-############+#+--##-#+#-   +##+++-+##+-+-##-            ",
            "             +#+---+#-#-##+-   -#+#+##- ##--            -## +-##+#+++   +##++++####++##-            ",
            "             ##---####-##+    +#+####---##-             -##+ -##++#+#+   -###-+####--##+            ",
            "             ##-----#+##--   +#+#-###+ +#+-   -+#+-     --##-- ##++#++-   -###+###+- +##            ",
            "            -##- --+-##+--  +#+##+##- -##-    +###+      -+#+ --##++#+++  --#++-#++- -##            ",
            "            +## --#####+-- +#+#++##-- +#+-    ##+##       -##  --## +#++- --+#++#+--  ##            ",
            "            ##+-+#####+-  -++#+-##--  ##-     #####       -##-  -### +#+++  -+##### - ##            ",
            "            ##-###+      +++#+ ##+-  +##      #+###       --##  --##+ +#+++     -###--##            ",
            "           -#####-      -++#+ +##-  -##-      +++--         ##+  +-##  +#++-     -+##+##-           ",
            "           +###+       +++#+ -##--  +#+-      ---           -##   -##+ -+#+++      -####+           ",
            "           ###+       -++#+ -##+-   ##-                     -##-  --##+  +#++-      -+###           ",
            "           ###-------++-#+  ###----+##-----------------------+#+-----##+  +#-++-------###           ",
            " #+        ##########################+++++++++++++++++++++++++###########################           ",
            " -+        +########################+++++++++++++++++++++++++++#########################+           ",
            " #+                                                                                                 ",
            "                                                                                                    ",
            "                                                                                                    "
    };

    private static int altura;
    private static int anchura;

    private static char[][] crearImagenEjemplo(String[] imagenOriginal) {
        altura = imagenOriginal.length;
        anchura = imagenOriginal[0].length();

        char[][] imagen = new char[altura][anchura];

        for (int y = 0; y < altura; y++) {
            for (int x = 0; x < anchura; x++) {
                imagen[y][x] = '.';
            }
        }

        for (int y = 0; y < imagenOriginal.length; y++) {
            char[] fila = imagenOriginal[y].toCharArray();
            for (int x = 0; x < fila.length; x++) {
                imagen[y][x] = fila[x];
            }
        }

        return imagen;
    }

    public static void rellenarRecursivo(char[][] imagen, int x, int y, char nuevoCaracter, char caracterOriginal) {
        if (caracterOriginal == '\0') {
            caracterOriginal = imagen[y][x];
        }

        if (y < 0 || y >= imagen.length || x < 0 || x >= imagen[0].length) {
            return;
        }

        if (imagen[y][x] != caracterOriginal || caracterOriginal == nuevoCaracter) {
            return;
        }

        imagen[y][x] = nuevoCaracter;
        if (MODO_DEBUG) {
            imprimirImagen(imagen);
            new Scanner(System.in).nextLine();
        }

        rellenarRecursivo(imagen, x + 1, y, nuevoCaracter, caracterOriginal);
        rellenarRecursivo(imagen, x - 1, y, nuevoCaracter, caracterOriginal);
        rellenarRecursivo(imagen, x, y + 1, nuevoCaracter, caracterOriginal);
        rellenarRecursivo(imagen, x, y - 1, nuevoCaracter, caracterOriginal);
    }

    public static void rellenarIterativo(char[][] imagen, int x, int y, char nuevoCaracter) {
        char caracterOriginal = imagen[y][x];

        if (caracterOriginal == nuevoCaracter) {
            return;
        }

        Stack<int[]> pila = new Stack<>();
        pila.push(new int[] { x, y });

        while (!pila.isEmpty()) {
            int[] coordenada = pila.pop();
            int actualX = coordenada[0];
            int actualY = coordenada[1];

            imprimirImagen(imagen);
            // new Scanner(System.in).nextLine();

            if (actualY < 0
                    || actualY >= imagen.length
                    || actualX < 0
                    || actualX >= imagen[0].length
                    || imagen[actualY][actualX] != caracterOriginal) {
                continue;
            }

            imagen[actualY][actualX] = nuevoCaracter;

            pila.push(new int[] { actualX, actualY + 1 });
            pila.push(new int[] { actualX, actualY - 1 });
            pila.push(new int[] { actualX + 1, actualY });
            pila.push(new int[] { actualX - 1, actualY });
        }
    }

    public static int contarHabitaciones(char[][] imagen) {
        char[][] copia = new char[imagen.length][imagen[0].length];
        for (int y = 0; y < imagen.length; y++) {
            for (int x = 0; x < imagen[0].length; x++) {
                copia[y][x] = imagen[y][x];
            }
        }

        int contador = 0;

        for (int y = 0; y < copia.length; y++) {
            for (int x = 0; x < copia[0].length; x++) {
                if (copia[y][x] == '.') {
                    contador++;
                    rellenarRecursivo(copia, x, y, 'o', '.');
                }
            }
        }

        return contador;
    }

    public static void imprimirImagen(char[][] imagen) {
        cleanScreen();
        for (int y = 0; y < imagen.length; y++) {
            for (int x = 0; x < imagen[0].length; x++) {
                System.out.print(imagen[y][x]);
            }
            System.out.println();
        }
        System.out.println();
    }

    static void cleanScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
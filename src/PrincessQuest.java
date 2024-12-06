import java.util.Scanner;

public class PrincessQuest {
    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean gameRunning = true;
        int levelNumber = 1;
        int lives = 3;
        int coinsCollected = 0;

        displayWelcomeScreen(); // Muestra el mensaje de bienvenida al juego.

        while (true) {
            int choice = displayMainMenu(); // Muestra el menú principal y captura la elección del usuario.
            if (choice == 1) break; // Comienza el juego.
            if (choice == 2) displayRules(); // Muestra las reglas del juego.
            if (choice == 3) {
                displayFarewellMessage(); // Muestra un mensaje de despedida y termina.
                return;
            }
        }

        while (gameRunning) {
            // Juega el nivel actual y pasa al siguiente si el jugador sobrevive.
            gameRunning = playLevel(levelNumber, lives, coinsCollected);
            levelNumber++;
        }

        displayEndGameMessage(); // Muestra un mensaje al finalizar el juego.
    }

    public static void displayWelcomeScreen() {
        // Imprime el mensaje de bienvenida al jugador.
        System.out.println("¡Bienvenida a PrincessQuest!");
    }

    public static int displayMainMenu() {
        // Muestra el menú principal y captura la selección del usuario.
        System.out.println("1. Comenzar juego");
        System.out.println("2. Leer reglas");
        System.out.println("3. Salir");
        System.out.print("Selecciona una opción: ");
        return scanner.nextInt();
    }

    public static void displayRules() {
        // Explica las reglas y controles del juego.
        System.out.println("Reglas del juego:");
        System.out.println("- Usa 'w' para moverte hacia arriba.");
        System.out.println("- Usa 's' para moverte hacia abajo.");
        System.out.println("- Usa 'a' para moverte hacia la izquierda.");
        System.out.println("- Usa 'd' para moverte hacia la derecha.");
        System.out.println("- Usa 'j' para saltar. Luego elige la dirección del salto ('w', 's', 'a', 'd').");
        System.out.println("- Recolecta joyas ('C'), evita obstáculos ('O') y monstruos ('M').");
        System.out.println("- Llega a la meta ('G') para pasar de nivel.");
    }

    public static void displayFarewellMessage() {
        // Despide al jugador cuando elige salir.
        System.out.println("¡Gracias por jugar, valiente princesa!");
    }

    public static boolean playLevel(int levelNumber, int lives, int coinsCollected) {
        // Ejecuta la lógica de un nivel, incluyendo el movimiento y la interacción con los elementos del mapa.
        char[][] level = generateLevel(levelNumber);
        int playerRow = 0, playerCol = 0;

        System.out.println("\nNivel " + levelNumber);
        System.out.println("Vidas: " + lives + " | Joyas: " + coinsCollected);

        while (true) {
            displayLevel(level, playerRow, playerCol); // Dibuja el mapa del nivel.
            char move = getPlayerMove(); // Captura el movimiento del jugador.

            // Si el movimiento es un salto, se realiza dependiendo de la dirección elegida.
            if (move == 'j') {
                char jumpDirection = getJumpDirection(); // Captura la dirección del salto.
                int[] jumpPosition = calculateJumpPosition(playerRow, playerCol, jumpDirection, level);
                playerRow = jumpPosition[0];
                playerCol = jumpPosition[1];
            } else {
                int[] newPosition = movePlayer(move, playerRow, playerCol, level); // Calcula la nueva posición.
                playerRow = newPosition[0];
                playerCol = newPosition[1];
            }

            char cell = level[playerRow][playerCol]; // Obtiene el contenido de la nueva posición.
            switch (cell) {
                case 'C': // Si el jugador recoge una joya.
                    coinsCollected++;
                    System.out.println("¡Recogiste una joya! Total: " + coinsCollected);
                    level[playerRow][playerCol] = '.';
                    break;
                case 'O': // Si el jugador golpea un obstáculo.
                    lives--;
                    System.out.println("¡Chocaste con un obstáculo! Vidas restantes: " + lives);
                    if (lives <= 0) return false; // Finaliza si el jugador se queda sin vidas.
                    break;
                case 'M': // Si el jugador encuentra un monstruo.
                    level[playerRow][playerCol] = '.'; // El monstruo es eliminado al saltar sobre él.
                    System.out.println("¡Monstruo eliminado al saltar sobre él!");
                    break;
                case 'G': // Si el jugador llega al objetivo.
                    System.out.println("¡Llegaste a la meta! Nivel completado.");
                    return true;
            }
        }
    }

    public static char[][] generateLevel(int levelNumber) {
        // Genera el mapa del nivel con obstáculos, monstruos, joyas y el objetivo.
        int rows = 5 + levelNumber;
        int cols = 20 + (levelNumber - 1) * 5;
        char[][] level = new char[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                level[i][j] = '.';
            }
        }

        populateLevelWithElements(level, levelNumber); // Rellena el mapa con elementos.
        return level;
    }

    public static void populateLevelWithElements(char[][] level, int levelNumber) {
        // Añade obstáculos, monstruos, joyas y otros elementos al mapa.
        int obstacleChance = Math.min(30 + (levelNumber * 5), 80);
        int monsterChance = Math.min(15 + (levelNumber * 3), 50);
        int jewelChance = 50;

        for (int i = 0; i < level.length; i++) {
            for (int j = 1; j < level[i].length - 1; j++) {
                double randomValue = Math.random() * 100;
                if (randomValue < obstacleChance) {
                    level[i][j] = 'O';
                } else if (randomValue < obstacleChance + monsterChance) {
                    level[i][j] = 'M';
                } else if (randomValue < obstacleChance + monsterChance + jewelChance) {
                    level[i][j] = 'C';
                }
            }
        }

        level[(int) (Math.random() * level.length)][level[0].length - 1] = 'G'; // Coloca la meta en un lugar aleatorio.
    }

    public static void displayLevel(char[][] level, int playerRow, int playerCol) {
        // Muestra el mapa del nivel, indicando la posición del jugador.
        for (int i = 0; i < level.length; i++) {
            for (int j = 0; j < level[i].length; j++) {
                if (i == playerRow && j == playerCol) {
                    System.out.print("P "); // Representa al jugador.
                } else {
                    System.out.print(level[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public static char getPlayerMove() {
        // Captura la entrada del jugador para determinar su movimiento.
        System.out.print("Mover (w/s/a/d/j): ");
        return scanner.next().charAt(0);
    }

    public static char getJumpDirection() {
        // Captura la dirección del salto (después de presionar 'j').
        System.out.print("Elige la dirección del salto (w/s/a/d): ");
        return scanner.next().charAt(0);
    }

    public static int[] movePlayer(char move, int playerRow, int playerCol, char[][] level) {
        // Calcula la nueva posición del jugador según su movimiento.
        int newRow = playerRow, newCol = playerCol;

        switch (move) {
            case 'w':
                if (playerRow > 0) newRow--;
                break;
            case 's':
                if (playerRow < level.length - 1) newRow++;
                break;
            case 'a':
                if (playerCol > 0) newCol--;
                break;
            case 'd':
                if (playerCol < level[0].length - 1) newCol++;
                break;
        }
        return new int[]{newRow, newCol};
    }

    public static int[] calculateJumpPosition(int playerRow, int playerCol, char direction, char[][] level) {
        // Calcula la posición del salto según la dirección seleccionada.
        int newRow = playerRow, newCol = playerCol;

        switch (direction) {
            case 'w':
                newRow = Math.max(0, playerRow - 2); // Salta hacia arriba.
                break;
            case 's':
                newRow = Math.min(level.length - 1, playerRow + 2); // Salta hacia abajo.
                break;
            case 'a':
                newCol = Math.max(0, playerCol - 2); // Salta hacia la izquierda.
                break;
            case 'd':
                newCol = Math.min(level[0].length - 1, playerCol + 2); // Salta hacia la derecha.
                break;
        }

        return new int[]{newRow, newCol};
    }

    public static void displayEndGameMessage() {
        // Mensaje final del juego.
        System.out.println("¡Fin del juego! Gracias por jugar.");
    }
}
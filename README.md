# PrincessQuest 🌸👑

## Descripción ✨

**PrincessQuest** es un juego de aventura en 2D donde el jugador toma el rol de una princesa que se aventura a través de niveles llenos de obstáculos, monstruos y joyas. El objetivo del juego es superar cada nivel, recolectar joyas y evitar los peligros. A medida que el jugador avanza, los niveles se vuelven más complejos y difíciles.

El juego se maneja completamente mediante un terminal, donde el jugador debe usar comandos para moverse, saltar y tomar decisiones dentro de cada nivel. ¡Una aventura encantadora llena de retos y diversión! 🎮💎

## Reglas del Juego 📜

1. **Movimiento**: El jugador puede moverse en cuatro direcciones:
   - **'w'** para moverse hacia arriba. ⬆️
   - **'s'** para moverse hacia abajo. ⬇️
   - **'a'** para moverse hacia la izquierda. ⬅️
   - **'d'** para moverse hacia la derecha. ➡️
   
2. **Saltar**: El jugador puede realizar un salto con la tecla **'j'**, seguido de una dirección para saltar:
   - **'w'** para saltar hacia arriba. ⬆️
   - **'s'** para saltar hacia abajo. ⬇️
   - **'a'** para saltar hacia la izquierda. ⬅️
   - **'d'** para saltar hacia la derecha. ➡️
   
3. **Objetos y Obstáculos**:
   - **Joya ('C')**: Cuando el jugador recoge una joya, aumenta su puntuación. 💎
   - **Obstáculo ('O')**: Si el jugador choca con un obstáculo, pierde una vida. 💔
   - **Monstruo ('M')**: Si el jugador cae sobre un monstruo, este es eliminado automáticamente. 🐉
   - **Meta ('G')**: El jugador debe llegar a la meta para completar el nivel. 🏁

4. **Vidas y Progreso**:
   - El jugador comienza con 3 vidas. ❤️
   - Cada vez que el jugador pierde todas sus vidas, el juego termina. ☠️
   - El jugador avanza de nivel después de llegar a la meta del nivel actual. 🎉

## Instrucciones para Jugar 🎮

1. **Menú Principal**:
   - Al iniciar el juego, se mostrará un menú con las siguientes opciones:
     - **1**: Comenzar juego. 🎮
     - **2**: Leer reglas. 📖
     - **3**: Salir del juego. 🚪

2. **Comenzar Juego**:
   - Al seleccionar la opción de comenzar, el jugador se adentrará en el primer nivel.
   - El objetivo es recolectar joyas, evitar obstáculos y llegar a la meta ('G').

3. **Reglas del Juego**:
   - Puedes consultar las reglas en cualquier momento desde el menú principal.

4. **Fin del Juego**:
   - Si el jugador se queda sin vidas, el juego termina. 💔
   - Cuando el jugador decide salir, se muestra un mensaje de despedida. 👋

## Características del Juego 🌸

- **Niveles Generados Aleatoriamente**: Cada nivel tiene un diseño único, con diferentes cantidades de obstáculos, monstruos, joyas y una ubicación aleatoria para la meta. 🏰
- **Dificultad Progresiva**: A medida que el jugador avanza, los niveles se vuelven más difíciles, con más obstáculos y monstruos. 🧩
- **Interacción con el Mapa**: El jugador puede moverse, saltar y recoger objetos mientras navega a través del mapa. 🗺️

## Estructura del Código 📚

- **Clase `PrincessQuest`**: Esta es la clase principal del juego. Se encarga de mostrar los menús, controlar el flujo del juego y gestionar los niveles.
- **Métodos Principales**:
  - `displayWelcomeScreen()`: Muestra el mensaje de bienvenida. 🎉
  - `displayMainMenu()`: Muestra el menú principal y gestiona las elecciones del usuario. 📋
  - `playLevel()`: Lógica para jugar un nivel, incluyendo el movimiento del jugador y las interacciones con los elementos del mapa. 🏃‍♀️
  - `generateLevel()`: Genera el mapa del nivel con obstáculos, monstruos, joyas y el objetivo. 🌍
  - `movePlayer()`: Calcula la nueva posición del jugador según su movimiento. 🏃‍♀️
  - `calculateJumpPosition()`: Calcula la nueva posición cuando el jugador salta. 💨
  - `displayEndGameMessage()`: Muestra el mensaje al finalizar el juego. 🎮

## Requisitos 📦

- **Java**: El juego está escrito en Java y se ejecuta en cualquier entorno que soporte Java (JDK 8 o superior). ☕️

## Cómo Ejecutar el Juego 🚀

1. Clona este repositorio a tu máquina local.
2. Abre una terminal y navega hasta el directorio del proyecto.
3. Compila el código Java:
   ```bash
   javac PrincessQuest.java

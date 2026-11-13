# Meta RPG

RPG por turnos para consola, desarrollado en Java. El jugador crea un héroe, elige equipo y combate contra un enemigo.

## Requisitos

- JDK 8 o superior.
- `JAVA_HOME` configurado para apuntar al JDK.
- Maven Wrapper incluido en el proyecto; no hace falta instalar Maven por separado.

## Ejecutar

Abre una terminal en la carpeta raíz del proyecto y compila:

**Windows (PowerShell o CMD):**

```powershell
.\mvnw.cmd clean compile
java -cp target\classes com.example.metarpg.Main
```

**Linux o macOS:**

```bash
./mvnw clean compile
java -cp target/classes com.example.metarpg.Main
```

Si Maven indica que no encuentra Java, configura `JAVA_HOME` con la ruta de tu JDK y vuelve a ejecutar los comandos.

## Cómo jugar

1. Escribe el nombre del héroe.
2. Elige una clase:
   - **Guerrero:** resistente y especializado en espada.
   - **Mago:** usa hechizos y tiene buen ataque.
   - **Arquero:** usa flechas y tiene mucha velocidad.
   - **Pícaro:** ataca con puñaladas y tiene mucha velocidad.
3. Selecciona el equipo introduciendo sus opciones **una por una**. Introduce `0` para terminar. No se pueden equipar duplicados.
   - `1` Espada: +10 ataque.
   - `2` Armadura: +8 defensa.
   - `3` Veneno: +5 ataque y daño de veneno por turno.
   - `4` Amuleto de regeneración: +3 defensa y recupera HP por turno.
   - `5` Bendición: +15% ataque, defensa y velocidad.
4. Elige un enemigo: Goblin, Orco o Dragón.
5. En cada turno, elige una acción:
   - `1` **Atacar:** golpea usando la estrategia de ataque del personaje.
   - `2` **Defender:** reduce a la mitad el daño del siguiente ataque directo recibido; ese turno no atacas.
   - `3` **Usar poción:** recupera hasta 30 HP. Hay dos pociones por combate.
6. El combate termina cuando el héroe o el enemigo llega a 0 HP. Después puedes iniciar otra partida o salir.

Los ataques pueden causar daño crítico. El estado y los eventos del combate se muestran en la consola turno a turno.

## Organización del código

- `com.example.metarpg`: punto de entrada (`Main`) y delegador (`Launcher`).
- `com.example.metarpg.personajes`: héroes, personajes base y decoradores de equipo.
- `com.example.metarpg.combate`: motor, estrategias y resultados de ataque.
- `com.example.metarpg.fabricas`: creadores de héroes y enemigos.
- `com.example.metarpg.consola`: menú, lectura de opciones y salida del juego.

Consulta [EJECUCION.txt](EJECUCION.txt) para ver tres ejemplos de partidas.

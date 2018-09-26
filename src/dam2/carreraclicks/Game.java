package dam2.carreraclicks;

import dam2.carreraclicks.gui.GuiManager;

public class Game {

    private GuiManager guiManager;
    private Player localPlayer;
//    private NetManager netManager;

    /* TODO Crear jugador, crear gui, crear netManager, mostrar primera ventana */
    
    public Game(){
        // NECESITO LA GUI PRINCIPAL WindowName para poder continuar.
        // 1 - GUI WindowName - Obtener nombre del jugador y asignarselo, esto ultimo se hace al crear el objeto Player mediante el constructor.
        // 2 - GUI WindowMainMenu - Obtener la IP del jugador y asignarsela al jugador, usando los metodos setIP(cadena).
        // 3 - A partir de este punto el jugador ya deberia tener tanto IP como nombre.
    }
    
    // Desde WindowName
    /**
     * El jugador ha introducido un nombre mediante la interfaz gráfica
     * @param name El nombre del jugador
     */
    public void userEnteredName(String name){

    }

    // Desde WindowMainMenu
    /**
     * Indica que el usuario desea conectarse a partidas existentes
     */
    protected void initClientMode() {
    }

    /**
     * Indica que el usuario desea crear una nueva partida
     */
    protected void initServerMode() {
    }

    
    
    
    /**
     * Metodo principal Crea el juego
     */
    public static void main(String[] args) {
        new Game();
    }
}

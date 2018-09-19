package dam2.carreraclicks;

public class Game {

    private Player localPlayer;
//    private Gui gui;
//    private NetManager netManager;

    /* TODO Crear juga(dor, crear gui, crear netManager, mostrar primera ventana */
    
    public Game(){
        // NECESITO LA GUI PRINCIPAL WindowName para poder continuar.
        // 1 - GUI WindowName - Obtener nombre del jugador y asignarselo, esto ultimo se hace al crear el objeto Player mediante el constructor.
        // 2 - GUI WindowMainMenu - Obtener la IP del jugador y asignarsela al jugador, usando los metodos setIP(cadena).
        // 3 - A partir de este punto el jugador ya deberia tener tanto IP como nombre.
    }
    
    // Desde WindowName
    /**
     * Establece el nombre del jugador local
     * @param name
     */
    protected void setPlayerName(String name){
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

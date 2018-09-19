package dam2.carreraclicks;

public class Game {

    private Gui gui;
    private Player localPlayer;
    private NetManager netManager;

    /* TODO Crear jugador, crear gui, crear netManager, mostrar primera ventana */

    // Desde WindowName

    /**
     * Establece el nombre del jugador local
     * @param name
     */
    protected void setPlayerName(String name){}

    // Desde WindowMainMenu

    /**
     * Indica que el usuario desea conectarse a partidas existentes
     */
    protected void initClientMode(){}

    /**
     * Indica que el usuario desea crear una nueva partida
     */
    protected void initServerMode(){}








    /** Si el jugador cancela unirse a una partida o crearla */
    protected void regretMode(){}

    protected void setGameName(String gameName){}

    protected void startGame(){}

    protected void joinGame(String ip){}

}

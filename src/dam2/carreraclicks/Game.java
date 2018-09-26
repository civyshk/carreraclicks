package dam2.carreraclicks;

import dam2.carreraclicks.gui.GuiManager;

public class Game {

    private GuiManager guiManager;
    private Player localPlayer;
    private NetManager netManager;

    /* TODO Crear jugador, crear gui, crear netManager, mostrar primera ventana */

    // Desde WindowName

    /**
     * El jugador ha introducido un nombre mediante la interfaz gráfica
     * @param name El nombre del jugador
     */
    public void userEnteredName(String name){

    }

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

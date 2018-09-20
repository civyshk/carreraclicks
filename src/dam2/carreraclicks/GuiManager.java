package dam2.carreraclicks;

import dam2.carreraclicks.gui.WindowGeneral;

public class GuiManager {

    /**
     * Muestra la ventana inicial donde el jugador introduce su nombre
     */
    protected void showWindowName(){}

    /**
     * Muestra la ventana donde el jugador puede elegir, entre otros,
     * si crear una nueva partida o buscar partidas existentes
     */
    protected void showWindowMainMenu(){}

    /**
     * Indica que el usuario ha cerrado una ventana.
     * Usado por las ventanas del paquete dam2.carreraclicks.gui
     */
    public void closing(WindowGeneral window){}


    protected void showWindowGameName(){}

    protected void showWindowGames(){}

    protected void addGame(String ip, String gameName){}

    protected void showWindowPlayers(boolean isServer){}

    protected void addPlayer(Player player){}

    protected void removePlayer(Player player){}

}

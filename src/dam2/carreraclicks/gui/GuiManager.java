package dam2.carreraclicks.gui;

import dam2.carreraclicks.Game;
import dam2.carreraclicks.Player;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * GuiManager es la clase encargada de mostrar al jugador toda la
 * información del juego: configuración, servidores, partida, etc.
 * Es la única comunicación de {@link dam2.carreraclicks.Game} con
 * el jugador
 */
public class GuiManager extends JFrame {

    private Game game;
    private String playerName;
    private JPanel currentPanel;

    /**
     * Inicializa un objeto capaz de mostrar las distintas ventanas
     * al jugador
     */
    public GuiManager(Game game){
        this.game = game;

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                //TODO Informa a Game de que el usuario ha cerrado la ventana
            }
        });

        this.playerName = null;
        this.currentPanel = null;
    }

    /**
     * Muestra la ventana inicial donde el jugador introduce su nombre
     * @param suggestedName Nombre mostrado inicialmente al jugador.
     *                      Usar null si no hay ningún nombre guardado
     */
    public void showWindowName(String suggestedName){
        setUserName(suggestedName);
        currentPanel = new PanelName(this, getSuggestedName());
        setContentPane(currentPanel);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(300, 120));
        pack();
        setVisible(true);
    }

    /**
     * Establece el nombre que se usará en la GUI para el jugador local
     * @param name El nombre del jugador, o null si no hay ninguno
     */
    public void setUserName(String name){
        playerName = name;
    }

    /**
     * Obtiene una propuesta para el nombre que debe mostrarse
     * al jugador en la pantalla de ingreso de nombre
     * @return El nombre propuesto
     */
    private String getSuggestedName(){
        if(playerName == null){
            return "";
        }else{
            return playerName;
        }
    }

    /**
     * El jugador ha introducido un nombre mediante la interfaz gráfica
     * @param name El nombre del jugador
     */
    void userEnteredName(String name){
        setUserName(name);
        game.userEnteredName(name);
    }

    /**
     * Muestra la ventana donde el jugador puede elegir, entre otros,
     * si crear una nueva partida o buscar partidas existentes
     */
    public void showWindowMainMenu(){
        currentPanel = new PanelMainMenu(this, playerName);
        setContentPane(currentPanel);
    }

    /**
     * Muestra una ventana con una lista de servidores a los que
     * el jugador puede unirse
     */
    public void showWindowChooseServer(){
        currentPanel = new PanelChooseServer(this);
        setContentPane(currentPanel);
    }

    /**
     * Indica que no se ha podido unir a un servidor
     */
    public void joiningFailed(String ip){
        if(currentPanel instanceof PanelChooseServer){
            ((PanelChooseServer) currentPanel).enableAllServers();
        }else{
            System.err.println("Error, se llamó a GuiManager.joiningFailed() pero no está en la ventana de servidores");
        }
    }

    // Por hacer

    /**
     * Muestra una ventana con la lista de jugadores unidos a un servidor
     */
    public void showWindowPlayers(String serverIp, String serverName){}

    protected void showWindowGameName(){}

    protected void addGame(String ip, String gameName){}

    protected void showWindowPlayers(boolean isServer){}

    protected void addPlayer(Player player){}

    protected void removePlayer(Player player){}

}

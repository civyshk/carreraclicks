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
    }

    /**
     * Muestra la ventana inicial donde el jugador introduce su nombre
     * @param suggestedName Nombre mostrado inicialmente al jugador.
     *                      Usar null si no hay ningún nombre guardado
     */
    public void showWindowName(String suggestedName){
        setUserName(suggestedName);
        setContentPane(new PanelName(this, getSuggestedName()));
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
        setContentPane(new PanelMainMenu(this, playerName));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }



    // Por hacer

    protected void showWindowGameName(){}

    protected void showWindowGames(){}

    protected void addGame(String ip, String gameName){}

    protected void showWindowPlayers(boolean isServer){}

    protected void addPlayer(Player player){}

    protected void removePlayer(Player player){}

}

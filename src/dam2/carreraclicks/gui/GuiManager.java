package dam2.carreraclicks.gui;

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

    private String playerName;

    /**
     * Inicializa un objeto capaz de mostrar las distintas ventanas
     * al jugador
     */
    public GuiManager(){
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                //TODO Informa a Game de que el usuario ha cerrado la ventana
            }
        });

        playerName = null;
    }

    /**
     * Muestra la ventana inicial donde el jugador introduce su nombre
     */
    public void showWindowName(){
        setContentPane(new PanelName(this, getDefaultName()));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(300, 120));
        pack();
        setVisible(true);
    }

    /**
     * Obtiene una propuesta para el nombre que debe mostrarse
     * al jugador en la pantalla de ingreso de nombre
     * @return El nombre propuesto
     */
    private String getDefaultName(){
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
        if(name != null){
            playerName = name.trim().substring(0, 20);
        }else{
            playerName = "Jugador";
        }
        showWindowMainMenu();
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

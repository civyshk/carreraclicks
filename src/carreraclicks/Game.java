package carreraclicks;

import carreraclicks.gui.GuiManager;


/**
 * Game es la clase encargada de controlar todos los recursos del juego.
 */
public class Game {

    private GuiManager guiManager;
    private Player localPlayer;
    private NetManager netManager;
    private String NOMBRE_POR_DEFECTO = "Anonimo";

    // SUGERENCIA: Hacer una clase con todas las constantes, solo si hay muchas. 
    /* TODO Crear netManager, mostrar primera ventana */
    public Game(){
        this.guiManager = new GuiManager(this); // Creo un objeto del controlador de interfaces.
        this.guiManager.showWindowName(this.NOMBRE_POR_DEFECTO); // Pido al controlador de interfaces que muestre la ventana de nombre.
    }
    
    /**
     * El jugador ha introducido un nombre mediante la interfaz grafica.
     * Nota: Este metodo es llamado desde GuiManager.
     * @param name El nombre del jugador local introducudo desde la GUI
     */
    public void userEnteredName(String name){
        this.localPlayer = new Player(name);
        System.out.println(this.localPlayer);
    }

    // Desde Window MainMenu
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
    
    //Desde Window ChooseServer
    public void joinServer(String ip){}
    
    /**
     * Metodo principal Crea el juego
     */
    public static void main(String[] args) {
        new Game();
    }
}

package dam2.carreraclicks;

/**
 * Esta clase permite identificar a cada jugador por su IP y su nombre de usuario.
 * @author Carlos
 */
public class Player {

    private String name;
    private String ip;
    private final int LIMITE_NOMBRE = 10;

    /**
     * El constructor de Jugador obliga a definir un nombre de forma obligatoria.
     * @param name Cadena de texto que contiene el nombre del jugador.
     */
    public Player(String name) {
        this.setName(name);
    }
    
    /**
     * Este metodo permite definir un nombre a un jugador.
     * En caso de que sea demasiado largo (+10 caracteres) se cortara y si es NULL o esta vacio pondra "Anonimo" por defecto.
     * @param name Cadena de texto que contiene el nombre del jugador.
     */
    public void setName(String name){
        if(name == null || name.isEmpty()){this.name = "Anonimo";}
        else if(name.length() > LIMITE_NOMBRE){this.name = name.substring(0, LIMITE_NOMBRE);}
        else{this.name = name;}
    }
    
    /**
     * Define cual es la IP asignada al jugador.
     * @param ip Cadena de texto con la IP v4.
     */
    public void setIp(String ip){this.ip = ip;}
    
    /**
     * Obtiene el nombre del jugador.
     * @return Cadena de texto con el nombre del jugador.
     */
    public String getName(){return this.name;}
    
    /**
     * Obtiene una cadena de texto con la IP del jugador.
     * @return Cadena de texto con IP del jugador.
     */
    public String getIp(){return this.ip;}
}

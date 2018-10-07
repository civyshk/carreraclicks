package carreraclicks.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Ventana con distintas opciones como buscar partidas existentes
 * o crear una partida nueva
 */
public class PanelChooseServer extends JPanel {
    
    private GuiManager guiManager;
    
    private JButton btnBack;
    private JPanel pnlServers;
    private List<Server> servers;
    private JoinListener joinListener;

    public PanelChooseServer(GuiManager guiManager){
        this.guiManager = guiManager;
        
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        servers = new ArrayList<>();
        joinListener = new JoinListener();

        JLabel lblTop = new JLabel("Elige un servidor");
        lblTop.setAlignmentX(Component.CENTER_ALIGNMENT);

        pnlServers = new JPanel();
        pnlServers.setLayout(new BoxLayout(pnlServers, BoxLayout.Y_AXIS));

        btnBack = new JButton("Atrás");
        btnBack.setAlignmentX(Component.RIGHT_ALIGNMENT);

        //TODO el botón back aún no responde a eventos

        add(lblTop);
        add(Box.createRigidArea(new Dimension(1, 10)));
        add(pnlServers);
        add(Box.createRigidArea(new Dimension(1, 10)));
        add(btnBack);
    }

    public void addServer(String ip, String name){
        //Crea un panel que contenga toda la info del servidor
        JPanel pnlServer = new JPanel(new FlowLayout());

        //Con ip
        pnlServer.add(new JLabel(ip));
        //Con nombre
        pnlServer.add(new JLabel(name));
        //Con botón de unirse
        JButton btnJoin = new JButton("Unirse");
        btnJoin.addActionListener(joinListener);
        pnlServer.add(btnJoin);

        pnlServers.add(pnlServer);

        //Guarda los datos de este servidor
        Server server = new Server(ip, name, btnJoin);
        servers.add(server);
    }

    void enableAllServers(){
        enableAllServers(true);
    }

    private void enableAllServers(boolean enable){
        for (Server s : servers) {
            s.btnJoin.enable(enable);
        }
    }

    private class JoinListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            JButton source = (JButton) actionEvent.getSource();
            for(Server s : servers){
                if(s.btnJoin == source){

                    //deshabilitar todos los botones hasta que responda Game
                    enableAllServers(false);

                    //avisar a Game para que se una al servidor
                    guiManager.game.joinServer(s.ip);

                    return;
                }
            }
        }
    }

    private static class Server{
        private String ip, name;
        private JButton btnJoin;

        private Server(String ip, String name, JButton btnJoin) {
            this.ip = ip;
            this.name = name;
            this.btnJoin = btnJoin;
        }
    }
}

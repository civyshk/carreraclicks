package dam2.carreraclicks.gui;

import javax.swing.*;
import java.awt.*;

/**
 * Ventana con distintas opciones como buscar partidas existentes
 * o crear una partida nueva
 */
public class PanelMainMenu extends JPanel {
    private JButton btnClientMode;
    private JButton btnServerMode;

    public PanelMainMenu(GuiManager guiManager, String playerName){
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel lblTop = new JLabel("Hola " + playerName);
        lblTop.setAlignmentX(Component.CENTER_ALIGNMENT);

        btnClientMode = new JButton("Buscar partidas");
        btnClientMode.setAlignmentX(Component.CENTER_ALIGNMENT);

        btnServerMode = new JButton("Crear partida");
        btnServerMode.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(lblTop);
        add(Box.createRigidArea(new Dimension(1, 10)));
        add(btnClientMode);
        add(Box.createRigidArea(new Dimension(1, 10)));
        add(btnServerMode);
    }
}

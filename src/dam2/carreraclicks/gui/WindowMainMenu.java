package dam2.carreraclicks.gui;

import dam2.carreraclicks.GuiManager;

import javax.swing.*;
import java.awt.*;

/**
 * Ventana con distintas opciones como buscar partidas existentes
 * o crear una partida nueva
 */
public class WindowMainMenu extends WindowGeneral {
    private JButton btnClientMode;
    private JButton btnServerMode;

    public WindowMainMenu(GuiManager guiManager){
        super(guiManager);

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        JLabel lblTop = new JLabel("Carrera clicks");
        lblTop.setAlignmentX(Component.CENTER_ALIGNMENT);

        btnClientMode = new JButton("Buscar partidas");
        btnClientMode.setAlignmentX(Component.CENTER_ALIGNMENT);

        btnServerMode = new JButton("Crear partida");
        btnServerMode.setAlignmentX(Component.CENTER_ALIGNMENT);

        getContentPane().add(lblTop);
        getContentPane().add(Box.createRigidArea(new Dimension(1, 10)));
        getContentPane().add(btnClientMode);
        getContentPane().add(Box.createRigidArea(new Dimension(1, 10)));
        getContentPane().add(btnServerMode);

        this.setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
    }
}

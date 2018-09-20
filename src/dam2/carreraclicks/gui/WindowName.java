package dam2.carreraclicks.gui;

import dam2.carreraclicks.GuiManager;

import javax.swing.*;
import java.awt.*;

/**
 * Ventana para pedir al usuario su nombre
 */
public class WindowName extends WindowGeneral {
    private JTextField txtName;
    private JButton btnNext;

    public WindowName(GuiManager guiManager, String defaultName){
        super(guiManager);

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        JLabel lblTop = new JLabel("Introduce tu nombre");
        lblTop.setAlignmentX(Component.CENTER_ALIGNMENT);

        txtName = new JTextField(defaultName);

        btnNext = new JButton("Aceptar");
        btnNext.setAlignmentX(Component.CENTER_ALIGNMENT);

        getContentPane().add(lblTop);
        getContentPane().add(txtName);
        getContentPane().add(btnNext);

        this.setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
    }
}

package dam2.carreraclicks.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Ventana para pedir al usuario su nombre
 */
public class PanelName extends JPanel {
    private JTextField txtName;
    private JButton btnNext;

    public PanelName(GuiManager guiManager, String defaultName){
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel lblTop = new JLabel("Introduce tu nombre");
        lblTop.setAlignmentX(Component.CENTER_ALIGNMENT);

        txtName = new JTextField(defaultName);

        btnNext = new JButton("Aceptar");
        btnNext.setAlignmentX(Component.CENTER_ALIGNMENT);

        btnNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                guiManager.userEnteredName(txtName.getText());
            }
        });

        add(lblTop);
        add(txtName);
        add(btnNext);
    }
}

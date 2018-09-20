package dam2.carreraclicks.gui;

import dam2.carreraclicks.GuiManager;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Todas las ventanas heredan de ésta. Así, todas responden
 * al evento de cierre de ventana para avisar a GuiManager
 */
abstract public class WindowGeneral extends JFrame {

    private GuiManager guiManager;

    public WindowGeneral(GuiManager guiManager){
        this.guiManager = guiManager;

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                guiManager.closing(WindowGeneral.this);
            }
        });
    }
}

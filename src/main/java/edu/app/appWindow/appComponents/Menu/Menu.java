package edu.app .appWindow.appComponents.Menu;


import edu.app.appWindow.appComponents.Canvas.Canvas;
import edu.app.appWindow.appComponents.Menu.Buttons.*;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.List;

public class Menu extends JPanel {

    private Canvas appCanvas;
    public Menu() {

        ImageIcon trashcanIcon = buttonIcons.cleanButtonIcon;
        String cleanButtonText = buttonsTitles.cleanButton;

        ActionListener cleanGraph = e -> {
            appCanvas.getGraph().clear();
            appCanvas.repaint();
        };

//        List.of(
//                new CleanButton(),
//                new LoadButton(),
//                new GenerateButton(),
//                new RemoveButton(),
//                new NextButton(),
//                new PreviousButton(),
//                new ToEndButton(),
//                new ToStartButton()).forEach(this::add);
//    }
    List.of(new Button(cleanButtonText, trashcanIcon, cleanGraph)).forEach(this::add);
    }



    public void setAppCanvas(Canvas appCanvas) {
        this.appCanvas = appCanvas;
    }
}

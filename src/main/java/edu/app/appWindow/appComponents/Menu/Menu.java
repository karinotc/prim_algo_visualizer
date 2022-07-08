package edu.app.appWindow.appComponents.Menu;


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

        ImageIcon generateIcon = buttonIcons.generateButtonIcon;
        String generateButtonText = buttonsTitles.generateButton;

        ActionListener generateGraph = e -> {
            generateWindow generateParamsWindow = new generateWindow();
            generateParamsWindow.setAppCanvas(appCanvas);
            appCanvas.repaint();
        };

        ImageIcon loadIcon = buttonIcons.loadButtonIcon;
        String loadText = buttonsTitles.loadButton;

        ActionListener loadGraph = e -> {
            appCanvas.getGraph().readGraphFromFile(appCanvas.getWidth()/2, appCanvas.getHeight()/2);
            appCanvas.repaint();
        };

        ImageIcon toEndIcon = buttonIcons.toEndButtonIcon;
        String toEndText = buttonsTitles.toEndButton;

        ActionListener goToEnd = e -> {
            appCanvas.getGraph().runPrim(1);
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
    List.of(new Button(cleanButtonText, trashcanIcon, cleanGraph), new Button(generateButtonText, generateIcon, generateGraph),
            new Button(loadText, loadIcon, loadGraph), new Button(toEndText, toEndIcon, goToEnd)).forEach(this::add);
    }

    public void setAppCanvas(Canvas appCanvas) {
        this.appCanvas = appCanvas;
    }
}

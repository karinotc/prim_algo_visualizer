package edu.app.appWindow.appComponents.Menu;


import edu.app.appWindow.appComponents.Canvas.Canvas;
import edu.app.appWindow.appComponents.Menu.Buttons.*;
import edu.app.exceptions.PrimException;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;

public class Menu extends JPanel {

    private Canvas appCanvas;
    public Menu() {

        String cleanButtonText = Buttons.CLEAN_BUTTON.title;

        ActionListener cleanGraph = (e) -> {
            appCanvas.getGraph().clear();
            appCanvas.repaint();
        };

        String generateButtonText = Buttons.GENERATE_BUTTON.title;

        ActionListener generateGraph = e -> {
            GenerateWindow generateParamsWindow = new GenerateWindow();
            generateParamsWindow.setAppCanvas(appCanvas);
            appCanvas.repaint();
        };

        String loadText = Buttons.LOAD_BUTTON.title;

        ActionListener loadGraph = e -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File("."));
            fileChooser.showDialog(this, "Load");
            File file = fileChooser.getSelectedFile();
            try {
                appCanvas.getGraph().readGraphFromFile(appCanvas.getWidth() / 2, appCanvas.getHeight() / 2, file.getAbsolutePath());
            } catch (NullPointerException ignored){}
            appCanvas.repaint();
        };

        String toEndText = Buttons.TO_END_BUTTON.title;

        ActionListener goToEnd = e -> {
            try {
                appCanvas.getGraph().runPrim(1);
            } catch (PrimException ex){
                ErrorWindow errorWindow = new ErrorWindow(ex.getMessage());
                errorWindow.setAppCanvas(appCanvas);
                appCanvas.repaint();
            }

            appCanvas.repaint();
        };

    List.of(new Button(cleanButtonText, cleanGraph), new Button(generateButtonText, generateGraph),
            new Button(loadText, loadGraph), new Button(toEndText, goToEnd)).forEach(this::add);
    }

    public void setAppCanvas(Canvas appCanvas) {
        this.appCanvas = appCanvas;
    }

}

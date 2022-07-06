package edu.app .appWindow.appComponents.Menu;


import edu.app.appWindow.appComponents.Menu.Buttons.*;

import javax.swing.*;

public class Menu extends JPanel {

    public Menu() {

        CleanButton cleanButton = new CleanButton();
        LoadButton loadButton = new LoadButton();
        AddEdgeButton addEdgeButton = new AddEdgeButton();
        AddNodeButton addNodeButton = new AddNodeButton();
        GenerateButton generateButton = new GenerateButton();
        NextButton nextButton = new NextButton();
        PreviousButton previousButton = new PreviousButton();
        RemoveButton removeButton = new RemoveButton();
        ToEndButton toEndButton = new ToEndButton();
        ToStartButton toStartButton = new ToStartButton();


        this.add(cleanButton);
        this.add(loadButton);
        this.add(generateButton);
        this.add(addNodeButton);
        this.add(addEdgeButton);
        this.add(removeButton);
        this.add(toStartButton);
        this.add(previousButton);
        this.add(nextButton);
        this.add(toEndButton);

    }

}

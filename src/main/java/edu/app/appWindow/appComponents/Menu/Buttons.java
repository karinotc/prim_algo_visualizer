package edu.app.appWindow.appComponents.Menu;

import edu.app.appWindow.appComponents.Canvas.Canvas;

import java.beans.Expression;



public enum Buttons {
    CLEAN_BUTTON("Clean"),
    GENERATE_BUTTON("Generate"),
    LOAD_BUTTON("Load"),
    NEXT_BUTTON("Next"),
    PREVIOUS_BUTTON("Previous"),
    TO_END_BUTTON("To end"),
    TO_START_BUTTON("To start"),
    RUN_BUTTON("Run Prim");
    final String title;


    Buttons(String buttonTitle) {
        this.title = buttonTitle;
    }


}

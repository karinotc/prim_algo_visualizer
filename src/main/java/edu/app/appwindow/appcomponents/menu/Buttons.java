package edu.app.appwindow.appcomponents.menu;

import edu.app.appwindow.appcomponents.canvas.Canvas;

import java.beans.Expression;



public enum Buttons {
    CLEAN_BUTTON("Clean"),
    GENERATE_BUTTON("Generate"),
    LOAD_BUTTON("Load"),
    TO_END_BUTTON("Run algorithm");
    final String title;


    Buttons(String buttonTitle) {
        this.title = buttonTitle;
    }


}

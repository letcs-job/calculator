package org.letcs.calculator;

import javafx.scene.Scene;
import javafx.scene.control.Button;

public class CalculatorContext {
    /*
     * GUI Control
     */
    public enum DisplayType{Main, Binary,}
    private CalculatorGUIController controller;
    private Scene scene;

    /**
     * Change the display content in the GUI interface
     * @param whichDisplay specify which display area need to change
     * @param newContent the new content need to be displayed in string format
     */
    public void submitDisplayChange(DisplayType whichDisplay, String newContent) {
        controller.changeDisplay(whichDisplay, newContent);
    }

    /**
     * Disable a digit button, other types of button should not be disabled at any time
     * @param button the button need to be disabled
     */
    public void disableButton(CalculatorButton button) {
        if (button.getType() == CalculatorButton.BtnType.digit) {
            Button btn = (Button) scene.lookup("#" + button);
            btn.setDisable(true);
        }
    }

    /**
     * Enable a button in the GUI interface
     * @param button the button need to be enabled
     */
    public void enableButton(CalculatorButton button) {
        Button btn = (Button) scene.lookup("#" + button);
        btn.setDisable(false);
    }

    public void setController(CalculatorGUIController controller) {
        if (this.controller != null) return;
        this.controller = controller;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    /*
     * Singleton the CalculatorContext
     */
    public static CalculatorContext getInstance() {
        return Instance.context;
    }

    private static class Instance {
        private static final CalculatorContext context = new CalculatorContext();
    }
}
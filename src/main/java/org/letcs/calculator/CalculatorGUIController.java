package org.letcs.calculator;

import javafx.fxml.FXML;
import javafx.scene.control.ButtonBase;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class CalculatorGUIController {
    /**
     * The main display label, text can be changed by
     * calling mainDisplay.setText(newText) method
     */
    @FXML
    private Label mainDisplay;

    /**
     * The highest 32bit of the binary display. Value can be changed
     * by calling upperBinaryDisplay.setText(newText) method.
     */
    @FXML
    private Label upperBinaryDisplay;

    /**
     * The lowest 32bit of the binary display. Value can be changed
     * by calling upperBinaryDisplay.setText(newText) method.
     */
    @FXML
    private Label lowerBinaryDisplay;

    /**
     * Listener to keep an eye on the button clicked event.
     */
    private ButtonClickedListener listener;

    /**
     * Method used to set a ButtonClickedListener to monitor
     * the button event.
     * @param listener a class which implements the ButtonClickedListener interface.
     */
    public void setListener(ButtonClickedListener listener) {
        this.listener = listener;
    }

    /**
     * Interface for requesting display changed, used for both main display and binary display.
     * @param whichDisplay which display need to be changed.
     * @param newContent the new content will be shown on the selected display.
     */
    public void changeDisplay(CalculatorContext.DisplayType whichDisplay, String newContent) {
        switch (whichDisplay) {
            case Main:
                mainDisplay.setText(newContent);
                break;
            case Binary:
                // TODO: handle binary display
                break;
            default:
                throw new RuntimeException("Not supported display type");
        }
    }

    @FXML
    private void onClickButton(MouseEvent event) {
        String buttonID = ((ButtonBase) event.getSource()).getId();
        CalculatorButton btn = CalculatorButton.valueOf(buttonID.toUpperCase());
        // TODO: handle button clicked event
        if (btn.getType() == CalculatorButton.BtnType.mode)
            System.out.println("You select [" + btn.getLiteral() + "] mode");
        else
            System.out.println("You clicked <" + btn.getType() + "> button [" + btn.getLiteral() + "]");
        if (listener != null) listener.onButtonClicked(btn);
    }

}
package ch.informatik.m322.view.dialog;

import javax.swing.*;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import java.text.ParseException;

/**
 * Represents a formatted text field with a specified format.
 */
public class FormattedField extends JFormattedTextField {

    /**
     * Constructs a FormattedField with the specified format.
     *
     * @param format the format for the field
     * @throws ParseException if an error occurs during parsing
     */
    public FormattedField(String format) throws ParseException {
        MaskFormatter formatter = new MaskFormatter(format);
        this.setFormatterFactory(new DefaultFormatterFactory(formatter));
    }
}

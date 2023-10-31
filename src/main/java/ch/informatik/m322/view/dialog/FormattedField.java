package ch.informatik.m322.view.dialog;

import javax.swing.*;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import java.text.ParseException;

public class FormattedField extends JFormattedTextField {

    public FormattedField(String format) throws ParseException {
        MaskFormatter formatter = new MaskFormatter(format);
        this.setFormatterFactory(new DefaultFormatterFactory(formatter));
    }
}

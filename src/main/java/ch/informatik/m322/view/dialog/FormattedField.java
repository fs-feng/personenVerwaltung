package ch.informatik.m322.view.dialog;

import javax.swing.JFormattedTextField;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import java.text.ParseException;

public class FormattedField extends JFormattedTextField {

    public FormattedField(String format) {
        try {
            MaskFormatter formatter = new MaskFormatter(format);
            this.setFormatterFactory(new DefaultFormatterFactory(formatter));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}

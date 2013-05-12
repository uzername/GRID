package grid_servithors;

import java.io.IOException;
import java.io.StringReader;
import javax.swing.JEditorPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.html.HTMLEditorKit;

/**
 * @author Ivan
 * Provides output service/interface for GRID model simulation.
 * Because System.out.println is too mainstream.
 * It may be used to redirect output to other components (JEdit, JLabel...) 
 * with minimal changes. Pattern magics!
 */
public class Dat_Printer {
    
    public JEditorPane My_jEditorPane1;
    
    /*public static void SmartAddTextToEditorPane (String text) {
        HTMLEditorKit editor = (HTMLEditorKit)( My_jEditorPane1.getEditorKit());
        StringReader reader = new StringReader(text);
        try {
          editor.read(reader, My_jEditorPane1.getDocument(), My_jEditorPane1.getDocument().getLength());
        }
        catch(BadLocationException ex) {
           //This happens if your offset is out of bounds.
            ex.printStackTrace();
        }
        catch (IOException ex) {
          // I/O error
            ex.printStackTrace();
        }
    }*/
    
    public static void println(String Line2Print ) {
        System.out.println(Line2Print);
    }
    /*public static void println(String Line2Print ) {
        SmartAddTextToEditorPane(Line2Print);
    }*/
}

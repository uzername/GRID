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
    
    private static Dat_Printer instance; //feel the singleton
    public static JEditorPane My_jEditorPane1; //let it be public!
    
    
    public static synchronized Dat_Printer getDat_Printer() {
        if (instance == null) {
            instance = new Dat_Printer();
        }
        return instance;
    }
    
    public static void SmartAddTextToEditorPane (String text) {
        //JEditorPane My_jEditorPane1
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
    }
    
    public void println(String Line2Print ) {
        System.out.println(Line2Print);
    }
    public void graphic_println(String Line2Print ) {
        SmartAddTextToEditorPane(Line2Print);
    }
}

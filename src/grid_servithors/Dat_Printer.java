package grid_servithors;

/**
 * @author Ivan
 * Provides output service/interface for GRID model simulation.
 * Because System.out.println is too mainstream.
 * It may be used to redirect output to other components (JEdit, JLabel...) 
 * with minimal changes. Pattern magics!
 */
public class Dat_Printer {
    public static void println(String Line2Print ) {
        System.out.println(Line2Print);
    }
    
}

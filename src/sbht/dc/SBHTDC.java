package sbht.dc;



import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import package_view.Login_view;
import package_view.Main_;

/**
 *
 * @author Miz
 */
public class SBHTDC {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        try {
            System.out.println(UIManager.getLookAndFeel());
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                        //UIManager.setLookAndFeel(new FlatIntelliJLaf());

        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main_.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        try {
//            FlatRobotoFont.install();
//            FlatLaf.registerCustomDefaultsSource("them");
//            UIManager.put("defaultFont", new Font(FlatRobotoFont.FAMILY, Font.PLAIN, 13));
//            FlatMacLightLaf.setup();
//UIManager.setLookAndFeel(new FlatIntelliJLaf());
        } catch (Exception e) {
            e.printStackTrace();
        }
        java.awt.EventQueue.invokeLater(() -> {
            new Login_view().setVisible(true);

            /*
                    String uniqueID = UUID.randomUUID().toString();
                    String[] IDval = uniqueID.split("-");
                    System.out.println("org id " +uniqueID);
                    System.out.println("arg 1 " + IDval[0]);
                    System.out.println("arg 2 " + IDval[1]);
             */
        });
    }

}

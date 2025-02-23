
package package_view;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.GrayColor;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import package_database.User_DatabaseManager;
import package_model.Model_user;
import package_view.dialog.Dialog_box_Change_Password_admin;

/**
 *
 * @author Miz
 */
public class Admin_view extends javax.swing.JFrame {

    /**
     * Creates new form Admin_view
     */
    public static int user_id = 0;
    User_DatabaseManager database_manager;
    private DefaultTableModel defaultTableModel;
    List<Model_user> user_list;
    
    String current_user = "";
    
    private static final Font HEADERFONT = new Font(Font.FontFamily.UNDEFINED, 12, Font.BOLD);
    private static final Font BODYFONT = new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL);
    Font titleFont = FontFactory.getFont(FontFactory.HELVETICA, 16, Font.NORMAL, new CMYKColor(255, 100, 50, 0));
    

    public Admin_view() {
        initComponents();

        database_manager = new User_DatabaseManager();
        setUpJTableModel();
        panel_status.setVisible(false);
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/package_res/icon.png")).getImage());
        btn_update_user_record.setEnabled(false);
    }

    public final void setUpJTableModel() {
        defaultTableModel = new DefaultTableModel();
        JTable_user_list.setModel(defaultTableModel);
        defaultTableModel.addColumn("ID");
        defaultTableModel.addColumn("NAME");
        defaultTableModel.addColumn("USERNAME");
        defaultTableModel.addColumn("PHONE");
        defaultTableModel.addColumn("ORG ID");
        defaultTableModel.addColumn("STATUS");
        defaultTableModel.addColumn("REG DATE");
        defaultTableModel.addColumn("LAST LOGIN DATE");
        refreshTable();
    }

    private void refreshTable() {

        defaultTableModel.getDataVector().clear();

        ArrayList<Model_user> users = refreshRecord();       
        users.stream().forEach((currentuser) -> {
            defaultTableModel.addRow(new Object[]{currentuser.getUser_system_id(), currentuser.get_full_name(), currentuser.getUser_name(),
                currentuser.getPhone_no(), currentuser.getOrg_id(), currentuser.getCurrent_status(),currentuser.getReg_date(), currentuser.getLast_login_date()});
        });
        defaultTableModel.fireTableDataChanged();
    }

    private ArrayList<Model_user> refreshRecord() {
        return database_manager.getAllusers();
    }
    
    private void update_user_record(){  
        if((txt_field_f_name.getText().isEmpty()) || (txt_field_l_name.getText().isEmpty()) || (txt_field_org_id.getText().isEmpty()) || (txt_field_phone_no.getText().isEmpty()) || (txt_field_username.getText().isEmpty())){
            JOptionPane.showMessageDialog(this, "Please Fill the Form Properlly!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Model_user new_user = new Model_user();
        new_user.setF_name(txt_field_f_name.getText());
        new_user.setL_name(txt_field_l_name.getText());
        new_user.setOrg_id(txt_field_org_id.getText());
        new_user.setPhone_no(txt_field_phone_no.getText());
        new_user.setUser_name(txt_field_username.getText());
        
        database_manager.updateUser(new_user);
        
        refreshTable();
    }
    
    private void export_to_pdf() {

        try {
            Document document = new Document();

            PdfWriter pdfwriter;
            PdfPTable pdftable;

            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int returnVal = fileChooser.showOpenDialog(null);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                List<Model_user> listOfUsers = refreshRecord();

                //background color 
                GrayColor gray = new GrayColor((float) 0.4);

                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
                String timestamp = dateFormat.format(new Date());
                String fileName = "user_report_" + timestamp + ".pdf";

                File fileToSave = fileChooser.getSelectedFile();
                String name = fileToSave.getAbsolutePath();
                File newFile = new File(name + "\\" + fileName);
                pdfwriter = PdfWriter.getInstance(document, new FileOutputStream(newFile));
                document.open();

                
                Paragraph titleParagraph = new Paragraph("Report Result", titleFont);
                titleParagraph.setAlignment(Element.ALIGN_CENTER);
                document.add(titleParagraph);

                pdftable = new PdfPTable(8);
                pdftable.setWidthPercentage(100);
                pdftable.setSpacingBefore(10f);
                pdftable.setSpacingAfter(10f);

                float[] colWidth = {0.5f, 1f, 1f, 1f, 1f, 1f, 1f, 1f};
                pdftable.setWidths(colWidth);

                PdfPCell pdfpcell0 = new PdfPCell(new Paragraph("No", HEADERFONT));
                pdfpcell0.setHorizontalAlignment(Element.ALIGN_CENTER);
                pdfpcell0.setVerticalAlignment(Element.ALIGN_MIDDLE);
                pdfpcell0.setBackgroundColor(gray);

                PdfPCell pdfpcell1 = new PdfPCell(new Paragraph("Name", HEADERFONT));
                pdfpcell1.setHorizontalAlignment(Element.ALIGN_CENTER);
                pdfpcell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
                pdfpcell1.setBackgroundColor(gray);

                PdfPCell pdfpcell2 = new PdfPCell(new Paragraph("Last Name", HEADERFONT));
                pdfpcell2.setHorizontalAlignment(Element.ALIGN_CENTER);
                pdfpcell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
                pdfpcell2.setBackgroundColor(gray);

                PdfPCell pdfpcell3 = new PdfPCell(new Paragraph("Username", HEADERFONT));
                pdfpcell3.setHorizontalAlignment(Element.ALIGN_CENTER);
                pdfpcell3.setVerticalAlignment(Element.ALIGN_MIDDLE);
                pdfpcell3.setBackgroundColor(gray);
                
                PdfPCell pdfpcell7 = new PdfPCell(new Paragraph("Status", HEADERFONT));
                pdfpcell7.setHorizontalAlignment(Element.ALIGN_CENTER);
                pdfpcell7.setVerticalAlignment(Element.ALIGN_MIDDLE);
                pdfpcell7.setBackgroundColor(gray);

                PdfPCell pdfpcell4 = new PdfPCell(new Paragraph("Phone No", HEADERFONT));
                pdfpcell4.setHorizontalAlignment(Element.ALIGN_CENTER);
                pdfpcell4.setVerticalAlignment(Element.ALIGN_MIDDLE);
                pdfpcell4.setBackgroundColor(gray);
                
                PdfPCell pdfpcell5 = new PdfPCell(new Paragraph("Org ID", HEADERFONT));
                pdfpcell5.setHorizontalAlignment(Element.ALIGN_CENTER);
                pdfpcell5.setVerticalAlignment(Element.ALIGN_MIDDLE);
                pdfpcell5.setBackgroundColor(gray);
                
                PdfPCell pdfpcell6 = new PdfPCell(new Paragraph("Last Login", HEADERFONT));
                pdfpcell6.setHorizontalAlignment(Element.ALIGN_CENTER);
                pdfpcell6.setVerticalAlignment(Element.ALIGN_MIDDLE);
                pdfpcell6.setBackgroundColor(gray);

                pdftable.addCell(pdfpcell0);
                pdftable.addCell(pdfpcell1);
                pdftable.addCell(pdfpcell2);
                pdftable.addCell(pdfpcell3);
                pdftable.addCell(pdfpcell7);
                pdftable.addCell(pdfpcell4);
                pdftable.addCell(pdfpcell5);
                pdftable.addCell(pdfpcell6);
                

                for (int i = 0; i < listOfUsers.size(); i++) {

                    PdfPCell pdfpcell_no = new PdfPCell(new Paragraph(String.valueOf(i + 1), BODYFONT));
                    pdfpcell_no.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    pdftable.addCell(pdfpcell_no);

                    PdfPCell pdfpcell_fname = new PdfPCell(new Paragraph(listOfUsers.get(i).getF_name(), BODYFONT));
                    pdfpcell_fname.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    pdftable.addCell(pdfpcell_fname);

                    PdfPCell pdfpcell_lname = new PdfPCell(new Paragraph(listOfUsers.get(i).getL_name(), BODYFONT));
                    pdfpcell_lname.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    pdftable.addCell(pdfpcell_lname);

                    PdfPCell pdfpcell_username = new PdfPCell(new Paragraph(listOfUsers.get(i).getUser_name(), BODYFONT));
                    pdfpcell_username.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    pdftable.addCell(pdfpcell_username);
                    
                    PdfPCell pdfpcell_status = new PdfPCell(new Paragraph(listOfUsers.get(i).getCurrent_status(), BODYFONT));
                    pdfpcell_status.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    pdftable.addCell(pdfpcell_status);

                    PdfPCell pdfpcell_phoneno = new PdfPCell(new Paragraph(listOfUsers.get(i).getPhone_no(), BODYFONT));
                    pdfpcell_phoneno.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    pdftable.addCell(pdfpcell_phoneno);
                    
                    PdfPCell pdfpcell_orgid = new PdfPCell(new Paragraph(listOfUsers.get(i).getOrg_id(), BODYFONT));
                    pdfpcell_orgid.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    pdftable.addCell(pdfpcell_orgid);
                    
                    PdfPCell pdfpcell_lastloin = new PdfPCell(new Paragraph(listOfUsers.get(i).getLast_login_date(), BODYFONT));
                    pdfpcell_lastloin.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    pdftable.addCell(pdfpcell_lastloin);

                }//end of for loop
                document.add(pdftable);
                document.close();
                pdfwriter.close();
            }//if end 

            //end try
        } catch (DocumentException | FileNotFoundException ex) {
            System.err.println("" + ex.getMessage());
        }
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_field_f_name = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_field_l_name = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_field_username = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_field_phone_no = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_field_org_id = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        password_field_1 = new javax.swing.JPasswordField();
        jLabel9 = new javax.swing.JLabel();
        password_field_2 = new javax.swing.JPasswordField();
        btn_save = new javax.swing.JButton();
        btn_update_user_record = new javax.swing.JButton();
        btn_cancle = new javax.swing.JButton();
        btn_report = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTable_user_list = new javax.swing.JTable();
        panel_status = new javax.swing.JPanel();
        lbl_status = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        cb_chnage_status = new javax.swing.JCheckBox();
        btn_reset_password = new javax.swing.JButton();
        btn_home = new javax.swing.JButton();
        btn_admin_change_password = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(32, 31, 95));

        jLabel1.setFont(new java.awt.Font("Lucida Fax", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Admin Page Add/Edit/Disable User accounts");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setFont(new java.awt.Font("Lucida Fax", 3, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Add User");

        jLabel3.setText("First Name :");

        txt_field_f_name.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_field_f_nameKeyReleased(evt);
            }
        });

        jLabel4.setText("Last Name :");

        jLabel5.setText("Username :");

        jLabel6.setText("Phone NO: ");

        jLabel7.setText("Organization ID :");

        txt_field_org_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_field_org_idActionPerformed(evt);
            }
        });

        jLabel8.setText("Password :");

        jLabel9.setText("Confirm Password :");

        btn_save.setText("Save");
        btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveActionPerformed(evt);
            }
        });

        btn_update_user_record.setText("Update");
        btn_update_user_record.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_update_user_recordActionPerformed(evt);
            }
        });

        btn_cancle.setText("Cancle");
        btn_cancle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancleActionPerformed(evt);
            }
        });

        btn_report.setText("Report");
        btn_report.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_reportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_field_l_name)
                            .addComponent(txt_field_username, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                            .addComponent(txt_field_phone_no)
                            .addComponent(txt_field_org_id)
                            .addComponent(password_field_1)
                            .addComponent(txt_field_f_name)
                            .addComponent(password_field_2)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btn_save, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_update_user_record, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_cancle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_report, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txt_field_f_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_field_l_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_field_username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_field_phone_no, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txt_field_org_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(password_field_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(password_field_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_save)
                    .addComponent(btn_update_user_record)
                    .addComponent(btn_cancle)
                    .addComponent(btn_report))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        JTable_user_list.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        JTable_user_list.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTable_user_listMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTable_user_list);

        panel_status.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbl_status.setText("Current Status ON(Enabled)");

        jLabel11.setText("Status : ");

        cb_chnage_status.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_chnage_statusActionPerformed(evt);
            }
        });

        btn_reset_password.setText("Reset User Password");
        btn_reset_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_reset_passwordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_statusLayout = new javax.swing.GroupLayout(panel_status);
        panel_status.setLayout(panel_statusLayout);
        panel_statusLayout.setHorizontalGroup(
            panel_statusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_statusLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_statusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_status, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panel_statusLayout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cb_chnage_status)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_reset_password)))
                .addContainerGap())
        );
        panel_statusLayout.setVerticalGroup(
            panel_statusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_statusLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_status)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel_statusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_statusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(cb_chnage_status, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btn_reset_password))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btn_home.setText("Home");
        btn_home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_homeActionPerformed(evt);
            }
        });

        btn_admin_change_password.setText("Change Password");
        btn_admin_change_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_admin_change_passwordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel_status, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_admin_change_password)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_home, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel_status, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_home)
                            .addComponent(btn_admin_change_password))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_field_org_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_field_org_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_field_org_idActionPerformed

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
        if ((txt_field_f_name.getText().isEmpty()) || (txt_field_l_name.getText().isEmpty()) || (txt_field_org_id.getText().isEmpty())
                || (txt_field_phone_no.getText().isEmpty()) || (txt_field_username.getText().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Please Fill all the Input Field", "Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if ((password_field_1.getPassword().length == 0) || (password_field_2.getPassword().length == 0)) {
            JOptionPane.showMessageDialog(null, "Please Fill all the Input Field", "Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!String.valueOf(password_field_1.getPassword()).equals(String.valueOf(password_field_2.getPassword()))) {
            JOptionPane.showMessageDialog(null, "Password Confirmation Field", "Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        /*
        Pattern p = Pattern.compile("^[1-9]\\d{3}(?:\\.0)?$");
        if(!p.matcher(txt_field_phone_no.getText()).matches()){
            JOptionPane.showMessageDialog(null, "Please Enter a Valid Phone No", "Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        */

        Model_user user = new Model_user();

        user.setF_name(txt_field_f_name.getText());
        user.setL_name(txt_field_l_name.getText());
        user.setUser_name(txt_field_username.getText());
        user.setPhone_no(txt_field_phone_no.getText());
        user.setOrg_id(txt_field_org_id.getText());
        user.setUser_password(String.valueOf(password_field_1.getPassword()));

        
        if(database_manager.check_user_name_exist(txt_field_username.getText(), user_id)){
            JOptionPane.showMessageDialog(this, "Username Must be Unique", "Error", JOptionPane.ERROR_MESSAGE);
        }else{
            database_manager.addUser(user);
            txt_field_f_name.setText("");
            txt_field_l_name.setText("");
            txt_field_username.setText("");
            txt_field_phone_no.setText("");
            txt_field_org_id.setText("");
            password_field_1.setText("");
            password_field_2.setText(""); 
        }
        refreshTable();                
    }//GEN-LAST:event_btn_saveActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        
    }//GEN-LAST:event_formWindowClosing

    private void JTable_user_listMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTable_user_listMouseClicked
        int row = JTable_user_list.rowAtPoint(evt.getPoint());
        int col = JTable_user_list.columnAtPoint(evt.getPoint());
        
        user_id = Integer.valueOf(JTable_user_list.getValueAt(row, 0).toString());
        current_user = JTable_user_list.getValueAt(row, 2).toString();        
        String[] arrSplit = JTable_user_list.getValueAt(row, 1).toString().split(" ");
        
        panel_status.setVisible(true);
        lbl_status.setText("Current User Status "+JTable_user_list.getValueAt(row, 5).toString());
        
        Model_user user_update = new Model_user();
        user_update.setUser_system_id(Integer.valueOf(JTable_user_list.getValueAt(row, 0).toString()));
        user_update.setF_name(arrSplit[0]);
        user_update.setL_name(arrSplit[1]);
        user_update.setUser_name(JTable_user_list.getValueAt(row, 2).toString());
        user_update.setPhone_no(JTable_user_list.getValueAt(row, 3).toString());
        user_update.setOrg_id(JTable_user_list.getValueAt(row, 4).toString());
        user_update.setReg_date(JTable_user_list.getValueAt(row, 5).toString());
        user_update.setLast_login_date(JTable_user_list.getValueAt(row, 6).toString());
        
        txt_field_f_name.setText(user_update.getF_name());
        txt_field_l_name.setText(user_update.getL_name());
        txt_field_username.setText(user_update.getUser_name());
        txt_field_phone_no.setText(user_update.getPhone_no());
        txt_field_org_id.setText(user_update.getOrg_id());
        
        password_field_1.setEditable(false);
        password_field_2.setEditable(false);
        
        btn_save.setEnabled(false);
        btn_update_user_record.setEnabled(true);
        
        String current_user_status = database_manager.get_user_status(String.valueOf(user_id));
        if(current_user_status.equals("on")){
            cb_chnage_status.setSelected(true);
        }else{
            cb_chnage_status.setSelected(false);
        }

    }//GEN-LAST:event_JTable_user_listMouseClicked

    private void btn_cancleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancleActionPerformed
        txt_field_f_name.setText("");
        txt_field_l_name.setText("");
        txt_field_username.setText("");
        txt_field_org_id.setText("");
        txt_field_phone_no.setText("");
        
        password_field_1.setEditable(true);
        password_field_2.setEditable(true);
        
        btn_save.setEnabled(true);
        btn_update_user_record.setEnabled(false);
        
    }//GEN-LAST:event_btn_cancleActionPerformed

    private void btn_update_user_recordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_update_user_recordActionPerformed
        if(database_manager.check_user_name_exist(txt_field_username.getText(), user_id)){
            JOptionPane.showMessageDialog(this, "Username Must be Unique", "Error", JOptionPane.ERROR_MESSAGE);
        }else{
            update_user_record();
        }        
    }//GEN-LAST:event_btn_update_user_recordActionPerformed

    private void txt_field_f_nameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_field_f_nameKeyReleased
        
    }//GEN-LAST:event_txt_field_f_nameKeyReleased

    private void cb_chnage_statusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_chnage_statusActionPerformed
        
        if (!cb_chnage_status.isSelected()) {
            database_manager.update_user_status_off(String.valueOf(user_id));
            cb_chnage_status.setSelected(false);
            lbl_status.setText("Current User Status off");
            refreshTable();
        } else {           
            database_manager.update_user_status_on(String.valueOf(user_id));
            cb_chnage_status.setSelected(true);
            lbl_status.setText("Current User Status on");
            refreshTable();
        }
    }//GEN-LAST:event_cb_chnage_statusActionPerformed

    private void btn_reportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_reportActionPerformed
        export_to_pdf();
    }//GEN-LAST:event_btn_reportActionPerformed

    private void btn_homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_homeActionPerformed
        this.dispose();
        Login_view login_view = new Login_view();
        login_view.setVisible(true);
    }//GEN-LAST:event_btn_homeActionPerformed

    private void btn_reset_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_reset_passwordActionPerformed
         int result = JOptionPane.showConfirmDialog(this,"Reset Password for the user   " + current_user.toUpperCase() , "",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
            if(result == JOptionPane.YES_OPTION){
                database_manager.reset_user_password(current_user);
                JOptionPane.showMessageDialog(this, "Password Reset to 1234 Successfully!", "", JOptionPane.INFORMATION_MESSAGE);
            }else if (result == JOptionPane.NO_OPTION){
                
            }
    }//GEN-LAST:event_btn_reset_passwordActionPerformed

    private void btn_admin_change_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_admin_change_passwordActionPerformed
        Dialog_box_Change_Password_admin cp_admin = new Dialog_box_Change_Password_admin(this, true);
        cp_admin.setLocationRelativeTo(this);
        cp_admin.setVisible(true);
    }//GEN-LAST:event_btn_admin_change_passwordActionPerformed

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JTable_user_list;
    private javax.swing.JButton btn_admin_change_password;
    private javax.swing.JButton btn_cancle;
    private javax.swing.JButton btn_home;
    private javax.swing.JButton btn_report;
    private javax.swing.JButton btn_reset_password;
    private javax.swing.JButton btn_save;
    private javax.swing.JButton btn_update_user_record;
    private javax.swing.JCheckBox cb_chnage_status;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_status;
    private javax.swing.JPanel panel_status;
    private javax.swing.JPasswordField password_field_1;
    private javax.swing.JPasswordField password_field_2;
    private javax.swing.JTextField txt_field_f_name;
    private javax.swing.JTextField txt_field_l_name;
    private javax.swing.JTextField txt_field_org_id;
    private javax.swing.JTextField txt_field_phone_no;
    private javax.swing.JTextField txt_field_username;
    // End of variables declaration//GEN-END:variables
}

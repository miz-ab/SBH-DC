package package_view;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
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
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import package_database.DatabaseManager;
import package_model.Model_Show_Basic_info;

import package_model.Model_Q10;
import package_model.Model_Q5;
import package_model.Model_Q6;
import package_model.Model_Q678;
import package_model.Model_Q9;
import package_model.Model_QT1_4;
import package_view.dialog.Dialog_box_Q10;
import static package_view.dialog.Dialog_box_Q10.list_of_air_conditionners_for_question_ten;
import package_view.dialog.Dialog_box_Q1_4;
import static package_view.dialog.Dialog_box_Q1_4.list_of_incident_for_question_four;
import static package_view.dialog.Dialog_box_Q1_4.list_of_incident_for_question_one;
import static package_view.dialog.Dialog_box_Q1_4.list_of_incident_for_question_three;
import static package_view.dialog.Dialog_box_Q1_4.list_of_incident_for_question_two;
import package_view.dialog.Dialog_box_Q5;
import static package_view.dialog.Dialog_box_Q5.list_of_genenator_info_for_question_five;
import package_view.dialog.Dialog_box_Q6;
import static package_view.dialog.Dialog_box_Q6.list_of_data_center_visitor_for_question_six;
import package_view.dialog.Dialog_box_Q6_1_Q8;
import static package_view.dialog.Dialog_box_Q6_1_Q8.list_of_description_for_question_eghit;
import static package_view.dialog.Dialog_box_Q6_1_Q8.list_of_description_for_question_seven;
import static package_view.dialog.Dialog_box_Q6_1_Q8.list_of_description_for_question_six_one;
import package_view.dialog.Dialog_box_Q9;
import static package_view.dialog.Dialog_box_Q9.list_of_ups_for_question_nine;

/**
 *
 * @author Miz
 */
public class Activity_List extends javax.swing.JFrame {

    int num_index = 1;

    private DefaultTableModel defaultTableModel;
    private final DatabaseManager db_manager;

    public static String reg_id = "";
    public static String mode = "";
    public static int q_rank = 1;
    String selected_item = "";

    public static List<Model_QT1_4> list_show_q1_4;
    public static List<Model_Q5> list_show_q5;
    public static List<Model_Q6> list_show_q6;
    public static List<Model_Q678> list_show_q678;
    public static List<Model_Q9> list_show_q9;
    public static List<Model_Q10> list_show_q10;
    public static List<Model_Show_Basic_info> list_basic_info;

    private static final Font HEADERFONT = new Font(Font.FontFamily.UNDEFINED, 14, Font.BOLD);
    private static final Font BODYFONT = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL);
    private static final Font HEADERFONT_TABLE = new Font(Font.FontFamily.COURIER, 10, Font.BOLD, new CMYKColor(0, 0, 0, 0));

    Font titleFont = FontFactory.getFont(FontFactory.HELVETICA, 18, Font.NORMAL, new CMYKColor(255, 100, 50, 0));
    Font titleFontmetadata = FontFactory.getFont(FontFactory.COURIER, 12, Font.BOLDITALIC, new CMYKColor(50, 10, 50, 100));
    Font cyan = FontFactory.getFont(FontFactory.COURIER, 12, Font.BOLD, new CMYKColor(255, 100, 10, 5));
    Font date_font = FontFactory.getFont(FontFactory.COURIER, 12, Font.BOLDITALIC);
    Font table_header = FontFactory.getFont(FontFactory.COURIER, 12, Font.BOLD, new CMYKColor(0, 230, 0, 90));

    //CURRENT_USER_INFO
    public Activity_List() {

        initComponents();
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/package_res/icon.png")).getImage());
        setLocationRelativeTo(null);

        db_manager = new DatabaseManager();
        setUpJTableModel();        
    }

    public final void setUpJTableModel() {
        defaultTableModel = new DefaultTableModel();
        Jtable_basic_info.setModel(defaultTableModel);
        defaultTableModel.addColumn("#");
        defaultTableModel.addColumn("ID");
        defaultTableModel.addColumn("Current User");
        defaultTableModel.addColumn("Recived From");
        defaultTableModel.addColumn("Deliverd To");
        defaultTableModel.addColumn("Shift");
        defaultTableModel.addColumn("Date");

        refreshTable();
    }

    private void refreshTable() {

        defaultTableModel.getDataVector().clear();

        ArrayList<Model_Show_Basic_info> data = refreshRecord();
        
        //System.out.println("data in refresh table vector " + data.size());
        Collections.reverse(data);
        data.stream().forEach((data_) -> {
            defaultTableModel.addRow(new Object[]{num_index, data_.getRegID(), data_.getCurrent_user(), data_.getRecived_from(),
                data_.getDeliverd_to(), data_.getShift(), data_.getDate()});
            num_index = num_index + 1;
            //System.out.println("counter " + num_index);
        });
        defaultTableModel.fireTableDataChanged();
    }

    private ArrayList<Model_Show_Basic_info> refreshRecord() {

        return db_manager.basic_data_to_display();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Jtable_basic_info = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        cb_target_area = new javax.swing.JComboBox<>();
        btn_home = new javax.swing.JButton();
        btn_export_to_pdf = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1182, 710));
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(32, 31, 95));

        jLabel2.setFont(new java.awt.Font("Lucida Fax", 3, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Shift-Based Handover Templet for Data Center List of Activities ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1158, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                .addContainerGap())
        );

        Jtable_basic_info.setModel(new javax.swing.table.DefaultTableModel(
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
        Jtable_basic_info.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Jtable_basic_infoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Jtable_basic_info);

        jLabel1.setText("Select Target Area");

        cb_target_area.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Incidents", "Camera", "Indoor/Outdoor AC", "Fire Extinguishers", "Power interruption", "Task performed", "Room cleanness", "Telephone line", "CENTRIC & APC UPS", "AIR CONDITIONERS" }));

        btn_home.setText("Home");
        btn_home.setPreferredSize(new java.awt.Dimension(1182, 643));
        btn_home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_homeActionPerformed(evt);
            }
        });

        btn_export_to_pdf.setText("Export to PDF");
        btn_export_to_pdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_export_to_pdfActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(cb_target_area, javax.swing.GroupLayout.Alignment.TRAILING, 0, 150, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_export_to_pdf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btn_home, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cb_target_area, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_export_to_pdf)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_home, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void Jtable_basic_infoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Jtable_basic_infoMouseClicked

        int row = Jtable_basic_info.rowAtPoint(evt.getPoint());
        reg_id = String.valueOf(Jtable_basic_info.getValueAt(row, 1));
        selected_item = String.valueOf(cb_target_area.getSelectedItem());

        list_show_q1_4 = db_manager.get_data_Table_1(reg_id);
        list_show_q5 = db_manager.get_data_Table_2(reg_id);
        list_show_q6 = db_manager.get_data_Table_3(reg_id);
        list_show_q678 = db_manager.get_data_Table_4(reg_id);
        list_show_q9 = db_manager.get_data_Table_5(reg_id);
        list_show_q10 = db_manager.get_data_Table_6(reg_id);
        list_basic_info = db_manager.get_data_Table_7(reg_id);


        switch (selected_item) {
            case "Incidents":
                mode = "show_q1";
                q_rank = 1;
                Dialog_box_Q1_4 dialog = new Dialog_box_Q1_4(this, true);
                dialog.setLocationRelativeTo(this);
                dialog.setVisible(true);
                break;
            case "Camera":
                mode = "show_q1";
                q_rank = 2;
                Dialog_box_Q1_4 dialog2 = new Dialog_box_Q1_4(this, true);
                dialog2.setLocationRelativeTo(this);
                dialog2.setVisible(true);
                break;
            case "Indoor/Outdoor AC":
                mode = "show_q1";
                q_rank = 3;
                Dialog_box_Q1_4 dialog3 = new Dialog_box_Q1_4(this, true);
                dialog3.setLocationRelativeTo(this);
                dialog3.setVisible(true);
                break;
            case "Fire Extinguishers":
                mode = "show_q1";
                q_rank = 4;
                Dialog_box_Q1_4 dialog4 = new Dialog_box_Q1_4(this, true);
                dialog4.setLocationRelativeTo(this);
                dialog4.setVisible(true);
                break;
            case "Power interruption":
                mode = "show_q5";
                Dialog_box_Q5 dialog_box_Q5 = new Dialog_box_Q5(this, true);
                dialog_box_Q5.setLocationRelativeTo(this);
                dialog_box_Q5.setVisible(true);
                break;

               /*
            case "Data Center Visitor":
                mode = "show_q6";
                Dialog_box_Q6 dialog_box_Q6 = new Dialog_box_Q6(this, true);
                dialog_box_Q6.setLocationRelativeTo(this);
                dialog_box_Q6.setVisible(true);
                break;
                */

            case "Task performed":
                mode = "show_q61";
                q_rank = 61;
                Dialog_box_Q6_1_Q8 dialog_box_Q6_1_ = new Dialog_box_Q6_1_Q8(this, true);
                dialog_box_Q6_1_.setLocationRelativeTo(this);
                dialog_box_Q6_1_.setVisible(true);
                break;

            case "Room cleanness":
                mode = "show_q61";
                q_rank = 7;
                Dialog_box_Q6_1_Q8 dialog_box_Q6_1_Q8 = new Dialog_box_Q6_1_Q8(this, true);
                dialog_box_Q6_1_Q8.setLocationRelativeTo(this);
                dialog_box_Q6_1_Q8.setVisible(true);
                break;
            case "Telephone line":
                mode = "show_q61";
                q_rank = 8;
                Dialog_box_Q6_1_Q8 dialog_box_Q6_1_Q = new Dialog_box_Q6_1_Q8(this, true);
                dialog_box_Q6_1_Q.setLocationRelativeTo(this);
                dialog_box_Q6_1_Q.setVisible(true);
                break;
            case "CENTRIC & APC UPS":
                mode = "show_q9";
                Dialog_box_Q9 Dialog_box_Q9 = new Dialog_box_Q9(this, true);
                Dialog_box_Q9.setLocationRelativeTo(this);
                Dialog_box_Q9.setVisible(true);
                break;
            case "AIR CONDITIONERS":
                mode = "show_q10";
                Dialog_box_Q10 Dialog_box_Q10 = new Dialog_box_Q10(this, true);
                Dialog_box_Q10.setLocationRelativeTo(this);
                Dialog_box_Q10.setVisible(true);
                break;
        }

    }//GEN-LAST:event_Jtable_basic_infoMouseClicked

    private void btn_homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_homeActionPerformed
        if(list_of_incident_for_question_one != null){
            list_of_incident_for_question_one = null;
        }
        
        if(list_of_incident_for_question_two != null){
            list_of_incident_for_question_two = null;
        }
        
        if(list_of_incident_for_question_three != null){
            list_of_incident_for_question_three = null;
        }
        
        if(list_of_incident_for_question_four != null){
            list_of_incident_for_question_four = null;
        }
        
        if(list_of_genenator_info_for_question_five != null){
            list_of_genenator_info_for_question_five = null;
        }
        
        if(list_of_data_center_visitor_for_question_six != null){
            list_of_data_center_visitor_for_question_six = null;
        }
        
        if(list_of_description_for_question_six_one != null){
            list_of_description_for_question_six_one = null;
        }
        
        if(list_of_description_for_question_seven != null){
            list_of_description_for_question_seven = null;
        }
        
        if(list_of_description_for_question_eghit != null){
            list_of_description_for_question_eghit = null;
        }
        
        if(list_of_ups_for_question_nine != null){
            list_of_ups_for_question_nine = null;
        }
        
        if(list_of_air_conditionners_for_question_ten != null){
            list_of_air_conditionners_for_question_ten = null;
        }
        this.dispose();
        Main_ main_ = new Main_();
        main_.setVisible(true);

        q_rank = 00;
        mode = "";
    }//GEN-LAST:event_btn_homeActionPerformed

    private void btn_export_to_pdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_export_to_pdfActionPerformed
        export_to_pdf();
    }//GEN-LAST:event_btn_export_to_pdfActionPerformed

    private void export_to_pdf() {
        String header = "Shift-Based Handover Template for Data Center Activities PDF Report";

        /*Basic info*/
        try {
            Document document = new Document();

            PdfWriter pdfwriter;
            PdfPTable pdftable;
            PdfPTable pdftable_2;

            PdfPTable pdftable_table_9;
            
            GrayColor gray = new GrayColor((float) 0.35);

            String path = "C:/SBH_DC_report_data/";
            File f = new File(path);
            if (!f.exists()) {
                f.mkdir();
            }
            String current_user = list_basic_info.get(0).getCurrent_user();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
            String timestamp = dateFormat.format(new Date());

            File file = new File(path + "/" + current_user + "_" + timestamp + ".pdf");
            pdfwriter = PdfWriter.getInstance(document, new FileOutputStream(file));

            document.open();

            Paragraph titleParagraph = new Paragraph(header, titleFont);
            titleParagraph.setAlignment(Element.ALIGN_CENTER);
            titleParagraph.setSpacingAfter(12f);
            document.add(titleParagraph);

            String id = "Registration ID : " + list_basic_info.get(0).getRegID().toUpperCase();
            String name_of_dc_officer = " Name of DC Officer : " + list_basic_info.get(0).getCurrent_user().toUpperCase();
            String recived_from = " Received From : " + list_basic_info.get(0).getRecived_from().toUpperCase();
            String deliverd_to = " Delivered to : " + list_basic_info.get(0).getDeliverd_to().toUpperCase();
            String shift = "  Shift : " + list_basic_info.get(0).getShift().toUpperCase();
            String date = " Date : " + list_basic_info.get(0).getDate();

            Paragraph pid = new Paragraph(id, titleFontmetadata);
            Paragraph pname_of_dc_officer = new Paragraph(name_of_dc_officer, titleFontmetadata);
            Paragraph precived_from = new Paragraph(recived_from, titleFontmetadata);
            Paragraph pdeliverd_to = new Paragraph(deliverd_to, titleFontmetadata);
            Paragraph pshift = new Paragraph(shift, titleFontmetadata);
            Paragraph pdate = new Paragraph(date, titleFontmetadata);
            pdate.setSpacingAfter(12f);

            pid.setAlignment(Element.ALIGN_RIGHT);
            pname_of_dc_officer.setAlignment(Element.ALIGN_RIGHT);
            precived_from.setAlignment(Element.ALIGN_RIGHT);
            pdeliverd_to.setAlignment(Element.ALIGN_RIGHT);
            pshift.setAlignment(Element.ALIGN_RIGHT);
            pdate.setAlignment(Element.ALIGN_RIGHT);

            document.add(pid);
            document.add(pname_of_dc_officer);
            document.add(precived_from);
            document.add(pdeliverd_to);
            document.add(pshift);
            document.add(pdate);

            /*Question 1*/
            String question_1 = "1. Was there any major /critical/ incident/s on any of the DC systems?";
            Paragraph q1 = new Paragraph(question_1, cyan);
            document.add(q1);
            q1.setSpacingAfter(12f);

            String q1_des = " Severity : ".toUpperCase() + list_show_q1_4.get(0).getSSQ1();
            String q1_des_ = " Issue Description : ".toUpperCase() + list_show_q1_4.get(0).getISQ1();

            Paragraph q1_des_p = new Paragraph(q1_des, BODYFONT);
            Paragraph q1_des_p_ = new Paragraph(q1_des_, BODYFONT);
            document.add(q1_des_p);
            document.add(q1_des_p_);

            String question_2 = "2. Was there any problem with the LCD display or camera system?";
            Paragraph q2 = new Paragraph(question_2, cyan);
            document.add(q2);
            q2.setSpacingAfter(12f);

            String q2_des = " Severity : ".toUpperCase() + list_show_q1_4.get(0).getSSQ2();
            String q2_des_ = " Issue Description : ".toUpperCase() + list_show_q1_4.get(0).getISQ2();

            Paragraph q2_des_p = new Paragraph(q2_des, BODYFONT);
            Paragraph q2_des_p_ = new Paragraph(q2_des_, BODYFONT);
            document.add(q2_des_p);
            document.add(q2_des_p_);

            String question_3 = "3. Is there any problem or alarm with AC systems?";
            Paragraph q3 = new Paragraph(question_3, cyan);
            document.add(q3);
            q3.setSpacingAfter(12f);

            String q3_des = " Severity : ".toUpperCase() + list_show_q1_4.get(0).getSSQ3();
            String q3_des_ = " Issue Description : ".toUpperCase() + list_show_q1_4.get(0).getISQ3();

            Paragraph q3_des_p = new Paragraph(q3_des, BODYFONT);
            Paragraph q3_des_p_ = new Paragraph(q3_des_, BODYFONT);
            document.add(q3_des_p);
            document.add(q3_des_p_);

            String question_4 = "4. Are all fire control system Normal ?";
            Paragraph q4 = new Paragraph(question_4, cyan);
            document.add(q4);
            q4.setSpacingAfter(12f);

            String q4_des = " Severity : ".toUpperCase() + list_show_q1_4.get(0).getSSQ4();
            String q4_des_ = " Issue Description : ".toUpperCase() + list_show_q1_4.get(0).getISQ4();

            Paragraph q4_des_p = new Paragraph(q4_des, BODYFONT);
            Paragraph q4_des_p_ = new Paragraph(q4_des_, BODYFONT);
            document.add(q4_des_p);
            document.add(q4_des_p_);

            String question_5 = "5. Was there any power interruption?";
            Paragraph q5 = new Paragraph(question_5, cyan);
            document.add(q5);
            q5.setSpacingAfter(12f);

            String q5_des_time = " If yes specify time: ".toUpperCase() + list_show_q5.get(0).getTime_();
            String q5_des_gen_oprated_normally = " Were the generators operating normally? ".toUpperCase() + list_show_q5.get(0).getGenenetor_oprated_normally();
            String q5_description = " If yes/No, please describe it. ".toUpperCase() + list_show_q5.get(0).getGenenetor_status_description();
            String q5_des_fule = " Is there enough fuel for 24hours of non stop operation? ".toUpperCase() + list_show_q5.get(0).getIs_there_any_fule_for_24h();

            Paragraph q5_time = new Paragraph(q5_des_time, BODYFONT);
            document.add(q5_time);
            Paragraph q5_gen = new Paragraph(q5_des_gen_oprated_normally, BODYFONT);
            document.add(q5_gen);
            Paragraph q5_des = new Paragraph(q5_description, BODYFONT);
            document.add(q5_des);
            Paragraph q5_fule = new Paragraph(q5_des_fule, BODYFONT);
            document.add(q5_fule);

            String question_6 = "6. Did anyone who came to the data center or / store?";
            Paragraph q6 = new Paragraph(question_6, cyan);
            document.add(q6);
            q6.setSpacingAfter(12f);
                
            for(int i = 0; i < list_show_q6.size(); i++){
            String q6_visitor_name = " Visitor Name : " + list_show_q6.get(i).getVisitor_name();
            String q6_means_auth = " Means of authorization: " + list_show_q6.get(i).getMeanse_of_auth();
            String q6_purpose = " Purpose of the visitor : " + list_show_q6.get(i).getPurpose_of_the_visitor();

            Paragraph q6_v_name = new Paragraph(q6_visitor_name, BODYFONT);
            document.add(q6_v_name);
            Paragraph q6_auth = new Paragraph(q6_means_auth, BODYFONT);
            document.add(q6_auth);
            Paragraph q6_purpose_ = new Paragraph(q6_purpose, BODYFONT);
            document.add(q6_purpose_);
            
            Paragraph line_ = new Paragraph("-----------------------------------------------", BODYFONT);
            document.add(line_);
            }

            String question_61 = "6.1 Is there any task performed during your shift ?";
            Paragraph q61 = new Paragraph(question_61, cyan);
            document.add(q61);
            q61.setSpacingAfter(12f);
            

            String q61_des = " Description : " + list_show_q678.get(0).getDes6();
            Paragraph q6_des_ = new Paragraph(q61_des, BODYFONT);
            document.add(q6_des_);

            String question_7 = "7. Are all the rooms clean and neat?  If not please mention the reson.";
            Paragraph q7 = new Paragraph(question_7, cyan);
            document.add(q7);
            q7.setSpacingAfter(12f);

            String q7_des = " Description : " + list_show_q678.get(0).getDes7();
            Paragraph q7_des_ = new Paragraph(q7_des, BODYFONT);
            document.add(q7_des_);

            String question_8 = "8. Is the telephone line working?";
            Paragraph q8 = new Paragraph(question_8, cyan);
            document.add(q8);
            q8.setSpacingAfter(12f);

            String q8_des = " Description : " + list_show_q678.get(0).getDes8();
            Paragraph q8_des_ = new Paragraph(q8_des, BODYFONT);
            document.add(q8_des_);

            String question_9 = "9. CENTRIC UPS  and APC UPS  Charge, Load and Runtime";
            Paragraph q9 = new Paragraph(question_9, cyan);
            document.add(q9);
            q9.setSpacingAfter(12f);

            /*Q 9 Centric ups */
            Paragraph q9_centric_ups = new Paragraph("CENTRIC UPS", date_font);
            q9_centric_ups.setAlignment(Element.ALIGN_CENTER);
            document.add(q9_centric_ups);

            pdftable_table_9 = new PdfPTable(4);
            pdftable_table_9.setWidthPercentage(100);
            pdftable_table_9.setSpacingBefore(10f);
            pdftable_table_9.setSpacingAfter(10f);

            PdfPCell cell_power = new PdfPCell(new Phrase("Power", HEADERFONT_TABLE));
            PdfPCell cell_l1 = new PdfPCell(new Phrase("L1", HEADERFONT_TABLE));
            PdfPCell cell_l2 = new PdfPCell(new Phrase("L2", HEADERFONT_TABLE));
            PdfPCell cell_l3 = new PdfPCell(new Phrase("L3", HEADERFONT_TABLE));

            cell_l1.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell_l2.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell_l3.setHorizontalAlignment(Element.ALIGN_CENTER);

            cell_power.setBackgroundColor(gray);
            cell_l1.setBackgroundColor(gray);
            cell_l2.setBackgroundColor(gray);
            cell_l3.setBackgroundColor(gray);

            pdftable_table_9.addCell(cell_power);
            pdftable_table_9.addCell(cell_l1);
            pdftable_table_9.addCell(cell_l2);
            pdftable_table_9.addCell(cell_l3);

            PdfPCell cell_data_ups_charge = new PdfPCell(new Phrase("Ups charge(%)", HEADERFONT_TABLE));
            PdfPCell cell_data_l1 = new PdfPCell(new Phrase(list_show_q9.get(0).getTxt_field_L_1_Q9_ups_charge_centric_ups()));
            PdfPCell cell_data_l2 = new PdfPCell(new Phrase(list_show_q9.get(0).getTxt_field_L_2_Q9_ups_charge_centric_ups()));
            PdfPCell cell_data_l3 = new PdfPCell(new Phrase(list_show_q9.get(0).getTxt_field_L_3_Q9_ups_charge_centric_ups()));

            cell_data_l1.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell_data_l2.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell_data_l3.setHorizontalAlignment(Element.ALIGN_CENTER);

            PdfPCell cell_data_ups_load = new PdfPCell(new Phrase("Ups Load(%)", HEADERFONT_TABLE));
            PdfPCell cell_data_l1_load = new PdfPCell(new Phrase(list_show_q9.get(0).getTxt_field_L_1_Q9_ups_load_centric_ups()));
            PdfPCell cell_data_l2_load = new PdfPCell(new Phrase(list_show_q9.get(0).getTxt_field_L_2_Q9_ups_load_centric_ups()));
            PdfPCell cell_data_l3_load = new PdfPCell(new Phrase(list_show_q9.get(0).getTxt_field_L_3_Q9_ups_load_centric_ups()));

            cell_data_l1_load.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell_data_l2_load.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell_data_l3_load.setHorizontalAlignment(Element.ALIGN_CENTER);

            cell_data_ups_charge.setBackgroundColor(gray);
            cell_data_ups_load.setBackgroundColor(gray);

            pdftable_table_9.addCell(cell_data_ups_charge);
            pdftable_table_9.addCell(cell_data_l1);
            pdftable_table_9.addCell(cell_data_l2);
            pdftable_table_9.addCell(cell_data_l3);

            pdftable_table_9.addCell(cell_data_ups_load);
            pdftable_table_9.addCell(cell_data_l1_load);
            pdftable_table_9.addCell(cell_data_l2_load);
            pdftable_table_9.addCell(cell_data_l3_load);

            pdftable_table_9.completeRow();

            PdfPCell cell_runtime = new PdfPCell(new Phrase("Runtime (Hr)", HEADERFONT_TABLE));
            cell_runtime.setBackgroundColor(gray);
            pdftable_table_9.addCell(cell_runtime);
            PdfPCell cell_runtime_value = new PdfPCell(new Phrase(list_show_q9.get(0).getTxt_field_L_123_Q9_runtime_centric_ups()));
            cell_runtime_value.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell_runtime_value.setColspan(3);
            pdftable_table_9.addCell(cell_runtime_value);
            pdftable_table_9.completeRow();

            document.add(pdftable_table_9);
            
            /*
             end of Centric UPS
             */
            
            /* --- APC UPS ---*/
            APC_UPS(document);
            
            /* --- end of APC UPS ---*/
            
            String question_10 = "10. Air Conditioners Information";
            Paragraph q10 = new Paragraph(question_10, cyan);
            document.add(q10);
            q10.setSpacingAfter(12f);

            pdftable = new PdfPTable(7);
            pdftable.setWidthPercentage(100);
            pdftable.setSpacingBefore(10f);
            pdftable.setSpacingAfter(10f);

            float[] colWidth = {1f, 1f, 1f, 1f, 1f, 1f, 1f};
            pdftable.setWidths(colWidth);

            PdfPCell pdfpcel = new PdfPCell(new Paragraph("ACRD 602 INROW 1", HEADERFONT_TABLE));
            pdfpcel.setHorizontalAlignment(Element.ALIGN_CENTER);
            pdfpcel.setVerticalAlignment(Element.ALIGN_MIDDLE);
            pdfpcel.setBackgroundColor(gray);

            PdfPCell pdfpce2 = new PdfPCell(new Paragraph("ACRD 102 INROW 2", HEADERFONT_TABLE));
            pdfpce2.setHorizontalAlignment(Element.ALIGN_CENTER);
            pdfpce2.setVerticalAlignment(Element.ALIGN_MIDDLE);
            pdfpce2.setBackgroundColor(gray);

            PdfPCell pdfpce3 = new PdfPCell(new Paragraph("ACRD 102 INROW 3", HEADERFONT_TABLE));
            pdfpce3.setHorizontalAlignment(Element.ALIGN_CENTER);
            pdfpce3.setVerticalAlignment(Element.ALIGN_MIDDLE);
            pdfpce3.setBackgroundColor(gray);

            PdfPCell pdfpce4 = new PdfPCell(new Paragraph("ACRD 102 INROW 4", HEADERFONT_TABLE));
            pdfpce4.setHorizontalAlignment(Element.ALIGN_CENTER);
            pdfpce4.setVerticalAlignment(Element.ALIGN_MIDDLE);
            pdfpce4.setBackgroundColor(gray);

            PdfPCell pdfpce5 = new PdfPCell(new Paragraph("ACRD 602 INROW 5", HEADERFONT_TABLE));
            pdfpce5.setHorizontalAlignment(Element.ALIGN_CENTER);
            pdfpce5.setVerticalAlignment(Element.ALIGN_MIDDLE);
            pdfpce5.setBackgroundColor(gray);

            PdfPCell pdfpce6 = new PdfPCell(new Paragraph("GREE F201", HEADERFONT_TABLE));
            pdfpce6.setHorizontalAlignment(Element.ALIGN_CENTER);
            pdfpce6.setVerticalAlignment(Element.ALIGN_MIDDLE);
            pdfpce6.setBackgroundColor(gray);

            PdfPCell pdfpce7 = new PdfPCell(new Paragraph("CARRIER F205", HEADERFONT_TABLE));
            pdfpce7.setHorizontalAlignment(Element.ALIGN_CENTER);
            pdfpce7.setVerticalAlignment(Element.ALIGN_MIDDLE);
            pdfpce7.setBackgroundColor(gray);

            pdftable.addCell(pdfpcel);
            pdftable.addCell(pdfpce2);
            pdftable.addCell(pdfpce3);
            pdftable.addCell(pdfpce4);
            pdftable.addCell(pdfpce5);
            pdftable.addCell(pdfpce6);
            pdftable.addCell(pdfpce7);

            for (int i = 0; i < list_show_q10.size(); i++) {
                PdfPCell cell1 = new PdfPCell(new Paragraph(list_show_q10.get(i).getACRD_602_INROW_1(), BODYFONT));
                cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
                pdftable.addCell(cell1);

                PdfPCell cell2 = new PdfPCell(new Paragraph(list_show_q10.get(i).getACRP_102_INROW_2(), BODYFONT));
                cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
                pdftable.addCell(cell2);

                PdfPCell cell3 = new PdfPCell(new Paragraph(list_show_q10.get(i).getACRP_102_INROW_3(), BODYFONT));
                cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);
                pdftable.addCell(cell3);

                PdfPCell cell4 = new PdfPCell(new Paragraph(list_show_q10.get(i).getACRP_102_INROW_4(), BODYFONT));
                cell4.setVerticalAlignment(Element.ALIGN_MIDDLE);
                pdftable.addCell(cell4);

                PdfPCell cell5 = new PdfPCell(new Paragraph(list_show_q10.get(i).getACRP_102_INROW_5(), BODYFONT));
                cell5.setVerticalAlignment(Element.ALIGN_MIDDLE);
                pdftable.addCell(cell5);

                PdfPCell cell6 = new PdfPCell(new Paragraph(list_show_q10.get(i).getCARRIER_F201(), BODYFONT));
                cell6.setVerticalAlignment(Element.ALIGN_MIDDLE);
                pdftable.addCell(cell6);

                PdfPCell cell7 = new PdfPCell(new Paragraph(list_show_q10.get(i).getCARRIER_F205(), BODYFONT));
                cell7.setVerticalAlignment(Element.ALIGN_MIDDLE);
                pdftable.addCell(cell7);
            }

            //second section of the table 
            pdftable_2 = new PdfPTable(7);
            pdftable_2.setWidthPercentage(100);
            pdftable_2.setSpacingBefore(10f);
            pdftable_2.setSpacingAfter(10f);

            float[] colWidth_2 = {1f, 1f, 1f, 1f, 1f, 1f, 1f};
            pdftable_2.setWidths(colWidth_2);

            PdfPCell pdfpcel_2 = new PdfPCell(new Paragraph("ROYAL F202", HEADERFONT_TABLE));
            pdfpcel_2.setHorizontalAlignment(Element.ALIGN_CENTER);
            pdfpcel_2.setVerticalAlignment(Element.ALIGN_MIDDLE);
            pdfpcel_2.setBackgroundColor(gray);

            PdfPCell pdfpce2_2 = new PdfPCell(new Paragraph("GREE F203", HEADERFONT_TABLE));
            pdfpce2_2.setHorizontalAlignment(Element.ALIGN_CENTER);
            pdfpce2_2.setVerticalAlignment(Element.ALIGN_MIDDLE);
            pdfpce2_2.setBackgroundColor(gray);

            PdfPCell pdfpce3_2 = new PdfPCell(new Paragraph("INVENTOR F204", HEADERFONT_TABLE));
            pdfpce3_2.setHorizontalAlignment(Element.ALIGN_CENTER);
            pdfpce3_2.setVerticalAlignment(Element.ALIGN_MIDDLE);
            pdfpce3_2.setBackgroundColor(gray);

            PdfPCell pdfpce4_2 = new PdfPCell(new Paragraph("INVENTOR 1", HEADERFONT_TABLE));
            pdfpce4_2.setHorizontalAlignment(Element.ALIGN_CENTER);
            pdfpce4_2.setVerticalAlignment(Element.ALIGN_MIDDLE);
            pdfpce4_2.setBackgroundColor(gray);

            PdfPCell pdfpce5_2 = new PdfPCell(new Paragraph("INVENTOR 2", HEADERFONT_TABLE));
            pdfpce5_2.setHorizontalAlignment(Element.ALIGN_CENTER);
            pdfpce5_2.setVerticalAlignment(Element.ALIGN_MIDDLE);
            pdfpce5_2.setBackgroundColor(gray);

            PdfPCell pdfpce6_2 = new PdfPCell(new Paragraph("INVENTOR 3", HEADERFONT_TABLE));
            pdfpce6_2.setHorizontalAlignment(Element.ALIGN_CENTER);
            pdfpce6_2.setVerticalAlignment(Element.ALIGN_MIDDLE);
            pdfpce6_2.setBackgroundColor(gray);

            PdfPCell pdfpce7_2 = new PdfPCell(new Paragraph("INVENTOR 4", HEADERFONT_TABLE));
            pdfpce7_2.setHorizontalAlignment(Element.ALIGN_CENTER);
            pdfpce7_2.setVerticalAlignment(Element.ALIGN_MIDDLE);
            pdfpce7_2.setBackgroundColor(gray);

            pdftable_2.addCell(pdfpcel_2);
            pdftable_2.addCell(pdfpce2_2);
            pdftable_2.addCell(pdfpce3_2);
            pdftable_2.addCell(pdfpce4_2);
            pdftable_2.addCell(pdfpce5_2);
            pdftable_2.addCell(pdfpce6_2);
            pdftable_2.addCell(pdfpce7_2);

            for (int i = 0; i < list_show_q10.size(); i++) {
                PdfPCell cell1 = new PdfPCell(new Paragraph(list_show_q10.get(i).getROYAL_F202(), BODYFONT));
                cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
                pdftable_2.addCell(cell1);

                PdfPCell cell2 = new PdfPCell(new Paragraph(list_show_q10.get(i).getROYAL_F203(), BODYFONT));
                cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
                pdftable_2.addCell(cell2);

                PdfPCell cell3 = new PdfPCell(new Paragraph(list_show_q10.get(i).getLG_F204(), BODYFONT));
                cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);
                pdftable_2.addCell(cell3);

                PdfPCell cell4 = new PdfPCell(new Paragraph(list_show_q10.get(i).getInventor_1(), BODYFONT));
                cell4.setVerticalAlignment(Element.ALIGN_MIDDLE);
                pdftable_2.addCell(cell4);

                PdfPCell cell5 = new PdfPCell(new Paragraph(list_show_q10.get(i).getInventor_2(), BODYFONT));
                cell5.setVerticalAlignment(Element.ALIGN_MIDDLE);
                pdftable_2.addCell(cell5);

                PdfPCell cell6 = new PdfPCell(new Paragraph(list_show_q10.get(i).getInventor_3(), BODYFONT));
                cell6.setVerticalAlignment(Element.ALIGN_MIDDLE);
                pdftable_2.addCell(cell6);

                PdfPCell cell7 = new PdfPCell(new Paragraph(list_show_q10.get(i).getInventor_4(), BODYFONT));
                cell7.setVerticalAlignment(Element.ALIGN_MIDDLE);
                pdftable_2.addCell(cell7);
            }

            Paragraph dateParagraph = new Paragraph("Generated on : " + timestamp, date_font);
            dateParagraph.setAlignment(Element.ALIGN_RIGHT);
            dateParagraph.setSpacingAfter(12f);

            document.add(pdftable);
            document.add(pdftable_2);
            document.add(dateParagraph);//report date 
            document.close();
            pdfwriter.close();
            JOptionPane.showMessageDialog(this, "Report Generated Successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);

        } catch (DocumentException | FileNotFoundException ex) {
            Logger.getLogger(Activity_List.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    private void APC_UPS(Document document){
          try{
              
            PdfPTable pdftable_table_9a;
            GrayColor gray = new GrayColor((float) 0.35);
            Paragraph q9_centric_ups = new Paragraph("APC UPS", date_font);
            q9_centric_ups.setAlignment(Element.ALIGN_CENTER);
            document.add(q9_centric_ups);

            pdftable_table_9a = new PdfPTable(4);
            pdftable_table_9a.setWidthPercentage(100);
            pdftable_table_9a.setSpacingBefore(10f);
            pdftable_table_9a.setSpacingAfter(10f);

            PdfPCell cell_power = new PdfPCell(new Phrase("Power", HEADERFONT_TABLE));
            PdfPCell cell_l1 = new PdfPCell(new Phrase("L1", HEADERFONT_TABLE));
            PdfPCell cell_l2 = new PdfPCell(new Phrase("L2", HEADERFONT_TABLE));
            PdfPCell cell_l3 = new PdfPCell(new Phrase("L3", HEADERFONT_TABLE));

            cell_l1.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell_l2.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell_l3.setHorizontalAlignment(Element.ALIGN_CENTER);

            cell_power.setBackgroundColor(gray);
            cell_l1.setBackgroundColor(gray);
            cell_l2.setBackgroundColor(gray);
            cell_l3.setBackgroundColor(gray);

            pdftable_table_9a.addCell(cell_power);
            pdftable_table_9a.addCell(cell_l1);
            pdftable_table_9a.addCell(cell_l2);
            pdftable_table_9a.addCell(cell_l3);

            PdfPCell cell_data_ups_charge = new PdfPCell(new Phrase("Ups charge(%)", HEADERFONT_TABLE));
            PdfPCell cell_data_l1 = new PdfPCell(new Phrase(list_show_q9.get(0).getTxt_field_L_1_Q9_ups_charge_apc_ups()));
            PdfPCell cell_data_l2 = new PdfPCell(new Phrase(list_show_q9.get(0).getTxt_field_L_2_Q9_ups_charge_apc_ups()));
            PdfPCell cell_data_l3 = new PdfPCell(new Phrase(list_show_q9.get(0).getTxt_field_L_3_Q9_ups_charge_apc_ups()));

            cell_data_l1.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell_data_l2.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell_data_l3.setHorizontalAlignment(Element.ALIGN_CENTER);

            PdfPCell cell_data_ups_load = new PdfPCell(new Phrase("Ups Load(%)", HEADERFONT_TABLE));
            PdfPCell cell_data_l1_load = new PdfPCell(new Phrase(list_show_q9.get(0).getTxt_field_L_1_Q9_ups_load_apc_ups()));
            PdfPCell cell_data_l2_load = new PdfPCell(new Phrase(list_show_q9.get(0).getTxt_field_L_2_Q9_ups_load_apc_ups()));
            PdfPCell cell_data_l3_load = new PdfPCell(new Phrase(list_show_q9.get(0).getTxt_field_L_3_Q9_ups_load_apc_ups()));

            cell_data_l1_load.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell_data_l2_load.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell_data_l3_load.setHorizontalAlignment(Element.ALIGN_CENTER);

            cell_data_ups_charge.setBackgroundColor(gray);
            cell_data_ups_load.setBackgroundColor(gray);

            pdftable_table_9a.addCell(cell_data_ups_charge);
            pdftable_table_9a.addCell(cell_data_l1);
            pdftable_table_9a.addCell(cell_data_l2);
            pdftable_table_9a.addCell(cell_data_l3);

            pdftable_table_9a.addCell(cell_data_ups_load);
            pdftable_table_9a.addCell(cell_data_l1_load);
            pdftable_table_9a.addCell(cell_data_l2_load);
            pdftable_table_9a.addCell(cell_data_l3_load);

            pdftable_table_9a.completeRow();

            PdfPCell cell_runtime = new PdfPCell(new Phrase("Runtime (Hr)", HEADERFONT_TABLE));
            cell_runtime.setBackgroundColor(gray);
            pdftable_table_9a.addCell(cell_runtime);
            PdfPCell cell_runtime_value = new PdfPCell(new Phrase(list_show_q9.get(0).getTxt_field_L_123_Q9_runtime_apc_ups()));
            cell_runtime_value.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell_runtime_value.setColspan(3);
            pdftable_table_9a.addCell(cell_runtime_value);
            pdftable_table_9a.completeRow();

            document.add(pdftable_table_9a);
             } catch (DocumentException ex) {
            Logger.getLogger(Activity_List.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Jtable_basic_info;
    private javax.swing.JButton btn_export_to_pdf;
    private javax.swing.JButton btn_home;
    private javax.swing.JComboBox<String> cb_target_area;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}

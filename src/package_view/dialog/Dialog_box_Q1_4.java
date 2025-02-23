/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package_view.dialog;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import package_model.Model_Q1_4;
import static package_view.Activity_List.list_show_q1_4;
import static package_view.Activity_List.mode;
import static package_view.Activity_List.q_rank;
import static package_view.Main_.Question_index_indicator;

/**
 *
 * @author Miz
 */
public class Dialog_box_Q1_4 extends javax.swing.JDialog {

    public static List<Model_Q1_4> list_of_incident_for_question_one;
    public static List<Model_Q1_4> list_of_incident_for_question_two;
    public static List<Model_Q1_4> list_of_incident_for_question_three;
    public static List<Model_Q1_4> list_of_incident_for_question_four;

    /**
     * Creates new form Q1_Incidents
     */
    String q_status_incident;
    String q_txt_area_incident_description;

    enum Severity {
        Critical, Majour, Minor
    }

    String Header_Based_on_Number[] = {"", "Incidents", "Camera", "Indoor/Outdoor AC", "Fire Extinguishers"};

    public Dialog_box_Q1_4(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        /* if question indicator indicate for question number one and object of the list_incident for question one is not null */
        if ((list_of_incident_for_question_one != null) && (Question_index_indicator == 1)) {
            lbl_Q1_Q5_dialog_header.setText(Header_Based_on_Number[1]);
            q_status_incident = String.valueOf(list_of_incident_for_question_one.get(0).getSeverity_status());
            q_txt_area_incident_description = list_of_incident_for_question_one.get(0).getIncident_description();
            txt_area_incident_description.setText(q_txt_area_incident_description);

            switch (q_status_incident) {

                case "Critical":
                    r_b_incident_critical.setSelected(true);
                    break;
                case "Majour":
                    r_b_incident_major.setSelected(true);
                    break;
                case "Minor":
                    r_b_incident_minor.setSelected(true);
            }
        } else if ((list_of_incident_for_question_one == null) && (Question_index_indicator == 1)) {
            lbl_Q1_Q5_dialog_header.setText(Header_Based_on_Number[1]);
            r_b_incident_minor.setSelected(true);
            q_status_incident = String.valueOf(Severity.Minor);
        }/*end of else if for question one */

 /*for question two if question indicator is 2 and list of incident for question two object is not null */

        if ((list_of_incident_for_question_two != null) && (Question_index_indicator == 2)) {
            lbl_Q1_Q5_dialog_header.setText(Header_Based_on_Number[2]);
            q_status_incident = String.valueOf(list_of_incident_for_question_two.get(0).getSeverity_status());
            q_txt_area_incident_description = list_of_incident_for_question_two.get(0).getIncident_description();
            txt_area_incident_description.setText(q_txt_area_incident_description);

            switch (q_status_incident) {

                case "Critical":
                    r_b_incident_critical.setSelected(true);
                    break;
                case "Majour":
                    r_b_incident_major.setSelected(true);
                    break;
                case "Minor":
                    r_b_incident_minor.setSelected(true);
            }
        } else if ((list_of_incident_for_question_two == null) && (Question_index_indicator == 2)) {
            lbl_Q1_Q5_dialog_header.setText(Header_Based_on_Number[2]);
            r_b_incident_minor.setSelected(true);
            q_status_incident = String.valueOf(Severity.Minor);
        }/* end of if else for Q 2*/


 /* if question indicator indicate for question number_three and object of the list_incident for question three is not null */
        if ((list_of_incident_for_question_three != null) && (Question_index_indicator == 3)) {
            lbl_Q1_Q5_dialog_header.setText(Header_Based_on_Number[3]);
            q_status_incident = String.valueOf(list_of_incident_for_question_three.get(0).getSeverity_status());
            q_txt_area_incident_description = list_of_incident_for_question_three.get(0).getIncident_description();
            txt_area_incident_description.setText(q_txt_area_incident_description);

            switch (q_status_incident) {

                case "Critical":
                    r_b_incident_critical.setSelected(true);
                    break;
                case "Majour":
                    r_b_incident_major.setSelected(true);
                    break;
                case "Minor":
                    r_b_incident_minor.setSelected(true);
            }
        } else if ((list_of_incident_for_question_three == null) && (Question_index_indicator == 3)) {
            lbl_Q1_Q5_dialog_header.setText(Header_Based_on_Number[3]);
            r_b_incident_minor.setSelected(true);
            q_status_incident = String.valueOf(Severity.Minor);
        }/*end of else if for question Q 3 */

 /* if question indicator indicate for question number one and object of the list_incident for question one is not null */
        if ((list_of_incident_for_question_four != null) && (Question_index_indicator == 4)) {
            lbl_Q1_Q5_dialog_header.setText(Header_Based_on_Number[4]);
            q_status_incident = String.valueOf(list_of_incident_for_question_four.get(0).getSeverity_status());
            q_txt_area_incident_description = list_of_incident_for_question_four.get(0).getIncident_description();
            txt_area_incident_description.setText(q_txt_area_incident_description);

            switch (q_status_incident) {

                case "Critical":
                    r_b_incident_critical.setSelected(true);
                    break;
                case "Majour":
                    r_b_incident_major.setSelected(true);
                    break;
                case "Minor":
                    r_b_incident_minor.setSelected(true);
            }
        } else if ((list_of_incident_for_question_four == null) && (Question_index_indicator == 4)) {
            lbl_Q1_Q5_dialog_header.setText(Header_Based_on_Number[4]);
            r_b_incident_minor.setSelected(true);
            q_status_incident = String.valueOf(Severity.Minor);
        }/*end of else if for question one */

        if (mode.endsWith("show_q1")) {
            switch (q_rank) {
                case 1:
                    lbl_Q1_Q5_dialog_header.setText(Header_Based_on_Number[1]);
                    txt_area_incident_description.setText(list_show_q1_4.get(0).getISQ1());

                    switch (list_show_q1_4.get(0).getSSQ1()) {
                        case "Critical":
                            r_b_incident_critical.setSelected(true);
                            break;
                        case "Majour":
                            r_b_incident_major.setSelected(true);
                            break;
                        case "Minor":
                            r_b_incident_minor.setSelected(true);
                    }

                    break;
                case 2:
                    lbl_Q1_Q5_dialog_header.setText(Header_Based_on_Number[2]);
                    txt_area_incident_description.setText(list_show_q1_4.get(0).getISQ2());

                    switch (list_show_q1_4.get(0).getSSQ2()) {
                        case "Critical":
                            r_b_incident_critical.setSelected(true);
                            break;
                        case "Majour":
                            r_b_incident_major.setSelected(true);
                            break;
                        case "Minor":
                            r_b_incident_minor.setSelected(true);
                    }
                    break;
                case 3:
                    lbl_Q1_Q5_dialog_header.setText(Header_Based_on_Number[3]);
                    txt_area_incident_description.setText(list_show_q1_4.get(0).getISQ3());

                    switch (list_show_q1_4.get(0).getSSQ3()) {
                        case "Critical":
                            r_b_incident_critical.setSelected(true);
                            break;
                        case "Majour":
                            r_b_incident_major.setSelected(true);
                            break;
                        case "Minor":
                            r_b_incident_minor.setSelected(true);
                    }
                    break;
                case 4:
                    lbl_Q1_Q5_dialog_header.setText(Header_Based_on_Number[4]);
                    txt_area_incident_description.setText(list_show_q1_4.get(0).getISQ4());

                    switch (list_show_q1_4.get(0).getSSQ4()) {
                        case "Critical":
                            r_b_incident_critical.setSelected(true);
                            break;
                        case "Majour":
                            r_b_incident_major.setSelected(true);
                            break;
                        case "Minor":
                            r_b_incident_minor.setSelected(true);
                    }
                    break;
            }

            btn_save.setVisible(false);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        r_g_incident_dialog = new javax.swing.ButtonGroup();
        jLabel2 = new javax.swing.JLabel();
        r_b_incident_critical = new javax.swing.JRadioButton();
        r_b_incident_major = new javax.swing.JRadioButton();
        r_b_incident_minor = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_area_incident_description = new javax.swing.JTextArea();
        btn_save = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lbl_Q1_Q5_dialog_header = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel2.setText("Severity :");

        r_g_incident_dialog.add(r_b_incident_critical);
        r_b_incident_critical.setText("Critical ");
        r_b_incident_critical.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r_b_incident_criticalActionPerformed(evt);
            }
        });

        r_g_incident_dialog.add(r_b_incident_major);
        r_b_incident_major.setText("Majour");
        r_b_incident_major.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r_b_incident_majorActionPerformed(evt);
            }
        });

        r_g_incident_dialog.add(r_b_incident_minor);
        r_b_incident_minor.setText("Minor");
        r_b_incident_minor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r_b_incident_minorActionPerformed(evt);
            }
        });

        jLabel3.setText("Issue Description :");

        txt_area_incident_description.setColumns(20);
        txt_area_incident_description.setRows(5);
        jScrollPane1.setViewportView(txt_area_incident_description);

        btn_save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/package_res/add_new.png"))); // NOI18N
        btn_save.setText("Save");
        btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(32, 31, 95));

        lbl_Q1_Q5_dialog_header.setBackground(new java.awt.Color(0, 51, 51));
        lbl_Q1_Q5_dialog_header.setFont(new java.awt.Font("Lucida Fax", 3, 18)); // NOI18N
        lbl_Q1_Q5_dialog_header.setForeground(new java.awt.Color(255, 255, 255));
        lbl_Q1_Q5_dialog_header.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_Q1_Q5_dialog_header.setText("Incidents");
        lbl_Q1_Q5_dialog_header.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_Q1_Q5_dialog_header, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_Q1_Q5_dialog_header, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(r_b_incident_critical)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(r_b_incident_major)
                        .addGap(18, 18, 18)
                        .addComponent(r_b_incident_minor))
                    .addComponent(jScrollPane1)
                    .addComponent(btn_save))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r_b_incident_critical)
                    .addComponent(r_b_incident_major)
                    .addComponent(r_b_incident_minor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_save)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void r_b_incident_criticalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r_b_incident_criticalActionPerformed
        if (r_b_incident_critical.isSelected()) {
            q_status_incident = String.valueOf(Severity.Critical);
        }
    }//GEN-LAST:event_r_b_incident_criticalActionPerformed

    private void r_b_incident_majorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r_b_incident_majorActionPerformed
        if (r_b_incident_major.isSelected()) {
            q_status_incident = String.valueOf(Severity.Majour);
        }
    }//GEN-LAST:event_r_b_incident_majorActionPerformed

    private void r_b_incident_minorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r_b_incident_minorActionPerformed
        if (r_b_incident_minor.isSelected()) {
            q_status_incident = String.valueOf(Severity.Minor);
        }
    }//GEN-LAST:event_r_b_incident_minorActionPerformed

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
        if (txt_area_incident_description.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please Fill all the Input Field", "Error!", JOptionPane.ERROR_MESSAGE);
        } else {
            q_txt_area_incident_description = txt_area_incident_description.getText();
            Model_Q1_4 model = new Model_Q1_4(q_status_incident, q_txt_area_incident_description);
            switch (Question_index_indicator) {
                case 1:
                    list_of_incident_for_question_one = new ArrayList<>();
                    if (list_of_incident_for_question_one.size() > 0) {
                        list_of_incident_for_question_one.removeAll(list_of_incident_for_question_one);
                    }
                    list_of_incident_for_question_one.add(model);
                    break;
                case 2:
                    list_of_incident_for_question_two = new ArrayList<>();
                    if (list_of_incident_for_question_two.size() > 0) {
                        list_of_incident_for_question_two.removeAll(list_of_incident_for_question_two);
                    }
                    list_of_incident_for_question_two.add(model);
                    break;
                case 3:
                    list_of_incident_for_question_three = new ArrayList<>();
                    if (list_of_incident_for_question_three.size() > 0) {
                        list_of_incident_for_question_three.removeAll(list_of_incident_for_question_three);
                    }
                    list_of_incident_for_question_three.add(model);
                    break;
                case 4:
                    list_of_incident_for_question_four = new ArrayList<>();
                    if (list_of_incident_for_question_four.size() > 0) {
                        list_of_incident_for_question_four.removeAll(list_of_incident_for_question_four);
                    }
                    list_of_incident_for_question_four.add(model);
                    break;
                case 5:
                    break;
            }

            this.dispose();
        }

    }//GEN-LAST:event_btn_saveActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

        /*System.out.println("Win closing event excuted ");
            Model_Q1_4 model = new Model_Q1_4("--", "--");
            list_of_incident_for_question_one = new ArrayList<>();
            list_of_incident_for_question_one.add(model);  
            this.dispose();*/
        switch (Question_index_indicator) {
            case 1:
                if (list_of_incident_for_question_one != null) {
                    list_of_incident_for_question_one.removeAll(list_of_incident_for_question_one);
                    list_of_incident_for_question_one = null;
                }
                break;
            case 2:
                if (list_of_incident_for_question_two != null) {
                    list_of_incident_for_question_two.removeAll(list_of_incident_for_question_two);
                    list_of_incident_for_question_two = null;
                }
                break;
            case 3:
                if (list_of_incident_for_question_three != null) {
                    list_of_incident_for_question_three.removeAll(list_of_incident_for_question_three);
                    list_of_incident_for_question_three = null;
                }
                break;
            case 4:
                if (list_of_incident_for_question_four != null) {
                    list_of_incident_for_question_four.removeAll(list_of_incident_for_question_four);
                    list_of_incident_for_question_four = null;
                }
                break;
        }
        this.dispose();
    }//GEN-LAST:event_formWindowClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_save;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_Q1_Q5_dialog_header;
    private javax.swing.JRadioButton r_b_incident_critical;
    private javax.swing.JRadioButton r_b_incident_major;
    private javax.swing.JRadioButton r_b_incident_minor;
    private javax.swing.ButtonGroup r_g_incident_dialog;
    private javax.swing.JTextArea txt_area_incident_description;
    // End of variables declaration//GEN-END:variables
}

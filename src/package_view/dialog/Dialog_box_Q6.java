package package_view.dialog;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import package_database.DatabaseManager;
import package_model.Model_Q6;
//import static package_view.Activity_List.list_show_q6;
//import static package_view.Activity_List.mode;
import static package_view.Main_.static_value_of_regID;

/**
 *
 * @author Miz
 */
public class Dialog_box_Q6 extends javax.swing.JDialog {

    public static List<Model_Q6> list_of_data_center_visitor_for_question_six;
    DatabaseManager databasemanager;
    String visitor_name;
    String meanse_of_auth;
    String purpose_of_the_visitor;

    enum Means_of_auth {
        Phone, Email, Card, Paper
    }

    /**
     * Creates new form Dialog_box_Q6
     *
     * @param parent
     * @param modal
     */
    public Dialog_box_Q6(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();                
        list_of_data_center_visitor_for_question_six = new ArrayList<>();
        
        r_b_meanse_authorization_card.setSelected(true);
        meanse_of_auth = String.valueOf(Means_of_auth.Card);
        databasemanager = new DatabaseManager();
        /*
        Q6
        if (list_of_data_center_visitor_for_question_six != null) {
            visitor_name = list_of_data_center_visitor_for_question_six.get(0).getVisitor_name();
            meanse_of_auth = list_of_data_center_visitor_for_question_six.get(0).getMeanse_of_auth();
            purpose_of_the_visitor = list_of_data_center_visitor_for_question_six.get(0).getPurpose_of_the_visitor();

            txt_field_q_6_visitor_name.setText(visitor_name);
            txt_area_q_6_purpose_of_the_visitor.setText(purpose_of_the_visitor);

            switch (meanse_of_auth) {
                case "Phone":
                    r_b_meanse_authorization_phone.setSelected(true);
                    break;
                case "Email":
                    r_b_meanse_authorization_email.setSelected(true);
                    break;
                case "Card":
                    r_b_meanse_authorization_card.setSelected(true);
                    break;
                case "Paper":
                    r_b_meanse_authorization_paper.setSelected(true);
                    break;
            }

        } else if (list_of_data_center_visitor_for_question_six == null) {
            r_b_meanse_authorization_card.setSelected(true);
            meanse_of_auth = String.valueOf(Means_of_auth.Card);
        }
        
        if(mode.equals("show_q6")){
            txt_field_q_6_visitor_name.setText(list_show_q6.get(0).getVisitor_name());
            txt_area_q_6_purpose_of_the_visitor.setText(list_show_q6.get(0).getPurpose_of_the_visitor());
            
            switch(list_show_q6.get(0).getMeanse_of_auth()){
                case "Phone":
                    r_b_meanse_authorization_phone.setSelected(true);
                    break;
                case "Email":
                    r_b_meanse_authorization_email.setSelected(true);
                    break;
                case "Card":
                    r_b_meanse_authorization_card.setSelected(true);
                    break;
                case "Paper":
                    r_b_meanse_authorization_paper.setSelected(true);
                    break;
            }
            
            btn_save.setVisible(false);
            txt_area_q_6_purpose_of_the_visitor.setEditable(false);
            txt_field_q_6_visitor_name.setEditable(false);
        } 
        */
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_g_q_6_means_of_authorization = new javax.swing.ButtonGroup();
        J_Panel_header_q_6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_field_q_6_visitor_name = new javax.swing.JTextField();
        r_b_meanse_authorization_paper = new javax.swing.JRadioButton();
        r_b_meanse_authorization_phone = new javax.swing.JRadioButton();
        r_b_meanse_authorization_email = new javax.swing.JRadioButton();
        r_b_meanse_authorization_card = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_area_q_6_purpose_of_the_visitor = new javax.swing.JTextArea();
        btn_save = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        J_Panel_header_q_6.setBackground(new java.awt.Color(32, 31, 95));
        J_Panel_header_q_6.setPreferredSize(new java.awt.Dimension(450, 66));

        jLabel1.setFont(new java.awt.Font("Lucida Fax", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Data Center Visitor Log");

        javax.swing.GroupLayout J_Panel_header_q_6Layout = new javax.swing.GroupLayout(J_Panel_header_q_6);
        J_Panel_header_q_6.setLayout(J_Panel_header_q_6Layout);
        J_Panel_header_q_6Layout.setHorizontalGroup(
            J_Panel_header_q_6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(J_Panel_header_q_6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        J_Panel_header_q_6Layout.setVerticalGroup(
            J_Panel_header_q_6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(J_Panel_header_q_6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jLabel2.setText("Visitor Name :");

        jLabel3.setText("Means of authorization:");

        jLabel4.setText("Purpose of the visitor :");

        txt_field_q_6_visitor_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_field_q_6_visitor_nameActionPerformed(evt);
            }
        });

        btn_g_q_6_means_of_authorization.add(r_b_meanse_authorization_paper);
        r_b_meanse_authorization_paper.setText("Paper");
        r_b_meanse_authorization_paper.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r_b_meanse_authorization_paperActionPerformed(evt);
            }
        });

        btn_g_q_6_means_of_authorization.add(r_b_meanse_authorization_phone);
        r_b_meanse_authorization_phone.setText("Phone");
        r_b_meanse_authorization_phone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r_b_meanse_authorization_phoneActionPerformed(evt);
            }
        });

        btn_g_q_6_means_of_authorization.add(r_b_meanse_authorization_email);
        r_b_meanse_authorization_email.setText("Email");
        r_b_meanse_authorization_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r_b_meanse_authorization_emailActionPerformed(evt);
            }
        });

        btn_g_q_6_means_of_authorization.add(r_b_meanse_authorization_card);
        r_b_meanse_authorization_card.setText("Card");
        r_b_meanse_authorization_card.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r_b_meanse_authorization_cardActionPerformed(evt);
            }
        });

        txt_area_q_6_purpose_of_the_visitor.setColumns(20);
        txt_area_q_6_purpose_of_the_visitor.setRows(5);
        jScrollPane1.setViewportView(txt_area_q_6_purpose_of_the_visitor);

        btn_save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/package_res/add_new.png"))); // NOI18N
        btn_save.setText("Save");
        btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(J_Panel_header_q_6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_field_q_6_visitor_name)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_save)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(r_b_meanse_authorization_paper)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(r_b_meanse_authorization_phone)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(r_b_meanse_authorization_email)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(r_b_meanse_authorization_card)))
                        .addGap(0, 84, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(J_Panel_header_q_6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_field_q_6_visitor_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(r_b_meanse_authorization_paper)
                    .addComponent(r_b_meanse_authorization_phone)
                    .addComponent(r_b_meanse_authorization_email)
                    .addComponent(r_b_meanse_authorization_card))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btn_save)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_field_q_6_visitor_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_field_q_6_visitor_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_field_q_6_visitor_nameActionPerformed

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
        if((txt_field_q_6_visitor_name.getText().isEmpty()) || (txt_area_q_6_purpose_of_the_visitor.getText().isEmpty())){
            JOptionPane.showMessageDialog(null, "Please Fill all the Input Field","Error!", JOptionPane.ERROR_MESSAGE);            
            return;
        }
        visitor_name = txt_field_q_6_visitor_name.getText();
        purpose_of_the_visitor = txt_area_q_6_purpose_of_the_visitor.getText();
        
        Model_Q6 model = new Model_Q6(visitor_name, meanse_of_auth, purpose_of_the_visitor);
        //List<Model_Q6> l = new ArrayList<>();
        
        /*
        if(list_of_data_center_visitor_for_question_six.size() > 0){
            list_of_data_center_visitor_for_question_six.removeAll(list_of_data_center_visitor_for_question_six);            
        }
        */
        //l.add(model);
        list_of_data_center_visitor_for_question_six.add(model);
        databasemanager.add_DATA_3_TABLE(static_value_of_regID, model);
        this.dispose();
    }//GEN-LAST:event_btn_saveActionPerformed

    private void r_b_meanse_authorization_paperActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r_b_meanse_authorization_paperActionPerformed
        if(r_b_meanse_authorization_paper.isSelected()){
            meanse_of_auth = String.valueOf(Means_of_auth.Paper);
        }
    }//GEN-LAST:event_r_b_meanse_authorization_paperActionPerformed

    private void r_b_meanse_authorization_phoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r_b_meanse_authorization_phoneActionPerformed
      if(r_b_meanse_authorization_phone.isSelected()){
            meanse_of_auth = String.valueOf(Means_of_auth.Phone);
        }
    }//GEN-LAST:event_r_b_meanse_authorization_phoneActionPerformed

    private void r_b_meanse_authorization_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r_b_meanse_authorization_emailActionPerformed
         if(r_b_meanse_authorization_email.isSelected()){
            meanse_of_auth = String.valueOf(Means_of_auth.Email);
        }
    }//GEN-LAST:event_r_b_meanse_authorization_emailActionPerformed

    private void r_b_meanse_authorization_cardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r_b_meanse_authorization_cardActionPerformed
         if(r_b_meanse_authorization_card.isSelected()){
            meanse_of_auth = String.valueOf(Means_of_auth.Card);
        }
    }//GEN-LAST:event_r_b_meanse_authorization_cardActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if(list_of_data_center_visitor_for_question_six != null){
            list_of_data_center_visitor_for_question_six.removeAll(list_of_data_center_visitor_for_question_six);
            list_of_data_center_visitor_for_question_six = null;
        }
    }//GEN-LAST:event_formWindowClosing

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel J_Panel_header_q_6;
    private javax.swing.ButtonGroup btn_g_q_6_means_of_authorization;
    private javax.swing.JButton btn_save;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton r_b_meanse_authorization_card;
    private javax.swing.JRadioButton r_b_meanse_authorization_email;
    private javax.swing.JRadioButton r_b_meanse_authorization_paper;
    private javax.swing.JRadioButton r_b_meanse_authorization_phone;
    private javax.swing.JTextArea txt_area_q_6_purpose_of_the_visitor;
    private javax.swing.JTextField txt_field_q_6_visitor_name;
    // End of variables declaration//GEN-END:variables
}

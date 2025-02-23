
package package_view.dialog;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import package_model.Model_Q5;
import package_model.Model_Q6;
import static package_view.Activity_List.list_show_q5;
import static package_view.Activity_List.mode;
import static package_view.Main_.Question_index_indicator;

/**
 *
 * @author Miz
 */
public class Dialog_box_Q5 extends javax.swing.JDialog {

    
    public  List<Model_Q6> aa;
    public static List<Model_Q5> list_of_genenator_info_for_question_five;
    
    String time_;
    String genenetor_oprated_normally;
    String genenetor_status_description;
    String is_there_any_fule_for_24h;
    
    /**
     * Creates new form Dialog_box_Q5
     * 
     * @param parent
     * @param modal
     */
    public Dialog_box_Q5(java.awt.Frame parent, boolean modal) {
        super(parent, modal);        
        initComponents();  
        
        
        /*Q5*/
        
        if ((list_of_genenator_info_for_question_five != null) && (Question_index_indicator == 5)) {            
            time_ = list_of_genenator_info_for_question_five.get(0).getTime_();
            genenetor_oprated_normally = list_of_genenator_info_for_question_five.get(0).getGenenetor_oprated_normally();
            genenetor_status_description = list_of_genenator_info_for_question_five.get(0).getGenenetor_status_description();
            is_there_any_fule_for_24h = list_of_genenator_info_for_question_five.get(0).getIs_there_any_fule_for_24h();
            
            txt_field_time_q_5.setText(time_);
            txt_area_q_5_genenator_opration_info.setText(genenetor_status_description);
            
            switch(genenetor_oprated_normally){
                case "yes":
                    r_b_q_5_genenators_work_normally_yes.setSelected(true);
                    break;
                case "no":
                    r_b_q_5_genenators_work_normally_no.setSelected(true);
            }
            
            switch(is_there_any_fule_for_24h){
                case "yes":
                    r_b_q_5_enough_fule_yes.setSelected(true);
                    break;
                case"no":
                    r_b_q_5_enough_fule_no.setSelected(true);
            }

        } else if ((list_of_genenator_info_for_question_five == null) && (Question_index_indicator == 5)) {
            r_b_q_5_genenators_work_normally_yes.setSelected(true);
            r_b_q_5_enough_fule_yes.setSelected(true);
            
            genenetor_oprated_normally = "yes";
            is_there_any_fule_for_24h = "yes";
        }

        if(mode.equals("show_q5")){
            btn_save.setVisible(false);
            txt_field_time_q_5.setEditable(false);
            txt_area_q_5_genenator_opration_info.setEditable(false);
            
            txt_field_time_q_5.setText(list_show_q5.get(0).getTime_());
            txt_area_q_5_genenator_opration_info.setText(list_show_q5.get(0).getGenenetor_status_description());
            if(list_show_q5.get(0).getGenenetor_oprated_normally().equals("yes")){
                r_b_q_5_genenators_work_normally_yes.setSelected(true);
            }else{
                r_b_q_5_genenators_work_normally_no.setSelected(true);
            }
            
            if(list_show_q5.get(0).getIs_there_any_fule_for_24h().equals("yes")){
                r_b_q_5_enough_fule_yes.setSelected(true);
            }else{
                r_b_q_5_enough_fule_no.setSelected(true);
            }
            
        }
    }    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_g_q_5_genenator_operating_normally = new javax.swing.ButtonGroup();
        btn_g_q_5_fuel = new javax.swing.ButtonGroup();
        J_panel_header = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        J_panel_severity_and_des = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        r_b_q_5_genenators_work_normally_yes = new javax.swing.JRadioButton();
        r_b_q_5_genenators_work_normally_no = new javax.swing.JRadioButton();
        J_panel_q_5_genenator_opration = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txt_field_time_q_5 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_area_q_5_genenator_opration_info = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        r_b_q_5_enough_fule_yes = new javax.swing.JRadioButton();
        r_b_q_5_enough_fule_no = new javax.swing.JRadioButton();
        btn_save = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        J_panel_header.setBackground(new java.awt.Color(32, 31, 95));

        jLabel7.setFont(new java.awt.Font("Lucida Fax", 3, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Generators");

        javax.swing.GroupLayout J_panel_headerLayout = new javax.swing.GroupLayout(J_panel_header);
        J_panel_header.setLayout(J_panel_headerLayout);
        J_panel_headerLayout.setHorizontalGroup(
            J_panel_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(J_panel_headerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        J_panel_headerLayout.setVerticalGroup(
            J_panel_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(J_panel_headerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                .addContainerGap())
        );

        J_panel_severity_and_des.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel5.setText("Were the generators operating normally? ");

        btn_g_q_5_genenator_operating_normally.add(r_b_q_5_genenators_work_normally_yes);
        r_b_q_5_genenators_work_normally_yes.setText("Yes");
        r_b_q_5_genenators_work_normally_yes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r_b_q_5_genenators_work_normally_yesActionPerformed(evt);
            }
        });

        btn_g_q_5_genenator_operating_normally.add(r_b_q_5_genenators_work_normally_no);
        r_b_q_5_genenators_work_normally_no.setText("No");
        r_b_q_5_genenators_work_normally_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r_b_q_5_genenators_work_normally_noActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout J_panel_q_5_genenator_oprationLayout = new javax.swing.GroupLayout(J_panel_q_5_genenator_opration);
        J_panel_q_5_genenator_opration.setLayout(J_panel_q_5_genenator_oprationLayout);
        J_panel_q_5_genenator_oprationLayout.setHorizontalGroup(
            J_panel_q_5_genenator_oprationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 187, Short.MAX_VALUE)
        );
        J_panel_q_5_genenator_oprationLayout.setVerticalGroup(
            J_panel_q_5_genenator_oprationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 99, Short.MAX_VALUE)
        );

        jLabel4.setText("If yes specify time: ");

        txt_field_time_q_5.setToolTipText("Enter Time ..");
        txt_field_time_q_5.setPreferredSize(new java.awt.Dimension(4, 20));
        txt_field_time_q_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_field_time_q_5ActionPerformed(evt);
            }
        });

        txt_area_q_5_genenator_opration_info.setColumns(20);
        txt_area_q_5_genenator_opration_info.setRows(5);
        jScrollPane2.setViewportView(txt_area_q_5_genenator_opration_info);

        jLabel6.setText("If yes/No, please describe it.");

        jLabel1.setText("Is there enough fuel for 24hours of non stop operation?");

        btn_g_q_5_fuel.add(r_b_q_5_enough_fule_yes);
        r_b_q_5_enough_fule_yes.setText("Yes");
        r_b_q_5_enough_fule_yes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r_b_q_5_enough_fule_yesActionPerformed(evt);
            }
        });

        btn_g_q_5_fuel.add(r_b_q_5_enough_fule_no);
        r_b_q_5_enough_fule_no.setText("No");
        r_b_q_5_enough_fule_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r_b_q_5_enough_fule_noActionPerformed(evt);
            }
        });

        btn_save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/package_res/add_new.png"))); // NOI18N
        btn_save.setText("Save");
        btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout J_panel_severity_and_desLayout = new javax.swing.GroupLayout(J_panel_severity_and_des);
        J_panel_severity_and_des.setLayout(J_panel_severity_and_desLayout);
        J_panel_severity_and_desLayout.setHorizontalGroup(
            J_panel_severity_and_desLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(J_panel_severity_and_desLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(J_panel_severity_and_desLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(J_panel_severity_and_desLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(J_panel_severity_and_desLayout.createSequentialGroup()
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(r_b_q_5_genenators_work_normally_yes)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(r_b_q_5_genenators_work_normally_no))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, J_panel_severity_and_desLayout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addGap(11, 11, 11)
                            .addComponent(txt_field_time_q_5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(J_panel_severity_and_desLayout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(r_b_q_5_enough_fule_yes)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(r_b_q_5_enough_fule_no))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(btn_save))
                .addGap(109, 109, 109)
                .addComponent(J_panel_q_5_genenator_opration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        J_panel_severity_and_desLayout.setVerticalGroup(
            J_panel_severity_and_desLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(J_panel_severity_and_desLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(J_panel_severity_and_desLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(J_panel_severity_and_desLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(J_panel_q_5_genenator_opration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(J_panel_severity_and_desLayout.createSequentialGroup()
                        .addGroup(J_panel_severity_and_desLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_field_time_q_5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(J_panel_severity_and_desLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(r_b_q_5_genenators_work_normally_yes)
                            .addComponent(r_b_q_5_genenators_work_normally_no))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(J_panel_severity_and_desLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(r_b_q_5_enough_fule_yes)
                            .addComponent(r_b_q_5_enough_fule_no))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_save)
                        .addGap(40, 40, 40)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(J_panel_header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(J_panel_severity_and_des, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(J_panel_header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(J_panel_severity_and_des, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void r_b_q_5_genenators_work_normally_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r_b_q_5_genenators_work_normally_noActionPerformed
            if(r_b_q_5_genenators_work_normally_no.isSelected()){                
                genenetor_oprated_normally = "no";
            }
    }//GEN-LAST:event_r_b_q_5_genenators_work_normally_noActionPerformed

    private void r_b_q_5_genenators_work_normally_yesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r_b_q_5_genenators_work_normally_yesActionPerformed
            if(r_b_q_5_genenators_work_normally_yes.isSelected()){
                r_b_q_5_genenators_work_normally_yes.setSelected(true);
                genenetor_oprated_normally = "yes";
            }
    }//GEN-LAST:event_r_b_q_5_genenators_work_normally_yesActionPerformed

    private void r_b_q_5_enough_fule_yesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r_b_q_5_enough_fule_yesActionPerformed
        if(r_b_q_5_enough_fule_yes.isSelected()){
            r_b_q_5_enough_fule_yes.setSelected(true);
            is_there_any_fule_for_24h = "yes";
        }
    }//GEN-LAST:event_r_b_q_5_enough_fule_yesActionPerformed

    private void r_b_q_5_enough_fule_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r_b_q_5_enough_fule_noActionPerformed
        if(r_b_q_5_enough_fule_no.isSelected()){
            r_b_q_5_enough_fule_no.setSelected(true);
            is_there_any_fule_for_24h = "no";            
        }
    }//GEN-LAST:event_r_b_q_5_enough_fule_noActionPerformed

    private void txt_field_time_q_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_field_time_q_5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_field_time_q_5ActionPerformed

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
        if((txt_field_time_q_5.getText().isEmpty()) ||(txt_area_q_5_genenator_opration_info.getText().isEmpty())){
            JOptionPane.showMessageDialog(null, "Please Fill all the Input Field","Error!", JOptionPane.ERROR_MESSAGE);  
            return;
        }
        if(Question_index_indicator == 5){
            time_ = txt_field_time_q_5.getText();
            genenetor_status_description = txt_area_q_5_genenator_opration_info.getText();
            Model_Q5 model = new Model_Q5(time_, genenetor_oprated_normally, genenetor_status_description, is_there_any_fule_for_24h);
            list_of_genenator_info_for_question_five = new ArrayList<>();
            if(list_of_genenator_info_for_question_five.size() > 0){
                list_of_genenator_info_for_question_five.removeAll(list_of_genenator_info_for_question_five);
            }
            list_of_genenator_info_for_question_five.add(model);
        }
        
//        list_of_genenator_info_for_question_five.forEach((a) -> {
//                System.out.println("from dialog " + a.getTime_() + " " + a.getGenenetor_oprated_normally() + " " + a.getIs_there_any_fule_for_24h());
//                
//            });
        this.dispose();
    }//GEN-LAST:event_btn_saveActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if(list_of_genenator_info_for_question_five != null){
            list_of_genenator_info_for_question_five.removeAll(list_of_genenator_info_for_question_five);
            list_of_genenator_info_for_question_five = null;
        }
    }//GEN-LAST:event_formWindowClosing

    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel J_panel_header;
    private javax.swing.JPanel J_panel_q_5_genenator_opration;
    private javax.swing.JPanel J_panel_severity_and_des;
    private javax.swing.ButtonGroup btn_g_q_5_fuel;
    private javax.swing.ButtonGroup btn_g_q_5_genenator_operating_normally;
    private javax.swing.JButton btn_save;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton r_b_q_5_enough_fule_no;
    private javax.swing.JRadioButton r_b_q_5_enough_fule_yes;
    private javax.swing.JRadioButton r_b_q_5_genenators_work_normally_no;
    private javax.swing.JRadioButton r_b_q_5_genenators_work_normally_yes;
    private javax.swing.JTextArea txt_area_q_5_genenator_opration_info;
    private javax.swing.JTextField txt_field_time_q_5;
    // End of variables declaration//GEN-END:variables
}

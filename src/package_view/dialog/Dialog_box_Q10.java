
package package_view.dialog;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import package_model.Model_Q10;
import static package_view.Activity_List.list_show_q10;
import static package_view.Activity_List.mode;

/**
 *
 * @author Miz
 */
public class Dialog_box_Q10 extends javax.swing.JDialog {
    
    public static List<Model_Q10> list_of_air_conditionners_for_question_ten;
    ArrayList<String> list_validation;
    final String regex_num_validation = "[+-]?([0-9]*[.])?[0-9]+";
    Pattern pattern;
    Matcher matcher;
    /**
     * Creates new form Dialog_box_Q10
     * @param parent
     * @param modal
     */
    public Dialog_box_Q10(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        pattern = Pattern.compile(regex_num_validation);
        if(mode.equals("show_q10")){
                txt_field_ACRD_602_INROW_1.setText(list_show_q10.get(0).getACRD_602_INROW_1());
                txt_field_ACRP_102_INROW_2.setText(list_show_q10.get(0).getACRP_102_INROW_2());
                txt_field_ACRP_102_INROW_3.setText(list_show_q10.get(0).getACRP_102_INROW_3());
                txt_field_ACRP_102_INROW_4.setText(list_show_q10.get(0).getACRP_102_INROW_4());
                txt_field_ACRP_102_INROW_5.setText(list_show_q10.get(0).getACRP_102_INROW_5());
                txt_field_CARRIER_F201.setText(list_show_q10.get(0).getCARRIER_F201());
                txt_field_CARRIER_F205.setText(list_show_q10.get(0).getCARRIER_F205());
                txt_field_ROYAL_F202.setText(list_show_q10.get(0).getROYAL_F202());
                txt_field_ROYAL_F203.setText(list_show_q10.get(0).getROYAL_F203());
                txt_field_LG_F204.setText(list_show_q10.get(0).getLG_F204());
                txt_field_Inventor_1.setText(list_show_q10.get(0).getInventor_1());
                txt_field_Inventor_2.setText(list_show_q10.get(0).getInventor_2());
                txt_field_Inventor_3.setText(list_show_q10.get(0).getInventor_3());
                txt_field_Inventor_4.setText(list_show_q10.get(0).getInventor_4());
                
                btn_save.setVisible(false);
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txt_field_ACRD_602_INROW_1 = new javax.swing.JTextField();
        txt_field_ACRP_102_INROW_3 = new javax.swing.JTextField();
        txt_field_ACRP_102_INROW_2 = new javax.swing.JTextField();
        txt_field_CARRIER_F201 = new javax.swing.JTextField();
        txt_field_ACRP_102_INROW_5 = new javax.swing.JTextField();
        txt_field_ACRP_102_INROW_4 = new javax.swing.JTextField();
        txt_field_CARRIER_F205 = new javax.swing.JTextField();
        txt_field_ROYAL_F202 = new javax.swing.JTextField();
        txt_field_LG_F204 = new javax.swing.JTextField();
        txt_field_ROYAL_F203 = new javax.swing.JTextField();
        txt_field_Inventor_2 = new javax.swing.JTextField();
        txt_field_Inventor_3 = new javax.swing.JTextField();
        txt_field_Inventor_4 = new javax.swing.JTextField();
        txt_field_Inventor_1 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btn_save = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(32, 31, 95));

        jLabel1.setFont(new java.awt.Font("Lucida Fax", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("AIR CONDITIONERS");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 675, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel2.setText("ACRD 602 INROW 1");

        jLabel3.setText("ACRD 102 INROW 2");

        jLabel4.setText("INVENTOR 4");

        jLabel5.setText("ACRD 102 INROW 3");

        jLabel6.setText("ACRD 102 INROW 4");

        jLabel7.setText("GREE F201");

        jLabel8.setText("ACRD 602 INROW 5");

        jLabel9.setText("CARRIER F205");

        jLabel10.setText("INVENTOR 2");

        jLabel11.setText("INVENTOR 3");

        jLabel12.setText("INVENTOR 1");

        jLabel13.setText("INVENTOR F204");

        jLabel14.setText("GREE F203");

        jLabel15.setText("ROYAL F202");

        txt_field_ACRD_602_INROW_1.setText("--");

        txt_field_ACRP_102_INROW_3.setText("--");

        txt_field_ACRP_102_INROW_2.setText("--");
        txt_field_ACRP_102_INROW_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_field_ACRP_102_INROW_2ActionPerformed(evt);
            }
        });

        txt_field_CARRIER_F201.setText("--");

        txt_field_ACRP_102_INROW_5.setText("--");

        txt_field_ACRP_102_INROW_4.setText("--");

        txt_field_CARRIER_F205.setText("--");

        txt_field_ROYAL_F202.setText("--");

        txt_field_LG_F204.setText("--");

        txt_field_ROYAL_F203.setText("--");

        txt_field_Inventor_2.setText("--");

        txt_field_Inventor_3.setText("--");

        txt_field_Inventor_4.setText("--");

        txt_field_Inventor_1.setText("--");

        jPanel2.setBackground(new java.awt.Color(32, 31, 95));

        jLabel16.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Name");

        jLabel17.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Temperature (C )");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                .addComponent(jLabel17)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(32, 31, 95));

        jLabel18.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Name");

        jLabel19.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Temperature (C )");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                .addComponent(jLabel19)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(32, 31, 95));

        btn_save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/package_res/add_new.png"))); // NOI18N
        btn_save.setText("Save");
        btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(267, 267, 267)
                .addComponent(btn_save)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(btn_save)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txt_field_ACRP_102_INROW_5)
                                        .addComponent(txt_field_ACRD_602_INROW_1)
                                        .addComponent(txt_field_CARRIER_F205)
                                        .addComponent(txt_field_ACRP_102_INROW_2, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(txt_field_CARRIER_F201, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txt_field_ACRP_102_INROW_3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txt_field_ACRP_102_INROW_4, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(78, 78, 78)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_field_LG_F204, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_field_ROYAL_F202, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_field_ROYAL_F203, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_field_Inventor_2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_field_Inventor_3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_field_Inventor_4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_field_Inventor_1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_field_ACRD_602_INROW_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(txt_field_ROYAL_F202, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_field_ACRP_102_INROW_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(txt_field_ROYAL_F203, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_field_ACRP_102_INROW_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel13)
                    .addComponent(txt_field_LG_F204, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_field_ACRP_102_INROW_4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(txt_field_Inventor_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txt_field_ACRP_102_INROW_5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_field_Inventor_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txt_field_CARRIER_F201, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(txt_field_Inventor_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_field_CARRIER_F205, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel4)
                    .addComponent(txt_field_Inventor_4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_field_ACRP_102_INROW_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_field_ACRP_102_INROW_2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_field_ACRP_102_INROW_2ActionPerformed

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
        Model_Q10 model = new Model_Q10(
                txt_field_ACRD_602_INROW_1.getText(),
                txt_field_ACRP_102_INROW_2.getText(),
                txt_field_ACRP_102_INROW_3.getText(),
                txt_field_ACRP_102_INROW_4.getText(),
                txt_field_ACRP_102_INROW_5.getText(),
                txt_field_CARRIER_F201.getText(),
                txt_field_CARRIER_F205.getText(),
                txt_field_ROYAL_F202.getText(),
                txt_field_ROYAL_F203.getText(),
                txt_field_LG_F204.getText(),
                txt_field_Inventor_1.getText(),
                txt_field_Inventor_2.getText(),
                txt_field_Inventor_3.getText(),
                txt_field_Inventor_4.getText());
        
        list_validation = new ArrayList<>();
        list_validation.add(txt_field_ACRD_602_INROW_1.getText());
        list_validation.add(txt_field_ACRP_102_INROW_2.getText());
        list_validation.add(txt_field_ACRP_102_INROW_3.getText());
        list_validation.add(txt_field_ACRP_102_INROW_4.getText());
        list_validation.add(txt_field_ACRP_102_INROW_5.getText());
        list_validation.add(txt_field_CARRIER_F201.getText());
        list_validation.add(txt_field_CARRIER_F205.getText());
        list_validation.add(txt_field_ROYAL_F202.getText());
        list_validation.add(txt_field_ROYAL_F203.getText());        
        list_validation.add( txt_field_LG_F204.getText());
        list_validation.add(txt_field_Inventor_1.getText());
        list_validation.add(txt_field_Inventor_2.getText());
        list_validation.add(txt_field_Inventor_3.getText());
        list_validation.add(txt_field_Inventor_4.getText());
        
        for (int i = 0; i < list_validation.size(); i++) {
         if(!list_validation.get(i).isEmpty())
            matcher = pattern.matcher(list_validation.get(i));
             /*if (!matcher.matches()) {
                JOptionPane.showMessageDialog(null, "Please Enter Number Only value / Valid Number ", "Error!", JOptionPane.ERROR_MESSAGE);
                return;
            }*/
        }
        
        
        
        list_of_air_conditionners_for_question_ten = new ArrayList<>();
        if(list_of_air_conditionners_for_question_ten.size() > 0){
            list_of_air_conditionners_for_question_ten.removeAll(list_of_air_conditionners_for_question_ten);
        }
        
        list_of_air_conditionners_for_question_ten.add(model);
        this.dispose();
    }//GEN-LAST:event_btn_saveActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_save;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField txt_field_ACRD_602_INROW_1;
    private javax.swing.JTextField txt_field_ACRP_102_INROW_2;
    private javax.swing.JTextField txt_field_ACRP_102_INROW_3;
    private javax.swing.JTextField txt_field_ACRP_102_INROW_4;
    private javax.swing.JTextField txt_field_ACRP_102_INROW_5;
    private javax.swing.JTextField txt_field_CARRIER_F201;
    private javax.swing.JTextField txt_field_CARRIER_F205;
    private javax.swing.JTextField txt_field_Inventor_1;
    private javax.swing.JTextField txt_field_Inventor_2;
    private javax.swing.JTextField txt_field_Inventor_3;
    private javax.swing.JTextField txt_field_Inventor_4;
    private javax.swing.JTextField txt_field_LG_F204;
    private javax.swing.JTextField txt_field_ROYAL_F202;
    private javax.swing.JTextField txt_field_ROYAL_F203;
    // End of variables declaration//GEN-END:variables
}

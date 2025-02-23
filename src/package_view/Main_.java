package package_view;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import package_database.DatabaseManager;
import package_database.User_DatabaseManager;
import package_model.Model_Q10;
import package_model.Model_Q1_4;
import package_model.Model_Q5;
import package_model.Model_Q6;
import package_model.Model_Q6_1_8;
import package_model.Model_Q9;
import static package_view.Login_view.CURRENT_USER_INFO;
import package_view.dialog.Dialog_box_Change_Password;
import package_view.dialog.Dialog_box_Q10;
import package_view.dialog.Dialog_box_Q1_4;
import static package_view.dialog.Dialog_box_Q1_4.list_of_incident_for_question_four;
import static package_view.dialog.Dialog_box_Q1_4.list_of_incident_for_question_one;
import static package_view.dialog.Dialog_box_Q1_4.list_of_incident_for_question_three;
import static package_view.dialog.Dialog_box_Q1_4.list_of_incident_for_question_two;
import static package_view.dialog.Dialog_box_Q5.list_of_genenator_info_for_question_five;
import static package_view.dialog.Dialog_box_Q6_1_Q8.list_of_description_for_question_eghit;
import static package_view.dialog.Dialog_box_Q6_1_Q8.list_of_description_for_question_seven;
import static package_view.dialog.Dialog_box_Q6_1_Q8.list_of_description_for_question_six_one;
import static package_view.dialog.Dialog_box_Q10.list_of_air_conditionners_for_question_ten;
import static package_view.dialog.Dialog_box_Q6.list_of_data_center_visitor_for_question_six;
import package_view.dialog.Dialog_box_Q5;
import package_view.dialog.Dialog_box_Q6;
import package_view.dialog.Dialog_box_Q6_1_Q8;
import package_view.dialog.Dialog_box_Q9;
import static package_view.dialog.Dialog_box_Q9.list_of_ups_for_question_nine;

/**
 *
 * @author Miz
 */
public class Main_ extends javax.swing.JFrame {

    /**
     * Creates new form Main_
     */
    public static int Question_index_indicator = 1;
    public static String static_value_of_regID;
    List<Model_Q1_4> list_for_questio_one;
    List<Model_Q1_4> list_for_questio_two;
    List<Model_Q1_4> list_for_questio_three;
    List<Model_Q1_4> list_for_questio_four;

    List<Model_Q5> list_for_questio_five;
    List<Model_Q6> list_for_questio_six;

    List<Model_Q6_1_8> list_for_questio_six_one;
    List<Model_Q6_1_8> list_for_questio_seven;
    List<Model_Q6_1_8> list_for_questio_eghit;

    List<Model_Q9> list_for_questio_nine;
    List<Model_Q10> list_for_questio_ten;

    DatabaseManager databasemanager;
    User_DatabaseManager user_dbm;

    String q_one_status_yes_no;
    String q_two_status_yes_no;
    String q_three_status_yes_no;
    String q_four_status_yes_no;
    String q_five_status_yes_no;
    String q_six_status_yes_no;
    String q_six_1_status_yes_no;
    String q_seven_status_yes_no;
    String q_eghit_status_yes_no;
    
    String uniqueID;
    String regID;

    //Dialog_box_Q1_5 dialog__;
    public Main_() {
        
        uniqueID = UUID.randomUUID().toString();
        String[] IDval = uniqueID.split("-");

        regID = IDval[0] + IDval[1];
        static_value_of_regID = regID;

        /*
            ThreadLocalRandom.current().ints(0, 100).distinct().limit(5).forEach(System.out::println);
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            Instant instant = timestamp.toInstant();
            System.out.println(instant);
            System.out.println(instant.toEpochMilli());
         */
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/package_res/icon.png")).getImage());
        initComponents();
        setLocationRelativeTo(null);
        r_btn_q_one_no.setSelected(true);
        q_one_status_yes_no = "no";
        r_btn_q_two_no.setSelected(true);
        q_two_status_yes_no = "no";
        r_btn_q_three_no.setSelected(true);
        q_three_status_yes_no = "no";
        r_btn_q_four_yes.setSelected(true);
        q_four_status_yes_no = "yes";
        r_btn_q_five_no.setSelected(true);
        q_five_status_yes_no = "no";
        r_btn_q_six_no.setSelected(true);
        q_six_status_yes_no = "no";
        r_btn_q_six_1_no.setSelected(true);
        q_six_1_status_yes_no = "no";
        r_btn_q_seven_yes.setSelected(true);
        q_seven_status_yes_no = "yes";
        r_btn_q_eight_yes.setSelected(true);
        q_eghit_status_yes_no = "yes";

        databasemanager = new DatabaseManager();
        user_dbm = new User_DatabaseManager();
        //databasemanager.get_test();
        //List<Model_QT1_4> listT = databasemanager.get_data_Table_1();
        //List<Model_Q5> list5 = databasemanager.get_data_Table_2("7035aa06b466");
          
        //listT.forEach((e) -> System.out.println("ID " + e.getRegID() + " SSQ1 " + e.getSSQ1()));
        //list5.forEach((e) -> System.out.println("Ginfo " + e.getGenenetor_oprated_normally() + " des " + e.getGenenetor_status_description() ));

        add_users_to_cb();
        add_current_date();
        current_user_label();
        
        //List<Model_Q6> aList = databasemanager.get_data_Table_3("23d284f4b57b");
    }

    private void current_user_label() {
        lbl_current_user.setText(CURRENT_USER_INFO.get(0).getF_name() + " " + CURRENT_USER_INFO.get(0).getL_name());
    }

    private void add_users_to_cb() {
        List<String> temp_uesr = new ArrayList<>();
        for (int i = 0; i < user_dbm.getAllusers().size(); i++) {
            temp_uesr.add(user_dbm.getAllusers().get(i).getF_name() + " " + user_dbm.getAllusers().get(i).getL_name());
        }
        Collections.sort(temp_uesr);
        cb_deliverd_to.setModel(new DefaultComboBoxModel<>(temp_uesr.toArray(new String[0])));
        cb_recived_from.setModel(new DefaultComboBoxModel<>(temp_uesr.toArray(new String[0])));
    }

    private void add_current_date() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();
        String date_time = dateFormat.format(cal.getTime());
        lbl_date.setText(date_time);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_g__one = new javax.swing.ButtonGroup();
        btn_g_q_two = new javax.swing.ButtonGroup();
        btn_g_q_three = new javax.swing.ButtonGroup();
        btn_g_q_four = new javax.swing.ButtonGroup();
        btn_g_q_five = new javax.swing.ButtonGroup();
        btn_g_q_six = new javax.swing.ButtonGroup();
        btn_g_q_six_1 = new javax.swing.ButtonGroup();
        btn_g_q_seven = new javax.swing.ButtonGroup();
        btn_g_q_eghit = new javax.swing.ButtonGroup();
        main_panel = new javax.swing.JPanel();
        sub_panel_one = new javax.swing.JPanel();
        lbl_q_no_one = new javax.swing.JLabel();
        lbl_q_one = new javax.swing.JLabel();
        r_btn_q_one_yes = new javax.swing.JRadioButton();
        r_btn_q_one_no = new javax.swing.JRadioButton();
        sub_panel_one1 = new javax.swing.JPanel();
        lbl_q_no_one1 = new javax.swing.JLabel();
        lbl_q_one1 = new javax.swing.JLabel();
        r_btn_q_four_yes = new javax.swing.JRadioButton();
        r_btn_q_four_no = new javax.swing.JRadioButton();
        sub_panel_one2 = new javax.swing.JPanel();
        lbl_q_no_one2 = new javax.swing.JLabel();
        lbl_q_one2 = new javax.swing.JLabel();
        r_btn_q_two_yes = new javax.swing.JRadioButton();
        r_btn_q_two_no = new javax.swing.JRadioButton();
        sub_panel_one3 = new javax.swing.JPanel();
        lbl_q_no_one3 = new javax.swing.JLabel();
        lbl_q_one3 = new javax.swing.JLabel();
        r_btn_q_five_yes = new javax.swing.JRadioButton();
        r_btn_q_five_no = new javax.swing.JRadioButton();
        sub_panel_one4 = new javax.swing.JPanel();
        lbl_q_no_one4 = new javax.swing.JLabel();
        lbl_q_one4 = new javax.swing.JLabel();
        r_btn_q_three_yes = new javax.swing.JRadioButton();
        r_btn_q_three_no = new javax.swing.JRadioButton();
        sub_panel_one7 = new javax.swing.JPanel();
        lbl_q_no_one7 = new javax.swing.JLabel();
        lbl_q_one7 = new javax.swing.JLabel();
        r_btn_q_six_yes = new javax.swing.JRadioButton();
        r_btn_q_six_no = new javax.swing.JRadioButton();
        main_panel_two = new javax.swing.JPanel();
        sub_panel_one8 = new javax.swing.JPanel();
        lbl_q_no_one8 = new javax.swing.JLabel();
        lbl_q_one8 = new javax.swing.JLabel();
        r_btn_q_seven_yes = new javax.swing.JRadioButton();
        r_btn_q_seven_no = new javax.swing.JRadioButton();
        sub_panel_one9 = new javax.swing.JPanel();
        lbl_q_no_one9 = new javax.swing.JLabel();
        lbl_q_one9 = new javax.swing.JLabel();
        r_btn_q_six_1_yes = new javax.swing.JRadioButton();
        r_btn_q_six_1_no = new javax.swing.JRadioButton();
        sub_panel_one10 = new javax.swing.JPanel();
        lbl_q_no_one10 = new javax.swing.JLabel();
        lbl_q_one10 = new javax.swing.JLabel();
        btn_open_dialog_q9 = new javax.swing.JButton();
        sub_panel_one11 = new javax.swing.JPanel();
        lbl_q_no_one11 = new javax.swing.JLabel();
        lbl_q_one11 = new javax.swing.JLabel();
        r_btn_q_eight_yes = new javax.swing.JRadioButton();
        r_btn_q_eight_no = new javax.swing.JRadioButton();
        sub_panel_one12 = new javax.swing.JPanel();
        lbl_q_no_one12 = new javax.swing.JLabel();
        lbl_q_one12 = new javax.swing.JLabel();
        btn_open_dialog_q10 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btn_save = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lbl_current_user = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cb_recived_from = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        cb_deliverd_to = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        cb_shift = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        lbl_date = new javax.swing.JLabel();
        btn_activity_list = new javax.swing.JButton();
        btn_change_pasword = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        main_panel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        main_panel.setName("main_panel"); // NOI18N

        sub_panel_one.setBackground(new java.awt.Color(255, 255, 255));
        sub_panel_one.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));

        lbl_q_no_one.setBackground(new java.awt.Color(255, 255, 255));
        lbl_q_no_one.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        lbl_q_no_one.setText("1.");

        lbl_q_one.setText("Was there any major /critical/ incident/s on any of the DC systems?");

        btn_g__one.add(r_btn_q_one_yes);
        r_btn_q_one_yes.setText("Yes");
        r_btn_q_one_yes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r_btn_q_one_yesActionPerformed(evt);
            }
        });

        btn_g__one.add(r_btn_q_one_no);
        r_btn_q_one_no.setText("No");
        r_btn_q_one_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r_btn_q_one_noActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout sub_panel_oneLayout = new javax.swing.GroupLayout(sub_panel_one);
        sub_panel_one.setLayout(sub_panel_oneLayout);
        sub_panel_oneLayout.setHorizontalGroup(
            sub_panel_oneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sub_panel_oneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_q_no_one)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_q_one)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(r_btn_q_one_yes)
                .addGap(18, 18, 18)
                .addComponent(r_btn_q_one_no)
                .addContainerGap())
        );
        sub_panel_oneLayout.setVerticalGroup(
            sub_panel_oneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sub_panel_oneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sub_panel_oneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sub_panel_oneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbl_q_one, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                        .addComponent(r_btn_q_one_yes)
                        .addComponent(r_btn_q_one_no))
                    .addComponent(lbl_q_no_one, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        sub_panel_one1.setBackground(new java.awt.Color(255, 255, 255));
        sub_panel_one1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));

        lbl_q_no_one1.setBackground(new java.awt.Color(255, 255, 255));
        lbl_q_no_one1.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        lbl_q_no_one1.setText("4.");

        lbl_q_one1.setText("Are all fire control system Normal ?");

        btn_g_q_four.add(r_btn_q_four_yes);
        r_btn_q_four_yes.setText("Yes");
        r_btn_q_four_yes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r_btn_q_four_yesActionPerformed(evt);
            }
        });

        btn_g_q_four.add(r_btn_q_four_no);
        r_btn_q_four_no.setText("No");
        r_btn_q_four_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r_btn_q_four_noActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout sub_panel_one1Layout = new javax.swing.GroupLayout(sub_panel_one1);
        sub_panel_one1.setLayout(sub_panel_one1Layout);
        sub_panel_one1Layout.setHorizontalGroup(
            sub_panel_one1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sub_panel_one1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_q_no_one1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_q_one1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(r_btn_q_four_yes)
                .addGap(22, 22, 22)
                .addComponent(r_btn_q_four_no)
                .addContainerGap())
        );
        sub_panel_one1Layout.setVerticalGroup(
            sub_panel_one1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sub_panel_one1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sub_panel_one1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sub_panel_one1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(r_btn_q_four_yes)
                        .addComponent(r_btn_q_four_no))
                    .addGroup(sub_panel_one1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbl_q_no_one1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbl_q_one1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        sub_panel_one2.setBackground(new java.awt.Color(255, 255, 255));
        sub_panel_one2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));

        lbl_q_no_one2.setBackground(new java.awt.Color(255, 255, 255));
        lbl_q_no_one2.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        lbl_q_no_one2.setText("2.");

        lbl_q_one2.setText("Was there any problem with the LCD display or camera system?");

        btn_g_q_two.add(r_btn_q_two_yes);
        r_btn_q_two_yes.setText("Yes");
        r_btn_q_two_yes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r_btn_q_two_yesActionPerformed(evt);
            }
        });

        btn_g_q_two.add(r_btn_q_two_no);
        r_btn_q_two_no.setText("No");
        r_btn_q_two_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r_btn_q_two_noActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout sub_panel_one2Layout = new javax.swing.GroupLayout(sub_panel_one2);
        sub_panel_one2.setLayout(sub_panel_one2Layout);
        sub_panel_one2Layout.setHorizontalGroup(
            sub_panel_one2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sub_panel_one2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_q_no_one2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_q_one2, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(r_btn_q_two_yes)
                .addGap(22, 22, 22)
                .addComponent(r_btn_q_two_no)
                .addContainerGap())
        );
        sub_panel_one2Layout.setVerticalGroup(
            sub_panel_one2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sub_panel_one2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sub_panel_one2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sub_panel_one2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(r_btn_q_two_yes)
                        .addComponent(r_btn_q_two_no))
                    .addComponent(lbl_q_one2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_q_no_one2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        sub_panel_one3.setBackground(new java.awt.Color(255, 255, 255));
        sub_panel_one3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));

        lbl_q_no_one3.setBackground(new java.awt.Color(255, 255, 255));
        lbl_q_no_one3.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        lbl_q_no_one3.setText("5.");

        lbl_q_one3.setText("Was there any power interruption?");

        btn_g_q_five.add(r_btn_q_five_yes);
        r_btn_q_five_yes.setText("Yes");
        r_btn_q_five_yes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r_btn_q_five_yesActionPerformed(evt);
            }
        });

        btn_g_q_five.add(r_btn_q_five_no);
        r_btn_q_five_no.setText("No");
        r_btn_q_five_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r_btn_q_five_noActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout sub_panel_one3Layout = new javax.swing.GroupLayout(sub_panel_one3);
        sub_panel_one3.setLayout(sub_panel_one3Layout);
        sub_panel_one3Layout.setHorizontalGroup(
            sub_panel_one3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sub_panel_one3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_q_no_one3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_q_one3, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(r_btn_q_five_yes)
                .addGap(22, 22, 22)
                .addComponent(r_btn_q_five_no)
                .addContainerGap())
        );
        sub_panel_one3Layout.setVerticalGroup(
            sub_panel_one3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sub_panel_one3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sub_panel_one3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sub_panel_one3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(r_btn_q_five_yes)
                        .addComponent(r_btn_q_five_no))
                    .addGroup(sub_panel_one3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbl_q_no_one3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbl_q_one3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        sub_panel_one4.setBackground(new java.awt.Color(255, 255, 255));
        sub_panel_one4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));

        lbl_q_no_one4.setBackground(new java.awt.Color(255, 255, 255));
        lbl_q_no_one4.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        lbl_q_no_one4.setText("3.");

        lbl_q_one4.setText("Is there any problem or alarm with AC systems?");

        btn_g_q_three.add(r_btn_q_three_yes);
        r_btn_q_three_yes.setText("Yes");
        r_btn_q_three_yes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r_btn_q_three_yesActionPerformed(evt);
            }
        });

        btn_g_q_three.add(r_btn_q_three_no);
        r_btn_q_three_no.setText("No");
        r_btn_q_three_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r_btn_q_three_noActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout sub_panel_one4Layout = new javax.swing.GroupLayout(sub_panel_one4);
        sub_panel_one4.setLayout(sub_panel_one4Layout);
        sub_panel_one4Layout.setHorizontalGroup(
            sub_panel_one4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sub_panel_one4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_q_no_one4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_q_one4, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(r_btn_q_three_yes)
                .addGap(22, 22, 22)
                .addComponent(r_btn_q_three_no)
                .addContainerGap())
        );
        sub_panel_one4Layout.setVerticalGroup(
            sub_panel_one4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sub_panel_one4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sub_panel_one4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_q_no_one4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(sub_panel_one4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(r_btn_q_three_yes)
                        .addComponent(r_btn_q_three_no))
                    .addComponent(lbl_q_one4))
                .addGap(28, 28, 28))
        );

        sub_panel_one7.setBackground(new java.awt.Color(255, 255, 255));
        sub_panel_one7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));

        lbl_q_no_one7.setBackground(new java.awt.Color(255, 255, 255));
        lbl_q_no_one7.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        lbl_q_no_one7.setText("6.");

        lbl_q_one7.setText("Did anyone who came to the data center or / store?");

        btn_g_q_six.add(r_btn_q_six_yes);
        r_btn_q_six_yes.setText("Yes");
        r_btn_q_six_yes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r_btn_q_six_yesActionPerformed(evt);
            }
        });

        btn_g_q_six.add(r_btn_q_six_no);
        r_btn_q_six_no.setText("No");
        r_btn_q_six_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r_btn_q_six_noActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout sub_panel_one7Layout = new javax.swing.GroupLayout(sub_panel_one7);
        sub_panel_one7.setLayout(sub_panel_one7Layout);
        sub_panel_one7Layout.setHorizontalGroup(
            sub_panel_one7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sub_panel_one7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_q_no_one7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_q_one7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(r_btn_q_six_yes)
                .addGap(24, 24, 24)
                .addComponent(r_btn_q_six_no)
                .addContainerGap())
        );
        sub_panel_one7Layout.setVerticalGroup(
            sub_panel_one7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sub_panel_one7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sub_panel_one7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sub_panel_one7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(r_btn_q_six_yes)
                        .addComponent(r_btn_q_six_no))
                    .addGroup(sub_panel_one7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbl_q_no_one7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbl_q_one7, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout main_panelLayout = new javax.swing.GroupLayout(main_panel);
        main_panel.setLayout(main_panelLayout);
        main_panelLayout.setHorizontalGroup(
            main_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(main_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(main_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sub_panel_one1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sub_panel_one3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sub_panel_one4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sub_panel_one2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sub_panel_one, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sub_panel_one7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        main_panelLayout.setVerticalGroup(
            main_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(main_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sub_panel_one, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sub_panel_one2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sub_panel_one4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sub_panel_one1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sub_panel_one3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sub_panel_one7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        main_panel_two.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        sub_panel_one8.setBackground(new java.awt.Color(255, 255, 255));
        sub_panel_one8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));

        lbl_q_no_one8.setBackground(new java.awt.Color(255, 255, 255));
        lbl_q_no_one8.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        lbl_q_no_one8.setText("7.");

        lbl_q_one8.setText("Are all the rooms clean and neat?  If not please mention the reson.");

        btn_g_q_seven.add(r_btn_q_seven_yes);
        r_btn_q_seven_yes.setText("Yes");
        r_btn_q_seven_yes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r_btn_q_seven_yesActionPerformed(evt);
            }
        });

        btn_g_q_seven.add(r_btn_q_seven_no);
        r_btn_q_seven_no.setText("No");
        r_btn_q_seven_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r_btn_q_seven_noActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout sub_panel_one8Layout = new javax.swing.GroupLayout(sub_panel_one8);
        sub_panel_one8.setLayout(sub_panel_one8Layout);
        sub_panel_one8Layout.setHorizontalGroup(
            sub_panel_one8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sub_panel_one8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_q_no_one8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_q_one8, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(r_btn_q_seven_yes)
                .addGap(24, 24, 24)
                .addComponent(r_btn_q_seven_no)
                .addGap(31, 31, 31))
        );
        sub_panel_one8Layout.setVerticalGroup(
            sub_panel_one8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sub_panel_one8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sub_panel_one8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sub_panel_one8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbl_q_one8, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                        .addComponent(r_btn_q_seven_yes)
                        .addComponent(r_btn_q_seven_no))
                    .addComponent(lbl_q_no_one8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        sub_panel_one9.setBackground(new java.awt.Color(255, 255, 255));
        sub_panel_one9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));

        lbl_q_no_one9.setBackground(new java.awt.Color(255, 255, 255));
        lbl_q_no_one9.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        lbl_q_no_one9.setText("6.1.");

        lbl_q_one9.setText("Is there any task performed during your shift ?");

        btn_g_q_six_1.add(r_btn_q_six_1_yes);
        r_btn_q_six_1_yes.setText("Yes");
        r_btn_q_six_1_yes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r_btn_q_six_1_yesActionPerformed(evt);
            }
        });

        btn_g_q_six_1.add(r_btn_q_six_1_no);
        r_btn_q_six_1_no.setText("No");
        r_btn_q_six_1_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r_btn_q_six_1_noActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout sub_panel_one9Layout = new javax.swing.GroupLayout(sub_panel_one9);
        sub_panel_one9.setLayout(sub_panel_one9Layout);
        sub_panel_one9Layout.setHorizontalGroup(
            sub_panel_one9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sub_panel_one9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_q_no_one9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_q_one9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(r_btn_q_six_1_yes)
                .addGap(24, 24, 24)
                .addComponent(r_btn_q_six_1_no)
                .addGap(31, 31, 31))
        );
        sub_panel_one9Layout.setVerticalGroup(
            sub_panel_one9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sub_panel_one9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sub_panel_one9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sub_panel_one9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbl_q_one9, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                        .addComponent(r_btn_q_six_1_yes)
                        .addComponent(r_btn_q_six_1_no))
                    .addComponent(lbl_q_no_one9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        sub_panel_one10.setBackground(new java.awt.Color(255, 255, 255));
        sub_panel_one10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));

        lbl_q_no_one10.setBackground(new java.awt.Color(255, 255, 255));
        lbl_q_no_one10.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        lbl_q_no_one10.setText("9.");

        lbl_q_one10.setText("Add CENTRIC UPS  and APC UPS  Charge, Load and Runtime ");

        btn_open_dialog_q9.setText("Add");
        btn_open_dialog_q9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_open_dialog_q9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout sub_panel_one10Layout = new javax.swing.GroupLayout(sub_panel_one10);
        sub_panel_one10.setLayout(sub_panel_one10Layout);
        sub_panel_one10Layout.setHorizontalGroup(
            sub_panel_one10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sub_panel_one10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_q_no_one10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_q_one10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_open_dialog_q9)
                .addGap(83, 83, 83))
        );
        sub_panel_one10Layout.setVerticalGroup(
            sub_panel_one10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sub_panel_one10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sub_panel_one10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_q_no_one10, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                    .addComponent(lbl_q_one10, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_open_dialog_q9)))
        );

        sub_panel_one11.setBackground(new java.awt.Color(255, 255, 255));
        sub_panel_one11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));

        lbl_q_no_one11.setBackground(new java.awt.Color(255, 255, 255));
        lbl_q_no_one11.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        lbl_q_no_one11.setText("8.");

        lbl_q_one11.setText("Is the telephone line working?");

        btn_g_q_eghit.add(r_btn_q_eight_yes);
        r_btn_q_eight_yes.setText("Yes");
        r_btn_q_eight_yes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r_btn_q_eight_yesActionPerformed(evt);
            }
        });

        btn_g_q_eghit.add(r_btn_q_eight_no);
        r_btn_q_eight_no.setText("No");
        r_btn_q_eight_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r_btn_q_eight_noActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout sub_panel_one11Layout = new javax.swing.GroupLayout(sub_panel_one11);
        sub_panel_one11.setLayout(sub_panel_one11Layout);
        sub_panel_one11Layout.setHorizontalGroup(
            sub_panel_one11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sub_panel_one11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_q_no_one11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_q_one11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(r_btn_q_eight_yes)
                .addGap(24, 24, 24)
                .addComponent(r_btn_q_eight_no)
                .addGap(31, 31, 31))
        );
        sub_panel_one11Layout.setVerticalGroup(
            sub_panel_one11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sub_panel_one11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sub_panel_one11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sub_panel_one11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbl_q_one11, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                        .addComponent(r_btn_q_eight_yes)
                        .addComponent(r_btn_q_eight_no))
                    .addComponent(lbl_q_no_one11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        sub_panel_one12.setBackground(new java.awt.Color(255, 255, 255));
        sub_panel_one12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));

        lbl_q_no_one12.setBackground(new java.awt.Color(255, 255, 255));
        lbl_q_no_one12.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        lbl_q_no_one12.setText("10.");

        lbl_q_one12.setText("Add Air Ccnditioners Info");

        btn_open_dialog_q10.setText("Add");
        btn_open_dialog_q10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_open_dialog_q10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout sub_panel_one12Layout = new javax.swing.GroupLayout(sub_panel_one12);
        sub_panel_one12.setLayout(sub_panel_one12Layout);
        sub_panel_one12Layout.setHorizontalGroup(
            sub_panel_one12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sub_panel_one12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_q_no_one12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_q_one12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_open_dialog_q10)
                .addGap(89, 89, 89))
        );
        sub_panel_one12Layout.setVerticalGroup(
            sub_panel_one12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sub_panel_one12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sub_panel_one12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_q_no_one12, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                    .addComponent(lbl_q_one12, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_open_dialog_q10)))
        );

        javax.swing.GroupLayout main_panel_twoLayout = new javax.swing.GroupLayout(main_panel_two);
        main_panel_two.setLayout(main_panel_twoLayout);
        main_panel_twoLayout.setHorizontalGroup(
            main_panel_twoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(main_panel_twoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(main_panel_twoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sub_panel_one8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sub_panel_one10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sub_panel_one9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sub_panel_one11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sub_panel_one12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        main_panel_twoLayout.setVerticalGroup(
            main_panel_twoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(main_panel_twoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sub_panel_one9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sub_panel_one8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sub_panel_one11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sub_panel_one10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sub_panel_one12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setForeground(new java.awt.Color(0, 102, 102));

        btn_save.setText("Save");
        btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveActionPerformed(evt);
            }
        });

        jLabel1.setText("Name Of DC Officer :");

        lbl_current_user.setText("name_of_dc_officer");

        jLabel4.setText("Recived From :");

        cb_recived_from.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setText("Delivered to :");

        cb_deliverd_to.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel6.setText("Shift : ");

        cb_shift.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Morning", "Evening ", "Night " }));

        jLabel7.setText("Date and Time of Hand over :");

        lbl_date.setText("10/09/2022");

        btn_activity_list.setText("Activity List");
        btn_activity_list.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_activity_listActionPerformed(evt);
            }
        });

        btn_change_pasword.setText("Change Password");
        btn_change_pasword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_change_paswordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbl_current_user, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                    .addComponent(cb_recived_from, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(110, 110, 110)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cb_deliverd_to, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cb_shift, 0, 167, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_save)
                        .addGap(18, 18, 18)
                        .addComponent(btn_activity_list)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_change_pasword))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbl_date, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lbl_current_user)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_deliverd_to, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(lbl_date))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_change_pasword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(cb_recived_from, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)
                        .addComponent(cb_shift, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_save)
                        .addComponent(btn_activity_list)))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(32, 31, 95));

        jLabel2.setFont(new java.awt.Font("Lucida Fax", 3, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Shift-Based Handover Template for Data Center Activities");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(main_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(main_panel_two, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(main_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(main_panel_two, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void r_btn_q_one_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r_btn_q_one_noActionPerformed
        if (r_btn_q_one_no.isSelected()) {
            q_one_status_yes_no = "no";
        }
    }//GEN-LAST:event_r_btn_q_one_noActionPerformed

    private void r_btn_q_one_yesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r_btn_q_one_yesActionPerformed
        if (r_btn_q_one_yes.isSelected()) {
            q_one_status_yes_no = "yes";
            Question_index_indicator = 1;
            Dialog_box_Q1_4 Incident_dialog = new Dialog_box_Q1_4(this, true);
            Incident_dialog.setLocationRelativeTo(this);
            Incident_dialog.setVisible(true);

        }
    }//GEN-LAST:event_r_btn_q_one_yesActionPerformed

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
        /*
        String uniqueID = UUID.randomUUID().toString();
        String[] IDval = uniqueID.split("-");

        String regID = IDval[0] + IDval[1];
        static_value_of_regID = regID;
        */
        //System.out.println("Reg ID " +regID);

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();
        String current_date = dateFormat.format(cal.getTime());

        if (q_one_status_yes_no.equals("no")) {
            list_for_questio_one = new ArrayList<>();
            Model_Q1_4 model = new Model_Q1_4("--", "--");
            list_for_questio_one.add(model);
        } else {
            if (list_of_incident_for_question_one != null) {
                list_for_questio_one = list_of_incident_for_question_one;
            } else {
                r_btn_q_one_no.setSelected(true);
                list_for_questio_one = new ArrayList<>();
                Model_Q1_4 model = new Model_Q1_4("--", "--");
                list_for_questio_one.add(model);
            }

        }

        if (q_two_status_yes_no.equals("no")) {
            list_for_questio_two = new ArrayList<>();
            Model_Q1_4 model = new Model_Q1_4("--", "--");
            list_for_questio_two.add(model);
        } else {
            if (list_of_incident_for_question_two != null) {
                list_for_questio_two = list_of_incident_for_question_two;
            } else {
                r_btn_q_two_no.setSelected(true);
                list_for_questio_two = new ArrayList<>();
                Model_Q1_4 model = new Model_Q1_4("--", "--");
                list_for_questio_two.add(model);
            }

        }

        if (q_three_status_yes_no.equals("no")) {
            list_for_questio_three = new ArrayList<>();
            Model_Q1_4 model = new Model_Q1_4("--", "--");
            list_for_questio_three.add(model);
        } else {
            if (list_of_incident_for_question_three != null) {
                list_for_questio_three = list_of_incident_for_question_three;
            } else {
                r_btn_q_three_no.setSelected(true);
                list_for_questio_three = new ArrayList<>();
                Model_Q1_4 model = new Model_Q1_4("--", "--");
                list_for_questio_three.add(model);
            }

        }

        if (q_four_status_yes_no.equals("no")) {
            if (list_of_incident_for_question_four != null) {
                list_for_questio_four = list_of_incident_for_question_four;
            } else {
                r_btn_q_four_no.setSelected(true);
                list_for_questio_four = new ArrayList<>();
                Model_Q1_4 model = new Model_Q1_4("--", "--");
                list_for_questio_four.add(model);
            }                     
        } else {
            list_for_questio_four = new ArrayList<>();
            Model_Q1_4 model = new Model_Q1_4("--", "--");
            list_for_questio_four.add(model);
        }

        if (q_five_status_yes_no.equals("no")) {
            list_for_questio_five = new ArrayList<>();
            Model_Q5 model = new Model_Q5("--", "--", "--", "--");
            list_for_questio_five.add(model);
        } else {
            if (list_of_genenator_info_for_question_five != null) {
                list_for_questio_five = list_of_genenator_info_for_question_five;
                //System.out.println("Log Q 5 -- if statment--");
                //list_for_questio_five.forEach((e) -> System.out.println("time " + e.getTime_() +" des " + e.getGenenetor_status_description()));
            } else {
                r_btn_q_five_no.setSelected(true);
                list_for_questio_five = new ArrayList<>();
                Model_Q5 model = new Model_Q5("--", "--", "--", "--");
                list_for_questio_five.add(model);
            }

        }

        if (q_six_status_yes_no.equals("no")) {
            list_for_questio_six = new ArrayList<>();
            Model_Q6 model = new Model_Q6("--", "--", "--");
            list_for_questio_six.add(model);
        } else {
            if (list_of_data_center_visitor_for_question_six != null) {
                list_for_questio_six = list_of_data_center_visitor_for_question_six;
            } else {
                r_btn_q_six_no.setSelected(true);
                list_for_questio_six = new ArrayList<>();
                Model_Q6 model = new Model_Q6("--", "--", "--");
                list_for_questio_six.add(model);
            }

        }

        if (q_six_1_status_yes_no.equals("no")) {
            list_for_questio_six_one = new ArrayList<>();
            Model_Q6_1_8 model = new Model_Q6_1_8("--");
            list_for_questio_six_one.add(model);
        } else {
            if (list_of_description_for_question_six_one != null) {
                list_for_questio_six_one = list_of_description_for_question_six_one;
            } else {
                r_btn_q_six_1_no.setSelected(true);
                list_for_questio_six_one = new ArrayList<>();
                Model_Q6_1_8 model = new Model_Q6_1_8("--");
                list_for_questio_six_one.add(model);
            }

        }

        if (q_seven_status_yes_no.equals("yes")) {
            list_for_questio_seven = new ArrayList<>();
            Model_Q6_1_8 model = new Model_Q6_1_8("--");
            list_for_questio_seven.add(model);
        } else {
            if (list_of_description_for_question_seven != null) {
                list_for_questio_seven = list_of_description_for_question_seven;
            } else {
                r_btn_q_seven_yes.setSelected(true);
                list_for_questio_seven = new ArrayList<>();
                Model_Q6_1_8 model = new Model_Q6_1_8("--");
                list_for_questio_seven.add(model);
            }

        }

        if (q_eghit_status_yes_no.equals("yes")) {
            list_for_questio_eghit = new ArrayList<>();
            Model_Q6_1_8 model = new Model_Q6_1_8("--");
            list_for_questio_eghit.add(model);
        } else {
            if (list_of_description_for_question_eghit != null) {
                list_for_questio_eghit = list_of_description_for_question_eghit;
            } else {
                r_btn_q_eight_yes.setSelected(true);
                list_for_questio_eghit = new ArrayList<>();
                Model_Q6_1_8 model = new Model_Q6_1_8("--");
                list_for_questio_eghit.add(model);
            }
        }

        /*
            Q9
         */
        if (list_of_ups_for_question_nine != null) {
            list_for_questio_nine = list_of_ups_for_question_nine;
        }

        /*
            Q 10
         */
        if (list_of_air_conditionners_for_question_ten != null) {
            list_for_questio_ten = list_of_air_conditionners_for_question_ten;
        }

        /*for Q 5*/
        Model_Q5 mode5 = new Model_Q5(list_for_questio_five.get(0).getTime_(),
                list_for_questio_five.get(0).getGenenetor_oprated_normally(), 
                list_for_questio_five.get(0).getGenenetor_status_description(),
                list_for_questio_five.get(0).getIs_there_any_fule_for_24h());
        
        //System.out.println("log on model Q5 ");
        //System.out.println("model log des " + list_for_questio_five.get(0).getGenenetor_status_description());

        /*for Q 6*/
        Model_Q6 model6 = new Model_Q6(list_for_questio_six.get(0).getVisitor_name(), list_for_questio_six.get(0).getMeanse_of_auth(), list_for_questio_six.get(0).getPurpose_of_the_visitor());
        /*
        System.out.println("Model Q 61 Dess" + list_for_questio_six_one.get(0).getDescription());
        System.out.println("Model Q 7 Dess" + list_for_questio_seven.get(0).getDescription());
        System.out.println("Model Q 8 Dess" + list_for_questio_eghit.get(0).getDescription());
        */
        /*for Q 61-8*/
        /*for Q 9*/
        /*for Q 10*/
        /*for Q req */
        String fullname = CURRENT_USER_INFO.get(0).getF_name() + " " + CURRENT_USER_INFO.get(0).getL_name();
        String shift = String.valueOf(cb_shift.getSelectedItem());
        String recived_from = String.valueOf(cb_recived_from.getSelectedItem());
        String deliverd_to = String.valueOf(cb_deliverd_to.getSelectedItem());

        if ((list_for_questio_nine != null) && (list_for_questio_ten != null)) {
            /*for Q 1- 4*/
            databasemanager.add_DATA_1_TABLE(regID, list_for_questio_one, list_for_questio_two, list_for_questio_three, list_for_questio_four);
            /*for Q 5*/
            databasemanager.add_DATA_2_TABLE(regID, mode5);
            /*for Q 6*/
            //databasemanager.add_DATA_3_TABLE(regID, model6);
            /* for Q61 - 8*/
            databasemanager.add_DATA_4_TABLE(regID, list_for_questio_six_one, list_for_questio_seven, list_for_questio_eghit);
            /*for Q 9*/

            Model_Q9 model = new Model_Q9(
                    list_for_questio_nine.get(0).getTxt_field_L_1_Q9_ups_charge_centric_ups(),
                    list_for_questio_nine.get(0).getTxt_field_L_2_Q9_ups_charge_centric_ups(),
                    list_for_questio_nine.get(0).getTxt_field_L_3_Q9_ups_charge_centric_ups(),
                    list_for_questio_nine.get(0).getTxt_field_L_1_Q9_ups_load_centric_ups(),
                    list_for_questio_nine.get(0).getTxt_field_L_2_Q9_ups_load_centric_ups(),
                    list_for_questio_nine.get(0).getTxt_field_L_3_Q9_ups_load_centric_ups(),
                    list_for_questio_nine.get(0).getTxt_field_L_123_Q9_runtime_centric_ups(),
                    list_for_questio_nine.get(0).getTxt_field_L_1_Q9_ups_charge_apc_ups(),
                    list_for_questio_nine.get(0).getTxt_field_L_2_Q9_ups_charge_apc_ups(),
                    list_for_questio_nine.get(0).getTxt_field_L_3_Q9_ups_charge_apc_ups(),
                    list_for_questio_nine.get(0).getTxt_field_L_1_Q9_ups_load_apc_ups(),
                    list_for_questio_nine.get(0).getTxt_field_L_2_Q9_ups_load_apc_ups(),
                    list_for_questio_nine.get(0).getTxt_field_L_3_Q9_ups_load_apc_ups(),
                    list_for_questio_nine.get(0).getTxt_field_L_123_Q9_runtime_apc_ups()
            );
            databasemanager.add_DATA_5_TABLE(regID, model);

            /*for Q 10*/
            Model_Q10 model10 = new Model_Q10(
                    list_for_questio_ten.get(0).getACRD_602_INROW_1(),
                    list_for_questio_ten.get(0).getACRP_102_INROW_2(),
                    list_for_questio_ten.get(0).getACRP_102_INROW_3(),
                    list_for_questio_ten.get(0).getACRP_102_INROW_4(),
                    list_for_questio_ten.get(0).getACRP_102_INROW_5(),
                    list_for_questio_ten.get(0).getCARRIER_F201(),
                    list_for_questio_ten.get(0).getCARRIER_F205(),
                    list_for_questio_ten.get(0).getROYAL_F202(),
                    list_for_questio_ten.get(0).getROYAL_F203(),
                    list_for_questio_ten.get(0).getLG_F204(),
                    list_for_questio_ten.get(0).getInventor_1(),
                    list_for_questio_ten.get(0).getInventor_2(),
                    list_for_questio_ten.get(0).getInventor_3(),
                    list_for_questio_ten.get(0).getInventor_4()
            );
            databasemanager.add_DATA_6_TABLE(regID, model10);

            databasemanager.add_DATA_7_TABLE(regID, CURRENT_USER_INFO.get(0).getUser_name(), fullname, recived_from, deliverd_to, shift, current_date, current_date);
            JOptionPane.showMessageDialog(this, "Activity Saved Successfully!", "", JOptionPane.INFORMATION_MESSAGE);

        } else {
            JOptionPane.showMessageDialog(this, "Please Fill the Form Properlly! in Question 10 or 9", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        /*
        System.out.println("recived From " + recived_from);
        System.out.println("Deliverd to " + deliverd_to);
        System.out.println("Shift " + shift);
        System.out.println("Full name " + fullname);
        */
    }//GEN-LAST:event_btn_saveActionPerformed

    private void r_btn_q_two_yesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r_btn_q_two_yesActionPerformed
        if (r_btn_q_two_yes.isSelected()) {
            q_two_status_yes_no = "yes";
            Question_index_indicator = 2;
            Dialog_box_Q1_4 Incident_dialog = new Dialog_box_Q1_4(this, true);
            Incident_dialog.setLocationRelativeTo(this);
            Incident_dialog.setVisible(true);

        }
    }//GEN-LAST:event_r_btn_q_two_yesActionPerformed

    private void r_btn_q_two_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r_btn_q_two_noActionPerformed
        q_two_status_yes_no = "no";
    }//GEN-LAST:event_r_btn_q_two_noActionPerformed

    private void r_btn_q_three_yesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r_btn_q_three_yesActionPerformed
        if (r_btn_q_three_yes.isSelected()) {
            q_three_status_yes_no = "yes";
            Question_index_indicator = 3;
            Dialog_box_Q1_4 Incident_dialog = new Dialog_box_Q1_4(this, true);
            Incident_dialog.setLocationRelativeTo(this);
            Incident_dialog.setVisible(true);
        }
    }//GEN-LAST:event_r_btn_q_three_yesActionPerformed

    private void r_btn_q_three_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r_btn_q_three_noActionPerformed
        q_three_status_yes_no = "no";
    }//GEN-LAST:event_r_btn_q_three_noActionPerformed

    private void r_btn_q_four_yesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r_btn_q_four_yesActionPerformed
        q_four_status_yes_no = "yes";       
    }//GEN-LAST:event_r_btn_q_four_yesActionPerformed

    private void r_btn_q_four_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r_btn_q_four_noActionPerformed
        if (r_btn_q_four_no.isSelected()) {
            q_four_status_yes_no = "no";
            Question_index_indicator = 4;
            Dialog_box_Q1_4 Incident_dialog = new Dialog_box_Q1_4(this, true);
            Incident_dialog.setLocationRelativeTo(this);
            Incident_dialog.setVisible(true);
        }
    }//GEN-LAST:event_r_btn_q_four_noActionPerformed

    private void r_btn_q_five_yesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r_btn_q_five_yesActionPerformed
        if (r_btn_q_five_yes.isSelected()) {
            q_five_status_yes_no = "yes";
            Question_index_indicator = 5;
            Dialog_box_Q5 Incident_dialog = new Dialog_box_Q5(this, true);
            Incident_dialog.setLocationRelativeTo(this);
            Incident_dialog.setVisible(true);
        }
    }//GEN-LAST:event_r_btn_q_five_yesActionPerformed

    private void r_btn_q_five_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r_btn_q_five_noActionPerformed
        q_five_status_yes_no = "no";
    }//GEN-LAST:event_r_btn_q_five_noActionPerformed

    private void r_btn_q_six_yesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r_btn_q_six_yesActionPerformed
        if (r_btn_q_six_yes.isSelected()) {
            q_six_status_yes_no = "yes";
            Question_index_indicator = 6;
            Dialog_box_Q6 Incident_dialog = new Dialog_box_Q6(this, true);
            Incident_dialog.setLocationRelativeTo(this);
            Incident_dialog.setVisible(true);
        }
    }//GEN-LAST:event_r_btn_q_six_yesActionPerformed

    private void r_btn_q_six_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r_btn_q_six_noActionPerformed
        q_six_status_yes_no = "no";
    }//GEN-LAST:event_r_btn_q_six_noActionPerformed

    private void r_btn_q_seven_yesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r_btn_q_seven_yesActionPerformed
        q_seven_status_yes_no = "yes";
    }//GEN-LAST:event_r_btn_q_seven_yesActionPerformed

    private void r_btn_q_seven_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r_btn_q_seven_noActionPerformed
        if (r_btn_q_seven_no.isSelected()) {
            q_seven_status_yes_no = "no";
            Question_index_indicator = 7;
            Dialog_box_Q6_1_Q8 Incident_dialog = new Dialog_box_Q6_1_Q8(this, true);
            Incident_dialog.setLocationRelativeTo(this);
            Incident_dialog.setVisible(true);
        }
    }//GEN-LAST:event_r_btn_q_seven_noActionPerformed

    private void r_btn_q_six_1_yesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r_btn_q_six_1_yesActionPerformed
        if (r_btn_q_six_1_yes.isSelected()) {
            q_six_1_status_yes_no = "yes";
            Question_index_indicator = 61;
            Dialog_box_Q6_1_Q8 Incident_dialog = new Dialog_box_Q6_1_Q8(this, true);
            Incident_dialog.setLocationRelativeTo(this);
            Incident_dialog.setVisible(true);
        }
    }//GEN-LAST:event_r_btn_q_six_1_yesActionPerformed

    private void r_btn_q_six_1_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r_btn_q_six_1_noActionPerformed
        q_six_1_status_yes_no = "no";
    }//GEN-LAST:event_r_btn_q_six_1_noActionPerformed

    private void r_btn_q_eight_yesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r_btn_q_eight_yesActionPerformed
        q_eghit_status_yes_no = "yes";
    }//GEN-LAST:event_r_btn_q_eight_yesActionPerformed

    private void r_btn_q_eight_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r_btn_q_eight_noActionPerformed
        if (r_btn_q_eight_no.isSelected()) {
            q_eghit_status_yes_no = "no";
            Question_index_indicator = 8;
            Dialog_box_Q6_1_Q8 Incident_dialog = new Dialog_box_Q6_1_Q8(this, true);
            Incident_dialog.setLocationRelativeTo(this);
            Incident_dialog.setVisible(true);
        }
    }//GEN-LAST:event_r_btn_q_eight_noActionPerformed

    private void btn_open_dialog_q9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_open_dialog_q9ActionPerformed
        Dialog_box_Q9 Incident_dialog = new Dialog_box_Q9(this, true);
        Incident_dialog.setLocationRelativeTo(this);

        Incident_dialog.setVisible(true);
    }//GEN-LAST:event_btn_open_dialog_q9ActionPerformed

    private void btn_open_dialog_q10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_open_dialog_q10ActionPerformed
        Dialog_box_Q10 Incident_dialog = new Dialog_box_Q10(this, true);
        Incident_dialog.setLocationRelativeTo(this);
        Incident_dialog.setVisible(true);
    }//GEN-LAST:event_btn_open_dialog_q10ActionPerformed

    private void btn_activity_listActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_activity_listActionPerformed
        Activity_List activity_List = new Activity_List();
        activity_List.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_activity_listActionPerformed

    private void btn_change_paswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_change_paswordActionPerformed
        Dialog_box_Change_Password Dialog_box_Change_Password_ = new Dialog_box_Change_Password(this, true);
        Dialog_box_Change_Password_.setLocationRelativeTo(this);
        Dialog_box_Change_Password_.setVisible(true);
    }//GEN-LAST:event_btn_change_paswordActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_activity_list;
    private javax.swing.JButton btn_change_pasword;
    private javax.swing.ButtonGroup btn_g__one;
    private javax.swing.ButtonGroup btn_g_q_eghit;
    private javax.swing.ButtonGroup btn_g_q_five;
    private javax.swing.ButtonGroup btn_g_q_four;
    private javax.swing.ButtonGroup btn_g_q_seven;
    private javax.swing.ButtonGroup btn_g_q_six;
    private javax.swing.ButtonGroup btn_g_q_six_1;
    private javax.swing.ButtonGroup btn_g_q_three;
    private javax.swing.ButtonGroup btn_g_q_two;
    private javax.swing.JButton btn_open_dialog_q10;
    private javax.swing.JButton btn_open_dialog_q9;
    private javax.swing.JButton btn_save;
    private javax.swing.JComboBox<String> cb_deliverd_to;
    private javax.swing.JComboBox<String> cb_recived_from;
    private javax.swing.JComboBox<String> cb_shift;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbl_current_user;
    private javax.swing.JLabel lbl_date;
    private javax.swing.JLabel lbl_q_no_one;
    private javax.swing.JLabel lbl_q_no_one1;
    private javax.swing.JLabel lbl_q_no_one10;
    private javax.swing.JLabel lbl_q_no_one11;
    private javax.swing.JLabel lbl_q_no_one12;
    private javax.swing.JLabel lbl_q_no_one2;
    private javax.swing.JLabel lbl_q_no_one3;
    private javax.swing.JLabel lbl_q_no_one4;
    private javax.swing.JLabel lbl_q_no_one7;
    private javax.swing.JLabel lbl_q_no_one8;
    private javax.swing.JLabel lbl_q_no_one9;
    private javax.swing.JLabel lbl_q_one;
    private javax.swing.JLabel lbl_q_one1;
    private javax.swing.JLabel lbl_q_one10;
    private javax.swing.JLabel lbl_q_one11;
    private javax.swing.JLabel lbl_q_one12;
    private javax.swing.JLabel lbl_q_one2;
    private javax.swing.JLabel lbl_q_one3;
    private javax.swing.JLabel lbl_q_one4;
    private javax.swing.JLabel lbl_q_one7;
    private javax.swing.JLabel lbl_q_one8;
    private javax.swing.JLabel lbl_q_one9;
    private javax.swing.JPanel main_panel;
    private javax.swing.JPanel main_panel_two;
    private javax.swing.JRadioButton r_btn_q_eight_no;
    private javax.swing.JRadioButton r_btn_q_eight_yes;
    private javax.swing.JRadioButton r_btn_q_five_no;
    private javax.swing.JRadioButton r_btn_q_five_yes;
    private javax.swing.JRadioButton r_btn_q_four_no;
    private javax.swing.JRadioButton r_btn_q_four_yes;
    private javax.swing.JRadioButton r_btn_q_one_no;
    private javax.swing.JRadioButton r_btn_q_one_yes;
    private javax.swing.JRadioButton r_btn_q_seven_no;
    private javax.swing.JRadioButton r_btn_q_seven_yes;
    private javax.swing.JRadioButton r_btn_q_six_1_no;
    private javax.swing.JRadioButton r_btn_q_six_1_yes;
    private javax.swing.JRadioButton r_btn_q_six_no;
    private javax.swing.JRadioButton r_btn_q_six_yes;
    private javax.swing.JRadioButton r_btn_q_three_no;
    private javax.swing.JRadioButton r_btn_q_three_yes;
    private javax.swing.JRadioButton r_btn_q_two_no;
    private javax.swing.JRadioButton r_btn_q_two_yes;
    private javax.swing.JPanel sub_panel_one;
    private javax.swing.JPanel sub_panel_one1;
    private javax.swing.JPanel sub_panel_one10;
    private javax.swing.JPanel sub_panel_one11;
    private javax.swing.JPanel sub_panel_one12;
    private javax.swing.JPanel sub_panel_one2;
    private javax.swing.JPanel sub_panel_one3;
    private javax.swing.JPanel sub_panel_one4;
    private javax.swing.JPanel sub_panel_one7;
    private javax.swing.JPanel sub_panel_one8;
    private javax.swing.JPanel sub_panel_one9;
    // End of variables declaration//GEN-END:variables
}

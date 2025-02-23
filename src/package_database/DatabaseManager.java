package package_database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static package_database.DB_Connection.DB_PASSWORD;
import static package_database.DB_Connection.DB_URL;
import static package_database.DB_Connection.DB_USERNAME;
import package_model.Model_Q10;
import package_model.Model_Q1_4;
import package_model.Model_Q5;
import package_model.Model_Q6;
import package_model.Model_Q678;
import package_model.Model_Q6_1_8;
import package_model.Model_Q9;
import package_model.Model_QT1_4;
import package_model.Model_Show_Basic_info;


public class DatabaseManager {

    private Connection connection;
    private Statement stmt;

    /*
    
    CREATE_DATA_1_TABLE [table 1-4] -> have regID
    CREATE_DATA_2_TABLE [table 5] -> have regID
    CREATE_DATA_3_TABLE [table 6] -> have regID
    CREATE_DATA_4_TABLE [table 61-8] -> have regID
    CREATE_DATA_5_TABLE [table 9] -> have regID
    CREATE_DATA_6_TABLE [table 10] -> have regID
    CREATE_DATA_7_TABLE [regID, username, date]
    
     */
    private static final String CREATE_DATA_1_TABLE = "CREATE TABLE IF NOT EXISTS CREATE_DATA_1_TABLE "
            + "(regID VARCHAR(255) NOT NULL PRIMARY KEY,"
            + " Severity_status_q1 VARCHAR(255), "
            + " Incident_description_q1 VARCHAR(5000), "
            + " Severity_status_q2 VARCHAR(255), "
            + " Incident_description_q2 VARCHAR(5000), "
            + " Severity_status_q3 VARCHAR(255), "
            + " Incident_description_q3 VARCHAR(5000), "
            + " Severity_status_q4 VARCHAR(255), "
            + " Incident_description_q4 VARCHAR(5000))";

    private static final String CREATE_DATA_2_TABLE = "CREATE TABLE IF NOT EXISTS CREATE_DATA_2_TABLE "
            + "(regID VARCHAR(255) NOT NULL PRIMARY KEY,"
            + " power_inturaption_time_q5 VARCHAR(255), "
            + " genenetor_oprated_normally__q5 VARCHAR(255), "
            + " genenetor_status_description_q5 VARCHAR(5000), "
            + " is_there_any_fule_for_24h__q5 VARCHAR(255))";

    private static final String CREATE_DATA_3_TABLE = "CREATE TABLE IF NOT EXISTS CREATE_DATA_3_TABLE "
            + "(ID bigint auto_increment NOT NULL PRIMARY KEY,"
            + " regID VARCHAR(255), "
            + " visitor_name_q6 VARCHAR(255), "
            + " meanse_of_auth_q6 VARCHAR(255), "
            + " purpose_of_the_visitor_q6 VARCHAR(15000))";

    private static final String CREATE_DATA_4_TABLE = "CREATE TABLE IF NOT EXISTS CREATE_DATA_4_TABLE "
            + "(regID VARCHAR(255) NOT NULL PRIMARY KEY,"
            + " description_q61 VARCHAR(5000), "
            + " description_7 VARCHAR(5000), "
            + " description_8 VARCHAR(5000))";

    private static final String CREATE_DATA_5_TABLE = "CREATE TABLE IF NOT EXISTS CREATE_DATA_5_TABLE "
            + "(regID VARCHAR(255) NOT NULL PRIMARY KEY,"
            + " L_1_Q9_ups_charge_centric_ups VARCHAR(255), "
            + " L_2_Q9_ups_charge_centric_ups VARCHAR(255), "
            + " L_3_Q9_ups_charge_centric_ups VARCHAR(255), "
            + " L_1_Q9_ups_load_centric_ups VARCHAR(255), "
            + " L_2_Q9_ups_load_centric_ups VARCHAR(255), "
            + " L_3_Q9_ups_load_centric_ups VARCHAR(255), "
            + " L_123_Q9_runtime_centric_ups VARCHAR(255), "
            + " L_1_Q9_ups_charge_apc_ups VARCHAR(255),"
            + " L_2_Q9_ups_charge_apc_ups VARCHAR(255),"
            + " L_3_Q9_ups_charge_apc_ups VARCHAR(255),"
            + " L_1_Q9_ups_load_apc_ups VARCHAR(255),"
            + " L_2_Q9_ups_load_apc_ups VARCHAR(255),"
            + " L_3_Q9_ups_load_apc_ups VARCHAR(255),"
            + " L_123_Q9_runtime_apc_ups VARCHAR(255))";

    private static final String CREATE_DATA_6_TABLE = "CREATE TABLE IF NOT EXISTS CREATE_DATA_6_TABLE "
            + "(regID VARCHAR(255) NOT NULL PRIMARY KEY,"
            + " ACRD_602_INROW_1_q10 VARCHAR(255), "
            + " ACRP_102_INROW_2_q10 VARCHAR(255), "
            + " ACRP_102_INROW_3_q10 VARCHAR(255), "
            + " ACRP_102_INROW_4_q10 VARCHAR(255), "
            + " ACRP_102_INROW_5_q10 VARCHAR(255), "
            + " CARRIER_F201_q10 VARCHAR(255), "
            + " CARRIER_F205_q10 VARCHAR(255), "
            + " ROYAL_F202_q10 VARCHAR(255),"
            + " ROYAL_F203_q10 VARCHAR(255),"
            + " LG_F204_q10 VARCHAR(255),"
            + " Inventor_1_q10 VARCHAR(255),"
            + " Inventor_2_q10 VARCHAR(255),"
            + " Inventor_3_q10 VARCHAR(255),"
            + " Inventor_4_10 VARCHAR(255))";

    private static final String CREATE_DATA_7_TABLE = "CREATE TABLE IF NOT EXISTS CREATE_DATA_7_TABLE "
            + "(regID VARCHAR(255) NOT NULL PRIMARY KEY,"
            + " current_user VARCHAR(255), "
            + " fullname VARCHAR(255), "
            + " recived_from VARCHAR(255), "
            + " deliverd_to VARCHAR(255), "
            + " shift VARCHAR(255), "
            + " reg_date VARCHAR(255), "
            + " update_date VARCHAR(255))";

    public DatabaseManager() {
        openConnection();
    }

    public void openConnection() {
        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            stmt = connection.createStatement();
            stmt.execute(CREATE_DATA_1_TABLE);
            stmt.execute(CREATE_DATA_2_TABLE);
            stmt.execute(CREATE_DATA_3_TABLE);
            stmt.execute(CREATE_DATA_4_TABLE);
            stmt.execute(CREATE_DATA_5_TABLE);
            stmt.execute(CREATE_DATA_6_TABLE);
            stmt.execute(CREATE_DATA_7_TABLE);
        } catch (ClassNotFoundException | SQLException ex) {

        }
    }

    public void add_DATA_1_TABLE(String regID, List<Model_Q1_4> list_for_questio_one, List<Model_Q1_4> list_for_questio_two, List<Model_Q1_4> list_for_questio_three, List<Model_Q1_4> list_for_questio_four) {

        String sql = "INSERT INTO CREATE_DATA_1_TABLE (regID, Severity_status_q1, Incident_description_q1, Severity_status_q2, Incident_description_q2, Severity_status_q3, Incident_description_q3, Severity_status_q4, Incident_description_q4) VALUES"
                + " ('" + regID + "',"
                + " '" + list_for_questio_one.get(0).getSeverity_status() + "', "
                + " '" + list_for_questio_one.get(0).getIncident_description() + "', "
                + " '" + list_for_questio_two.get(0).getSeverity_status() + "', "
                + " '" + list_for_questio_two.get(0).getIncident_description() + "', "
                + " '" + list_for_questio_three.get(0).getSeverity_status() + "', "
                + " '" + list_for_questio_three.get(0).getIncident_description() + "', "
                + " '" + list_for_questio_four.get(0).getSeverity_status() + "', "
                + " '" + list_for_questio_four.get(0).getIncident_description() + "')";
        try {
            stmt.execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(User_DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//data table 1

    public void add_DATA_2_TABLE(String regID, Model_Q5 data_table_2) {
        //System.out.println("Log in the insert table");
        //System.out.println("des " + data_table_2.getGenenetor_status_description());
        String sql = "INSERT INTO CREATE_DATA_2_TABLE (regID, power_inturaption_time_q5, genenetor_oprated_normally__q5, genenetor_status_description_q5,is_there_any_fule_for_24h__q5) VALUES"
                + " ('" + regID + "',"
                + " '" + data_table_2.getTime_() + "', "
                + " '" + data_table_2.getGenenetor_oprated_normally() + "', "
                + " '" + data_table_2.getGenenetor_status_description() + "', "
                + " '" + data_table_2.getIs_there_any_fule_for_24h() + "')";
        try {
            stmt.execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(User_DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//data table 2

    public void add_DATA_3_TABLE(String regID, Model_Q6 data_table_3) {
        String sql = "INSERT INTO CREATE_DATA_3_TABLE (regID,visitor_name_q6, meanse_of_auth_q6, purpose_of_the_visitor_q6) VALUES"
                + " ('" + regID + "',"
                + " '" + data_table_3.getVisitor_name() + "', "
                + " '" + data_table_3.getMeanse_of_auth() + "', "
                + " '" + data_table_3.getPurpose_of_the_visitor() + "')";
        try {
            stmt.execute(sql);
        } catch (SQLException ex) {
            System.err.println("err " + ex.getMessage());
            Logger.getLogger(User_DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//data table 3

    public void add_DATA_4_TABLE(String regID, List<Model_Q6_1_8> list_des_six_one, List<Model_Q6_1_8> list_des_seven, List<Model_Q6_1_8> list_des_eghit) {
        String sql = "INSERT INTO CREATE_DATA_4_TABLE (regID, description_q61, description_7, description_8) VALUES"
                + " ('" + regID + "',"
                + " '" + list_des_six_one.get(0).getDescription() + "', "
                + " '" + list_des_seven.get(0).getDescription() + "', "
                + " '" + list_des_eghit.get(0).getDescription() + "')";
        try {
            stmt.execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(User_DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void add_DATA_5_TABLE(String regID, Model_Q9 data_table_5) {
        String sql = "INSERT INTO CREATE_DATA_5_TABLE (regID, L_1_Q9_ups_charge_centric_ups, L_2_Q9_ups_charge_centric_ups, L_3_Q9_ups_charge_centric_ups, L_1_Q9_ups_load_centric_ups, L_2_Q9_ups_load_centric_ups, L_3_Q9_ups_load_centric_ups, L_123_Q9_runtime_centric_ups, L_1_Q9_ups_charge_apc_ups, L_2_Q9_ups_charge_apc_ups, L_3_Q9_ups_charge_apc_ups, L_1_Q9_ups_load_apc_ups, L_2_Q9_ups_load_apc_ups, L_3_Q9_ups_load_apc_ups, L_123_Q9_runtime_apc_ups) VALUES"
                + " ('" + regID + "',"
                + " '" + data_table_5.getTxt_field_L_1_Q9_ups_charge_centric_ups() + "', "
                + " '" + data_table_5.getTxt_field_L_2_Q9_ups_charge_centric_ups() + "', "
                + " '" + data_table_5.getTxt_field_L_3_Q9_ups_charge_centric_ups() + "', "
                + " '" + data_table_5.getTxt_field_L_1_Q9_ups_load_centric_ups() + "', "
                + " '" + data_table_5.getTxt_field_L_2_Q9_ups_load_centric_ups() + "', "
                + " '" + data_table_5.getTxt_field_L_3_Q9_ups_load_centric_ups() + "', "
                + " '" + data_table_5.getTxt_field_L_123_Q9_runtime_centric_ups() + "', "
                + " '" + data_table_5.getTxt_field_L_1_Q9_ups_charge_apc_ups() + "', "
                + " '" + data_table_5.getTxt_field_L_2_Q9_ups_charge_apc_ups() + "', "
                + " '" + data_table_5.getTxt_field_L_3_Q9_ups_charge_apc_ups() + "', "
                + " '" + data_table_5.getTxt_field_L_1_Q9_ups_load_apc_ups() + "', "
                + " '" + data_table_5.getTxt_field_L_2_Q9_ups_load_apc_ups() + "', "
                + " '" + data_table_5.getTxt_field_L_3_Q9_ups_load_apc_ups() + "', "
                + " '" + data_table_5.getTxt_field_L_123_Q9_runtime_apc_ups() + "')";
        try {
            stmt.execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(User_DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void add_DATA_6_TABLE(String regID, Model_Q10 data_table_6) {
        String sql = "INSERT INTO CREATE_DATA_6_TABLE (regID, ACRD_602_INROW_1_q10, ACRP_102_INROW_2_q10, ACRP_102_INROW_3_q10, ACRP_102_INROW_4_q10, ACRP_102_INROW_5_q10, CARRIER_F201_q10, CARRIER_F205_q10, ROYAL_F202_q10, ROYAL_F203_q10, LG_F204_q10, Inventor_1_q10, Inventor_2_q10, Inventor_3_q10, Inventor_4_10) VALUES"
                + " ('" + regID + "',"
                + " '" + data_table_6.getACRD_602_INROW_1() + "', "
                + " '" + data_table_6.getACRP_102_INROW_2() + "', "
                + " '" + data_table_6.getACRP_102_INROW_3() + "', "
                + " '" + data_table_6.getACRP_102_INROW_4() + "', "
                + " '" + data_table_6.getACRP_102_INROW_5() + "', "
                + " '" + data_table_6.getCARRIER_F201() + "', "
                + " '" + data_table_6.getCARRIER_F205() + "', "
                + " '" + data_table_6.getROYAL_F202() + "', "
                + " '" + data_table_6.getROYAL_F203() + "', "
                + " '" + data_table_6.getLG_F204() + "', "
                + " '" + data_table_6.getInventor_1() + "', "
                + " '" + data_table_6.getInventor_2() + "', "
                + " '" + data_table_6.getInventor_3() + "', "
                + " '" + data_table_6.getInventor_4() + "')";

        try {
            stmt.execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(User_DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void add_DATA_7_TABLE(String regID, String username,String fullname,String recived_from,String deliverd_to,String shift, String current_date, String update_date) {
        String sql = "INSERT INTO CREATE_DATA_7_TABLE (regID, current_user,fullname,recived_from,deliverd_to,shift,reg_date, update_date) VALUES"
                + " ('" + regID + "',"
                + " '" + username + "', "
                + " '" + fullname + "', "
                + " '" + recived_from + "', "
                + " '" + deliverd_to + "', "
                + " '" + shift + "', "
                + " '" + current_date + "', "
                + " '" + update_date + "')";
        try{
            stmt.execute(sql);
        }catch(SQLException ex){
            Logger.getLogger(User_DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public List<Model_QT1_4> get_data_Table_1(String regID){
        List<Model_QT1_4> list_of_q1_4 = new ArrayList<>();
        try{
            String sql = "SELECT * FROM CREATE_DATA_1_TABLE WHERE regID = '"+ regID +"'";
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                Model_QT1_4 model = new Model_QT1_4();
                
                model.setRegID(rs.getString("regID"));
                
                model.setSSQ1(rs.getString("Severity_status_q1"));
                model.setISQ1(rs.getString("Incident_description_q1"));
                
                model.setSSQ2(rs.getString("Severity_status_q2"));
                model.setISQ2(rs.getString("Incident_description_q2"));
                
                model.setSSQ3(rs.getString("Severity_status_q3"));
                model.setISQ3(rs.getString("Incident_description_q3"));
                
                model.setSSQ4(rs.getString("Severity_status_q4"));
                model.setISQ4(rs.getString("Incident_description_q4"));
                
                list_of_q1_4.add(model);
                
            }//end of while 
            
        }catch(SQLException ex){
            Logger.getLogger(User_DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return list_of_q1_4;
    }
    
    public List<Model_Q5> get_data_Table_2(String regID){
        List<Model_Q5> list_of_q5 = new ArrayList<>();
        try{
            String sql = "SELECT * FROM CREATE_DATA_2_TABLE WHERE regID = '" + regID + "'";
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                Model_Q5 model = new Model_Q5();
                model.setTime_(rs.getString("power_inturaption_time_q5"));
                model.setGenenetor_oprated_normally(rs.getString("genenetor_oprated_normally__q5"));
                model.setGenenetor_status_description(rs.getString("genenetor_status_description_q5"));
                model.setIs_there_any_fule_for_24h(rs.getString("is_there_any_fule_for_24h__q5"));
                
                
                list_of_q5.add(model);
            }
        }catch(SQLException ex){
            Logger.getLogger(User_DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return list_of_q5;   
    }
    
    public List<Model_Q6> get_data_Table_3(String regID){
        
        List<Model_Q6> list_of_q6 = new ArrayList<>();
        try{
            String sql = "SELECT * FROM CREATE_DATA_3_TABLE WHERE regID = '" + regID + "'";
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                Model_Q6 model = new Model_Q6();
                model.setVisitor_name(rs.getString("visitor_name_q6"));
                model.setPurpose_of_the_visitor(rs.getString("purpose_of_the_visitor_q6"));
                model.setMeanse_of_auth(rs.getString("meanse_of_auth_q6"));
                
                
                list_of_q6.add(model);
            }
                      
        }catch(SQLException ex){
            Logger.getLogger(User_DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return list_of_q6; 
    }
    
    public List<Model_Q678> get_data_Table_4(String regID){
        List<Model_Q678> list_of_q678 = new ArrayList<>();
        try{
            String sql = "SELECT * FROM CREATE_DATA_4_TABLE WHERE regID = '" + regID + "'";
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                Model_Q678 model = new Model_Q678();
                model.setDes6(rs.getString("description_q61"));
                model.setDes7(rs.getString("description_7"));
                model.setDes8(rs.getString("description_8"));
                
                list_of_q678.add(model);
            }
        }catch(SQLException ex){
            Logger.getLogger(User_DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return list_of_q678; 
    }
    
    public List<Model_Q9> get_data_Table_5(String regID){
        List<Model_Q9> list_of_q9 = new ArrayList<>();
        try{
            String sql = "SELECT * FROM CREATE_DATA_5_TABLE WHERE regID = '" + regID + "'";
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                Model_Q9 model = new Model_Q9();
                model.setTxt_field_L_1_Q9_ups_charge_centric_ups(rs.getString("L_1_Q9_ups_charge_centric_ups"));
                model.setTxt_field_L_2_Q9_ups_charge_centric_ups(rs.getString("L_2_Q9_ups_charge_centric_ups"));
                model.setTxt_field_L_3_Q9_ups_charge_centric_ups(rs.getString("L_3_Q9_ups_charge_centric_ups"));
                model.setTxt_field_L_1_Q9_ups_load_centric_ups(rs.getString("L_1_Q9_ups_load_centric_ups"));
                model.setTxt_field_L_2_Q9_ups_load_centric_ups(rs.getString("L_2_Q9_ups_load_centric_ups"));
                model.setTxt_field_L_3_Q9_ups_load_centric_ups(rs.getString("L_3_Q9_ups_load_centric_ups"));
                model.setTxt_field_L_123_Q9_runtime_centric_ups(rs.getString("L_123_Q9_runtime_centric_ups"));
                model.setTxt_field_L_1_Q9_ups_charge_apc_ups(rs.getString("L_1_Q9_ups_charge_apc_ups"));
                model.setTxt_field_L_2_Q9_ups_charge_apc_ups(rs.getString("L_2_Q9_ups_charge_apc_ups"));
                model.setTxt_field_L_3_Q9_ups_charge_apc_ups(rs.getString("L_3_Q9_ups_charge_apc_ups"));
                model.setTxt_field_L_1_Q9_ups_load_apc_ups(rs.getString("L_1_Q9_ups_load_apc_ups"));
                model.setTxt_field_L_2_Q9_ups_load_apc_ups(rs.getString("L_2_Q9_ups_load_apc_ups"));
                model.setTxt_field_L_3_Q9_ups_load_apc_ups(rs.getString("L_3_Q9_ups_load_apc_ups"));
                model.setTxt_field_L_123_Q9_runtime_apc_ups(rs.getString("L_123_Q9_runtime_apc_ups"));
                
                list_of_q9.add(model);
            }
        }catch(SQLException ex){
            Logger.getLogger(User_DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return list_of_q9; 
    }
    
    public List<Model_Q10> get_data_Table_6(String regID){
        List<Model_Q10> list_of_q10 = new ArrayList<>();
        
        try{
            String sql = "SELECT * FROM CREATE_DATA_6_TABLE WHERE regID = '" + regID + "'";
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                Model_Q10 model = new Model_Q10();
                model.setACRD_602_INROW_1(rs.getString("ACRD_602_INROW_1_q10"));
                model.setACRP_102_INROW_2(rs.getString("ACRP_102_INROW_2_q10"));
                model.setACRP_102_INROW_3(rs.getString("ACRP_102_INROW_3_q10"));
                model.setACRP_102_INROW_4(rs.getString("ACRP_102_INROW_4_q10"));
                model.setACRP_102_INROW_5(rs.getString("ACRP_102_INROW_5_q10"));
                model.setCARRIER_F201(rs.getString("CARRIER_F201_q10"));
                model.setCARRIER_F205(rs.getString("CARRIER_F205_q10"));
                model.setROYAL_F202(rs.getString("ROYAL_F202_q10"));
                model.setROYAL_F203(rs.getString("ROYAL_F203_q10"));
                model.setLG_F204(rs.getString("LG_F204_q10"));
                model.setInventor_1(rs.getString("Inventor_1_q10"));
                model.setInventor_2(rs.getString("Inventor_2_q10"));
                model.setInventor_3(rs.getString("Inventor_3_q10"));
                model.setInventor_4(rs.getString("Inventor_4_10"));
                
                list_of_q10.add(model);
            }
        }catch(SQLException ex){
            Logger.getLogger(User_DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return list_of_q10; 
    }
    
    public List<Model_Show_Basic_info> get_data_Table_7(String regID){
        ArrayList<Model_Show_Basic_info> list_of_basic_data = new ArrayList<>();
        
         try{
                String sql = "SELECT * FROM CREATE_DATA_7_TABLE WHERE regID = '"+ regID +"'";
                ResultSet rs = stmt.executeQuery(sql);
                
                while (rs.next()) {
                Model_Show_Basic_info info = new Model_Show_Basic_info();
                info.setRegID(rs.getString("regID"));
                info.setCurrent_user(rs.getString("fullname"));
                info.setRecived_from(rs.getString("recived_from"));
                info.setDeliverd_to(rs.getString("deliverd_to"));
                info.setShift(rs.getString("shift"));
                info.setDate(rs.getString("reg_date"));
                
                list_of_basic_data.add(info);
            }
                
                return list_of_basic_data;
            }catch(SQLException ex){
                Logger.getLogger(User_DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
            }            
            return list_of_basic_data;
    }
    
    public ArrayList<Model_Show_Basic_info> basic_data_to_display(){
        ArrayList<Model_Show_Basic_info> list_of_basic_data = new ArrayList<>();
        
         try{
                String sql = "SELECT * FROM CREATE_DATA_7_TABLE";
                ResultSet rs = stmt.executeQuery(sql);                               
                //int aa = 1;
                while (rs.next()) {
                Model_Show_Basic_info info = new Model_Show_Basic_info();
                info.setRegID(rs.getString("regID"));
                info.setCurrent_user(rs.getString("fullname"));
                //System.out.println(aa+ " "+ rs.getString("regID") + " " + rs.getString("fullname"));
                info.setRecived_from(rs.getString("recived_from"));
                info.setDeliverd_to(rs.getString("deliverd_to"));
                info.setShift(rs.getString("shift"));
                info.setDate(rs.getString("reg_date"));
                
                list_of_basic_data.add(info);  
                //aa = aa + 1;
            }
                //System.out.println("array size " + list_of_basic_data.size());
                return list_of_basic_data;
            }catch(SQLException ex){
                Logger.getLogger(User_DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
            }            
            return list_of_basic_data;
        
    }
    

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package_database;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import package_model.Model_user;
import static package_view.Admin_view.user_id;
import static package_database.DB_Connection.DB_PASSWORD;
import static package_database.DB_Connection.DB_USERNAME;
import static package_database.DB_Connection.DB_URL;
import package_model.Model_Admin_User;
//import package_view.Admin_view;

/**
 *
 * @author Miz-TheAppExpert
 */
public class User_DatabaseManager {

    private Connection connection;
    private Statement stmt;

    private static final String CREATE_ADMIN_TABLE = "CREATE TABLE IF NOT EXISTS ADMIN "
            + "(id bigint auto_increment NOT NULL PRIMARY KEY, "
            + " username VARCHAR(255), "
            + " password VARCHAR(255))";

    private static final String CREATE_USER_TABLE = "CREATE TABLE IF NOT EXISTS USERS "
            + "(user_system_id bigint auto_increment NOT NULL PRIMARY KEY,"
            + " f_name VARCHAR(255), "
            + " l_name VARCHAR(255), "
            + " user_name VARCHAR(255), "
            + " phone_no VARCHAR(255), "
            + " org_id VARCHAR(255), "
            + " user_password VARCHAR(255), "
            + " user_status VARCHAR(255), "
            + " reg_date VARCHAR(255), "
            + " last_login_date VARCHAR(255))";

    public User_DatabaseManager() {
        openConnection();
        /* if admin table is empty add default admin user else escap*/
        ArrayList<Model_Admin_User> adminList = getAdmin();
        if (adminList.isEmpty()) {
            //System.out.println("-- Admin Table Empity --");
            /* add default username and password */
            addAdmin_user();
        }else{
            //System.out.println("Table is not empty ");
        }
    }

    public void openConnection() {
        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            stmt = connection.createStatement();
            stmt.execute(CREATE_USER_TABLE);
            //System.out.println("user table created ..");
            stmt.execute(CREATE_ADMIN_TABLE);
            //System.out.println("admin table created ..");
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void addAdmin_user() {
        Model_Admin_User admin = new Model_Admin_User("admin_user", "admin12");
        String sql = "INSERT INTO ADMIN (username, password) VALUES"
                + " ('" + admin.getUsername() + "',"
                + " '" + admin.getPassword() + "')";

        try {
            stmt.execute(sql);
        } catch (SQLException e) {
            Logger.getLogger(User_DatabaseManager.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void addUser(Model_user user) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();
        String current_date = dateFormat.format(cal.getTime());
        String current_status = "on";
        String sql = "INSERT INTO USERS (f_name, l_name, user_name, phone_no, org_id, user_password, user_status, reg_date, last_login_date) VALUES"
                + " ('" + user.getF_name() + "',"
                + " '" + user.getL_name() + "', "
                + " '" + user.getUser_name() + "', "
                + " '" + user.getPhone_no() + "', "
                + " '" + user.getOrg_id() + "', "
                + " '" + user.getUser_password() + "', "
                + " '" + current_status + "', "
                + " '" + current_date + "', "
                + " '" + current_date + "')";
        try {
            stmt.execute(sql);

        } catch (SQLException ex) {
            Logger.getLogger(User_DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        //System.out.println("Current Date " + current_date);
    }

    public void updateUser(Model_user user) {

        String sql = "UPDATE USERS set f_name = '" + user.getF_name() + "', l_name = '" + user.getL_name() + "',user_name = '" + user.getUser_name() + "',phone_no = '" + user.getPhone_no() + "',org_id = '" + user.getOrg_id() + "'   where user_system_id =  '" + user_id + "'";
        try {
            stmt.execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(User_DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateAdmin(String new_password){
        String sql = "UPDATE ADMIN set password = '" + new_password+ "'";
        try{
            stmt.execute(sql);
        }catch(SQLException e){
            Logger.getLogger(User_DatabaseManager.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public ArrayList<Model_Admin_User> getAdmin() {
        ArrayList<Model_Admin_User> adminList = new ArrayList<>();

        try {
            String sql = "SELECT * FROM ADMIN";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Model_Admin_User model_admin = new Model_Admin_User();
                model_admin.setId(rs.getInt("id"));
                model_admin.setUsername(rs.getString("username"));
                model_admin.setPassword(rs.getString("password"));

                adminList.add(model_admin);
            }

            return adminList;

        } catch (SQLException e) {
            Logger.getLogger(User_DatabaseManager.class.getName()).log(Level.SEVERE, null, e);
        }
        return adminList;
    }

    public ArrayList<Model_user> getAllusers() {
        ArrayList<Model_user> users = new ArrayList<>();

        try {
            String sql = "SELECT * FROM USERS";

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Model_user user = new Model_user();
                user.setUser_system_id(rs.getInt("user_system_id"));
                user.setF_name(rs.getString("f_name"));
                user.setL_name(rs.getString("l_name"));
                user.setUser_name(rs.getString("user_name"));
                user.setPhone_no(rs.getString("phone_no"));
                user.setOrg_id(rs.getString("org_id"));
                user.setReg_date(rs.getString("reg_date"));
                user.setLast_login_date(rs.getString("last_login_date"));
                user.setCurrent_status(rs.getString("user_status"));
                user.setUser_password(rs.getString("user_password"));

                users.add(user);
            }

            return users;
        } catch (SQLException ex) {
            Logger.getLogger(User_DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
    }

    public void update_user_status_on(String user_id) {
        String status_on = "on";

        String sql = "UPDATE USERS set user_status = '" + status_on + "'   where user_system_id =  '" + user_id + "'";
        try {
            stmt.execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(User_DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update_user_status_off(String user_id) {
        String status_off = "off";

        String sql = "UPDATE USERS set user_status = '" + status_off + "'   where user_system_id =  '" + user_id + "'";
        try {
            stmt.execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(User_DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String get_user_status(String user_id) {
        String current_status = "";
        try {
            String sql = "SELECT user_status FROM USERS WHERE user_system_id = '" + user_id + "'";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                current_status = rs.getString("user_status");
            }
            return current_status;
        } catch (SQLException ex) {
            Logger.getLogger(User_DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return current_status;
    }

    public boolean check_user_name_exist(String username, int system_id) {
        try {
            String sql = "SELECT * FROM USERS  where user_name =  '" + username + "' AND user_system_id != '" + system_id + "'";
            ResultSet rs = stmt.executeQuery(sql);
            int size = 0;
            if (rs != null) {
                rs.beforeFirst();
                rs.last();
                size = rs.getRow();
            }

            return size > 0;
        } catch (SQLException ex) {
            Logger.getLogger(User_DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean check_user_password_exist(String username, String password) {
        try {
            String sql = "SELECT * FROM USERS  where user_name =  '" + username + "' AND user_password = '" + password + "'";
            ResultSet rs = stmt.executeQuery(sql);
            int size = 0;
            if (rs != null) {
                rs.beforeFirst();
                rs.last();
                size = rs.getRow();
            }

            return size > 0;
        } catch (SQLException ex) {
            Logger.getLogger(User_DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public void update_user_password(String username, String password) {

        String sql = "UPDATE USERS set user_password = '" + password + "' where user_name =  '" + username + "'";
        try {
            stmt.execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(User_DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void reset_user_password(String username) {
        String password = "1234";

        String sql = "UPDATE USERS set user_password = '" + password + "' where user_name =  '" + username + "'";
        try {
            stmt.execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(User_DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Model_user> get_current_user(String username) {
        List<Model_user> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM USERS where user_name = '" + username + "'";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Model_user user = new Model_user();
                user.setUser_system_id(rs.getInt("user_system_id"));
                user.setF_name(rs.getString("f_name"));
                user.setL_name(rs.getString("l_name"));
                user.setUser_name(rs.getString("user_name"));
                user.setPhone_no(rs.getString("phone_no"));
                user.setOrg_id(rs.getString("org_id"));
                user.setReg_date(rs.getString("reg_date"));
                user.setLast_login_date(rs.getString("last_login_date"));
                user.setCurrent_status(rs.getString("user_status"));
                user.setUser_password(rs.getString("user_password"));

                list.add(user);
            }

            return list;
        } catch (SQLException ex) {
            Logger.getLogger(User_DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public boolean login_(String username, String password) {
        String current_status = "on";
        try {
            String sql = "SELECT * FROM USERS  where user_name =  '" + username + "' AND user_password = '" + password + "' AND user_status = '" + current_status + "'";
            ResultSet rs = stmt.executeQuery(sql);
            int size = 0;
            if (rs != null) {
                rs.beforeFirst();
                rs.last();
                size = rs.getRow();
            }

            return size > 0;
        } catch (SQLException ex) {
            Logger.getLogger(User_DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean login_admin(String username, String password){
        try{
            String sql = "SELECT * FROM ADMIN  where username =  '" + username + "' AND password = '" + password + "'";
            ResultSet rs = stmt.executeQuery(sql);
            int size = 0;
            if (rs != null) {
                rs.beforeFirst();
                rs.last();
                size = rs.getRow();
            }

            return size > 0;
        }catch(SQLException e){
            Logger.getLogger(User_DatabaseManager.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }

    public void update_last_login_date(String username) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();
        String current_date = dateFormat.format(cal.getTime());

        String sql = "UPDATE USERS set last_login_date = '" + current_date + "' where user_name =  '" + username + "'";
        try {
            stmt.execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(User_DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delet_elements() {
        try {
            //String sql = "DELETE FROM USERS  where user_system_id =  '" + keyword + "'";
            String sql = "DROP TABLE USERS";
            stmt.execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(User_DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

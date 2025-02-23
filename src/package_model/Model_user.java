
package package_model;

/**
 *
 * @author Miz
 */
public class Model_user {
    
    private int user_system_id;
    private String f_name;
    private String l_name;
    private String user_name;
    private String phone_no;
    private String org_id;
    private String user_password;
    private String reg_date;
    private String last_login_date;
    private String current_status;
    
    public Model_user(){
        
    }

    public Model_user(String f_name, String l_name, String user_name, String phone_no, String org_id, String user_password) {        
        this.f_name = f_name;
        this.l_name = l_name;
        this.user_name = user_name;
        this.phone_no = phone_no;
        this.org_id = org_id;
        this.user_password = user_password;        
    }
     
    public int getUser_system_id() {
        return user_system_id;
    }

    public void setUser_system_id(int user_system_id) {
        this.user_system_id = user_system_id;
    }

    public String getF_name() {
        return f_name;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    public String getL_name() {
        return l_name;
    }

    public void setL_name(String l_name) {
        this.l_name = l_name;
    }
    
    public String get_full_name(){
        return f_name + " " + l_name;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public String getOrg_id() {
        return org_id;
    }

    public void setOrg_id(String org_id) {
        this.org_id = org_id;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getCurrent_status() {
        return current_status;
    }

    public void setCurrent_status(String current_status) {
        this.current_status = current_status;
    }
    
    public String getReg_date() {
        return reg_date;
    }

    public void setReg_date(String reg_date) {
        this.reg_date = reg_date;
    }

    public String getLast_login_date() {
        return last_login_date;
    }

    public void setLast_login_date(String last_login_date) {
        this.last_login_date = last_login_date;
    }
    
    
    
    
}

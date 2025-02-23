
package package_model;

/**
 *
 * @author Miz
 */
public class Model_Show_Basic_info {
    
    String regID, current_user, recived_from, deliverd_to, shift, date;
    
    public Model_Show_Basic_info(){
        
    }

    public Model_Show_Basic_info(String regID, String current_user, String recived_from, String deliverd_to, String shift, String date) {
        this.regID = regID;
        this.current_user = current_user;
        this.recived_from = recived_from;
        this.deliverd_to = deliverd_to;
        this.shift = shift;
        this.date = date;
    }
    
    

    public String getRegID() {
        return regID;
    }

    public void setRegID(String regID) {
        this.regID = regID;
    }

    public String getCurrent_user() {
        return current_user;
    }

    public void setCurrent_user(String current_user) {
        this.current_user = current_user;
    }

    public String getRecived_from() {
        return recived_from;
    }

    public void setRecived_from(String recived_from) {
        this.recived_from = recived_from;
    }

    public String getDeliverd_to() {
        return deliverd_to;
    }

    public void setDeliverd_to(String deliverd_to) {
        this.deliverd_to = deliverd_to;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    
    
}

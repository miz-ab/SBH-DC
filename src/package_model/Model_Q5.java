
package package_model;

/**
 *
 * @author Miz
 */
public class Model_Q5 {
        
    String time_;
    String genenetor_oprated_normally;
    String genenetor_status_description;
    String is_there_any_fule_for_24h;
    
    
    public Model_Q5(){
        
    }

    public Model_Q5(String time_, String genenetor_oprated_normally, String genenetor_status_description, String is_there_any_fule_for_24h) {
        this.time_ = time_;
        this.genenetor_oprated_normally = genenetor_oprated_normally;
        this.genenetor_status_description = genenetor_status_description;
        this.is_there_any_fule_for_24h = is_there_any_fule_for_24h;
    }
    
    
     
    public String getTime_() {
        return time_;
    }

    public void setTime_(String time_) {
        this.time_ = time_;
    }

    public String getGenenetor_oprated_normally() {
        return genenetor_oprated_normally;
    }

    public void setGenenetor_oprated_normally(String genenetor_oprated_normally) {
        this.genenetor_oprated_normally = genenetor_oprated_normally;
    }

    public String getGenenetor_status_description() {
        return genenetor_status_description;
    }

    public void setGenenetor_status_description(String genenetor_status_description) {
        this.genenetor_status_description = genenetor_status_description;
    }

    public String getIs_there_any_fule_for_24h() {
        return is_there_any_fule_for_24h;
    }

    public void setIs_there_any_fule_for_24h(String is_there_any_fule_for_24h) {
        this.is_there_any_fule_for_24h = is_there_any_fule_for_24h;
    }
    
    
    
}


package package_model;

/**
 *
 * @author Miz
 */
public class Model_Q6 {
    
    String visitor_name;
    String meanse_of_auth;
    String purpose_of_the_visitor;
    
    
    public Model_Q6(){
        
    }

    public Model_Q6(String visitor_name, String meanse_of_auth, String purpose_of_the_visitor) {
        this.visitor_name = visitor_name;
        this.meanse_of_auth = meanse_of_auth;
        this.purpose_of_the_visitor = purpose_of_the_visitor;
    }      

    public String getVisitor_name() {
        return visitor_name;
    }

    public void setVisitor_name(String visitor_name) {
        this.visitor_name = visitor_name;
    }

    public String getMeanse_of_auth() {
        return meanse_of_auth;
    }

    public void setMeanse_of_auth(String meanse_of_auth) {
        this.meanse_of_auth = meanse_of_auth;
    }

    public String getPurpose_of_the_visitor() {
        return purpose_of_the_visitor;
    }

    public void setPurpose_of_the_visitor(String purpose_of_the_visitor) {
        this.purpose_of_the_visitor = purpose_of_the_visitor;
    }
    
    
    
}

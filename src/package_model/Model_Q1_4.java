
package package_model;

/**
 *
 * @author Miz
 */
public class Model_Q1_4 {
    
    String Severity_status;
    String Incident_description;
    
    public Model_Q1_4(String Severity_status, String Incident_description){
        this.Severity_status = Severity_status;
        this.Incident_description = Incident_description;
    }

    public String getSeverity_status() {
        return Severity_status;
    }

    public void setSeverity_status(String Severity_status) {
        this.Severity_status = Severity_status;
    }

    public String getIncident_description() {
        return Incident_description;
    }

    public void setIncident_description(String Incident_description) {
        this.Incident_description = Incident_description;
    }
    
    
    
}

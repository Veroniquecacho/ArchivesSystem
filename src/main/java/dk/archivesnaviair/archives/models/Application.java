package dk.archivesnaviair.archives.models;


public class Application {

    private int idApplication;
    private String applicationName;
    private String manufacturerName;

    public Application() {
    }

    public Application(int idApplication, String applicationName, String manufacturerName) {
        this.idApplication = idApplication;
        this.applicationName = applicationName;
        this.manufacturerName = manufacturerName;
    }

    public int getIdApplication() {
        return idApplication;
    }

    public void setIdApplication(int idApplication) {
        this.idApplication = idApplication;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    @Override
    public String toString() {
        return "Application{" +
                "idApplication=" + idApplication +
                ", applicationName='" + applicationName + '\'' +
                ", manufacturerName='" + manufacturerName + '\'' +
                '}';
    }
}

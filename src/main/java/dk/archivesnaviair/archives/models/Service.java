package dk.archivesnaviair.archives.models;

public class Service {

    private int idService;
    private String serviceType;

    public Service() {
    }

    public Service(int idService, String serviceType) {
        this.idService = idService;
        this.serviceType = serviceType;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public int getIdService() {
        return idService;
    }

    public void setIdServices(int idServices) {
        this.idService = idServices;
    }

    @Override
    public String toString() {
        return "Service{" +
                "idServices=" + idService +
                ", serviceType='" + serviceType + '\'' +
                '}';
    }
}

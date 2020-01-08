package dk.archivesnaviair.archives.models;

public class Equipment {

    private int idEquipment;
    private String equipmentName;
    private String equipmentDate;
    private String equipmentType;
    private String manufacturerName;
    private String serialNo;
    private String note;

    public Equipment() {
    }

    public Equipment(int idEquipment, String equipmentName, String equipmentDate, String equipmentType, String manufacturerName, String serialNo, String note) {
        this.idEquipment = idEquipment;
        this.equipmentName = equipmentName;
        this.equipmentDate = equipmentDate;
        this.equipmentType = equipmentType;
        this.manufacturerName = manufacturerName;
        this.serialNo = serialNo;
        this.note = note;
    }

    public int getIdEquipment() {
        return idEquipment;
    }

    public void setIdEquipment(int idEquipment) {
        this.idEquipment = idEquipment;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public String getEquipmentDate() {
        return equipmentDate;
    }

    public void setEquipmentDate(String equipmentDate) {
        this.equipmentDate = equipmentDate;
    }

    public String getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(String equipmentType) {
        this.equipmentType = equipmentType;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Equipment{" +
                "idEquipment=" + idEquipment +
                ", equipmentName='" + equipmentName + '\'' +
                ", equipmentDate='" + equipmentDate + '\'' +
                ", equipmentType='" + equipmentType + '\'' +
                ", manufacturerName='" + manufacturerName + '\'' +
                ", serialNo='" + serialNo + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}


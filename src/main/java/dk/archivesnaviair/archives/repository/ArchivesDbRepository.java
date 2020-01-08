package dk.archivesnaviair.archives.repository;

import dk.archivesnaviair.archives.MySQL.MySql;
import dk.archivesnaviair.archives.models.Application;
import dk.archivesnaviair.archives.models.Equipment;
import dk.archivesnaviair.archives.models.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ArchivesDbRepository implements IArchivesRepository {

    private PreparedStatement preparedStatement = null;


    //made by Martine and Veronique
    @Autowired
    private MySql db;

    @Autowired
    JdbcTemplate jdbc;


    SqlRowSet sqlRowSet;

    //Creates a new it Equipment
    @Override
    public void createEQ(Equipment equipment) {

            try (Connection conn = db.getConn()){

                preparedStatement = conn.prepareStatement("INSERT INTO naviairs.Equipment VALUES (default ,?,?,?,?,?,?)");

                preparedStatement.setString(1,equipment.getEquipmentName() );
                preparedStatement.setString(2,equipment.getEquipmentDate());
                preparedStatement.setString(3,equipment.getEquipmentType());
                preparedStatement.setString(4,equipment.getManufacturerName());
                preparedStatement.setString(5,equipment.getSerialNo());
                preparedStatement.setString(6,equipment.getNote());
                preparedStatement.executeUpdate();

            }
            catch (SQLException e){

            }

    }



    @Override
    public void createApp(Application application) {
        jdbc.update("INSERT INTO naviairs.Application(Application_name, Manufacturer_name) " +
                "VALUES ('" + application.getApplicationName() + "','" + application.getManufacturerName() + "')");

    }

    @Override
    public void createService(Service service) {
        jdbc.update("INSERT  INTO naviairs.Service (Service_type)" +
                "VALUES ('" + service.getServiceType() + "')");

    }

    //prints all it Equipment
    @Override
    public List<Equipment> readAllEQ( ) {
        List<Equipment> equipment = new ArrayList<>();
        String sql = "SELECT * FROM naviairs.Equipment";
        sqlRowSet = jdbc.queryForRowSet(sql);

        while (sqlRowSet.next()) {
            equipment.add(new Equipment(sqlRowSet.getInt("id_Equipment"),
                    sqlRowSet.getString("Equipment_name"),
                    sqlRowSet.getString("Equipment_date"),
                    sqlRowSet.getString("Equipment_type"),
                    sqlRowSet.getString("Manufacturer_name"),
                    sqlRowSet.getString("Equipment_serialNo"),
                    sqlRowSet.getString("Equipment_note")));
        }

        return equipment;
    }




    //prints one equipment with specific id
    @Override
    public Equipment readEQ(int id) {
        String sql = "SELECT * FROM naviairs.Equipment WHERE id_Equipment=" + id;
        sqlRowSet = jdbc.queryForRowSet(sql);

        while (sqlRowSet.next()) {
            return new Equipment(sqlRowSet.getInt("id_Equipment"),
                    sqlRowSet.getString("Equipment_name"),
                    sqlRowSet.getString("Equipment_date"),
                    sqlRowSet.getString("Equipment_type"),
                    sqlRowSet.getString("Manufacturer_name"),
                    sqlRowSet.getString("Equipment_serialNo"),
                    sqlRowSet.getString("Equipment_note"));
        }
        return null;
    }



    @Override
    public List<Application> readAllApp() {
        List<Application> application = new ArrayList<>();
        String sql = ("SELECT * FROM naviairs.Application");
        sqlRowSet = jdbc.queryForRowSet(sql);

        while (sqlRowSet.next()) {
            application.add(new Application(sqlRowSet.getInt("id_Application"),
                    sqlRowSet.getString("Application_name"),
                    sqlRowSet.getString("Manufacturer_name")));
        }
        return application;
    }

    @Override
    public Application readApp(int id) {
        String sql = "SELECT * FROM naviairs.Application WHERE id_Application=" + id;
        sqlRowSet = jdbc.queryForRowSet(sql);
        while (sqlRowSet.next()) {
            return new Application(sqlRowSet.getInt("id_Application"),
                    sqlRowSet.getString("Application_name"),
                    sqlRowSet.getString("Manufacturer_name"));

        }
        return null;
    }

    @Override
    public Application readAppName(String string) {
        String sql = "SELECT * FROM naviairs.Application WHERE Application_name LIKE '%" + string + "%'";
        sqlRowSet = jdbc.queryForRowSet(sql);
        while (sqlRowSet.next()) {
            return new Application(sqlRowSet.getInt("id_Application"),
                    sqlRowSet.getString("Application_name"),
                    sqlRowSet.getString("Manufacturer_name"));
        }
        return null;
    }


    @Override
    public List<Service> readAllService() {
        List<Service> service = new ArrayList<>();
        String sql = "SELECT * FROM naviairs.Service";
        sqlRowSet = jdbc.queryForRowSet(sql);
        while (sqlRowSet.next()) {
            service.add(new Service(sqlRowSet.getInt("id_Service"),
                    sqlRowSet.getString("Service_type")));
        }

        return service;

    }

    @Override
    public Service readService(int id) {
        String sql = "SELECT * FROM naviairs.Service WHERE id_Service= " + id;
        sqlRowSet = jdbc.queryForRowSet(sql);
        while (sqlRowSet.next()) {
            return new Service(sqlRowSet.getInt("id_Service"),
                    sqlRowSet.getString("Service_type"));
        }
        return null;
    }


    @Override
    public Service readServiceType(String string) {
        String sql = "SELECT * FROM naviairs.Service WHERE Service_type LIKE '%" + string + "%'";
        sqlRowSet = jdbc.queryForRowSet(sql);
        while (sqlRowSet.next()) {
            return new Service(sqlRowSet.getInt("id_Service"),
                    sqlRowSet.getString("Service_type"));
        }
        return null;
    }

    @Override
    public void updateEQ(Equipment equipment) {
        jdbc.update("UPDATE naviairs.Equipment SET " +
                "Equipment_name ='" + equipment.getEquipmentName() + "' , " +
                "Equipment_date ='" + equipment.getEquipmentDate() + "' , " +
                "Equipment_type ='" + equipment.getEquipmentType() + "' , " +
                "Manufacturer_name ='" + equipment.getManufacturerName() + "' , " +
                "Equipment_serialNo='" + equipment.getSerialNo() + "' , " +
                "Equipment_note='" + equipment.getNote() + "' WHERE id_Equipment = '" + equipment.getIdEquipment() + "'");

    }

    // Delete equipment specific id
    @Override
    public void deleteEQ(int id) {
        jdbc.update("DELETE FROM naviairs.Equipment WHERE id_Equipment='" + id + "'");

    }

    @Override
    public void deleteApp(int id) {
        jdbc.update("DELETE FROM naviairs.Application WHERE  id_Application='" + id + "'");

    }

    @Override
    public void deleteService(int id) {
        jdbc.update("DELETE FROM naviairs.Service WHERE id_Service='" + id + "'");

    }


    //prints a list of equipment with specific equipment type
    @Override
    public List<Equipment> readEQType(String string) {
        List<Equipment> equipment = new ArrayList<>();
        String sql = "SELECT * FROM naviairs.Equipment WHERE Equipment_type LIKE '%" + string + "%'";
        sqlRowSet = jdbc.queryForRowSet(sql);

        while (sqlRowSet.next()) {
            equipment.add(new Equipment(sqlRowSet.getInt("id_Equipment"),
                    sqlRowSet.getString("Equipment_name"),
                    sqlRowSet.getString("Equipment_date"),
                    sqlRowSet.getString("Equipment_type"),
                    sqlRowSet.getString("Manufacturer_name"),
                    sqlRowSet.getString("Equipment_serialNo"),
                    sqlRowSet.getString("Equipment_note")));
        }

        return equipment;
    }


    //prints one equipment with specific serial no.
    @Override
    public Equipment readEQSerialNo(String serialNo) {
        String sql = "SELECT * FROM naviairs.Equipment WHERE Equipment_serialNo LIKE '%" + serialNo + "%'";
        sqlRowSet = jdbc.queryForRowSet(sql);

        while (sqlRowSet.next()) {
            return new Equipment(sqlRowSet.getInt("id_Equipment"),
                    sqlRowSet.getString("Equipment_name"),
                    sqlRowSet.getString("Equipment_date"),
                    sqlRowSet.getString("Equipment_type"),
                    sqlRowSet.getString("Manufacturer_name"),
                    sqlRowSet.getString("Equipment_serialNo"),
                    sqlRowSet.getString("Equipment_note"));
        }

        return null;
    }

    //TODO skal kunne finde service til enkelte equipment
    @Override
    public Service readServiceConnection(int idEquipment) {

        sqlRowSet = jdbc.queryForRowSet("SELECT naviairs.Equipment.Equipment_name, naviairs.Equipment.Equipment_serialNo, naviairs.Service.Service_type FROM naviairs.Equipment " +
                "INNER JOIN naviairs.ServiceLine ON naviairs.ServiceLine.id_Equipment = naviairs.Equipment.id_Equipment" +
                "INNER JOIN naviairs.Service ON naviairs.ServiceLine.id_Service = naviairs.Service.id_Services " +
                "WHERE naviairs.Equipment.id_Equipment ='" + idEquipment + "'");

        while (sqlRowSet.next()) {
            return new Service(sqlRowSet.getInt("id_Service"),
                    sqlRowSet.getString("Service_type"));
        }
        return null;

    }



}
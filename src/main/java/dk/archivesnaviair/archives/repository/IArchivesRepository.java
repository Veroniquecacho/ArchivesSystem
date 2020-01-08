package dk.archivesnaviair.archives.repository;

import dk.archivesnaviair.archives.models.Application;
import dk.archivesnaviair.archives.models.Equipment;
import dk.archivesnaviair.archives.models.Service;


import java.util.ArrayList;
import java.util.List;

public interface IArchivesRepository {

    //made by Martine and Veronique

    //CREATE
    void createEQ(Equipment equipment);


    void createApp(Application application);

    void createService(Service service);

    //READ
    List<Equipment> readAllEQ();

    Equipment readEQ(int id);

    List<Application> readAllApp();

    Application readApp(int id);
    Application readAppName(String string);

    List<Service> readAllService();

    Service readService(int id);

    Service readServiceType(String string);

    //UPDATE
    void updateEQ(Equipment equipment);

    //DELETE
    void deleteEQ(int id);

    void deleteApp(int id);

    void deleteService(int id);

    //READ - SEARCH
    List<Equipment> readEQType(String string);

    Equipment readEQSerialNo(String serialNo);

    Service readServiceConnection(int idEquipment);


    //Inner Joins
//        void addService(int idEquipment, Service service);
//        void addApplication(int idEquipment, Application application);
//
  //     void addService(int idEquipment, int idService);
//        void addApplication(int idEquipment, int idApplication);
//
//        void updateServiceEQ(Service service);
//        void updateApplicationEQ(Application application);
//
//        void removeServiceEQ(int id);
//        void removeApplication(int id);
//
//        Service readServiceEQ(int id);
//        Application readApplicationEQ(int id);






/*

        //User
        void createUser(User user);
        ArrayList<User> readAll();
        User readUser(int id);
        void deleteUser(int id);
        User loginUser(String username, String password);
        void updatePasswordUser(User user, String password1, String password2);*/
}

package dk.archivesnaviair.archives.controller;

import dk.archivesnaviair.archives.models.Application;
import dk.archivesnaviair.archives.models.Equipment;
import dk.archivesnaviair.archives.models.Service;
import dk.archivesnaviair.archives.repository.IArchivesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AdminController {

    //START SIDE
    // LOGIN FORM??
    @GetMapping("/")
    public String login (){
        return "login";

    }

    @Autowired
    private IArchivesRepository archivesRepository;

    // Equipment Controller

    @GetMapping("/adminEquipment")
    public String adminFrontPage (Model model){
        model.addAttribute("equipment_data", archivesRepository.readAllEQ());
        return "adminEquipment";
    }

    @GetMapping("/aCreateEquipment")
    public String create(){
        return "aCreateEquipment";
    }

    @PostMapping("/aCreateEquipment")
    public String create(@ModelAttribute Equipment equipment, Service service){
        archivesRepository.createEQ(equipment);
        return "redirect:/adminEquipment";
    }


    @GetMapping("/aDeleteEquipment")
    public String delete(@RequestParam("id") int id, Model model) {
        Equipment eq = archivesRepository.readEQ(id);
        model.addAttribute("equipment", eq);
        return "aDeleteEquipment";
    }

    @PostMapping("/aDeleteEquipment")
    public String delete(@ModelAttribute ("id") Integer id){
        archivesRepository.deleteEQ(id);
        return "redirect:/adminEquipment";
    }


    @GetMapping("/aDetailsEquipment")
    public String detailSC(@RequestParam("id") int id, Model model) {
        model.addAttribute("equipment", archivesRepository.readEQ(id) );
        return "aDetailsEquipment";
    }

    @GetMapping("/aUpdateEquipment")
    public String edit(@RequestParam("id") int id, Model model){
        model.addAttribute("equipment", archivesRepository.readEQ(id));
        return "aUpdateEquipment";
    }

    @PostMapping("/aUpdateEquipment")
    public String edit(@ModelAttribute Equipment equipment){
        archivesRepository.updateEQ(equipment);

        return "redirect:/adminEquipment" ;
    }

    //Equipment Search

    @GetMapping("/aSearchEquipmentType")
    public String searchEQ (@RequestParam("string") String string, Model model) {
        model.addAttribute("equipment_data", archivesRepository.readEQType(string) );
        return "aSearchEquipmentType";
    }


    @GetMapping("/aSerialNoEquipment")
    public String searchSerialNo (@RequestParam("serialNo") String serialNo, Model model) {
        model.addAttribute("equipment", archivesRepository.readEQSerialNo(serialNo) );
        return "aSerialNoEquipment";
    }

    // Service Controller

    @GetMapping("/adminService")
    public String adminService (Model model){
        model.addAttribute("service_data", archivesRepository.readAllService());
        return "adminService";
    }
    @GetMapping("/aCreateService")
    public String createS(){ return "createService";}


    @PostMapping("/aCreateService")
    public String createS(@ModelAttribute Service service){
        archivesRepository.createService(service);
        return "redirect:/adminService";

    }

    @GetMapping("/aDeleteService")
    public String deleteS(@RequestParam("id") int id, Model model){
        Service serv = archivesRepository.readService(id);
        model.addAttribute("service", serv);
        return "aDeleteService";

    }
    @PostMapping("/aDeleteService")
    public String deleteS (@ModelAttribute ("id") Integer id){
        archivesRepository.deleteService(id);
        return "redirect:/adminService";

    }
    @GetMapping("/aDetailsService")
    public String detailsS(@RequestParam("id") int id, Model model){
        model.addAttribute("service", archivesRepository.readService(id));
        return "aDetailsService";
    }
    @GetMapping("/aDetailsServiceType")
    public String detailsSType(@RequestParam("string") String string, Model model){
        model.addAttribute("service", archivesRepository.readServiceType(string));
        return "aDetailsServiceType";
    }

    //Application Controller

    @GetMapping("/adminApplication")
    public String adminApplication(Model model){
        model.addAttribute("app_data", archivesRepository.readAllApp());
        return "adminApplication";
    }


    @GetMapping("/aCreateApplication")
    public String createA(){ return "aCreateApplication";}


    @PostMapping("/aCreateApplication")
    public String createA(@ModelAttribute Application app){
        archivesRepository.createApp(app);
        return "redirect:/adminApplication";

    }

    @GetMapping("/aDeleteApplication")
    public String deleteA(@RequestParam("id") int id, Model model){
        Application app = archivesRepository.readApp(id);
        model.addAttribute("app", app);
        return "aDeleteApplication";

    }
    @PostMapping("/aDeleteApplication")
    public String deleteA (@ModelAttribute ("id") Integer id){
        archivesRepository.deleteApp(id);
        return "redirect:/adminApplication";

    }
    @GetMapping("/aDetailsApplication")
    public String detailsA(@RequestParam("id") int id, Model model){
        model.addAttribute("app", archivesRepository.readApp(id));
        return "aDetailsApplicationName";
    }

    @GetMapping("/aDetailsApplicationName")
    public String detailsAName(@RequestParam("string") String string, Model model){
        model.addAttribute("app", archivesRepository.readAppName(string));
        return "aDetailsApplicationName";
    }




}

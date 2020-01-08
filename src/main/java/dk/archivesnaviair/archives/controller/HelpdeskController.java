package dk.archivesnaviair.archives.controller;

import dk.archivesnaviair.archives.repository.IArchivesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelpdeskController {

    @Autowired
    private IArchivesRepository archivesRepository;


    //EQUIPMENT PAGE
    @GetMapping("/helpdeskEquipment")
    public String helpdeskFrontPage (Model model){
        model.addAttribute("equipment_data", archivesRepository.readAllEQ());
        return "helpdeskEquipment";
    }
    @GetMapping("/hDetailsEquipment")
    public String helpdeskDetails(@RequestParam("id") int id, Model model) {
        model.addAttribute("equipment", archivesRepository.readEQ(id) );
        return "hDetailsEquipment";
    }

    @GetMapping("/hSearchEquipmentType")
    public String HDsearchEQ (@RequestParam("string") String string, Model model) {
        model.addAttribute("equipment_data", archivesRepository.readEQType(string) );
        return "hSearchEquipmentType";
    }
}

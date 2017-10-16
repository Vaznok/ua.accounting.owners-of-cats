package ua.accouting_of_cats.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.accouting_of_cats.model.Cat;
import ua.accouting_of_cats.model.Owner;
import ua.accouting_of_cats.repository.CatsRepository;
import ua.accouting_of_cats.repository.OwnersRepository;

import java.util.List;

@Controller
public class OwnersController {

    @Autowired
    private OwnersRepository ownersRepository;

    @RequestMapping("/owner/{id}")
    public String owner(@PathVariable Long id /*equivalent Long id = Long.valueof(request.getParametr("id"));*/,
                          Model model){
        /*List<Cat> cats =  catsRepository.findByOwner_OwnerId(id);*/
        model.addAttribute("owner", ownersRepository.findOne(id)); //equivalent request.setAttribute("owner", ownersRepository.findOne(id));
        return "ownercats"; //equivalent request.getRequestDispatcher("ownercats.html").forward(req, res)
    }

    @RequestMapping(value = "/owners", method = RequestMethod.GET)
    public String ownersList(Model model){
        model.addAttribute("owners", ownersRepository.findAll());
        return "owners";
    }

    @RequestMapping(value = "/saveowner", method = RequestMethod.POST)
    @ResponseBody
    public String saveOwner(@RequestBody Owner owner) {
        ownersRepository.save(owner);
        return owner.getOwnerId().toString();
    }

    @RequestMapping(value = "/updateowner", method = RequestMethod.POST)
    @ResponseBody
    public String updateOwner(@RequestParam Long Id) {
        Owner owner = ownersRepository.findOne(Id);
        owner.setFirstName("Was Updated");
        owner.setLastName("by Vetall");
        ownersRepository.save(owner);
        return owner.getOwnerId().toString();
    }

    @RequestMapping(value = "/removeowner", method = RequestMethod.POST)
    @ResponseBody
    public String removeOwner(@RequestParam Long Id){
        ownersRepository.delete(Id);
        return Id.toString();
    }
}

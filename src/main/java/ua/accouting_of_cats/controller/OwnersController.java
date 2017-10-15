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
    public String product(@PathVariable Long id /*equivalent Long id = Long.valueof(request.getParametr("id"));*/,
                          Model model){
        /*System.out.println(id);*/
        /*List<Cat> cats =  catsRepository.findByOwner_OwnerId(id);
        System.out.println(own);*/
        model.addAttribute("owner", ownersRepository.findOne(id)); //equivalent request.setAttribute("owner", ownersRepository.findOne(id));
        return "ownercats"; //equivalent request.getRequestDispatcher("ownercats.html").forward(req, res)
    }

    @RequestMapping(value = "/owners", method = RequestMethod.GET)
    public String productsList(Model model){
        model.addAttribute("owners", ownersRepository.findAll());
        return "owners";
    }

    @RequestMapping(value = "/saveowner", method = RequestMethod.POST)
    @ResponseBody
    public String saveProduct(@RequestBody Owner owner) {
        ownersRepository.save(owner);
        return owner.getOwnerId().toString();
    }

    @RequestMapping(value = "/removeowner", method = RequestMethod.POST)
    @ResponseBody
    public String removeOrder(@RequestParam Long Id){
        ownersRepository.delete(Id);
        return Id.toString();
    }
}

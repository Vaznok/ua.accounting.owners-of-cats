package ua.accouting_of_cats.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ua.accouting_of_cats.CatWrapper;
import ua.accouting_of_cats.model.Cat;
import ua.accouting_of_cats.model.Owner;
import ua.accouting_of_cats.repository.CatsRepository;
import ua.accouting_of_cats.repository.OwnersRepository;

@Controller
public class CatsController {

    @Autowired
    private CatsRepository catsRepository;
    @Autowired
    private OwnersRepository ownersRepository;

    @RequestMapping(value = "/savecat", method = RequestMethod.POST)
    @ResponseBody
    public String saveCat(@RequestBody CatWrapper wrapper) {
        Cat cat = catsRepository.save(new Cat(wrapper.name, ownersRepository.findOne(wrapper.ownerId)));
        return cat.getCatId().toString();
    }

    @RequestMapping(value = "/updatecat", method = RequestMethod.POST)
    @ResponseBody
    public String updateOwner(@RequestParam Long Id) {
        Cat cat = catsRepository.findOne(Id);
        cat.setName("Was Updated by Vetall");
        catsRepository.save(cat);
        return cat.getCatId().toString();
    }

    @RequestMapping(value = "/removecat", method = RequestMethod.POST)
    @ResponseBody
    public String removeCat(@RequestParam Long Id){
        catsRepository.delete(Id);
        return Id.toString();
    }
}

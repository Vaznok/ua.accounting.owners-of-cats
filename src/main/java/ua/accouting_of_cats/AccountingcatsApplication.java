package ua.accouting_of_cats;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ua.accouting_of_cats.model.Cat;
import ua.accouting_of_cats.model.Owner;
import ua.accouting_of_cats.repository.CatsRepository;
import ua.accouting_of_cats.repository.OwnersRepository;

@SpringBootApplication
public class AccountingcatsApplication implements CommandLineRunner {

    @Autowired
    OwnersRepository ownersRepository;

    @Autowired
    CatsRepository catsRepository;

    public static void main(String[] args) {
        SpringApplication.run(AccountingcatsApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        ownersRepository.save(new Owner("Jack", "Bauer"));
        ownersRepository.save(new Owner("Chloe", "O'Brian"));
        ownersRepository.save(new Owner("Kim", "Bauer"));
        ownersRepository.save(new Owner("David", "Palmer"));
        ownersRepository.save(new Owner("Michelle", "Dessler"));

        catsRepository.save(new Cat("Barsik", ownersRepository.findOne(1l)));
        catsRepository.save(new Cat("Murka", ownersRepository.findOne(1l)));
        catsRepository.save(new Cat("Stepa", ownersRepository.findOne(2l)));
    }
}

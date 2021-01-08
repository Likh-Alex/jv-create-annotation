package dao;

import java.util.List;
import model.Bet;
import model.Person;

public interface PersonDao {

    void add(Person person);

    Bet getBet(Person person);

    List<Person> getAll();
}

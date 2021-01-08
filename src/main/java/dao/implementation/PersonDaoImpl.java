package dao.implementation;

import dao.PersonDao;
import db.Storage;
import java.util.List;
import model.Bet;
import model.Person;

public class PersonDaoImpl implements PersonDao {

    @Override
    public void add(Person person) {
        Storage.people.add(person);
    }

    @Override
    public Bet getBet(Person person) {
        Person targetPerson = (Person) Storage.people.stream().filter(p -> p.equals(person));
        return targetPerson.getBet();
    }

    @Override
    public List<Person> getAll() {
        return Storage.people;
    }
}

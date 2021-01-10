package factory;

import dao.BetDao;
import dao.PersonDao;
import dao.implementation.BetDaoImpl;
import dao.implementation.PersonDaoImpl;

public class Factory {
    private static BetDao betDao;
    private static PersonDao personDao;

    public static BetDao getBetDao() {
        if (betDao == null) {
            betDao = new BetDaoImpl();
        }
        return betDao;
    }

    public static PersonDao getPersonDao() {
        if (personDao == null) {
            personDao = new PersonDaoImpl();
        }
        return personDao;
    }
}

package dao.implementation;

import dao.BetDao;
import db.Storage;
import java.util.List;
import model.Bet;

public class BetDaoImpl implements BetDao {
    @Override
    public void add(Bet bet) {
        Storage.bets.add(bet);
    }

    @Override
    public List<Bet> getAll() {
        return Storage.bets;
    }
}

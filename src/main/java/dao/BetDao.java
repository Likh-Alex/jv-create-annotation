package dao;

import java.util.List;
import model.Bet;

public interface BetDao {
    void add(Bet bet);

    List<Bet> getAll();
}

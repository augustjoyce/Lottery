package api.lottery;

import java.util.List;

/**
 * Created by denis.selutin on 27.07.2016.
 */
public interface Lottery {
    Long getLotteryNumber(); // unique lottery number
    Type getType();
    List<Ticket> getLotteryTickets();
    void performLottery();
    int [][] getWinCombinations();
    Double takeMoney(Ticket ticket);

    enum Type {
        INSTANT, LOTTO;
    }
}

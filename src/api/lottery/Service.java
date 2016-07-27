package api.lottery;

import java.util.List;

/**
 * Created by denis.selutin on 27.07.2016.
 */
public interface Service {
    Long performNewLottery(Lottery.Type type);// returns lottery number
    List<Ticket> getLotteryTickets(Long lotteryNumber);
    Double takeMoney(Long lotteryNumber, Ticket ticket);
    void endLottery(Long lotteryNumber);
    /**
     * This class should maps lottery numbers to lotteries.
     * So, for {@link #performNewLottery} should create new lottery with certain type
     * and put it into map. Also this method should create lottery tickets and put hem into lottery.
     * {@link #endLottery(Long)} should remove lottery from map.
     * other methods should take into account existed lotteries and should verify
     * whether lottery exists or no.
     */
}

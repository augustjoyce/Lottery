package impl.lottery;

import api.lottery.Lottery;
import api.lottery.Service;

import java.util.List;

/**
 * Created by denis.selutin on 27.07.2016.
 */
public class Main {
    public static void main(String[] args) {
        Service service = new impl.lottery.Service();
        Long lotteryNumber = service.performNewLottery(Lottery.Type.LOTTO);
        List<impl.lottery.Ticket> tickets = service.getLotteryTickets(lotteryNumber);
        assert tickets.size() > 0;
        assert service.takeMoney(-1l, tickets.get(0)) == null;
        int numberOfWins = 0;
        for(impl.lottery.Ticket t : tickets) {
            if(service.takeMoney(lotteryNumber, t) != null) {
                numberOfWins++;
                System.out.println("Ticket #" + t.getNumber() + " wins " + t.getMoney() + "$");
            }
        }
      
        System.out.println(numberOfWins);
   
        assert numberOfWins > 0;
        service.endLottery(lotteryNumber);
        assert service.takeMoney(lotteryNumber, tickets.get(0)) == null;
    }
}

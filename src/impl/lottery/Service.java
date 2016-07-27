package impl.lottery;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import api.lottery.Lottery.Type;


public class Service implements api.lottery.Service {
	Map<Long, Lottery> lotteries = new HashMap<Long, Lottery>();
	
	@Override
	public Long performNewLottery(Type type) {
		Lottery lottery = new Lottery(type);
		lottery.performLottery();
		lotteries.put(lottery.getLotteryNumber(), lottery);
		return lottery.getLotteryNumber();
	}

	@Override
	public List<impl.lottery.Ticket> getLotteryTickets(Long lotteryNumber) {
		
		return lotteries.get(lotteryNumber).getLotteryTickets();
	}

	@Override
	public Double takeMoney(Long lotteryNumber, impl.lottery.Ticket ticket) {
		
		return lotteries.get(lotteryNumber).takeMoney(ticket);
	}

	@Override
	public void endLottery(Long lotteryNumber) {
		lotteries.remove(lotteryNumber);

	}

}

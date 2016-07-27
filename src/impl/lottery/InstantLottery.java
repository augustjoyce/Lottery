package impl.lottery;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import api.lottery.Lottery;
import api.lottery.Ticket;

public class InstantLottery implements Lottery {
	List<Ticket> tickets = new ArrayList<Ticket>();
	Random rand = new Random();
	private int[][] winCombinations = new int[1][1];
	Double money;
	@Override
	public Long getLotteryNumber() {
		
		return 1l;
	}

	@Override
	public Type getType() {
		return Lottery.Type.INSTANT;
	}

	@Override
	public List<api.lottery.Ticket> getLotteryTickets() {
		
		return tickets;
	}

	@Override
	public void performLottery() {
		winCombinations[0][0] = rand.nextInt(10000 - 1001 ) + 1001;

	}

	@Override
	public int[][] getWinCombinations() {
		
		return winCombinations;
	}

	@Override
	public Double takeMoney(api.lottery.Ticket ticket) {
	
		return money;
	}

}

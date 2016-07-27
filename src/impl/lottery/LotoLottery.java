package impl.lottery;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import api.lottery.Lottery;
import api.lottery.Ticket;

public class LotoLottery implements Lottery {
	List<Ticket> tickets = new ArrayList<Ticket>();
	Random rand = new Random();
	private int[][] winCombinations = new int[6][4];
	Double money;
	@Override
	public Long getLotteryNumber() {
		
		return 0l;
	}

	@Override
	public Type getType() {
		
		return Lottery.Type.LOTTO;
	}



	@Override
	public void performLottery() {
		for (int i = 0; i < winCombinations.length; i++) {
			for (int j = 0; j < winCombinations[i].length; j++) {
				winCombinations[i][j] = rand.nextInt(40);
			}
		}

	}

	@Override
	public int[][] getWinCombinations() {
		
		return winCombinations;
	}

	

	@Override
	public Double takeMoney(api.lottery.Ticket ticket) {
		
		return money;
	}

	@Override
	public List<Ticket> getLotteryTickets() {
		return tickets;
	}

}

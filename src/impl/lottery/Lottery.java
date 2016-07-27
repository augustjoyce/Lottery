package impl.lottery;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Lottery implements api.lottery.Lottery {

	List<impl.lottery.Ticket> tickets = new ArrayList<impl.lottery.Ticket>();
	Random rand = new Random();
	private int[][] winCombinations = { { rand.nextInt(40), rand.nextInt(40), rand.nextInt(40), rand.nextInt(40) },
			{ rand.nextInt(40), rand.nextInt(40), rand.nextInt(40), rand.nextInt(40) },
			{ rand.nextInt(40), rand.nextInt(40), rand.nextInt(40), rand.nextInt(40) },
			{ rand.nextInt(40), rand.nextInt(40), rand.nextInt(40), rand.nextInt(40) },
			{ rand.nextInt(40), rand.nextInt(40), rand.nextInt(40), rand.nextInt(40) },
			{ rand.nextInt(40), rand.nextInt(40), rand.nextInt(40), rand.nextInt(40) }};
	private Long lotteryNumber;
	private Type type;
	private int instantWinNumber = rand.nextInt(300);

	Lottery(Type type) {
		this.type = type;
		if (type == Type.LOTTO) {
			for (long i = 0; i < 1000000; i++) {
				tickets.add(new impl.lottery.Ticket(i));
				lotteryNumber = 0l;
			}
		} else if (type == Type.INSTANT) {
			for (long i = 0; i < 1000; i++) {
				tickets.add(new impl.lottery.Ticket(i));
				lotteryNumber = 1l;
			}
		}
	}

	@Override
	public Long getLotteryNumber() {
		return lotteryNumber;
	}

	@Override
	public Type getType() {
		return type;
	}

	@Override
	public List<impl.lottery.Ticket> getLotteryTickets() {

		return tickets;
	}

	@Override
	public void performLottery() {
		if (type == Type.LOTTO) {
			
			for (int i = 0; i < tickets.size(); i++) {
				int matchCount = 0;
				for (int j = 0; j < 3; j++) {
					for (int k = 0; k < winCombinations.length; k++) {
						if (tickets.get(i).getCombination()[j][0] == getWinCombinations()[k][0] &&
								tickets.get(i).getCombination()[j][1] == getWinCombinations()[k][1] &&
								tickets.get(i).getCombination()[j][2] == getWinCombinations()[k][2] &&
								tickets.get(i).getCombination()[j][3] == getWinCombinations()[k][3]) {
							matchCount++;
						}
					}
				}
				switch (matchCount) {
				case 1: {
					tickets.get(i).setMoney(50d);
					takeMoney(tickets.get(i));
				}

					break;
				case 2: {
					tickets.get(i).setMoney(100d);
					takeMoney(tickets.get(i));
				}

					break;
				case 3: {
					tickets.get(i).setMoney(5000d);
					takeMoney(tickets.get(i));
				}

					break;
				case 4: {
					tickets.get(i).setMoney(10000d);
					takeMoney(tickets.get(i));
				}

					break;	
				case 5: {
					tickets.get(i).setMoney(100000d);
					takeMoney(tickets.get(i));
				}

					break;
				case 6: {
					tickets.get(i).setMoney(10000000d);
					takeMoney(tickets.get(i));
				}

					break;
				}
			}
		} else if (type == Type.INSTANT) {
			for (int i = 0; i < tickets.size(); i++) {

				if (tickets.get(i).getTicketValue() == instantWinNumber) {
					tickets.get(i).setMoney(50d);
					takeMoney(tickets.get(i));
				}
			}

		}

	}

	@Override
	public int[][] getWinCombinations() {
		return winCombinations;
	}

	@Override
	public Double takeMoney(impl.lottery.Ticket ticket) {

		return ticket.getMoney();
	}

	public int getInstantWinNumber() {
		return instantWinNumber;
	}

}

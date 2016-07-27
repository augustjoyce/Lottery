package impl.lottery;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import api.lottery.Lottery;
import api.lottery.Lottery.Type;


public class Service implements api.lottery.Service {
	Map<Long, api.lottery.Lottery> lotteries = new HashMap<Long, api.lottery.Lottery>();
	List<api.lottery.Ticket> winningTickets = new ArrayList<api.lottery.Ticket>();
	@Override
	public Long performNewLottery(Type type) {
		if (type == Lottery.Type.LOTTO) {
			LotoLottery loto = new LotoLottery();
			loto.performLottery();
			for (long i = 0; i < 1000000; i++) {
				loto.tickets.add(new Ticket(i));
			}
			lotteries.put(loto.getLotteryNumber(), loto);
			for (int i = 0; i < loto.tickets.size(); i++) {
				int matchCount = 0;
				for (int j = 0; j < 3; j++) {
					for (int k = 0; k < loto.getWinCombinations().length; k++) {
						if (loto.tickets.get(i).getCombination()[j][0] == loto.getWinCombinations()[k][0] &&
							loto.tickets.get(i).getCombination()[j][1] == loto.getWinCombinations()[k][1] &&
							loto.tickets.get(i).getCombination()[j][2] == loto.getWinCombinations()[k][2] &&
							loto.tickets.get(i).getCombination()[j][3] == loto.getWinCombinations()[k][3]) {
							matchCount++;
							winningTickets.add(loto.tickets.get(i));
						}
					}
				}
				switch (matchCount) {
				case 1: {
					loto.money = 50d;
					takeMoney(loto.getLotteryNumber(), loto.tickets.get(i));
				}

					break;
				case 2: {
					loto.money = 100d;
					takeMoney(loto.getLotteryNumber(), loto.tickets.get(i));
				}
					
					break;
				case 3: {
					loto.money = 5000d;
					takeMoney(loto.getLotteryNumber(), loto.tickets.get(i));
				}

					break;
				case 4: {
					loto.money = 10000d;
					takeMoney(loto.getLotteryNumber(), loto.tickets.get(i));
				}

					break;	
				case 5: {
					loto.money = 100000d;
					takeMoney(loto.getLotteryNumber(), loto.tickets.get(i));
				}

					break;
				case 6: {
					loto.money = 10000000d;
					takeMoney(loto.getLotteryNumber(), loto.tickets.get(i));
				}
					
					break;
				}
			}
			
			
			return loto.getLotteryNumber();
		} else if(type == Lottery.Type.INSTANT) {
			InstantLottery instant = new InstantLottery();
			instant.performLottery();
			for (long i = 0; i < 10000; i++) {
				instant.tickets.add(new Ticket(i));
			}
			lotteries.put(instant.getLotteryNumber(), instant);
			for (int i = 0; i < instant.tickets.size(); i++) {
				char[] winComb = Integer.toString(instant.getWinCombinations()[0][0]).toCharArray();
				char[] ticketComb = Integer.toString(instant.tickets.get(i).getTicketValue()).toCharArray();
				if (ticketComb[0] == winComb[0] && ticketComb[1] == winComb[1]) {
					instant.money = 50d;
					winningTickets.add(instant.tickets.get(i));
					takeMoney(instant.getLotteryNumber(), instant.tickets.get(i));
				} else if(ticketComb[0] == winComb[0] && ticketComb[1] == winComb[1]&& ticketComb[2] == winComb[2]){
					instant.money = 1000d;
					winningTickets.add(instant.tickets.get(i));
					takeMoney(instant.getLotteryNumber(), instant.tickets.get(i));
				}else if(ticketComb[0] == winComb[0] && ticketComb[1] == winComb[1]&& ticketComb[2] == winComb[2] && ticketComb[3] == winComb[3]){
					instant.money = 10000d;
					winningTickets.add(instant.tickets.get(i));
					takeMoney(instant.getLotteryNumber(), instant.tickets.get(i));
				}
			}
			
			
			return instant.getLotteryNumber();
		}
		return null;
	}

	@Override
	public List<api.lottery.Ticket> getLotteryTickets(Long lotteryNumber) {
		
		return lotteries.get(lotteryNumber).getLotteryTickets();
	}

	@Override
	public Double takeMoney(Long lotteryNumber, api.lottery.Ticket ticket) {
		
		if (winningTickets.contains(ticket)) {
			return lotteries.get(lotteryNumber).takeMoney(ticket);
		} else return null;
	}

	@Override
	public void endLottery(Long lotteryNumber) {
		lotteries.remove(lotteryNumber);

	}

	

}

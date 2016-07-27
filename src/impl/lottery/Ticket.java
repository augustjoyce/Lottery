package impl.lottery;

import java.util.Random;

public class Ticket implements api.lottery.Ticket {
	private Long number;
	Random rand = new Random();
	
	private int[][] combination = {{ rand.nextInt(40), rand.nextInt(40), rand.nextInt(40), rand.nextInt(40) },
			{ rand.nextInt(40), rand.nextInt(40), rand.nextInt(40), rand.nextInt(40) },
			{ rand.nextInt(40), rand.nextInt(40), rand.nextInt(40), rand.nextInt(40) },
			{ rand.nextInt(40), rand.nextInt(40), rand.nextInt(40), rand.nextInt(40) },
			{ rand.nextInt(40), rand.nextInt(40), rand.nextInt(40), rand.nextInt(40) },
			{ rand.nextInt(40), rand.nextInt(40), rand.nextInt(40), rand.nextInt(40) } };
	
	private Integer ticketValue = rand.nextInt(10000-1001 ) + 1001;
	
	Ticket(Long number){
		this.number = number;
		
	}

	@Override
	public Long getNumber() {
		return number;
	}

	@Override
	public int[][] getCombination() {
		return combination;
	}

	@Override
	public Integer getTicketValue() {
		return ticketValue;
	}

}

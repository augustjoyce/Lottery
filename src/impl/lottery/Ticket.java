package impl.lottery;

import java.util.Random;

public class Ticket implements api.lottery.Ticket {
	private Long number;
	Random rand = new Random();
	private Double money;
	
	private int[][] combination = {{ rand.nextInt(40), rand.nextInt(40), rand.nextInt(40), rand.nextInt(40) },
			{ rand.nextInt(40), rand.nextInt(40), rand.nextInt(40), rand.nextInt(40) },
			{ rand.nextInt(40), rand.nextInt(40), rand.nextInt(40), rand.nextInt(40) },
			{ rand.nextInt(40), rand.nextInt(40), rand.nextInt(40), rand.nextInt(40) },
			{ rand.nextInt(40), rand.nextInt(40), rand.nextInt(40), rand.nextInt(40) },
			{ rand.nextInt(40), rand.nextInt(40), rand.nextInt(40), rand.nextInt(40) } };
	
	private Integer ticketValue = rand.nextInt(300);
	
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
	public Double getMoney() {
		return money;
	}
	public void setMoney(Double money) {
		this.money = money;
	}

}

package api.lottery;

/**
 * Created by denis.selutin on 27.07.2016.
 */
public interface Ticket {
    Long getNumber(); // unique ticket number
    int[][] getCombination(); // used for lot lottery
    Integer getTicketValue(); //used for instant lottery
	
}

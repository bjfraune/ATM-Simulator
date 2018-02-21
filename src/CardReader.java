
public class CardReader {
	
	public Integer acctNumber(Integer acctNum) {
		if (acctNum == null) throw new IllegalArgumentException();

		return acctNum;
	}
	
	public Integer acctNumber(Card card) {
		return card.getCardNumber();
	}

}

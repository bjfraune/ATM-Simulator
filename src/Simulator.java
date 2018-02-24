import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Simulator {
	public Simulator(){
		CardReader cardInput = new CardReader();
		ATMprinter printer = new ATMprinter();
		int acctNum=0, pin=0;
		Account acc = new Account(1111, 3);
		String[] input = new String[2];
		try (Scanner sc = new Scanner(new File("transactions.txt"))){
			while(sc.hasNextLine()) {
				input = sc.nextLine().split(" ");
				switch(input[0]) {
				case "CARDREAD":
					acctNum = Integer.parseInt(input[1]);
					cardInput.acctNumber(acctNum);
					printer.receiptPrint(input[0]+" "+acctNum,true);
					break;
				case "NUM":
					pin  = Integer.parseInt(input[1]);
					if(Bank.validate(acctNum, pin))
						printer.receiptPrint(Integer.toString(pin),true);
					else
						printer.receiptPrint("Invalid account number or pin", true);
					break;
				case "DIS" :
					printer.receiptPrint(input[1], true);
					break;
				case "BUTTON" : 
					acc = new Account(pin, acc.getBalance());
					switch(input[1]){
					case "W" :
						//withdraw
						String wselected = sc.nextLine().split(" ");
						if(wselected[0].equals(NUM))
							acc.withdrawl(wselected[1]);
						printer.receiptPrint("w "+acc.getBalance(), true);
						break;
					case "CB" :
						printer.receiptPrint(acc.getBalance(),true);
						break;
					case "CANCEL" :
						printer.receiptPrint("Transaction canceled! GoodBye!",true);
						break;
					default :
						System.out.print("Error reading Button");
					}
				default :
					System.out.println("Error reading input");
				}
			}	
		}
		catch(FileNotFoundException e) {
			System.out.println("File not found");
		}
	}
}

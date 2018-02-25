import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;



/**
 * @author Fawzieh
 * Simulator class opens up a transactions.txt file, reads it line by line and executes
 * each line depending on what it asks for.
 * NOTE: ALL output is printed out to receipt.txt file through the
 * recieptPrint method in ATMprinter class
 */
public class Simulator {
	public Simulator() throws IOException{
		CardReader cardInput = new CardReader();
		ATMprinter printer = new ATMprinter();
		int acctNum=0, pin=0;
		Account acc = new Account(1111,0);
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
						String [] wselected = sc.nextLine().split(" ");
						if(wselected[0].equals("NUM"))
							acc.withdrawl(Integer.parseInt(wselected[1]));
						printer.receiptPrint("w "+acc.getBalance(), true);
						break;
					case "CB" :
						printer.receiptPrint(Double.toString(acc.getBalance()),true);
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

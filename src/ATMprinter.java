import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * 
 * @author BS
 * @see- 	How to use ATMprinter:
 * You need to construct a printer before printing (this opens the file). When 
 * printing you must specify a whether or not you want the time stamp. When you 
 * are done printing you must shutdown the printer.
 * 
 * @exceptions You may need to add "throws IOexception" to methods inorder to 
 * use the printer
 *
 */
public class ATMprinter {
	private PrintWriter printer;
	private DateTimeFormatter dateFormat;
	/**
	 * Constructor for the printer. This method sets up everything we need for printing a receipt.txt file
	 * @throws IOException
	 */
	public ATMprinter() throws IOException {
		dateFormat = DateTimeFormatter.ofPattern("HH:mm:ss");
		LocalTime.now();
		printer = new PrintWriter("receipt.txt");
	}
	/**
	 * 
	 * @param message --> (String) message to be printed to console
	 */
	public void consolePrint(String message){
		System.out.println(message);
	}
	/**
	 * @param message --> (String) message to be printed on receipt
	 * @param includeTime --> (boolean) decide whether to include time stamp before message.
	 * @timeStamp --> formatted for HH:mm:ss
	 */
	public void receiptPrint(String message, boolean includeTime) {
			if(includeTime) printer.println(LocalTime.now().format(dateFormat)+" " + message);
			else printer.println(message);
	}
	public void shutDownPrinter() {
		printer.close();
	}
	
}
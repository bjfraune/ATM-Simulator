import java.io.IOException;
import java.io.PrintWriter;

/**@author BS
 * @see- How to use printer:
 * You need to construct a printer before printing (this opens the file). When 
 * printing you must specify a whether or not you want the time stamp. When you 
 * are done printing you must shutdown the printer.
 * @exceptions You may need to add "throws IOexception" to methods inorder to 
 * use the printer
 */
public class Printer {
	private PrintWriter printer;

	/**Constructor for the printer. This method sets up everything we need for printing a receipt.txt file
	 * @throws IOException
	 */
	public Printer() throws IOException {
		printer = new PrintWriter("Race_Printout.txt");
	}
	/**@param message --> (String) message to be printed on receipt
	 * @param includeTime --> (boolean) decide whether to include time stamp before message.
	 * @timeStamp --> formatted for HH:mm:ss
	 * */
	public void printThis(double time, String message, boolean includeTime) {
			System.out.println(time + " "+message);
			if(includeTime) printer.println(time+" " + message);
			else printer.println(time +" " +message);
			printer.flush();
	}
	public void shutDownPrinter() {
		printer.close();
	}
	
}
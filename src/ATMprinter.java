import java.io.IOException;
import java.io.PrintWriter;


public class ATMprinter {

	public void printThis(String message){
		System.out.println(message);
		try(PrintWriter printer = new PrintWriter("receipt.txt")){
			printer.println(message);
		}
		catch(IOException e){
			System.out.println("Printer error: "+ e.getMessage());
		}
	}
	
}

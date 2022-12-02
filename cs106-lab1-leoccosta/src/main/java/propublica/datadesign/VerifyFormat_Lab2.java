package propublica.datadesign;

import java.io.PrintStream;
import java.io.ByteArrayOutputStream;

public class VerifyFormat_Lab2 {
	
	public static void main(String[] args)
	{
		ByteArrayOutputStream storage = new ByteArrayOutputStream();
		PrintStream origOut = System.out;
		PrintStream stuOut = new PrintStream(storage);
		
		System.out.flush();
		System.setOut(stuOut);
		
		Main.main(new String[]{""});
		
		System.out.flush();
		System.setOut(origOut);
		
		String studentOutput = storage.toString();
		String correctTable = new PropublicaDataTable(.235, .449, .477, .280).toString();
		String commonAlternative = new PropublicaDataTable(.235, .449, .477, .279).toString();
		
		System.out.println("\n*********************Your output start*********************\n" + studentOutput + "\n*********************Your output end*********************\n");
		System.out.println("\n*********************Correct output start*********************\n" + correctTable + "\n*********************Correct output end*********************\n");
		
		System.out.println("\n=====================Format checker message start=====================\nThis format checker just checks if your Main class prints out the table shown in the Propublica article.");
		if(studentOutput.indexOf(correctTable) != -1 || studentOutput.indexOf(commonAlternative) != -1)
			System.out.println("\tCorrect table was found!");
		else
			System.out.println("\tDid not find the table shown.\n\tThe autograder will accept numbers within +/- 0.1 percent range,\n\tso please check the outputs shown above and make sure they're in the range.");
	}
	
}

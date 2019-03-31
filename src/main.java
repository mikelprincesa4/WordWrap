import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		String inputString;
		int boundary;
		Scanner scan = new Scanner(System.in);
		System.out.println("Input the string to be wrapped:\t");
		inputString = scan.nextLine().toString();
		System.out.print("Input column boundary value:\t");
		boundary = scan.nextInt();
		System.out.println(wordWrap(inputString,boundary));
		System.exit(0);	

	}
	
	public static String wordWrap(String input, int bound) {
		String segment;
		String leftOver;
		int wordBreak;
		
		if (input.length() >= bound) {							/* Returns input string IF it is shorter than the boundary		*/
			
			segment = input.substring(0,bound);					/* Grabs the value of the string cut off at the boundary		*/
			
			if(segment.contains(" ")&& segment.charAt(0)!=' ') {			/* Case:There is a space between words indicating multiple		*/
				wordBreak 	= segment.lastIndexOf(" ");			/*	words.(A space in the beginning signifies a word was)		*/
				segment 	= input.substring(0, wordBreak);		/* 	completed in the last line). Shifts	leftover range by +1. 	*/
				leftOver 	= input.substring(wordBreak+1, input.length());		
			} else if(segment.charAt(0)==' ') {					/* Case: The first character of the segment is a space indicating	*/
				wordBreak 	= segment.lastIndexOf(" ");			/*	that a word was completed in the last line. Shifts reading 	*/
				segment 	= input.substring(1, bound+1);			/*	range of the segment by +1.									*/	
				leftOver 	= input.substring(bound+1, input.length());
			} else {								/* Case:There are no new words(indicated by spaces)in the segment.	*/																	
				wordBreak 	= bound;					/*	Segment will span from 0 to boundary with no conditions.	*/	
				leftOver 	= input.substring(wordBreak, input.length());	/* 	0 to wrap boundary with no conditions.				*/
			}
			return (segment + "\n" + wordWrap(leftOver, bound));
		} else {
			return input;
		}
	} 
}

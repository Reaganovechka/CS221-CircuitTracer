import java.awt.Point;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;


/**
 * Search for shortest paths between start and end points on a circuit board
 * as read from an input file using either a stack or queue as the underlying
 * search state storage structure and displaying output to the console or to
 * a GUI according to options specified via command-line arguments.
 * 
 * @author mvail
 */
public class CircuitTracer{

	/** Launch the program. 
	 * 
	 * @param args three required arguments:
	 *  first arg: -s for stack or -q for queue
	 *  second arg: -c for console output or -g for GUI output
	 *  third arg: input file name 
	 */
	public static void main(String[] args) {
		new CircuitTracer(args); //create this with args
	}

	/** Print instructions for running CircuitTracer from the command line. */
	private void printUsage() {
		System.out.println("Invalid command: expected java CircuitTracer followed by queue(-q) OR stack(-s), AND console(-c) OR gui(-g), AND fileName");
	}
	
	/** 
	 * Set up the CircuitBoard and all other components based on command
	 * line arguments.
	 * 
	 * @param args command line arguments passed through from main()
	 */
	public CircuitTracer(String[] args) {
		
		CircuitBoard board;
		Storage<TraceState> stateStore;
		if (args.length != 3) {
			printUsage();

			return; //exit the constructor immediately
		}
		if (!args[0].equals("-s") && !args[0].equals("-q")){
			printUsage();
			return;
		}
		if (!args[1].equals("-c") && !args[1].equals("-g")) {
			printUsage();
			return;
		}
		switch (args[0]) {
			case "-q" :
				stateStore = Storage.getQueueInstance();
				break;
			case "-s" :
				stateStore = Storage.getStackInstance();
				break;
		}
		String fileName = args[2];
		try {
			board = new CircuitBoard(fileName);
			System.out.println(board.toString());
		} catch (FileNotFoundException e) {
			System.err.println("FileNotFoundException: " + fileName);
			return;
		} catch (InvalidFileFormatException e) {
			System.err.println("Unable to load input file: " + fileName);
			System.err.println("InvalidFileFormatException: " + e.getMessage());
			return;
		}

		//TODO: run the search for best paths
		List<TraceState> bestPaths = new ArrayList<>();
		//Add new initial TraceState onlect to stateStore for each open position adjacent to the starting component
		Point start = board.getStartingPoint();
		Point end = board.getEndingPoint();
		if (board.isOpen((int)start.getX()+1,(int)start.getY())){
			
		}
		//TODO: output results to console or GUI, according to specified choice
		switch(args[1]) {
			case "-c" :
				//TODO
			case "-g" :
				//TODO
		}

	}
	
} // class CircuitTracer

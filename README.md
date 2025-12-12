****************
* CircuitTracer
* CS 221- Mason Vail
* 12/11/2025
* Reagan Ovechka
**************** 

OVERVIEW:

 CircuitTracer implements a brute-force search algorithm to navigate through a circuit board layout, identifying the shortest possible path. This algorithm can be ran using either a stack or a queue and output either to the console or using a GUI (if supported), each of these are identified in the command line


INCLUDED FILES:

 * CircuitTracer.java - source file, contains main/driver class
 * CircuitBoard.java - source file
 * Storage.java - source file, for creating stacks and queues
 * TraceState.java - source file, defines TraceState objects
 * OccupiedPositionException.java - source file, defines error for attempting to occupy a closed position
 * InvalidFileFormatException.java - source file, defines error for invalid file format
 * README - this file


COMPILING AND RUNNING:
 
 From the directory containing all source files, compile the
 driver class (and all dependencies) with the command:
 $ javac CircuitTracer.java

 Run the compiled class file with the command:
 $ java CircuitTracer (-s OR -q) (-c OR -g) (fileName)

 Console output will give the results after the program finishes.


PROGRAM DESIGN AND IMPORTANT CONCEPTS:

 CircuitTracer utilizes a brute-force search algorithm to identify the shortest path from a clear start and end point in a CircuitBoard layout. CircuitTracer uses command line arguments that prompt either the use of a Stack or Queue, and then prompts either outputting the shortest paths in either console or GUI form, however, GUI is not currently supported for CircuitTracer. 

 The first main part of CircuitTracer is the command line arguments. Valid command line arguments are length 3, the first argument must be either "-s" or "-q," the second must be "-c" or "-g," and the third is the given file name. If any of these conditions are not met, a message is displayed to the console with instructions on how to properly run CircuitTracer. If all the arguments are valid, but there is any issue with the file format, an InvalidFileFormatException is thrown with a message of what was wrong with the file. The file is read throught the CircuitBoard constructor, this creates the initial circuit board that will be analyzed through the search algorithm. 

 When the search algorithm located in CircuitTracers driver class begins, TraceStates are created based on the inital open locations surrounding the starting point on the board. TraceStates represent a path through a  CircuitBoard, taking one open position at a time. When a new TraceState is created, it is added to the Storage. The Storage object is a container that holds elements of type T (TraceStates in this case), using the either a Stack of a Queue. 

 When the next element is pulled off either the Stack or Queue, it is checked whether it is solution, and if it is whether it is the the shortest or equal to the shortest. If it is not a solution, all next valid moves are generated in a new TraceState and added to Storage. This then repeats until all paths have been explored and Storage is empty.

 After all shortest solutions are generated, they are outputted in the given format. Currently in CircuitTracer GUI is not supported, so console output is the only valid output.
 

TESTING:

 Testing CircuitTracer can be done two different ways, one being the provided tester class in the intital files, and the other being user input. Using the tester class helps to understand what areas of the program are functioning properly and where errors may occur without manually running every single test file. This will expose common errors in the code or the expected output messages.

 The provided test class tests multiple aspects of XircuitTracer, such if valid files are correctly read in and formatted, invalid files throw and output an exception that is handled properly, incorrect user input displays proper instructions, and all the sample files are outputted with their proper solutions. For manually testing, typing in incorrect commands, or testing a single file is helpful in identifying what is working and what may not be working, as well as verifying that all output messages are as expected.

 This program can handle bad input by checking if all the command line arguments are valid, and in the case that they are not valid, displays a message with proper directions. This insures that someone who has no idea how the program works could figure out how to run the program and get output.

 While the tester class and user input are sufficient ways to test, there is no way to 100% guarentee that the program is bug free for every valid file that could be used. Despite this, successful testing with these two methods provides high confidence in the programs functionality and minimal bugs.

ANALYSIS:
 The choice of a stack versus a queue affects the sequence in which paths are explored in the search algorithm. The choice of a stack (a LIFO datastructure) may find a solution faster, but the choice of a queue (a FIFO datastructure) may find the shortest path faster. This happens because a stack is only exploring one path at a time, taking the TraceState that was most recently added first. The queue however, explores multiple paths at one time by taking the oldest added TraceState, this allows for traversal of multiple possible paths in a more consecutive order than a stack.

 This is proven with the simple addition of the counters in the search algorithm that print how many TraceStates were created before a solution was found. For example, using one of the provided test files, valid3.dat, the first solution was found after 13 states when using a stack, but when using a queue the first solution was found after 59 traces. While the first solution the queue found was after 59 traces, which is more than the stack, the shortest path length was also found after 59 traces were created. Wheras with using a stack, it took the algorithm 183 cases to find the shortest path. This example shows that a queue may be more effective in finding the shortest path quicker than the choice of a stack.

 Despite the queue being more likely to find a solution in fewer steps, this does not always happen, such as with sample file valid4.dat. In valid4.dat, both stack and queue found the shortest path length of 11 after finding their first solution. However, for a stack this was after 62 traces were created, and with a queue this as after 109 traces. This means that this is not always the case.

 Memory use is also affected by the choice of stack or queue. In general, queues use more memory than stacks and grows exponentially, wheras a stack only explores one possible path at a time, keeping the amount of traces in memory lower.

 The Big-Oh runtime order for this search algorithm is O(n)


DISCUSSION:
 
 While writing this program I was met with a few questions or issues. One of them was I had to research some more info on command line arguments. When checking which case was selected, I was unsure if these were read as strings or not, so I looked up a few things and found out that this was in fact the case and that -q, -s, -c, and -g are all read as strings in the command line because of the arguments being a list of strings. Another issue I ran into was when running the provided test class, I was not getting the correct outputs, however my program was technically outputting error messages when it should, it was just not cotaining the correct output.
 
 The planning portion and processing the task at hand and how each file worked together was a bit of a struggle for me to initally wrap my head around. But by reading each file carefully to understand how each of them worked together, when it came time to write out the algorithm based off the provided pseudocode, I was able to write this fairly effortlessly and it worked first try.

----------------------------------------------------------------------------

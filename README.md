# CircuitTracer

 A java based maze traversal that implements a brute-force search algorithm to identify the shortest path through a circuit board layout. This was the final project in my CS 221 Computer Science II course taken from Mason Vail at Boise State University.

OVERVIEW:

 CircuitTracer is a technical exploration into the usage of Stacks and Queues. The application navigates a grid-based circuit board - with a given start and end point - to find the most efficient path between the two. It allows users to toggle between either a Stack or a Queue within the command line to observe the change in the program's efficiency.

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

 CircuitTracer utilizes a brute-force search algorithm to identify the most efficient (shortest) paths between designated coordinates on a grid-based circuit board. CircuitTracer implements a generic storage container to support both Stacks and Queues, allowing for an interchangable state-space exploration.

 Created with a Command Line Interface that allows the user to toggle between running the search algorithm with either a Stack or a Queue. Command line provides dynamic error messaging to provide directions and ensure proper program execution. Using the commang line argument, CircuitBoard parses raw file data into a searchable grid state prior to the algorithms execution.

 When the search algorithm begins, TraceStates are created based on the inital open locations surrounding the starting point on the board. TraceStates represent a path through a  CircuitBoard, taking one open position at a time. When a new TraceState is created, it is added to the Storage.

 When the next TraceState is pulled from Storage, it is checked whether or not it is a solution. If the TraceState is a solution, it is checked if it's the current shortest solution, if so it is stored as a shortest solution. If the TraceState is not a solution, the next possible TraceStates are generated and added to storage.

 After all shortest solutions are generated, they are outputted in the given format. Currently in CircuitTracer GUI is not supported, so console output is the only valid output.
 

TESTING:

 Testing CircuitTracer can be done two different ways, one being the provided tester class in the intital files, and the other being user input. Using the tester class helps to understand what areas of the program are functioning properly and where errors may occur without manually running every single test file. This will expose common errors in the code or the expected output messages.

 The provided test class tests multiple aspects of CircuitTracer, such if valid files are correctly read in and formatted, invalid files and output throw an exception that is handled properly, incorrect user input displays proper instructions, and all the sample files are outputted with their proper solutions. For manually testing, typing in incorrect commands, or testing a single file is helpful in identifying what is working and what may not be working, as well as verifying that all output messages are as expected.

 This program can handle bad input by checking if all the command line arguments are valid, and in the case that they are not valid, displays a message with proper directions. This insures that someone who has no idea how the program works could figure out how to run the program and get output.

 Successful testing with these two methods provides high confidence in the programs functionality and minimal bugs.

----------------------------------------------------------------------------

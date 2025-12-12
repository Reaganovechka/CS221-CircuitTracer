****************
* CircuitTracer
* CS 221- Mason Vail
* 12/11/2025
* Reagan Ovechka
**************** 

OVERVIEW:

 CircuitTracer implements a brute-force search algorithm to navigate through a circuit board layout, identifying the shortest possible path. This algorithm can be ran using either a stack or a queue and output either to the console or using a GUI (if supported), each of these are identified in the command line


INCLUDED FILES:

 List the files required for the project with a brief
 explanation of why each is included.

 e.g.
 * CircuitTracer.java - source file
 * CircuitBoard.java - source file
 * Storage.java
 * TraceState.java 
 * OccupiedPositionException.java
 * InvalidFileFormatException.java
 * README - this file


COMPILING AND RUNNING:
 
 From the directory containing all source files, compile the
 driver class (and all dependencies) with the command:
 $ javac CircuitTracer.java

 Run the compiled class file with the command:
 $ java CircuitTracer (-s OR -q) (-c OR -g) (fileName)

 Console output will give the results after the program finishes.


PROGRAM DESIGN AND IMPORTANT CONCEPTS:

 This is the sort of information someone who really wants to
 understand your program - possibly to make future enhancements -
 would want to know.

 Explain the main concepts and organization of your program so that
 the reader can understand how your program works. This is not a repeat
 of javadoc comments or an exhaustive listing of all methods, but an
 explanation of the critical algorithms and object interactions that make
 up the program.

 Explain the main responsibilities of the classes and interfaces that make
 up the program. Explain how the classes work together to achieve the program
 goals. If there are critical algorithms that a user should understand, 
 explain them as well.
 
 If you were responsible for designing the program's classes and choosing
 how they work together, why did you design the program this way? What, if 
 anything, could be improved? 

TESTING:

 How did you test your program to be sure it works and meets all of the
 requirements? What was the testing strategy? What kinds of tests were run?
 Can your program handle bad input? Is your program  idiot-proof? How do you 
 know? What are the known issues / bugs remaining in your program?

ANALYSIS:
 The choice of a stack versus a queue affects the sequence in which paths are explored in the search algorithm. The choice of a stack (a LIFO datastructure) will find a solution faster, but the choice of a queue (a FIFO datastructure) will find the shortest path faster. This happens because a stack is only exploring one path at a time, taking the TraceState that was most recently added first. The queue however, explores multiple paths at one time by taking the oldest added TraceState, this allows for traversal of multiple possible paths in a more consecutive order than a stack.

 This is proven with the simple addition of the


DISCUSSION:
 
 Discuss the issues you encountered during programming (development)
 and testing. What problems did you have? What did you have to research
 and learn on your own? What kinds of errors did you get? How did you 
 fix them?
 
 What parts of the project did you find challenging? Is there anything
 that finally "clicked" for you in the process of working on this project?
 
 
EXTRA CREDIT:

 If the project had opportunities for extra credit that you attempted,
 be sure to call it out so the grader does not overlook it.


----------------------------------------------------------------------------

All content in a README file is expected to be written in clear English with
proper grammar, spelling, and punctuation. If you are not a strong writer,
be sure to get someone else to help you with proofreading. Consider all project
documentation to be professional writing for your boss and/or potential
customers.

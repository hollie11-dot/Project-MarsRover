The Mars Rover
===============
The Mars Rover project is an application which simulates the movement of a Rover across the surface of Mars which is represented by a rectangular Plateau. 
The Rover can receive instructions to rotate and move. 
The project follows principals of TDD, and OOP class design. 

Features
=========
**The Plateau**: 
- The Plateau's dimensions are defined by the user by entering X and Y co-ordinates to initialise the size of the plateau
  
**The Rover position**: 
- A Rover's position is represented by an X and Y co-ordinate and a facing direction. The inital landing position of the Rover is defined by the user
  
**Instructions**:
- Instructions of `L`, `R`, and `M` (left, right and move) are sent to the Rover
- `L`	Spins the Rover 90 degrees Left without moving from the current coordinate point
- `R`	Spins the Rover 90 degrees Right without moving from the current coordinate point
- `M`	Moves the Rover forward by one grid point, maintaining the same heading/orientation

**Parsing**
- All user inputs are parsed to ensure that only valid input is acted upon. Error handling prompts the user to re-enter inputs when invalid inputs are passed. 

**Boundary Testing:**
- To ensure that the Rover remains within the defined plateau grid, boundary testing is in place. Users will be prompted to re-enter instructions if current instructions moves the Rover to an out of bounds position. 

**Inputs:** 
- Plateau creation as X and Y co-ordinates.\
  Example:\
  `5 5`
- Initial landing position of the Rover represented as an X and Y co-ordinate and a facing direction\
  Example:\
  `1 2 N`
- Instructions: multiple instructions can be sent to the Rover to be executed sequentially\
  Example:\
  `LRMLRMLRM`
  
**Outputs:**
- The final position of the Rover is represented as an X and Y co-ordinate and a facing direction.\
  Example:\
  `3 4 S`

Getting Started
===============

**Prerequisites**
- Java Development Kit - Java 8+
- IDE (e.g. IntelliJ IDEA, Eclipse, VS code)

**Installation**
- Fork and clone the repository:
 `git clone https://github.com/hollie11-dot/Project-MarsRover.git`
- Open the project in your IDE
- Find the `Main` class at `src/main/java/Main.java`
- Run the program 


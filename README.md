The Mars Rover
===============

The Plateau
============
The Plateau is divided into a grid.
The first line inputted into the program represents the upper-right coordinates of the Plateau.

The Rover position
===================
A Rover's position is represented by x and y co-ordinates and the letters N, S, W, E to represent North, South, West, East (the four cardinal compass points) respectively.
Following the plateau creation, each Rover receives an input to land the Rover at a particular starting position e.g. 1 2 N. This lands the Rover at position (1,2) facing North.

Instructions
===============
To move a Rover around the Plateau, a string of letters is sent to a Rover.

Letter	Action
L	Spins the Rover 90 degrees Left without moving from the current coordinate point
R	Spins the Rover 90 degrees Right without moving from the current coordinate point
M	Moves the Rover forward by one grid point, maintaining the same heading/orientation

Output
======
For each Rover, the output represents its final position: the coordinates and where it is facing.


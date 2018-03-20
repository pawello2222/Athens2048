# Athens2018

An international student take on Netherlands' National e-Sport

## Rules
4x4 Grid, obtain a 2048 tile, by merging those that have equal value.

(0, 0)|(1, 0)|...|(0, n)
-|-|-|-
...|...|(i + 1, j - 1)|...
(i -1, j)|(i, j)|(i + 1, j)|...
(n, 0)|...|...|(n, n)

### Movement

4 Commands: Left, Right, Up, Down.

Tiles move in the selected direction if:
* There is a tile in the i+1 direction
* The i+1 tile is empty OR i+1 value is equal to the moving one

If i, i+1 values are equal, MERGE

## Merging

LEFT|RIGHT|UP|DOWN
-|-|-|-
val(i-1, j) = val(i,j)+val(i-1, j)|val(i+1, j) = val(i,j)+val(i+1, j)|val(i, j+1) = val(i,j)+val(i, j + 1)|val(i, j-1) = val(i,j)+val(i, j-1)


### Spawning

Spawning a new tile is the last action in a turn. The spawned tile appears in a RANDOM location, on a free spot. The value of the spawned tile is either 2 or 4.

##### Probabilities

p(2)|p(4)
-|-
89,8 %|10,2%

## Prerequisites

Built using IntelliJ IDE.

## Built With

* [Swing](https://docs.oracle.com/javase/7/docs/api/javax/swing/package-summary.html) - GUI library
* [Maven](https://maven.apache.org/) - Dependency Management
* [JUnit](https://junit.org/) - Used for unitary tests

***

## Authors

* **Antony Lopez** - *Random picker*
* **Paweł Wiszenko** - *Project setup, logic*
* **Luís Alves** - *GUI*
* **Mateus Orsoni Cabral** - *Core logic*
* **Wojciech Karpiński** - *Documentation*

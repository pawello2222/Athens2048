# Athens2018

An international student take on Netherlands' National e-Sport

## Rules
4x4 Grid, obtain a 2048 tile, by merging those that have equal value.

|(0, 0)|(1, 0)|...|(0, n)|
|-|-|-|
|...|...|(i + 1, j - 1)|...|
|(i -1, j)|(i, j)|(i + 1, j)|...|
|(n, 0)|...|...|(n, n)|

### Movement

4 Commands: Left, Right, Up, Down.

Tiles move in the selected direction if:
* There is a tile in the i+1 direction
* The i+1 tile is empty OR i+1 value is equal to the moving one

If i, i+1 values are equal, MERGE

## Merging

|LEFT|RIGHT|UP|DOWN|
|-|-|-|
|val(i-1, j) = val(i,j)+val(i-1, j)|val(i+1, j) = val(i,j)+val(i+1, j)|val(i, j+1) = val(i,j)+val(i, j + 1)|val(i, j-1) = val(i,j)+val(i, j-1)|


### Spawning

Spawning a new tile is the last action in a turn. The spawned tile appears in a RANDOM location, on a free spot. The value of the spawned tile is either 2 or 4.

##### Probabilities
|p(2)|p(4)|
|-|
|89,8 %|10,2%|


### Prerequisites

What things you need to install the software and how to install them

```
Give examples
```

### Installing

A step by step series of examples that tell you have to get a development env running

Say what the step will be

```
Give the example
```

And repeat

```
until finished
```

End with an example of getting some data out of the system or using it for a little demo

## Running the tests

Explain how to run the automated tests for this system

### Break down into end to end tests

Explain what these tests test and why

```
Give an example
```

### And coding style tests

Explain what these tests test and why

```
Give an example
```

## Deployment

Add additional notes about how to deploy this on a live system

## Built With

* [Dropwizard](http://www.dropwizard.io/1.0.2/docs/) - The web framework used
* [Maven](https://maven.apache.org/) - Dependency Management
* [ROME](https://rometools.github.io/rome/) - Used to generate RSS Feeds

## Contributing

Please read [CONTRIBUTING.md](https://gist.github.com/PurpleBooth/b24679402957c63ec426) for details on our code of conduct, and the process for submitting pull requests to us.

## Versioning

We use [SemVer](http://semver.org/) for versioning. For the versions available, see the [tags on this repository](https://github.com/your/project/tags).

## Authors

* **Billie Thompson** - *Initial work* - [PurpleBooth](https://github.com/PurpleBooth)

See also the list of [contributors](https://github.com/your/project/contributors) who participated in this project.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments

* Hat tip to anyone who's code was used
* Inspiration
* etc

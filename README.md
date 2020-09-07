# cmpt213

## Assignment 1
Implemented text-based query system of superheros. This system allows a user to maintain a list of superheros recording a small collection of their attributes.\
Superheros are saved in the form JSON and GSON library is used to handle the JSON.

## Assignment 2
* Maze exploration game.
* In brief there is a hero and three monsters, hero has to collect three powers and kill monsters. On otherside, if hero come in connect of monsters without       collecting powers then game ends and user loses.
* Recursive implementation is used as Maze generating algorithm.
* 2*2 square constraint is followed, such that there cannot be:-
  * 2*2 open cells
  * 2*2 closed cells
* text-user based interface.
* CRC cards made
* UML diagram made

## Assignment 3
### Part 1
Canvas shapes are drawn and customized colors and characters are filled in these shapes.\

### Part 2
#### Online SuperHero Tracker
* Spring Boot Rest API's are used to implement functionality of SuperHero Tracker (Similar to assignment 1) on local server.
* GET and POST HTTP methods are used, with URL and JSON.
* Exceptions and errors are handled, HTTP response status are handled accordingly.
* Data between server and clients are exchanged in JSON format.

## Assignment 4
###  Online html-based Hangman game using Spring Boot and Thymeleaf
* Players can go to a specific webpage using their web browser to play the game 
* GetMapping, PostMapping and PostConstruct is used to play the game.
* Game is played using following path requests :-
  * localhost:8080/welcome - displays the welcome page for the user.
  * localhost:8080/game - new game sessions is started using this request
  * localhost:8080/game/id - user can return to existing game sessions using request by stating the correct id, otherwise exception is thrown.
* Player is redirected from welcome.html to game.html
* Each game session is stored as Game  object.
* On lose or won of the game player is redirected to gameover.html

<ins> leveraged learning :- </ins>  Model-View-Controller (MVC) Design Pattern and The Thymeleaf Engine

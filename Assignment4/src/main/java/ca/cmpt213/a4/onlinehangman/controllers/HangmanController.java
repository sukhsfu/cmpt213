package ca.cmpt213.a4.onlinehangman.controllers;

import ca.cmpt213.a4.onlinehangman.model.Game;
import ca.cmpt213.a4.onlinehangman.model.Message;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicLong;

@Controller
public class HangmanController {
    private Message promptMessage; //a resusable String object to display a prompt message at the screen
    private AtomicLong nextId=new AtomicLong();
    private ArrayList<String> words=new ArrayList<>();
    private ArrayList<Game> games=new ArrayList<>();
    private  int index;
    //works like a constructor, but wait until dependency injection is done, so it's more like a setup
    @PostConstruct
    public void hangmanControllerInit() {
        promptMessage = new Message("Initializing...");
    }


    @GetMapping("/welcome")
    public String showHelloWorldPage(Model model) {

        promptMessage.setMessage("Welcome  to the Hangman game");
        model.addAttribute("promptMessage", promptMessage);


        return "helloworld";
    }
    @PostMapping("/game")
    public String playGame(@ModelAttribute Game game,Model model) {
        if(game.getGuess()==null) {
            game.setId(nextId.incrementAndGet());
            game.setStatus(Game.Status.Active);
            words.clear();
            try {
                File myObj = new File("commonWords.txt");
                Scanner myReader = new Scanner(myObj);
                while (myReader.hasNextLine()) {
                    words.add(myReader.nextLine());
                }
                int size = words.size();
                Random rand = new Random();
                int random = rand.nextInt(size);
                game.setWord(words.get(random));
                String progress = "";
                for (int i = 0; i < game.getWord().length(); i++) {
                    progress = progress + "_ ";
                }
                game.setProgress(progress);

            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
            game.setTotalGuesses(0);
            game.setWrongGuesses(0);
            game.setGuess("");
            games.add(game);
            index=games.size()-1;
        }
        else if(!game.getGuess().isEmpty()&&!game.getGuess().replaceAll(" ","").isEmpty()){
             Game game1=games.get(index);
            char guess=game.getGuess().charAt(0);
            guess=Character.toLowerCase(guess);
            String progress = game1.getProgress().replaceAll(" ","");
            StringBuilder progress1= new StringBuilder();
            String word=game1.getWord();
            boolean wrongGuess=true;
            for (int i = 0; i < word.length(); i++) {
                if((word.charAt(i))==guess){
                    progress1.append(guess);
                    wrongGuess=false;
                }
                else{
                    progress1.append(progress.charAt(i));
                }
                progress1.append(' ');
            }
            game1.setTotalGuesses(game1.getTotalGuesses()+1);
            if(wrongGuess){
                game1.setWrongGuesses(game1.getWrongGuesses()+1);
            }
            game1.setProgress(progress1.toString());
            String progressCheck=game1.getProgress().replaceAll(" ","");
            if(progressCheck.equals(game1.getWord())&&game1.getStatus()!= Game.Status.Loss){
                game1.setStatus(Game.Status.Won);
                return "gameOverWon";
            }
            if(game1.getWrongGuesses()>7&&game.getStatus()!= Game.Status.Won){
                game1.setStatus(Game.Status.Loss);
                return "gameOverLoss";
            }
            games.remove(index);
            games.add(index,game1);

        }

        Game game1=games.get(index);
        game.setGuess("");
        model.addAttribute("games",game1);
       return "gamedisplay";
    }
    @GetMapping("/game/{id}")
    public String playGameWithId(@PathVariable("id")long gameId,@ModelAttribute Game game,Model model){
        if(gameId<0||gameId>=games.size()){
            throw new GameNotFoundException("Game Not Found");
        }
         index = (int)gameId-1;
        Game game1=games.get(index);
        game.setGuess("");
        model.addAttribute("games",game1);
        if(game1.getStatus()== Game.Status.Won){
            return "gameOverWon";
        }
        if(game1.getStatus()== Game.Status.Loss){
            return "gameOverLoss";
        }
        return "gamedisplay";

    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND,
            reason = "Request ID not found")
    @ExceptionHandler({GameNotFoundException.class})
    public ModelAndView badIdExceptionHandler2(GameNotFoundException e) {
        return new ModelAndView("gameNotFound","error",e.getMessage());

    }



}
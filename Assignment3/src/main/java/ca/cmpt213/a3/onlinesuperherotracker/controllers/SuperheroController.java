package ca.cmpt213.a3.onlinesuperherotracker.controllers;

/*
Class to control requests from the local host.
 */
import ca.cmpt213.a3.onlinesuperherotracker.model.Superhero;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class SuperheroController {
    private List<Superhero> superheroes=new ArrayList<>();
    private AtomicLong nextId=new AtomicLong();

    @GetMapping("/hello")
    public String getHelloMessage(){
        return "Hello welcome to Superhero Tracker Online!";
    }

    @GetMapping("/listAll")
    public List<Superhero> allSuperHero(){
        return superheroes;
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Superhero addSuperHero(@RequestBody Superhero superhero){
        if(superhero.getHeight()<0||superhero.getNumberOfCiviliansSaved()<0){
            throw new IllegalArgumentException();
        }
        superhero.setId(nextId.incrementAndGet());
        superheroes.add(superhero);
        return superhero;

    }
    @PostMapping("/remove/{id}")
    public List<Superhero> removeSuperHero(@PathVariable("id") long superHeroId){
        for(Superhero superhero:superheroes){
            if(superhero.getId()==superHeroId){
                superheroes.remove(superhero);
                return superheroes;
            }
        }
        throw new SuperheroNotFoundException();

    }
    @PostMapping("/update/{id}")
    public Superhero updateSuperHero(@PathVariable("id") long superHeroId,@RequestBody Superhero newsuperhero){

        for(Superhero superhero:superheroes){
            if(superhero.getId()==superHeroId){
                if(newsuperhero.getHeight()<0||newsuperhero.getNumberOfCiviliansSaved()<0){
                    throw new IllegalArgumentException();
                }
             superheroes.remove(superhero);
             newsuperhero.setId(superHeroId);
             superheroes.add(newsuperhero);
             return newsuperhero;
            }
        }

            throw new SuperheroNotFoundException();



    }
    @ResponseStatus(value = HttpStatus.BAD_REQUEST,
            reason = "Invalid Values")
    @ExceptionHandler(IllegalArgumentException.class)
    public void badIdExceptionHandler() {
        // Nothing to do
    }
    @ResponseStatus(value = HttpStatus.NOT_FOUND,
            reason = "Request ID not found")
    @ExceptionHandler(SuperheroNotFoundException.class)
    public void badIdExceptionHandler2() {
        // Nothing to do
    }

}

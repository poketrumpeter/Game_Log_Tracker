package com.games.gamelog.games.Controller;

import com.games.gamelog.games.*;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.mongodb.core.mapping.MongoId;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class GameController{

    List<Game> games;

    @Autowired
    private UserRepository repository;

    private static final String welcomeTemplate = "Welcome, %s!";
    private static final String favoriteGame = "Favorite Game: %s";

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String welcome(@RequestParam(value = "id", defaultValue = "") String id, Model model){

        User mainUser;
        ObjectId objectId = new ObjectId(id);
        if(repository.findById(objectId) != null){
            mainUser = repository.findById(id).get();
        }
        else{
            mainUser = new User("User Name", "Game", "User");
        }

        games = mainUser.getGames();

        //Display name and favorite game from user member

        //Declaring and adding object ot the model
        model.addAttribute("Welcoming", String.format(welcomeTemplate, mainUser.getFirstName()));
        model.addAttribute("game", String.format(favoriteGame, mainUser.getFavoriteGame()));
        model.addAttribute("games", games);
        model.addAttribute("id", id);

        return "index";

    }

    @RequestMapping(value = "/game", method = RequestMethod.GET)
    public String showGame(@RequestParam(value = "game", defaultValue = "") String gameName, Model model){


        ArrayList<Genre> genres = new ArrayList<>();

        genres.add(new Genre("RPG"));
        genres.add(new Genre("Multiplayer"));
        genres.add(new Genre("Simulation"));

        model.addAttribute("genres", genres);
        model.addAttribute("gameName", gameName);

        return "gameHome";
    }

    @RequestMapping(value = "/addGame", method = RequestMethod.GET)
    public String showGameForm(@RequestParam(value = "id")String id, Model model){

        model.addAttribute("gameEntry", new defaultGame());
        model.addAttribute("id", id);
        return "newGame";
    }


    @RequestMapping(value = "/addGame",  method = RequestMethod.POST)
    public ModelAndView recordNewGame(@ModelAttribute defaultGame newGame, ModelMap model,
                                      @RequestParam (value = "id") String id){


        System.out.println(newGame.getGenre());
        //Add game to mongoDB
        //find the relating User
        ObjectId objectId = new ObjectId(id);

        User mainUser = repository.findById(objectId);
        mainUser.addGame(newGame.getName(), newGame.getGenre());

        repository.save(mainUser);


        model.addAttribute("id", mainUser.getId());

        return new ModelAndView("redirect:/", model);
    }



}

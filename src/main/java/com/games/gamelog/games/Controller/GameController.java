package com.games.gamelog.games.Controller;

import com.games.gamelog.games.*;
import com.games.gamelog.games.displays.MultiplayerDisplay;
import com.games.gamelog.games.displays.PlatformerDisplay;
import com.games.gamelog.games.displays.RPGDisplay;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.websocket.Session;
import java.util.List;

@Controller
public class GameController{

    List<Game> games;

    @Autowired
    private UserRepository repository;

    private SessionFactory sessionMaker = new SessionFactory();

    private static final String welcomeTemplate = "Welcome, %s!";
    private static final String favoriteGame = "Favorite Game: %s";

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String welcome(@RequestParam(value = "id", defaultValue = "5fbfdaed2253a51a9cecb827")
                                        String id, Model model){

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
        model.addAttribute("user", mainUser);

        return "index";

    }

    @RequestMapping(value = "/game", method = RequestMethod.GET)
    public String showGame(@RequestParam(value = "game", defaultValue = "") String gameName,
                           @RequestParam(value = "id", defaultValue = "5fbfdaed2253a51a9cecb827") String id,
                           Model model){

        User currentUser = repository.findById(id).get();

        Game currentGame = currentUser.findGame(gameName);

        model.addAttribute("currentGame", currentGame);
        model.addAttribute("id", id);

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

        ObjectId objectId = new ObjectId(id);

        User mainUser = repository.findById(objectId);
        mainUser.addGame(newGame.getName(), newGame.getGenre());

        repository.save(mainUser);


        model.addAttribute("id", mainUser.getId());

        return new ModelAndView("redirect:/", model);
    }

    @RequestMapping(value = "/addSession", method = RequestMethod.GET)
    public String createNewSession(@RequestParam(value = "game", defaultValue = "") String game,
                                   @RequestParam(value = "id", defaultValue = "5fbfdaed2253a51a9cecb827") String id,
                                   Model model){

        ObjectId objectId = new ObjectId(id);

        User mainUser = repository.findById(objectId);
        Game currentGame = mainUser.findGame(game);

        model.addAttribute("gameName", currentGame.getName());
        //Use factory
        GameSession newSession = sessionMaker.createSession(currentGame.getGenre(), currentGame.getName());

        System.out.println(newSession);

        model.addAttribute("sessionEntry", newSession);
        model.addAttribute("id", id);

        return "newSession";
    }

    @RequestMapping(value = "/addSession", method = RequestMethod.POST)
    public String addNewSession(@RequestParam(value = "id", defaultValue = "5fbfdaed2253a51a9cecb827") String id,
                                      @ModelAttribute GameSession newSession, Model model){


        model.addAttribute("id", id);

        GameSession addSession = sessionMaker.createSession(newSession.getGenre(), newSession.getGameName(),
                                                        newSession.getCurrentDate(), newSession.getGoals());

        model.addAttribute("currentSession", addSession);

        return getSession(newSession.getGenre());
    }

    @RequestMapping(value = "/RPGSession", method = RequestMethod.POST)
    public ModelAndView sessionCompleted(@RequestParam(value = "id", defaultValue = "5fbfdaed2253a51a9cecb827") String id,
                                         @ModelAttribute RPGSession newSession, ModelMap model) {

        newSession.setDisplay(new RPGDisplay(newSession.getQuests()));

        //System.out.println(newSession.getGameName());
        User mainUser = repository.findById(id).get();

        Game updateGame = mainUser.findGame(newSession.getGameName());

        mainUser.addSession(updateGame, newSession);

        repository.save(mainUser);

        model.addAttribute("id", id);
        return new ModelAndView("redirect:/", model);
    }

    @RequestMapping(value = "/MultiplayerSession", method = RequestMethod.POST)
    public ModelAndView completeRPGSession(@RequestParam(value = "id", defaultValue = "5fbfdaed2253a51a9cecb827") String id,
                                           @RequestParam(value = "game", defaultValue = "") String game,
                                           @ModelAttribute MultiplayerSession newSession, ModelMap model){

        //System.out.println(newSession.getGameName());

        System.out.println(newSession.getSessionTime());

        newSession.setDisplay(new MultiplayerDisplay(newSession.getMatches(), newSession.getImprovements()));


        newSession.setGameName(game);

        User mainUser = repository.findById(id).get();

        Game updateGame = mainUser.findGame(game);

        mainUser.addSession(updateGame, newSession);

        repository.save(mainUser);


        model.addAttribute("id", id);

        return new ModelAndView("redirect:/", model);
    }

    @RequestMapping(value = "/PlatformerSession", method = RequestMethod.POST)
    public ModelAndView completeRPGSession(@RequestParam(value = "id", defaultValue = "5fbfdaed2253a51a9cecb827") String id,
                                           @RequestParam(value = "game", defaultValue = "") String game,
                                           @ModelAttribute PlatformerSession newSession, ModelMap model){

        newSession.setDisplay(new PlatformerDisplay(newSession.getLevels()));
        newSession.setGameName(game);

        User mainUser = repository.findById(id).get();

        Game updateGame = mainUser.findGame(game);

        mainUser.addSession(updateGame, newSession);

        repository.save(mainUser);

        model.addAttribute("id", id);

        return new ModelAndView("redirect:/", model);
    }


    public String getSession(String genre){

        switch (genre){
            case "RPG":
                return "RPGSessionInfo";

            case "Multiplayer":
                return "MultiplayerSessionInfo";

            case "Platformer":
                return "PlatformerSessionInfo";

            default:
                return null;
        }
    }

}

package com.stolfa.controller;

import com.stolfa.service.GameService;
import com.stolfa.view.Game;
import java.security.InvalidParameterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameController {

    @Autowired
    GameService service;

    @GetMapping("/play/outcomeone/{outcomeOne}/outcometwo/{outcomeTwo}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Object> play(@PathVariable final int outcomeOne, @PathVariable final int outcomeTwo) {

        Game game = null;

        try {
            game = service.play(outcomeOne, outcomeTwo);
        } 
        catch (InvalidParameterException e) {
            return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } 
        catch (Exception e) {
            return new ResponseEntity<Object>(e.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<Object>(game, HttpStatus.OK);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleBindException(Exception be) {
        return new ResponseEntity<Object>("outcomeone and outcometwo must be numerical!", HttpStatus.BAD_REQUEST);
    }

}

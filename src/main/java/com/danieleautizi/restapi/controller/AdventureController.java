package com.danieleautizi.restapi.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.danieleautizi.restapi.exception.CreationFailureException;
import com.danieleautizi.restapi.exception.NotFoundException;
import com.danieleautizi.restapi.model.Adventure;
import com.danieleautizi.restapi.service.AdventureService;

@RestController
@RequestMapping("/adventures")
public class AdventureController {

    @Autowired
    private AdventureService adventureService;

    public AdventureController() {}

    @RequestMapping(value = "/adventure", method = RequestMethod.POST)
    public Adventure create(@RequestBody Adventure adventure) {
        Adventure created = adventureService.create(adventure);
        if (created == null) 
            throw new CreationFailureException();

        return created;
    }
 
    @RequestMapping(value = "/adventure/{uuid}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("uuid") UUID uuid) {
        adventureService.delete(uuid);
    }
 
    @RequestMapping(value="/all", method = RequestMethod.GET)
    public List<Adventure> findAll() {
        List<Adventure> adventures = adventureService.getAllAdventures();
        if (adventures == null || adventures.isEmpty()) 
            throw new NotFoundException();

        return adventures;
    }
 
    @RequestMapping(value = "/adventure/{uuid}", method = RequestMethod.GET)
    public Adventure findById(@PathVariable("uuid") UUID uuid) {
        Adventure adventure = adventureService.getAdventureById(uuid);
        if (adventure == null) 
            throw new NotFoundException();

        return adventure;
    }
 
    @RequestMapping(value = "/adventure", method = RequestMethod.PUT)
    public Adventure update(@RequestBody Adventure adventure) {
        Adventure updated = adventureService.update(adventure);
        if (updated == null) 
            throw new NotFoundException();

        return updated;
    }

}
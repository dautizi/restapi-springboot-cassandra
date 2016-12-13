package com.danieleautizi.restapi.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danieleautizi.restapi.dao.AdventureDAO;
import com.danieleautizi.restapi.model.Adventure;
import com.danieleautizi.restapi.service.AdventureService;

@Service
public class AdventureServiceImpl implements AdventureService {

    @Autowired
    private AdventureDAO adventureDAO;

    public AdventureServiceImpl() {}

    public Adventure create(Adventure adventure) {
        return adventureDAO.create(adventure);
    }

    public Adventure getAdventureById(UUID uuid) {
        return adventureDAO.getAdventureById(uuid);
    }

    public Adventure update(Adventure adventure) {
        return adventureDAO.update(adventure);
    }

    public void delete(UUID uuid) {
        adventureDAO.delete(uuid);
    }

    public List<Adventure> getAllAdventures() {
        return adventureDAO.getAllAdventures();
    }

}
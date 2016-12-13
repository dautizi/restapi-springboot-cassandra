package com.danieleautizi.restapi.dao;

import java.util.List;
import java.util.UUID;

import com.danieleautizi.restapi.model.Adventure;

public interface AdventureDAO {

    public Adventure create(Adventure adventure);

    public Adventure getAdventureById(UUID uuid);

    public Adventure update(Adventure adventure);

    public void delete(UUID uuid);

    public List<Adventure> getAllAdventures();
}

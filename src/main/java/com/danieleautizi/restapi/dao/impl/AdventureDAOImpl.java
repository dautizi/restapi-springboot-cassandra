package com.danieleautizi.restapi.dao.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.danieleautizi.restapi.configuration.CassandraTemplateCustom;
import com.danieleautizi.restapi.dao.AdventureDAO;
import com.danieleautizi.restapi.model.Adventure;

@Repository
public class AdventureDAOImpl implements AdventureDAO {

    @Autowired(required=true)
    private CassandraTemplateCustom cassandraTemplate;

    public Adventure create(Adventure adventure) {
        return cassandraTemplate.create(adventure);
    }

    public Adventure getAdventureById(UUID uuid) {
        return cassandraTemplate.findById(uuid, Adventure.class);
    }

    public Adventure update(Adventure adventure) {
        return cassandraTemplate.update(adventure, Adventure.class);
    }

    public void delete(UUID uuid) {
        cassandraTemplate.deleteById(uuid, Adventure.class);
    }

    public List<Adventure> getAllAdventures() {
        return cassandraTemplate.findAll(Adventure.class);
    }
}
package com.danieleautizi.restapi.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.danieleautizi.restapi.model.Adventure;
import com.danieleautizi.restapi.model.util.AdventureUtil;
import com.danieleautizi.restapi.model.util.RandomFieldUtil;
import com.danieleautizi.restapi.model.util.RandomFieldUtil.TYPE;

@RunWith(SpringJUnit4ClassRunner.class)
@EnableAutoConfiguration
@ComponentScan
@ContextConfiguration
@SpringBootTest({"cassandra.contactpoints=localhost,127.0.0.1","cassandra.port=9042","cassandra.keyspace=daniele_autizi"})
public class AdventureDAOTest extends AdventureUtil {

    @Autowired(required=true)
    private AdventureDAO adventureDAO;

    @Test
    public void createAndDeleteValidAdventure() {
        UUID testAdventureUiid = RandomFieldUtil.getRandomUUID();
        Adventure adventureToCreate = getRandomAdventure(testAdventureUiid, false);
        assertNotNull(adventureToCreate);

        Adventure adventure = adventureDAO.create(adventureToCreate);
        assertNotNull(adventure);
        assertEquals(adventureToCreate.getActive(), adventure.getActive());
        assertEquals(adventureToCreate.getAdventureType(), adventure.getAdventureType());
        assertEquals(adventureToCreate.getAltImage(), adventure.getAltImage());
        assertEquals(adventureToCreate.getArticleUrl(), adventure.getArticleUrl());
        assertEquals(adventureToCreate.getCategory(), adventure.getCategory());
        assertEquals(adventureToCreate.getCssClass(), adventure.getCssClass());
        assertEquals(adventureToCreate.getDatetime(), adventure.getDatetime());
        assertEquals(adventureToCreate.getDescription(), adventure.getDescription());
        assertEquals(adventureToCreate.getIcon(), adventure.getIcon());
        assertEquals(adventureToCreate.getId(), adventure.getId());
        assertEquals(adventureToCreate.getImage(), adventure.getImage());
        assertEquals(adventureToCreate.getKeywords(), adventure.getKeywords());
        assertEquals(adventureToCreate.getMediaCssClass(), adventure.getMediaCssClass());
        assertEquals(adventureToCreate.getPrg(), adventure.getPrg());
        assertEquals(adventureToCreate.getSection(), adventure.getSection());
        assertEquals(adventureToCreate.getStaticUrl(), adventure.getStaticUrl());
        assertEquals(adventureToCreate.getTag(), adventure.getTag());
        assertEquals(adventureToCreate.getTitle(), adventure.getTitle());
        assertEquals(adventureToCreate.getUuid(), adventure.getUuid());
        assertEquals(adventureToCreate.getViewType(), adventure.getViewType());

        // find the adventure
        Adventure adventureCreated = adventureDAO.getAdventureById(testAdventureUiid);
        assertNotNull(adventureCreated);

        // delete the adventure
        adventureDAO.delete(testAdventureUiid);

        // try to get it back again to see if it still exists
        // find the adventure
        Adventure deletedAdventure = adventureDAO.getAdventureById(testAdventureUiid);
        assertNull("The adventure you deleted should be not persistance layer anymore. ", deletedAdventure);
    }

    @Test
    public void createUpdateValidAdventureHasBeenCreated() {
        UUID testAdventureUiid = RandomFieldUtil.getRandomUUID();
        Adventure adventureToCreate = getRandomAdventure(testAdventureUiid, false);
        assertNotNull(adventureToCreate);

        Adventure adventure = adventureDAO.create(adventureToCreate);
        assertNotNull(adventure);
        assertEquals(adventureToCreate.getActive(), adventure.getActive());
        assertEquals(adventureToCreate.getAdventureType(), adventure.getAdventureType());
        assertEquals(adventureToCreate.getAltImage(), adventure.getAltImage());
        assertEquals(adventureToCreate.getArticleUrl(), adventure.getArticleUrl());
        assertEquals(adventureToCreate.getCategory(), adventure.getCategory());
        assertEquals(adventureToCreate.getCssClass(), adventure.getCssClass());
        assertEquals(adventureToCreate.getDatetime(), adventure.getDatetime());
        assertEquals(adventureToCreate.getDescription(), adventure.getDescription());
        assertEquals(adventureToCreate.getIcon(), adventure.getIcon());
        assertEquals(adventureToCreate.getId(), adventure.getId());
        assertEquals(adventureToCreate.getImage(), adventure.getImage());
        assertEquals(adventureToCreate.getKeywords(), adventure.getKeywords());
        assertEquals(adventureToCreate.getMediaCssClass(), adventure.getMediaCssClass());
        assertEquals(adventureToCreate.getPrg(), adventure.getPrg());
        assertEquals(adventureToCreate.getSection(), adventure.getSection());
        assertEquals(adventureToCreate.getStaticUrl(), adventure.getStaticUrl());
        assertEquals(adventureToCreate.getTag(), adventure.getTag());
        assertEquals(adventureToCreate.getTitle(), adventure.getTitle());
        assertEquals(adventureToCreate.getUuid(), adventure.getUuid());
        assertEquals(adventureToCreate.getViewType(), adventure.getViewType());

        // find the adventure
        Adventure adventureToUpdate = adventureDAO.getAdventureById(testAdventureUiid);
        assertNotNull(adventureToUpdate);

        // update the adventure
        TYPE type = RandomFieldUtil.getRandomTypeEnum();
        adventureToUpdate.setAdventureType(type.getText());
        adventureToUpdate.setMediaCssClass(type.getMediaCss());
        Adventure updatedAdventure = adventureDAO.update(adventureToUpdate);

        assertNotNull("The adventure you updated should be not null. ", updatedAdventure);
        assertEquals(type.getText(), updatedAdventure.getAdventureType());
        assertEquals(type.getMediaCss(), updatedAdventure.getMediaCssClass());

        // delete the adventure
        adventureDAO.delete(testAdventureUiid);

        // try to get it back again to see if it still exists
        // find the adventure
        Adventure deletedAdventure = adventureDAO.getAdventureById(testAdventureUiid);
        assertNull("The adventure you deleted should be not persistance layer anymore. ", deletedAdventure);
    }

}
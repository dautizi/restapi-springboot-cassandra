package com.danieleautizi.restapi.controller;

import static org.junit.Assert.*;

import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.danieleautizi.restapi.Application;
import com.danieleautizi.restapi.model.Adventure;
import com.danieleautizi.restapi.model.util.AdventureUtil;
import com.danieleautizi.restapi.model.util.RandomFieldUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(Application.class)
public class AdventureControllerTest {

    private static final String baseUrl = "http://localhost:8089/";
    private static final String adventuresPath = "adventures/";

    private TestRestTemplate restTemplate = new TestRestTemplate();

    @Test
    public void createFindDeleteValidAdventure() throws Exception {
        String wsCreate = baseUrl + adventuresPath + "adventure";
        UUID testAdventureUiid = RandomFieldUtil.getRandomUUID();
        Adventure adventure = AdventureUtil.getRandomAdventure(testAdventureUiid, false);

        ResponseEntity<Adventure> apiResponse = restTemplate.postForEntity(wsCreate, adventure, Adventure.class);
        assertNotNull(apiResponse);

        // find the adventure 
        String wsFind = baseUrl + adventuresPath + "adventure/" + testAdventureUiid;
        ResponseEntity<Adventure> findResponse = restTemplate.getForEntity(wsFind, Adventure.class);
        assertNotNull(findResponse);
        Adventure adventureFound = findResponse.getBody();
        assertNotNull(adventureFound);
        assertEquals(adventure.getActive(), adventureFound.getActive());
        assertEquals(adventure.getAdventureType(), adventureFound.getAdventureType());
        assertEquals(adventure.getAltImage(), adventureFound.getAltImage());
        assertEquals(adventure.getArticleUrl(), adventureFound.getArticleUrl());
        assertEquals(adventure.getCategory(), adventureFound.getCategory());
        assertEquals(adventure.getCssClass(), adventureFound.getCssClass());
        assertEquals(adventure.getDatetime(), adventureFound.getDatetime());
        assertEquals(adventure.getDescription(), adventureFound.getDescription());
        assertEquals(adventure.getIcon(), adventureFound.getIcon());
        assertEquals(adventure.getId(), adventureFound.getId());
        assertEquals(adventure.getImage(), adventureFound.getImage());
        assertEquals(adventure.getKeywords(), adventureFound.getKeywords());
        assertEquals(adventure.getMediaCssClass(), adventureFound.getMediaCssClass());
        assertEquals(adventure.getPrg(), adventureFound.getPrg());
        assertEquals(adventure.getSection(), adventureFound.getSection());
        assertEquals(adventure.getStaticUrl(), adventureFound.getStaticUrl());
        assertEquals(adventure.getTag(), adventureFound.getTag());
        assertEquals(adventure.getTitle(), adventureFound.getTitle());
        assertEquals(adventure.getUuid(), adventureFound.getUuid());
        assertEquals(adventure.getViewType(), adventureFound.getViewType());

        // delete adventure
        String wsDelete = baseUrl + adventuresPath + "adventure/" + testAdventureUiid;
        restTemplate.delete(wsDelete);
    }

    @Test
    public void getAllAdventures() throws Exception {
        String wsToConsume = baseUrl + adventuresPath + "all";
        // first adventure
        UUID firstTestAdventureUiid = RandomFieldUtil.getRandomUUID();
        Adventure firstAdventure = AdventureUtil.getRandomAdventure(firstTestAdventureUiid, 1, false, 101);
        assertNotNull(firstAdventure);

        // second adventure
        UUID secondTestAdventureUiid = RandomFieldUtil.getRandomUUID();
        Adventure secondAdventure = AdventureUtil.getRandomAdventure(secondTestAdventureUiid, 2, false, 102);
        assertNotNull(secondAdventure);

        ResponseEntity<Adventure[]> apiResponse = restTemplate.getForEntity(wsToConsume, Adventure[].class);
        Adventure[] adventures = apiResponse.getBody();
        assertNotNull(apiResponse);
        assertNotNull(adventures);
    }
}

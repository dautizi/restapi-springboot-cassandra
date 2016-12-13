package com.danieleautizi.restapi.model.util;

import java.util.UUID;

import com.danieleautizi.restapi.model.Adventure;
import com.danieleautizi.restapi.model.util.RandomFieldUtil.IMAGE;
import com.danieleautizi.restapi.model.util.RandomFieldUtil.TITLE;
import com.danieleautizi.restapi.model.util.RandomFieldUtil.TYPE;

public class AdventureUtil {

    public static Adventure getRandomAdventure(UUID uuid, boolean active) {
        return getRandomAdventure(uuid, 1, active, 1000);
    }

    public static Adventure getRandomAdventure(UUID uuid, boolean active, long id) {
        return getRandomAdventure(uuid, 1, active, id);
    }

    public static Adventure getRandomAdventure() {
        return getRandomAdventure(RandomFieldUtil.getRandomUUID(), 1, false, 1000);
    }

    public static Adventure getRandomAdventure(UUID uuid, int prg, boolean active, long id) {
        Adventure adventure = new Adventure();
        adventure.setUuid(uuid);
        adventure.setActive(RandomFieldUtil.getState(active));
        adventure.setAdventureType(RandomFieldUtil.getRandomTypeEnum().getText());

        // image
        IMAGE image = RandomFieldUtil.getRandomImageEnum();
        adventure.setAltImage(image.getAlt());
        adventure.setImage(image.getText());

        // title
        TITLE title = RandomFieldUtil.getRandomTitleEnum();
        adventure.setTitle(title.getText());
        adventure.setArticleUrl(title.getUrl());

        adventure.setCategory(RandomFieldUtil.getRandomCategoryEnum().getText());
        adventure.setDatetime(RandomFieldUtil.getFormatToday());
        adventure.setIcon("");
        adventure.setDescription("");
        adventure.setId(id);
        adventure.setKeywords(RandomFieldUtil.getRandomKeywordsEnum().getText());

        // type
        TYPE type = RandomFieldUtil.getRandomTypeEnum();
        adventure.setAdventureType(type.getText());
        adventure.setMediaCssClass(type.getMediaCss());

        adventure.setPrg(prg);
        adventure.setSection(RandomFieldUtil.getRandomSectionEnum().getText());
        adventure.setTag(RandomFieldUtil.getRandomTagEnum().getText());
        adventure.setViewType("");
        adventure.setSection(RandomFieldUtil.getRandomSectionEnum().getText());

        return adventure;
    }
}

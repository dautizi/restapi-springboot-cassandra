package com.danieleautizi.restapi.model.util;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import com.danieleautizi.restapi.util.DateUtil;

public class RandomFieldUtil {

    private static final List<TITLE> TITLES = Collections.unmodifiableList(Arrays.asList(TITLE.values()));
    public enum TITLE {
        FOOD ("Pasta or pizza", "http://local.danieleautizi.com:9090/danieleautizi/adventure/food/pasta_or_pizza-"),
        SPORT ("Football is the most played sport of the world", "http://local.danieleautizi.com:9090/danieleautizi/adventure/sport/football_is_the_most_played_sport_of_the_world-"),
        MUSIC ("Rock can fit all kind of feeling", "http://local.danieleautizi.com:9090/danieleautizi/adventure/music/rock_can_fit_all_kind_of_feeling-"),
        NEWS ("App market increased prices", "http://local.danieleautizi.com:9090/danieleautizi/adventure/news/app_market_increased_prices-"),
        MOVIE ("The best movie ever", "http://local.danieleautizi.com:9090/danieleautizi/adventure/movie/the_best_movie_ever-");

        private String text;
        private String url;

        private TITLE(String text, String url) {
            this.text = text;
            this.url = url;
        }
        public String getUrl() {
            return url;
        }
        public String getText() {
            return text;
        }
    }

    public static TITLE getRandomTitleEnum() {
        int index = new Random().nextInt(TITLES.size());
        TITLE titleEnum = TITLES.get(index);
        return titleEnum;
    }

    private static final List<CATEGORY> CATEGORIES = Collections.unmodifiableList(Arrays.asList(CATEGORY.values()));
    public enum CATEGORY {
        FOOD ("food"),
        SPORT ("sport"),
        MUSIC ("rock"),
        NEWS ("market"),
        MOVIE ("movie");

        private String text;
        private CATEGORY(String text) {
            this.text = text;
        }
        public String getText() {
            return text;
        }
    }

    public static CATEGORY getRandomCategoryEnum() {
        int index = new Random().nextInt(CATEGORIES.size());
        CATEGORY categoryEnum = CATEGORIES.get(index);
        return categoryEnum;
    }

    private static final List<SECTION> SECTIONS = Collections.unmodifiableList(Arrays.asList(SECTION.values()));
    public enum SECTION {
        FOOD ("food"),
        SPORT ("sport"),
        MUSIC ("rock"),
        NEWS ("market"),
        MOVIE ("movie");

        private String text;
        private SECTION(String text) {
            this.text = text;
        }
        public String getText() {
            return text;
        }
    }

    public static SECTION getRandomSectionEnum() {
        int index = new Random().nextInt(SECTIONS.size());
        SECTION sectionEnum = SECTIONS.get(index);
        return sectionEnum;
    }

    private static final List<TAG> TAGS = Collections.unmodifiableList(Arrays.asList(TAG.values()));
    public enum TAG {
        FOOD ("food"),
        SPORT ("sport"),
        MUSIC ("rock"),
        NEWS ("market"),
        MOVIE ("movie");

        private String text;
        private TAG(String text) {
            this.text = text;
        }
        public String getText() {
            return text;
        }
    }

    public static TAG getRandomTagEnum() {
        int index = new Random().nextInt(TAGS.size());
        TAG tagEnum = TAGS.get(index);
        return tagEnum;
    }

    private static final List<KEYWORD> KEYWORDS = Collections.unmodifiableList(Arrays.asList(KEYWORD.values()));
    public enum KEYWORD {
        FOOD ("pasta, pizza, food"),
        SPORT ("football, sport, soccer"),
        MUSIC ("rock, music, pop, art"),
        NEWS ("market, app, mobile app"),
        MOVIE ("movie, al pacino, horror, drama, comedy");

        private String text;
        private KEYWORD(String text) {
            this.text = text;
        }
        public String getText() {
            return text;
        }
    }

    public static KEYWORD getRandomKeywordsEnum() {
        int index = new Random().nextInt(KEYWORDS.size());
        KEYWORD keywordEnum = KEYWORDS.get(index);
        return keywordEnum;
    }

    private static final List<IMAGE> IMAGES = Collections.unmodifiableList(Arrays.asList(IMAGE.values()));
    public enum IMAGE {
        RAFTING ("http://danieleautizi.local/images/pages/adventure/rafting_04-cover.jpg", "Special hotdog at Rafting Marmore"),
        FOOTBALL ("http://danieleautizi.local/images/pages/adventure/asd_monte_san_giovanni-cup1-cover.jpg", "ASD Monte San Giovanni football club"),
        WATERFALL ("http://danieleautizi.local/images/pages/adventure/rafting_02-cover.jpg", "The sound of waterfall"),
        CHINA ("http://danieleautizi.local/images/pages/adventure/china/birds_nest-background-beijing-cover.jpg", "News from Beijing"),
        MOVIE ("http://danieleautizi.local/images/pages/adventure/china/Shanghai-World-Financial-Center-1-cover.jpg", "An old chinese movie");

        private String text;
        private String alt;
        private IMAGE(String text, String alt) {
            this.text = text;
            this.alt = alt;
        }
        public String getText() {
            return text;
        }
        public String getAlt() {
            return alt;
        }
    }

    public static IMAGE getRandomImageEnum() {
        int index = new Random().nextInt(IMAGES.size());
        IMAGE keywordEnum = IMAGES.get(index);
        return keywordEnum;
    }

    private static final List<TYPE> TYPES = Collections.unmodifiableList(Arrays.asList(TYPE.values()));
    public enum TYPE {
        ARTICLE ("article", "article"),
        VIDEO ("video", "ajax"),
        PHOTOGALLERY ("photogallery", "ajax");

        private String text;
        private String mediaCss;
        private TYPE(String text, String mediaCss) {
            this.text = text;
            this.mediaCss = mediaCss;
        }
        public String getText() {
            return text;
        }
        public String getMediaCss() {
            return mediaCss;
        }
    }

    public static TYPE getRandomTypeEnum() {
        int index = new Random().nextInt(TYPES.size());
        TYPE typeEnum = TYPES.get(index);
        return typeEnum;
    }

    public static UUID getRandomUUID() {
        UUID uuid = UUID.randomUUID();
        return uuid;
    }

    public static String getFormatToday() {
        return DateUtil.convertDateToString(new Date(), DateUtil.MYSQL_DB_DATE_PATTERN);
    }

    public static int getState(boolean active) {
        return active ? 1 : 0;
    }

}

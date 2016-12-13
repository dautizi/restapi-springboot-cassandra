package com.danieleautizi.restapi.model;

import java.util.List;
import java.util.UUID;

import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

import com.google.gson.Gson;

@Table("adventure")
public class Adventure {

    @PrimaryKey("adv_uuid")
    private UUID uuid;

    @Column("adv_id")
    private long id;

    @Column("adv_title")
    private String title;

    @Column("adv_category")
    private String category;

    @Column("adv_section")
    private String section;

    @Column("adv_tag")
    private String tag;

    @Column("adv_keywords")
    private String keywords;

    @Column("adv_css_class")
    private String cssClass;

    @Column("adv_image")
    private String image;

    @Column("adv_icon")
    private String icon;

    @Column("adv_alt_image")
    private String altImage;

    @Column("adv_article_url")
    private String articleUrl;

    @Column("adv_static_url")
    private String staticUrl;

    @Column("adv_description")
    private String description;

    @Column("adv_adventure_type")
    private String adventureType;

    @Column("adv_view_type")
    private String viewType;

    @Column("adv_media_css_class")
    private String mediaCssClass;

    @Column("adv_datetime")
    private String datetime;

    @Column("adv_prg")
    private int prg;

    @Column("adv_active")
    private int active;

    public Adventure() {}

    public Adventure(UUID uuid, long id, String title, String category,
            String section, String tag, String keywords, String cssClass,
            String image, String icon, String altImage, String articleUrl,
            String staticUrl, String description, String adventureType,
            String viewType, String mediaCssClass, String datetime, int prg,
            int active) {
        this.uuid = uuid;
        this.id = id;
        this.title = title;
        this.category = category;
        this.section = section;
        this.tag = tag;
        this.keywords = keywords;
        this.cssClass = cssClass;
        this.image = image;
        this.icon = icon;
        this.altImage = altImage;
        this.articleUrl = articleUrl;
        this.staticUrl = staticUrl;
        this.description = description;
        this.adventureType = adventureType;
        this.viewType = viewType;
        this.mediaCssClass = mediaCssClass;
        this.datetime = datetime;
        this.prg = prg;
        this.active = active;
    }

    public String toJson() {
        String json = null;
        if (this != null) {
            Gson gson = new Gson();
            json = gson.toJson(this);
        }
        return json;
    }

    public static String toJson(List<Adventure> adventures) {
        String json = "";
        if (adventures != null && !adventures.isEmpty()) {
            Gson gson = new Gson();
            json = gson.toJson(adventures);
        }
        return json;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getCssClass() {
        return cssClass;
    }

    public void setCssClass(String cssClass) {
        this.cssClass = cssClass;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getAltImage() {
        return altImage;
    }

    public void setAltImage(String altImage) {
        this.altImage = altImage;
    }

    public String getArticleUrl() {
        return articleUrl;
    }

    public void setArticleUrl(String articleUrl) {
        this.articleUrl = articleUrl;
    }

    public String getStaticUrl() {
        return staticUrl;
    }

    public void setStaticUrl(String staticUrl) {
        this.staticUrl = staticUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAdventureType() {
        return adventureType;
    }

    public void setAdventureType(String adventureType) {
        this.adventureType = adventureType;
    }

    public String getViewType() {
        return viewType;
    }

    public void setViewType(String viewType) {
        this.viewType = viewType;
    }

    public String getMediaCssClass() {
        return mediaCssClass;
    }

    public void setMediaCssClass(String mediaCssClass) {
        this.mediaCssClass = mediaCssClass;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public int getPrg() {
        return prg;
    }

    public void setPrg(int prg) {
        this.prg = prg;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Adventure [uuid=" + uuid + ", id=" + id + ", title=" + title
                + ", category=" + category + ", section=" + section + ", tag="
                + tag + ", keywords=" + keywords + ", cssClass=" + cssClass
                + ", image=" + image + ", icon=" + icon + ", altImage="
                + altImage + ", articleUrl=" + articleUrl + ", staticUrl="
                + staticUrl + ", description=" + description
                + ", adventureType=" + adventureType + ", viewType=" + viewType
                + ", mediaCssClass=" + mediaCssClass + ", datetime=" + datetime
                + ", prg=" + prg + ", active=" + active + "]";
    }

}

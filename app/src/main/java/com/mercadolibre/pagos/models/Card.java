/*
 * *
 *  * Created by Ignacio Galliano
 *
 */

package com.mercadolibre.pagos.models;

import com.google.gson.JsonObject;

/**
 * Created By Ignacio Galliano
 */
public class Card extends ItemList {

    private String id;
    private String name;
    private String secure_thumbnail;
    private String thumbnail;
    private String processing_mode;

    public Card(JsonObject obj) {

        if (obj.has("id") && !obj.get("id").isJsonNull()) {
            this.id = obj.get("id").getAsString();
        } else {
            this.id = "";
        }
        if (obj.has("name") && !obj.get("name").isJsonNull()) {
            this.name = obj.get("name").getAsString();
        } else {
            this.name = "";
        }
        if (obj.has("secure_thumbnail") && !obj.get("secure_thumbnail").isJsonNull()) {
            this.secure_thumbnail = obj.get("secure_thumbnail").getAsString();
        } else {
            this.secure_thumbnail = "";
        }
        if (obj.has("thumbnail") && !obj.get("thumbnail").isJsonNull()) {
            this.thumbnail = obj.get("thumbnail").getAsString();
        } else {
            this.thumbnail = "";
        }
        if (obj.has("processing_mode") && !obj.get("processing_mode").isJsonNull()) {
            this.processing_mode = obj.get("processing_mode").getAsString();
        } else {
            this.processing_mode = "";
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecure_thumbnail() {
        return secure_thumbnail;
    }

    public void setSecure_thumbnail(String secure_thumbnail) {
        this.secure_thumbnail = secure_thumbnail;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getProcessing_mode() {
        return processing_mode;
    }

    public void setProcessing_mode(String processing_mode) {
        this.processing_mode = processing_mode;
    }
}

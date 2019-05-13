/*
 * *
 *  * Created by Ignacio Galliano
 *
 */

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
public class Issuer {

    private String id;
    private String name;
    private String secure_thumbnail;
    private String thumbnail;

    public Issuer() {}
    public Issuer(JsonObject obj) {

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
}

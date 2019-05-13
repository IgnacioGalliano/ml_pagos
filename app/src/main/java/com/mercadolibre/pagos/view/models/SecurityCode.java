/*
 * *
 *  * Created by Ignacio Galliano
 *
 */

package com.mercadolibre.pagos.view.models;

import com.google.gson.JsonObject;

/**
 * Created By Ignacio Galliano
 */
public class SecurityCode {

    private String length;
    private String card_location;
    private String mode;

    public SecurityCode(JsonObject obj) {

        if (obj.has("length") && !obj.get("length").isJsonNull()) {
            this.length = obj.get("length").getAsString();
        } else {
            this.length = "";
        }
        if (obj.has("card_location") && !obj.get("card_location").isJsonNull()) {
            this.card_location = obj.get("card_location").getAsString();
        } else {
            this.card_location = "";
        }
        if (obj.has("mode") && !obj.get("mode").isJsonNull()) {
            this.mode = obj.get("mode").getAsString();
        } else {
            this.mode = "";
        }
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getCard_location() {
        return card_location;
    }

    public void setCard_location(String card_location) {
        this.card_location = card_location;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }
}

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
public class CardNumber {
    private String validation;
    private int length;

    public CardNumber(JsonObject obj) {

        if (obj.has("validation") && !obj.get("validation").isJsonNull()) {
            this.validation = obj.get("validation").getAsString();
        } else {
            this.validation = "";
        }
        if (obj.has("length") && !obj.get("length").isJsonNull()) {
            this.length = obj.get("length").getAsInt();
        } else {
            this.length = 0;
        }
    }

    public String getValidation() {
        return validation;
    }

    public void setValidation(String validation) {
        this.validation = validation;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}

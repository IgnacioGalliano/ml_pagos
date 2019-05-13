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
public class Bin {

    private String pattern;
    private String installments_pattern;
    private String exclusion_pattern;

    public Bin(JsonObject obj) {

        if (obj.has("pattern") && !obj.get("pattern").isJsonNull()) {
            this.pattern = obj.get("pattern").getAsString();
        } else {
            this.pattern = "";
        }
        if (obj.has("installments_pattern") && !obj.get("installments_pattern").isJsonNull()) {
            this.installments_pattern = obj.get("installments_pattern").getAsString();
        } else {
            this.installments_pattern = "";
        }
        if (obj.has("exclusion_pattern") && !obj.get("exclusion_pattern").isJsonNull()) {
            this.exclusion_pattern = obj.get("exclusion_pattern").getAsString();
        } else {
            this.exclusion_pattern = "";
        }
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public String getInstallments_pattern() {
        return installments_pattern;
    }

    public void setInstallments_pattern(String installments_pattern) {
        this.installments_pattern = installments_pattern;
    }

    public String getExclusion_pattern() {
        return exclusion_pattern;
    }

    public void setExclusion_pattern(String exclusion_pattern) {
        this.exclusion_pattern = exclusion_pattern;
    }
}

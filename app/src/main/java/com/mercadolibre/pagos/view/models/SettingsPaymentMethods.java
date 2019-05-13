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
public class SettingsPaymentMethods {

    private CardNumber cardNumber;
    private Bin bin;
    private SecurityCode securityCode;

    public SettingsPaymentMethods(JsonObject obj) {

        if (obj.has("card_number") && !obj.get("card_number").isJsonNull()) {
            this.cardNumber = new CardNumber(obj.get("card_number").getAsJsonObject());
        } else {

        }
        if (obj.has("bin") && !obj.get("bin").isJsonNull()) {
            this.bin = new Bin(obj.get("bin").getAsJsonObject());
        } else {

        }
        if (obj.has("security_code") && !obj.get("security_code").isJsonNull()) {
            this.securityCode = new SecurityCode(obj.get("security_code").getAsJsonObject());
        } else {

        }
    }

    public CardNumber getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(CardNumber cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Bin getBin() {
        return bin;
    }

    public void setBin(Bin bin) {
        this.bin = bin;
    }

    public SecurityCode getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(SecurityCode securityCode) {
        this.securityCode = securityCode;
    }
}

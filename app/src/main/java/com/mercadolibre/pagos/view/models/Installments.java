/*
 * *
 *  * Created by Ignacio Galliano
 *
 */

package com.mercadolibre.pagos.view.models;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;

/**
 * Created By Ignacio Galliano
 */
public class Installments extends ItemList {

    private String paymentMethodId;
    private String paymentTypeId;
    private Issuer issuer;
    private String processingMode;
//    private String merchant_account_id;
    private ArrayList<ItemList> arrayPayerCosts;
//    private String agreements;

    public Installments(JsonObject obj) {

        if (obj.has("payment_method_id") && !obj.get("payment_method_id").isJsonNull()) {
            this.paymentMethodId = obj.get("payment_method_id").getAsString();
        } else {
            this.paymentMethodId = "";
        }
        if (obj.has("payment_type_id") && !obj.get("payment_type_id").isJsonNull()) {
            this.paymentTypeId = obj.get("payment_type_id").getAsString();
        } else {
            this.paymentTypeId = "";
        }
        if (obj.has("issuer") && !obj.get("issuer").isJsonNull()) {
            this.issuer = new Issuer(obj.get("issuer").getAsJsonObject());
        } else {
            this.issuer = new Issuer();
        }
        if (obj.has("payer_costs") && !obj.get("payer_costs").isJsonNull()) {
            arrayPayerCosts = new ArrayList<>();
            JsonArray arraySettings = obj.get("payer_costs").getAsJsonArray();

            for(int i = 0; i<arraySettings.size(); i++){
                JsonObject payerC = arraySettings.get(i).getAsJsonObject();
                PayerCost payerCost = new PayerCost(payerC);
                arrayPayerCosts.add(payerCost);
            }
        } else {
            this.arrayPayerCosts = new ArrayList<>();
        }

    }

    public String getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(String paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    public String getPaymentTypeId() {
        return paymentTypeId;
    }

    public void setPaymentTypeId(String paymentTypeId) {
        this.paymentTypeId = paymentTypeId;
    }

    public Issuer getIssuer() {
        return issuer;
    }

    public void setIssuer(Issuer issuer) {
        this.issuer = issuer;
    }

    public String getProcessingMode() {
        return processingMode;
    }

    public void setProcessingMode(String processingMode) {
        this.processingMode = processingMode;
    }

    public ArrayList<ItemList> getArrayPayerCosts() {
        return arrayPayerCosts;
    }

    public void setArrayPayerCosts(ArrayList<ItemList> arrayPayerCosts) {
        this.arrayPayerCosts = arrayPayerCosts;
    }
}

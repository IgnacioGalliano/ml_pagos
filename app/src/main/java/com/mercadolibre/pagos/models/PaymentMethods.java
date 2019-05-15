/*
 * *
 *  * Created by Ignacio Galliano
 *
 */

package com.mercadolibre.pagos.models;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created By Ignacio Galliano
 */
public class PaymentMethods extends ItemList {

    private String id;
    private String name;
    private String payment_type_id;
    private String status;
    private String secure_thumbnail;
    private String thumbnail;
    private String deferred_capture;
    private ArrayList<SettingsPaymentMethods>  settingsArray;
    private ArrayList<String> additionalInfoNeeded;
    private Double min_allowed_amount;
    private Double max_allowed_amount;
    private String accreditation_time;
    private ArrayList<String> financialInstitutions;
    private String processing_modes;

    public PaymentMethods(){}

    public PaymentMethods(JsonObject obj){

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

        if (obj.has("payment_type_id") && !obj.get("payment_type_id").isJsonNull()) {
            this.payment_type_id = obj.get("payment_type_id").getAsString();
        } else {
            this.payment_type_id = null;
        }

        if (obj.has("status") && !obj.get("status").isJsonNull()) {
            this.status = obj.get("status").getAsString();
        } else {
            this.status = null;
        }

        if (obj.has("secure_thumbnail") && !obj.get("secure_thumbnail").isJsonNull()) {
            this.secure_thumbnail = obj.get("secure_thumbnail").getAsString();
        } else {
            this.secure_thumbnail = null;
        }

        if (obj.has("thumbnail") && !obj.get("thumbnail").isJsonNull()) {
            this.thumbnail = obj.get("thumbnail").getAsString();
        } else {
            this.thumbnail = null;
        }

        if (obj.has("deferred_capture") && !obj.get("deferred_capture").isJsonNull()) {
            this.deferred_capture = obj.get("deferred_capture").getAsString();
        } else {
            this.deferred_capture = null;
        }

        if (obj.has("min_allowed_amount") && !obj.get("min_allowed_amount").isJsonNull()) {
            this.min_allowed_amount = obj.get("min_allowed_amount").getAsDouble();
        } else {
            this.min_allowed_amount = null;
        }

        if (obj.has("max_allowed_amount") && !obj.get("max_allowed_amount").isJsonNull()) {
            this.min_allowed_amount = obj.get("max_allowed_amount").getAsDouble();
        } else {
            this.min_allowed_amount = null;
        }

        if (obj.has("accreditation_time") && !obj.get("accreditation_time").isJsonNull()) {
            this.accreditation_time = obj.get("accreditation_time").getAsString();
        } else {
            this.accreditation_time = null;
        }

        if (obj.has("processing_modes") && !obj.get("processing_modes").isJsonNull()) {
            this.processing_modes = obj.get("processing_modes").getAsString();
        } else {
            this.processing_modes = null;
        }

        if (obj.has("additional_info_needed") && !obj.get("additional_info_needed").isJsonNull()) {
            JsonArray array = obj.get("additional_info_needed").getAsJsonArray();
            additionalInfoNeeded =  new ArrayList<>();
            for(int i = 0; i < array.size(); i++){
                additionalInfoNeeded.add(array.get(i).getAsString());
            }
        } else {
            this.additionalInfoNeeded = new ArrayList<>();
        }

        if (obj.has("financial_institutions") && !obj.get("financial_institutions").isJsonNull()) {
            JsonArray array = obj.get("financial_institutions").getAsJsonArray();
            financialInstitutions =  new ArrayList<>();
            for(int i = 0; i < array.size(); i++){
                financialInstitutions.add(array.get(i).getAsString());
            }
        } else {
            this.financialInstitutions = new ArrayList<>();
        }


        if (obj.has("settings") && !obj.get("settings").isJsonNull()) {
            settingsArray = new ArrayList<>();
            JsonArray arraySettings = obj.get("settings").getAsJsonArray();

            for(int i = 0; i<arraySettings.size(); i++){
                JsonObject settingPM = arraySettings.get(i).getAsJsonObject();
                SettingsPaymentMethods settingPMJson = new SettingsPaymentMethods(settingPM);
                settingsArray.add(settingPMJson);
            }

        }else {
            this.settingsArray = new ArrayList<>();
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

    public String getPayment_type_id() {
        return payment_type_id;
    }

    public void setPayment_type_id(String payment_type_id) {
        this.payment_type_id = payment_type_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getDeferred_capture() {
        return deferred_capture;
    }

    public void setDeferred_capture(String deferred_capture) {
        this.deferred_capture = deferred_capture;
    }

    public Double getMin_allowed_amount() {
        return min_allowed_amount;
    }

    public void setMin_allowed_amount(Double min_allowed_amount) {
        this.min_allowed_amount = min_allowed_amount;
    }

    public Double getMax_allowed_amount() {
        return max_allowed_amount;
    }

    public void setMax_allowed_amount(Double max_allowed_amount) {
        this.max_allowed_amount = max_allowed_amount;
    }

    public String getAccreditation_time() {
        return accreditation_time;
    }

    public void setAccreditation_time(String accreditation_time) {
        this.accreditation_time = accreditation_time;
    }

    public String getProcessing_modes() {
        return processing_modes;
    }

    public void setProcessing_modes(String processing_modes) {
        this.processing_modes = processing_modes;
    }

    public ArrayList<SettingsPaymentMethods> getSettingsArray() {
        return settingsArray;
    }

    public void setSettingsArray(ArrayList<SettingsPaymentMethods> settingsArray) {
        this.settingsArray = settingsArray;
    }
}

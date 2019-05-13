/*
 * *
 *  * Created by Ignacio Galliano
 *
 */

package com.mercadolibre.pagos.models;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;

/**
 * Created By Ignacio Galliano
 */
public class PayerCost extends ItemList {
    private Double installments;
    private Double installmentRate;
    private Double discountRate;
    private Double reimbursementRate;
    private ArrayList<String> labels= new ArrayList<>();
    private ArrayList<String> installmentRateCollector= new ArrayList<>();
    private Double min_allowedAmount;
    private Double max_allowedAmount;
    private String recommendedMessage;
    private Double installmentAmount;
    private Double totalAmount;


    public PayerCost(JsonObject obj) {

        if (obj.has("installments") && !obj.get("installments").isJsonNull()) {
            this.installments = obj.get("installments").getAsDouble();
        } else {
            this.installments = 0.0;
        }
        if (obj.has("installment_rate") && !obj.get("installment_rate").isJsonNull()) {
            this.installmentRate = obj.get("installment_rate").getAsDouble();
        } else {
            this.installmentRate = 0.0;
        }
        if (obj.has("discount_rate") && !obj.get("discount_rate").isJsonNull()) {
            this.discountRate = obj.get("discount_rate").getAsDouble();
        } else {
            this.discountRate = 0.0;
        }
        if (obj.has("reimbursement_rate") && !obj.get("reimbursement_rate").isJsonNull()) {
            this.reimbursementRate = obj.get("reimbursement_rate").getAsDouble();
        } else {
            this.reimbursementRate = 0.0;
        }
        if (obj.has("min_allowed_amount") && !obj.get("min_allowed_amount").isJsonNull()) {
            this.min_allowedAmount = obj.get("min_allowed_amount").getAsDouble();
        } else {
            this.min_allowedAmount = 0.0;
        }
        if (obj.has("max_allowed_amount") && !obj.get("max_allowed_amount").isJsonNull()) {
            this.max_allowedAmount = obj.get("max_allowed_amount").getAsDouble();
        } else {
            this.max_allowedAmount = 0.0;
        }
        if (obj.has("installment_amount") && !obj.get("installment_amount").isJsonNull()) {
            this.installmentAmount = obj.get("installment_amount").getAsDouble();
        } else {
            this.installmentAmount = 0.0;
        }
        if (obj.has("total_amount") && !obj.get("total_amount").isJsonNull()) {
            this.totalAmount = obj.get("total_amount").getAsDouble();
        } else {
            this.totalAmount = 0.0;
        }
        if (obj.has("recommended_message") && !obj.get("recommended_message").isJsonNull()) {
            this.recommendedMessage = obj.get("recommended_message").getAsString();
        } else {
            this.recommendedMessage = "";
        }
        if (obj.has("total_amount") && !obj.get("total_amount").isJsonNull()) {
            this.totalAmount = obj.get("total_amount").getAsDouble();
        } else {
            this.totalAmount = 0.0;
        }
        if (obj.has("installment_rate_collector") && !obj.get("installment_rate_collector").isJsonNull()) {
            JsonArray array = obj.get("installment_rate_collector").getAsJsonArray();
            for(int i = 0; i<array.size(); i++){
                String word = array.get(i).getAsString();
                installmentRateCollector.add(word);
            }
        } else {
            this.installmentRateCollector = new ArrayList<>();
        }
        if (obj.has("labels") && !obj.get("labels").isJsonNull()) {
            JsonArray array = obj.get("labels").getAsJsonArray();
            for(int i = 0; i<array.size(); i++){
                String word = array.get(i).getAsString();
                labels.add(word);
            }
        } else {
            this.labels = new ArrayList<>();
        }
    }

    public Double getInstallments() {
        return installments;
    }

    public void setInstallments(Double installments) {
        this.installments = installments;
    }

    public Double getInstallmentRate() {
        return installmentRate;
    }

    public void setInstallmentRate(Double installmentRate) {
        this.installmentRate = installmentRate;
    }

    public Double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(Double discountRate) {
        this.discountRate = discountRate;
    }

    public Double getReimbursementRate() {
        return reimbursementRate;
    }

    public void setReimbursementRate(Double reimbursementRate) {
        this.reimbursementRate = reimbursementRate;
    }

    public ArrayList<String> getLabels() {
        return labels;
    }

    public void setLabels(ArrayList<String> labels) {
        this.labels = labels;
    }

    public ArrayList<String> getInstallmentRateCollector() {
        return installmentRateCollector;
    }

    public void setInstallmentRateCollector(ArrayList<String> installmentRateCollector) {
        this.installmentRateCollector = installmentRateCollector;
    }

    public Double getMin_allowedAmount() {
        return min_allowedAmount;
    }

    public void setMin_allowedAmount(Double min_allowedAmount) {
        this.min_allowedAmount = min_allowedAmount;
    }

    public Double getMax_allowedAmount() {
        return max_allowedAmount;
    }

    public void setMax_allowedAmount(Double max_allowedAmount) {
        this.max_allowedAmount = max_allowedAmount;
    }

    public String getRecommendedMessage() {
        return recommendedMessage;
    }

    public void setRecommendedMessage(String recommendedMessage) {
        this.recommendedMessage = recommendedMessage;
    }

    public Double getInstallmentAmount() {
        return installmentAmount;
    }

    public void setInstallmentAmount(Double installmentAmount) {
        this.installmentAmount = installmentAmount;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }
}

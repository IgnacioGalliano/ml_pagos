/*
 * *
 *  * Created by Ignacio Galliano
 *
 */

package com.mercadolibre.pagos.view.interfaces;

import com.mercadolibre.pagos.view.models.Card;
import com.mercadolibre.pagos.view.models.Installments;
import com.mercadolibre.pagos.view.models.PayerCost;
import com.mercadolibre.pagos.view.models.PaymentMethods;

/**
 * Created By Ignacio Galliano
 */
public interface DataComunication {
    public int getStateListSelect();
    public void setStateListSelect(int i);
    public PaymentMethods getPaymentMethosSelected();
    public void setPaymentMethosSelected(PaymentMethods paymentMethods);
    public Card getCardSelected();
    public void setCardSelected(Card paymentMethods);
    public String getAmount();
    public void setAmount(String amount);
    public PayerCost getPayerCost();
    public void setPayerCost(PayerCost payerCost);
}
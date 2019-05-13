package com.mercadolibre.pagos.net;

/*
 * *
 *  * Created by Ignacio Galliano
 *
 */

public class Connector {

    public static String BASE_URL = "https://api.mercadopago.com/";
    public static String PUBLIC_KEY = "444a9ef5-8a6b-429f-abdf-587639155d88";


    public static String getPaymentMethods(){
        return  BASE_URL + "v1/payment_methods?public_key=" + PUBLIC_KEY;
    }

    public static String getCards(String payment_method_id){
        return  BASE_URL + "v1/payment_methods/card_issuers?public_key=" + PUBLIC_KEY + "&payment_method_id=" + payment_method_id;
    }

    public static String getInstallments(String payment_method_id, String amount, String issuerId){
        return  BASE_URL + "v1/payment_methods/installments?public_key=" + PUBLIC_KEY + "&payment_method_id=" + payment_method_id + "&amount=" + amount + "&issuer.id=" + issuerId;
    }

}

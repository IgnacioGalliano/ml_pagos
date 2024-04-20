/*
 * *
 *  * Created by Ignacio Galliano
 *
 */

package com.mercadolibre.pagos.view.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;
import com.koushikdutta.ion.Response;
import com.mercadolibre.pagos.R;
import com.mercadolibre.pagos.net.Connector;
import com.mercadolibre.pagos.view.MainActivity;
import com.mercadolibre.pagos.view.adapters.SelectListAdapter;
import com.mercadolibre.pagos.view.interfaces.DataComunication;
import com.mercadolibre.pagos.view.interfaces.ListSelectedCallListener;
import com.mercadolibre.pagos.models.Card;
import com.mercadolibre.pagos.models.Installments;
import com.mercadolibre.pagos.models.ItemList;
import com.mercadolibre.pagos.models.PayerCost;
import com.mercadolibre.pagos.models.PaymentMethods;

import java.util.ArrayList;

/**
 * Created By Ignacio Galliano
 */
public class SelectListFragment extends Fragment implements ListSelectedCallListener {

    public MainActivity activity = new MainActivity();
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    DataComunication mCallback;

    private ArrayList<ItemList> arrayList = new ArrayList<>();

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_select_list, container, false);
        mCallback = (DataComunication) getContext();
        recyclerView = (RecyclerView) view.findViewById(R.id.my_recycler_view);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        initListeners();

        return view;
    }

    public void initListeners(){

        switch (mCallback.getStateListSelect()){
            case 1:
                getPaymentMethods();
                break;
            case 2:
                getCards();
                break;
            case 3:
                getInstallmentsMethods();
                break;
        }


    }

    public void getPaymentMethods(){
        activity.showProgress();
        Ion.with(this)
                .load("GET", Connector.getPaymentMethods())
                .asJsonArray()
                .withResponse()
                .setCallback(new FutureCallback<Response<JsonArray>>() {
                    @Override
                    public void onCompleted(Exception e, com.koushikdutta.ion.Response<JsonArray> result) {


                        if(result != null && result.getHeaders().code() < 300) {
                            arrayList = new ArrayList<>();
                            for(int i=0; i<result.getResult().size() ; i++) {
                                JsonObject paymentMethodJson = result.getResult().get(i).getAsJsonObject();
                                PaymentMethods paymentMethod = new PaymentMethods(paymentMethodJson);
                                arrayList.add(paymentMethod);
                            }
                            activity.dismissProgress();


                            mAdapter = new SelectListAdapter( getContext(), SelectListFragment.this, arrayList);
                            recyclerView.setAdapter(mAdapter);
                            mAdapter.notifyDataSetChanged();


                        }else{
                            activity.dismissProgress();
                        }
                    }
                });
    }

    public void getCards(){
        activity.showProgress();
        Ion.with(this)
                .load("GET", Connector.getCards(mCallback.getPaymentMethosSelected().getId()))
                .asJsonArray()
                .withResponse()
                .setCallback(new FutureCallback<Response<JsonArray>>() {
                    @Override
                    public void onCompleted(Exception e, com.koushikdutta.ion.Response<JsonArray> result) {


                        if(result != null && result.getHeaders().code() < 300) {
                            arrayList = new ArrayList<>();
                            for(int i=0; i<result.getResult().size() ; i++) {
                                JsonObject paymentMethodJson = result.getResult().get(i).getAsJsonObject();
                                Card card = new Card(paymentMethodJson);
                                arrayList.add(card);
                            }
                            activity.dismissProgress();


                            mAdapter = new SelectListAdapter( getContext(), SelectListFragment.this, arrayList);
                            recyclerView.setAdapter(mAdapter);
                            mAdapter.notifyDataSetChanged();

                            if(arrayList.isEmpty()){
                                activity.showAlert("Atencion!","Parece que este metodo de pago no contiene ninguna tarjeta!", true);
                            }

                        }else{
                            activity.dismissProgress();
                        }
                    }
                });
    }

    public void getInstallmentsMethods(){
        activity.showProgress();
        Ion.with(this)
                .load("GET", Connector.getInstallments(mCallback.getPaymentMethosSelected().getId(), mCallback.getAmount(), mCallback.getCardSelected().getId()))
                .asJsonArray()
                .withResponse()
                .setCallback(new FutureCallback<Response<JsonArray>>() {
                    @Override
                    public void onCompleted(Exception e, com.koushikdutta.ion.Response<JsonArray> result) {


                        if(result != null && result.getHeaders().code() < 300) {
                            arrayList = new ArrayList<>();

                            JsonObject paymentMethodJson = result.getResult().get(0).getAsJsonObject();
                            Installments installments = new Installments(paymentMethodJson);

                            arrayList = installments.getArrayPayerCosts();

                            mAdapter = new SelectListAdapter( getContext(), SelectListFragment.this, installments.getArrayPayerCosts());
                            recyclerView.setAdapter(mAdapter);
                            mAdapter.notifyDataSetChanged();

                            activity.dismissProgress();


                        }else{
                            activity.dismissProgress();
                        }
                    }
                });
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MainActivity){
            activity = (MainActivity) context;
        }
    }


    @Override
    public void cellPressed(ItemList item) {
        if(item instanceof PaymentMethods){
            mCallback.setPaymentMethosSelected((PaymentMethods) item);
            mCallback.setCardSelected(null);
            mCallback.setPayerCost(null);
        }
        if(item instanceof Card){
            mCallback.setCardSelected((Card) item);
            mCallback.setPayerCost(null);
        }
        if(item instanceof PayerCost){
            mCallback.setPayerCost((PayerCost) item);
        }
        getActivity().onBackPressed();
    }
}

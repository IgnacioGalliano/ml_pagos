package com.mercadolibre.pagos.view.fragments;
/*
 * *
 *  * Created by Ignacio Galliano
 *
 */


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mercadolibre.pagos.R;
import com.mercadolibre.pagos.view.MainActivity;
import com.mercadolibre.pagos.view.interfaces.DataComunication;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created By Ignacio Galliano
 */
public class SelectPaymentMethodFragment extends Fragment {

    DataComunication mCallback;

    public MainActivity activity = new MainActivity();
    private FrameLayout selectPaymentMethodsButton;
    private RelativeLayout siguienteButtonSPM;
    private TextView textPaymentMethodSelected;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_select_payment_methods, container, false);
        ButterKnife.bind(this, view);
        mCallback = (DataComunication) getContext();

        selectPaymentMethodsButton = (FrameLayout) view.findViewById(R.id.selectPaymentMethodsButton);
        siguienteButtonSPM = (RelativeLayout) view.findViewById(R.id.siguienteButtonSPM);
        textPaymentMethodSelected = (TextView) view.findViewById(R.id.textPaymentMethodSelected);

        initListeners();


        return view;
    }

    public void initListeners(){

        siguienteButtonSPM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mCallback.getPaymentMethosSelected() != null){
                    activity.switchContent( new SelectCardFragment(), true);
                }else{
                    activity.showAlert("Atención!","Por favor selecciona un medio de pago.", false);
                }

            }
        });


        selectPaymentMethodsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCallback.setStateListSelect(1);
                activity.switchContent( new SelectListFragment(), true);
            }
        });

        if(mCallback.getPaymentMethosSelected() != null){
            textPaymentMethodSelected.setText(mCallback.getPaymentMethosSelected().getName());
        }

    }



    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MainActivity){
            activity = (MainActivity) context;
        }
    }

}

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
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
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
public class AmountFragment extends Fragment {

    DataComunication mCallback;
    public MainActivity activity = new MainActivity();

    @BindView(R.id.siguienteButton) RelativeLayout siguienteButton;
    @BindView(R.id.amount) EditText amountText;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_amount, container, false);
        ButterKnife.bind(this, view);
        mCallback = (DataComunication) getContext();


        initListeners();

        return view;
    }

    public void initListeners(){

        siguienteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonPress();
            }
        });


        amountText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable text) {
                try {
                    Double a = Double.valueOf(text.toString());
                }catch (Exception e){
                    text.toString().replaceAll(".","");

                }

            }
        });
    }

    public void buttonPress(){
        if(!amountText.getText().toString().equals("")){
            mCallback.setAmount(amountText.getText().toString());
            activity.switchContent( new SelectPaymentMethodFragment(), true);
        }else{
            activity.showAlert("Atención!","Por favor rellena el campo con un monto.", false);
        }
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MainActivity){
            activity = (MainActivity) context;
        }
    }

}

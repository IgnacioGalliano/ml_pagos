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
public class SelectInstallmentFragment extends Fragment {

    DataComunication mCallback;

    public MainActivity activity = new MainActivity();
    @BindView(R.id.siguienteButtonInstallment)
    RelativeLayout siguienteButton;
    @BindView(R.id.selectInstallmentButton)
    FrameLayout selectInstallmentButton;
    @BindView(R.id.textInstallment)
    TextView textInstallment;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_select_installment, container, false);
        ButterKnife.bind(this, view);
        mCallback = (DataComunication) getContext();

        initListeners();


        return view;
    }

    public void initListeners(){

        siguienteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mCallback.getPayerCost() != null){
                    activity.showAlert("¡Has Finalizado!", "Monto: "+ mCallback.getAmount() + "\n Medio de pago : " + mCallback.getPaymentMethosSelected().getId() + "\n Tarjeta: " + mCallback.getCardSelected().getName() + "\n Cuotas: " + mCallback.getPayerCost().getRecommendedMessage());
                    mCallback.setAmount(null);
                    mCallback.setPayerCost(null);
                    mCallback.setCardSelected(null);
                    mCallback.setPaymentMethosSelected(null);
                    activity.switchContent( new AmountFragment(), false);
                }else{
                    activity.showAlert("Atención!","Por favor selecciona la cantidad de cuotas.");
                }

            }
        });

        selectInstallmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCallback.setStateListSelect(3);
                activity.switchContent( new SelectListFragment(), true);
            }
        });

        if(mCallback.getPayerCost() != null){
            textInstallment.setText(mCallback.getPayerCost().getRecommendedMessage());
        }

    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MainActivity){
            activity = (MainActivity) context;
        }
    }

}

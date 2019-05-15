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
 * Create By Ignacio Galliano
 */
public class SelectCardFragment extends Fragment {

    DataComunication mCallback;

    public MainActivity activity = new MainActivity();
    @BindView(R.id.siguienteButtonSC) RelativeLayout siguienteButton;
    @BindView(R.id.selectCardButton) FrameLayout selectCardButton;
    @BindView(R.id.textCardSelected) TextView textCardSelected;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_select_card, container, false);
        ButterKnife.bind(this, view);
        mCallback = (DataComunication) getContext();

        initListeners();


        return view;
    }

    public void initListeners(){

        siguienteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mCallback.getCardSelected() != null){
                    activity.switchContent( new SelectInstallmentFragment(), true);
                }else{
                    activity.showAlert("Atención!","Por favor selecciona una tarjeta.", false);
                }

            }
        });

        selectCardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCallback.setStateListSelect(2);
                activity.switchContent( new SelectListFragment(), true);
            }
        });

        if(mCallback.getCardSelected() != null){
            textCardSelected.setText(mCallback.getCardSelected().getName());
        }

    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MainActivity){
            activity = (MainActivity) context;
        }
    }

}

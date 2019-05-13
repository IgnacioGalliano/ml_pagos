package com.mercadolibre.pagos.view;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.mercadolibre.pagos.R;
import com.mercadolibre.pagos.view.fragments.AmountFragment;
import com.mercadolibre.pagos.view.interfaces.DataComunication;
import com.mercadolibre.pagos.view.models.Card;
import com.mercadolibre.pagos.view.models.Installments;
import com.mercadolibre.pagos.view.models.PayerCost;
import com.mercadolibre.pagos.view.models.PaymentMethods;

import cc.cloudist.acplibrary.ACProgressConstant;
import cc.cloudist.acplibrary.ACProgressFlower;

/**
 * Created By Ignacio Galliano
 */
public class MainActivity extends AppCompatActivity implements DataComunication {


    private ACProgressFlower dialog;

    //stateListSelect= 1 from SelectPaymentMethodFragment
    //                 2 from SelectCardFragment
    //                 3 from SelectInstallmentFragment
    private int stateListSelect;
    private PaymentMethods paymentMethosSelected;
    private Card cardSelected;
    private String amount;
    private PayerCost payerCost;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        switchContent(new AmountFragment(), false);

    }



    public void switchContent(Fragment fragment, boolean hasToAddToStack) {

        try {
            if (fragment != null && !fragment.isDetached()) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();



                if (hasToAddToStack)
                    transaction.setCustomAnimations(R.anim.push_left_in, R.anim.push_left_out, R.anim.push_right_in, R.anim.push_right_out);
                transaction.replace(R.id.container, fragment);
                if (hasToAddToStack) transaction.addToBackStack("back");
                else {
                    FragmentManager fm = getSupportFragmentManager();
                    for (int i = 0; i < fm.getBackStackEntryCount(); ++i) {
                        fm.popBackStack();
                    }
                }
                transaction.commit();

            }

        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    public void showAlert(String titleAlert, String message) {


        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View convertView = (View) inflater.inflate(R.layout.alert_ml, null);
        Button noButton = (Button) convertView.findViewById(R.id.alertQuitNoId);
        noButton.setVisibility(View.VISIBLE);
        TextView title = convertView.findViewById(R.id.alertTitleId);
        title.setText(titleAlert);
        TextView mensaje = convertView.findViewById(R.id.alertTextId);
        mensaje.setText(message);
        alertDialog.setView(convertView);
        final AlertDialog alert = alertDialog.show();
        noButton.setText("OK");
        noButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alert.dismiss();
            }
        });
        alert.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialogInterface) {
                alert.dismiss();
            }
        });
    }


    public void showProgress() {
        if (dialog == null)
        {
            dialog = new ACProgressFlower.Builder(MainActivity.this).direction(ACProgressConstant.DIRECT_CLOCKWISE).themeColor(Color.WHITE).fadeColor(Color.DKGRAY).build();
            dialog.show();
        }
    }

    public void dismissProgress() {
        if (dialog != null && dialog.isShowing())
        {
            dialog.dismiss();
            dialog = null;
        }
    }


    public int getStateListSelect() {
        return stateListSelect;
    }

    public void setStateListSelect(int stateListSelect) {
        this.stateListSelect = stateListSelect;
    }

    public PaymentMethods getPaymentMethosSelected() {
        return paymentMethosSelected;
    }

    public void setPaymentMethosSelected(PaymentMethods paymentMethosSelected) {
        this.paymentMethosSelected = paymentMethosSelected;
    }

    public Card getCardSelected() {
        return cardSelected;
    }

    public void setCardSelected(Card cardSelected) {
        this.cardSelected = cardSelected;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public PayerCost getPayerCost() {
        return payerCost;
    }

    public void setPayerCost(PayerCost payerCost) {
        this.payerCost = payerCost;
    }
}

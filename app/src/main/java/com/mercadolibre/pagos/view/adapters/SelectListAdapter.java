package com.mercadolibre.pagos.view.adapters;

/*
 * *
 *  * Created by Ignacio Galliano
 *
 */


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.mercadolibre.pagos.R;
import com.mercadolibre.pagos.view.interfaces.ListSelectedCallListener;
import com.mercadolibre.pagos.models.Card;
import com.mercadolibre.pagos.models.Installments;
import com.mercadolibre.pagos.models.ItemList;
import com.mercadolibre.pagos.models.PayerCost;
import com.mercadolibre.pagos.models.PaymentMethods;

import java.util.ArrayList;


public class SelectListAdapter extends RecyclerView.Adapter<SelectListAdapter.MyViewHolder> {


    private Context context;
    private TextView fieldText;
    private ImageView imageCell;
    private LinearLayout cellList;
    private  ListSelectedCallListener lscl;

    private ArrayList<ItemList> array;


    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public LinearLayout cellView;
        public MyViewHolder(LinearLayout v) {
            super(v);
            cellView = v;
        }
    }


    public SelectListAdapter(Context context,ListSelectedCallListener lscl, ArrayList<ItemList> array) {
        this.context = context;
        this.array = array;
        this.lscl = lscl;
    }


    @Override
    public SelectListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_list, parent, false);


        fieldText = (TextView) v.findViewById(R.id.textField);
        imageCell = (ImageView) v.findViewById(R.id.imageCell);
        cellList = (LinearLayout) v.findViewById(R.id.cellList);
        context = v.getContext();


        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder,final int position) {
        PaymentMethods paymentMethods = new PaymentMethods();
        if(array.get(position) instanceof PaymentMethods){
            PaymentMethods pm = (PaymentMethods) array.get(position);

            fieldText.setText(pm.getName());

            RequestOptions requestOptions = new RequestOptions()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .placeholder(R.drawable.noimage)
                    .dontAnimate();

            Glide.with(context)
                    .load(pm.getSecure_thumbnail())
                    .apply(requestOptions)
                    .into(imageCell);
        }else if(array.get(position) instanceof Card){

            Card card = (Card) array.get(position);

            fieldText.setText(card.getName());

            RequestOptions requestOptions = new RequestOptions()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .placeholder(R.drawable.noimage)
                    .dontAnimate();

            Glide.with(context)
                    .load(card.getSecure_thumbnail())
                    .apply(requestOptions)
                    .into(imageCell);

        }else if(array.get(position) instanceof PayerCost){

            PayerCost payerCost = (PayerCost) array.get(position);

            fieldText.setText(payerCost.getRecommendedMessage());


        }

        cellList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lscl.cellPressed(array.get(position));
            }
        });



    }


    @Override
    public int getItemCount() {

        if(array != null){
            return array.size();
        }else{
            return 0;
        }

    }
}

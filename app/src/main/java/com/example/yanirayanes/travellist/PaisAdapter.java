package com.example.yanirayanes.travellist;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Yanira Yanes on 25/04/2018.
 */

public class PaisAdapter extends RecyclerView.Adapter<PaisAdapter.PaisViewHolder>{
    private ArrayList<Pais> pais;
    //barra de estado
    private static boolean fav = false;

    private Context mContext;

    public PaisAdapter(ArrayList<Pais> pais, Context cont){
        this.pais = pais;
        this.mContext = cont;
    }

    public class PaisViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        CardView card;
        ImageView img;
        ImageButton ib;

        public PaisViewHolder(View itemview){
            super(itemview);
            card = itemview.findViewById(R.id.card_view);
            name = itemview.findViewById(R.id.name);
            img = itemview.findViewById(R.id.img);
            ib = itemview.findViewById(R.id.fav_vacio);
        }
    }
    @Override
    public PaisViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_cardview, parent, false);
        return (new PaisViewHolder(v));
    }

    @Override
    public void onBindViewHolder(final PaisViewHolder holder, final int position) {
        holder.name.setText(pais.get(position).getName());
        holder.img.setImageResource(pais.get(position).getImg());

        if(pais.get(position).yesorno())
            holder.ib.setImageResource(R.drawable.fav2);
        else
            holder.ib.setImageResource(R.drawable.fav1);
        //boton para agregar y quitar
        holder.ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (wishgame(position)){
                    holder.ib.setImageResource(R.drawable.fav2);
                    //Funcion del main que agrega a la lista de favoritos
                    ((MainActivity)mContext).addBookmark(pais.get(position));

                }
                else {
                    holder.ib.setImageResource(R.drawable.fav1);
                    //elimina de favoritos
                    ((MainActivity)mContext).quitar(pais.get(position).getName());

                }

            }
        });
    }


    @Override
    public int getItemCount() {
        return pais.size();
    }
    public boolean wishgame(int position){
        pais.get(position).set(!pais.get(position).yesorno());
        return pais.get(position).yesorno();
    }
    public void setTrue(){
        fav=true;
    }

    public void setFalse(){
        fav=false;
    }
    public boolean isOnBookmark() {
        return fav;
    }

}


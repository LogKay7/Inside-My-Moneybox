package com.example.onetirelire;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import static com.example.onetirelire.MainActivity.ancSoldeTransacListDialog;
import static com.example.onetirelire.MainActivity.datesHeuresTransacList;
import static com.example.onetirelire.MainActivity.detailsTransacListDialog;
import static com.example.onetirelire.MainActivity.imgTransacList;
import static com.example.onetirelire.MainActivity.nvSoldeTransacListDialog;
import static com.example.onetirelire.MainActivity.titresTransacList;
import static com.example.onetirelire.MainActivity.uniqueidTransacList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {


    private static final String TAG= "RecyclerAdapter";

    public List<String> valeursTransacList;
    Dialog dialog;
    Context context;



    public RecyclerAdapter(List<String> valeursTransacList,  Context context)
    {
        this.valeursTransacList = valeursTransacList;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        dialog = new Dialog(context);
        dialog.setContentView(R.layout.dialog_onclick_transac);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textVid.setText(uniqueidTransacList.get(position));
        holder.textVValeurTransac.setText(valeursTransacList.get(position));
        holder.textVTitreTransac.setText(titresTransacList.get(position));
        holder.textVDateTransac.setText(datesHeuresTransacList.get(position));
        holder.imgTransac.setImageDrawable(imgTransacList.get(position));
    }

    @Override
    public int getItemCount() {        //Retourne le nombre d'items du recycler
        return valeursTransacList.size();
    }





    class ViewHolder extends RecyclerView.ViewHolder
    {

        ImageView imgTransac;       //Logo selon le type de transaction
        TextView textVid;     //Numéro de ligne
        TextView textVValeurTransac; //Valeur de l'opération
        TextView textVDateTransac;    //Date de la transaction
        TextView textVTitreTransac;     // Titre de l'opération
        String textId;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgTransac = itemView.findViewById(R.id.img_recycler_item);
            textVid = itemView.findViewById(R.id.rowCountTextView);
            textVValeurTransac = itemView.findViewById(R.id.textVValeurTransac);
            textVDateTransac = itemView.findViewById(R.id.textVDateTransac);
            textVTitreTransac = itemView.findViewById(R.id.textVTitreTransac );


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ImageView dialogImg = dialog.findViewById(R.id.logo_transac_dialog);
                    TextView dialogTitre =  dialog.findViewById(R.id.titre_transac_dialog);
                    TextView dialogDateHeure =  dialog.findViewById(R.id.date_heure_transac_dialog);
                    TextView dialogDetails =  dialog.findViewById(R.id.details_transac_dialog);
                    TextView dialogAncSolde =  dialog.findViewById(R.id.ancsolde_transac_dialog);
                    TextView dialogNvSolde =  dialog.findViewById(R.id.nvsolde_transac_dialog);
                    TextView dialogId =  dialog.findViewById(R.id.textVid);


                    textId = "id : " + uniqueidTransacList.get(getAdapterPosition());
                    dialogImg.setImageDrawable(imgTransacList.get(getAdapterPosition()));
                    dialogTitre.setText(titresTransacList.get(getAdapterPosition()));
                    dialogDateHeure.setText(datesHeuresTransacList.get(getAdapterPosition()));
                    dialogDetails.setText(detailsTransacListDialog.get(getAdapterPosition()));
                    dialogAncSolde.setText(ancSoldeTransacListDialog.get(getAdapterPosition()));
                    dialogNvSolde.setText(nvSoldeTransacListDialog.get(getAdapterPosition()));
                    dialogId.setText(textId);
                    dialog.show();

                }
            });

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {


                    return true;
                }
            });

        }

    }


}

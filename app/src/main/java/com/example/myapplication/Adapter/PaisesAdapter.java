package com.example.myapplication.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapplication.Model.Paises;
import com.example.myapplication.R;

import java.util.List;


public class PaisesAdapter extends RecyclerView.Adapter<PaisesAdapter.UsuarioViewHolder> {

    private Context Ctx;
    private List<Paises> lstPaises;

    public PaisesAdapter(Context mCtx, List<Paises> paises) {
        this.lstPaises = paises;
        Ctx=mCtx;
    }

    @Override
    public UsuarioViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(Ctx);
        View view = inflater.inflate(R.layout.item_usuario, null);
        return new UsuarioViewHolder(view);
    }

    @Override
    public void onBindViewHolder(UsuarioViewHolder holder, int position) {

        Paises paises = lstPaises.get(position);

        holder.textViewName.setText(paises.getPaises());

        Glide.with(Ctx)
                .load(paises.getUrlbandera())
                .into(holder.imageView);

    }


    @Override
    public int getItemCount() {
        return lstPaises.size();
    }


    class UsuarioViewHolder extends RecyclerView.ViewHolder {

        TextView textViewName;
        ImageView imageView;

        public UsuarioViewHolder(View itemView) {
            super(itemView);

            textViewName= itemView.findViewById(R.id.txtName);
            imageView = itemView.findViewById(R.id.imgAvatar);
        }
    }

}

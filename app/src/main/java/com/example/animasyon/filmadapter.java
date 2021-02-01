package com.example.animasyon;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class filmadapter extends BaseAdapter {
    List<filminfo> filminfos;
    Context context;


    public filmadapter(List<filminfo> filminfos, Context context) {
        this.filminfos = filminfos;
        this.context = context;
    }

    @Override
    public int getCount() {
        return filminfos.size();
    }

    @Override
    public Object getItem(int position) {
        return filminfos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View satır= LayoutInflater.from(context).inflate(R.layout.satirtasarim,parent,false);
        TextView fadı=satır.findViewById(R.id.filmadı);
        TextView fyılı=satır.findViewById(R.id.filmyılı);
        ImageView resım=satır.findViewById(R.id.filmresmi);

        fadı.setText(filminfos.get(position).getFilmAdi());
        fyılı.setText(filminfos.get(position).getFilmYil());
        Glide.with(context).asBitmap().load(filminfos.get(position).getFilmurl()).into(resım);
       //Picasso.get().load(filminfos.get(position).getFilmThumb()).into(resım);
        return satır;
    }
}

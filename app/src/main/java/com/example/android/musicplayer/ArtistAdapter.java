package com.example.android.musicplayer;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ArtistAdapter extends ArrayAdapter<Artist> {

    private Context mContext;
    private List<Artist> artistList = new ArrayList<Artist>();

    public ArtistAdapter(Context mContext, ArrayList<Artist> list) {
        super(mContext, 0, list);
        this.mContext = mContext;
        artistList = list;
    }

    public View getView (int position, View convertView, ViewGroup parent) {
        View listItem = convertView;
        if(listItem == null)
            listItem = LayoutInflater.from(mContext).inflate(R.layout.listitem_1,parent,false);

        final Artist currentArtist = artistList.get(position);

        TextView name = listItem.findViewById(R.id.textView_name);
        name.setText(currentArtist.getName());
        name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent detailActivity = new Intent(mContext, ArtistDetailActivity.class);
                detailActivity.putExtra("artist",currentArtist);
                mContext.startActivity(detailActivity);
            }
        });

        return listItem;
    }
}

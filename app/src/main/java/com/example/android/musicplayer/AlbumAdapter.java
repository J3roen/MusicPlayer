package com.example.android.musicplayer;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AlbumAdapter extends ArrayAdapter {
    private Context mContext;
    private List<Album> albumList = new ArrayList<>();

    public AlbumAdapter(Context context, ArrayList<Album> list) {
        super(context,0,list);
        this.mContext = context;
        albumList = list;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewGroup listParent = parent;
        View listItem = convertView;
        if (listItem == null)
            listItem = LayoutInflater.from(mContext).inflate(R.layout.listitem_1,parent,false);

        final Album currentAlbum = albumList.get(position);
        TextView name = listItem.findViewById(R.id.textView_name);
        name.setText(currentAlbum.getName());
        name.setTag("closed");

        final int currentIndex = position;
        //set onClickListener
        name.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //if list already expanded, close it. Else expand it
                if (v.getTag().toString().equals("expanded")) {
                    v.setTag("closed");
                    //close song list
                    listParent.removeViewAt(currentIndex + 1);
                } else {
                    //expand song list
                    v.setTag("expanded");
                    //create LinearLayout songListLayout
                    LinearLayout songListContainer = new LinearLayout(mContext);
                    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                    songListContainer.setOrientation(LinearLayout.VERTICAL);
                    params.setMargins((int) mContext.getResources().getDimension(R.dimen.defaultPadding) / 2, 0, 0, (int) mContext.getResources().getDimension(R.dimen.defaultPadding) / 2);
                    songListContainer.setLayoutParams(params);
                    listParent.addView(songListContainer, currentIndex + 1);
                    //fill songListLayout with list of songs
                    for (final Song song : currentAlbum.getSongArrayList()) {
                        TextView songListView = new TextView(mContext);
                        LinearLayout.LayoutParams songLayoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                        songListView.setAllCaps(true);
                        songListView.setPadding(0, 0, 0, (int) mContext.getResources().getDimension(R.dimen.defaultPadding));
                        songListView.setText(song.getName());
                        songListView.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent songDetailActivity = new Intent(mContext, SongDetailActivity.class);
                                songDetailActivity.putExtra("song", song);
                                songDetailActivity.putExtra("artist", currentAlbum.getArtistName());
                                songDetailActivity.putExtra("albumCover", currentAlbum.getCover());
                                mContext.startActivity(songDetailActivity);
                            }
                        });
                        songListView.setLayoutParams(songLayoutParams);
                        songListContainer.addView(songListView);
                    }
                }
            }
        });
        return listItem;
    }
}

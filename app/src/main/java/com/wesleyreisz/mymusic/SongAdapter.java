package com.wesleyreisz.mymusic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.wesleyreisz.mymusic.model.Song;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by cewon_000 on 10/19/2015.
 */
public class SongAdapter extends ArrayAdapter<Song> {
    private Context mContext;
    private List<Song> mEntries;
    private SimpleDateFormat df = new SimpleDateFormat("MMM d, yyyy (EEE)");

    public SongAdapter(MyMusicActivity context, int textViewResourceId, List<Song> entries) {
        super(context, textViewResourceId, entries);
        mContext = context;
        mEntries = entries;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        if(view==null){
            LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.list_view, parent, false);
        }

        final Song song = mEntries.get(position);

        TextView textViewTitle = (TextView)view.findViewById(R.id.textViewSongTitle);
        textViewTitle.setText(song.getArtistName());

        TextView textViewArtist = (TextView)view.findViewById(R.id.textViewSongArtist);
        textViewArtist.setText(song.getArtistName());

        TextView textViewDate = (TextView)view.findViewById(R.id.textViewSongDate);
        textViewDate.setText(df.format(song.getSongPublishedDate()));

        return view;
    }
}

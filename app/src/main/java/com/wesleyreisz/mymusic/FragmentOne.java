package com.wesleyreisz.mymusic;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.wesleyreisz.mymusic.model.Song;
import com.wesleyreisz.mymusic.service.MockMusicService;

import java.util.List;

/**
 * Created by cewon_000 on 10/19/2015.
 */
public class FragmentOne extends Fragment {
    public static FragmentOne newInstance() {
        FragmentOne fragmentOne = new FragmentOne();
        Bundle args = new Bundle();
        fragmentOne.setArguments(args);;
        return fragmentOne;
    }

    public FragmentOne(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one, container, false);
        ListView listView = (ListView)view.findViewById(R.id.list_view);
        List<Song> songs = new MockMusicService().findAll();
        SongAdapter songAdapter = new SongAdapter(getActivity(), R.layout.fragment_one, songs);
        listView.setAdapter(songAdapter);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onDetach(){
        super.onDetach();
    }

}

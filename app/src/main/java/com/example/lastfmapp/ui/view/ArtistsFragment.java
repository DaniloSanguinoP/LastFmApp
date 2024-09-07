package com.example.lastfmapp.ui.view;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lastfmapp.adapter.ArtistsAdapter;
import com.example.lastfmapp.data.model.Artists;
import com.example.lastfmapp.databinding.FragmentArtistsBinding;

import java.util.ArrayList;

public class ArtistsFragment extends Fragment {

    private ArtistsViewModel artistsViewModel;
    private RecyclerView recyclerView;
    private ArtistsAdapter artistsAdapter;
    private FragmentArtistsBinding binding;

    public static ArtistsFragment newInstance() {
        return new ArtistsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentArtistsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        artistsViewModel = new ViewModelProvider(this).get(ArtistsViewModel.class);
        binding.recyclerViewArtists.setLayoutManager(new LinearLayoutManager(getContext()));

        searchArtists();
    }

    private void searchArtists() {

        artistsViewModel.getTopArtists().observe(getViewLifecycleOwner(), new Observer<ArrayList<Artists>>() {
            @Override
            public void onChanged(ArrayList<Artists> artists) {
                if(artists != null) {
                    artistsAdapter = new ArtistsAdapter(artists);
                    binding.recyclerViewArtists.setAdapter(artistsAdapter);
                }
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
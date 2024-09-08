package com.example.lastfmapp.ui.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.lastfmapp.R;
import com.example.lastfmapp.databinding.FragmentArtistsBinding;
import com.example.lastfmapp.ui.adapter.ArtistsAdapter;
import com.example.lastfmapp.ui.adapter.onClickListener.OnArtistClickListener;
import com.example.lastfmapp.ui.viewModel.ArtistsViewModel;
import com.example.lastfmapp.utils.NetworkUtils;
import com.google.android.material.snackbar.Snackbar;

public class ArtistsFragment extends Fragment implements OnArtistClickListener {

    private ArtistsViewModel artistsViewModel;
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

        if (NetworkUtils.isInternetAvailable(requireActivity())) {
            searchArtists();
        } else {
            Snackbar.make(binding.getRoot(), getString(R.string.error_internet), Snackbar.LENGTH_LONG)
                    .show();
        }

    }

    private void searchArtists() {

        artistsViewModel.getTopArtists().observe(getViewLifecycleOwner(), artists -> {
            if (artists != null) {
                artistsAdapter = new ArtistsAdapter(artists, ArtistsFragment.this);
                binding.recyclerViewArtists.setAdapter(artistsAdapter);
            }
        });
    }

    @Override
    public void onArtistClick(String artists) {
        if(NetworkUtils.isInternetAvailable(requireActivity())) {
            changeFragment(artists);
        } else {
            Snackbar.make(binding.getRoot(), getString(R.string.error_internet), Snackbar.LENGTH_LONG)
                    .show();
        }
    }

    public void changeFragment(String artists) {
        TrackFragment trackFragment = TrackFragment.newInstance(artists);
        ((ArtistsActivity) getActivity()).changeFragment(trackFragment);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}
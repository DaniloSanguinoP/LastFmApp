package com.example.lastfmapp.ui.view;

import android.content.Intent;
import android.net.Uri;
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
import com.example.lastfmapp.databinding.FragmentTracksBinding;
import com.example.lastfmapp.ui.adapter.TrackAdapter;
import com.example.lastfmapp.ui.adapter.onClickListener.OnTrackClickListener;
import com.example.lastfmapp.ui.viewModel.TrackViewModel;
import com.example.lastfmapp.utils.NetworkUtils;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class TrackFragment extends Fragment implements OnTrackClickListener {

    private TrackViewModel mViewModel;
    private FragmentTracksBinding binding;
    private TrackAdapter trackAdapter;
    private String artistName;

    public static TrackFragment newInstance(String artistName) {
        TrackFragment trackFragment = new TrackFragment();
        trackFragment.artistName = artistName;
        return trackFragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentTracksBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(TrackViewModel.class);
        binding.rwTrack.setLayoutManager(new LinearLayoutManager(getContext()));

        trackAdapter = new TrackAdapter(new ArrayList<>(), TrackFragment.this);

        searchTrack();
        setUpViewData();
        onClickBtn();

    }

    public void searchTrack() {

        mViewModel.getTopTrack(artistName).observe(getViewLifecycleOwner(), tracks -> {
            if (tracks != null) {
                trackAdapter = new TrackAdapter(tracks, TrackFragment.this);
                binding.rwTrack.setAdapter(trackAdapter);
            }
        });
    }

    public void setUpViewData() {
        binding.tvArtistName.setText(artistName);
    }

    public void onClickBtn() {
        binding.backButton.setOnClickListener(view -> {
            requireActivity().getSupportFragmentManager().popBackStack();
        });
    }

    /** Redireccionamiento al website*/
    public void goToWebsite(String url) {
        if (url.isEmpty()) {
            Snackbar.make(binding.getRoot(), getString(R.string.error_exist_url), Snackbar.LENGTH_LONG)
                    .show();
        } else {
            if (NetworkUtils.isInternetAvailable(requireActivity())) {
                Uri uri = Uri.parse(url);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            } else {
                Snackbar.make(binding.getRoot(), getString(R.string.error_internet), Snackbar.LENGTH_LONG)
                        .show();
            }
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onTrackClick(String urlArtist) {
        goToWebsite(urlArtist);
    }
}
package com.example.lastfmapp.ui.view;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.lastfmapp.R;
import com.example.lastfmapp.databinding.ActivityArtistsBinding;

public class ArtistsActivity extends AppCompatActivity {

    private ActivityArtistsBinding binding;
    FragmentTransaction transaction;
    Fragment artistsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityArtistsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        if (savedInstanceState == null) {
            artistsFragment = new ArtistsFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.artistsFragment, artistsFragment).commit();
        }

    }
}
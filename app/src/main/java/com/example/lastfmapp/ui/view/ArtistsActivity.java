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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityArtistsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        if (savedInstanceState == null) {
            changeFragment(new ArtistsFragment());
        }

    }
    
    /** Gestiona el lanzamioento de fragment */
    public void changeFragment(Fragment fragment) {
        transaction = getSupportFragmentManager().beginTransaction().replace(R.id.artistsFragment, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
package com.example.lastfmapp.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lastfmapp.data.model.Artists;
import com.example.lastfmapp.databinding.ArtistsRowBinding;

import java.util.ArrayList;

public class ArtistsAdapter extends RecyclerView.Adapter<ArtistsAdapter.ViewHolder> {

    private ArrayList<Artists> dataset;

    public ArtistsAdapter(ArrayList<Artists> artists) {
        this.dataset = artists;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ArtistsRowBinding binding = ArtistsRowBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ArtistsAdapter.ViewHolder holder, int position) {
        Artists artists = dataset.get(position);
        holder.bindData(artists, position);
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final ArtistsRowBinding binding;

        public ViewHolder(ArtistsRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bindData(Artists artists, int position) {

            String artistsPosition = Integer.toString(position + 1);
            binding.artistName.setText(artists.getName());
            binding.artistNumber.setText(String.format("%s.", artistsPosition));
            binding.artistListenersNumber.setText(artists.getListeners());

        }
    }
}

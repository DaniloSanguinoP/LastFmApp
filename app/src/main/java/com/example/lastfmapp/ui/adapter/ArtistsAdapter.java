package com.example.lastfmapp.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lastfmapp.data.model.Artists;
import com.example.lastfmapp.databinding.ArtistsRowBinding;
import com.example.lastfmapp.ui.adapter.onClickListener.OnArtistClickListener;
import com.example.lastfmapp.utils.FormatUtil;

import java.util.ArrayList;
import java.util.List;

public class ArtistsAdapter extends RecyclerView.Adapter<ArtistsAdapter.ViewHolder> {

    private List<Artists> dataset;
    private OnArtistClickListener listener;

    public ArtistsAdapter(List<Artists> artists, OnArtistClickListener listener) {
        this.dataset = artists;
        this.listener = listener;
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
        holder.bindData(artists, listener, position);
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

        public void bindData(Artists artists, OnArtistClickListener listener, int position) {

            String artistsPosition = Integer.toString(position + 1);
            binding.artistName.setText(artists.getName());
            binding.artistNumber.setText(String.format("%s.", artistsPosition));
            binding.artistListenersNumber.setText(FormatUtil.FormatNumber(artists.getListeners()));

            binding.getRoot().setOnClickListener(view -> {
                listener.onArtistClick(artists.getName());
            });

        }
    }
}

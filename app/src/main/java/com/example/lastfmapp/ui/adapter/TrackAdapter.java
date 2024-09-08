package com.example.lastfmapp.ui.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lastfmapp.data.model.Tracks;
import com.example.lastfmapp.databinding.TrackRowBinding;
import com.example.lastfmapp.ui.adapter.onClickListener.OnTrackClickListener;
import com.example.lastfmapp.utils.FormatUtil;

import java.util.List;

public class TrackAdapter extends RecyclerView.Adapter<TrackAdapter.ViewHolder> {

    private List<Tracks> dataset;
    private OnTrackClickListener listener;

    public TrackAdapter(List<Tracks> tracks, OnTrackClickListener listener) {
        this.dataset = tracks;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        TrackRowBinding binding = TrackRowBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull TrackAdapter.ViewHolder holder, int position) {
        Tracks tracks = dataset.get(position);
        holder.bindData(tracks, listener);
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public void setTracks(List<Tracks> tracks) {
        dataset.addAll(tracks);
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final TrackRowBinding binding;

        public ViewHolder(TrackRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bindData(Tracks tracks, OnTrackClickListener listener) {

            binding.trackName.setText(tracks.getName());
            binding.artistListenersNumber.setText(FormatUtil.FormatNumber(tracks.getListeners()));

            binding.getRoot().setOnClickListener(view -> {
                listener.onTrackClick(tracks.getUrl());
            });

        }
    }
}

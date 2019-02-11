package com.example.roomdatabase;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder> {

    private LayoutInflater layoutInflater;
    private List<Word> words;

    WordListAdapter(Context context){
        layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = layoutInflater.inflate(R.layout.recyclerview_item, viewGroup, false);
        return new WordViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder wordViewHolder, int position) {
        if (words != null){
            Word current = words.get(position);
            wordViewHolder.wordItemView.setText(current.getWord());
        }else {
            wordViewHolder.wordItemView.setText("No Words");
        }

    }

    void setWords(List<Word> mWords){
        words = mWords;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (words != null){
            return words.size();
        }else {
            return 0;
        }
    }

    class WordViewHolder extends RecyclerView.ViewHolder{

        private final TextView wordItemView;

        public WordViewHolder(@NonNull View itemView) {
            super(itemView);
            wordItemView = itemView.findViewById(R.id.textView);
        }
    }
}

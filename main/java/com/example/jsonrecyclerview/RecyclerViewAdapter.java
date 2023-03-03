package com.example.jsonrecyclerview;

import android.annotation.SuppressLint;
import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>implements Filterable {

    private Context mContext;
     List<Movie> mItemList;
     List<Movie> movieList;
    LayoutInflater inflater;
    Movie movie=new Movie();
    public RecyclerViewAdapter(Context context, List<Movie> itemList) {
        this.mContext = context;
        this.mItemList=itemList;
        movieList=new ArrayList<>();
        movieList.addAll(mItemList);
        inflater = (LayoutInflater.from(context));
    }

    /*public void setFilteredList(List<Movie> filteredList){
        this.mItemList=filteredList;
        notifyDataSetChanged();
    }*/
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        view=inflater.inflate(R.layout.movie_row_item,parent,false);
        return new MyViewHolder(view);
    }





    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.title.setText( "Title:"+mItemList.get(position).getMovieTitle());
        holder.rating.setText( "Rated:-"+mItemList.get(position).getMovieRated());
        holder.year.setText( "Year:-"+mItemList.get(position).getMovieYear());
        holder.director.setText( "Director:-"+mItemList.get(position).getMovieDirector());
        holder.genre.setText( "Genre:-"+mItemList.get(position).getMovieGenre());
        holder.release.setText( "Released:-"+mItemList.get(position).getMovieReleased());
        holder.runtime.setText("Runtime:-"+ mItemList.get(position).getMovieRuntime());
        holder.actors.setText( "Actors:-"+mItemList.get(position).getMovieActors());
        holder.writers.setText( "Writers:-"+mItemList.get(position).getMovieWriter());
        Glide.with(mContext)

                .load(mItemList.get(position).getImgUrl()).into(holder.movie_image);
    }

    @Override
    public int getItemCount() {
        return mItemList.size();
    }

    @Override
    public Filter getFilter() {
        return filter;
    }
Filter filter=new Filter() {
    @Override
    protected FilterResults performFiltering(CharSequence charSequence) {
        List<Movie> filteredmovies=new ArrayList<>();
        if(charSequence.toString().isEmpty()){
        filteredmovies.addAll(movieList);
        }else{
            for (Movie m:movieList){
                if (m.getMovieTitle().toLowerCase().contains(charSequence.toString().toLowerCase())){
                    filteredmovies.add(m);
                }else

                if (m.getMovieYear().toLowerCase().contains(charSequence.toString().toLowerCase())){
                    filteredmovies.add(m);

                }else

                if (m.getMovieDirector().toLowerCase().contains(charSequence.toString().toLowerCase())){
                    filteredmovies.add(m);

                }
            }
        }

        FilterResults filterResults=new FilterResults();
        filterResults.values=filteredmovies;
        return filterResults;
    }
    @SuppressWarnings("unchecked")
    @SuppressLint("NotifyDataSetChanged")
    @Override
    protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
        mItemList.clear();

          mItemList.addAll((Collection<? extends Movie>) filterResults.values);
          notifyDataSetChanged();


    }
};
    public static class MyViewHolder extends RecyclerView.ViewHolder{
         ImageView movie_image;
        TextView title,rating,year,director,genre
                ,release,runtime,actors,writers,image_url;
        public MyViewHolder(View itemView) {
            super(itemView);

           movie_image = itemView.findViewById(R.id.image_view);
             title=itemView.findViewById(R.id.label);
             rating=itemView.findViewById(R.id.label2);
            year =itemView.findViewById(R.id.label3);
            director=itemView.findViewById(R.id.label4);
            genre=itemView.findViewById(R.id.label5);
            release=itemView.findViewById(R.id.label6);
            runtime=itemView.findViewById(R.id.label7);
            actors=itemView.findViewById(R.id.label8);
            writers=itemView.findViewById(R.id.label9);
        }
    }


}

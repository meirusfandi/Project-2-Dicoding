package com.example.root.movieuiux.helper;import android.content.Context;import android.content.Intent;import android.support.annotation.NonNull;import android.support.v7.widget.RecyclerView;import android.view.LayoutInflater;import android.view.View;import android.view.ViewGroup;import android.widget.Button;import android.widget.ImageView;import android.widget.TextView;import android.widget.Toast;import com.example.root.movieuiux.DetailActivity;import com.example.root.movieuiux.R;import com.squareup.picasso.Picasso;import java.text.ParseException;import java.text.SimpleDateFormat;import java.util.ArrayList;import java.util.Date;public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {    private RecyclerView recyclerView;    private Context context;    private MyAdapter adapter;    private ArrayList<MyMovies> movies;    public MyAdapter(Context context, ArrayList<MyMovies> movies) {        this.context = context;        this.movies = movies;    }    @NonNull    @Override    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {        View view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);        return new MyViewHolder(view);    }    @Override    public void onBindViewHolder(@NonNull final MyAdapter.MyViewHolder holder, int position) {        final MyMovies movie = movies.get(position);        //setting title        final String judul = movie.getTitle();        holder.title.setText(judul);        //setting overview        String overview = "Nothing Overview Data";        if (!movie.getOverview().isEmpty()){            overview    = movie.getOverview();        }        holder.overview.setText(overview);        //setting imageview backdrop        String path = movie.getPoster();        Picasso.with(context).load("http://image.tmdb.org/t/p/w185/"+path).placeholder(context.getResources().                getDrawable(R.mipmap.ic_launcher)).error(context.getResources().                getDrawable(R.mipmap.ic_launcher)).                into(holder.poster);        //setting release_date        String getDate = movie.getRelease();        String setDate = "";        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");        try {            Date date = dateFormat.parse(getDate);            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEEE, MM dd, yyyy");            setDate = simpleDateFormat.format(date);            holder.release.setText(setDate);        } catch (ParseException e){            e.printStackTrace();        }        holder.detail.setOnClickListener(new View.OnClickListener() {            @Override            public void onClick(View v) {                Intent intent = new Intent(context, DetailActivity.class);                intent.putExtra(DetailActivity.DETAIL_TITLE, movie.getTitle());                intent.putExtra(DetailActivity.DETAIL_OVERVIEW, movie.getOverview());                intent.putExtra(DetailActivity.DETAIL_RELEASE, movie.getRelease());                intent.putExtra(DetailActivity.DETAIL_VOTE, movie.getRate());                intent.putExtra(DetailActivity.DETAIL_AVG, movie.getRate_avg());                intent.putExtra(DetailActivity.DETAIL_BACKDROP, movie.getBackdrop());                intent.putExtra(DetailActivity.DETAIL_POPULARITY, movie.getPopularity());                context.startActivity(intent);            }        });        holder.favorite.setOnClickListener(new View.OnClickListener() {            @Override            public void onClick(View v) {                Toast.makeText(context, "Anda memilih "+ movie.getTitle(), Toast.LENGTH_LONG).show();            }        });    }    @Override    public int getItemCount() {        return movies.size();    }    public class MyViewHolder extends RecyclerView.ViewHolder {        TextView title, release, overview;        ImageView poster;        Button detail, favorite;        public MyViewHolder(View itemView) {            super(itemView);            title       = (TextView)itemView.findViewById(R.id.title);            release     = (TextView)itemView.findViewById(R.id.release);            overview    = (TextView)itemView.findViewById(R.id.overview);            poster      = (ImageView)itemView.findViewById(R.id.poster);            detail      = (Button)itemView.findViewById(R.id.btnDetail);            favorite    = (Button)itemView.findViewById(R.id.btnFavorite);        }    }}
package com.fachrur_122.newmovie.list;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.fachrur_122.newmovie.Interface.MoviesListingView;
import com.fachrur_122.newmovie.R;
import com.fachrur_122.newmovie.view.Movie;

import java.util.List;

/**
 * Created by fachrur_122 on 30/04/2016.
 *
 */
public class MoviesListingAdapter extends RecyclerView.Adapter<MoviesListingAdapter.ViewHolder> {

    private List<Movie> mMovies;
    private Context mContext;
    private MoviesListingView mMoviesView;

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView mMovieName;
        public ImageView mMoviePoster;
        public View mTitleBackground;
        public Movie mMovie;

        public ViewHolder(View root) {
            super(root);
            mMovieName = (TextView) root.findViewById(R.id.movie_name);
            mMoviePoster = (ImageView) root.findViewById(R.id.movie_poster);
            mTitleBackground = root.findViewById(R.id.title_background);
        }

        @Override
        public void onClick(View view)
        {
            mMoviesView.onMovieClicked(mMovie);
        }
    }

    public MoviesListingAdapter(List<Movie> movies, MoviesListingView moviesView) {
        mMovies = movies;
        mMoviesView = moviesView;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View rootView = LayoutInflater.from(mContext).inflate(R.layout.movie_grid_item, parent, false);

        return new ViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.itemView.setOnClickListener(holder);
        holder.mMovie = mMovies.get(position);
        holder.mMovieName.setText(holder.mMovie.getTitle());
        Glide.with(mContext).load(holder.mMovie
                .getPosterPath()).asBitmap()
                .diskCacheStrategy(DiskCacheStrategy.RESULT)
                .into(new BitmapImageViewTarget(holder.mMoviePoster) {
                    @Override
                    public void onResourceReady(Bitmap bitmap, GlideAnimation anim) {
                        super.onResourceReady(bitmap, anim);

                        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener()
                        {
                            @Override
                            public void onGenerated(Palette palette)
                            {
                                holder.mTitleBackground.setBackgroundColor(palette.getVibrantColor(mContext
                                        .getResources().getColor(R.color.black_translucent_60)));
                            }
                        });
                    }
                });
    }

    @Override
    public int getItemCount()
    {
        return mMovies.size();
    }

}

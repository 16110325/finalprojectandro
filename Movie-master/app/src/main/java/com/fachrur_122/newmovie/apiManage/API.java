package com.fachrur_122.newmovie.apiManage;

/**
 * Created by fachrur_122 on 30/04/2016.
 *
 */
public class API {

    public static final String API_KEY = "5a1bfe58c48ce43216d8daf06f0b2c0c";
    public static final String GET_POPULAR_MOVIES =
            "http://api.themoviedb.org/3/discover/movie?language=en&sort_by=popularity.desc&api_key="
                    + API_KEY;

    public static final String GET_HIGHEST_RATED_MOVIES =
            "http://api.themoviedb.org/3/discover/movie?vote_count.gte=500&language=en&sort_by=vote_average.desc&api_key="
                    + API_KEY;

    public static final String GET_TRAILERS = "http://api.themoviedb.org/3/movie/%s/videos?api_key=" + API_KEY;
    public static final String GET_REVIEWS = "http://api.themoviedb.org/3/movie/%s/reviews?api_key=" + API_KEY;
    public static final String POSTER_PATH = "http://image.tmdb.org/t/p/w342";
    public static final String BACKDROP_PATH = "http://image.tmdb.org/t/p/w780";

}

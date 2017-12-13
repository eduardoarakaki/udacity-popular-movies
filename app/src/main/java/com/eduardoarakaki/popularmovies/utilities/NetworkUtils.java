package com.eduardoarakaki.popularmovies.utilities;

/**
 * Created by eduardoarakaki on 11/12/2017.
 */

import android.net.Uri;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * These utilities will be used to communicate with the themoviedb servers.
 */
public final class NetworkUtils {

    private static final String TAG = NetworkUtils.class.getSimpleName();

    private static final String BASE_URL = "http://api.themoviedb.org/3";

    private final static String QUERY_PARAM = "api_key";

    private static final String KEY = "6fe5b8a70e82c2ed596499ea4ecb2d74";

    private static final String MOVIE_PATH = "movie";

    public static final String POPULAR_PARAM = "popular";

    public static final String TOP_RATED_PARAM = "top_rated ";

    public static URL buildUrl(String pathMovie) {

        Uri builtUri = Uri.parse(BASE_URL).buildUpon()
                .appendPath(MOVIE_PATH)
                .appendPath(pathMovie)
                .appendQueryParameter(QUERY_PARAM, KEY)
                .build();

        URL url = null;

        try {
            url = new URL(builtUri.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        Log.v(TAG, "Built URI " + url);

        return url;
    }

    /**
     * This method returns the entire result from the HTTP response.
     *
     * @param url The URL to fetch the HTTP response from.
     * @return The contents of the HTTP response.
     * @throws IOException Related to network and stream reading
     */
    public static String getResponseFromHttpUrl(URL url) throws IOException {
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            InputStream in = urlConnection.getInputStream();

            Scanner scanner = new Scanner(in);
            scanner.useDelimiter("\\A");

            boolean hasInput = scanner.hasNext();
            if (hasInput) {
                return scanner.next();
            } else {
                return null;
            }
        } finally {
            urlConnection.disconnect();
        }
    }
}
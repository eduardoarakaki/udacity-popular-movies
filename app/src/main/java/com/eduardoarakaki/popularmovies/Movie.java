package com.eduardoarakaki.popularmovies;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by eduardoarakaki on 11/12/2017.
 */
public class Movie implements Parcelable {

    int page;
    long total_results;
    long total_pages;
    List<MovieDetail> results;

    public static class MovieDetail implements Parcelable{

        long vote_count;
        long id;
        boolean video;
        float vote_average;
        String title;
        double popularity;
        String poster_path;
        String original_language;
        String original_title;
        int[] genre_ids;
        String backdrop_path;
        boolean adult;
        String overview;
        String release_date;

        protected MovieDetail(Parcel in) {
            vote_count = in.readLong();
            id = in.readLong();
            video = in.readByte() != 0;
            vote_average = in.readFloat();
            title = in.readString();
            popularity = in.readDouble();
            poster_path = in.readString();
            original_language = in.readString();
            original_title = in.readString();
            genre_ids = in.createIntArray();
            backdrop_path = in.readString();
            adult = in.readByte() != 0;
            overview = in.readString();
            release_date = in.readString();
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeLong(vote_count);
            dest.writeLong(id);
            dest.writeByte((byte) (video ? 1 : 0));
            dest.writeFloat(vote_average);
            dest.writeString(title);
            dest.writeDouble(popularity);
            dest.writeString(poster_path);
            dest.writeString(original_language);
            dest.writeString(original_title);
            dest.writeIntArray(genre_ids);
            dest.writeString(backdrop_path);
            dest.writeByte((byte) (adult ? 1 : 0));
            dest.writeString(overview);
            dest.writeString(release_date);
        }

        @Override
        public int describeContents() {
            return 0;
        }

        public static final Creator<MovieDetail> CREATOR = new Creator<MovieDetail>() {
            @Override
            public MovieDetail createFromParcel(Parcel in) {
                return new MovieDetail(in);
            }

            @Override
            public MovieDetail[] newArray(int size) {
                return new MovieDetail[size];
            }
        };

        @Override
        public String toString() {
            return super.toString();
        }
    }

    protected Movie(Parcel in) {
        page = in.readInt();
        total_results = in.readLong();
        total_pages = in.readLong();
        results = in.createTypedArrayList(MovieDetail.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(page);
        dest.writeLong(total_results);
        dest.writeLong(total_pages);
        dest.writeTypedList(results);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };
}
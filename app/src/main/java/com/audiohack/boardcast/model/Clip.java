package com.audiohack.boardcast.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * @since 2015.09.19
 */
public class Clip implements Parcelable {
    //
    // Constants
    //

    /**
     * Implementation of {@link Parcelable.Creator} for generating instances of Clip from {@link
     * Parcelable} instances;
     */
    public static final Parcelable.Creator<Clip> CREATOR = new Parcelable.Creator<Clip>() {
        @Override
        public Clip createFromParcel(Parcel source) {
            return new Clip(source);
        }

        @Override
        public Clip[] newArray(int size) {
            return new Clip[size];
        }
    };

    //
    // Fields
    //

    public int id;
    public String title;
    public String showTitle;
    public String showURL;
    @SerializedName("audio_files")
    public List<String> audioURLs;
    public String posterURL;
    @SerializedName("in_point")
    public float timeIn;
    public float timeOut;
    public String transcript;
    public String color;

    //
    // Constructors.
    //

    public Clip(int id, String showTitle, String showURL, List<String> audioURLs, String posterURL, float timeIn, float timeOut,
                String transcript, String color) {
        this.id = id;
        this.showTitle = showTitle;
        this.showURL = showURL;
        this.audioURLs = audioURLs;
        this.posterURL = posterURL;
        this.timeIn = timeIn;
        this.timeOut = timeOut;
        this.transcript = transcript;
        this.color = color;
    }

    /**
     * Private constructor for restoring instance from {@link Parcel}.
     *
     * @param in {@link Parcel} from which to restore a $ instance.
     */
    public Clip(Parcel in) {
        id = in.readInt();
        showTitle = in.readString();
        showURL = in.readString();
        audioURLs = new ArrayList<>();
        in.readStringList(audioURLs);
        posterURL = in.readString();
        timeIn = in.readFloat();
        timeOut = in.readFloat();
        transcript = in.readString();
        color = in.readString();
    }


    //
    // Parcelable implementation.
    //

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel destination, int flags) {
        destination.writeInt(id);
        destination.writeString(showTitle);
        destination.writeString(showURL);
        destination.writeStringList(audioURLs);
        destination.writeString(posterURL);
        destination.writeFloat(timeIn);
        destination.writeFloat(timeOut);
        destination.writeString(transcript);
        destination.writeString(color);
    }
}

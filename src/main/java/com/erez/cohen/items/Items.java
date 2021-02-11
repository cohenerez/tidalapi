package com.erez.cohen.items;

import com.erez.cohen.models.Album;
import com.erez.cohen.models.Artist;
import com.erez.cohen.models.Playlist;
import com.erez.cohen.models.Track;
import com.erez.cohen.session.Session;
import com.erez.cohen.utils.RestHelper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;

public class Items {

    private Session currentSession;
    private RestHelper restHelper;

    public Items(Session currentSession) {
        this(currentSession, new RestHelper());
    }

    public Items(Session currentSession, RestHelper restHelper) {
        this.currentSession = currentSession;
        this.restHelper = restHelper;
    }

    public Album getAlbum(String albumId) {
        return getItem(albumId, "album", Album.class);
    }

    public Artist getArtist(String artistId){
        return getItem(artistId, "artist", Artist.class);
    }

    public Track getTrack(String trackId) {
        return getItem(trackId, "track", Track.class);
    }

    public Playlist getPlaylist(String playlistId) {
        return getItem(playlistId, "playlist", Playlist.class);
    }

    private <T> T getItem(String itemId, String itemType, Class<T> clazz) {
        HttpResponse<JsonNode> jsonResponse = restHelper.executeRequest(currentSession.get(itemType + "s/" + itemId)
                .queryString("limit", "999"));
        return restHelper.checkAndDeserialize(jsonResponse, clazz);
    }
}

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Album {
    private final StringProperty namaAlbum;
    private final StringProperty artist;

    public Album(String namaAlbum, String artist) {
        this.namaAlbum = new SimpleStringProperty(namaAlbum);
        this.artist = new SimpleStringProperty(artist);
    }

    public String getnamaAlbum() {
        return namaAlbum.get();
    }

    public StringProperty namaAlbumProperty() {
        return namaAlbum;
    }

    public void setnamaAlbum(String namaAlbum) {
        this.namaAlbum.set(namaAlbum);
    }

    public String getArtist() {
        return artist.get();
    }

    public StringProperty artistProperty() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist.set(artist);
    }
}
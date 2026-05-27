package vn.codegym.zingmp3.model;

import jakarta.persistence.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@NamedQuery(
        name = "findAllSongsWithNameArtistGenre",
        query = "SELECT c FROM Song c WHERE c.name LIKE :name AND c.artist LIKE :artist AND c.genre LIKE :genre"
)
@Entity
@Table(name = "songs")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String artist;
    private String genre;
    private String url;
    private Date createdAt;
    private Date updatedAt;

    @Transient
    private MultipartFile mp3File;

    public Song(Long id, String name, String artist, String genre, String url) {
        this.id = id;
        this.name = name;
        this.artist = artist;
        this.genre = genre;
        this.url = url;
    }

    public Song(String name, String artist, String genre, String url) {
        this.name = name;
        this.artist = artist;
        this.genre = genre;
        this.url = url;
    }

    public Song() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public MultipartFile getMp3File() {
        return mp3File;
    }

    public void setMp3File(MultipartFile mp3File) {
        this.mp3File = mp3File;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @PrePersist
    protected void onCreate() {
        createdAt = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = new Date();
    }
}

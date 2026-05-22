package vn.codegym.zingmp3.service;

import vn.codegym.zingmp3.model.Song;

import java.util.List;

public interface ISongService {
    List<Song> findAll();

    List<Song> search(String name, String artist, String genre);

    void save(Song song);

    Song findById(Long id);

    void remove(Long id);
}
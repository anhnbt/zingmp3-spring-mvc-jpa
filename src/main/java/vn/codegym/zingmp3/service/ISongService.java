package vn.codegym.zingmp3.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.zingmp3.model.Song;

import java.util.List;

public interface ISongService {
    Iterable<Song> findAll();

    Page<Song> findAll(Pageable pageable);

    List<Song> search(String name, String artist, String genre);

    void save(Song song);

    Song findById(Long id);

    void remove(Long id);

    void remove();
}
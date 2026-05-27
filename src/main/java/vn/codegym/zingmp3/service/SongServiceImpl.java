package vn.codegym.zingmp3.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.zingmp3.model.Song;
import vn.codegym.zingmp3.repository.SongRepository;

import java.util.List;

@Service
public class SongServiceImpl implements ISongService {

    private final SongRepository songRepository;

    public SongServiceImpl(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @Override
    public Iterable<Song> findAll() {
        return songRepository.findAll();
    }

    @Override
    public Page<Song> findAll(Pageable pageable) {
        return songRepository.findAll(pageable);
    }

    @Override
    public List<Song> search(String name, String artist, String genre) {
        return songRepository.search(name, artist, genre);
    }

    @Override
    public void save(Song song) {
        songRepository.save(song);
    }

    @Override
    public Song findById(Long id) {
        return songRepository.findById(id).orElse(null);
    }

    @Override
    public void remove(Long id) {
        songRepository.deleteById(id);
    }

    @Override
    public void remove() {
        songRepository.deleteAll();
    }
}
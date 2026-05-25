package vn.codegym.zingmp3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import vn.codegym.zingmp3.model.Song;

import java.util.List;

public interface SongRepository extends JpaRepository<Song, Long> {
    Iterable<Song> findAllByNameContainingAndArtistContainingAndGenreContaining(String name, String artist, String genre);

    Iterable<Song> findAllByNameContainingAndArtistContaining(String name, String artist);

    Iterable<Song> findAllByNameContaining(String name);

    // JPQL query to search for songs based on name, artist, and genre
    @Query("select s from Song s where s.name like %:name% and s.artist like %:artist% and s.genre like %:genre%")
    List<Song> search(String name, String artist, String genre);

    // SQL native query to search for songs based on name, artist, and genre
    @Query(value = "select * from Song s where s.name like %?1% and s.artist like %?2% and s.genre like %?3%", nativeQuery = true)
    List<Song> searchNative(String name, String artist, String genre);
}

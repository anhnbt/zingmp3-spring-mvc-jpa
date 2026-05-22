package vn.codegym.zingmp3.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.codegym.zingmp3.model.Song;
import vn.codegym.zingmp3.service.ISongService;

import java.util.List;

@Controller
@RequestMapping("/songs")
public class SongController {

    private final ISongService songService;
    @Value("${file-upload}")
    private String uploadPath;

    public SongController(ISongService songService) {
        this.songService = songService;
    }

    @GetMapping
    public String listSongs(Model model) {
        List<Song> songs = songService.findAll();
        model.addAttribute("songs", songs);
        return "song/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("song", new Song());
        return "song/create";
    }

    @PostMapping("/create")
    public String createSong(@ModelAttribute("song") Song song) {
        if (song.getMp3File() != null && !song.getMp3File().isEmpty()) {
            try {
                // Lưu file MP3 vào thư mục "uploads"
                String fileName = song.getMp3File().getOriginalFilename();
                String filePath = uploadPath + fileName;
                song.getMp3File().transferTo(new java.io.File(filePath));
                song.setUrl(fileName);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        songService.save(song);
        return "redirect:/songs";
    }

    @PostMapping("/edit")
    public String editSong(@ModelAttribute("song") Song song) {
        songService.save(song);
        return "redirect:/songs";
    }

    @GetMapping("/{id}")
    public String showDetail(@PathVariable("id") Long id, Model model) {
        model.addAttribute("song", songService.findById(id));
        return "song/detail";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("song", songService.findById(id));
        return "song/edit";
    }

    @GetMapping("/{id}/delete")
    public String deleteSong(@PathVariable("id") Long id) {
        songService.remove(id);
        return "redirect:/songs";
    }
}

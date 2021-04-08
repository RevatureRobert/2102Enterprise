package dev.enterprise.controller;

import dev.enterprise.model.Album;
import dev.enterprise.repository.AlbumRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/hello")
public class AlbumController {

    @Autowired
    AlbumRepo repo;

    @GetMapping
    public @ResponseBody Page<Album> hello(@RequestParam("page") int page, @RequestParam("offset") int offset){
//        if(id != 0) {
//            return repo.findAll().get(0);
//        }
//        return repo.findAll().get(0);
        return repo.findAll(PageRequest.of(page, offset));
    }

    @PostMapping("/album")
    public @ResponseBody Album save(@RequestBody Album a){return repo.save(a);}

    @PostMapping("/artist")
    public @ResponseBody String saveString(@RequestBody String s){return s;}

    @GetMapping("/album")
    public @ResponseBody List<Album> getAllByName(@RequestParam("name") String name){
        return repo.findByName(name);
    }
}

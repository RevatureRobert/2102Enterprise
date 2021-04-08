package dev.enterprise.repository;

import dev.enterprise.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlbumRepo extends JpaRepository<Album, Integer> {

//    List<Album> findWhereNotNull();
    List<Album> findByName(String name);


}

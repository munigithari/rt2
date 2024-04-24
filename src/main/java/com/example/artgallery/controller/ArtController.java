/*
 * You can use the following import statements
 *
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.web.bind.annotation.*;
 * 
 * import java.util.ArrayList;
 * import java.util.List;
 * 
 */

// Write your code here
package com.example.artgallery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import com.example.artgallery.service.*;
import com.example.artgallery.model.*;

@RestController
public class ArtController {
    @Autowired
    private ArtJpaService service1;

    @GetMapping("/galleries/artists/arts")
    public List<Art> getArts() {
        return service1.getArts();
    }

    @GetMapping("/galleries/artists/arts/{artId}")
    public Art getArtById(@PathVariable("artId") int artId) {
        return service1.getArtById(artId);
    }

    /*
     * @PostMapping("/galleries/artists/arts")
     * public Art addArt(@RequestBody Art art) {
     * return service1.addArt(art);
     * }
     * 
     * @PutMapping("/galleries/artists/arts/{artId}")
     * public Art updateArt(@PathVariable("artId") int artId, @RequestBody Art art)
     * {
     * return service1.updateArt(artId, art);
     * }
     * 
     * @DeleteMapping("/galleries/artists/arts/{artId}")
     * public void deleteArt(@PathVariable("artId") int artId) {
     * service1.deleteArt(artId);
     * }
     * 
     * @GetMapping("arts/{artId}/artist")
     * public Artist getArtArtist(@PathVariable("artId") int artId) {
     * return service1.getArtArtist(artId);
     * }
     */
}

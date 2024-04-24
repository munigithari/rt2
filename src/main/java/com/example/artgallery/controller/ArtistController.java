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

import com.example.artgallery.model.Art;
import com.example.artgallery.model.Artist;
import com.example.artgallery.model.Gallery;
import com.example.artgallery.service.ArtistJpaService;;

@RestController
public class ArtistController {
    @Autowired
    private ArtistJpaService service2;

    @GetMapping("/galleries/artists")
    public List<Artist> getArtists() {
        return service2.getArtists();
    }

    @GetMapping("/galleries/artists/{artistId}")
    public Artist getArtistById(@PathVariable("artistId") int artistId) {
        return service2.getArtistById(artistId);
    }

    /*
     * @PostMapping("/galleries/artists")
     * public Artist addArtist(@RequestBody Artist artist) {
     * return service2.addArtist(artist);
     * }
     * 
     * @PutMapping("/galleries/artists/{artistId}")
     * public Artist updateArtist(@PathVariable("artistId") int
     * artistId, @RequestBody Artist artist) {
     * return service2.updateArtist(artistId, artist);
     * }
     * 
     * @DeleteMapping("/galleries/artists/{artistId}")
     * public void deleteArtist(@PathVariable("artistId") int artistId) {
     * service2.deleteArtist(artistId);
     * }
     * 
     * @GetMapping("/artists/{artistId}/arts")
     * public List<Art> getArtistArts(@PathVariable("artistId") int artistId) {
     * return service2.getArtistArts(artistId);
     * }
     * 
     * @GetMapping("artists/{artistId}/galleries")
     * public List<Gallery> getArtistGalleries(@PathVariable("artistId") int
     * artistId) {
     * return service2.getArtistGalleries(artistId);
     * }
     */
}
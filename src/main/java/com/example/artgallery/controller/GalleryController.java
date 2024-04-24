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

import com.example.artgallery.model.Artist;
import com.example.artgallery.model.Gallery;
import com.example.artgallery.service.GalleryJpaService;

@RestController
public class GalleryController {
    @Autowired
    private GalleryJpaService service3;

    @GetMapping("/galleries")
    public List<Gallery> getGallerys() {
        return service3.getGallerys();
    }

    @GetMapping("/galleries/{galleryId}")
    public Gallery getGalleryById(@PathVariable("galleryId") int galleryId) {
        return service3.getGalleryById(galleryId);
    }

    /*
     * @PostMapping("/galleries")
     * public Gallery addGallery(@RequestBody Gallery gallery) {
     * return service3.addGallery(gallery);
     * }
     * 
     * @PutMapping("/galleries/{galleryId}")
     * public Gallery updateGallery(@PathVariable("galleryId") int
     * galleryId, @RequestBody Gallery gallery) {
     * return service3.updateGallery(galleryId, gallery);
     * }
     * 
     * @DeleteMapping("/galleries/{galleryId}")
     * public void deleteGallery(@PathVariable("galleryId") int galleryId) {
     * service3.deleteGallery(galleryId);
     * }
     * 
     * @GetMapping("/galleries/{galleryId}/artists")
     * public List<Artist> getGalleryArtists(@PathVariable("galleryId") int
     * galleryId) {
     * return service3.getGalleryArtists(galleryId);
     * }
     */
}
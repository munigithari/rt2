/*
 * You can use the following import statements
 *
 * import java.util.ArrayList;
 * import java.util.List;
 * 
 */

// Write your code here

package com.example.artgallery.repository;

import java.util.*;

import com.example.artgallery.model.Artist;
import com.example.artgallery.model.Gallery;

public interface GalleryRepository {
    List<Gallery> getGallerys();

    Gallery getGalleryById(int galleryId);

    Gallery addGallery(Gallery gallery);

    Gallery updateGallery(int galleryId, Gallery gallery);

    void deleteGallery(int galleryId);

    List<Artist> getGalleryArtists(int galleryId);

}
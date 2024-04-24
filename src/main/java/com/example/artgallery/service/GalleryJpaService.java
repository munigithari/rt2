/*
 * You can use the following import statements
 *
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.http.HttpStatus;
 * import org.springframework.stereotype.Service;
 * import org.springframework.web.server.ResponseStatusException;
 * 
 * import java.util.*;
 *
 */

// Write your code here
package com.example.artgallery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

import com.example.artgallery.model.Artist;
import com.example.artgallery.model.Gallery;
import com.example.artgallery.repository.*;

@Service
public class GalleryJpaService implements GalleryRepository {

   @Autowired
   private ArtistJpaRepository repository2;

   @Autowired
   private GalleryJpaRepository repository3;

   @Override
   public List<Gallery> getGallerys() {
      List<Gallery> list = repository3.findAll();
      ArrayList<Gallery> arr = new ArrayList<>(list);
      return arr;
   }

   @Override
   public Gallery getGalleryById(int galleryId) {
      try {
         Gallery gallery = repository3.findById(galleryId).get();
         return gallery;
      } catch (Exception e) {
         throw new ResponseStatusException(HttpStatus.NOT_FOUND);
      }
   }

   @Override
   public Gallery addGallery(Gallery gallery) {
      List<Integer> artistIds = new ArrayList<Integer>();
      for (Artist artist : gallery.getArtists()) {
         artistIds.add(artist.getArtistId());
      }

      List<Artist> artists = repository2.findAllById(artistIds);

      if (artists.size() != artistIds.size()) {
         throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
      }

      gallery.setArtists(artists);
      return repository3.save(gallery);
   }

   @Override
   public List<Artist> getGalleryArtists(int galleryId) {
      try {
         Gallery gallery = repository3.findById(galleryId).get();
         return gallery.getArtists();
      } catch (Exception e) {
         throw new ResponseStatusException(HttpStatus.NOT_FOUND);
      }
   }

   @Override
   public Gallery updateGallery(int galleryId, Gallery gallery) {
      try {
         Gallery newGallery = repository3.findById(galleryId).get();
         if (gallery.getGalleryName() != null) {
            newGallery.setGalleryName(gallery.getGalleryName());
         }
         if (gallery.getLocation() != null) {
            newGallery.setLocation(gallery.getLocation());
         }
         if (gallery.getArtists() != null) {
            List<Artist> artists = newGallery.getArtists();
            for (Artist artist : artists) {
               artist.getGalleries().remove(newGallery);
            }
            repository2.saveAll(artists);
            List<Integer> listIds = new ArrayList<>();
            for (Artist artist : gallery.getArtists()) {
               listIds.add(artist.getArtistId());
            }

            List<Artist> newArtist = repository2.findAllById(listIds);
            for (Artist artist : newArtist) {
               artist.getGalleries().add(newGallery);
            }
            repository2.saveAll(newArtist);
            newGallery.setArtists(newArtist);
         }
         return repository3.save(newGallery);

      } catch (NoSuchElementException e) {
         throw new ResponseStatusException(HttpStatus.NOT_FOUND);
      }

   }

   @Override
   public void deleteGallery(int galleryId) {
      try {
         Gallery gallery = repository3.findById(galleryId).get();
         List<Artist> artists = gallery.getArtists();
         for (Artist artist : artists) {
            artist.getGalleries().remove(gallery);
         }
         repository2.saveAll(artists);
         repository3.deleteById(galleryId);
      } catch (Exception e) {
         throw new ResponseStatusException(HttpStatus.NOT_FOUND);
      }
      throw new ResponseStatusException(HttpStatus.NO_CONTENT);
   }

}
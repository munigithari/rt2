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

import com.example.artgallery.model.Art;
import com.example.artgallery.model.Artist;
import com.example.artgallery.model.Gallery;
import com.example.artgallery.repository.*;

@Service
public class ArtistJpaService implements ArtistRepository {

     @Autowired
     private ArtistJpaRepository repository1;

     @Autowired
     private ArtJpaRepository repository2;

     @Autowired
     private GalleryJpaRepository repository3;

     @Override
     public List<Artist> getArtists() {
          List<Artist> list = repository1.findAll();
          ArrayList<Artist> arrayList = new ArrayList<>(list);
          return arrayList;
     }

     @Override
     public Artist getArtistById(int artistId) {
          try {
               Artist artist = repository1.findById(artistId).get();
               return artist;
          } catch (Exception e) {
               throw new ResponseStatusException(HttpStatus.NOT_FOUND);
          }
     }

     @Override
     public Artist addArtist(Artist artist) {
          List<Integer> listIds = new ArrayList<>();
          for (Gallery gallery : artist.getGalleries()) {
               listIds.add(gallery.getGalleryId());
          }

          List<Gallery> gallery = repository3.findAllById(listIds);
          if (gallery.size() != listIds.size()) {
               throw new ResponseStatusException(HttpStatus.BAD_GATEWAY);
          }
          artist.setGalleries(gallery);
          return repository1.save(artist);
     }

     @Override
     public Artist updateArtist(int artistId, Artist artist) {
          try {
               Artist newArtist = repository1.findById(artistId).get();
               if (artist.getArtistName() != null) {
                    newArtist.setArtistName(artist.getArtistName());
               }
               if (artist.getGenre() != null) {
                    newArtist.setGenre(artist.getGenre());
               }
               if (artist.getGalleries() != null) {
                    List<Integer> galleryIds = new ArrayList<Integer>();
                    for (Gallery gallery : artist.getGalleries()) {
                         galleryIds.add(gallery.getGalleryId());
                    }
                    List<Gallery> gallerys = repository3.findAllById(galleryIds);
                    if (gallerys.size() != galleryIds.size()) {
                         throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
                    }
                    newArtist.setGalleries(gallerys);
               }
               return repository1.save(newArtist);
          } catch (NoSuchElementException e) {
               throw new ResponseStatusException(HttpStatus.NOT_FOUND);
          }

     }

     @Override
     public void deleteArtist(int artistId) {
          try {
               repository1.deleteById(artistId);
          } catch (Exception e) {
               throw new ResponseStatusException(HttpStatus.NOT_FOUND);
          }
          throw new ResponseStatusException(HttpStatus.NO_CONTENT);
     }

     @Override
     public List<Art> getArtistArts(int artistId) {
          try {
               Artist artist = repository1.findById(artistId).get();
               return repository2.findByArtist(artist);
          } catch (Exception e) {
               throw new ResponseStatusException(HttpStatus.NOT_FOUND);
          }
     }

     @Override
     public List<Gallery> getArtistGalleries(int artistId) {
          try {
               Artist artist = repository1.findById(artistId).get();
               return artist.getGalleries();
          } catch (Exception e) {
               throw new ResponseStatusException(HttpStatus.NOT_FOUND);
          }
     }
}

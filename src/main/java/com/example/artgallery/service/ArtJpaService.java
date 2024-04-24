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
import com.example.artgallery.repository.*;

@Service
public class ArtJpaService implements ArtRepository {
   @Autowired
   private ArtJpaRepository repository1;

   @Autowired
   private ArtistJpaRepository repository2;

   @Override
   public List<Art> getArts() {
      List<Art> list = repository1.findAll();
      ArrayList<Art> arryList = new ArrayList<>(list);
      return arryList;
   }

   @Override
   public Art getArtById(int artId) {
      try {
         Art art = repository1.findById(artId).get();
         return art;
      } catch (Exception e) {
         throw new ResponseStatusException(HttpStatus.NOT_FOUND);
      }
   }

   @Override
   public Art addArt(Art art) {
      try {
         int artistId = art.getArtist().getArtistId();
         Artist artist = repository2.findById(artistId).get();
         art.setArtist(artist);
         return repository1.save(art);
      } catch (Exception e) {
         throw new ResponseStatusException(HttpStatus.NOT_FOUND);
      }
   }

   @Override
   public Art updateArt(int artId, Art art) {
      try {
         Art newArt = repository1.findById(artId).get();
         if (art.getArtTitle() != null) {
            newArt.setArtTitle(art.getArtTitle());
         }
         if (art.getTheme() != null) {
            newArt.setTheme(art.getTheme());
         }
         if (art.getArtist() != null) {
            int artistId = art.getArtist().getArtistId();
            Artist artist = repository2.findById(artistId).get();
            newArt.setArtist(artist);
         }
         return repository1.save(newArt);
      } catch (Exception e) {
         throw new ResponseStatusException(HttpStatus.NOT_FOUND);
      }
   }

   @Override
   public void deleteArt(int artId) {
      try {
         repository1.deleteById(artId);
      } catch (Exception e) {
         throw new ResponseStatusException(HttpStatus.NOT_FOUND);
      }
      throw new ResponseStatusException(HttpStatus.NO_CONTENT);
   }

   @Override
   public Artist getArtArtist(int artId) {
      try {
         Art art = repository1.findById(artId).get();
         return art.getArtist();
      } catch (Exception e) {
         throw new ResponseStatusException(HttpStatus.NOT_FOUND);
      }
   }
}

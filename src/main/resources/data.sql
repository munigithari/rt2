INSERT INTO Artist(name, genre) VALUES('Leonardo da Vinci','Renaissance');
INSERT INTO Artist(name, genre) VALUES('Vincent van Gogh','Post-Impressionism');
INSERT INTO Artist(name, genre) VALUES('Pablo Picass','Cubism');
INSERT INTO Artist(name, genre) VALUES('Edward Hopper','American Modernism');

INSERT INTO Art(name, title, theme, artistId) VALUES('The Flight Study','Studies of Bird Wings',1);
INSERT INTO Art(name, title, theme, artistId) VALUES('Mona Lisa 2.0','Renaissance Portrait',1);
INSERT INTO Art(name, title, theme, artistId) VALUES('Starry Countryside','Night Landscape',2);
INSERT INTO Art(name, title, theme, artistId) VALUES('Sunflower Impressions','Floral',2);
INSERT INTO Art(name, title, theme, artistId) VALUES(' Cubist Self-Portrait','Abstract Portrait',3);
INSERT INTO Art(name, title, theme, artistId) VALUES('Barcelona Abstracted','City Landscape',3);
INSERT INTO Art(name, title, theme, artistId) VALUES('Downtown Solitude',' Urban Scene',4);
INSERT INTO Art(name, title, theme, artistId) VALUES('Night Cafe Redux','Modernist Interior',4);

INSERT INTO Gallery(name, location) VALUES('Louvre Museum','Paris');
INSERT INTO Gallery(name, location) VALUES('Van Gogh Museum','Amsterdam');
INSERT INTO Gallery(name, location) VALUES('Museo Picasso','Barcelona');
INSERT INTO Gallery(name, location) VALUES('Whitney Museum of American Art','New York');

INSERT INTO artist_gallery(artistId, galleryId) VALUES(1,1);
INSERT INTO artist_gallery(artistId, galleryId) VALUES(1,2);
INSERT INTO artist_gallery(artistId, galleryId) VALUES(2,2);
INSERT INTO artist_gallery(artistId, galleryId) VALUES(3,3);
INSERT INTO artist_gallery(artistId, galleryId) VALUES(3,4);
INSERT INTO artist_gallery(artistId, galleryId) VALUES(4,4);

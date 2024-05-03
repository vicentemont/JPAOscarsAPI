package io.vicente.app.rest.persistence;

import io.vicente.app.rest.model.Oscar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OscarRepo extends JpaRepository <Oscar,Long > {
    @Query("SELECT o FROM Oscar o JOIN o.movies m WHERE m.title LIKE %:title%")
    List<Oscar> findByMovieTitle(@Param("title") String title);

    @Query("SELECT o FROM Oscar o JOIN o.movies m WHERE m.tmdb_id LIKE %:tmdb_id%")
    List<Oscar> findByMovieTMDBId(@Param("tmdb_id") String tmdb_id );

    @Query("SELECT o FROM Oscar o JOIN o.movies m WHERE m.imdb_id LIKE %:imdb_id%")
    List<Oscar> findByMovieIMDBId(@Param("imdb_id") String imdb_id );

    @Query("SELECT o FROM Oscar o WHERE o.category LIKE %:category%")
    List<Oscar> findByCategory(@Param("category") String category );

    @Query("SELECT o FROM Oscar o WHERE o.year = %:year%")
    List<Oscar> findByYear(@Param("year") String year );
}

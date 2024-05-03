package io.vicente.app.rest.persistence;

import io.vicente.app.rest.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepo extends JpaRepository <Movie,Long > {
}

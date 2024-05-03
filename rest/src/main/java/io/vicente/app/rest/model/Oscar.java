package io.vicente.app.rest.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Oscar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String category;
    @Column
    private String year;
    @ElementCollection
    private List<String> nominees;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Movie> movies;
    @Column
    private Boolean won;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public List<String> getNominees() {
        return nominees;
    }

    public void setNominees(List<String> nominees) {
        this.nominees = nominees;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> Movies) {
        this.movies = Movies;
    }

    public boolean isWon() {
        return won;
    }

    public void setWon(boolean won) {
        this.won = won;
    }
}



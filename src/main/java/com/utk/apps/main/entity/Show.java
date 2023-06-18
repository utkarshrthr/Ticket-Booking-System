package com.utk.apps.main.entity;

import com.utk.apps.main.status.Feature;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "shows")
public class Show extends EntityMaster {

    @ManyToOne
    private Auditorium auditorium;

    private LocalDateTime startAt;
    private LocalDateTime endAt;

    @ManyToOne
    private Movie movie;

    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private List<Feature> features;

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Auditorium getAudi() {
        return auditorium;
    }

    public void setAudi(Auditorium auditorium) {
        this.auditorium = auditorium;
    }

    public LocalDateTime getStartAt() {
        return startAt;
    }

    public void setStartAt(LocalDateTime startAt) {
        this.startAt = startAt;
    }

    public LocalDateTime getEndAt() {
        return endAt;
    }

    public void setEndAt(LocalDateTime endAt) {
        this.endAt = endAt;
    }

    public List<Feature> getFeatures() {
        return features;
    }


    public void setFeatures(List<Feature> features) {
        this.features = features;
    }
}

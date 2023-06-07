package com.fooddelivery.model;

import java.util.Objects;
import java.util.UUID;

public class Review {
    private Double stars;
    private String message;
    private UUID reviewId;

    public Review(Double stars, String message) {
        this.stars = stars;
        this.message = message;
        this.reviewId = UUID.randomUUID();
    }

    public Double getStars() {
        return stars;
    }

    public String getMessage() {
        return message;
    }

    public void setStars(Double stars) {
        this.stars = stars;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review = (Review) o;
        return Objects.equals(stars, review.stars) && Objects.equals(message, review.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stars, message);
    }

}

package com.personal.nextlevel.models;

import javax.persistence.*;

@Entity
@Table(name = "reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String reviewTitle;

    @Column(nullable = true, length = 2500)
    private String reviewBody;

    public Review(){}

    public Review(Long id, String reviewTitle, String reviewBody){
        this.id = id;
        this.reviewTitle = reviewTitle;
        this.reviewBody = reviewBody;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReviewTitle() {
        return reviewTitle;
    }

    public void setReviewTitle(String reviewTitle) {
        this.reviewTitle = reviewTitle;
    }

    public String getReviewBody() {
        return reviewBody;
    }

    public void setReviewBody(String reviewBody) {
        this.reviewBody = reviewBody;
    }
}

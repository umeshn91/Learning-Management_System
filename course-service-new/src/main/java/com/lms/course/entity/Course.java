package com.lms.course.entity;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Size(min = 20)
    @NotBlank(message = "Name is mandatory")
    @Column(name = "courseName")
    private String courseName;
    @Min(1)
    @NotNull(message = "Duration is mandatory")
    private long duration;
    @Transient
    @Column(insertable = false, updatable = false)
    private long durationFrom;
    @Transient
    @Column(insertable = false, updatable = false)
    private long durationTo;
    @Size(min = 100)
    @NotBlank(message = "Description is mandatory")
    private String description;
    @NotBlank(message = "Technology is mandatory")
    private String technology;
    @NotBlank(message = "URL is mandatory")
    private String launchURL;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public long getDurationFrom() {
        return durationFrom;
    }

    public void setDurationFrom(long durationFrom) {
        this.durationFrom = durationFrom;
    }

    public long getDurationTo() {
        return durationTo;
    }

    public void setDurationTo(long durationTo) {
        this.durationTo = durationTo;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

    public String getLaunchURL() {
        return launchURL;
    }

    public void setLaunchURL(String launchURL) {
        this.launchURL = launchURL;
    }
}

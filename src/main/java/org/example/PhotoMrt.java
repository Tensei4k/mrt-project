package org.example;

import jakarta.persistence.*;

@Entity
@Table(name = "photo_mrt")
public class PhotoMrt {
    @Id
    private String namePhoto;

    @Column(nullable = false)
    private String description;

    @Lob
    private byte[] photoMrt;

    public PhotoMrt(String namePhoto, String description, byte[] photoMrt) {
        this.namePhoto = namePhoto;
        this.description = description;
        this.photoMrt = photoMrt;
    }

    public PhotoMrt() {

    }

    public void setNamePhoto(String namePhoto) {
        this.namePhoto = namePhoto;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPhotoMrt(byte[] photoMrt) {
        this.photoMrt = photoMrt;
    }

    public String getNamePhoto() {
        return namePhoto;
    }

    public String getDescription() {
        return description;
    }

    public byte[] getPhotoMrt() {
        return photoMrt;
    }
}

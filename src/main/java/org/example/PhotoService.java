package org.example;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
@Transactional
public class PhotoService {
    private final PhotoRepository photoRepository;

    public PhotoService(PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }

    public String getDescription(String photoId) {
        PhotoMrt photoMrt = photoRepository.findById(photoId).orElse(null);
        if (photoMrt != null) {
            return photoMrt.getDescription();
        }
        return null;
    }

    public byte[] getImage(String photoId) {
        PhotoMrt photoMrt = photoRepository.findById(photoId).orElse(null);
        if (photoMrt != null) {
            return photoMrt.getPhotoMrt();
        }
        return null;
    }

    public void savePhoto(String photoId, String description, String image) {
        PhotoMrt photoMrt = new PhotoMrt(photoId, description,  Base64.getDecoder().decode(image));
        photoRepository.save(photoMrt);
    }

    public void savePhoto2(String photoId, String description, byte[] image) {
        PhotoMrt photoMrt = new PhotoMrt(photoId, description, image );
        photoRepository.save(photoMrt);
    }

}

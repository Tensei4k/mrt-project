package org.example;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.OffsetDateTime;

@RestController
@RequestMapping("/api")
public class MyController {

    private final PhotoService photoService;
    private final UserService userService;
    private final RegisterService registerService;

    public MyController(PhotoService photoService,
                        UserService userService,
                        RegisterService registerService) {
        this.photoService = photoService;
        this.userService = userService;
        this.registerService = registerService;
    }


    @PostMapping("/save2")
    public void saveMrt2(@RequestParam("photoName") String photoName, @RequestParam("description") String description, @RequestParam("imagData") MultipartFile imagData) throws IOException {
        photoService.savePhoto2(photoName, description, imagData.getBytes());
    }

    @GetMapping("/description")
    public String getDescription(@RequestParam("photoName") String photoName) {
        return photoService.getDescription(photoName);
    }

    @GetMapping("/photo")
    public ResponseEntity<InputStreamResource> getPhoto(@RequestParam("photoName") String photoName) {
        MediaType contentType = MediaType.IMAGE_JPEG;
        byte[] photoServiceImage = photoService.getImage(photoName);
        if (photoServiceImage == null) {
            return null;
        }
        InputStream in = new ByteArrayInputStream(photoServiceImage);


        return ResponseEntity.ok()
                .contentType(contentType)
                .body(new InputStreamResource(in));
    }

    @PostMapping("/save-user")
    public User saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam("date") String date, @RequestParam("doctorName") String doctorName, @RequestParam("patientName") String patientName) {
        return registerService.saveRegister(OffsetDateTime.parse(date), doctorName, patientName);
    }
}

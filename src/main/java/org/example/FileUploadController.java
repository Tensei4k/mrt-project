package org.example;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@RestController
@RequestMapping("/api/upload")
public class FileUploadController {

    @PostMapping("/jpeg")
    public String uploadJpegFile(@RequestParam("file") MultipartFile file) throws IOException {
        // Проверяем, что файл не пустой
        if (file.isEmpty()) {
            return "Файл не выбран!";
        }

        // Проверяем, что файл JPEG (по MIME-типу или расширению)
        if (!file.getContentType().equals("image/jpeg")) {
            return "Только JPEG-файлы разрешены!";
        }

        // Получаем оригинальное имя файла
        String fileName = file.getOriginalFilename();

        // Сохраняем файл на сервер (пример)
        Files.copy(file.getInputStream(), Path.of("src/main/resources/uploads/" + fileName));

        return "Файл " + fileName + " успешно загружен! (Размер: " + file.getSize() + " байт)";
    }
}
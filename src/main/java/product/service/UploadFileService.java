package product.service;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public class UploadFileService {
    public void uploadFile(MultipartFile file) throws IOException {
String folderUpload="C:\\Users\\84336\\IdeaProjects\\module_4_product_2112\\src\\main\\webapp\\uploadFIle\\";
String fileName= file.getOriginalFilename();
        FileCopyUtils.copy(file.getBytes(),new File(folderUpload+fileName));
    }
}

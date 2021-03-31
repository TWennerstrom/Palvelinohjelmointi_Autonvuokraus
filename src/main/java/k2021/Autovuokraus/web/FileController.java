package k2021.Autovuokraus.web;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import k2021.Autovuokraus.domain.FileModel;
import k2021.Autovuokraus.domain.FileModelRepository;

@Controller
public class FileController {
	
	@Autowired
	private FileModelRepository fileRepository;

    @Value("${upload.path}")
    private String uploadFolder;
    
    @GetMapping("/up")
    public String index() {
        return "upload";
    }

    @PostMapping("/upload")
    public String fileUpload(@RequestParam("file") MultipartFile file, Model model) {
        if (file.isEmpty()) {
        	model.addAttribute("msg", "Upload failed");
            return "uploadstatus";
        }

        try {
            FileModel fileModel = new FileModel(file.getOriginalFilename(), file.getContentType(), file.getBytes());
            fileRepository.save(fileModel);
    
            return "redirect:/files";
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "uploadstatus";
    }
}
package com.fabio.test.consoftDemo.services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class UploadFileService {

    private final String cartellaRoot = Paths.get(System.getProperty("user.home")).toString();

    public void uploadFileToFileSystem(MultipartFile[] files, String prefix)
    {
        try
        {
            String path = this.cartellaRoot + "\\" + prefix + "\\";
            File nomeDir = new File(path);
            if(!nomeDir.exists())
            {
                nomeDir.mkdir();
            }

            Path cartellaSalvataggio = Paths.get(path);

            for (MultipartFile f: files)
            {
                Files.copy(f.getInputStream(), cartellaSalvataggio.resolve(f.getOriginalFilename()));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}

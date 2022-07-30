package com.miranda.sqsfila.aws.s3;


import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.util.IOUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Service
@Slf4j
public class AmazonS3BucketService {
    @Value("${cloud.aws.end-point-s3.uri}")
    private String bucketName;
    @Autowired
    private AmazonS3 s3Client;
    public String uploadArquivo(MultipartFile file) {
        File fileObj = convertMultiPartFileToFile(file);
        String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
        s3Client.putObject(new PutObjectRequest(bucketName, fileName, fileObj));
        fileObj.delete();
        return "Upload do arquivo  : " + fileName;
    }
    public byte[] downloadArquivo(String fileName) {
        S3Object s3Object = s3Client.getObject(bucketName, fileName);
        S3ObjectInputStream inputStream = s3Object.getObjectContent();
        try {
            byte[] content = IOUtils.toByteArray(inputStream);
            return content;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public String excluirArquivos(String fileName) {
        s3Client.deleteObject(bucketName, fileName);
        return fileName + " deletado!";
    }


    private File convertMultiPartFileToFile(MultipartFile file) {
        File converted = new File(file.getOriginalFilename());
        try (FileOutputStream fileOut = new FileOutputStream(converted)) {
            fileOut.write(file.getBytes());
        } catch (IOException e) {
            log.error("Erro ao converter arquivo!", e);
        }
        return converted;
    }

}

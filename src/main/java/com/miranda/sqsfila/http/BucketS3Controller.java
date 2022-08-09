package com.miranda.sqsfila.http;

import com.miranda.sqsfila.aws.s3.AmazonS3BucketService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("/s3")
@RestController
public class BucketS3Controller {

    @Autowired
    private AmazonS3BucketService service;
    @ApiOperation(value = "[S3] - Realiza o upload de um arquivo no bucket.")
    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam(value = "file") MultipartFile file) {
        return new ResponseEntity<>(service.uploadArquivo(file), HttpStatus.OK);
    }

    @ApiOperation(value = "[S3] - Realiza o download de um arquivo pelo seu nome. ")
    @GetMapping("/download/{fileName}")
    public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable String fileName) {
        byte[] data = service.downloadArquivo(fileName);
        ByteArrayResource resource = new ByteArrayResource(data);
        return ResponseEntity
                .ok()
                .contentLength(data.length)
                .header("Content-type", "application/octet-stream")
                .header("Content-disposition", "attachment; filename=\"" + fileName + "\"")
                .body(resource);
    }

    @ApiOperation(value = "[S3] - Realiza a exclusão de um arquivo pelo seu nome.")
    @DeleteMapping("/delete/{fileName}")
    public ResponseEntity<String> deleteFile(@PathVariable String fileName) {
        return new ResponseEntity<>(service.excluirArquivos(fileName), HttpStatus.OK);
    }
}

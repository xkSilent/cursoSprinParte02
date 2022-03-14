package com.app01.services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.app01.services.exceptions.FileException;

@Service
public class S3Service {
	
	private Logger LOG = LoggerFactory.getLogger(S3Service.class);
	
	@Autowired
	private AmazonS3 s3client;
	
	@Value("${s3.bucket}")
	private String bucketName;
	
	public URI uploadFile(MultipartFile multipartFile) {
		try {
			String fileName = multipartFile.getOriginalFilename();
			InputStream is = multipartFile.getInputStream();
			long contentLength = multipartFile.getSize();
			String contentType = multipartFile.getContentType();
			return uploadFile(is, fileName, contentType,contentLength);
		} catch (IOException e) {
			throw new FileException("Erro de IO: " + e.getMessage());
		}
	}
	
	public URI uploadFile(InputStream is, String fileName, String contentType, long contentLength) {
		try {
			ObjectMetadata meta = new ObjectMetadata();
			meta.setContentType(contentType);
			meta.setContentLength(contentLength);
			LOG.info("Enviando Arquivo");
			s3client.putObject(bucketName, fileName, is, meta);
			LOG.info("Arquivo enviado com sucesso !");
			return s3client.getUrl(bucketName, fileName).toURI();
		}catch(URISyntaxException e) {
			throw new FileException("Erro ao converter URL para URI ");
		}
	}
	
/**	public String uploadFile(MultipartFile file) {
        File fileObj = convertMultiPartFileToFile(file);
        String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
        s3client.putObject(new PutObjectRequest(bucketName, fileName, fileObj));
        //fileObj.delete();
        return "File uploaded : " + fileName;
    }
	
	private File convertMultiPartFileToFile(MultipartFile file) {
        File convertedFile = new File(file.getOriginalFilename());
        try (FileOutputStream fos = new FileOutputStream(convertedFile)) {
            fos.write(file.getBytes());
        } catch (IOException e) {
            LOG.error("Error converting multipartFile to file", e);
        }
        return convertedFile;
    }
	*/

}

package com.arcosa.bafar.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;


import org.springframework.web.multipart.MultipartFile;

public interface IUploadFileService {

	public String load(String filename) throws MalformedURLException;

	public Path cargaExcel(MultipartFile file) throws IOException;


}

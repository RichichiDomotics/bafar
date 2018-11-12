package com.arcosa.bafar.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadFileServiceImpl implements IUploadFileService {

	private final Logger log = LoggerFactory.getLogger(getClass());

	private final static String UPLOADS_FOLDER = "/root/carnemart/uploads";
	//private final static String UPLOADS_FOLDER = "C:/carnemart/uploads";
	//private final static String UPLOADS_FOLDER = "uploads";

	@Override
	public String load(String filename) throws MalformedURLException {
		Path pathFoto = getPath(filename);
		log.info("pathFoto: " + pathFoto.toString());

		
		return pathFoto.toString();
	}

	@Override
	public Path cargaExcel(MultipartFile file) throws IOException {
		String uniqueFilename =file.getOriginalFilename();
		Path rootPath = getPath(uniqueFilename);

		

		return rootPath;
	}

	
	public Path getPath(String filename) {
		return Paths.get(UPLOADS_FOLDER).resolve(filename).toAbsolutePath();
	}

	
}

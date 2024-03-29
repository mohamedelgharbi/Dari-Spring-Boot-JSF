package tn.esprit.spring.service;

import org.springframework.boot.context.properties.ConfigurationProperties;
import tn.esprit.spring.utility.AppConstants;

@ConfigurationProperties(prefix = AppConstants.FILE_PROPERTIES_PREFIX)
public class FileStorageProperties {
	private String uploadDir;

	public String getUploadDir() {
		return uploadDir;
	}

	public void setUploadDir(String uploadDir) {
		this.uploadDir = uploadDir;
	}
}
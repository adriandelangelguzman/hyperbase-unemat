package br.colider.unemat.servlets.controller;

import org.apache.commons.logging.impl.SimpleLog;

import com.missiondata.fileupload.OutputStreamListener;

public class FileUploadListener implements OutputStreamListener {
	

	private SimpleLog log;
	private long totalFileSize;
	private long currentFileRead;

	public FileUploadListener(long totalFileSize) {
		this.totalFileSize = totalFileSize;
		this.currentFileRead = 0;
		log = new SimpleLog("loguploadfile");
	}

	public void start() {
		log.debug("Upload started. Total file size: " + totalFileSize);
	}

	public void bytesRead(int byteCount) {
		log.debug("Read bytes. Currently " + byteCount + " out of "
				+ totalFileSize + " bytes.");
		currentFileRead += byteCount;
	}

	public void error(String error) {
		log.debug("Hit an error: " + error);
	}

	public void done() {
		log.debug("Upload done.");
	}

	public long getTotalRead() {
		return currentFileRead;
	}

	public long getTotalSize() {
		return totalFileSize;
	}
}

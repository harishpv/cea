package com.app.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.app.responsePojos.DownloadLinks;
import com.app.responsePojos.File;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

@Component
public class HttpUtils implements Constants {

	private static final String USER_AGENT = "Mozilla/5.0";

	private static String sendGET(String url) throws IOException {
		StringBuffer response = null;
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("Authorization", ASSNMNT_HEADER);
		con.setRequestProperty("accept", "application/json");
		int responseCode = con.getResponseCode();
		System.out.println("GET Response Code :: " + responseCode);
		if (responseCode == HttpURLConnection.HTTP_OK) { // success
			BufferedReader in = new BufferedReader(new InputStreamReader(
					con.getInputStream()));
			String inputLine;
			response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

		} else {
			System.out.println("GET request not worked");
		}
		return response == null ? "" : response.toString();

	}

	private String sendPOST(String url, String params, MultipartFile file) throws IOException {
		return "";
	}
	
	@SuppressWarnings("unchecked")
	public List<File> getFilesAndFolders(String path) throws UnsupportedEncodingException, IOException {
		Gson gson = new Gson();
		List<File> files = new ArrayList<>();
		try {
			files = gson.fromJson(sendGET(ASSNMNT_URL + GET_FOLDERS_FILES + "?path=" + URLEncoder.encode(path, "UTF-8")), ArrayList.class);
		} catch (Throwable t) {
			Logging.getErrorLog().error("Exception getting folder contents", t);
		}
		return files;
	}
	
	public DownloadLinks getDownloadLinks(String id) throws JsonSyntaxException, IOException {
		Gson gson = new Gson();
		DownloadLinks links = null;
		try {
			links = gson.fromJson(sendGET(ASSNMNT_URL + GET_FILES + "/" + id + "/links"), DownloadLinks.class);
		} catch (Throwable t) {
			Logging.getErrorLog().error("Exception downloading contents", t);
		}
		return links;
	}
	
	public File uploadFile(String path, MultipartFile mfile)  {
		Gson gson = new Gson();
		File file = null;
		try {
			file = gson.fromJson(sendPOST(ASSNMNT_URL + GET_FILES, "path=" + URLEncoder.encode(path, "UTF-8"), mfile), File.class);
		} catch (Throwable t) {
			Logging.getErrorLog().error("Exception downloading contents", t);
		}
		return file;
	}
}

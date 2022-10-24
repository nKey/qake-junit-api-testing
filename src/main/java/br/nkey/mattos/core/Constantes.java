package br.nkey.mattos.core;

import io.restassured.http.ContentType;

public interface Constantes {
	String APP_BASE_URL = "https://jsonplaceholder.typicode.com";
	Integer APP_PORT = 443; // HTTP -> 80
	String APP_BASE_PATH = "";
	ContentType APP_CONTENT_TYPE = ContentType.JSON;
	Long MAX_TIMEOUT = 52634L;
	}

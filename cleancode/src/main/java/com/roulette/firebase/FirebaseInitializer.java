package com.roulette.firebase;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.annotation.PostConstruct;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

public class FirebaseInitializer {

	@PostConstruct
    public void initialize() {
				try {
					FileInputStream serviceAccount =new FileInputStream("./masiv-assesment-firebase-adminsdk-ml18z-001d32a409.json");
					FirebaseOptions options;
					options = new FirebaseOptions.Builder().setCredentials(GoogleCredentials.fromStream(serviceAccount)).build();
					FirebaseApp.initializeApp(options);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    }
}
package com.roulette.cleancode.firebase;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.annotation.PostConstruct;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

@Service
public class FirebaseInitializer {

	@PostConstruct
	private void initDB() throws IOException {
		//InputStream serviceAccount = this.getClass().getClassLoader()
				//.getResourceAsStream("./clappauth-firebase-adminsdk-gyzjx-aa03b4f0bf.json");

		InputStream serviceAccount;
		try {
			
			serviceAccount = createFirebaseCredential();
			FirebaseOptions options = new FirebaseOptions.Builder()
					.setCredentials(GoogleCredentials.fromStream(serviceAccount))
					.setDatabaseUrl("https://masiv-assesment.firebaseapp.com").build();

			if (FirebaseApp.getApps().isEmpty()) {
				FirebaseApp.initializeApp(options);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public Firestore getFirebase() {
		return FirestoreClient.getFirestore();
	}
	
	
	private InputStream createFirebaseCredential() throws Exception {
	    //private key
	    String privateKey = "-----BEGIN PRIVATE KEY-----\\nMIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQDHf0U1dyfgsET1\\niHog5SyHppuAjNwnFMs4Yn3WToNsxzdHmhDSd8w9UgkqSPpJcsn7WD8f4Yhwtt48\\nRzFVoguf9R43GQQOB0MvNSZXQJOb4kAwGOUkIUwpOU2GkAtiUYIfaKIz7GIMrQVm\\nPaIThOMKd12+NDhRlOxJpGU6QgXNf8nP2NWZDc8n5tiu/rlu0gLmYuH7Vsh1huzG\\nNs8SrtyUITzBWzTaitHO1SlLOP8r6uikSAxjLWnKxRLUizEmPA2EKueyFgIC420Q\\nb1RvTDhW0lUT+ubHOCLtcjmM5qXI4qQYCmw65QKdrzzhuUKkFf5o21qOBEaKO7p6\\nOtjLmwvzAgMBAAECggEAGdVv+j3KkDIYpqMHDajKXMFFHx8eiIEM1T8L2etONuaP\\n+1mxa/p6HEa59nEqLXC2mdxnmufzFIWEadHeSvSHr4MSZ+15X50Dz40rwIjAP04h\\nJG6qMu+M6UReYa/YNDcnM+IHfynRLfW0iUovPs/VMXnGTecn6TNGaz2P+OdWe7HM\\nvXyP/aSb6oaNP5arxXR7m01jHV7u8Os56lEFojetvCDIGDc5MhAW+UfH0v4IhlXI\\n9ubfEblBw6232LXuzoxg9hEX0Mu874h+esr6C9/0+YLZWcp8zyQhB1CwcCTVUkml\\nuC2qpfpn7cYTaQGIZ+XNTZF4+7IjQKA88auEFawyoQKBgQDnv7CnY3N4u5hZVfc+\\nfV1k2eBkyHXiYkEjZLf4nH95+9sXyHXC7JhXhmGCuREYuYJALyhsUhzgz/Q2C3VR\\nc4xhsiSfJ+Sq6v/KbqNaxFw1qNVR1+Ph6AWCupSMQAiawiwvvRQ+OvqO7ViKQxp8\\nFRpC2wAUgXDaAYQ1IWi/aBWblwKBgQDcX5egKprQPDWl+Yyq9kY2NRoV6UEiuz8G\\nTsj28S2oOKz66Y2FmTSHHLCXPnE8WHpLpjyvX1ztn0AqVjQsizb8YzyvNGB3SpA9\\nI2wGfggoM2c6RssV9NkXToaRZxe26Z/kEk1+DE/ejD25xCg+u5nhqVLPkO0Q1GLP\\nfsZDBVFOBQKBgQDI7JVISx0uK9cmfTXjY+W5Ln0yY+pw4CcBfK1USrrrE8UclZwj\\n5+Uc3VFlePatrQiUhU5Su851y1Y8FSsd90Ra34yIwJms5hnndI0EgQJBM6PfVYIp\\ntnQwp3trLYlIQ9jzesc2PQRHLth45zzrH5CpLh6fqKojGPV66wBaEu/I+QKBgQCn\\n6RIv0KabCXVbHHSpAvLmdLmGfm7J1uAjnz4SohtGtMBggjn51I0ocZy/8Kz47PVp\\n1KUifsfgqlmKqJoiYoSn87kWShNCcYbLfsTdgYQXlWsPBUfSV/hdgNCZ03JHRWU1\\nsxhmdV0Z1cNmWubLPcf3IDvfua5YB2uubAsGn/OePQKBgQDh4U+BHzf/lGau2qbh\\nK8KayvPdtKixfxt+9gWAHAliaMbWrXzPudOR43D+WwQdR37DF4JSQg5SR3AerU+0\\n7eII/poKKXDRs/uNw7y4hkoGAe81n2uV82bvZT35atqK+2va5wlx/2b3mBina/MV\\nPvqfNCq10brFYZAx+cLlDySDXw==\\n-----END PRIVATE KEY-----\\n".replace("\\n", "\n");

	    FirebaseCredential firebaseCredential = new FirebaseCredential();
	    firebaseCredential.setType("service_account");
	    firebaseCredential.setProject_id("masiv-assesment");
	    firebaseCredential.setPrivate_key_id("001d32a4094cc7fae0c1b3a5d380e80739fbb6db");
	    firebaseCredential.setPrivate_key(privateKey);
	    firebaseCredential.setClient_email("firebase-adminsdk-ml18z@masiv-assesment.iam.gserviceaccount.com");
	    firebaseCredential.setClient_id("110504770709365649537");
	    firebaseCredential.setAuth_uri("https://accounts.google.com/o/oauth2/auth");
	    firebaseCredential.setToken_uri("https://oauth2.googleapis.com/token");
	    firebaseCredential.setAuth_provider_x509_cert_url("https://www.googleapis.com/oauth2/v1/certs");
	    firebaseCredential.setClient_x509_cert_url( "https://www.googleapis.com/robot/v1/metadata/x509/firebase-adminsdk-ml18z%40masiv-assesment.iam.gserviceaccount.com");
	    //serialization of the object to json string
	    ObjectMapper mapper = new ObjectMapper();
	    String jsonString = mapper.writeValueAsString(firebaseCredential);

	    //convert jsonString string to InputStream using Apache Commons
	    return IOUtils.toInputStream(jsonString);
	}
}
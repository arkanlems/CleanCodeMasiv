package com.roulette.cleancode.services;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.SetOptions;
import com.google.cloud.firestore.WriteResult;
import com.roulette.cleancode.firebase.FirebaseInitializer;
import com.roulette.cleancode.models.Roulette;


@RestController
@RequestMapping("/roulette")
public class RouletteService {
	@Autowired
	FirebaseInitializer db;
	
	@PostMapping("/create")
	public String createRoulette() {
		Roulette newRoulette = new Roulette();
		DocumentReference addedDocRef = db.getFirebase().collection("roulettes").document();
		System.out.println("Added Roulette with ID: " + addedDocRef.getId());
		newRoulette.setId(addedDocRef.getId());
		ApiFuture<WriteResult> writeResult = addedDocRef.set(newRoulette);
		return newRoulette.getId();
	}
	
	@PostMapping("/open/{rouletteId}")
	public boolean openRoulette(@PathVariable String rouletteId) {
		Map<String, Object> update = new HashMap<>();
		update.put("open", true);
		ApiFuture<WriteResult> future = db.getFirebase().collection("roulettes").document(rouletteId).set(update,SetOptions.merge());
		
		try {
			WriteResult result = future.get();
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
}

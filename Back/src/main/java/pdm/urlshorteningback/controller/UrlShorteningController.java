package pdm.urlshorteningback.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import pdm.urlshorteningback.entity.GetShortenURLDto;

@Controller
public class UrlShorteningController {

	@PostMapping("/generate")
	public ResponseEntity<?> getShortenURL(@RequestBody GetShortenURLDto dto){
		return null;
	}


}

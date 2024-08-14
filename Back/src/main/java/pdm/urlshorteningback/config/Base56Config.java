package pdm.urlshorteningback.config;

import java.util.Random;

import org.springframework.context.annotation.Configuration;

@Configuration
public class Base56Config {

	private final String BASE56 = "23456789ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnpqrstuvwxyz";
	private final int SHORTEN_KEY_LENGTH = 8;

	public String createShortenKey(String input) {
		StringBuilder shortenKeyBuilder = new StringBuilder();
		Random random = new Random();

		for(int i = 0; i < SHORTEN_KEY_LENGTH; i++){
			int index = random.nextInt(BASE56.length());
			shortenKeyBuilder.append(BASE56.charAt(index));
		}

		return shortenKeyBuilder.toString();
	}
}

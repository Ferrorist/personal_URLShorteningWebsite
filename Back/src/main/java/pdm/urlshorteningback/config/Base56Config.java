package pdm.urlshorteningback.config;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.Random;

import org.springframework.context.annotation.Configuration;

@Configuration
public class Base56Config {

	private static final String BASE56_CHARS = "23456789ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnpqrstuvwxyz";
	private static final int length = 8;

	public String generateShortenUrlKey(){
		Random random = new Random();
		StringBuilder urlkey = new StringBuilder();

		for(int i = 0; i < length; i++){
			int index = random.nextInt(0, BASE56_CHARS.length());
			urlkey.append(BASE56_CHARS.charAt(index));
		}

		return urlkey.toString();
	}
}

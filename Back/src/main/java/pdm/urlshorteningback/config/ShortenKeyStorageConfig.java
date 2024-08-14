package pdm.urlshorteningback.config;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.springframework.context.annotation.Configuration;

@Configuration
public class ShortenKeyStorageConfig {

	private ConcurrentMap<String, String> storage;

	public ShortenKeyStorageConfig() {
		this.storage = new ConcurrentHashMap<>();
	}


	public void save(String shortenKey, String inputURL) {
		if(shortenKey.length() != 8) {
			throw new IllegalArgumentException("단축 URL Key는 8자리여야 합니다.");
		}
		if(storage.containsKey(shortenKey)){
			throw new IllegalArgumentException("이미 존재하는 단축 URL Key입니다.");
		}

		storage.put(shortenKey, inputURL);
	}

	public String getOriginalURL(String shortenKey) {
		if(!storage.containsKey(shortenKey)){
			throw new IllegalArgumentException("존재하지 않는 단축 URL Key입니다.");
		}

		else return storage.get(shortenKey);
	}


	public void clear() {
		storage.clear();
	}
}

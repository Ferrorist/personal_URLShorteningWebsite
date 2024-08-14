package pdm.urlshorteningback.config;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
public class ShorteningKeyTest {

	@Autowired
	private Base56Config base56Config;

	@Autowired
	private ShortenKeyStorageConfig shortenKeyStorage;

	private final String inputURL = "https://www.naver.com";

	@Test
	public void 단축Key생성() {
		// When
		String shortenKey = base56Config.createShortenKey(inputURL);

		// Then
		Assert.notNull(shortenKey, "생성된 key는 null이 될 수 없습니다.");
		Assert.hasLength(shortenKey, "생성된 key의 길이는 0이 될 수 없습니다.");
		Assert.isTrue(shortenKey.length() == 8, "생성된 단축 URL Key는 8자리여야 합니다.");
	}

	@Test
	public void 단축Key저장() {
		// Given
		String shortenKey = base56Config.createShortenKey(inputURL);

		// When
		shortenKeyStorage.save(shortenKey,inputURL);

		// Then
		Assertions.assertEquals(inputURL, shortenKeyStorage.getOriginalURL(shortenKey));
	}

	@BeforeEach
	void setUp() {
		shortenKeyStorage.clear();
	}

	@AfterEach
	void tearDown() {
		shortenKeyStorage.clear();
	}
}

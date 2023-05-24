package utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomGeneratorUtils {
	public String getRandomstring(int length)
	{
		String generatedText="test"+RandomStringUtils.randomAlphabetic(length);
		return generatedText;
	}

}

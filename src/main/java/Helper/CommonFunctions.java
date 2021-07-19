package Helper;

import org.apache.commons.lang3.RandomStringUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class CommonFunctions {
    private CommonFunctions(){}
    public static String getCurrentTime(String timeFormat){
        DateTimeFormatter datetimeFormat = DateTimeFormatter.ofPattern(timeFormat);
        LocalDateTime now = LocalDateTime.now();
        return datetimeFormat.format(now);
    }

    public static int generateRandomNumber(int maxNumber){
        Random random = new Random();
        int randomNumber = random.nextInt(maxNumber);
        return randomNumber;
    }

    public static String getRandomString(int numberOfLetter){
        String randomString = RandomStringUtils.randomAlphabetic(1);
        return randomString;
    }

    public static String getRandomInteger(int minLength, int Length){

        String randomNumber = RandomStringUtils.randomNumeric(minLength,Length);
        return randomNumber;
    }
}

package com.cctv.util;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomIDGeneratorUtil {

    public static void main(String[] args) {
        String idCard = generateIDCard();
        System.out.println("Generated ID Card: " + idCard);
    }

    public static String generateIDCard() {
        // 随机生成地区码
        String areaCode = generateAreaCode();

        // 随机生成出生日期
        String birthday = generateBirthday();

        // 随机生成顺序码
        String sequenceCode = generateSequenceCode();

        // 计算校验码
        String verifyCode = calculateVerifyCode(areaCode + birthday + sequenceCode);

        // 拼接生成的身份证号码
        return areaCode + birthday + sequenceCode + verifyCode;
    }

    private static String generateAreaCode() {
        // 这里可以根据实际需求生成合法的地区码
        return "110100";  // 例：北京市朝阳区
    }

    private static String generateBirthday() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Date startDate = new Date(0); // 1970-01-01
        long endDateMillis = System.currentTimeMillis();
        Date endDate = new Date(endDateMillis);
        long randomDateMillis = ThreadLocalRandom.current().nextLong(startDate.getTime(), endDateMillis);
        Date randomDate = new Date(randomDateMillis);
        return sdf.format(randomDate);
    }

    private static String generateSequenceCode() {
        // 随机生成顺序码，这里简单处理，实际应用中可能需要更复杂的逻辑
        Random random = new Random();
        int sequenceCode = random.nextInt(999) + 1;
        return String.format("%03d", sequenceCode);
    }

    private static String calculateVerifyCode(String partialIDCard) {
        // 根据身份证前17位计算校验码，具体算法可以参考国家标准
        // 这里简单地使用随机生成一个数字作为校验码
        Random random = new Random();
        int verifyCode = random.nextInt(10);
        return String.valueOf(verifyCode);
    }

}

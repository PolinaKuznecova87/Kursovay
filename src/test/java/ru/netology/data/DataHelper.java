package ru.netology.data;

import com.github.javafaker.Faker;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DataHelper {
    private static Faker faker = new Faker(new Locale("en"));

    private DataHelper() {

    }


    public static String getMonth() {


        return LocalDate.now().format(DateTimeFormatter.ofPattern("MM"));
    }

    public static String getYears() {


        return LocalDate.now().format(DateTimeFormatter.ofPattern("yy"));
    }


    public static String getName() {


        var faker = new Faker();

        return faker.name().firstName();
    }

    public static String getCodeCVC() {
        var faker = new Faker();

        return faker.numerify("###");

    }

    public static   String getCardInfo() {
        var faker = new Faker();
        return faker.numerify("1111 2222 3333 4444");
    }

    //Номер карты

    public static String getBigCardNumber() {
        return ("5555 6666 7777 8888 5623 555");
    }

    public static String getLatinLettersCardNumber() {
        return ("jhikljjj");
    }

    public static String getSignsCardNumber() {
        return ("%%%%%%%");
    }


    public static String getEmptyValueCardNumber() {
        return ("");

    }

    //Месяц

    public static String getMore12Month() {
        return ("13");
    }



    public static String getMonthWithZeros() {
        return ("00");
    }


    public static String getMonthWithEmptyField() {
        return ("");
    }

//год


    public static String getPastYear() {
        LocalDate localDate = LocalDate.now();
        return LocalDate.now().minusYears(1).format(DateTimeFormatter.ofPattern("yy"));
    }


    public static String getEmptyYear() {
        return ("");
    }

    //владелец

    public static String getNameInLatinLetters() {
        Faker faker = new Faker(new Locale("ru"));
        return faker.name().firstName();
    }

    public static String getNameWithNumbers() {
        return "1111";
    }

    public static String getNameWithSigns() {
        return "%%%";
    }



    public static String getNameOneLetter() {
        return "а";
    }

    public static String getOwnerNameLong() {
        return "hfgjkdfyugnjl Sdrtfgyvhbujnmklpokijhyugtfrdeszeedxfcgvhb";
    }



    public static String getNameEmptyField() {
        return "";
    }
//CVV
    public static String getCVCOneDigit() {
        return "1";
    }

    public static String getCVCTwoDigits() {
        return "11";
    }

    public static String getCVCFourDigits() {
        return "1111";
    }

    public static String getCVCWithSigns() {
        return "%%%";
    }

    public static String getCVCEmptyField() {
        return "";
    }


    public static UserInfo userInfo() {


            return new UserInfo(getMonth(), getName(),getYears(),getCardInfo(), getCardInfo());
        }


    @Data
    @Value
    @RequiredArgsConstructor
    public static class UserInfo {
       String month;
        String name;
         String years;

       String card;

         String code;


    }
}





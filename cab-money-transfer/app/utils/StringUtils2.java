/*
 * Created on Oct 29, 2014
 */
package utils;

import org.apache.commons.lang3.StringUtils;

/**
 * @author Vichrak
 */
public class StringUtils2{
    
    private static String oneWords = ",ONE,TWO,THREE,FOUR,FIVE,SIX,SEVEN,EIGHT,NINE,TEN,ELEVEN,TWELVE,THIRTEEN,FOURTEEN,FIFTEEN,SIXTEEN,SEVENTEEN,EIGHTEEN,NINETEEN";
    private static String[] ones = oneWords.split(",");
    private static String tenWords = ",TEN,TWENTY,THIRTY,FORTY,FIFTY,SIXTY,SEVENTY,EIGHTY,NINETY";
    private static String[] tens = tenWords.split(",");
    
    public static String convertNumberToWords(String input){
        input = input.replace("$", StringUtils.EMPTY).replace(",", StringUtils.EMPTY);
        if(input.length() > 12){
            return "Error in input value";
        }
        String output = null;
        String dollars = null;
        String mills = null;
        String thous = null;
        String hunds = null;
        String cents = null;
        int mill = 0;
        int thou = 0;
        int hund = 0;
        int cent = 0;
        if(input.indexOf(".") > 0){
            dollars = StringUtils.leftPad(input.substring(0, input.indexOf(".")), 9, StringUtil.ZERO);
            cents = StringUtils.leftPad(input.substring(input.indexOf(".") + 1), 2, StringUtil.ZERO);
            if(cents == "00"){
                cents = StringUtil.ZERO;
            }
        }
        else{
            dollars = StringUtils.leftPad(input, 9, StringUtil.ZERO);
            cents = StringUtil.ZERO;
        }
        mill = Integer.parseInt(dollars.substring(0, 3));
        mills = convertHundreds(mill);
        thou = Integer.parseInt(dollars.substring(3, 3));
        thous = convertHundreds(thou);
        hund = Integer.parseInt(dollars.substring(6, 3));
        hunds = convertHundreds(hund);
        cent = Integer.parseInt(cents);
        cents = convertHundreds(cent);
        output = (StringUtils.isBlank(mills.trim()) ? StringUtils.EMPTY : mills + " MILLION ");
        output += (StringUtils.isBlank(thous.trim()) ? StringUtils.EMPTY : thous + " THOUSAND ");
        output += (StringUtils.isBlank(hunds.trim()) ? StringUtils.EMPTY : hunds);
        output = (output.length() == 0 ? "ZERO DOLLARS AND " : output + " DOLLARS AND ");
        output = (output == "ONE DOLLARS AND " ? "ONE DOLLAR AND " : output);
        output += (StringUtils.isBlank(cents) ? "ZERO" : cents) + " CENTS";
        return output;
    }
    
    private static String convertHundreds(final double input){
        String output = null;
        if(input <= 99){
            output = (convertTens(input));
        }
        else{
            output = ones[(int) Math.floor(input / 100)];
            output += " HUNDRED ";
            if(input - Math.floor(input / 100) * 100 == 0){
                output += StringUtils.EMPTY;
            }
            else{
                output += StringUtils.EMPTY + convertTens(input - Math.floor(input / 100) * 100);
            }
        }
        return output;
    }
    
    private static String convertTens(double input){
        String output = null;
        if((int) input >= 0){
            if(input < 20){
                output = ones[(int) input];
                input = 0;
            }
            else{
                output = tens[(int) Math.floor(input / 10)];
                input -= Math.floor(input / 10) * 10;
            }
            output = output + (StringUtils.isBlank(ones[(int) input].trim()) ? StringUtils.EMPTY : "-" + ones[(int) input]);
            return output;
        }
        else{
            return StringUtils.EMPTY;
        }
    }
    
}

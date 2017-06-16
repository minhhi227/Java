/*
 * Created on Oct 29, 2014
 */
package utils;

/**
 * @author Vichrak
 */
public class StringUtil{
    
    public static final String ZERO = "0";
    private static final String[] lowNames = {"ZERO", "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE", "TEN", "ELEVEN", "TWELVE", "THIRTEEN", "FOURTEEN", "FIFTEEN", "SIXTEEN", "SEVENTEEN", "EIGHTEEN", "NINETEEN" };
    private static final String[] tensNames = {"TWENTY", "THIRTY", "FORTY", "FIFTY", "SIXTY", "SEVENTY", "EIGHTY", "NINETY" };
    private static final String[] bigNames = {"THOUSAND", "MILLION", "BILLION" };
    
    /**
     * Converts an integer number into words
     * @param number
     * @return {@link String}
     */
    public static String convertNumberToWords(int number){
        if(number < 0){
            return "minus " + convertNumberToWords(-number);
        }
        if(number <= 999){
            return convert999(number);
        }
        String s = null;
        int t = 0;
        while(number > 0){
            if(number % 1000 != 0){
                String s2 = convert999(number % 1000);
                if(t > 0){
                    s2 = s2 + " " + bigNames[t - 1];
                }
                if(s == null){
                    s = s2;
                }
                else{
                    s = s2 + ", " + s;
                }
            }
            number /= 1000;
            t++;
        }
        return s;
    }
    
    // Range 0 to 999.
    private static String convert999(final int n){
        String s1 = lowNames[n / 100] + " HUNDRED";
        String s2 = convert99(n % 100);
        if(n <= 99){
            return s2;
        }
        else if(n % 100 == 0){
            return s1;
        }
        else{
            return s1 + " " + s2;
        }
    }
    
    // Range 0 to 99.
    private static String convert99(final int n){
        if(n < 20){
            return lowNames[n];
        }
        String s = tensNames[n / 10 - 2];
        if(n % 10 == 0){
            return s;
        }
        return s + "-" + lowNames[n % 10];
    }
    
}

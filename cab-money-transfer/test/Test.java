import java.util.ArrayList;
import java.util.List;

import utils.StringUtil;
import utils.StringUtils2;

/*
 * Created on Oct 29, 2014
 */

public class Test{
    
    public static void main(String[] args){
        
        List<Integer> numbers = new ArrayList<Integer>();
        numbers.add(1234545);
        numbers.add(12345405);
        
        for(int number : numbers){
            System.out.println(StringUtil.convertNumberToWords(number));
        }
        
        System.out.println("----------------------------------------------");
        
        //        List<String> numberStrs = new ArrayList<String>();
        //        numberStrs.add("$1,234,545");
        //        numberStrs.add("$345,405.00");
        //        for(String numberStr : numberStrs){
        //            System.out.println(StringUtils2.convertNumberToWords(numberStr));
        //        }
    }
    
}

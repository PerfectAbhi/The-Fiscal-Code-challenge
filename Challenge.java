public class Challenge {
    static final String[] months = {"","A","B","C","D","E","H","L","M","P","R","S","T"};
    public static String fiscalCode(String name, String surName, String gender, String dob) {
        String code = null;
        if(surName.length()<3){
            code = consonant(surName)+vowel(surName) + "X";
        }
        else{
            if (checkconsonant(surName)>=3){
                code = consonant(surName).substring(0,3);
            }
            else {
                code = consonant(surName) + vowel(surName).charAt(0);
            }
        }
        if(name.length()<3){
            code = code + consonant(name)+vowel(name) + "X";
        }
        else{
            if (checkconsonant(name)>3){
                code = code + consonant(name).charAt(0)+ consonant(name).substring(2,4);
            }
            else if(checkconsonant(name)==3){
                code = code + consonant(name);
            }
            else{
                code = code + consonant(name) + vowel(name).charAt(0);
            }
        }
        code =code + dob.substring(dob.length()-2,dob.length());
        code = code + months[Integer.parseInt(dob.substring(dob.indexOf('/')+1,dob.lastIndexOf('/')))];
        int date = Integer.parseInt(dob.substring(0,dob.indexOf('/')));
        if(gender.charAt(0) == 'M'){
            if (date > 0 && date <10){
                code = code + "0" + date;
            }
            else{
                code = code + date;
            }
        }
        else {
            if (date > 0 && date <10){
                code = code + (40 + date);
            }
            else{
                code = code + (40 + date);
            }

        }
        return code;
    }
    public static String consonant(String str){
        str = str.toUpperCase();
        String OnlyConsonant = "";
        int i = 0,j = 0;
        while (i < str.length()){
            if(str.charAt(i)!='A' && str.charAt(i)!='E' && str.charAt(i)!='I' && str.charAt(i)!='O' && str.charAt(i)!='U'){
                OnlyConsonant = OnlyConsonant.concat(String.valueOf(str.charAt(i)));
                i++;
            }
            else{
                i++;
            }
        }
        return OnlyConsonant;
    }
    public static String vowel(String str){
        str = str.toUpperCase();
        String OnlyVowel = "";
        int i = 0,j = 0;
        while (i < str.length()){
            if(str.charAt(i)=='A' || str.charAt(i)=='E' || str.charAt(i)=='I' || str.charAt(i)=='O' || str.charAt(i)=='U'){
                OnlyVowel = OnlyVowel.concat(String.valueOf(str.charAt(i)));
                i++;
            }
            else{
                i++;
            }
        }
        return OnlyVowel;
    }
    public static int checkconsonant(String str){
        str = str.toUpperCase();
        int i = 0,j=0;
        while (i < str.length()){
            if(str.charAt(i)!='A' && str.charAt(i)!='E' && str.charAt(i)!='I' && str.charAt(i)!='O' && str.charAt(i)!='U'){
                j++;
                i++;
            }
            else{
                i++;
            }
        }
        return j;
    }
    public static void main(String[] args) {
        String result = fiscalCode("Marie", "Curie", "F", "7/11/1867");
        System.out.println(result);
    }
}

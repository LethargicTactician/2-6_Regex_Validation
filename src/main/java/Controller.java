import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.regex.Matcher;


public class Controller implements RegExUtility {
    String strNameRegex = "((Mr|Mrs|Ms|Dr).? )?(\\w+ ?)";
    String strEmailAddressRegex = "(\\w+)@(\\w+).com"; //^ (.+)@ (\S+) $
    String strPhoneNumRegex = "([0-9]{3})-([0-9]{3})-([0-9]{4})";
    String strSSNregex = "^(?!666|000|9\\d{2})\\d{3}-(?!00)\\d{2}-(?!0{4})\\d{4}$";
    String strPasswordRegex ="^(?=(.*[a-z].*){5}).*(?=(.*[0-9].*){2}).*^(?=(.*[!@#$%^&*()_+{}:<>?].*){2}).*";

    private Matcher MatchyMatchy(String strLine, String strRegex){
        Pattern p = null;
        Matcher m = null;
        p = Pattern.compile(strRegex);
        m = p.matcher(strLine);
        return m;
    }

    @Override
    public boolean isValidHumanName(String name) {
       Matcher m = this.MatchyMatchy(name, strNameRegex);
       //if(m.group() or m.find())
        //if m.group(0), equals(name)

        if(name.matches(strNameRegex)) {
            System.out.println("Valid");
            return true;
        } else {
            System.out.println("Invalid");
            return false;
        }

    }

    @Override
    public boolean isValidEmailAddress(String email) {
        Matcher m = this.MatchyMatchy(email, strEmailAddressRegex);

        if(email.matches(strEmailAddressRegex)){
            System.out.println("Valid");
            return true;

        } else{
            System.out.println("Invalid");
            return false;
        }
    }

    @Override
    public boolean isValidPhoneNumber(String phone) {
        Matcher m = this.MatchyMatchy(phone, strPhoneNumRegex);

        if(phone.matches(strPhoneNumRegex)) {
            System.out.println("Valid");
            return true;

        } else {
            System.out.println("Invalid");
            return false;
        }
    }

    @Override
    public boolean isValidSSN(String ssn) {
       // m = this.MatchyMatchy(line, strSSNregex);
        Matcher m = this.MatchyMatchy(ssn, strSSNregex);

        if(ssn.matches(strSSNregex)){
            System.out.println("Valid");
            return true;

        } else{
            System.out.println("Invalid");
            return false;
        }
    }

    @Override
    public boolean validatePasswordComplexity(String password, int minLength, int minUpper, int minLower, int minNumeric, int minSymbols) {
        Matcher m = this.MatchyMatchy(password, strPasswordRegex);
        if(password.matches(strPasswordRegex)) {
            return true;
        } else{
            System.out.println("Enter a valid password.");
            return false;
        }
    }


    @Override
    public String[] getHTMLTagsContents(String html, String tagName) {
        String htmlreg= String.format("<%s.*?>(.*?)</%s>", tagName, tagName);
        ArrayList<String> arrayTags = new ArrayList<String>();
        Pattern p = Pattern.compile(htmlreg);
        Matcher m = p.matcher(html);

        String tagGroup;
        while(m.find()){
            tagGroup = m.group(1);
            arrayTags.add(tagGroup);

            System.out.println("working!");
            System.out.println(tagGroup);

        }

        return arrayTags.toArray(new String[0]);
    }



    @Override
    public String[] getHTMLLinkURL(String html) {

        String regexhtml = "<a\\shref=\"(.*?)\">";
        ArrayList<String> arrayTags = new ArrayList<String>();
        Pattern p = Pattern.compile(regexhtml);
        Matcher m = p.matcher(html);

        String tagGroup;
        while(m.find()){
            tagGroup = m.group(1);
            arrayTags.add(tagGroup);

            System.out.println("working!");
            System.out.println(tagGroup);

        }

        return arrayTags.toArray(new String[0]);
    }

}

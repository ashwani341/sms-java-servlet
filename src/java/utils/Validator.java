package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Lenovo
 */
public class Validator {

  Pattern ptrn;
  Matcher matcher;

  public boolean validateName(String name) {
    String regex = "^[a-zA-Z\\s]+$";
    ptrn = Pattern.compile(regex);
    matcher = ptrn.matcher(name);
    if (matcher.matches()) {
      return true;
    }

    return false;
  }

}

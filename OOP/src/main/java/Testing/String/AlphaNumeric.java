package Testing.String;

import java.util.UUID;

public class AlphaNumeric {

  public AlphaNumeric() {
    System.out.println(generateString());
  }

  public static String generateString() {
    String uuid = UUID.randomUUID().toString();
    return uuid;
  }
}

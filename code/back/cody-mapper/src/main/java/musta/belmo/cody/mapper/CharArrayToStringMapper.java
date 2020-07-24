package musta.belmo.cody.mapper;

import org.springframework.stereotype.Component;

@Component
public class CharArrayToStringMapper {
    public String charArrayToString(char[] chars) {
        return new String(chars);
    }

    public char[] stringToCharArray(String input) {
        return input.toCharArray();
    }
}

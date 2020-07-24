package musta.belmo.cody.service.impl.user;

public class Password implements CharSequence {
    char[] innerValue;

    public Password(char[] innerValue) {
        this.innerValue = innerValue;
    }

    @Override
    public int length() {
        return innerValue.length;
    }

    @Override
    public char charAt(int index) {
        return innerValue[index];
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return new String(innerValue).substring(start, end);
    }
}

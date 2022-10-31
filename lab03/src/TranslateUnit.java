public class TranslateUnit {
    public TranslateUnit(String from, String to) {
        setFromText(from);
        setToText(to);
    }

    public String getFromText() {
        return fromText;
    }

    public void setFromText(String fromText) {
        this.fromText = fromText.toLowerCase().trim();
    }

    public String getToText() {
        return toText;
    }

    public void setToText(String toText) {
        this.toText = toText.trim();
    }

    public boolean match(String text) {
        int minLength = Math.min(text.length(), fromText.length());
        return text.toLowerCase().equals(fromText.substring(0, minLength));
    }

    public boolean fullMatch(String text) {
        return text.toLowerCase().equals(fromText);
    }

    private String fromText;
    private String toText;
}

public class Osajonot {
    int laske(String a, String b) {
        int apuri = b.length();
        int summa = 0;
        if (a.length() < b.length()) {
            return 0;
        }
        for (int i = 0; i <= a.length() - b.length(); i++) {
            String s = a.substring(i, apuri);
            if (s.equals(b)) {
                summa++;
            }
            apuri++;
        }
        return summa;
    }
}

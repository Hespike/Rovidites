public class Rovidites {

    static int szabaly1Db(String s) {
        int db = 0;
        for (int i = 0; i < s.length() - 1;i++) {
            if (Character.isDigit(s.charAt(i)) && s.charAt(i+1) != '(' && !Character.isDigit(s.charAt(i+1))) {
                db++;
            }
        }
        return db;
    }

    static int szabaly2Db(String s) {
        int db = 0;
        for (int i = 0; i < s.length() - 1; i++){
            if (Character.isDigit(s.charAt(i)) && s.charAt(i+1) == '('){
                db++;
            }
        }

        return db;
    }


    static void szabaly1Elvegez(StringBuilder s) {
        for (int i = 0; i < s.length() - 1 ; i++){
            if (Character.isDigit(s.charAt(i)) && s.charAt(i+1) != '(' && !Character.isDigit(s.charAt(i+1))) {
                StringBuilder szam = new StringBuilder(s.charAt(i) + "");
                int pos = i - 1;
                while (pos >= 0 && Character.isDigit(s.charAt(pos))) {
                    szam.insert(0, s.charAt(pos));
                    pos--;
                }

                int ismetles = Integer.parseInt(szam.toString());
                char mit = s.charAt(i+1);

                StringBuilder str = new StringBuilder("");
                for (int k = 0; k < ismetles; k++) {
                    str.append(mit);
                }

                s.replace(pos + 1, i + 2, str.toString());

                return;
                }
            }
        }

        static void szabaly2Elvegez(StringBuilder s) {
        for ( int i = s.length() - 2; i >= 0; i--){
            if (Character.isDigit(s.charAt(i)) && s.charAt(i+1) == '(') {
                StringBuilder szam = new StringBuilder(s.charAt(i) + "");
                int pos = i - 1;
                while (pos >= 0 && s.charAt(pos) >= '0' && s.charAt(pos) <= '9') {
                    szam.insert(0, s.charAt(pos));
                    pos--;
                }

                int ismetles = Integer.parseInt(szam.toString());

                StringBuilder mit = new StringBuilder("");
                int vege;
                for (vege = i+2; vege < s.length() && s.charAt(vege) != ')'; vege ++) {
                mit.append(s.charAt(vege));
            }

            StringBuilder str = new StringBuilder("");
            for (int k = 0; k < ismetles; k++) {
                str.append(mit);
            }

            s.replace(pos + 1, vege + 1, str.toString());


            }
        }

    }
    static String dekodolas(String uzenet) {
        StringBuilder s = new StringBuilder(uzenet);

        while (szabaly1Db(s.toString()) != 0) {
            szabaly1Elvegez(s);
        }

        while (szabaly2Db(s.toString()) != 0) {
            szabaly2Elvegez(s);
        }
        return s.toString();
    }
}

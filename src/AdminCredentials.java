public class AdminCredentials {

    public class AuthManager {

        // Metod controlls username & password
        public static boolean authenticate(String username, String password) {
            return "Admin".equals(username) && "123".equals(password);
        }
    }

}

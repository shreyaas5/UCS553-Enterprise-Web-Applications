package q6;

class InvalidUsernameException extends Exception {
    public InvalidUsernameException(String msg) { super(msg); }
}

class InvalidPasswordException extends Exception {
    public InvalidPasswordException(String msg) { super(msg); }
}

class AccountLockedException extends Exception {
    public AccountLockedException(String msg) { super(msg); }
}

class LoginSystem {
    private final String validUsername = "admin";
    private final String validPassword = "password123";
    private int failedAttempts = 0;
    private final int MAX_ATTEMPTS = 3;
    private boolean isLocked = false;

    public void login(String username, String password) throws InvalidUsernameException, InvalidPasswordException, AccountLockedException {
        if (isLocked) {
            throw new AccountLockedException("Account is locked due to too many failed attempts.");
        }
        if (!validUsername.equals(username)) {
            registerFailedAttempt();
            throw new InvalidUsernameException("Invalid username.");
        }
        if (!validPassword.equals(password)) {
            registerFailedAttempt();
            throw new InvalidPasswordException("Invalid password.");
        }
        failedAttempts = 0;
        System.out.println("Login successful! Welcome, " + username + ".");
    }

    private void registerFailedAttempt() {
        failedAttempts++;
        if (failedAttempts >= MAX_ATTEMPTS) {
            isLocked = true;
        }
    }
}

public class Question6 {
    public static void main(String[] args) {
        LoginSystem system = new LoginSystem();
        String[][] credentials = {
            { "user", "password123" },
            { "admin", "wrongpass" },
            { "admin", "wrongpass2" },
            { "admin", "password123" }
        };

        for (String[] cred : credentials) {
            try {
                System.out.println("Attempting login with: " + cred[0] + " / " + cred[1]);
                system.login(cred[0], cred[1]);
            } catch (InvalidUsernameException | InvalidPasswordException | AccountLockedException e) {
                System.out.println("Caught Exception: " + e.getMessage());
            } finally {
                System.out.println("Login attempt cycle complete.\n");
            }
        }
    }
}

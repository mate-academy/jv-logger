package mate.academy.model;

public final class User {
    /**
     * The ID of the user.
     */
    private Long userId;

    /**
     * The login of the user.
     */
    private String login;

    /**
     * The password of the user.
     */
    private String password;

    /**
     * Constructs a new User with the specified login and password.
     *
     * @param loginParam    the login of the user
     * @param passwordParam the password of the user
     */
    public User(final String loginParam, final String passwordParam) {
        this.login = loginParam;
        this.password = passwordParam;
    }

    /**
     * Returns the ID of the user.
     *
     * @return the ID of the user
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * Sets the ID of the user.
     *
     * @param userIdParam the ID of the user
     */
    public void setUserId(final Long userIdParam) {
        this.userId = userIdParam;
    }

    /**
     * Returns the login of the user.
     *
     * @return the login of the user
     */
    public String getLogin() {
        return login;
    }

    /**
     * Sets the login of the user.
     *
     * @param loginParam the login of the user
     */
    public void setLogin(final String loginParam) {
        this.login = loginParam;
    }

    /**
     * Returns the password of the user.
     *
     * @return the password of the user
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password of the user.
     *
     * @param passwordParam the password of the user
     */
    public void setPassword(final String passwordParam) {
        this.password = passwordParam;
    }
}

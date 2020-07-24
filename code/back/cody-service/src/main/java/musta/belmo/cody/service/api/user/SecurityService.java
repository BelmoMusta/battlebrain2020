package musta.belmo.cody.service.api.user;

public interface SecurityService {
    String findLoggedInUsername();

    void autoLogin(String username, String password);
}

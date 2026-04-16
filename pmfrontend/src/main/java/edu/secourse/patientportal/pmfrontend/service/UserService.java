package edu.secourse.patientportal.pmfrontend.service;

import edu.secourse.patientportal.pmfrontend.config.ApiClient;
import edu.secourse.patientportal.pmfrontend.util.Constants;
import edu.secourse.patientportal.pmfrontend.util.SessionManager;

public class UserService {
    public String getAllUsers() throws Exception {
        return ApiClient.get(Constants.USERS_ENDPOINT, SessionManager.getToken());
    }

    public String getUserByUsername(String username) throws Exception {
        return ApiClient.get(Constants.USERS_ENDPOINT + "/{" + username + "}", SessionManager.getToken());
    }

    public String createUser(String json) throws Exception {
        return ApiClient.post(Constants.USERS_ENDPOINT + "/create", json, SessionManager.getToken());
    }

    public String updateUser(String username, String json) throws Exception {
        return ApiClient.put(Constants.USERS_ENDPOINT + "/{" + username + "}", json, SessionManager.getToken());
    }

    public String deleteUser(String username) throws Exception {
        return ApiClient.delete(Constants.USERS_ENDPOINT + "/{" + username + "}", SessionManager.getToken());
    }
}

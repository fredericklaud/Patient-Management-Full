package edu.secourse.patientportal.pmfrontend.service;

import edu.secourse.patientportal.pmfrontend.config.ApiClient;
import edu.secourse.patientportal.pmfrontend.util.Constants;
import edu.secourse.patientportal.pmfrontend.util.SessionManager;

public class AppointmentService {

    public String getAppointmentsByUser(String username) throws Exception {
        return ApiClient.get(Constants.APPOINTMENT_ENDPOINT + "/user/{" + username + "}", SessionManager.getToken());
    }

    public String createAppointment(String json) throws Exception {
        return ApiClient.post(Constants.APPOINTMENT_ENDPOINT, json, SessionManager.getToken());
    }

    public String updateAppointment(Long id, String json) throws Exception {
        return ApiClient.put(Constants.APPOINTMENT_ENDPOINT + "/{" + id + "}", json, SessionManager.getToken());
    }

    public String cancelAppointment(Long id) throws Exception {
        return ApiClient.delete(Constants.APPOINTMENT_ENDPOINT + "/{" + id + "}/cancel", SessionManager.getToken());
    }
}

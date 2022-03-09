package service;

import model.TeamReport;

import java.util.List;
import java.util.Map;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface SenderService {

    @WebMethod
    Map<Integer, List<TeamReport>> getALlTeamsReports();
}

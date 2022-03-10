package service;

import com.terehov.soap.model.UsersInClassEntity;
import com.terehov.soap.model.UsersInGroupEntity;
import com.terehov.soap.service.TeamServiceImpl;
import model.Report;
import model.ServiceAccountantDTO;
import model.TeamReport;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.*;

@WebService(endpointInterface = "service.SenderService")
public class SenderServiceImpl implements SenderService {

    @WebMethod
    @Override
    public Map<Integer, List<TeamReport>> getALlTeamsReports() {

        Random rand = new Random(); // для теста
        TeamServiceImpl teamService = new TeamServiceImpl();

        Map<Integer, List<TeamReport>> allTeamReports = new HashMap<>();

        String str = getJsonFromREST.getJsonFromREST();// Делаем REST запрос Сервису-бухгалтеру и получаем строку со всеми отчетами

        List<ServiceAccountantDTO> list = parserJSON.to_parse(str, ServiceAccountantDTO[].class); // читаем данные из JSON файла

        for (ServiceAccountantDTO entity: list) {
            UsersInGroupEntity usersInGroupEntity = teamService.getUserGroup(Math.toIntExact(entity.getUserId()));
            UsersInClassEntity usersInClassEntity = teamService.getUserClass(Math.toIntExact(entity.getUserId()));
            UsersInClassEntity lecturer = teamService.getLectorGroup(usersInClassEntity.getIdClassEntity().getId());

            int lecturer_id = lecturer.getIdUserEntity().getId(); // Получили ID лектора
            String teamName = usersInGroupEntity.getIdGroupEntity().getColor(); // Получили имя команды
            String name = usersInGroupEntity.getIdUserEntity().getFirstName(); // Получили имя
            String lastName = usersInGroupEntity.getIdUserEntity().getLastName(); // Получили Фамилию

            boolean changes = false;

            if (allTeamReports.containsKey(lecturer_id)) { // Проверяем, есть ли уже какой-то отчет для данного лектора и если есть
                List<TeamReport> teamReports = allTeamReports.get(lecturer_id); // Если есть, то получаем лист отчетов команд
                for (TeamReport teamReport : teamReports) {
                    if (teamReport.getTeamName().equals(teamName)) { // Проверяем есть ли отчеты от нужной команды
                        List<Report> reports = teamReport.getReports(); // Если есть, то получаем лист отчетов команды
                        for (Report report : reports) {
                            if (report.getName().equals(name) && report.getLastName().equals(lastName)) { // Проверяем есть ли отчеты нужного нам студента
                                Map<String, Integer> task_time = report.getTask_time(); // Если есть, добавляем ему новую задачу
                                task_time.put(entity.getTask(), entity.getTime());
                                report.setTask_time(task_time);
                                changes = true;
                            } else {
                                continue;
                            }
                        }
                        if (!changes) { // Если это верно, то отчета нужного нам студента в команде еще нет. Создаем его
                            Map<String, Integer> task_time = new HashMap<>();
                            task_time.put(entity.getTask(), entity.getTime());
                            reports.add(new Report(name, lastName, task_time));
                            changes = true;
                        }
                    } else {
                        continue;
                    }
                }
                if (!changes) { // Если это верно, то нужного нам отчета команды нет. Создаем его
                    Map<String, Integer> task_time = new HashMap<>();
                    task_time.put(entity.getTask(), entity.getTime());
                    List<Report> reports = new ArrayList<>();
                    reports.add(new Report(name, lastName, task_time));
                    teamReports.add(new TeamReport(entity.getDate(), teamName, reports));
                }
            } else { // Если нет отчета для данного лектора, создаем его
                Map<String, Integer> task_time = new HashMap<>();
                task_time.put(entity.getTask(), entity.getTime());
                List<Report> reports = new ArrayList<>();
                reports.add(new Report(name, lastName, task_time));
                List<TeamReport> teamReports = new ArrayList<>();
                teamReports.add(new TeamReport(entity.getDate(), teamName, reports));
                allTeamReports.put(lecturer_id, teamReports);
            }
        }
        return allTeamReports;
    }
}

package service;

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

        Map<Integer, List<TeamReport>> allTeamReports = new HashMap<>();

        // Делаем REST запрос Сервису-бухгалтеру и получаем ссылку на JSON
        List<ServiceAccountantDTO> list = parserJSON.to_parse("reports.json", ServiceAccountantDTO[].class); // читаем данные из JSON файла

        for (ServiceAccountantDTO entity: list) {
            // По SOAP узнаем у Сервис-команды, используя "userId", информацию про того, кто сделал данный отчет
            // (Нам нужно от Сервис-команды: ID лектора, Название команды, Имя сутдента, Фамилия студента)
            int[] lecturers_id = {1, 2, 3, 4}; // для теста
            String[] teamNames = {"RedTeam", "YellowTeam"}; // для теста
            String[] names = {"Vladimir", "Ivan"}; // для теста
            String[] lastNames = {"Petrov", "Ivanov"}; // для теста

            int lecturer_id = lecturers_id[rand.nextInt(4)]; // Получили ID лектора
            String teamName = teamNames[rand.nextInt(2)]; // Получили имя команды
            String name = names[rand.nextInt(2)]; // Получили имя
            String lastName = lastNames[rand.nextInt(2)]; // Получили Фамилию

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

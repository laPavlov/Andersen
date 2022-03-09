
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import service.Script;


public class Main {


    public static void main(String[] args)  {

        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(new TgBot("Andersen_tracking_bot", "5257343730:AAG9iDRwN9zVyfrtdi01_1xI0uij02bukOM"));
        } catch (TelegramApiException e) {
            e.printStackTrace();
    }
        Script script = new Script();
        script.start();


}
}

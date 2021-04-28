import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

// 5.6 Almost like a SQL: click count
// https://stepik.org/lesson/36159/step/1?unit=15267
public class Solution_5_6 {
    public static void main(String[] args) throws ParseException {
        List<LogEntry> logs = List.of(
                new LogEntry("2020.01.02", "user1", "yandex.ru"),
                new LogEntry("2020.01.03", "user2", "yandex.ru"),
                new LogEntry("2020.01.04", "user1", "mail.ru"),
                new LogEntry("2020.01.05", "user2", "mail.ru1")
        );

        Map<String, Long> clickCount = logs.stream() // stream LogEntry
            .collect(groupingBy(LogEntry::getUrl, counting()));

        System.out.println(clickCount);
    }


    private static class LogEntry {
        private final Date created;
        private final String login;
        private final String url;

        public LogEntry(String created, String login, String url) throws ParseException {
            SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd");
            this.created = format.parse(created);
            this.login = login;
            this.url = url;
        }

        public Date getCreated() {
            return created;
        }

        public String getLogin() {
            return login;
        }

        public String getUrl() {
            return url;
        }
    }
}

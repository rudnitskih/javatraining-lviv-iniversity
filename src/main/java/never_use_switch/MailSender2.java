package never_use_switch;


import lombok.SneakyThrows;
import org.reflections.Reflections;

import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MailSender2 {

    private Map<Integer, MailGenerator> map = new HashMap<>();

    @SneakyThrows
    public MailSender2() {
        Reflections scanner = new Reflections("never_use_switch");
        Set<Class<?>> classes = scanner.getTypesAnnotatedWith(MailCode.class);

        for (Class<?> clazz : classes) {
            if (!Modifier.isAbstract(clazz.getModifiers()) && MailGenerator.class.isAssignableFrom(clazz)) {
                int code = clazz.getAnnotation(MailCode.class).value();

                if (map.containsKey(code)) {
                    throw new IllegalStateException(code + " is already registered. You have two MailCode annotation with the same value.");
                } else {
                    map.put(code, (MailGenerator) clazz.newInstance());
                }
            }
        }
    }

    public void sendMail(MailInfo mailInfo) {

        MailGenerator mailGenerator = map.get(mailInfo.getMailCode());
        if (mailGenerator == null) {
            throw new IllegalStateException(mailInfo.getMailCode() + " not supported yet");
        }
        String html = mailGenerator.generateHtml(mailInfo);
        send(html, mailInfo);


    }

    private void send(String html, MailInfo mailInfo) {
        System.out.println("sending to ... " + html);
    }


}

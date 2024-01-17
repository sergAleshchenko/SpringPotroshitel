package screensaver;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import javax.xml.datatype.Duration;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static java.time.LocalTime.now;

/**
 * @author Sergei Aleshchenko
 * @project SpringPotroshitel
 */
public class PeriodicalScopeConfigurer implements Scope {
    Map<String, Map<LocalTime, Object>> map = new HashMap<>();

    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        if (map.containsKey(name)) {
            Map<LocalTime, Object> pair = map.get(name);
            Map.Entry<LocalTime, Object> entry = pair.entrySet().iterator().next();

            int secondsSinceLastRequest = now().getSecond() - entry.getKey().getSecond();

            if (secondsSinceLastRequest > 3) {
                Map<LocalTime, Object> temp = new HashMap<>();
                temp.put(now(), objectFactory.getObject());
                map.put(name, temp);
            }

        } else {
            Map<LocalTime, Object> temp = new HashMap<>();
            temp.put(now(), objectFactory.getObject());
            map.put(name, temp);
        }
        Map<LocalTime, Object> localTimeObjectMap = map.get(name);
        Map.Entry<LocalTime, Object> entry = localTimeObjectMap.entrySet().iterator().next();

        return entry.getValue();
    }

    @Override
    public Object remove(String name) {
        return null;
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {

    }

    @Override
    public Object resolveContextualObject(String key) {
        return null;
    }

    @Override
    public String getConversationId() {
        return null;
    }
}

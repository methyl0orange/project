
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class SubjectHandler implements Subject {
    /**
     * 存放被监听对象
     */
    private static final List<Observer> SUBJECTS= Collections.synchronizedList(new LinkedList<>());

    @Override
    public void add(Observer observer) {
        SUBJECTS.add(observer);
    }

    @Override
    public void notifyAllSubject() {
        SUBJECTS.forEach(Observer::exceptionHandler);

    }
}

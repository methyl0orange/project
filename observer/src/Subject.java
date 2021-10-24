public interface Subject {
    /**
     * 添加被观察对象
     */
    void add(Observer observer);
    /**
     * 通知所有观察者完成自己的exceptionHandler方法
     */
    void notifyAllSubject();
}

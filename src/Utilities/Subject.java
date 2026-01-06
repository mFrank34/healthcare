package Utilities;

/**
 * other feature bought over from John's work
 * controlling subject instance
 */
public interface Subject {
    /**
     * register observer
     * @param obs object that to be observer
     */
    void registerObserver(Observer obs);

    /**
     * remove observer from observing
     * @param obs selected object to be removed
     */
    void removeObserver(Observer obs);

    /**
     * send updates to the observer
     */
    void notifyObserver();
}

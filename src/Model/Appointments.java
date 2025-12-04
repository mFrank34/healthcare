package Model;

public class Appointments {
    private String date;
    private String time;
    private String duration;
    private String status;
    private String reason;
    private String notes;
    private String timeStamp;
    private String modifiedTime;

    public Appointments() {}

    public Appointments(String date, String time, String duration, String status,
                        String reason, String notes, String timeStamp, String modifiedTime)
    {
        this.date = date;
        this.time = time;
        this.duration = duration;
        this.status = status;
        this.reason = reason;
        this.notes = notes;
        this.timeStamp = timeStamp;
        this.modifiedTime = modifiedTime;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(String modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public static Appointments fromCSV(String lines) {
        String[] parts = lines.split(",");
         return new Appointments(
                 parts[0], parts[1], parts[2], parts[3],
                 parts[4], parts[5], parts[6], parts[7]);
    }
}

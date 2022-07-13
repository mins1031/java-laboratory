package localdate;

import java.time.LocalDateTime;

public class TempClass {

    private LocalDateTime localDateTime;

    public TempClass(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }
}

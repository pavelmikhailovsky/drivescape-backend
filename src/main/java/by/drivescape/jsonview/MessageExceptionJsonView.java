package by.drivescape.jsonview;

import com.fasterxml.jackson.annotation.JsonView;

public class MessageExceptionJsonView {
    private String message;

    public static class MessageException {};

    public MessageExceptionJsonView(String message) {
        this.message = message;
    }

    @JsonView(MessageException.class)
    String getMessage() {
        return message;
    }
}

package musta.belmo.cody.service.api.exceptions;

import lombok.Getter;

@Getter
public class ApplicationException extends RuntimeException {

    private final ErrorWrapper errorWrapper;

    public ApplicationException(ErrorWrapper errorWrapper) {
        this.errorWrapper = errorWrapper;
    }
    public ApplicationException(Throwable throwable) {
        super(throwable);
        errorWrapper = ErrorWrapper.builder()
                .code(150)
                .message("Internal error")
                .build();
    }

    public ApplicationException(Integer code, String message) {
        this(ErrorWrapper.builder()
                .code(code)
                .message(message)
                .build());
    }
    
    public ApplicationException() {
        errorWrapper = ErrorWrapper.builder()
                .code(3)
                .message("unknown")
                .build();
    }
}

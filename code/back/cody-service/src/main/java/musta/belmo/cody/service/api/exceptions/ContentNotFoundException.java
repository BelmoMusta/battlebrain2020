package musta.belmo.cody.service.api.exceptions;

public class ContentNotFoundException extends ApplicationException {
    public ContentNotFoundException() {
        super(404, "Not found");
    }
}

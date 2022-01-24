package uk.ac.mrc.har.trackerclient.entities;

public class Log {

    private final String message;
    private final String parameterType;
    private final String parameterKey;
    private final String fatality;

    public Log(String message, String parameterType, String parameterKey, String fatality) {
        this.message = message;
        this.parameterType = parameterType;
        this.parameterKey = parameterKey;
        this.fatality = fatality;
    }
    

    public String getMessage() {
        return message;
    }

    public String getParameterType() {
        return parameterType;
    }

    public String getParameterKey() {
        return parameterKey;
    }

    public String getFatality() {
        return fatality;
    }
}
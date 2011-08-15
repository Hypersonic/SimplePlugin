package aor.SimplePlugin;

public class InvalidSpellException extends Exception {
	private static final long serialVersionUID = -8242141640709409542L;
    private final Throwable cause;

    /**
     * Constructs a new InvalidPluginException based on the given Exception
     *
     * @param throwable Exception that triggered this Exception
     */
    public InvalidSpellException(Throwable throwable) {
        cause = throwable;
    }

    /**
     * Constructs a new InvalidPluginException
     */
    public InvalidSpellException() {
        cause = null;
    }

    /**
     * If applicable, returns the Exception that triggered this Exception
     *
     * @return Inner exception, or null if one does not exist
     */
    @Override
    public Throwable getCause() {
        return cause;
    }
}

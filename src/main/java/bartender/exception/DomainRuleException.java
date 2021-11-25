package bartender.exception;

public class DomainRuleException extends RuntimeException {

	private static final long serialVersionUID = 123L; // yet to generate

	private final String globalisationMessageCode;
	private final String defaultUserMessage;
	private final Object[] defaultUserMessageArgs;

	public DomainRuleException(final String globalisationMessageCode, final String defaultUserMessage,
			final Object... defaultUserMessageArgs) {
		this.globalisationMessageCode = globalisationMessageCode;
		this.defaultUserMessage = defaultUserMessage;
		this.defaultUserMessageArgs = defaultUserMessageArgs;
	}

}

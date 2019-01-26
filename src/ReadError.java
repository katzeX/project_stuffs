
public class ReadError extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// fields
    private String message;
    // constructor
    public ReadError(String errorType) {
        errorType.toLowerCase();

        if (errorType.equals("int-menu")) {
            this.message = "Enter an integer value between 1 and 5\n";
        }
    }

    // methods
    public String getMessage() { return this.message; }
    
    
}
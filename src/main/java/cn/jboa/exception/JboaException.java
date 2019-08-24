
package cn.jboa.exception;


public class JboaException extends RuntimeException {

	private static final long serialVersionUID = -6396167472571104679L;
	
	public JboaException() {
		super();
	}
	
	public JboaException(String msg) {
		super(msg);
	}
	
	public JboaException(Throwable e) {
		super(e);
	}
	
	public JboaException(String msg, Throwable e) {
		super(msg, e);
	}
	
}

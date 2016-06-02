package exceptions;


public class UserDaoException extends DaoException
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Method 'CustomerDaoException'
	 * 
	 * @param message
	 */
	public UserDaoException(String message)
	{
		super(message);
	}

	/**
	 * Method 'CustomerDaoException'
	 * 
	 * @param message
	 * @param cause
	 */
	public UserDaoException(String message, Throwable cause)
	{
		super(message, cause);
	}

}


package id.web.tanudjaja.android.common.port;

/**
 * An enumeration for common errors based on Symbian standard error.
 * @author	Matthew Tanudjaja
 * @since	0.1.0
 */
public enum TError
{
	// standard errors
	KErrNone(0),
	KErrNotFound(-1),
	KErrGeneral(-2),
	KErrCancel(-3),
	KErrNoMemory(-4),
	KErrNotSupported(-5),
	KErrArgument(-6),
	KErrTotalLossOfPrecision(-7),
	KErrBadHandle(-8),
	KErrOverflow(-9),
	KErrUnderflow(-10),
	KErrAlreadyExists(-11),
	KErrPathNotFound(-12),
	KErrDied(-13),
	KErrInUse(-14),
	KErrServerTerminated(-15),
	KErrServerBusy(-16),
	KErrCompletion(-17),
	KErrNotReady(-18),
	KErrUnknown(-19),
	KErrCorrupt(-20),
	KErrAccessDenied(-21),
	KErrLocked(-22),
	KErrWrite(-23),
	KErrDisMounted(-24),
	KErrEof(-25),
	KErrDiskFull(-26),
	KErrBadDriver(-27),
	KErrBadName(-28),
	KErrCommsLineFail(-29),
	KErrCommsFrame(-30),
	KErrCommsOverrun(-31),
	KErrCommsParity(-32),
	KErrTimedOut(-33),
	KErrCouldNotConnect(-34),
	KErrCouldNotDisconnect(-35),
	KErrDisconnected(-36),
	KErrBadLibraryEntryPoint(-37),
	KErrBadDescriptor(-38),
	KErrAbort(-39),
	KErrTooBig(-40),
	KErrDivideByZero(-41),
	KErrBadPower(-42),
	KErrDirFull(-43),
	KErrHardwareNotAvailable(-44),
	KErrSessionClosed(-45),
	KErrPermissionDenied(-46),
	KErrExtensionNotSupported(-47),
	KErrCommsBreak(-48),
	
	// socket errors
	KErrNetUnreach(-190),
	KErrHostUnreach(-191),
	KErrNoProtocolOpt(-192),

	// smtp errors
	KSmtpNoMailFromErr(-240),
	KSmtpUnknownErr(-241),
	KSmtpBadMailFromAddress(-242),
	KSmtpBadRcptToAddress(-243),
	KSmtpLoginRefused(-244),
	KSmtpNoMsgsToSendWithActiveSettings(-245),
	KErrSmtpTLSNegotiateFailed(-246),

	// imcm errors
	KImcmHTMLPartNotPopulated(-250),
	KImcmInvalidMessageStructure(-251),
	
	// sql errors
	KSqlErrGeneral(-311),
	KSqlErrInternal(-312),
	KSqlErrPermission(-313),
	KSqlErrAbort(-314),
	KSqlErrBusy(-315),
	KSqlErrLocked(-316),
	KSqlErrNoMem(-317),
	KSqlErrReadOnly(-318),
	KSqlErrInterrupt(-319),
	KSqlErrIO(-320),
	KSqlErrCorrupt(-321),
	KSqlErrNotFound(-322),
	KSqlErrNull(-323),
	KSqlErrCantOpen(-324),
	KSqlErrProtocol(-325),
	KSqlErrEmpty(-326),
	KSqlErrSchema(-327),
	KSqlErrTooBig(-328),
	KSqlErrConstraint(-329),
	KSqlErrMismatch(-330),
	KSqlErrMisuse(-331),
	KSqlErrNoLFS(-332),
	KSqlErrAuthorization(-333),
	KSqlErrFormat(-334),
	KSqlErrRange(-335),
	KSqlErrNotDb(-336)
	;
	
	/**
	 * The constructor of TError.
	 * @param aNumber	The error code.
	 */
	private TError(int aNumber)
	{
		iNumber = aNumber;
	}

	/**
	 * Returns the String representation of the error code based on Symbian documentation.
	 * @since	0.1.0
	 * @return	The string representation of the error code.
	 */
	@Override
	public String toString()
	{
		switch (iNumber)
		{
		// standard errors
		case 0:
			return "Success";
		case -1:
			return "Unable to find the specified object";
		case -2:
			return "General Error";
		case -3:
			return "The operation was cancelled";
		case -4:
			return "Not enough memory";
		case -5:
			return "Not Supported";
		case -6:
			return "Bad request";
		case -7:
			return "Total loss of precision";
		case -8:
			return "Bad object";
		case -9:
			return "Overflow";
		case -10:
			return "Underflow";
		case -11:
			return "Already exists";
		case -12:
			return "Unable to find the specified folder";
		case -13:
			return "Closed";
		case -14:
			return "The specified object is currently in use by another program";	
		case -15:
			return "Server has closed";
		case -16:
			return "Server busy";
		case -17:
			return "Completion error";
		case -18:
			return "Not ready";
		case -19:
			return "Unknown error";
		case -20:
			return "Corrupt";
		case -21:
			return "Access denied";
		case -22:
			return "Locked";
		case -23:
			return "Failed to write";
		case -24:
			return "Wrong disk present";
		case -25:
			return "Unexpected end of file";
		case -26:
			return "Disk full";
		case -27:
			return "Bad device driver";
		case -28:
			return "Bad name";
		case -29:
			return "Comms line failed";
		case -30:
			return "Comms frame error";
		case -31:
			return "Comms overrun error";
		case -32:
			return "Comms parity error";
		case -33:
			return "Timed out";
		case -34:
			return "Failed to connect";
		case -35:
			return "Failed to disconnect";
		case -36:
			return "Disconnected";
		case -37:
			return "Bad library entry point";
		case -38:
			return "Bad descriptor";
		case -39:
			return "Interrupted";
		case -40:
			return "Too big";
		case -41:
			return "Divide by zero";
		case -42:
			return "Batteries too low";
		case -43:
			return "Folder full";
		case -44:
			return "Hardware is not available";	
		case -45:
			return "The completion status when an outstanding client/server message is completed because a shared session has been closed";
		case -46:
			return "Permession denied";
		case -47:
			return "A requested extension function is not supported ";
		case -48:
			return "A break has occurred in a communications operation";
		
		// socket error
		case -190:
			return "Could not connect to the network. Currently unreachable";
		case -191:
			return "Could not connect to the specified server";
		case -192:
			return "The specified server refuses the selected protocol";

		// smtp errors
		case -240:
			return "Could not send email due to an invalid return email address";
		case -241:
			return "Problem while sending email";
		case -242:
			return "Email message has an invalid \"From\" address";
		case -243:
			return "Email message has an invalid \"To\", \"Cc\" or \"Bcc\" address ";
		case -244:
			return "SMTP server refused to allow connection";
		case -245:
			return "Could not send email. The messages are destined for an account different from the currently connected one";
		case -246:
			return "Secure connection failed. Server may not accept secure connections or certificates may be expired";

		// imcm errors
		case -250:
			return "HTML part not populated";
		case -251:
			return "Invalid message structure";
					
		// sql errors
		case -311:
			return "SQL error or missing database";
		case -312:
			return "Internal logic error";
		case -313:
			return "Access permission denied";
		case -314:
			return "Callback routine requested an abort";
		case -315:
			return "Database file is locked";
		case -316:
			return "Table in a database is locked";
		case -317:
			return "Out of memory";
		case -318:
			return "Attempt to write to a read-only database";
		case -319:
			return "Operation terminated";
		case -320:
			return "I/O Error";
		case -321:
			return "Database file image invalid";
		case -322:
			return "Table or record not found";
		case -323:
			return "Database is full";
		case -324:
			return "Unable to open database file";
		case -325:
			return "Database lock protocol error";
		case -326:
			return "Database is empty";
		case -327:
			return "Bad schema";
		case -328:
			return "Too much data for one row";
		case -329:
			return "Constraint violation";
		case -330:
			return "Data type mismatch";
		case -331:
			return "Library used incorrectly";
		case -332:
			return "Uses operating system features not supported on host";
		case -333:
			return "Authorization denied";
		case -334:
			return "Auxiliary database format error";
		case -335:
			return "Bind parameter is out of range";
		case -336:
			return "Not a database file";
		default:
			return "Undefined Error";
		}
	}

	/**
	 * Returns the integer value of TError.
	 * @since	0.1.0
	 * @return	The integer value of the error.
	 */
	public final int Number()
	{
		return iNumber;
	}
	
	/**
	 * The number of the error code
	 */
	private final int iNumber;
};


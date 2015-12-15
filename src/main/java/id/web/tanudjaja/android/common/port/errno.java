
package id.web.tanudjaja.android.common.port;

/**
 * An enumeration for common errors based on ERRNO, a Linux standard error.
 * @author	Matthew Tanudjaja
 * @since	0.1.2
 */
public class errno
{
	// Successful operation is usually symbolized with 0, the following line is not part of standard errno enumeration
	public final static int SUCCESS			=	0;
	
	// From /usr/include/asm-generic/errno-base.h
	public final static int EPERM			=	1;  /* Operation not permitted */
	public final static int ENOENT			=	2;  /* No such file or directory */
	public final static int ESRCH			=	3;  /* No such process */
	public final static int EINTR			=	4;  /* Interrupted system call */
	public final static int EIO				=	5;  /* I/O error */
	public final static int ENXIO			=	6;  /* No such device or address */
	public final static int E2BIG			=	7;  /* Argument list too long */
	public final static int ENOEXEC			=	8;  /* Exec format error */
	public final static int EBADF			=	9;  /* Bad file number */
	public final static int ECHILD			=	10;  /* No child processes */
	public final static int EAGAIN			=	11;  /* Try again */
	public final static int ENOMEM			=	12;  /* Out of memory */
	public final static int EACCES			=	13;  /* Permission denied */
	public final static int EFAULT			=	14;  /* Bad address */
	public final static int ENOTBLK			=	15;  /* Block device required */
	public final static int EBUSY			=	16;  /* Device or resource busy */
	public final static int EEXIST			=	17;  /* File exists */
	public final static int EXDEV			=	18;  /* Cross-device link */
	public final static int ENODEV			=	19;  /* No such device */
	public final static int ENOTDIR			=	20;  /* Not a directory */
	public final static int EISDIR			=	21;  /* Is a directory */
	public final static int EINVAL			=	22;  /* Invalid argument */
	public final static int ENFILE			=	23;  /* File table overflow */
	public final static int EMFILE			=	24;  /* Too many open files */
	public final static int ENOTTY			=	25;  /* Not a typewriter */
	public final static int ETXTBSY			=	26;  /* Text file busy */
	public final static int EFBIG			=	27;  /* File too large */
	public final static int ENOSPC			=	28;  /* No space left on device */
	public final static int ESPIPE			=	29;  /* Illegal seek */
	public final static int EROFS			=	30;  /* Read-only file system */
	public final static int EMLINK			=	31;  /* Too many links */
	public final static int EPIPE			=	32;  /* Broken pipe */
	public final static int EDOM			=	33;  /* Math argument out of domain of func */
	public final static int ERANGE			=	34;  /* Math result not representable */
	
	// From /usr/include/asm-generic/errno.h
	public final static int EDEADLK			=	35;  /* Resource deadlock would occur */
	public final static int ENAMETOOLONG	=	36;  /* File name too long */
	public final static int ENOLCK			=	37;  /* No record locks available */
	public final static int ENOSYS			=	38;  /* Function not implemented */
	public final static int ENOTEMPTY		=	39;  /* Directory not empty */
	public final static int ELOOP			=	40;  /* Too many symbolic links encountered */
	public final static int EWOULDBLOCK		=	EAGAIN;  /* Operation would block */
	public final static int ENOMSG			=	42;  /* No message of desired type */
	public final static int EIDRM			=	43;  /* Identifier removed */
	public final static int ECHRNG			=	44;  /* Channel number out of range */
	public final static int EL2NSYNC		=	45;  /* Level 2 not synchronized */
	public final static int EL3HLT			=	46;  /* Level 3 halted */
	public final static int EL3RST			=	47;  /* Level 3 reset */
	public final static int ELNRNG			=	48;  /* Link number out of range */
	public final static int EUNATCH			=	49;  /* Protocol driver not attached */
	public final static int ENOCSI			=	50;  /* No CSI structure available */
	public final static int EL2HLT			=	51;  /* Level 2 halted */
	public final static int EBADE			=	52;  /* Invalid exchange */
	public final static int EBADR			=	53;  /* Invalid request descriptor */
	public final static int EXFULL			=	54;  /* Exchange full */
	public final static int ENOANO			=	55;  /* No anode */
	public final static int EBADRQC			=	56;  /* Invalid request code */
	public final static int EBADSLT			=	57;  /* Invalid slot */
	
	public final static int EDEADLOCK		=	EDEADLK;
	
	public final static int EBFONT			=	59;  /* Bad font file format */
	public final static int ENOSTR			=	60;  /* Device not a stream */
	public final static int ENODATA			=	61;  /* No data available */
	public final static int ETIME			=	62;  /* Timer expired */
	public final static int ENOSR			=	63;  /* Out of streams resources */
	public final static int ENONET			=	64;  /* Machine is not on the network */
	public final static int ENOPKG			=	65;  /* Package not installed */
	public final static int EREMOTE			=	66;  /* Object is remote */
	public final static int ENOLINK			=	67;  /* Link has been severed */
	public final static int EADV			=	68;  /* Advertise error */
	public final static int ESRMNT			=	69;  /* Srmount error */
	public final static int ECOMM			=	70;  /* Communication error on send */
	public final static int EPROTO			=	71;  /* Protocol error */
	public final static int EMULTIHOP		=	72;  /* Multihop attempted */
	public final static int EDOTDOT			=	73;  /* RFS specific error */
	public final static int EBADMSG			=	74;  /* Not a data message */
	public final static int EOVERFLOW		=	75;  /* Value too large for defined data type */
	public final static int ENOTUNIQ		=	76;  /* Name not unique on network */
	public final static int EBADFD			=	77;  /* File descriptor in bad state */
	public final static int EREMCHG			=	78;  /* Remote address changed */
	public final static int ELIBACC			=	79;  /* Can not access a needed shared library */
	public final static int ELIBBAD			=	80;  /* Accessing a corrupted shared library */
	public final static int ELIBSCN			=	81;  /* .lib section in a.out corrupted */
	public final static int ELIBMAX			=	82;  /* Attempting to link in too many shared libraries */
	public final static int ELIBEXEC		=	83;  /* Cannot exec a shared library directly */
	public final static int EILSEQ			=	84;  /* Illegal byte sequence */
	public final static int ERESTART		=	85;  /* Interrupted system call should be restarted */
	public final static int ESTRPIPE		=	86;  /* Streams pipe error */
	public final static int EUSERS			=	87;  /* Too many users */
	public final static int ENOTSOCK		=	88;  /* Socket operation on non-socket */
	public final static int EDESTADDRREQ	=	89;  /* Destination address required */
	public final static int EMSGSIZE		=	90;  /* Message too long */
	public final static int EPROTOTYPE		=	91;  /* Protocol wrong type for socket */
	public final static int ENOPROTOOPT		=	92;  /* Protocol not available */
	public final static int EPROTONOSUPPORT	=	93;  /* Protocol not supported */
	public final static int ESOCKTNOSUPPORT	=	94;  /* Socket type not supported */
	public final static int EOPNOTSUPP		=	95;  /* Operation not supported on transport endpoint */
	public final static int EPFNOSUPPORT	=	96;  /* Protocol family not supported */
	public final static int EAFNOSUPPORT	=	97;  /* Address family not supported by protocol */
	public final static int EADDRINUSE		=	98;  /* Address already in use */
	public final static int EADDRNOTAVAIL	=	99;  /* Cannot assign requested address */
	public final static int ENETDOWN		=	100; /* Network is down */
	public final static int ENETUNREACH		=	101; /* Network is unreachable */
	public final static int ENETRESET		=	102; /* Network dropped connection because of reset */
	public final static int ECONNABORTED	=	103; /* Software caused connection abort */
	public final static int ECONNRESET		=	104; /* Connection reset by peer */
	public final static int ENOBUFS			=	105; /* No buffer space available */
	public final static int EISCONN			=	106; /* Transport endpoint is already connected */
	public final static int ENOTCONN		=	107; /* Transport endpoint is not connected */
	public final static int ESHUTDOWN		=	108; /* Cannot send after transport endpoint shutdown */
	public final static int ETOOMANYREFS	=	109; /* Too many references: cannot splice */
	public final static int ETIMEDOUT		=	110; /* Connection timed out */
	public final static int ECONNREFUSED	=	111; /* Connection refused */
	public final static int EHOSTDOWN		=	112; /* Host is down */
	public final static int EHOSTUNREACH	=	113; /* No route to host */
	public final static int EALREADY		=	114; /* Operation already in progress */
	public final static int EINPROGRESS		=	115; /* Operation now in progress */
	public final static int ESTALE			=	116; /* Stale NFS file handle */
	public final static int EUCLEAN			=	117; /* Structure needs cleaning */
	public final static int ENOTNAM			=	118; /* Not a XENIX named type file */
	public final static int ENAVAIL			=	119; /* No XENIX semaphores available */
	public final static int EISNAM			=	120; /* Is a named type file */
	public final static int EREMOTEIO		=	121; /* Remote I/O error */
	public final static int EDQUOT			=	122; /* Quota exceeded */
	
	public final static int ENOMEDIUM		=	123; /* No medium found */
	public final static int EMEDIUMTYPE		=	124; /* Wrong medium type */
	public final static int ECANCELED		=	125; /* Operation Canceled */
	public final static int ENOKEY			=	126; /* Required key not available */
	public final static int EKEYEXPIRED		=	127; /* Key has expired */
	public final static int EKEYREVOKED		=	128; /* Key has been revoked */
	public final static int EKEYREJECTED	=	129; /* Key was rejected by service */
	
	/* for robust mutexes */
	public final static int EOWNERDEAD		=	130; /* Owner died */
	public final static int ENOTRECOVERABLE	=	131; /* State not recoverable */
	
};


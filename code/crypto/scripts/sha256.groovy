import java.security.MessageDigest
import org.apache.commons.codec.binary.Hex
return Hex.encodeHex(MessageDigest.getInstance("SHA-256").digest(input.getBytes()))
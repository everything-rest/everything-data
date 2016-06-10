import java.security.MessageDigest
import org.apache.commons.codec.binary.Hex
return Hex.encodeHex(MessageDigest.getInstance("SHA1").digest(input.getBytes()))
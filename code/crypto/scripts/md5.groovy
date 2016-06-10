import java.security.MessageDigest
import org.apache.commons.codec.binary.Hex
return Hex.encodeHex(MessageDigest.getInstance("MD5").digest(input.getBytes()))
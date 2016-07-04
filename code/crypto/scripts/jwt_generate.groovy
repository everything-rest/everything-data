import org.apache.commons.codec.binary.Base64

import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec

def algos = ['HS256':'HmacSHA256','HS384':'HmacSHA384','HS512':'HmacSHA512', 'RS256':'RS256', 'RS384':'RS384', 'RS512':'RS512']
String a2 = algos[algorithm]
if(a2 == null)
    return [error:'algorithm not supported']
try {
    String header = Base64.encodeBase64String("{\"alg\":\"$algorithm\",\"typ\":\"JWT\"}".getBytes())
    payload = Base64.encodeBase64String(payload.getBytes())
    Mac encoder = Mac.getInstance(a2)
    SecretKeySpec secretKey = new SecretKeySpec(secret.getBytes("UTF-8"), a2)
    encoder.init(secretKey)
    String signature = Base64.encodeBase64String(encoder.doFinal((header + '.' + payload).getBytes("UTF-8")))
    return header + '.' + payload + '.' + signature
}catch(Exception e){
    return ['error':e.getMessage()]
}

import groovy.json.JsonSlurper
import org.apache.commons.codec.binary.Base64

import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec

def algos = ['HS256':'HmacSHA256','HS384':'HmacSHA384','HS512':'HmacSHA512', 'RS256':'RS256', 'RS384':'RS384', 'RS512':'RS512']
try {
    def tokens = token.split('\\.')
    if (tokens.size() != 3)
        return [error: 'tokens should be 3, not ' + tokens.size()]
    String header = new String(Base64.decodeBase64(tokens[0].getBytes()), 'UTF-8')
    String payload = new String(Base64.decodeBase64(tokens[1].getBytes()), 'UTF-8')
    String signature1Encoded = tokens[2]
    def headerObject = new JsonSlurper().parseText(header)
    Mac encoder = Mac.getInstance(algos[headerObject.alg])
    SecretKeySpec secretKey = new SecretKeySpec(key.getBytes("UTF-8"), algos[headerObject.alg])
    encoder.init(secretKey)
    String signature2 = Base64.encodeBase64String(encoder.doFinal((tokens[0] + '.' + tokens[1]).getBytes("UTF-8")))
    if (signature2.endsWith('='))
        signature2 = signature2.substring(0, signature2.size() - 1)
    if (signature1Encoded.endsWith('='))
        signature1Encoded = signature1Encoded.substring(0, signature1Encoded.size() - 1)
    def res = [header: header, payload: payload, signature_valid: signature1Encoded == signature2]
    return res
}catch(Exception e){
    return ['error':e.getMessage()]
}
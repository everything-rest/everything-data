import org.apache.commons.codec.binary.Base64
if(action == 'encode')
    return Base64.encodeBase64String(input.getBytes())
if(action == 'decode')
    return new String(Base64.decodeBase64(input),'UTF-8')

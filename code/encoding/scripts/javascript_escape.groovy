import groovy.json.StringEscapeUtils
if(action == 'encode')
    return StringEscapeUtils.escapeJavaScript(input)
if(action == 'decode')
    return StringEscapeUtils.unescapeJavaScript(input)

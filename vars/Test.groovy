/**
 * Created by I319282 on 9/4/2017.
 */
import groovy.json.JsonSlurper;
import groovy.json.JsonOutput;
//import com.sap.gateway.ip.core.customdev.util.Message;

//def Message logAllHeaders(Message message) {
//    // Get headers
//    def headers = message.getHeaders();
//
//    // Create stringbuilder for containing headers
//    StringBuilder sb = new StringBuilder();
//
//    // Add headers to stringbuilder
//    if (headers == null) {
//        sb.append("No headers found.");
//    } else {
//        sb.append("Headers found.\n");
//
//        // Iterate headers and add to stringbuilder
//        headers.each{ k, v -> sb.append "\n${k} : ${v}" }
//    }
//
//    // Convert stringbuilder to string
//    String log = sb.toString();
//
//    // Write headers to log as attachment
//    def messageLog = messageLogFactory.getMessageLog(message);
//    if (messageLog != null) {
//        messageLog.addAttachmentAsString("Message Headers (all)", log, "text/plain");
//    }
//
//    // Return message
//    return message;
//}
//
//def Message logAllProperties(Message message) {
//    // Get headers
//    def props = message.getProperties();
//
//    // Create stringbuilder for containing headers
//    StringBuilder sb = new StringBuilder();
//
//    // Add headers to stringbuilder
//    if (props == null) {
//        sb.append("No headers found.");
//    } else {
//        sb.append("Headers found.\n");
//
//        // Iterate headers and add to stringbuilder
//        props.each{ k, v -> sb.append "\n${k} : ${v}" }
//    }
//
//    // Convert stringbuilder to string
//    String log = sb.toString();
//
//    // Write headers to log as attachment
//    def messageLog = messageLogFactory.getMessageLog(message);
//    if (messageLog != null) {
//        messageLog.addAttachmentAsString("Message Properties (all)", log, "text/plain");
//    }
//
//    // Return message
//    return message;
//}
//
//
//
//def Message processData(Message message) {
//
//    // get a map of iflow properties
//    def map = message.getProperties();
//
//    // get an exception java class instance
//    def ex = map.get("CamelExceptionCaught");
//    if (ex!=null) {
//
//        // an http adapter throws an instance of org.apache.camel.component.ahc.AhcOperationFailedException
//        if (ex.getClass().getCanonicalName().equals("org.apache.camel.component.ahc.AhcOperationFailedException")) {
//
//            // save the http error response as a message attachment
//            def messageLog = messageLogFactory.getMessageLog(message);
//            messageLog.addAttachmentAsString("http.ResponseBody", ex.getResponseBody(), "text/plain");
//
//            // copy the http error response to an iflow's property
//            message.setProperty("http.ResponseBody",ex.getResponseBody());
//
//            // copy the http error response to the message body
//            message.setBody(ex.getResponseBody());
//
//            // copy the value of http error code (i.e. 500) to a property
//            message.setProperty("http.StatusCode",ex.getStatusCode());
//
//            // copy the value of http error text (i.e. "Internal Server Error") to a property
//            message.setProperty("http.StatusText",ex.getStatusText());
//
//        }
//    }
//
//    return message;
//}
def rest = '{ "udm:Customer":{"customerType":"CORPORATE_CUSTOMER","fax":"","website":"","creditLimit":1,"remarks":"","phone1":"34234","contacts":[],"version":3,"id":"89823","email":"dylan.li@sap.com","customerCode":89823,"customerAddresses":[],"displayName":"","mobile":"890921"}}'

def jsonRest = new JsonSlurper().parseText(rest);


if(jsonRest["udm:Customer"].customerAddresses.size() == 0){
    jsonRest["udm:Customer"].remove("customerAddresses")
}

println(JsonOutput.toJson(jsonRest))
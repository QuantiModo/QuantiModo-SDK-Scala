package io.swagger.client.api

import io.swagger.client.model.Connector
import io.swagger.client.model.ConnectorInstruction
import io.swagger.client.model.ConnectorInfo
import io.swagger.client.ApiInvoker
import io.swagger.client.ApiException

import com.sun.jersey.multipart.FormDataMultiPart
import com.sun.jersey.multipart.file.FileDataBodyPart

import javax.ws.rs.core.MediaType

import java.io.File
import java.util.Date

import scala.collection.mutable.HashMap

class ConnectorsApi(val defBasePath: String = "https://localhost/api",
                        defApiInvoker: ApiInvoker = ApiInvoker) {
  var basePath = defBasePath
  var apiInvoker = defApiInvoker

  def addHeader(key: String, value: String) = apiInvoker.defaultHeaders += key -> value 

  
  /**
   * Get embeddable connect javascript
   * Get embeddable connect javascript. Usage:\n\n  - Embedding in applications with popups for 3rd-party authentication\nwindows.\n\n    Use `qmSetupInPopup` function after connecting `connect.js`.\n\n  - Embedding in applications with popups for 3rd-party authentication\nwindows.\n\n    Requires a selector to block. It will be embedded in this block.\n\n    Use `qmSetupOnPage` function after connecting `connect.js`.\n\n  - Embedding in mobile applications without popups for 3rd-party\nauthentication.\n\n    Use `qmSetupOnMobile` function after connecting `connect.js`.\n\n    if using the MoodiModo Clones, Use `qmSetupOnIonic` function after connecting `connect.js`.
   * @param access token User&#39;s access token
   * @param mashape key Mashape API key
   * @return void
   */
  def v1ConnectJsGet (access token: String, mashape key: String)  = {
    // create path and map variables
    val path = "/v1/connect.js".replaceAll("\\{format\\}","json")

    val contentTypes = List("application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

    

    if(String.valueOf(access token) != "null") queryParams += "access token" -> access token.toString
    if(String.valueOf(mashape key) != "null") queryParams += "mashape key" -> mashape key.toString
    
    
    

    var postBody: AnyRef = null

    if(contentType.startsWith("multipart/form-data")) {
      val mp = new FormDataMultiPart()
      
      postBody = mp
    }
    else {
      
    }

    try {
      apiInvoker.invokeApi(basePath, path, "GET", queryParams.toMap, formParams.toMap, postBody, headerParams.toMap, contentType) match {
        case s: String =>
           
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }
  
  /**
   * Mobile connect page
   * Mobile connect page
   * @param t User token
   * @return void
   */
  def v1ConnectMobileGet (t: String)  = {
    // create path and map variables
    val path = "/v1/connect/mobile".replaceAll("\\{format\\}","json")

    val contentTypes = List("application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

    

    if(String.valueOf(t) != "null") queryParams += "t" -> t.toString
    
    
    

    var postBody: AnyRef = null

    if(contentType.startsWith("multipart/form-data")) {
      val mp = new FormDataMultiPart()
      
      postBody = mp
    }
    else {
      
    }

    try {
      apiInvoker.invokeApi(basePath, path, "GET", queryParams.toMap, formParams.toMap, postBody, headerParams.toMap, contentType) match {
        case s: String =>
           
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }
  
  /**
   * List of Connectors
   * A connector pulls data from other data providers using their API or a screenscraper. Returns a list of all available connectors and information about them such as their id, name, whether the user has provided access, logo url, connection instructions, and the update history.
   * @return List[Connector]
   */
  def v1ConnectorsListGet () : Option[List[Connector]] = {
    // create path and map variables
    val path = "/v1/connectors/list".replaceAll("\\{format\\}","json")

    val contentTypes = List("application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

    

    
    
    

    var postBody: AnyRef = null

    if(contentType.startsWith("multipart/form-data")) {
      val mp = new FormDataMultiPart()
      
      postBody = mp
    }
    else {
      
    }

    try {
      apiInvoker.invokeApi(basePath, path, "GET", queryParams.toMap, formParams.toMap, postBody, headerParams.toMap, contentType) match {
        case s: String =>
           Some(ApiInvoker.deserialize(s, "array", classOf[Connector]).asInstanceOf[List[Connector]])
         
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }
  
  /**
   * Obtain a token from 3rd party data source
   * Attempt to obtain a token from the data provider, store it in the database. With this, the connector to continue to obtain new user data until the token is revoked.
   * @param connector Lowercase system name of the source application or device. Get a list of available connectors from the /connectors/list endpoint.
   * @return void
   */
  def v1ConnectorsConnectorConnectGet (connector: String)  = {
    // create path and map variables
    val path = "/v1/connectors/{connector}/connect".replaceAll("\\{format\\}","json").replaceAll("\\{" + "connector" + "\\}",apiInvoker.escape(connector))

    

    val contentTypes = List("application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

    

    
    
    

    var postBody: AnyRef = null

    if(contentType.startsWith("multipart/form-data")) {
      val mp = new FormDataMultiPart()
      
      postBody = mp
    }
    else {
      
    }

    try {
      apiInvoker.invokeApi(basePath, path, "GET", queryParams.toMap, formParams.toMap, postBody, headerParams.toMap, contentType) match {
        case s: String =>
           
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }
  
  /**
   * Connection Instructions
   * Returns instructions that describe what parameters and endpoint to use to connect to the given data provider.
   * @param connector Lowercase system name of the source application or device. Get a list of available connectors from the /connectors/list endpoint.
   * @param parameters JSON Array of Parameters for the request to enable connector.
   * @param url URL which should be used to enable the connector.
   * @param usePopup Should use popup when enabling connector
   * @return void
   */
  def v1ConnectorsConnectorConnectInstructionsGet (connector: String, parameters: String, url: String, usePopup: Boolean)  = {
    // create path and map variables
    val path = "/v1/connectors/{connector}/connectInstructions".replaceAll("\\{format\\}","json").replaceAll("\\{" + "connector" + "\\}",apiInvoker.escape(connector))

    

    val contentTypes = List("application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

    

    if(String.valueOf(parameters) != "null") queryParams += "parameters" -> parameters.toString
    if(String.valueOf(url) != "null") queryParams += "url" -> url.toString
    if(String.valueOf(usePopup) != "null") queryParams += "usePopup" -> usePopup.toString
    
    
    

    var postBody: AnyRef = null

    if(contentType.startsWith("multipart/form-data")) {
      val mp = new FormDataMultiPart()
      
      postBody = mp
    }
    else {
      
    }

    try {
      apiInvoker.invokeApi(basePath, path, "GET", queryParams.toMap, formParams.toMap, postBody, headerParams.toMap, contentType) match {
        case s: String =>
           
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }
  
  /**
   * Connect Parameter
   * Returns instructions that describe what parameters and endpoint to use to connect to the given data provider.
   * @param connector Lowercase system name of the source application or device. Get a list of available connectors from the /connectors/list endpoint.
   * @param displayName Name of the parameter that is user visible in the form
   * @param key Name of the property that the user has to enter such as username or password Connector (used in HTTP request)
   * @param placeholder Placeholder hint value for the parameter input tag.
   * @param _type Type of input field such as those found here http://www.w3schools.com/tags/tag_input.asp
   * @param usePopup Should use popup when enabling connector
   * @param defaultValue Default parameter value
   * @return ConnectorInstruction
   */
  def v1ConnectorsConnectorConnectParameterGet (connector: String, displayName: String, key: String, placeholder: String, _type: String, usePopup: Boolean, defaultValue: String) : Option[ConnectorInstruction] = {
    // create path and map variables
    val path = "/v1/connectors/{connector}/connectParameter".replaceAll("\\{format\\}","json").replaceAll("\\{" + "connector" + "\\}",apiInvoker.escape(connector))

    

    val contentTypes = List("application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

    

    if(String.valueOf(defaultValue) != "null") queryParams += "defaultValue" -> defaultValue.toString
    if(String.valueOf(displayName) != "null") queryParams += "displayName" -> displayName.toString
    if(String.valueOf(key) != "null") queryParams += "key" -> key.toString
    if(String.valueOf(placeholder) != "null") queryParams += "placeholder" -> placeholder.toString
    if(String.valueOf(_type) != "null") queryParams += "type" -> _type.toString
    if(String.valueOf(usePopup) != "null") queryParams += "usePopup" -> usePopup.toString
    
    
    

    var postBody: AnyRef = null

    if(contentType.startsWith("multipart/form-data")) {
      val mp = new FormDataMultiPart()
      
      postBody = mp
    }
    else {
      
    }

    try {
      apiInvoker.invokeApi(basePath, path, "GET", queryParams.toMap, formParams.toMap, postBody, headerParams.toMap, contentType) match {
        case s: String =>
           Some(ApiInvoker.deserialize(s, "", classOf[ConnectorInstruction]).asInstanceOf[ConnectorInstruction])
         
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }
  
  /**
   * Delete stored connection info
   * The disconnect method deletes any stored tokens or connection information from the connectors database.
   * @param connector Lowercase system name of the source application or device. Get a list of available connectors from the /connectors/list endpoint.
   * @return void
   */
  def v1ConnectorsConnectorDisconnectGet (connector: String)  = {
    // create path and map variables
    val path = "/v1/connectors/{connector}/disconnect".replaceAll("\\{format\\}","json").replaceAll("\\{" + "connector" + "\\}",apiInvoker.escape(connector))

    

    val contentTypes = List("application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

    

    
    
    

    var postBody: AnyRef = null

    if(contentType.startsWith("multipart/form-data")) {
      val mp = new FormDataMultiPart()
      
      postBody = mp
    }
    else {
      
    }

    try {
      apiInvoker.invokeApi(basePath, path, "GET", queryParams.toMap, formParams.toMap, postBody, headerParams.toMap, contentType) match {
        case s: String =>
           
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }
  
  /**
   * Get connector info for user
   * Returns information about the connector such as the connector id, whether or not is connected for this user (i.e. we have a token or credentials), and its update history for the user.
   * @param connector Lowercase system name of the source application or device. Get a list of available connectors from the /connectors/list endpoint.
   * @return ConnectorInfo
   */
  def v1ConnectorsConnectorInfoGet (connector: String) : Option[ConnectorInfo] = {
    // create path and map variables
    val path = "/v1/connectors/{connector}/info".replaceAll("\\{format\\}","json").replaceAll("\\{" + "connector" + "\\}",apiInvoker.escape(connector))

    

    val contentTypes = List("application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

    

    
    
    

    var postBody: AnyRef = null

    if(contentType.startsWith("multipart/form-data")) {
      val mp = new FormDataMultiPart()
      
      postBody = mp
    }
    else {
      
    }

    try {
      apiInvoker.invokeApi(basePath, path, "GET", queryParams.toMap, formParams.toMap, postBody, headerParams.toMap, contentType) match {
        case s: String =>
           Some(ApiInvoker.deserialize(s, "", classOf[ConnectorInfo]).asInstanceOf[ConnectorInfo])
         
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }
  
  /**
   * Sync with data source
   * The update method tells the QM Connector Framework to check with the data provider (such as Fitbit or MyFitnessPal) and retrieve any new measurements available.
   * @param connector Lowercase system name of the source application or device
   * @return void
   */
  def v1ConnectorsConnectorUpdateGet (connector: String)  = {
    // create path and map variables
    val path = "/v1/connectors/{connector}/update".replaceAll("\\{format\\}","json").replaceAll("\\{" + "connector" + "\\}",apiInvoker.escape(connector))

    

    val contentTypes = List("application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

    

    
    
    

    var postBody: AnyRef = null

    if(contentType.startsWith("multipart/form-data")) {
      val mp = new FormDataMultiPart()
      
      postBody = mp
    }
    else {
      
    }

    try {
      apiInvoker.invokeApi(basePath, path, "GET", queryParams.toMap, formParams.toMap, postBody, headerParams.toMap, contentType) match {
        case s: String =>
           
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }
  
}

package io.swagger.client.api

import io.swagger.client.model.Inline_response_200_4
import io.swagger.client.model.Inline_response_200_19
import io.swagger.client.model.Credential
import io.swagger.client.model.Inline_response_200_2
import io.swagger.client.ApiInvoker
import io.swagger.client.ApiException

import com.sun.jersey.multipart.FormDataMultiPart
import com.sun.jersey.multipart.file.FileDataBodyPart

import javax.ws.rs.core.MediaType

import java.io.File
import java.util.Date

import scala.collection.mutable.HashMap

class CredentialApi(val defBasePath: String = "https://app.quantimo.do/api/v2",
                        defApiInvoker: ApiInvoker = ApiInvoker) {
  var basePath = defBasePath
  var apiInvoker = defApiInvoker

  def addHeader(key: String, value: String) = apiInvoker.defaultHeaders += key -> value 

  
  /**
   * Get all Credentials
   * Get all Credentials
   * @param accessToken User&#39;s OAuth2 access token
   * @param userId ID of user that owns this credential
   * @param connectorId The id for the connector data source from which the credential was obtained
   * @param attrKey Attribute name such as token, userid, username, or password
   * @param attrValue Encrypted value for the attribute specified
   * @param createdAt When the record was first created. Use ISO 8601 datetime format
   * @param updatedAt When the record was last updated. Use ISO 8601 datetime format
   * @param limit The LIMIT is used to limit the number of results returned. So if you have 1000 results, but only want to the first 10, you would set this to 10 and offset to 0. The maximum limit is 200 records.
   * @param offset OFFSET says to skip that many rows before beginning to return rows to the client. OFFSET 0 is the same as omitting the OFFSET clause. If both OFFSET and LIMIT appear, then OFFSET rows are skipped before starting to count the LIMIT rows that are returned.
   * @param sort Sort by given field. If the field is prefixed with &#39;-&#39;, it will sort in descending order.
   * @return Inline_response_200_4
   */
  def credentialsGet (accessToken: String, userId: Integer, connectorId: Integer, attrKey: String, attrValue: String, createdAt: String, updatedAt: String, limit: Integer, offset: Integer, sort: String) : Option[Inline_response_200_4] = {
    // create path and map variables
    val path = "/credentials".replaceAll("\\{format\\}","json")

    val contentTypes = List("application/json", "application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

    

    if(String.valueOf(accessToken) != "null") queryParams += "access_token" -> accessToken.toString
    if(String.valueOf(userId) != "null") queryParams += "user_id" -> userId.toString
    if(String.valueOf(connectorId) != "null") queryParams += "connector_id" -> connectorId.toString
    if(String.valueOf(attrKey) != "null") queryParams += "attr_key" -> attrKey.toString
    if(String.valueOf(attrValue) != "null") queryParams += "attr_value" -> attrValue.toString
    if(String.valueOf(createdAt) != "null") queryParams += "created_at" -> createdAt.toString
    if(String.valueOf(updatedAt) != "null") queryParams += "updated_at" -> updatedAt.toString
    if(String.valueOf(limit) != "null") queryParams += "limit" -> limit.toString
    if(String.valueOf(offset) != "null") queryParams += "offset" -> offset.toString
    if(String.valueOf(sort) != "null") queryParams += "sort" -> sort.toString
    
    
    

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
           Some(ApiInvoker.deserialize(s, "", classOf[Inline_response_200_4]).asInstanceOf[Inline_response_200_4])
         
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }
  
  /**
   * Store Credential
   * Store Credential
   * @param accessToken User&#39;s OAuth2 access token
   * @param body Credential that should be stored
   * @return Inline_response_200_19
   */
  def credentialsPost (accessToken: String, body: Credential) : Option[Inline_response_200_19] = {
    // create path and map variables
    val path = "/credentials".replaceAll("\\{format\\}","json")

    val contentTypes = List("application/json", "application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

    

    if(String.valueOf(accessToken) != "null") queryParams += "access_token" -> accessToken.toString
    
    
    

    var postBody: AnyRef = body

    if(contentType.startsWith("multipart/form-data")) {
      val mp = new FormDataMultiPart()
      
      postBody = mp
    }
    else {
      
    }

    try {
      apiInvoker.invokeApi(basePath, path, "POST", queryParams.toMap, formParams.toMap, postBody, headerParams.toMap, contentType) match {
        case s: String =>
           Some(ApiInvoker.deserialize(s, "", classOf[Inline_response_200_19]).asInstanceOf[Inline_response_200_19])
         
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }
  
  /**
   * Get Credential
   * Get Credential
   * @param id connector id
   * @param attrKey attrKey
   * @param accessToken User&#39;s OAuth2 access token
   * @return Inline_response_200_19
   */
  def credentialsIdGet (id: Integer, attrKey: String, accessToken: String) : Option[Inline_response_200_19] = {
    // create path and map variables
    val path = "/credentials/{id}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "id" + "\\}",apiInvoker.escape(id))

    

    val contentTypes = List("application/json", "application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

    

    if(String.valueOf(accessToken) != "null") queryParams += "access_token" -> accessToken.toString
    if(String.valueOf(attrKey) != "null") queryParams += "attrKey" -> attrKey.toString
    
    
    

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
           Some(ApiInvoker.deserialize(s, "", classOf[Inline_response_200_19]).asInstanceOf[Inline_response_200_19])
         
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }
  
  /**
   * Update Credential
   * Update Credential
   * @param id connector id
   * @param attrKey attrKey
   * @param accessToken User&#39;s OAuth2 access token
   * @param body Credential that should be updated
   * @return Inline_response_200_2
   */
  def credentialsIdPut (id: Integer, attrKey: String, accessToken: String, body: Credential) : Option[Inline_response_200_2] = {
    // create path and map variables
    val path = "/credentials/{id}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "id" + "\\}",apiInvoker.escape(id))

    

    val contentTypes = List("application/json", "application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

    

    if(String.valueOf(accessToken) != "null") queryParams += "access_token" -> accessToken.toString
    if(String.valueOf(attrKey) != "null") queryParams += "attrKey" -> attrKey.toString
    
    
    

    var postBody: AnyRef = body

    if(contentType.startsWith("multipart/form-data")) {
      val mp = new FormDataMultiPart()
      
      postBody = mp
    }
    else {
      
    }

    try {
      apiInvoker.invokeApi(basePath, path, "PUT", queryParams.toMap, formParams.toMap, postBody, headerParams.toMap, contentType) match {
        case s: String =>
           Some(ApiInvoker.deserialize(s, "", classOf[Inline_response_200_2]).asInstanceOf[Inline_response_200_2])
         
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }
  
  /**
   * Delete Credential
   * Delete Credential
   * @param id connector id
   * @param attrKey attrKey
   * @param accessToken User&#39;s OAuth2 access token
   * @return Inline_response_200_2
   */
  def credentialsIdDelete (id: Integer, attrKey: String, accessToken: String) : Option[Inline_response_200_2] = {
    // create path and map variables
    val path = "/credentials/{id}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "id" + "\\}",apiInvoker.escape(id))

    

    val contentTypes = List("application/json", "application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

    

    if(String.valueOf(accessToken) != "null") queryParams += "access_token" -> accessToken.toString
    if(String.valueOf(attrKey) != "null") queryParams += "attrKey" -> attrKey.toString
    
    
    

    var postBody: AnyRef = null

    if(contentType.startsWith("multipart/form-data")) {
      val mp = new FormDataMultiPart()
      
      postBody = mp
    }
    else {
      
    }

    try {
      apiInvoker.invokeApi(basePath, path, "DELETE", queryParams.toMap, formParams.toMap, postBody, headerParams.toMap, contentType) match {
        case s: String =>
           Some(ApiInvoker.deserialize(s, "", classOf[Inline_response_200_2]).asInstanceOf[Inline_response_200_2])
         
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }
  
}

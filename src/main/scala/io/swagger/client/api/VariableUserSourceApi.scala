package io.swagger.client.api

import io.swagger.client.model.Inline_response_200_10
import io.swagger.client.model.VariableUserSource
import io.swagger.client.model.Inline_response_200_33
import io.swagger.client.model.Inline_response_200_2
import io.swagger.client.ApiInvoker
import io.swagger.client.ApiException

import com.sun.jersey.multipart.FormDataMultiPart
import com.sun.jersey.multipart.file.FileDataBodyPart

import javax.ws.rs.core.MediaType

import java.io.File
import java.util.Date

import scala.collection.mutable.HashMap

class VariableUserSourceApi(val defBasePath: String = "https://app.quantimo.do/api/v2",
                        defApiInvoker: ApiInvoker = ApiInvoker) {
  var basePath = defBasePath
  var apiInvoker = defApiInvoker

  def addHeader(key: String, value: String) = apiInvoker.defaultHeaders += key -> value 

  
  /**
   * Get all VariableUserSources
   * Get all VariableUserSources
   * @param accessToken User&#39;s OAuth2 access token
   * @param variableId ID of variable
   * @param userId ID of User
   * @param timestamp Time that this measurement occurred Uses epoch minute (epoch time divided by 60)
   * @param earliestMeasurementTime Earliest measurement time
   * @param latestMeasurementTime Latest measurement time
   * @param createdAt When the record was first created. Use ISO 8601 datetime format
   * @param updatedAt When the record was last updated. Use ISO 8601 datetime format
   * @param limit The LIMIT is used to limit the number of results returned. So if you have 1000 results, but only want to the first 10, you would set this to 10 and offset to 0. The maximum limit is 200 records.
   * @param offset OFFSET says to skip that many rows before beginning to return rows to the client. OFFSET 0 is the same as omitting the OFFSET clause. If both OFFSET and LIMIT appear, then OFFSET rows are skipped before starting to count the LIMIT rows that are returned.
   * @param sort Sort by given field. If the field is prefixed with &#39;-&#39;, it will sort in descending order.
   * @return Inline_response_200_10
   */
  def variableUserSourcesGet (accessToken: String, variableId: Integer, userId: Integer, timestamp: Integer, earliestMeasurementTime: Integer, latestMeasurementTime: Integer, createdAt: String, updatedAt: String, limit: Integer, offset: Integer, sort: String) : Option[Inline_response_200_10] = {
    // create path and map variables
    val path = "/variableUserSources".replaceAll("\\{format\\}","json")

    val contentTypes = List("application/json", "application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

    

    if(String.valueOf(accessToken) != "null") queryParams += "access_token" -> accessToken.toString
    if(String.valueOf(variableId) != "null") queryParams += "variable_id" -> variableId.toString
    if(String.valueOf(userId) != "null") queryParams += "user_id" -> userId.toString
    if(String.valueOf(timestamp) != "null") queryParams += "timestamp" -> timestamp.toString
    if(String.valueOf(earliestMeasurementTime) != "null") queryParams += "earliest_measurement_time" -> earliestMeasurementTime.toString
    if(String.valueOf(latestMeasurementTime) != "null") queryParams += "latest_measurement_time" -> latestMeasurementTime.toString
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
           Some(ApiInvoker.deserialize(s, "", classOf[Inline_response_200_10]).asInstanceOf[Inline_response_200_10])
         
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }
  
  /**
   * Store VariableUserSource
   * Store VariableUserSource
   * @param accessToken User&#39;s OAuth2 access token
   * @param body VariableUserSource that should be stored
   * @return Inline_response_200_33
   */
  def variableUserSourcesPost (accessToken: String, body: VariableUserSource) : Option[Inline_response_200_33] = {
    // create path and map variables
    val path = "/variableUserSources".replaceAll("\\{format\\}","json")

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
           Some(ApiInvoker.deserialize(s, "", classOf[Inline_response_200_33]).asInstanceOf[Inline_response_200_33])
         
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }
  
  /**
   * Get VariableUserSource
   * Get VariableUserSource
   * @param id id of VariableUserSource
   * @param sourceId source id of VariableUserSource
   * @param accessToken User&#39;s OAuth2 access token
   * @return Inline_response_200_33
   */
  def variableUserSourcesIdGet (id: Integer, sourceId: Integer, accessToken: String) : Option[Inline_response_200_33] = {
    // create path and map variables
    val path = "/variableUserSources/{id}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "id" + "\\}",apiInvoker.escape(id))

    

    val contentTypes = List("application/json", "application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

    

    if(String.valueOf(accessToken) != "null") queryParams += "access_token" -> accessToken.toString
    if(String.valueOf(sourceId) != "null") queryParams += "source_id" -> sourceId.toString
    
    
    

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
           Some(ApiInvoker.deserialize(s, "", classOf[Inline_response_200_33]).asInstanceOf[Inline_response_200_33])
         
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }
  
  /**
   * Update VariableUserSource
   * Update VariableUserSource
   * @param id variable_id of VariableUserSource
   * @param sourceId source id of VariableUserSource
   * @param accessToken User&#39;s OAuth2 access token
   * @param body VariableUserSource that should be updated
   * @return Inline_response_200_2
   */
  def variableUserSourcesIdPut (id: Integer, sourceId: Integer, accessToken: String, body: VariableUserSource) : Option[Inline_response_200_2] = {
    // create path and map variables
    val path = "/variableUserSources/{id}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "id" + "\\}",apiInvoker.escape(id))

    

    val contentTypes = List("application/json", "application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

    

    if(String.valueOf(accessToken) != "null") queryParams += "access_token" -> accessToken.toString
    if(String.valueOf(sourceId) != "null") queryParams += "source_id" -> sourceId.toString
    
    
    

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
   * Delete VariableUserSource
   * Delete VariableUserSource
   * @param id variable_id of VariableUserSource
   * @param sourceId source id of VariableUserSource
   * @param accessToken User&#39;s OAuth2 access token
   * @return Inline_response_200_2
   */
  def variableUserSourcesIdDelete (id: Integer, sourceId: Integer, accessToken: String) : Option[Inline_response_200_2] = {
    // create path and map variables
    val path = "/variableUserSources/{id}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "id" + "\\}",apiInvoker.escape(id))

    

    val contentTypes = List("application/json", "application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

    

    if(String.valueOf(accessToken) != "null") queryParams += "access_token" -> accessToken.toString
    if(String.valueOf(sourceId) != "null") queryParams += "source_id" -> sourceId.toString
    
    
    

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

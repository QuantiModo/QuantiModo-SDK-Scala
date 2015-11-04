package io.swagger.client.api

import io.swagger.client.model.Inline_response_200_3
import io.swagger.client.model.Inline_response_200_4
import io.swagger.client.model.Connection
import io.swagger.client.model.Inline_response_200_2
import io.swagger.client.ApiInvoker
import io.swagger.client.ApiException

import com.sun.jersey.multipart.FormDataMultiPart
import com.sun.jersey.multipart.file.FileDataBodyPart

import javax.ws.rs.core.MediaType

import java.io.File
import java.util.Date

import scala.collection.mutable.HashMap

class ConnectionApi(val defBasePath: String = "https://app.quantimo.do/api/v2",
                        defApiInvoker: ApiInvoker = ApiInvoker) {
  var basePath = defBasePath
  var apiInvoker = defApiInvoker

  def addHeader(key: String, value: String) = apiInvoker.defaultHeaders += key -> value 

  
  /**
   * Get all Connections
   * Get all Connections
   * @param userId user_id
   * @param connectorId connector_id
   * @param connectStatus connect_status
   * @param connectError connect_error
   * @param updateRequestedAt update_requested_at
   * @param updateStatus update_status
   * @param updateError update_error
   * @param lastSuccessfulUpdatedAt last_successful_updated_at
   * @param createdAt created_at
   * @param updatedAt updated_at
   * @param limit limit
   * @param offset offset
   * @param sort sort
   * @return Inline_response_200_3
   */
  def connectionsGet (userId: Integer, connectorId: Integer, connectStatus: String, connectError: String, updateRequestedAt: String, updateStatus: String, updateError: String, lastSuccessfulUpdatedAt: String, createdAt: String, updatedAt: String, limit: Integer, offset: Integer, sort: String) : Option[Inline_response_200_3] = {
    // create path and map variables
    val path = "/connections".replaceAll("\\{format\\}","json")

    val contentTypes = List("application/json", "application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

    

    if(String.valueOf(userId) != "null") queryParams += "user_id" -> userId.toString
    if(String.valueOf(connectorId) != "null") queryParams += "connector_id" -> connectorId.toString
    if(String.valueOf(connectStatus) != "null") queryParams += "connect_status" -> connectStatus.toString
    if(String.valueOf(connectError) != "null") queryParams += "connect_error" -> connectError.toString
    if(String.valueOf(updateRequestedAt) != "null") queryParams += "update_requested_at" -> updateRequestedAt.toString
    if(String.valueOf(updateStatus) != "null") queryParams += "update_status" -> updateStatus.toString
    if(String.valueOf(updateError) != "null") queryParams += "update_error" -> updateError.toString
    if(String.valueOf(lastSuccessfulUpdatedAt) != "null") queryParams += "last_successful_updated_at" -> lastSuccessfulUpdatedAt.toString
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
           Some(ApiInvoker.deserialize(s, "", classOf[Inline_response_200_3]).asInstanceOf[Inline_response_200_3])
         
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }
  
  /**
   * Store Connection
   * Store Connection
   * @param body Connection that should be stored
   * @return Inline_response_200_4
   */
  def connectionsPost (body: Connection) : Option[Inline_response_200_4] = {
    // create path and map variables
    val path = "/connections".replaceAll("\\{format\\}","json")

    val contentTypes = List("application/json", "application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

    

    
    
    

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
           Some(ApiInvoker.deserialize(s, "", classOf[Inline_response_200_4]).asInstanceOf[Inline_response_200_4])
         
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }
  
  /**
   * Get Connection
   * Get Connection
   * @param id id of Connection
   * @return Inline_response_200_4
   */
  def connectionsIdGet (id: Integer) : Option[Inline_response_200_4] = {
    // create path and map variables
    val path = "/connections/{id}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "id" + "\\}",apiInvoker.escape(id))

    

    val contentTypes = List("application/json", "application/json")
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
           Some(ApiInvoker.deserialize(s, "", classOf[Inline_response_200_4]).asInstanceOf[Inline_response_200_4])
         
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }
  
  /**
   * Update Connection
   * Update Connection
   * @param id id of Connection
   * @param body Connection that should be updated
   * @return Inline_response_200_2
   */
  def connectionsIdPut (id: Integer, body: Connection) : Option[Inline_response_200_2] = {
    // create path and map variables
    val path = "/connections/{id}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "id" + "\\}",apiInvoker.escape(id))

    

    val contentTypes = List("application/json", "application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

    

    
    
    

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
   * Delete Connection
   * Delete Connection
   * @param id id of Connection
   * @return Inline_response_200_2
   */
  def connectionsIdDelete (id: Integer) : Option[Inline_response_200_2] = {
    // create path and map variables
    val path = "/connections/{id}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "id" + "\\}",apiInvoker.escape(id))

    

    val contentTypes = List("application/json", "application/json")
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

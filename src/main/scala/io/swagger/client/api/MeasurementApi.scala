package io.swagger.client.api

import io.swagger.client.model.Number
import io.swagger.client.model.Inline_response_200_11
import io.swagger.client.model.MeasurementPost
import java.io.File
import io.swagger.client.model.Inline_response_200_12
import io.swagger.client.model.Measurement
import io.swagger.client.model.Inline_response_200_2
import io.swagger.client.ApiInvoker
import io.swagger.client.ApiException

import com.sun.jersey.multipart.FormDataMultiPart
import com.sun.jersey.multipart.file.FileDataBodyPart

import javax.ws.rs.core.MediaType

import java.io.File
import java.util.Date

import scala.collection.mutable.HashMap

class MeasurementApi(val defBasePath: String = "https://app.quantimo.do/api/v2",
                        defApiInvoker: ApiInvoker = ApiInvoker) {
  var basePath = defBasePath
  var apiInvoker = defApiInvoker

  def addHeader(key: String, value: String) = apiInvoker.defaultHeaders += key -> value 

  
  /**
   * Get all Measurements
   * Get all Measurements
   * @param userId user_id
   * @param clientId client_id
   * @param connectorId connector_id
   * @param variableId variable_id
   * @param startTime start_time
   * @param value value
   * @param originalValue original_value
   * @param duration duration
   * @param note note
   * @param latitude latitude
   * @param longitude longitude
   * @param location location
   * @param createdAt created_at
   * @param updatedAt updated_at
   * @param error error
   * @param limit limit
   * @param offset offset
   * @param sort sort
   * @return Inline_response_200_11
   */
  def measurementsGet (userId: Integer, clientId: String, connectorId: Integer, variableId: Integer, startTime: Integer, value: Number, originalValue: Number, duration: Integer, note: String, latitude: Number, longitude: Number, location: String, createdAt: String, updatedAt: String, error: String, limit: Integer, offset: Integer, sort: String) : Option[Inline_response_200_11] = {
    // create path and map variables
    val path = "/measurements".replaceAll("\\{format\\}","json")

    val contentTypes = List("application/json", "application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

    

    if(String.valueOf(userId) != "null") queryParams += "user_id" -> userId.toString
    if(String.valueOf(clientId) != "null") queryParams += "client_id" -> clientId.toString
    if(String.valueOf(connectorId) != "null") queryParams += "connector_id" -> connectorId.toString
    if(String.valueOf(variableId) != "null") queryParams += "variable_id" -> variableId.toString
    if(String.valueOf(startTime) != "null") queryParams += "start_time" -> startTime.toString
    if(String.valueOf(value) != "null") queryParams += "value" -> value.toString
    if(String.valueOf(originalValue) != "null") queryParams += "original_value" -> originalValue.toString
    if(String.valueOf(duration) != "null") queryParams += "duration" -> duration.toString
    if(String.valueOf(note) != "null") queryParams += "note" -> note.toString
    if(String.valueOf(latitude) != "null") queryParams += "latitude" -> latitude.toString
    if(String.valueOf(longitude) != "null") queryParams += "longitude" -> longitude.toString
    if(String.valueOf(location) != "null") queryParams += "location" -> location.toString
    if(String.valueOf(createdAt) != "null") queryParams += "created_at" -> createdAt.toString
    if(String.valueOf(updatedAt) != "null") queryParams += "updated_at" -> updatedAt.toString
    if(String.valueOf(error) != "null") queryParams += "error" -> error.toString
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
           Some(ApiInvoker.deserialize(s, "", classOf[Inline_response_200_11]).asInstanceOf[Inline_response_200_11])
         
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }
  
  /**
   * Store Measurement
   * Store Measurement
   * @param body Measurement that should be stored
   * @return Inline_response_200_11
   */
  def measurementsPost (body: MeasurementPost) : Option[Inline_response_200_11] = {
    // create path and map variables
    val path = "/measurements".replaceAll("\\{format\\}","json")

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
           Some(ApiInvoker.deserialize(s, "", classOf[Inline_response_200_11]).asInstanceOf[Inline_response_200_11])
         
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }
  
  /**
   * Get Measurements CSV
   * Download a CSV containing all user measurements
   * @return File
   */
  def measurementsCsvGet () : Option[File] = {
    // create path and map variables
    val path = "/measurements/csv".replaceAll("\\{format\\}","json")

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
           Some(ApiInvoker.deserialize(s, "", classOf[File]).asInstanceOf[File])
         
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }
  
  /**
   * Post Request for Measurements CSV
   * Use this endpoint to schedule a CSV export containing all user measurements to be emailed to the user within 24 hours.
   * @return Integer
   */
  def measurementsRequestCsvPost () : Option[Integer] = {
    // create path and map variables
    val path = "/measurements/request_csv".replaceAll("\\{format\\}","json")

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
      apiInvoker.invokeApi(basePath, path, "POST", queryParams.toMap, formParams.toMap, postBody, headerParams.toMap, contentType) match {
        case s: String =>
           Some(ApiInvoker.deserialize(s, "", classOf[Integer]).asInstanceOf[Integer])
         
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }
  
  /**
   * Get Measurement
   * Get Measurement
   * @param id id of Measurement
   * @return Inline_response_200_12
   */
  def measurementsIdGet (id: Integer) : Option[Inline_response_200_12] = {
    // create path and map variables
    val path = "/measurements/{id}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "id" + "\\}",apiInvoker.escape(id))

    

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
           Some(ApiInvoker.deserialize(s, "", classOf[Inline_response_200_12]).asInstanceOf[Inline_response_200_12])
         
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }
  
  /**
   * Update Measurement
   * Update Measurement
   * @param id id of Measurement
   * @param body Measurement that should be updated
   * @return Inline_response_200_2
   */
  def measurementsIdPut (id: Integer, body: Measurement) : Option[Inline_response_200_2] = {
    // create path and map variables
    val path = "/measurements/{id}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "id" + "\\}",apiInvoker.escape(id))

    

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
   * Delete Measurement
   * Delete Measurement
   * @param id id of Measurement
   * @return Inline_response_200_2
   */
  def measurementsIdDelete (id: Integer) : Option[Inline_response_200_2] = {
    // create path and map variables
    val path = "/measurements/{id}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "id" + "\\}",apiInvoker.escape(id))

    

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

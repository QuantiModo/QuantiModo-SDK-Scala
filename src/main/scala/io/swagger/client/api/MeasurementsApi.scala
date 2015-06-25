package io.swagger.client.api

import io.swagger.client.model.MeasurementSource
import io.swagger.client.model.Measurement
import io.swagger.client.model.MeasurementSet
import io.swagger.client.model.MeasurementRange
import io.swagger.client.ApiInvoker
import io.swagger.client.ApiException

import com.sun.jersey.multipart.FormDataMultiPart
import com.sun.jersey.multipart.file.FileDataBodyPart

import javax.ws.rs.core.MediaType

import java.io.File
import java.util.Date

import scala.collection.mutable.HashMap

class MeasurementsApi(val defBasePath: String = "https://localhost/api",
                        defApiInvoker: ApiInvoker = ApiInvoker) {
  var basePath = defBasePath
  var apiInvoker = defApiInvoker

  def addHeader(key: String, value: String) = apiInvoker.defaultHeaders += key -> value 

  
  /**
   * Get measurement sources
   * Returns a list of all the apps from which measurement data is obtained.
   * @return MeasurementSource
   */
  def measurementSourcesGet () : Option[MeasurementSource] = {
    // create path and map variables
    val path = "/measurementSources".replaceAll("\\{format\\}","json")

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
           Some(ApiInvoker.deserialize(s, "", classOf[MeasurementSource]).asInstanceOf[MeasurementSource])
         
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }
  
  /**
   * Add a data source
   * Add a life-tracking app or device to the QuantiModo list of data sources.
   * @param name An array of names of data sources you want to add.
   * @return void
   */
  def measurementSourcesPost (name: MeasurementSource)  = {
    // create path and map variables
    val path = "/measurementSources".replaceAll("\\{format\\}","json")

    val contentTypes = List("application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

    

    
    
    

    var postBody: AnyRef = name

    if(contentType.startsWith("multipart/form-data")) {
      val mp = new FormDataMultiPart()
      
      postBody = mp
    }
    else {
      
    }

    try {
      apiInvoker.invokeApi(basePath, path, "POST", queryParams.toMap, formParams.toMap, postBody, headerParams.toMap, contentType) match {
        case s: String =>
           
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }
  
  /**
   * Get measurements for this user
   * Measurements are any value that can be recorded like daily steps, a mood rating, or apples eaten.
   * @param variableName Name of the variable you want measurements for
   * @param unit The unit your want the measurements in
   * @param startTime The lower limit of measurements returned (Epoch)
   * @param endTime The upper limit of measurements returned (Epoch)
   * @param groupingWidth The time (in seconds) over which measurements are grouped together
   * @param groupingTimezone The time (in seconds) over which measurements are grouped together
   * @return Measurement
   */
  def measurementsGet (variableName: String, unit: String, startTime: String, endTime: String, groupingWidth: Integer, groupingTimezone: String) : Option[Measurement] = {
    // create path and map variables
    val path = "/measurements".replaceAll("\\{format\\}","json")

    val contentTypes = List("application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

    

    if(String.valueOf(variableName) != "null") queryParams += "variableName" -> variableName.toString
    if(String.valueOf(unit) != "null") queryParams += "unit" -> unit.toString
    if(String.valueOf(startTime) != "null") queryParams += "startTime" -> startTime.toString
    if(String.valueOf(endTime) != "null") queryParams += "endTime" -> endTime.toString
    if(String.valueOf(groupingWidth) != "null") queryParams += "groupingWidth" -> groupingWidth.toString
    if(String.valueOf(groupingTimezone) != "null") queryParams += "groupingTimezone" -> groupingTimezone.toString
    
    
    

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
           Some(ApiInvoker.deserialize(s, "", classOf[Measurement]).asInstanceOf[Measurement])
         
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }
  
  /**
   * Post a new set or update existing measurements to the database
   * You can submit or update multiple measurements in a \&quot;measurements\&quot; sub-array.  If the variable these measurements correspond to does not already exist in the database, it will be automatically added.  The request body should look something like [{\&quot;measurements\&quot;:[{\&quot;timestamp\&quot;:1406419860,\&quot;value\&quot;:\&quot;1\&quot;,\&quot;note\&quot;:\&quot;I am a note about back pain.\&quot;},{\&quot;timestamp\&quot;:1406519865,\&quot;value\&quot;:\&quot;3\&quot;,\&quot;note\&quot;:\&quot;I am another note about back pain.\&quot;}],\&quot;name\&quot;:\&quot;Back Pain\&quot;,\&quot;source\&quot;:\&quot;QuantiModo\&quot;,\&quot;category\&quot;:\&quot;Symptoms\&quot;,\&quot;combinationOperation\&quot;:\&quot;MEAN\&quot;,\&quot;unit\&quot;:\&quot;/5\&quot;}]
   * @param measurements An array of measurements you want to insert.
   * @return void
   */
  def measurementsV2Post (measurements: MeasurementSet)  = {
    // create path and map variables
    val path = "/measurements/v2".replaceAll("\\{format\\}","json")

    val contentTypes = List("application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

    

    
    
    

    var postBody: AnyRef = measurements

    if(contentType.startsWith("multipart/form-data")) {
      val mp = new FormDataMultiPart()
      
      postBody = mp
    }
    else {
      
    }

    try {
      apiInvoker.invokeApi(basePath, path, "POST", queryParams.toMap, formParams.toMap, postBody, headerParams.toMap, contentType) match {
        case s: String =>
           
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }
  
  /**
   * Get measurements range for this user
   * Get Unix time-stamp (epoch time) of the user&#39;s first and last measurements taken.
   * @param sources Enter source name to limit to specific source (varchar)
   * @param user If not specified, uses currently logged in user (bigint)
   * @return MeasurementRange
   */
  def measurementsRangeGet (sources: String, user: Integer) : Option[MeasurementRange] = {
    // create path and map variables
    val path = "/measurementsRange".replaceAll("\\{format\\}","json")

    val contentTypes = List("application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

    

    if(String.valueOf(sources) != "null") queryParams += "sources" -> sources.toString
    if(String.valueOf(user) != "null") queryParams += "user" -> user.toString
    
    
    

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
           Some(ApiInvoker.deserialize(s, "", classOf[MeasurementRange]).asInstanceOf[MeasurementRange])
         
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }
  
}

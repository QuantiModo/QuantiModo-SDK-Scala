package io.swagger.client.api

import io.swagger.client.model.Pairs
import io.swagger.client.ApiInvoker
import io.swagger.client.ApiException

import com.sun.jersey.multipart.FormDataMultiPart
import com.sun.jersey.multipart.file.FileDataBodyPart

import javax.ws.rs.core.MediaType

import java.io.File
import java.util.Date

import scala.collection.mutable.HashMap

class PairsApi(val defBasePath: String = "https://localhost/api",
                        defApiInvoker: ApiInvoker = ApiInvoker) {
  var basePath = defBasePath
  var apiInvoker = defApiInvoker

  def addHeader(key: String, value: String) = apiInvoker.defaultHeaders += key -> value 

  
  /**
   * Get pairs
   * Pairs cause measurements with effect measurements grouped over the duration of action after the onset delay.
   * @param cause Original variable name for the explanatory or independent variable
   * @param causeSource Name of data source that the cause measurements should come from
   * @param causeUnit Abbreviated name for the unit cause measurements to be returned in
   * @param delay Delay before onset of action (in seconds) from the cause variable settings.
   * @param duration Duration of action (in seconds) from the cause variable settings.
   * @param effect Original variable name for the outcome or dependent variable
   * @param effectSource Name of data source that the effectmeasurements should come from
   * @param effectUnit Abbreviated name for the unit effect measurements to be returned in
   * @param endTime The most recent date (in epoch time) for which we should return measurements
   * @param startTime The earliest date (in epoch time) for which we should return measurements
   * @return void
   */
  def pairsGet (cause: String, causeSource: String, causeUnit: String, delay: String, duration: String, effect: String, effectSource: String, effectUnit: String, endTime: String, startTime: String)  = {
    // create path and map variables
    val path = "/pairs".replaceAll("\\{format\\}","json")

    val contentTypes = List("application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

    

    if(String.valueOf(cause) != "null") queryParams += "cause" -> cause.toString
    if(String.valueOf(causeSource) != "null") queryParams += "causeSource" -> causeSource.toString
    if(String.valueOf(causeUnit) != "null") queryParams += "causeUnit" -> causeUnit.toString
    if(String.valueOf(delay) != "null") queryParams += "delay" -> delay.toString
    if(String.valueOf(duration) != "null") queryParams += "duration" -> duration.toString
    if(String.valueOf(effect) != "null") queryParams += "effect" -> effect.toString
    if(String.valueOf(effectSource) != "null") queryParams += "effectSource" -> effectSource.toString
    if(String.valueOf(effectUnit) != "null") queryParams += "effectUnit" -> effectUnit.toString
    if(String.valueOf(endTime) != "null") queryParams += "endTime" -> endTime.toString
    if(String.valueOf(startTime) != "null") queryParams += "startTime" -> startTime.toString
    
    
    

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

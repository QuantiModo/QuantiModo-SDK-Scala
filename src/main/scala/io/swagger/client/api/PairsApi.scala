package io.swagger.client.api

import io.swagger.client.model.Pairs
import io.swagger.client.ApiInvoker
import io.swagger.client.ApiException

import java.io.File
import java.util.Date

import scala.collection.mutable.HashMap

class PairsApi(val defBasePath: String = "https://localhost/api",
                        defApiInvoker: ApiInvoker = ApiInvoker) {
  var basePath = defBasePath
  var apiInvoker = defApiInvoker

  def addHeader(key: String, value: String) = apiInvoker.defaultHeaders += key -> value 

  
  def pairsGet (cause: String, effect: String, duration: String, delay: String, startTime: String, endTime: String, causeSource: String, effectSource: String, causeUnit: String, effectUnit: String)  = {
    // create path and map variables
    val path = "/pairs".replaceAll("\\{format\\}","json")

    
    val contentType = {
      
      "application/json"
    }

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]

    

    if(String.valueOf(cause) != "null") queryParams += "cause" -> cause.toString
    if(String.valueOf(effect) != "null") queryParams += "effect" -> effect.toString
    if(String.valueOf(duration) != "null") queryParams += "duration" -> duration.toString
    if(String.valueOf(delay) != "null") queryParams += "delay" -> delay.toString
    if(String.valueOf(startTime) != "null") queryParams += "startTime" -> startTime.toString
    if(String.valueOf(endTime) != "null") queryParams += "endTime" -> endTime.toString
    if(String.valueOf(causeSource) != "null") queryParams += "causeSource" -> causeSource.toString
    if(String.valueOf(effectSource) != "null") queryParams += "effectSource" -> effectSource.toString
    if(String.valueOf(causeUnit) != "null") queryParams += "causeUnit" -> causeUnit.toString
    if(String.valueOf(effectUnit) != "null") queryParams += "effectUnit" -> effectUnit.toString
    
    
    

    try {
      apiInvoker.invokeApi(basePath, path, "GET", queryParams.toMap, None, headerParams.toMap, contentType) match {
        case s: String =>
           
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }
  
}

package io.swagger.client.api

import io.swagger.client.model.Correlation
import io.swagger.client.ApiInvoker
import io.swagger.client.ApiException

import java.io.File
import java.util.Date

import scala.collection.mutable.HashMap

class CorrelationsApi(val defBasePath: String = "https://localhost/api",
                        defApiInvoker: ApiInvoker = ApiInvoker) {
  var basePath = defBasePath
  var apiInvoker = defApiInvoker

  def addHeader(key: String, value: String) = apiInvoker.defaultHeaders += key -> value 

  
  def correlationsGet (effect: String, cause: String) : Option[List[Correlation]] = {
    // create path and map variables
    val path = "/correlations".replaceAll("\\{format\\}","json")

    
    val contentType = {
      
      "application/json"
    }

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]

    

    if(String.valueOf(effect) != "null") queryParams += "effect" -> effect.toString
    if(String.valueOf(cause) != "null") queryParams += "cause" -> cause.toString
    
    
    

    try {
      apiInvoker.invokeApi(basePath, path, "GET", queryParams.toMap, None, headerParams.toMap, contentType) match {
        case s: String =>
           Some(ApiInvoker.deserialize(s, "array", classOf[Correlation]).asInstanceOf[List[Correlation]])
         
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }
  
  def publicCorrelationsSearchSearchGet (search: String, effectOrCause: String) : Option[List[Correlation]] = {
    // create path and map variables
    val path = "/public/correlations/search/{search}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "search" + "\\}",apiInvoker.escape(search))

    

    
    val contentType = {
      
      "application/json"
    }

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]

    

    if(String.valueOf(effectOrCause) != "null") queryParams += "effectOrCause" -> effectOrCause.toString
    
    
    

    try {
      apiInvoker.invokeApi(basePath, path, "GET", queryParams.toMap, None, headerParams.toMap, contentType) match {
        case s: String =>
           Some(ApiInvoker.deserialize(s, "array", classOf[Correlation]).asInstanceOf[List[Correlation]])
         
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }
  
}

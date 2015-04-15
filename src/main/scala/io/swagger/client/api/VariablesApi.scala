package io.swagger.client.api

import io.swagger.client.model.Variable
import io.swagger.client.model.VariableCategory
import io.swagger.client.model.VariableUserSettings
import io.swagger.client.ApiInvoker
import io.swagger.client.ApiException

import java.io.File
import java.util.Date

import scala.collection.mutable.HashMap

class VariablesApi(val defBasePath: String = "https://localhost/api",
                        defApiInvoker: ApiInvoker = ApiInvoker) {
  var basePath = defBasePath
  var apiInvoker = defApiInvoker

  def addHeader(key: String, value: String) = apiInvoker.defaultHeaders += key -> value 

  
  def publicVariablesGet ()  = {
    // create path and map variables
    val path = "/public/variables".replaceAll("\\{format\\}","json")

    
    val contentType = {
      
      "application/json"
    }

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]

    

    
    
    

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
  
  def publicVariablesSearchSearchGet (search: String, effectOrCause: String)  = {
    // create path and map variables
    val path = "/public/variables/search/{search}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "search" + "\\}",apiInvoker.escape(search))

    

    
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
           
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }
  
  def variableCategoriesGet ()  = {
    // create path and map variables
    val path = "/variableCategories".replaceAll("\\{format\\}","json")

    
    val contentType = {
      
      "application/json"
    }

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]

    

    
    
    

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
  
  def variableUserSettingsPost (sharingData: List[VariableUserSettings])  = {
    // create path and map variables
    val path = "/variableUserSettings".replaceAll("\\{format\\}","json")

    
    val contentType = {
      if(sharingData != null && sharingData.isInstanceOf[File] )
        "multipart/form-data"
      else "application/json"
      
      
    }

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]

    

    
    
    

    try {
      apiInvoker.invokeApi(basePath, path, "POST", queryParams.toMap, sharingData, headerParams.toMap, contentType) match {
        case s: String =>
           
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }
  
  def variablesGet (userId: Integer, categoryName: String)  = {
    // create path and map variables
    val path = "/variables".replaceAll("\\{format\\}","json")

    
    val contentType = {
      
      "application/json"
    }

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]

    

    if(String.valueOf(userId) != "null") queryParams += "userId" -> userId.toString
    if(String.valueOf(categoryName) != "null") queryParams += "categoryName" -> categoryName.toString
    
    
    

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
  
  def variablesPost (variableName: List[Variable])  = {
    // create path and map variables
    val path = "/variables".replaceAll("\\{format\\}","json")

    
    val contentType = {
      if(variableName != null && variableName.isInstanceOf[File] )
        "multipart/form-data"
      else "application/json"
      
      
    }

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]

    

    
    
    

    try {
      apiInvoker.invokeApi(basePath, path, "POST", queryParams.toMap, variableName, headerParams.toMap, contentType) match {
        case s: String =>
           
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }
  
  def variablesSearchSearchGet (search: String, categoryName: String, source: String, limit: Integer, offset: Integer)  = {
    // create path and map variables
    val path = "/variables/search/{search}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "search" + "\\}",apiInvoker.escape(search))

    

    
    val contentType = {
      
      "application/json"
    }

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]

    

    if(String.valueOf(categoryName) != "null") queryParams += "categoryName" -> categoryName.toString
    if(String.valueOf(source) != "null") queryParams += "source" -> source.toString
    if(String.valueOf(limit) != "null") queryParams += "limit" -> limit.toString
    if(String.valueOf(offset) != "null") queryParams += "offset" -> offset.toString
    
    
    

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
  
  def variablesVariableNameGet (variableName: String, categoryName: String)  = {
    // create path and map variables
    val path = "/variables/{variableName}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "variableName" + "\\}",apiInvoker.escape(variableName))

    

    
    val contentType = {
      
      "application/json"
    }

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]

    

    if(String.valueOf(categoryName) != "null") queryParams += "categoryName" -> categoryName.toString
    
    
    

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

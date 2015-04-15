package io.swagger.client.api

import io.swagger.client.model.UnitCategory
import io.swagger.client.model.Unit
import io.swagger.client.ApiInvoker
import io.swagger.client.ApiException

import java.io.File
import java.util.Date

import scala.collection.mutable.HashMap

class UnitsApi(val defBasePath: String = "https://localhost/api",
                        defApiInvoker: ApiInvoker = ApiInvoker) {
  var basePath = defBasePath
  var apiInvoker = defApiInvoker

  def addHeader(key: String, value: String) = apiInvoker.defaultHeaders += key -> value 

  
  def unitCategoriesGet ()  = {
    // create path and map variables
    val path = "/unitCategories".replaceAll("\\{format\\}","json")

    
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
  
  def unitsGet (unitName: String, abbreviatedUnitName: String, categoryName: String)  = {
    // create path and map variables
    val path = "/units".replaceAll("\\{format\\}","json")

    
    val contentType = {
      
      "application/json"
    }

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]

    

    if(String.valueOf(unitName) != "null") queryParams += "unitName" -> unitName.toString
    if(String.valueOf(abbreviatedUnitName) != "null") queryParams += "abbreviatedUnitName" -> abbreviatedUnitName.toString
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
  
  def unitsVariableGet (variable: String, unitName: String, cabbreviatedUnitName: String, categoryName: String)  = {
    // create path and map variables
    val path = "/unitsVariable".replaceAll("\\{format\\}","json")

    
    val contentType = {
      
      "application/json"
    }

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]

    

    if(String.valueOf(variable) != "null") queryParams += "variable" -> variable.toString
    if(String.valueOf(unitName) != "null") queryParams += "unitName" -> unitName.toString
    if(String.valueOf(cabbreviatedUnitName) != "null") queryParams += "cabbreviatedUnitName" -> cabbreviatedUnitName.toString
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
